
package net.hhdsj.goodblock.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.hhdsj.goodblock.procedures.RadiationProcedure;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.NotNull;

public class RadiationMobEffect extends MobEffect {
	public RadiationMobEffect() {
		super(MobEffectCategory.HARMFUL, -256);
	}

	@Override
	public @NotNull String getDescriptionId() {
		return "effect.goodblock.radiation";
	}

	@Override
	public void applyEffectTick( LivingEntity entity, int amplifier) {
		LevelAccessor world = entity.level();
		RadiationProcedure.execute(world,entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
