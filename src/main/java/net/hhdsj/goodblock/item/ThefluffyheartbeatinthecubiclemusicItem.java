
package net.hhdsj.goodblock.item;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import net.hhdsj.goodblock.init.GoodblockModTabs;
import net.hhdsj.goodblock.init.GoodblockModSounds;
import net.minecraftforge.registries.ForgeRegistries;

public class ThefluffyheartbeatinthecubiclemusicItem extends RecordItem {
	public ThefluffyheartbeatinthecubiclemusicItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("goodblock:the_fluffy_heartbeat_in_the_cubicle")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE),100);
	}
}
