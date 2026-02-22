
package net.hhdsj.goodblock.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class Inksans4Item extends RecordItem {
	public Inksans4Item() {
		super(13, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("goodblock:ink_sans")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 100);
	}
}
