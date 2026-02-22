
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

import net.hhdsj.goodblock.GoodblockMod;

public class GoodblockModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, GoodblockMod.MODID);
	public static final RegistryObject<PaintingVariant> HOME = REGISTRY.register("home", () -> new PaintingVariant(64, 64));
	public static final RegistryObject<PaintingVariant> CITYOLD = REGISTRY.register("cityold", () -> new PaintingVariant(32, 32));
	public static final RegistryObject<PaintingVariant> PAINTINKSUGER = REGISTRY.register("paintinksuger", () -> new PaintingVariant(32, 32));
}
