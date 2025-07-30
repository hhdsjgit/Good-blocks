
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.hhdsj.goodblock.item.ThefluffyheartbeatinthecubiclemusicItem;
import net.hhdsj.goodblock.item.TESTGBKItem;
import net.hhdsj.goodblock.item.SulphurItem;
import net.hhdsj.goodblock.item.PaletreeItem;
import net.hhdsj.goodblock.item.PainiteswordItem;
import net.hhdsj.goodblock.item.PainiteshovelItem;
import net.hhdsj.goodblock.item.PainitemanuscriptItem;
import net.hhdsj.goodblock.item.PainitehoeItem;
import net.hhdsj.goodblock.item.PainiteaxeItem;
import net.hhdsj.goodblock.item.PainiteArmorItem;
import net.hhdsj.goodblock.item.NotlistenthisItem;
import net.hhdsj.goodblock.item.NitricacidItem;
import net.hhdsj.goodblock.item.Inksans4Item;
import net.hhdsj.goodblock.item.ImpureuraniumingotItem;
import net.hhdsj.goodblock.item.ImpureuraniumItem;
import net.hhdsj.goodblock.item.Flutemusica1recordsItem;
import net.hhdsj.goodblock.item.FluteItem;
import net.hhdsj.goodblock.item.Armora1ArmorItem;
import net.hhdsj.goodblock.item.AnitfrrymusicItem;
import net.hhdsj.goodblock.GoodblockMod;

