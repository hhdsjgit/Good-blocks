package net.hhdsj.goodblock.item;

import net.hhdsj.goodblock.init.GoodblockModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.hhdsj.goodblock.init.GoodblockModTabs;


public class DragonfruitItem extends Item {
	public DragonfruitItem() {
		super(new Item.Properties()
				.stacksTo(64)
				.rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder())
						.nutrition(4)
						.saturationMod(0.3f).alwaysEat()
						.effect(() -> new MobEffectInstance(
								GoodblockModMobEffects.SLOWINFECTION.get(),
								200,
								0
						), 0.3f)

						.build()));
	}


}
