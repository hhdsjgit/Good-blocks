package net.hhdsj.goodblock.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.hhdsj.goodblock.init.GoodblockModMobEffects;

public class GuihotpaXianShiYouXiNeiDieJiaCengProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(GoodblockModMobEffects.LATEXHOTPAR.get()) : false) {
			return true;
		}
		return false;
	}
}
