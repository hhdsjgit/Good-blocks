
package net.hhdsj.goodblock.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class SlowinfectionMobEffect extends MobEffect {
	public SlowinfectionMobEffect() {
		super(MobEffectCategory.NEUTRAL, -65281);
	}

	@Override
	public String getDescriptionId() {
		return "effect.goodblock.slowinfection";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
