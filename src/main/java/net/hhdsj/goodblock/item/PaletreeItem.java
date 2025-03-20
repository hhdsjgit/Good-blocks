
package net.hhdsj.goodblock.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.hhdsj.goodblock.procedures.PaletreeDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhiProcedure;

public class PaletreeItem extends Item {
	public PaletreeItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		return PaletreeDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(),
				context.getItemInHand());
	}
}
