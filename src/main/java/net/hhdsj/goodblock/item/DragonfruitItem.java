
package net.hhdsj.goodblock.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

import net.hhdsj.goodblock.init.GoodblockModTabs;

public class DragonfruitItem extends Item {
	public DragonfruitItem() {
		super(new Item.Properties().tab(GoodblockModTabs.TAB_WORLDBLOCK).stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f).alwaysEat()

				.build()));
	}
}
