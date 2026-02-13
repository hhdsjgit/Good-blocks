/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.GoodblockMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodblockModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GoodblockMod.MODID);

	// 世界方块标签页
	public static final RegistryObject<CreativeModeTab> WORLDBLOCK = REGISTRY.register("worldblock",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("item_group.goodblock.worldblock"))
					.icon(() -> new ItemStack(Items.KNOWLEDGE_BOOK))
					.build());

	// 实体标签页
	public static final RegistryObject<CreativeModeTab> GOODBLOCK_ENTITY = REGISTRY.register("goodblock_entity",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("item_group.goodblock.goodblock_entity"))
					.icon(() -> new ItemStack(GoodblockModBlocks.BLOCKBW_1.get()))
					.build());

	// 所有物品通过事件添加到对应的标签页
	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		// 1. 添加到自定义标签页：WORLDBLOCK
		if (tabData.getTabKey() == WORLDBLOCK.getKey()) {
			// 方块
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
			tabData.accept(GoodblockModBlocks.PALE_WOOD_BUTTON.get().asItem());
			tabData.accept(GoodblockModBlocks.PALETREESPA_1.get().asItem());
			tabData.accept(GoodblockModBlocks.BLOCKBW_1.get().asItem());
			tabData.accept(GoodblockModBlocks.BLOCKBW_2.get().asItem());
			tabData.accept(GoodblockModBlocks.BLUE_CRYSTALORE.get().asItem()); // 修复：添加到标签页
			tabData.accept(GoodblockModBlocks.CATALYZER.get().asItem()); // 修复：添加到标签页

			// 物品
			tabData.accept(GoodblockModItems.SULPHUR.get());
			tabData.accept(GoodblockModItems.NITRICACID.get());
			tabData.accept(GoodblockModItems.IMPUREURANIUM.get());
			tabData.accept(GoodblockModItems.IMPUREURANIUMINGOT.get());
			tabData.accept(GoodblockModItems.PAINITESWORD.get());
			tabData.accept(GoodblockModItems.PAINITEMANUSCRIPT.get());
			tabData.accept(GoodblockModItems.PAINITEAXE.get());
			tabData.accept(GoodblockModItems.PAINITEHOE.get());
			tabData.accept(GoodblockModItems.PAINITESHOVEL.get());
			tabData.accept(GoodblockModItems.THEFLUFFYHEARTBEATINTHECUBICLEMUSIC.get());
			tabData.accept(GoodblockModItems.FLUTEMUSICA_1RECORDS.get());
			tabData.accept(GoodblockModItems.NOTLISTENTHIS.get());
			tabData.accept(GoodblockModItems.FLUTE.get());
			tabData.accept(GoodblockModItems.ANITFRRYMUSIC.get());
			tabData.accept(GoodblockModItems.DRAGONFRUIT.get());
			tabData.accept(GoodblockModItems.BlueCrystaloreItem.get());
			tabData.accept(GoodblockModItems.PALETREE.get());
			tabData.accept(GoodblockModItems.INKSANS_4.get());

			// 盔甲
			tabData.accept(GoodblockModItems.ARMORA_1_ARMOR_HELMET.get());
			tabData.accept(GoodblockModItems.ARMORA_1_ARMOR_CHESTPLATE.get());
			tabData.accept(GoodblockModItems.ARMORA_1_ARMOR_LEGGINGS.get());
			tabData.accept(GoodblockModItems.ARMORA_1_ARMOR_BOOTS.get());
			tabData.accept(GoodblockModItems.PAINITE_ARMOR_HELMET.get());
			tabData.accept(GoodblockModItems.PAINITE_ARMOR_CHESTPLATE.get());
			tabData.accept(GoodblockModItems.PAINITE_ARMOR_LEGGINGS.get());
			tabData.accept(GoodblockModItems.PAINITE_ARMOR_BOOTS.get());

			// 液体桶
			tabData.accept(GoodblockModItems.FLUIDHOTTEST_BUCKET.get());
		}

		// 自定义标签页：GOODBLOCK_ENTITY
		else if (tabData.getTabKey() == GOODBLOCK_ENTITY.getKey()) {
			tabData.accept(GoodblockModItems.BLACKPUPMALE_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.WHITEBLUEPUP_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEXPURPLEWSWOLF_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEXTHREEMONTHWOLF_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEXYUNXQHOTDRAGON_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEXYUNXQICEDRAGON_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEXBLUEDRAGON_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEX_DRAGON_FRUIT_WOLF_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEX_ICE_FIELD_WOLF_DRAGON_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEX_PURPLE_COOC_WOLF_EGG.get());
		}

		// 原版标签页
		else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(GoodblockModBlocks.BLACKBLOCK.get().asItem());
		}
		else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(GoodblockModBlocks.PALE_WOOD_FENCE_GATE.get().asItem());
			tabData.accept(GoodblockModBlocks.PALE_WOOD_PRESSURE_PLATE.get().asItem());
		}
		else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(GoodblockModItems.LATEX_ORANGE_FOX_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEX_KCAHRA_SHARK_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.DARKFU_LATEX_WOLF_MALE_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.LATEXICE_DRAGON_SPAWN_EGG.get());
			tabData.accept(GoodblockModItems.INKSUGER_SPAWN_EGG.get());
		}
		else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(GoodblockModBlocks.PALE_WOOD_FENCE.get().asItem());
		}
		else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			// 如果有功能性方块可以放这里
		}
		else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			// 如果有工具可以放这里
		}
		else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			// 如果有战斗用品可以放这里
		}
		else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			// 如果有食物可以放这里
		}
		else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			// 如果有合成材料可以放这里
		}
	}
}