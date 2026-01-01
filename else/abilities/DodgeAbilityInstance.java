package net.foxyas.changedaddon.abilities;

import com.mojang.math.Vector3f;
import net.foxyas.changedaddon.client.model.animations.parameters.DodgeAnimationParameters;
import net.foxyas.changedaddon.init.ChangedAddonAnimationEvents;
import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.AbstractAbilityInstance;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.init.ChangedAnimationEvents;
import net.ltxprogrammer.changed.init.ChangedSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import org.jetbrains.annotations.Nullable;

public class DodgeAbilityInstance extends AbstractAbilityInstance {

    private final int defaultRegenCooldown = 20;
    public boolean ultraInstinct = false; //FUNNY VARIABLE :3
    public DodgeType dodgeType = DodgeType.WEAVE;
    private int dodgeAmount = 4;
    private int maxDodgeAmount = 4;
    private boolean dodgeActive = false;
    private int dodgeRegenCooldown = defaultRegenCooldown;

    public DodgeAbilityInstance(AbstractAbility<?> ability, IAbstractChangedEntity entity) {
        super(ability, entity);
    }

    public DodgeAbilityInstance(AbstractAbility<?> ability, IAbstractChangedEntity entity, int maxDodge) {
        this(ability, entity);
        this.maxDodgeAmount = maxDodge;
        this.dodgeAmount = maxDodge;
    }

    private void dodgeAwayFromAttacker(Entity dodger, Entity attacker) {
        Vec3 motion = attacker.position().subtract(dodger.position()).scale(-0.25);
        if (dodger instanceof ServerPlayer serverPlayer) {
            serverPlayer.setDeltaMovement(motion.x, motion.y, motion.z);
            serverPlayer.connection.send(new ClientboundSetEntityMotionPacket(serverPlayer.getId(), serverPlayer.getDeltaMovement()));
        } else {
            dodger.setDeltaMovement(motion.x, motion.y, motion.z);
        }
    }


    private void applyDodgeAwayParticlesTrails(LivingEntity dodger, LivingEntity attacker) {
        Vec3 motion = attacker.getEyePosition().subtract(dodger.getEyePosition()).scale(-0.25);
        Vec3 dodgerPos = dodger.position().add(0, 0.5f, 0);

        if (dodger.getLevel() instanceof ServerLevel serverLevel) {
            int steps = 3;         // número de partículas por linha
            int lines = 5;          // quantas linhas paralelas
            float spread = 1;    // afastamento lateral das linhas

            for (int l = 0; l < lines; l++) {
                // gera um deslocamento lateral aleatório (x,z) em círculo
                Vec3 lateralOffset = new Vec3(dodger.getRandom().nextFloat(-spread, spread),
                        dodger.getRandom().nextFloat(-spread, spread),
                        dodger.getRandom().nextFloat(-spread, spread));
                if (l == 0) {
                    lateralOffset = Vec3.ZERO;
                }

                for (int s = 0; s <= steps; s++) {
                    //float t = s / (float) steps;
                    Vec3 particlePos = dodgerPos.add(lateralOffset);

                    serverLevel.sendParticles(
                            new DustParticleOptions(new Vector3f(1, 1, 1), 1),
                            particlePos.x(),
                            particlePos.y(),
                            particlePos.z(),
                            0, // count
                            motion.x, motion.y, motion.z, 1 // sem velocidade extra
                    );
                }
            }
        }
    }

    public static boolean isSpectator(Entity entity) {
        return entity instanceof Player player && player.isSpectator();
    }

    public DodgeAbilityInstance withDodgeType(DodgeType dodgeType) {
        this.dodgeType = dodgeType;
        return this;
    }

    public boolean isDodgeActive() {
        return dodgeActive || this.getController().getHoldTicks() > 0;
    }

    public void setDodgeActivate(boolean active) {
        this.dodgeActive = active;
    }

    public int getDodgeAmount() {
        return dodgeAmount;
    }

