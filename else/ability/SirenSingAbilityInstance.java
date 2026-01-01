package net.ltxprogrammer.changed.ability;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.effect.Shock;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedSounds;
import net.ltxprogrammer.changed.init.ChangedTags;
import net.ltxprogrammer.changed.util.CameraUtil;
import net.ltxprogrammer.changed.util.EntityUtil;
import net.ltxprogrammer.changed.util.LevelUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Random;

public class SirenSingAbilityInstance extends AbstractAbilityInstance {
    private int lastSingTick = 0;

    public SirenSingAbilityInstance(AbstractAbility<?> ability, IAbstractChangedEntity entity) {
        super(ability, entity);
    }

    @Override
    public boolean canUse() {
        return this.entity.getEntity().isEyeInFluidType(ForgeMod.EMPTY_TYPE.get());
    }

    @Override
    public boolean canKeepUsing() {
        return lastSingTick >= entity.getEntity().tickCount && this.canUse();
    }

    @Override
    public void startUsing() {
        final var self = entity.getEntity();
        self.playSound(ChangedSounds.SIREN.get(), 1, 1);
        lastSingTick = entity.getEntity().tickCount + (8 * 20) + 10;
    }

    public void applyEffect(@Nullable LivingEntity target, float scale) {
        if (scale <= 0f)
            return;
        if (target == null)
            return;
        if (target instanceof Player && !Changed.config.server.playerControllingAbilities.get())
            return;

        //Shock.setNoControlTicks(target, 5);
        Random random = new Random(target.getId() + ((target.getId() + target.tickCount) / 40));
        Vec3 xzDir = (new Vec3(random.nextDouble(-1, 1), 0, random.nextDouble(-1, 1))).normalize();

        CameraUtil.tugEntityLookDirection(target, xzDir, 0.125 * scale);

        if (!target.onGround())
            return;
        final double moveScale = (target.getSpeed() * 0.8 * (target instanceof Player ? 10.0 : 1.0)) * scale;
        target.travel(xzDir.multiply(moveScale, 0, moveScale));
    }

    protected float computeEffectScale(@NotNull LivingEntity target) {
        if (target instanceof Player && !Changed.config.server.playerControllingAbilities.get())
            return 0f;

        float effectScale = 1f;

        final var level = this.entity.getLevel();
        boolean worldOcclusion = LevelUtil.getBlocksInLine(EntityUtil.getEyeBlock(this.entity.getEntity()), EntityUtil.getEyeBlock(target), 0.25f)
                .anyMatch(blockPos -> {
                    return level.getBlockState(blockPos).isCollisionShapeFullBlock(level, blockPos);
                });

        if (worldOcclusion)
            effectScale *= 0.25f;

        effectScale *= Mth.map(this.entity.getEntity().distanceTo(target), 0, 8, 1.0f, 0.6f);

        return effectScale;
    }

    protected boolean shouldAffectEntity(@NotNull LivingEntity livingEntity) {
        if (TransfurVariant.getEntityVariant(livingEntity) != null)
            return false;

        return livingEntity.getType().is(ChangedTags.EntityTypes.HUMANOIDS);
    }

    @Override
    public void tick() {
        var self = entity.getEntity();
        var level = entity.getLevel();

        self.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 1, false, false, false));

        level.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT, self,
                new AABB(self.blockPosition()).inflate(8)).forEach(livingEntity -> {
            if (!this.shouldAffectEntity(livingEntity))
                return;

            if (self instanceof ChangedEntity && livingEntity instanceof Player player) {
                float scale = this.computeEffectScale(player);
                if (scale > 0) {
                    var tag = new CompoundTag();
                    tag.putUUID("id", player.getUUID());
                    tag.putFloat("effectScale", scale);
                    this.sendPayload(tag, player);
                }
            } else {
                applyEffect(livingEntity, this.computeEffectScale(livingEntity));
            }
        });
    }

    @Override
    public void acceptPayload(CompoundTag tag) {
        super.acceptPayload(tag);
        applyEffect(this.entity.getLevel().getPlayerByUUID(tag.getUUID("id")), tag.getFloat("effectScale"));
    }

    @Override
    public void stopUsing() {

    }
}
