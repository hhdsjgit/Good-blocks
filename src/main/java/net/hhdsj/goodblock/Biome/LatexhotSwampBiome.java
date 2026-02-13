package net.hhdsj.goodblock.Biome;  // 注意：包名应该小写

import net.hhdsj.goodblock.init.GoodblockModBlocks;
import net.hhdsj.goodblock.init.GoodblockModFluids;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class LatexhotSwampBiome {

    public static Biome createLatexhotSwamp(HolderGetter<ConfiguredWorldCarver<?>> featureGetter,
                                            HolderGetter<PlacedFeature> placedFeatureGetter) {
        // 1. 生物生成设置 - 适应炎热沼泽的生物
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();

        // 适应炎热环境的沼泽生物
        spawnSettings.addSpawn(MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 50, 1, 3)); // 岩浆怪

        // 2. 生物群系特效 - 地狱般的橙色调
        BiomeSpecialEffects.Builder effects = new BiomeSpecialEffects.Builder()
                .skyColor(0xFF6A00)               // 深橙色天空
                .fogColor(0xFF4500)              // 暗橙色雾
                .waterColor(0xFF3300)             // 热流体颜色
                .waterFogColor(0xFF3300)          // 橙色水下雾
                .foliageColorOverride(0x8B4513)   // 鞍棕色（枯萎的树叶）
                .grassColorOverride(0x8B4513)     // 鞍棕色（枯萎的草地）
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP))
                .ambientLoopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP);

        // 3. 生物群系生成设置
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatureGetter, featureGetter);

        // 添加基础特征
        addBaseFeatures(generationSettings);

        // 核心：替换方块和液体
        addSurfaceAndLiquidReplacement(generationSettings);

        // 添加自定义矿石生成
        addCustomOres(generationSettings);

        // 4. 创建生物群系
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)           // 有降水
                .temperature(2.0F)                // 高温
                .downfall(0.0F)                  // 无降雨（但自定义液体会生成）
                .specialEffects(effects.build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static void addBaseFeatures(BiomeGenerationSettings.Builder builder) {
        // 基础地形特征
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder);
        BiomeDefaultFeatures.addSwampExtraVegetation(builder);  // 沼泽植被
        BiomeDefaultFeatures.addSwampVegetation(builder);       // 沼泽植物
        BiomeDefaultFeatures.addDefaultMushrooms(builder);      // 蘑菇
    }

    private static void addSurfaceAndLiquidReplacement(BiomeGenerationSettings.Builder builder) {

    }

    private static void addCustomOres(BiomeGenerationSettings.Builder builder) {
        // 添加自定义矿石生成

    }
}