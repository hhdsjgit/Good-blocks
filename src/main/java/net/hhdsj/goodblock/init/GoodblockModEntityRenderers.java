
/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.client.renderer.*;
import net.hhdsj.goodblock.client.renderer.boss.LatexNightOwlBossRenderer;
import net.hhdsj.goodblock.client.renderer.boss.LatexNightOwlRenderer;
import net.hhdsj.goodblock.entity.boss.LatexNightOwlBossEntity;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GoodblockModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(GoodblockModEntities.LATEX_ORANGE_FOX.get(), LatexOrangeFoxRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_KCAHRA_SHARK.get(), LatexKcahraSharkRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.DARKFU_LATEX_WOLF_MALE.get(), DarkfuLatexWolfMaleRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXICE_DRAGON.get(), LatexiceDragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.INKSUGER.get(), InksugerRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.BLACKPUPMALE.get(), BlackpupmaleRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.WHITEBLUEPUP.get(), WhitebluepupRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXPURPLEWSWOLF.get(), LatexpurplewswolfRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXTHREEMONTHWOLF.get(), LatexthreemonthwolfRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXYUNXQHOTDRAGON.get(), LatexyunxqhotdragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXYUNXQICEDRAGON.get(), LatexyunxqicedragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXBLUEDRAGON.get(), LatexbluedragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEX_ICE_FIELD_WOLF_DRAGON.get(), LatexIceFieldWolfDragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXDRAGONFRUITWOLF.get(), LatexDragonFruitWolfRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXPRTPLECOOCWOLF.get(), LatexPurpleCoocWolfRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXTHREEMONTHWOLF_PROJECTILE.get(), LatexArrowRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXYUNQIICEDRAGON.get(), LatexYunQiIceDragonRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXRADIATIONFOX.get(), LatexRadiationFoxRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXNIGHTOWLDRAGONBOSS.get(), LatexNightOwlBossRenderer::new);
		event.registerEntityRenderer(GoodblockModEntities.LATEXNIGHTOWLDRAGON.get(), LatexNightOwlRenderer::new);
	}
}
