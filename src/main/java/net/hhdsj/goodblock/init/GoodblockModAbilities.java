package net.hhdsj.goodblock.init;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.ability.*;
import net.ltxprogrammer.changed.init.ChangedItems;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import net.hhdsj.goodblock.init.GoodblockModItems;
import net.hhdsj.goodblock.registers.GoodblockModRegisterItems;

public class GoodblockModAbilities{
    public static final DeferredRegister<AbstractAbility<?>> REGISTRY = ChangedRegistry.ABILITY.createDeferred(Changed.MODID);

    public static RegistryObject<SimpleCreateItemAbility> CREATE_DRAGON_FRUIT = REGISTRY.register("create_dragon_fruit",
            () -> new SimpleCreateItemAbility(() -> new ItemStack(GoodblockModItems.DRAGONFRUIT.get()), 5.0f, 6.0f));

    public static AbstractAbility<?> getAbility(ResourceLocation location) {
        return ChangedRegistry.ABILITY.get().getValue(location);
    }
}
