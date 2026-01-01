
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.registers;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.hhdsj.goodblock.client.renderer.LatexkamonaHSguydragonwolfRenderer;
import net.hhdsj.goodblock.client.renderer.LatexArrowRenderer;
import net.hhdsj.goodblock.client.renderer.LatexDragonFruitWolfRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GoodblockEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(GoodblockEntities.LATEX_KAMONA_HSGUY_DRAGON_WOLF.get(), LatexkamonaHSguydragonwolfRenderer::new);
		event.registerEntityRenderer(GoodblockEntities.LATEXDRAGONFRUITWOLF.get(), LatexDragonFruitWolfRenderer::new);
		event.registerEntityRenderer(GoodblockEntities.LATEXTHREEMONTHWOLF_PROJECTILE.get(), LatexArrowRenderer::new);
	}
}
