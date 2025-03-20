
package net.hhdsj.goodblock.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import net.hhdsj.goodblock.init.GoodblockModTabs;
import net.hhdsj.goodblock.init.GoodblockModSounds;

public class FluteItem extends RecordItem {
	public FluteItem() {
		super(0, GoodblockModSounds.REGISTRY.get(new ResourceLocation("goodblock:gnusmas_gm_soundfont_2.00")), new Item.Properties().tab(GoodblockModTabs.TAB_WORLDBLOCK).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
