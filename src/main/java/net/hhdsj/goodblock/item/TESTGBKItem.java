
package net.hhdsj.goodblock.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.hhdsj.goodblock.init.GoodblockModFluids;

public class TESTGBKItem extends BucketItem {
	public TESTGBKItem() {
		super(GoodblockModFluids.TESTGBK, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.EPIC).tab(null));
	}
}
