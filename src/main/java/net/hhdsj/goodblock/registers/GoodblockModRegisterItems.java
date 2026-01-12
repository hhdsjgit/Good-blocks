package net.hhdsj.goodblock.registers;

import net.hhdsj.goodblock.GoodblockMod;
import net.hhdsj.goodblock.init.GoodblockModBlocks;
import net.hhdsj.goodblock.registers.GoodblockEntities;
import net.hhdsj.goodblock.init.GoodblockModTabs;
import net.hhdsj.goodblock.item.*;
import net.hhdsj.goodblock.entity.LatexDragonFruitWolfEntity;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class GoodblockModRegisterItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, GoodblockMod.MODID);//Register
	public static final RegistryObject<Item> LATEX_DRAGON_FRUIT_WOLF_SPAWN_EGG = REGISTRY.register("latex_dragon_fruit_wolf_spawn_egg",
		() -> new ForgeSpawnEggItem(GoodblockEntities.LATEXDRAGONFRUITWOLF,
				-16724788,
				-16711681,
				new Item.Properties().tab(GoodblockModTabs.TAB_GOODBLOCK_ENTITY)
		));

	public static final RegistryObject<Item> LATEX_KAMONA_HSGUY_DRAGON_WOLF_SPAWN_EGG = REGISTRY.register("latex_kamona_hsguy_dragon_wolf_spawn_egg",
			() -> new ForgeSpawnEggItem(GoodblockEntities.LATEX_KAMONA_HSGUY_DRAGON_WOLF,
					-16724788,
					-16711681,
					new Item.Properties().tab(GoodblockModTabs.TAB_GOODBLOCK_ENTITY)
			));

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
