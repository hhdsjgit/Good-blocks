package net.hhdsj.goodblock.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.hhdsj.goodblock.GoodblockMod;

public class DIEProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.hurt(new DamageSource((entity.getDisplayName().getString() + "Killed by order")).bypassArmor(), 80);
		GoodblockMod.LOGGER.warn("The function cannot be called, and the permissions are insufficient");
		GoodblockMod.LOGGER.warn((entity.getDisplayName().getString()));
	}
}
