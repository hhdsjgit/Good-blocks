/*
 *
 *   MCR MAKE
 *
 */
package net.hhdsj.goodblock.potion;

import net.hhdsj.goodblock.potion.procedures.LatexSlowInfectionMobProcedure;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class SlowinfectionMobEffect extends MobEffect {
	public SlowinfectionMobEffect() {
		super(MobEffectCategory.NEUTRAL, -65281);
	}

	@Override
	public String getDescriptionId() {
		return "effect.goodblock.slowinfection";
	}

	//调用LatexSlowInfectionMobProcedure
	@Override
	public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
		LatexSlowInfectionMobProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
