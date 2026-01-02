
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import org.checkerframework.checker.units.qual.A;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.hhdsj.goodblock.fluid.TESTGBKFluid;
import net.hhdsj.goodblock.fluid.FluidhottestFluid;
import net.hhdsj.goodblock.fluid.AFluid;
import net.hhdsj.goodblock.GoodblockMod;

public class GoodblockModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, GoodblockMod.MODID);
	public static final RegistryObject<Fluid> TESTGBK = REGISTRY.register("testgbk", () -> new TESTGBKFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_TESTGBK = REGISTRY.register("flowing_testgbk", () -> new TESTGBKFluid.Flowing());
	public static final RegistryObject<Fluid> A = REGISTRY.register("a", () -> new AFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_A = REGISTRY.register("flowing_a", () -> new AFluid.Flowing());
	public static final RegistryObject<Fluid> FLUIDHOTTEST = REGISTRY.register("fluidhottest", () -> new FluidhottestFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_FLUIDHOTTEST = REGISTRY.register("flowing_fluidhottest", () -> new FluidhottestFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(TESTGBK.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_TESTGBK.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(A.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_A.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLUIDHOTTEST.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_FLUIDHOTTEST.get(), renderType -> renderType == RenderType.translucent());
		}
	}
}
