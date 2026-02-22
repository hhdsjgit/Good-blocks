
package net.hhdsj.goodblock.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.hhdsj.goodblock.procedures.ImpureuraniumDangWuPinZaiShouShangMeiKeFaShengProcedure;

public class ImpureuraniumingotItem extends Item {
	public ImpureuraniumingotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			ImpureuraniumDangWuPinZaiShouShangMeiKeFaShengProcedure.execute(entity);
	}
}
