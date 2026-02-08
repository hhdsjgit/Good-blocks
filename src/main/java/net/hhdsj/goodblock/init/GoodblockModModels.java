
/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.client.model.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GoodblockModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelDarkLatexYufengUnified.LAYER_LOCATION, ModelDarkLatexYufengUnified::createBodyLayer);
		event.registerLayerDefinition(ModelProtoTypeMob.LAYER_LOCATION, ModelProtoTypeMob::createBodyLayer);
		event.registerLayerDefinition(ModelNoNameMob.LAYER_LOCATION, ModelNoNameMob::createBodyLayer);
		event.registerLayerDefinition(ModelLatexPurpleFoxUnified.LAYER_LOCATION, ModelLatexPurpleFoxUnified::createBodyLayer);

		event.registerLayerDefinition(ModelLatexOrangeFox.LAYER_LOCATION, ModelLatexOrangeFox::createBodyLayer);
		event.registerLayerDefinition(Modelbluedragon.LAYER_LOCATION, Modelbluedragon::createBodyLayer);
		event.registerLayerDefinition(ModelLatexKcahraShark.LAYER_LOCATION, ModelLatexKcahraShark::createBodyLayer);
		event.registerLayerDefinition(ModelLatexicedragon.LAYER_LOCATION, ModelLatexicedragon::createBodyLayer);
		event.registerLayerDefinition(DarkfuLatexWolfMale.LAYER_LOCATION, DarkfuLatexWolfMale::createBodyLayer);
		event.registerLayerDefinition(ModelInksuger.LAYER_LOCATION, ModelInksuger::createBodyLayer);
		event.registerLayerDefinition(ModelIceFieldWolfDragon.LAYER_LOCATION, ModelIceFieldWolfDragon::createBodyLayer);
		event.registerLayerDefinition(Modelwhitebluepup.LAYER_LOCATION, Modelwhitebluepup::createBodyLayer);
		event.registerLayerDefinition(Modelblackpupmale.LAYER_LOCATION, Modelblackpupmale::createBodyLayer);
		event.registerLayerDefinition(ModelLatexpurplewswolf.LAYER_LOCATION, ModelLatexpurplewswolf::createBodyLayer);
		event.registerLayerDefinition(Modellatexyunxqhotdragon.LAYER_LOCATION, Modellatexyunxqhotdragon::createBodyLayer);
		event.registerLayerDefinition(ModelLatexthreemonthwolf.LAYER_LOCATION, ModelLatexthreemonthwolf::createBodyLayer);
		event.registerLayerDefinition(ModelLatexDragonFruitWolf.LAYER_LOCATION, ModelLatexDragonFruitWolf::createBodyLayer);
		event.registerLayerDefinition(ModelLatexYunQiIceDragon.LAYER_LOCATION, ModelLatexYunQiIceDragon::createBodyLayer);
		event.registerLayerDefinition(ModelLatexiceredDragonUnified_bw.LAYER_LOCATION, ModelLatexiceredDragonUnified_bw::createBodyLayer);
		event.registerLayerDefinition(ModelLatexRadiationFox.LAYER_LOCATION, ModelLatexRadiationFox::createBodyLayer);
		event.registerLayerDefinition(ModelLatexPurpleCoocWolf.LAYER_LOCATION, ModelLatexPurpleCoocWolf::createBodyLayer);
	}
}
