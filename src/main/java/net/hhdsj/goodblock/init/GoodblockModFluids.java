
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

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
import net.hhdsj.goodblock.GoodblockMod;

public class GoodblockModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, GoodblockMod.MODID);
	public static final RegistryObject<Fluid> TESTGBK = REGISTRY.register("testgbk", () -> new TESTGBKFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_TESTGBK = REGISTRY.register("flowing_testgbk", () -> new TESTGBKFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(TESTGBK.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_TESTGBK.get(), renderType -> renderType == RenderType.translucent());
		}
	}
}
