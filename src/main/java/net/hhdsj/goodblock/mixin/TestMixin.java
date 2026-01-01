package net.hhdsj.goodblock.mixin;

import net.ltxprogrammer.changed.data.DeferredStateProvider;
import net.ltxprogrammer.changed.data.MixedStateProvider;
import net.hhdsj.goodblock.init.GoodblockModBlocks;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class TestMixin {
    public TestMixin() {

    }


}
