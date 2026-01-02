
package net.hhdsj.goodblock.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class LatexhotparMobEffect extends MobEffect {
	public LatexhotparMobEffect() {
		super(MobEffectCategory.HARMFUL, -52480);
	}

	@Override
	public String getDescriptionId() {
		return "effect.goodblock.latexhotpar";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
