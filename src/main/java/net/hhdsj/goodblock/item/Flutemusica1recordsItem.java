
package net.hhdsj.goodblock.item;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import net.hhdsj.goodblock.init.GoodblockModTabs;
import net.hhdsj.goodblock.init.GoodblockModSounds;

public class Flutemusica1recordsItem extends RecordItem {
	public Flutemusica1recordsItem() {
		super(0, GoodblockModSounds.REGISTRY.get(new ResourceLocation("goodblock:flutemusica_1records")), new Item.Properties().tab(GoodblockModTabs.TAB_WORLDBLOCK).stacksTo(1).rarity(Rarity.RARE));
	}
}
