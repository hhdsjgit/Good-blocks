package net.foxyas.changedaddon.abilities;

import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import java.util.function.Consumer;

public class PassiveAbility extends AbstractAbility<PassiveAbilityInstance> {
    public final Consumer<IAbstractChangedEntity> passiveAction;

    public PassiveAbility(Consumer<IAbstractChangedEntity> passiveAction) {
        super(PassiveAbilityInstance::new);
        this.passiveAction = passiveAction;
    }

    public static void ApplyMobEffect(IAbstractChangedEntity entity, MobEffectInstance mobEffectInstance) {
        if (entity.getLevel().isClientSide()) return;

        LivingEntity livingEntity = entity.getEntity();
        MobEffect mobEffect = mobEffectInstance.getEffect();
        if (mobEffect == MobEffects.REGENERATION && !livingEntity.hasEffect(MobEffects.REGENERATION)) {
            livingEntity.addEffect(mobEffectInstance);
        } else if (mobEffect != MobEffects.REGENERATION) {
            livingEntity.addEffect(mobEffectInstance);
        }
    }

    @Override
    public UseType getUseType(IAbstractChangedEntity entity) {
        return UseType.MENU;
    }

    @Override
    public int getCoolDown(IAbstractChangedEntity entity) {
        return 5;
    }

    @Override
    public void startUsing(IAbstractChangedEntity entity) {
        super.startUsing(entity);
    }
}
