
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.hhdsj.goodblock.client.renderer.LatexiceDragonRenderer;
import net.hhdsj.goodblock.client.renderer.LatexgreendragonRenderer;
import net.hhdsj.goodblock.client.renderer.LatexfoxRenderer;
import net.hhdsj.goodblock.client.renderer.LatexOrangeFoxRenderer;
import net.hhdsj.goodblock.client.renderer.LatexKcahraSharkRenderer;
import net.hhdsj.goodblock.client.renderer.DarkfuLatexWolfMaleRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GoodblockModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(GoodblockModEntities.LATEXFOX.get(), LatexfoxRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_ORANGE_FOX.get(), LatexOrangeFoxRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_KCAHRA_SHARK.get(), LatexKcahraSharkRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXGREENDRAGON.get(), LatexgreendragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.DARKFU_LATEX_WOLF_MALE.get(), DarkfuLatexWolfMaleRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXICE_DRAGON.get(), LatexiceDragonRenderer::new);
	}
}
