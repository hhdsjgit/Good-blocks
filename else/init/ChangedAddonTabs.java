package net.foxyas.changedaddon.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class ChangedAddonTabs {
    public static CreativeModeTab TAB_CHANGED_ADDON;
    public static CreativeModeTab TAB_CHANGED_ADDON_COMBAT_OPTIONAL;

    public static void load() {
        TAB_CHANGED_ADDON = new CreativeModeTab("tab_changed_addon") {
            @Override
            public @NotNull ItemStack makeIcon() {
                return new ItemStack(ChangedAddonItems.CHANGED_BOOK.get());
            }

            @OnlyIn(Dist.CLIENT)
            public boolean hasSearchBar() {
                return false;
            }
        };
        TAB_CHANGED_ADDON_COMBAT_OPTIONAL = new CreativeModeTab("tab_changed_addon_combat_optional") {
            @Override
            public @NotNull ItemStack makeIcon() {
                return new ItemStack(ChangedAddonItems.ELECTRIC_KATANA.get());
            }

            @OnlyIn(Dist.CLIENT)
            public boolean hasSearchBar() {
                return false;
            }
        };
    }
}
