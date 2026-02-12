
/*
 * 这些为注册类,请将注册写在这里,而不是其它地方!
 * 				液体类
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

import net.hhdsj.goodblock.fluid.FluidhottestFluid;
import net.hhdsj.goodblock.GoodblockMod;

public class GoodblockModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, GoodblockMod.MODID);
	public static final RegistryObject<Fluid> FLUIDHOTTEST = REGISTRY.register("fluidhottest", FluidhottestFluid.Source::new);
	public static final RegistryObject<Fluid> FLOWING_FLUIDHOTTEST = REGISTRY.register("flowing_fluidhottest", FluidhottestFluid.Flowing::new);

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(FLUIDHOTTEST.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_FLUIDHOTTEST.get(), RenderType.translucent());
		}
	}
}