    public void setDodgeAmount(int amount) {
        dodgeAmount = Math.min(amount, maxDodgeAmount);
    }

    public void addDodgeAmount() {
        if (dodgeAmount < maxDodgeAmount) dodgeAmount++;
    }

    public void subDodgeAmount() {
        if (dodgeAmount > 0) dodgeAmount--;
    }

    public DodgeType getDodgeType() {
        return dodgeType;
    }

    public void executeDodgeEffects(LevelAccessor levelAccessor, @Nullable Entity attacker, LivingEntity dodger, @Nullable LivingAttackEvent event, boolean causeExhaustion) {
        if (!ultraInstinct) {
            this.subDodgeAmount();
        }
        if (dodger instanceof Player player) {
            if (!ultraInstinct) {
                player.displayClientMessage(new TranslatableComponent("changed_addon.ability.dodge.dodge_amount_left", this.getDodgeStaminaRatio()), false);
            } else {
                player.displayClientMessage(new TranslatableComponent("changed_addon.ability.dodge.ultra_instinct"), true);
            }
            if (causeExhaustion && !ultraInstinct) {
                player.causeFoodExhaustion(8f);
            }
        }

        if (this.getDodgeType() == DodgeType.WEAVE) {
            dodger.invulnerableTime = 20 * 3;
            dodger.hurtDuration = 20 * 3;
            dodger.hurtTime = dodger.hurtDuration;
            dodger.hurtMarked = false;
        } else if (this.getDodgeType() == DodgeType.TELEPORT) {
            dodger.hurtMarked = false;
        }

        if (event != null) {
            event.setCanceled(true);
        }
        if (this.getDodgeType() == DodgeType.WEAVE) {
            executeDodgeParticles(levelAccessor, dodger, attacker);
            executeDodgeAnimations(levelAccessor, dodger);
        }
    }

    public void executeDodgeParticles(LevelAccessor levelAccessor, LivingEntity dodger, Entity attacker) {
        if (levelAccessor instanceof ServerLevel serverLevel) {
            //spawnDodgeParticles(serverLevel, dodger, 0.5f, 0.3f, 0.3f, 0.3f, 10, 0.05f);
        }
        if (attacker instanceof LivingEntity attackerLiving) {
            applyDodgeAwayParticlesTrails(dodger, attackerLiving);
        }
    }

    public void executeDodgeAnimations(LevelAccessor levelAccessor, LivingEntity dodger) {
        ChangedSounds.broadcastSound(dodger, ChangedSounds.BOW2, 2.5f, 1);
        if (this.getDodgeType() == DodgeType.WEAVE) {
            int randomValue = levelAccessor.getRandom().nextInt(6);
            switch (randomValue) {
                case 0 ->
                        ChangedAnimationEvents.broadcastEntityAnimation(dodger, ChangedAddonAnimationEvents.DODGE_LEFT.get(), DodgeAnimationParameters.INSTANCE);
                case 1 ->
                        ChangedAnimationEvents.broadcastEntityAnimation(dodger, ChangedAddonAnimationEvents.DODGE_RIGHT.get(), DodgeAnimationParameters.INSTANCE);
                case 2 ->
                        ChangedAnimationEvents.broadcastEntityAnimation(dodger, ChangedAddonAnimationEvents.DODGE_WEAVE_LEFT.get(), DodgeAnimationParameters.INSTANCE);
                case 3 ->
                        ChangedAnimationEvents.broadcastEntityAnimation(dodger, ChangedAddonAnimationEvents.DODGE_WEAVE_RIGHT.get(), DodgeAnimationParameters.INSTANCE);
                case 4 ->
                        ChangedAnimationEvents.broadcastEntityAnimation(dodger, ChangedAddonAnimationEvents.DODGE_DOWN_LEFT.get(), DodgeAnimationParameters.INSTANCE);
                case 5 ->
                        ChangedAnimationEvents.broadcastEntityAnimation(dodger, ChangedAddonAnimationEvents.DODGE_DOWN_RIGHT.get(), DodgeAnimationParameters.INSTANCE);
                //default -> ChangedAnimationEvents.broadcastEntityAnimation(player, ChangedAddonAnimationEvents.DODGE_LEFT.get(), null);
            }
        }
    }

