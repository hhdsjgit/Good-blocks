package net.ltxprogrammer.changed.entity;

import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.init.ChangedBlocks;
import net.ltxprogrammer.changed.init.ChangedEntities;
import net.ltxprogrammer.changed.init.ChangedItems;
import net.ltxprogrammer.changed.item.AbstractLatexBucket;
import net.ltxprogrammer.changed.item.AbstractLatexItem;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changed.util.EntityUtil;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.IExtensibleEnum;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@Deprecated
public enum LatexTypeOld implements StringRepresentable, IExtensibleEnum {
    NEUTRAL("neutral"),
    DARK_LATEX("dark_latex", ChangedItems.DARK_LATEX_GOO, ChangedItems.DARK_LATEX_BUCKET, ChangedBlocks.DARK_LATEX_BLOCK, ChangedEntities.DARK_LATEX_WOLF_PUP, Color3.DARK, MapColor.TERRACOTTA_BLACK),
    WHITE_LATEX("white_latex", ChangedItems.WHITE_LATEX_GOO, ChangedItems.WHITE_LATEX_BUCKET, ChangedBlocks.WHITE_LATEX_BLOCK, () -> null /* null for now */, Color3.WHITE, MapColor.TERRACOTTA_WHITE);

    private final String serialName;
    public final Supplier<? extends AbstractLatexItem> goo;
    public final Supplier<? extends AbstractLatexBucket> gooBucket;
    public final Supplier<? extends Block> block;
    public final Supplier<? extends EntityType<?>> pup;
    public final Color3 color;
    public final MapColor mapColor;

    LatexTypeOld(String serialName) {
        this.serialName = serialName;
        this.goo = () -> null;
        this.gooBucket = () -> null;
        this.block = () -> null;
        this.pup = () -> null;
        this.color = Color3.WHITE;
        this.mapColor = MapColor.NONE;
    }
    LatexTypeOld(String serialName, Supplier<? extends AbstractLatexItem> goo, Supplier<? extends AbstractLatexBucket> gooBucket, Supplier<? extends Block> block, Supplier<? extends EntityType<?>> pup, Color3 color, MapColor mapColor) {
        this.serialName = serialName;
        this.goo = goo;
        this.gooBucket = gooBucket;
        this.block = block;
        this.pup = pup;
        this.color = color;
        this.mapColor = mapColor;
    }

    @Override
    public String getSerializedName() {
        return serialName;
    }

    public static LatexTypeOld create(String name, String serialName, Supplier<? extends Item> goo, Supplier<? extends Item> gooBucket, Supplier<Block> block, Supplier<? extends EntityType<?>> pup, Color3 color, MapColor mapColor)
    {
        throw new IllegalStateException("Enum not extended");
    }
}
