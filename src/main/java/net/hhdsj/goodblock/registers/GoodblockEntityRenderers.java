
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.registers;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.hhdsj.goodblock.client.renderer.LatexkamonaHSguydragonwolfRenderer;
import net.hhdsj.goodblock.registers.GoodblockEntities;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.hhdsj.goodblock.entity.LatexthreemonthwolfEntityProjectile;
import net.hhdsj.goodblock.registers.GoodblockEntities;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.hhdsj.goodblock.client.renderer.WhitebluepupRenderer;
import net.hhdsj.goodblock.client.renderer.LatexthreemonthwolfRenderer;
import net.hhdsj.goodblock.client.renderer.LatexpurplewswolfRenderer;
import net.hhdsj.goodblock.client.renderer.LatexiceDragonRenderer;
import net.hhdsj.goodblock.client.renderer.LatexgreendragonRenderer;
import net.hhdsj.goodblock.client.renderer.LatexOrangeFoxRenderer;
import net.hhdsj.goodblock.client.renderer.LatexKcahraSharkRenderer;
import net.hhdsj.goodblock.client.renderer.InksugerRenderer;
import net.hhdsj.goodblock.client.renderer.DarkfuLatexWolfMaleRenderer;
import net.hhdsj.goodblock.client.renderer.BlackpupmaleRenderer;
import net.hhdsj.goodblock.client.renderer.LatexArrowRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GoodblockEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(GoodblockEntities.LATEXKAMONA_H_SGUYDRAGONWOLF.get(), LatexkamonaHSguydragonwolfRenderer::new);
		
		event.registerEntityRenderer(GoodblockEntities.LATEXTHREEMONTHWOLF_PROJECTILE.get(), LatexArrowRenderer::new);
	}
}
