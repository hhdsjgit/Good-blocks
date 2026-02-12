
package net.hhdsj.goodblock.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

import net.hhdsj.goodblock.init.GoodblockModTabs;

public class PainitehoeItem extends HoeItem {
	public PainitehoeItem() {
		super(new Tier() {
			public int getUses() {
				return 4320;
			}

			public float getSpeed() {
				return 13f;
			}

			public float getAttackDamageBonus() {
				return 3f;
			}

			public int getLevel() {
				return 0;
			}

			public int getEnchantmentValue() {
				return 20;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_INGOT));
			}
		}, 0, -3f, new Item.Properties().fireResistant());
	}
}
