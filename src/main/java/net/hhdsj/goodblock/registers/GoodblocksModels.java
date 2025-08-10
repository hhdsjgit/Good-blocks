package net.hhdsj.goodblock.registers;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.hhdsj.goodblock.client.model.ModelLatexOrangeFox;
import net.hhdsj.goodblock.client.model.ModelgreendragonUnified;
import net.hhdsj.goodblock.client.model.ModelLatexKcahraShark;
import net.hhdsj.goodblock.client.model.ModelLatexicedragon;
import net.hhdsj.goodblock.client.model.DarkfuLatexWolfMale;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GoodblocksModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelLatexOrangeFox.LAYER_LOCATION, ModelLatexOrangeFox::createBodyLayer);
		event.registerLayerDefinition(ModelgreendragonUnified.LAYER_LOCATION, ModelgreendragonUnified::createBodyLayer);
		event.registerLayerDefinition(ModelLatexKcahraShark.LAYER_LOCATION, ModelLatexKcahraShark::createBodyLayer);
		event.registerLayerDefinition(ModelLatexicedragon.LAYER_LOCATION, ModelLatexicedragon::createBodyLayer);
		event.registerLayerDefinition(DarkfuLatexWolfMale.LAYER_LOCATION, DarkfuLatexWolfMale::createBodyLayer);
	}
}
