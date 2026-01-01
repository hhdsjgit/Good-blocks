package net.ltxprogrammer.changed.entity.decoration;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class WallSignVariant {
    private final int width;
    private final int height;

    private final Supplier<Item> asItem;

    public WallSignVariant(int width, int height, Supplier<Item> asItem) {
        this.width = width;
        this.height = height;
        this.asItem = asItem;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Item getItem() {
        return asItem.get();
    }
}
