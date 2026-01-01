package net.ltxprogrammer.changed.init;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.world.LatexCoverState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Consumer;

@Mod.EventBusSubscriber
public class ChangedLootContextParamSets {
    public static final LootContextParamSet LATEX_COVER = register("latex_cover", (builder) -> {
        builder.required(LatexCoverState.LOOT_CONTEXT_PARAM).required(LootContextParams.ORIGIN).required(LootContextParams.TOOL).optional(LootContextParams.THIS_ENTITY).optional(LootContextParams.EXPLOSION_RADIUS);
    });

    private static LootContextParamSet register(String name, Consumer<LootContextParamSet.Builder> builderConsumer) {
        LootContextParamSet.Builder lootcontextparamset$builder = new LootContextParamSet.Builder();
        builderConsumer.accept(lootcontextparamset$builder);
        LootContextParamSet lootcontextparamset = lootcontextparamset$builder.build();
        ResourceLocation resourcelocation = Changed.modResource(name);
        LootContextParamSet lootcontextparamset1 = LootContextParamSets.REGISTRY.put(resourcelocation, lootcontextparamset);
        if (lootcontextparamset1 != null) {
            throw new IllegalStateException("Loot table parameter set " + resourcelocation + " is already registered");
        } else {
            return lootcontextparamset;
        }
    }
}
