
package net.hhdsj.goodblock.item;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import net.hhdsj.goodblock.init.GoodblockModTabs;
import net.hhdsj.goodblock.init.GoodblockModSounds;
import net.minecraftforge.registries.ForgeRegistries;

public class Flutemusica1recordsItem extends RecordItem {
	public Flutemusica1recordsItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("goodblock:flutemusica_1records")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 100);
	}
}
