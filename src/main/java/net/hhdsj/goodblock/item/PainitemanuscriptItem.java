
package net.hhdsj.goodblock.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.hhdsj.goodblock.init.GoodblockModTabs;

public class PainitemanuscriptItem extends PickaxeItem {
	public PainitemanuscriptItem() {
		super(new Tier() {
			public int getUses() {
				return 4532;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 8;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_INGOT));
			}
		}, 1, -3f, new Item.Properties().tab(GoodblockModTabs.TAB_WORLDBLOCK).fireResistant());
	}
}
