
package net.hhdsj.goodblock.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.hhdsj.goodblock.init.GoodblockModTabs;

public abstract class Armora1ArmorItem extends ArmorItem {
	public Armora1ArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 12;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{2, 5, 4, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 7;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.COPPER_INGOT));
			}

			@Override
			public String getName() {
				return "armora_1_armor";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends Armora1ArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(GoodblockModTabs.TAB_WORLDBLOCK));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "goodblock:textures/models/armor/armora1_layer_1.png";
		}
	}

	public static class Chestplate extends Armora1ArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(GoodblockModTabs.TAB_WORLDBLOCK));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "goodblock:textures/models/armor/armora1_layer_1.png";
		}
	}

	public static class Leggings extends Armora1ArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(GoodblockModTabs.TAB_WORLDBLOCK));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "goodblock:textures/models/armor/armora1_layer_2.png";
		}
	}

	public static class Boots extends Armora1ArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(GoodblockModTabs.TAB_WORLDBLOCK));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "goodblock:textures/models/armor/armora1_layer_1.png";
		}
	}
}
