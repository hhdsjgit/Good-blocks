
/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.hhdsj.goodblock.world.inventory.FINDGUIMenu;
import net.hhdsj.goodblock.world.inventory.CatalyzerguiMenu;

import java.util.List;
import java.util.ArrayList;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.hhdsj.goodblock.world.inventory.FINDGUIMenu;
import net.hhdsj.goodblock.GoodblockMod;
/*
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodblockModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<FINDGUIMenu> FINDGUI = register("findgui", (id, inv, extraData) -> new FINDGUIMenu(id, inv, extraData));
	public static final MenuType<CatalyzerguiMenu> CATALYZERGUI = register("catalyzergui", (id, inv, extraData) -> new CatalyzerguiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}*/



public class GoodblockModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, GoodblockMod.MODID);
	public static final RegistryObject<MenuType<CatalyzerguiMenu>> CATALYZERGUI = REGISTRY.register("catalyzergui", () -> IForgeMenuType.create(CatalyzerguiMenu::new));
	public static final RegistryObject<MenuType<FINDGUIMenu>> FINDGUI = REGISTRY.register("findgui", () -> IForgeMenuType.create(FINDGUIMenu::new));
}