    public void executeDodgeEffects(LevelAccessor levelAccessor, @Nullable Entity attacker, LivingEntity dodger, @Nullable LivingAttackEvent event) {
        this.executeDodgeEffects(levelAccessor, attacker, dodger, event, true);
    }

    public void executeDodgeHandle(LevelAccessor levelAccessor, Entity attacker, LivingEntity dodger, LivingAttackEvent event, boolean causeExhaustion) {
        Vec3 attackerPos = attacker.position();
        Vec3 lookDirection = attacker.getLookAngle().normalize();
        //Vec3 dodgerLookDirection = dodger.getLookAngle();
        final double distanceBehind = 3;
        Vec3 dodgePosBehind = attackerPos.subtract(lookDirection.scale(distanceBehind));
        double distance = attacker.distanceTo(dodger);
        if (this.ultraInstinct) {
            dodgeAwayFromAttacker(dodger, attacker);
            if (event != null) {
                event.setCanceled(true);
            }
            return;
        }

        if (this.getDodgeType() == DodgeType.TELEPORT) {
            if (event != null) {
                event.setCanceled(true);
            }

            if (distance > 2f) {
                // Random offset values
                double maxDistance = 16.0; // maximum distance for teleport
                double dx = (dodger.getRandom().nextDouble() - 0.5) * 2 * maxDistance;
                double dz = (dodger.getRandom().nextDouble() - 0.5) * 2 * maxDistance;
                double dy = (dodger.getRandom().nextInt(16) - 8); // vertical offset -8 to +7

                // Calculate target position
                BlockPos targetPos = new BlockPos(dodger.getX() + dx, dodger.getY() + dy, dodger.getZ() + dz);
                if (dodger.randomTeleport(targetPos.getX(), targetPos.getY(), targetPos.getZ(), true)) {
                    // Optional: play sound & particles like Enderman
                    levelAccessor.playSound(null, dodger.blockPosition(),
                            SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
                    if (levelAccessor instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.PORTAL,
                                dodger.getX(), dodger.getY() + 0.5, dodger.getZ(),
                                20, 0.5, 1.0, 0.5, 0.1);
                    }
                }
            } else {
                if (dodger.randomTeleport(dodgePosBehind.x, dodgePosBehind.y, dodgePosBehind.z, true)) {
                    // Optional: play sound & particles like Enderman
                    levelAccessor.playSound(null, dodger.blockPosition(),
                            SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
                    if (levelAccessor instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.PORTAL,
                                dodger.getX(), dodger.getY() + 0.5, dodger.getZ(),
                                20, 0.5, 1.0, 0.5, 0.1);
                    }
                }
            }
        } else {
            dodgeAwayFromAttacker(dodger, attacker);
            if (event != null) {
                event.setCanceled(true);
            }
        }
    }

    public void executeDodgeHandle(LivingEntity dodger, Entity attacker) {
        this.executeDodgeHandle(dodger.getLevel(), attacker, dodger, null, true);
    }

    public void executeDodgeEffects(LivingEntity dodger, Entity attacker) {
        this.executeDodgeEffects(dodger.getLevel(), attacker, dodger, null);
    }

    private void spawnDodgeParticles(ServerLevel level, Entity entity, float middle, float xV, float yV, float zV, int count, float speed) {
        level.sendParticles(ParticleTypes.POOF,
                entity.getX(), entity.getY() + middle, entity.getZ(), count, xV, yV, zV, speed);
    }

    public int getMaxDodgeAmount() {
        return maxDodgeAmount;
    }

    public void setMaxDodgeAmount(int max) {
        maxDodgeAmount = max;
        dodgeAmount = Math.min(dodgeAmount, max); // Adjust current amount if needed
    }

    public float getDodgeStaminaRatio() {
        return ((float) dodgeAmount / maxDodgeAmount) * 100f;
    }

