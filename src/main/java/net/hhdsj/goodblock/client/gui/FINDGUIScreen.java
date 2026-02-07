
package net.hhdsj.goodblock.client.gui;

import net.minecraft.client.gui.GuiComponent;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.hhdsj.goodblock.world.inventory.FINDGUIMenu;
import net.hhdsj.goodblock.network.FINDGUIButtonMessage;
import net.hhdsj.goodblock.GoodblockMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class FINDGUIScreen extends AbstractContainerScreen<FINDGUIMenu> {
	private final static HashMap<String, Object> guistate = FINDGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox GUI_A;
	Button button_dian_wo;

	public FINDGUIScreen(FINDGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("goodblock:textures/screens/findgui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.goodblock.findgui.label_goodblock_06_beta"), 5, 5, -16724992);
		this.font.draw(poseStack, new TranslatableComponent("gui.goodblock.findgui.label_make_hhdsj2"), 5, 18, -16777012);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_dian_wo = new Button(this.leftPos + 5, this.topPos + 138, 35, 20, new TranslatableComponent("gui.goodblock.findgui.button_dian_wo"), e -> {
			if (true) {
				GoodblockMod.PACKET_HANDLER.sendToServer(new FINDGUIButtonMessage(0, x, y, z));
				FINDGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_dian_wo", button_dian_wo);
		this.addRenderableWidget(button_dian_wo);
		GUI_A = new Checkbox(this.leftPos + 2, this.topPos + 30, 20, 20, new TranslatableComponent("gui.goodblock.findgui.GUI_A"), false);
		guistate.put("checkbox:GUI_A", GUI_A);
		this.addRenderableWidget(GUI_A);
	}
}
