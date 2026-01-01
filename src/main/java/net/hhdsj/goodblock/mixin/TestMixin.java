package net.hhdsj.goodblock.mixin;


import net.hhdsj.goodblock.init.GoodblockModBlocks;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
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

@Mixin(TreeFeatures.class)
public abstract class TestMixin {
    @Inject(method = "createStraightBlobTree", at = @At("HEAD"), cancellable = true)
    private static void createStraightBlobTree(Block log, Block leaf, int p_195149_, int p_195150_, int p_195151_, int p_195152_, CallbackInfoReturnable<TreeConfiguration.TreeConfigurationBuilder> callbackInfoReturnable) {
       
    }
}
