package net.ltxprogrammer.changed.init;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.entity.decoration.WallSignVariant;
import net.ltxprogrammer.changed.item.WallSignItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ChangedWallSigns {
    public static final DeferredRegister<WallSignVariant> REGISTRY = ChangedRegistry.WALL_SIGN_VARIANT.createDeferred(Changed.MODID);

    private static RegistryObject<WallSignVariant> register(int width, int height, String name) {
        final RegistryObject<Item> item = ChangedItems.REGISTRY.register("wall_sign_" + name,
                () -> new WallSignItem(new Item.Properties()));
        return REGISTRY.register(name, () -> new WallSignVariant(width, height, item));
    }

    public static final RegistryObject<WallSignVariant> DO_NOT_TOUCH = register(32, 24, "do_not_touch");
    public static final RegistryObject<WallSignVariant> SQUID = register(32, 24, "squid");
    public static final RegistryObject<WallSignVariant> PROTOTYPE = register(32, 24, "prototype");
    public static final RegistryObject<WallSignVariant> CAT = register(32, 24, "cat");
    public static final RegistryObject<WallSignVariant> DO_NOT_TOUCH_LATEXES = register(16, 32, "do_not_touch_latexes");
    public static final RegistryObject<WallSignVariant> DO_NOT_SPEAK_WITH_DARK_LATEXES = register(16, 32, "do_not_speak_with_dark_latexes");
}
