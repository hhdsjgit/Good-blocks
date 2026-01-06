
package net.hhdsj.goodblock.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.hhdsj.goodblock.init.GoodblockModTabs;
import net.hhdsj.goodblock.init.GoodblockModFluids;

public class FluidhottestItem extends BucketItem {
	public FluidhottestItem() {
		super(GoodblockModFluids.FLUIDHOTTEST, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(GoodblockModTabs.TAB_WORLDBLOCK));
	}
}
