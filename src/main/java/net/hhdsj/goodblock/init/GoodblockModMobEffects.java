
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.hhdsj.goodblock.potion.RadiationMobEffect;
import net.hhdsj.goodblock.GoodblockMod;

public class GoodblockModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GoodblockMod.MODID);
	public static final RegistryObject<MobEffect> RADIATION = REGISTRY.register("radiation", () -> new RadiationMobEffect());
}
