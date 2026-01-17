package net.hhdsj.goodblock.Biome;

import net.hhdsj.goodblock.init.GoodblockModBlocks;
import net.hhdsj.goodblock.init.GoodblockModFluids;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.Holder;
import java.util.List;

public class LatexhotSwampBiome {
    public static Biome createLatexhotSwamp() {
        // 1. 生物生成设置 - 适应炎热沼泽的生物
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();

        // 适应炎热环境的沼泽生物
        spawnSettings.addSpawn(MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 50, 1, 3)); // 岩浆怪

        // 2. 生物群系特效 - 地狱般的橙色调
        BiomeSpecialEffects.Builder effects = new BiomeSpecialEffects.Builder()
                .skyColor(0xFF6A00)               // 深橙色天空
                .fogColor(0xFF4500)              // 暗橙色雾
                .waterColor(0xFF3300)             // 岩浆橙色（你的自定义液体）
                .waterFogColor(0xFF3300)          // 橙色水下雾
                .foliageColorOverride(0x8B4513)   // 鞍棕色（枯萎的树叶）
                .grassColorOverride(0x8B4513)     // 鞍棕色（枯萎的草地）
                .ambientMoodSound(new AmbientMoodSettings(
                        SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, // 灵魂沙谷音效
                        6000, 8, 2.0
                ))
                .ambientLoopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP); // 下界循环音效

        // 3. 生物群系生成设置
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        // 添加基础特征（修改版）
        addBaseFeatures(generationSettings);

        // 核心：替换方块和液体
        replaceSurfaceAndLiquid(generationSettings);

        // 4. 创建生物群系 - 主世界炎热沼泽
        Biome.BiomeBuilder biomeBuilder = new Biome.BiomeBuilder();

        biomeBuilder.precipitation(Biome.Precipitation.RAIN)    // 有降水（但液体是你的自定义液体）
                .biomeCategory(Biome.BiomeCategory.SWAMP)       // 沼泽分类
                .temperature(2F)                              // 高温
                .downfall(0F)                                 // 适度降雨
                .specialEffects(effects.build())                // 特效
                .mobSpawnSettings(spawnSettings.build())        // 生物生成
                .generationSettings(generationSettings.build()); // 地形生成

        return biomeBuilder.build();
    }

    private static void addBaseFeatures(BiomeGenerationSettings.Builder builder) {
        // 基础地形特征
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder);
    }

    private static void replaceSurfaceAndLiquid(BiomeGenerationSettings.Builder builder) {

        // 1. 替换地表方块（假设你的自定义方块是 ModBlocks.HOT_SWAMP_BLOCK）
        ReplaceBlockConfiguration surfaceReplace = new ReplaceBlockConfiguration(
                net.minecraft.world.level.block.Blocks.GRASS_BLOCK.defaultBlockState(),
                GoodblockModBlocks.CATALYZER.get().defaultBlockState()
        );

        // 1.5 替换泥土层（假设使用同种方块或不同变种）
        ReplaceBlockConfiguration dirtReplace = new ReplaceBlockConfiguration(
                net.minecraft.world.level.block.Blocks.DIRT.defaultBlockState(),
                GoodblockModBlocks.CATALYZER.get().defaultBlockState()
        );

        // 2. 替换所有水体为你的自定义液体
        // 假设你的自定义液体方块是 ModBlocks.LAVA_SWAMP_FLUID
        ReplaceBlockConfiguration waterReplace = new ReplaceBlockConfiguration(
                net.minecraft.world.level.block.Blocks.WATER.defaultBlockState(),
                GoodblockModFluids.FLUIDHOTTEST.get().defaultFluidState().createLegacyBlock()
        );


        // 2.5 替换流动水
        ReplaceBlockConfiguration flowingWaterReplace = new ReplaceBlockConfiguration(
                net.minecraft.world.level.block.Blocks.WATER.defaultBlockState(),
                GoodblockModFluids.FLUIDHOTTEST.get().defaultFluidState().createLegacyBlock()
        );

    }
}
