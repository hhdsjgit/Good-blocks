package net.hhdsj.goodblock.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.hhdsj.goodblock.init.GoodblockModMobEffects;

public class FluidhottestDangShengWuWanJiaPengZhuangFangKuaiShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(GoodblockModMobEffects.LATEXHOTPAR.get(), 230, 1));
	}
}
