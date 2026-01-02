
package net.hhdsj.goodblock.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BucketItem;

import net.hhdsj.goodblock.init.GoodblockModFluids;

public class AItem extends BucketItem {
	public AItem() {
		super(GoodblockModFluids.A, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(CreativeModeTab.TAB_MISC));
	}
}
