package net.ltxprogrammer.changed.init;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.item.loot.RandomVariantFunction;
import net.ltxprogrammer.changed.item.loot.SetVariantFunction;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChangedLootItemFunctions {
    public static final DeferredRegister<LootItemFunctionType> REGISTRY = DeferredRegister.create(Registries.LOOT_FUNCTION_TYPE, Changed.MODID);

    public static final RegistryObject<LootItemFunctionType> SET_VARIANT = register("set_variant", new SetVariantFunction.Serializer());
    public static final RegistryObject<LootItemFunctionType> RANDOM_VARIANT = register("random_variant", new RandomVariantFunction.Serializer());

    private static RegistryObject<LootItemFunctionType> register(String name, Serializer<? extends LootItemFunction> serializer) {
        return REGISTRY.register(name, () -> new LootItemFunctionType(serializer));
    }
}
