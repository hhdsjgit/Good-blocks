package net.hhdsj.goodblock.procedures;

import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class RadiationZaiXiaoGuoChiXuShiMeiKeFaShengProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(DamageTypes.ON_FIRE), 1);
	}
}
