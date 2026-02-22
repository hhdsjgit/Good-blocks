
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.hhdsj.goodblock.GoodblockMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodblockModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GoodblockMod.MODID);
	public static final RegistryObject<CreativeModeTab> WORLDBLOCK = REGISTRY.register("worldblock",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.goodblock.worldblock")).icon(() -> new ItemStack(Items.KNOWLEDGE_BOOK)).displayItems((parameters, tabData) -> {
				tabData.accept(GoodblockModBlocks.SULPHURBLOCK.get().asItem());
				tabData.accept(GoodblockModBlocks.NITREBLOCK.get().asItem());
				tabData.accept(GoodblockModBlocks.URANIUMMINERAL.get().asItem());
				tabData.accept(GoodblockModBlocks.PALE_WOOD_PLANKS.get().asItem());
				tabData.accept(GoodblockModBlocks.PALE_WOOD_LEAVES.get().asItem());
				tabData.accept(GoodblockModBlocks.PALE_WOOD_LOG.get().asItem());
				tabData.accept(GoodblockModBlocks.PALE_WOOD_WOOD.get().asItem());
				tabData.accept(GoodblockModBlocks.URANIUMBLOCK.get().asItem());
				tabData.accept(GoodblockModBlocks.BLUEBLOCK.get().asItem());
				tabData.accept(GoodblockModBlocks.IRONHOT.get().asItem());
				tabData.accept(GoodblockModBlocks.PALE_WOOD_STAIRS.get().asItem());
				tabData.accept(GoodblockModBlocks.PALE_WOOD_SLAB.get().asItem());
				tabData.accept(GoodblockModItems.SULPHUR.get());
				tabData.accept(GoodblockModItems.NITRICACID.get());
				tabData.accept(GoodblockModItems.IMPUREURANIUM.get());
				tabData.accept(GoodblockModItems.IMPUREURANIUMINGOT.get());
				tabData.accept(GoodblockModItems.PAINITESWORD.get());
				tabData.accept(GoodblockModItems.PAINITEMANUSCRIPT.get());
				tabData.accept(GoodblockModItems.PAINITEAXE.get());
				tabData.accept(GoodblockModItems.PAINITEHOE.get());
				tabData.accept(GoodblockModItems.PAINITESHOVEL.get());
				tabData.accept(GoodblockModBlocks.PALE_WOOD_BUTTON.get().asItem());
				tabData.accept(GoodblockModBlocks.PALETREESPA_1.get().asItem());
				tabData.accept(GoodblockModItems.THEFLUFFYHEARTBEATINTHECUBICLEMUSIC.get());
				tabData.accept(GoodblockModItems.FLUTEMUSICA_1RECORDS.get());
				tabData.accept(GoodblockModItems.NOTLISTENTHIS.get());
				tabData.accept(GoodblockModItems.FLUTE.get());
				tabData.accept(GoodblockModItems.ANITFRRYMUSIC.get());
				tabData.accept(GoodblockModItems.ARMORA_1_ARMOR_HELMET.get());
				tabData.accept(GoodblockModItems.ARMORA_1_ARMOR_CHESTPLATE.get());
				tabData.accept(GoodblockModItems.ARMORA_1_ARMOR_LEGGINGS.get());
				tabData.accept(GoodblockModItems.ARMORA_1_ARMOR_BOOTS.get());
				tabData.accept(GoodblockModItems.PAINITE_ARMOR_HELMET.get());
				tabData.accept(GoodblockModItems.PAINITE_ARMOR_CHESTPLATE.get());
				tabData.accept(GoodblockModItems.PAINITE_ARMOR_LEGGINGS.get());
				tabData.accept(GoodblockModItems.PAINITE_ARMOR_BOOTS.get());
				tabData.accept(GoodblockModItems.TESTGBK_BUCKET.get());
				tabData.accept(GoodblockModBlocks.BLOCKBW_1.get().asItem());
				tabData.accept(GoodblockModBlocks.BLOCKBW_2.get().asItem());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> GOODBLOCK_ENTITY = REGISTRY.register("goodblock_entity",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.goodblock.goodblock_entity")).icon(() -> new ItemStack(GoodblockModBlocks.BLOCKBW_1.get())).displayItems((parameters, tabData) -> {
				tabData.accept(GoodblockModItems.BLACKPUPMALE_SPAWN_EGG.get());
				tabData.accept(GoodblockModItems.WHITEBLUEPUP_SPAWN_EGG.get());
				tabData.accept(GoodblockModItems.LATEXPURPLEWSWOLF_SPAWN_EGG.get());
				tabData.accept(GoodblockModItems.LATEXTHREEMONTHWOLF_SPAWN_EGG.get());
				tabData.accept(GoodblockModItems.LATEXYUNXQHOTDRAGON_SPAWN_EGG.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(GoodblockModBlocks.BLACKBLOCK.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(GoodblockModBlocks.PALE_WOOD_FENCE_GATE.get().asItem());
			tabData.accept(GoodblockModBlocks.PALE_WOOD_PRESSURE_PLATE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(GoodblockModItems.LATEXFOX_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEX_ORANGE_FOX_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEX_KCAHRA_SHARK_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEXGREENDRAGON_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.DARKFU_LATEX_WOLF_MALE_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEXICE_DRAGON_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.INKSUGER_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.SADASD_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(GoodblockModBlocks.PALE_WOOD_FENCE.get().asItem());
		}
	}
}
