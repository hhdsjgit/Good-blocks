
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class GoodblockModTabs {
	public static CreativeModeTab TAB_WORLDBLOCK;
	public static CreativeModeTab TAB_GOODBLOCK_ENTITY;

	public static void load() {
		TAB_WORLDBLOCK = new CreativeModeTab("tabworldblock") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.KNOWLEDGE_BOOK);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_GOODBLOCK_ENTITY = new CreativeModeTab("tabgoodblock_entity") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(GoodblockModBlocks.BLOCKBW_1.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
