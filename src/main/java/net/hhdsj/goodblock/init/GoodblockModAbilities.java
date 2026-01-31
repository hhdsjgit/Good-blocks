/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.ability.*;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class GoodblockModAbilities{
    public static final DeferredRegister<AbstractAbility<?>> REGISTRY = ChangedRegistry.ABILITY.createDeferred(Changed.MODID);

    public static RegistryObject<SimpleCreateItemAbility> CREATE_DRAGON_FRUIT = REGISTRY.register("create_dragon_fruit",
            () -> new SimpleCreateItemAbility(() -> new ItemStack(GoodblockModItems.DRAGONFRUIT.get()), 1.0f, 1.0f));

    /*
    public static RegistryObject<SimpleCreateItemAbility> CREATE_ARROWS_FRUIT = REGISTRY.register("create_arrows_fruit",
            () -> new SimpleCreateItemAbility(() -> new ItemStack(GoodblockModItems.DRAGONFRUIT.get()), 1.0f, 1.0f));
*/
    public static AbstractAbility<?> getAbility(ResourceLocation location) {
        return ChangedRegistry.ABILITY.get().getValue(location);
    }
}
