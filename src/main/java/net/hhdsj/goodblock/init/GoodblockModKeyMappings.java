
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.hhdsj.goodblock.network.KeyaMessage;
import net.hhdsj.goodblock.GoodblockMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GoodblockModKeyMappings {
	public static final KeyMapping KEYA = new KeyMapping("key.goodblock.keya", GLFW.GLFW_KEY_P, "key.categories.ui");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(KEYA);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == KEYA.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						GoodblockMod.PACKET_HANDLER.sendToServer(new KeyaMessage(0, 0));
						KeyaMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
