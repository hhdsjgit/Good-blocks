
/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 * 					屏幕
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.hhdsj.goodblock.client.gui.FINDGUIScreen;
import net.hhdsj.goodblock.client.gui.CatalyzerguiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GoodblockModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(GoodblockModMenus.FINDGUI, FINDGUIScreen::new);
			MenuScreens.register(GoodblockModMenus.CATALYZERGUI, CatalyzerguiScreen::new);
		});
	}
}
