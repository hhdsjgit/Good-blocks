
package net.hhdsj.goodblock.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.hhdsj.goodblock.init.GoodblockModTabs;

import java.util.List;

public class NitricacidItem extends Item {
	public NitricacidItem() {
		super(new Item.Properties().tab(GoodblockModTabs.TAB_WORLDBLOCK).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("nitric"));
	}
}
