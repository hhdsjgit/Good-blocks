package net.hhdsj.goodblock.client.gui;

import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;

import net.hhdsj.goodblock.procedures.GuihotpaXianShiYouXiNeiDieJiaCengProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GuihotpaOverlay {

	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void eventHandler(RenderGuiOverlayEvent.Pre event) {
		// 1.20.1 使用 VanillaGuiOverlay 来判断
		if (event.getOverlay().id().equals(VanillaGuiOverlay.CROSSHAIR.id())) {
			Minecraft mc = Minecraft.getInstance();
			Player entity = mc.player;

			if (entity != null && GuihotpaXianShiYouXiNeiDieJiaCengProcedure.execute(entity)) {
				int w = mc.getWindow().getGuiScaledWidth();
				int h = mc.getWindow().getGuiScaledHeight();

				// 获取 GuiGraphics 对象
				GuiGraphics guiGraphics = event.getGuiGraphics();

				// 保存渲染状态
				RenderSystem.disableDepthTest();
				RenderSystem.depthMask(false);
				RenderSystem.enableBlend();
				RenderSystem.setShader(GameRenderer::getPositionTexShader);
				RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
						GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
						GlStateManager.SourceFactor.ONE,
						GlStateManager.DestFactor.ZERO);
				RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.4F);

				// 设置纹理
				RenderSystem.setShaderTexture(0, new ResourceLocation("goodblock:textures/screens/goo_outline.png"));

				// 使用 GuiGraphics 的 blit 方法
				guiGraphics.blit(new ResourceLocation("goodblock:textures/screens/goo_outline.png"),
						0, 0, 0, 0, w, h, w, h);

				// 恢复渲染状态
				RenderSystem.depthMask(true);
				RenderSystem.defaultBlendFunc();
				RenderSystem.enableDepthTest();
				RenderSystem.disableBlend();
				RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
}