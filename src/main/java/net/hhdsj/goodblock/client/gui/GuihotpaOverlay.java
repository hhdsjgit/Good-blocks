
package net.hhdsj.goodblock.client.gui;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.client.Minecraft;

import net.hhdsj.goodblock.procedures.GuihotpaXianShiYouXiNeiDieJiaCengProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class GuihotpaOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();
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
			if (GuihotpaXianShiYouXiNeiDieJiaCengProcedure.execute(entity)) {
				Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.goodblock.guihotpa.label_test_gui"), posX + -189, posY + -103, -1);
			}
		}
	}
}
