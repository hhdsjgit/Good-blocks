package net.hhdsj.goodblock.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.hhdsj.goodblock.network.KeyaMessage;
import net.hhdsj.goodblock.GoodblockMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GoodblockModKeyMappings {
	public static final KeyMapping KEYA = new KeyMapping("key.goodblock.keya", GLFW.GLFW_KEY_P, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				GoodblockMod.PACKET_HANDLER.sendToServer(new KeyaMessage(0, 0));
                if (Minecraft.getInstance().player != null) {
                    KeyaMessage.pressAction(Minecraft.getInstance().player, 0, 0);
                }
            }
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(KEYA);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				KEYA.consumeClick();
			}
		}
	}
}