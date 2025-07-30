
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.hhdsj.goodblock.client.renderer.LatextestRenderer;
import net.hhdsj.goodblock.client.renderer.LatexfoxRenderer;
import net.hhdsj.goodblock.client.renderer.LatexOrangeFoxRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GoodblockModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(GoodblockModEntities.LATEXTEST.get(), LatextestRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXFOX.get(), LatexfoxRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_ORANGE_FOX.get(), LatexOrangeFoxRenderer::new);
	}
}