    public void setUltraInstinct(boolean ultraInstinct) {
        if (ultraInstinct) {
            if (this.entity.getEntity() instanceof Player player) {
                player.displayClientMessage(new TranslatableComponent("changed_addon.ability.dodge.ultra_instinct.activated"), false);
            }
        }
        this.ultraInstinct = ultraInstinct;
    }

    @Override
    public boolean canUse() {
        if (ultraInstinct) {
            return true;
        }
        return dodgeAmount > 0 && !isSpectator(entity.getEntity());
    }

    @Override
    public boolean canKeepUsing() {
        if (ultraInstinct) {
            return true;
        }
        return dodgeAmount > 0 && !isSpectator(entity.getEntity());
    }

    @Override
    public void startUsing() {
        if (entity.getEntity() instanceof Player player && this.getController().getHoldTicks() == 0) {
            if (!(player.getLevel().isClientSide())) {
                if (!ultraInstinct) {
                    player.displayClientMessage(
                            new TranslatableComponent("changed_addon.ability.dodge.dodge_amount", getDodgeStaminaRatio()),
                            true
                    );
                }
            }
        }
    }

    @Override
    public void tick() {
        //super.tick();
        if (entity.getEntity() instanceof Player player) {
            if (!(player.getLevel().isClientSide())) {
                if (!ultraInstinct) {
                    player.displayClientMessage(
                            new TranslatableComponent("changed_addon.ability.dodge.dodge_amount", getDodgeStaminaRatio()), true);
                }
            }
        }
        setDodgeActivate(canUse());
    }

    @Override
    public void stopUsing() {
        setDodgeActivate(false);
    }

    @Override
    public void tickIdle() {
        super.tickIdle();
        if (ultraInstinct) {
            this.setDodgeActivate(true);
        }
        boolean nonHurtFrame = entity.getEntity().hurtTime <= 10 && entity.getEntity().invulnerableTime <= 10;
        if (nonHurtFrame && !isDodgeActive() && dodgeAmount < maxDodgeAmount) {
            if (dodgeRegenCooldown <= 0) {
                addDodgeAmount();
                dodgeRegenCooldown = 5;

                if (entity.getEntity() instanceof Player player) {
                    if (!(player.getLevel().isClientSide())) {
                        if (!ultraInstinct) {
                            player.displayClientMessage(
                                    new TranslatableComponent("changed_addon.ability.dodge.dodge_amount",
                                            getDodgeStaminaRatio()),
                                    true
                            );
                        } else {
                            player.displayClientMessage(new TranslatableComponent("changed_addon.ability.dodge.ultra_instinct"),
                                    true);
                        }
                    }
                }
            } else {
                dodgeRegenCooldown--;
            }
        }
    }

    @Override
    public void readData(CompoundTag tag) {
        super.readData(tag);
        if (tag.contains("DodgeAmount")) dodgeAmount = tag.getInt("DodgeAmount");
        if (tag.contains("MaxDodgeAmount")) maxDodgeAmount = tag.getInt("MaxDodgeAmount");
        if (tag.contains("DodgeRegenCooldown")) dodgeRegenCooldown = tag.getInt("DodgeRegenCooldown");
        if (tag.contains("DodgeActivate")) dodgeActive = tag.getBoolean("DodgeActivate");
        if (tag.contains("ultraInstinct")) ultraInstinct = tag.getBoolean("ultraInstinct");

    }

    @Override
    public void saveData(CompoundTag tag) {
        super.saveData(tag);
        tag.putInt("DodgeAmount", dodgeAmount);
        tag.putInt("MaxDodgeAmount", maxDodgeAmount);
        tag.putInt("DodgeRegenCooldown", dodgeRegenCooldown);
        tag.putBoolean("DodgeActivate", dodgeActive);
        tag.putBoolean("ultraInstinct", ultraInstinct);
    }

    public enum DodgeType {
        TELEPORT(),
        WEAVE();

        DodgeType() {
        }

    }
}
