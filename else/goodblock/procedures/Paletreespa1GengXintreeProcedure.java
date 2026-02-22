package net.hhdsj.goodblock.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.hhdsj.goodblock.init.GoodblockModBlocks;

public class Paletreespa1GengXintreeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		BlockState tree_levels_block = Blocks.AIR.defaultBlockState();
		double tree_higt = 0;
		double tree_hight_now = 0;
		double tree_y_now = 0;
		double tree_z_now = 0;
		double tree_x_now = 0;
		double a = 0;
		tree_higt = 7;
		tree_levels_block = GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState();
		for (int index0 = 0; index0 < (int) tree_higt; index0++) {
			tree_y_now = tree_y_now + 1;
			if (world.isEmptyBlock(BlockPos.containing(x, y + tree_y_now, z)) || blockstate.is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
				a = a + 1;
			}
		}
		tree_y_now = 0;
		if (Mth.nextDouble(RandomSource.create(), -3, 12) >= 7 && a >= tree_higt) {
			world.setBlock(BlockPos.containing(x, y, z), GoodblockModBlocks.PALE_WOOD_LOG.get().defaultBlockState(), 3);
			for (int index1 = 0; index1 < (int) tree_higt; index1++) {
				if (world.isEmptyBlock(BlockPos.containing(x, y + tree_y_now, z)) || blockstate.is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
					world.setBlock(BlockPos.containing(x, y + tree_y_now, z), GoodblockModBlocks.PALE_WOOD_LOG.get().defaultBlockState(), 3);
				}
				tree_y_now = tree_y_now + 1;
			}
			tree_y_now = tree_higt - 5;
			for (int index2 = 0; index2 < 2; index2++) {
				tree_x_now = -2;
				tree_z_now = -2;
				for (int index3 = 0; index3 < 5; index3++) {
					for (int index4 = 0; index4 < 5; index4++) {
						if (world.isEmptyBlock(BlockPos.containing(x + tree_x_now, y + tree_y_now, z + tree_z_now))) {
							world.setBlock(BlockPos.containing(x + tree_x_now, y + tree_y_now, z + tree_z_now), tree_levels_block, 3);
						}
						tree_x_now = tree_x_now + 1;
					}
					tree_x_now = -2;
					tree_z_now = tree_z_now + 1;
				}
				tree_y_now = tree_y_now + 1;
			}
		}
	}
}
