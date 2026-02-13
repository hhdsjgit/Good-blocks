/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.hhdsj.goodblock.Biome.LatexhotSwampBiome;
import net.hhdsj.goodblock.GoodblockMod;

public class GoodBlockModBiomes {

    // 创建DeferredRegister
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, GoodblockMod.MODID);

    // 注册热沼泽生物群系
    public static final ResourceKey<Biome> LATEX_HOT_SWAMP_KEY =
            ResourceKey.create(Registries.BIOME, new ResourceLocation(GoodblockMod.MODID, "latex_hot_swamp"));

    // 注册到Mod事件总线
    public static final RegistryObject<Biome> LATEXHOTSWAMPBIOME =
            BIOMES.register("latex_hot_swamp", () -> {

                throw new IllegalStateException("Biome must be registered via datapack or events with proper HolderGetter");
            });

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