public class GoodblockModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, GoodblockMod.MODID);
	public static final RegistryObject<Item> SULPHUR = REGISTRY.register("sulphur", () -> new SulphurItem());
	public static final RegistryObject<Item> NITRICACID = REGISTRY.register("nitricacid", () -> new NitricacidItem());
	public static final RegistryObject<Item> IMPUREURANIUM = REGISTRY.register("impureuranium", () -> new ImpureuraniumItem());
	public static final RegistryObject<Item> SULPHURBLOCK = block(GoodblockModBlocks.SULPHURBLOCK, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> NITREBLOCK = block(GoodblockModBlocks.NITREBLOCK, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> URANIUMMINERAL = block(GoodblockModBlocks.URANIUMMINERAL, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> IMPUREURANIUMINGOT = REGISTRY.register("impureuraniumingot", () -> new ImpureuraniumingotItem());
	public static final RegistryObject<Item> URANIUMBLOCK = block(GoodblockModBlocks.URANIUMBLOCK, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> TESTGBK_BUCKET = REGISTRY.register("testgbk_bucket", () -> new TESTGBKItem());
	public static final RegistryObject<Item> NOTLISTENTHIS = REGISTRY.register("notlistenthis", () -> new NotlistenthisItem());
	public static final RegistryObject<Item> BLACKBLOCK = block(GoodblockModBlocks.BLACKBLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> BLUEBLOCK = block(GoodblockModBlocks.BLUEBLOCK, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> IRONHOT = block(GoodblockModBlocks.IRONHOT, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> FLUTE = REGISTRY.register("flute", () -> new FluteItem());
	public static final RegistryObject<Item> ANITFRRYMUSIC = REGISTRY.register("anitfrrymusic", () -> new AnitfrrymusicItem());
	public static final RegistryObject<Item> PAINITE_ARMOR_HELMET = REGISTRY.register("painite_armor_helmet", () -> new PainiteArmorItem.Helmet());
	public static final RegistryObject<Item> PAINITE_ARMOR_CHESTPLATE = REGISTRY.register("painite_armor_chestplate", () -> new PainiteArmorItem.Chestplate());
	public static final RegistryObject<Item> PAINITE_ARMOR_LEGGINGS = REGISTRY.register("painite_armor_leggings", () -> new PainiteArmorItem.Leggings());
	public static final RegistryObject<Item> PAINITE_ARMOR_BOOTS = REGISTRY.register("painite_armor_boots", () -> new PainiteArmorItem.Boots());
	public static final RegistryObject<Item> PAINITEMANUSCRIPT = REGISTRY.register("painitemanuscript", () -> new PainitemanuscriptItem());
	public static final RegistryObject<Item> PAINITESWORD = REGISTRY.register("painitesword", () -> new PainiteswordItem());
	public static final RegistryObject<Item> PAINITEAXE = REGISTRY.register("painiteaxe", () -> new PainiteaxeItem());
	public static final RegistryObject<Item> PAINITEHOE = REGISTRY.register("painitehoe", () -> new PainitehoeItem());
	public static final RegistryObject<Item> PAINITESHOVEL = REGISTRY.register("painiteshovel", () -> new PainiteshovelItem());
	public static final RegistryObject<Item> PALE_WOOD_WOOD = block(GoodblockModBlocks.PALE_WOOD_WOOD, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> PALE_WOOD_LOG = block(GoodblockModBlocks.PALE_WOOD_LOG, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> PALE_WOOD_PLANKS = block(GoodblockModBlocks.PALE_WOOD_PLANKS, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> PALE_WOOD_LEAVES = block(GoodblockModBlocks.PALE_WOOD_LEAVES, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> PALE_WOOD_STAIRS = block(GoodblockModBlocks.PALE_WOOD_STAIRS, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> PALE_WOOD_SLAB = block(GoodblockModBlocks.PALE_WOOD_SLAB, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> PALE_WOOD_FENCE = block(GoodblockModBlocks.PALE_WOOD_FENCE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> PALE_WOOD_FENCE_GATE = block(GoodblockModBlocks.PALE_WOOD_FENCE_GATE, CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> PALE_WOOD_PRESSURE_PLATE = block(GoodblockModBlocks.PALE_WOOD_PRESSURE_PLATE, CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> PALE_WOOD_BUTTON = block(GoodblockModBlocks.PALE_WOOD_BUTTON, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> PALETREESPA_1 = block(GoodblockModBlocks.PALETREESPA_1, GoodblockModTabs.TAB_WORLDBLOCK);
	public static final RegistryObject<Item> PALETREE = REGISTRY.register("paletree", () -> new PaletreeItem());
	public static final RegistryObject<Item> INKSANS_4 = REGISTRY.register("inksans_4", () -> new Inksans4Item());
	public static final RegistryObject<Item> LATEXTEST_SPAWN_EGG = REGISTRY.register("latextest_spawn_egg", () -> new ForgeSpawnEggItem(GoodblockModEntities.LATEXTEST, -16724788, -16751002, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> THEFLUFFYHEARTBEATINTHECUBICLEMUSIC = REGISTRY.register("thefluffyheartbeatinthecubiclemusic", () -> new ThefluffyheartbeatinthecubiclemusicItem());
	public static final RegistryObject<Item> FLUTEMUSICA_1RECORDS = REGISTRY.register("flutemusica_1records", () -> new Flutemusica1recordsItem());
	public static final RegistryObject<Item> ARMORA_1_ARMOR_HELMET = REGISTRY.register("armora_1_armor_helmet", () -> new Armora1ArmorItem.Helmet());
	public static final RegistryObject<Item> ARMORA_1_ARMOR_CHESTPLATE = REGISTRY.register("armora_1_armor_chestplate", () -> new Armora1ArmorItem.Chestplate());
	public static final RegistryObject<Item> ARMORA_1_ARMOR_LEGGINGS = REGISTRY.register("armora_1_armor_leggings", () -> new Armora1ArmorItem.Leggings());
	public static final RegistryObject<Item> ARMORA_1_ARMOR_BOOTS = REGISTRY.register("armora_1_armor_boots", () -> new Armora1ArmorItem.Boots());
	public static final RegistryObject<Item> LATEXFOX_SPAWN_EGG = REGISTRY.register("latexfox_spawn_egg", () -> new ForgeSpawnEggItem(GoodblockModEntities.LATEXFOX, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> LATEX_ORANGE_FOX_SPAWN_EGG = REGISTRY.register("latex_orange_fox_spawn_egg",
			() -> new ForgeSpawnEggItem(GoodblockModEntities.LATEX_ORANGE_FOX, -39373, -39424, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
