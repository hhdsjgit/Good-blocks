package net.hhdsj.goodblock.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class DIEProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null) return;

		ResourceKey<DamageType> customDamageType = ResourceKey.create(
				Registries.DAMAGE_TYPE,
				new ResourceLocation("goodblock", "furry_cat_kill")
		);

		var damageType = world.registryAccess()
				.registryOrThrow(Registries.DAMAGE_TYPE)
				.getHolderOrThrow(customDamageType);

		entity.hurt(new DamageSource(damageType), 80);
	}
}