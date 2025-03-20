
/*
*    MCreator note: This file will be REGENERATED on each build.
*/
package net.hhdsj.goodblock.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GoodblockModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 38), new ItemStack(GoodblockModItems.IMPUREURANIUM.get()), new ItemStack(GoodblockModItems.IMPUREURANIUMINGOT.get()), 2, 5, 0.05f));
		}
	}
}
