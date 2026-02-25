package net.hhdsj.goodblock.entity.boss;

import net.foxyas.changedaddon.effect.particles.ThunderSparkOption;
import net.foxyas.changedaddon.init.ChangedAddonParticleTypes;
import net.hhdsj.goodblock.entity.LatexthreemonthwolfEntityProjectile;
import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.LatexType;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.init.ChangedAttributes;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class LatexNightOwlBossEntity extends ChangedEntity{

    public LatexNightOwlBossEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(GoodblockModEntities.LATEXNIGHTOWLDRAGONBOSS.get(), world);
    }

    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        attributes.getInstance(Attributes.MOVEMENT_SPEED).setBaseValue(1.2);
        attributes.getInstance(ForgeMod.SWIM_SPEED.get()).setBaseValue(1.1);
        attributes.getInstance(Attributes.MAX_HEALTH).setBaseValue(100.0);
    }

    @Override
    public @NotNull Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public LatexType getLatexType() {
        return LatexType.NEUTRAL;
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.REPLICATION;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (source == DamageSource.FALL)
            return false;
        if (source == DamageSource.ON_FIRE)
            return false;
        return super.hurt(source, amount);
    }

    public LatexNightOwlBossEntity(EntityType<LatexNightOwlBossEntity> type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(false);
        this.bossEvent = new ServerBossEvent(
                new TranslatableComponent("entity.goodblock.boss_heath.night_owl"), // 或者用
                BossEvent.BossBarColor.RED,
                BossEvent.BossBarOverlay.NOTCHED_10 // 进度条样式
        );
        // 默认设置为可见
        this.bossEvent.setVisible(true);
    }

    @Override
    public void tick() {
        super.tick();
        // 更新血条进度
        if (!this.level.isClientSide) {
            float healthPercent = this.getHealth() / this.getMaxHealth();
            this.bossEvent.setProgress(healthPercent);
        }
    }

    @Override
    public void startSeenByPlayer(@NotNull ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(@NotNull ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (this.getHealth() < this.getMaxHealth() * 0.3) {
            this.bossEvent.setName(
                    new TranslatableComponent("entity.goodblock.boss_heath.night_owl")
                            .withStyle(ChatFormatting.RED)
            );
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ServerPlayer.class, true, true));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new FloatGoal(this));

        // 添加远程技能目标
        this.goalSelector.addGoal(1, new Goal() {
            @Override
            public boolean canUse() {
                LivingEntity target = LatexNightOwlBossEntity.this.getTarget();
                if (target == null) return false;

                double distance = LatexNightOwlBossEntity.this.distanceTo(target);
                return distance >= 15;
            }

            @Override
            public void start() {
                LivingEntity target = LatexNightOwlBossEntity.this.getTarget();
                if (target == null) return;

                double distance = LatexNightOwlBossEntity.this.distanceTo(target);

                if (distance >= 15) {
                    int randomIntBound = LatexNightOwlBossEntity.this.random.nextInt(20); // 0-20之间的随机整数
                    if (randomIntBound >= 10) {
                        double oldX = LatexNightOwlBossEntity.this.getX();
                        double oldY = LatexNightOwlBossEntity.this.getY();
                        double oldZ = LatexNightOwlBossEntity.this.getZ();
                        if (LatexNightOwlBossEntity.this.level instanceof ServerLevel serverLevel) {
                            serverLevel.sendParticles(
                                    ParticleTypes.SMOKE,
                                    oldX,
                                    oldY + 1,
                                    oldZ,
                                    50,
                                    1, 1, 1,
                                    0.3
                            );
                        }
                        LatexNightOwlBossEntity.this.teleportTo(target.getX(), target.getY(), target.getZ());
                        if (LatexNightOwlBossEntity.this.level instanceof ServerLevel serverLevel) {
                            serverLevel.sendParticles(
                                    ParticleTypes.LAVA,
                                    target.getX(),
                                    target.getY() + target.getBbHeight() / 2,
                                    target.getZ(),
                                    100,
                                    5, 5, 5,
                                    0.5
                            );
                        }
                    } else {
                        target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30, 1));
                        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 2));
                    }
                }
            }
        });
    }

    @Override
    public boolean doHurtTarget(@NotNull Entity target) {
        // 先执行原版的近战攻击逻辑
        boolean hurt = super.doHurtTarget(target);

        if (hurt && target instanceof LivingEntity livingTarget) {
            // 添加击退效果
            double knockback = 0.5;
            livingTarget.setDeltaMovement(
                    livingTarget.getDeltaMovement().add(
                            Math.sin(this.getYRot() * Math.PI / 180.0) * knockback,
                            0.5,
                            -Math.cos(this.getYRot() * Math.PI / 180.0) * knockback
                    )
            );

            // 添加粒子效果
            if (this.level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(
                        ParticleTypes.FLAME,                    // 火焰粒子
                        target.getX(),                           // 目标X坐标（改为目标位置）
                        target.getY() + target.getBbHeight() / 2, // 目标中心高度
                        target.getZ(),                           // 目标Z坐标
                        100,                                      // 粒子数量（减少一些）
                        3, 3, 3,                           // 扩散范围
                        0.5                                      // 粒子速度
                );

                // 添加攻击特效粒子（横扫粒子）
                serverLevel.sendParticles(
                        ParticleTypes.SWEEP_ATTACK,
                        target.getX(),
                        target.getY() + target.getBbHeight() / 2,
                        target.getZ(),
                        1,
                        0, 0, 0,
                        0
                );

                SimpleParticleType solventParticle = (SimpleParticleType) ChangedAddonParticleTypes.SOLVENT_PARTICLE.get();

                serverLevel.sendParticles(
                        solventParticle,
                        this.getX(),
                        this.getY() + this.getEyeHeight(),
                        this.getZ(),
                        100,  // 生成20个粒子
                        0.5, 0.5, 0.5,
                        0.2
                );
            }

            // 添加效果
            livingTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 1));
            livingTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 10, 1));
            livingTarget.addEffect(new MobEffectInstance(MobEffects.GLOWING, 30, 1));


        }

        return hurt;
    }

    @Override
    public void remove(RemovalReason reason) {
        this.bossEvent.setVisible(false);
        super.remove(reason);
    }

    public static void init() {
    }

    private final ServerBossEvent bossEvent;

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(ChangedAttributes.TRANSFUR_DAMAGE.get(), 1);
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.JUMP_STRENGTH, 1.5);
        builder = builder.add(Attributes.MAX_HEALTH, 100);
        builder = builder.add(Attributes.ARMOR, 10);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
        builder = builder.add(Attributes.FOLLOW_RANGE, 32);
        return builder;
    }
}
