package net.hhdsj.goodblock.item;

import net.hhdsj.goodblock.init.GoodblockModTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class BlueCrystaloreItem extends Item {
    public BlueCrystaloreItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
    }

}
