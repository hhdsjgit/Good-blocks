package net.hhdsj.goodblock.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class LatexthreemonthwolfZhanDouShiTiTiaoJianProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (6 > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
			return true;
		}
		return false;
	}
}
