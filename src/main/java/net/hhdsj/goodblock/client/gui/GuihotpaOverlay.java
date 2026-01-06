
package net.hhdsj.goodblock.client.gui;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.Minecraft;

import net.hhdsj.goodblock.procedures.GuihotpaXianShiYouXiNeiDieJiaCengProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class GuihotpaOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void eventHandler(ScreenEvent.DrawScreenEvent.Post event) {
		if (event.getScreen() instanceof PauseScreen) {
			int w = event.getScreen().width;
			int h = event.getScreen().height;
			int posX = w / 2;
			int posY = h / 2;
			Level world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.level;
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
			}
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);
			if (GuihotpaXianShiYouXiNeiDieJiaCengProcedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("goodblock:textures/screens/hot_png.png"));
				Minecraft.getInstance().gui.blit(event.getPoseStack(), 0, 0, 0, 0, w, h, w, h);
				Minecraft.getInstance().font.draw(event.getPoseStack(), new TranslatableComponent("gui.goodblock.guihotpa.label_test_gui"), posX + -180, posY + -94, -1);
			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
