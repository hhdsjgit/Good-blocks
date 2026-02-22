
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.hhdsj.goodblock.fluid.types.TESTGBKFluidType;
import net.hhdsj.goodblock.GoodblockMod;

public class GoodblockModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, GoodblockMod.MODID);
	public static final RegistryObject<FluidType> TESTGBK_TYPE = REGISTRY.register("testgbk", () -> new TESTGBKFluidType());
}
