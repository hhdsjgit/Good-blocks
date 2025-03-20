
package net.hhdsj.goodblock.item;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import net.hhdsj.goodblock.init.GoodblockModSounds;

public class Inksans4Item extends RecordItem {
	public Inksans4Item() {
		super(13, GoodblockModSounds.REGISTRY.get(new ResourceLocation("goodblock:ink_sans")), new Item.Properties().tab(null).stacksTo(1).rarity(Rarity.RARE));
	}
}
