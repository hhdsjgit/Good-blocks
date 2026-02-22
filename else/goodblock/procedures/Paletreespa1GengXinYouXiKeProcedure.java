package net.hhdsj.goodblock.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.hhdsj.goodblock.init.GoodblockModBlocks;

public class Paletreespa1GengXinYouXiKeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() > 0.3) {
			if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				world.setBlock(BlockPos.containing(x, y, z), GoodblockModBlocks.PALE_WOOD_LOG.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 1, z), GoodblockModBlocks.PALE_WOOD_LOG.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
				world.setBlock(BlockPos.containing(x, y + 2, z), GoodblockModBlocks.PALE_WOOD_LOG.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 3, z))) {
				world.setBlock(BlockPos.containing(x, y + 3, z), GoodblockModBlocks.PALE_WOOD_LOG.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 4, z))) {
				world.setBlock(BlockPos.containing(x, y + 4, z), GoodblockModBlocks.PALE_WOOD_LOG.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 5, z))) {
				world.setBlock(BlockPos.containing(x, y + 5, z), GoodblockModBlocks.PALE_WOOD_LOG.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 6, z))) {
				world.setBlock(BlockPos.containing(x, y + 6, z), GoodblockModBlocks.PALE_WOOD_LOG.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 7, z))) {
				world.setBlock(BlockPos.containing(x, y + 7, z), GoodblockModBlocks.PALE_WOOD_LOG.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 3, z))) {
				world.setBlock(BlockPos.containing(x + 1, y + 3, z), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 2, y + 3, z))) {
				world.setBlock(BlockPos.containing(x + 2, y + 3, z), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 3, z))) {
				world.setBlock(BlockPos.containing(x - 1, y + 3, z), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 2, y + 3, z))) {
				world.setBlock(BlockPos.containing(x - 2, y + 3, z), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 3, z + 1))) {
				world.setBlock(BlockPos.containing(x + 1, y + 3, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 2, y + 3, z + 1))) {
				world.setBlock(BlockPos.containing(x + 2, y + 3, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 3, z + 1))) {
				world.setBlock(BlockPos.containing(x - 1, y + 3, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 2, y + 3, z + 1))) {
				world.setBlock(BlockPos.containing(x - 2, y + 3, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 3, z + 1))) {
				world.setBlock(BlockPos.containing(x, y + 3, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 3, z + 2))) {
				world.setBlock(BlockPos.containing(x + 1, y + 3, z + 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 2, y + 3, z + 2))) {
				world.setBlock(BlockPos.containing(x + 2, y + 3, z + 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 3, z + 2))) {
				world.setBlock(BlockPos.containing(x - 1, y + 3, z + 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 2, y + 3, z + 2))) {
				world.setBlock(BlockPos.containing(x - 2, y + 3, z + 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 3, z + 2))) {
				world.setBlock(BlockPos.containing(x, y + 3, z + 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 3, z - 1))) {
				world.setBlock(BlockPos.containing(x + 1, y + 3, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 2, y + 3, z - 1))) {
				world.setBlock(BlockPos.containing(x + 2, y + 3, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 3, z - 1))) {
				world.setBlock(BlockPos.containing(x - 1, y + 3, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 2, y + 3, z - 1))) {
				world.setBlock(BlockPos.containing(x - 2, y + 3, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 3, z - 1))) {
				world.setBlock(BlockPos.containing(x, y + 3, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 3, z - 2))) {
				world.setBlock(BlockPos.containing(x + 1, y + 3, z - 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 2, y + 3, z - 2))) {
				world.setBlock(BlockPos.containing(x + 2, y + 3, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 3, z - 2))) {
				world.setBlock(BlockPos.containing(x - 1, y + 3, z - 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 2, y + 3, z - 2))) {
				world.setBlock(BlockPos.containing(x - 2, y + 3, z - 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 3, z - 2))) {
				world.setBlock(BlockPos.containing(x, y + 3, z - 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 4, z))) {
				world.setBlock(BlockPos.containing(x + 1, y + 4, z), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 2, y + 4, z))) {
				world.setBlock(BlockPos.containing(x + 2, y + 4, z), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 4, z))) {
				world.setBlock(BlockPos.containing(x - 1, y + 4, z), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 2, y + 4, z))) {
				world.setBlock(BlockPos.containing(x - 2, y + 4, z), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 4, z + 1))) {
				world.setBlock(BlockPos.containing(x + 1, y + 4, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 2, y + 4, z + 1))) {
				world.setBlock(BlockPos.containing(x + 2, y + 4, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 4, z + 1))) {
				world.setBlock(BlockPos.containing(x - 1, y + 4, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 2, y + 4, z + 1))) {
				world.setBlock(BlockPos.containing(x - 2, y + 4, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 4, z + 1))) {
				world.setBlock(BlockPos.containing(x, y + 4, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 4, z + 2))) {
				world.setBlock(BlockPos.containing(x + 1, y + 4, z + 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 2, y + 4, z + 2))) {
				world.setBlock(BlockPos.containing(x + 2, y + 4, z + 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 4, z + 2))) {
				world.setBlock(BlockPos.containing(x - 1, y + 4, z + 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 2, y + 4, z + 2))) {
				world.setBlock(BlockPos.containing(x - 2, y + 4, z + 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 4, z + 2))) {
				world.setBlock(BlockPos.containing(x, y + 4, z + 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 4, z - 1))) {
				world.setBlock(BlockPos.containing(x + 1, y + 4, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 2, y + 4, z - 1))) {
				world.setBlock(BlockPos.containing(x + 2, y + 4, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 4, z - 1))) {
				world.setBlock(BlockPos.containing(x - 1, y + 4, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 2, y + 4, z - 1))) {
				world.setBlock(BlockPos.containing(x - 2, y + 4, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 4, z - 1))) {
				world.setBlock(BlockPos.containing(x, y + 4, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 4, z - 2))) {
				world.setBlock(BlockPos.containing(x + 1, y + 4, z - 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 2, y + 4, z - 2))) {
				world.setBlock(BlockPos.containing(x + 2, y + 4, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 4, z - 2))) {
				world.setBlock(BlockPos.containing(x - 1, y + 4, z - 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 2, y + 4, z - 2))) {
				world.setBlock(BlockPos.containing(x - 2, y + 4, z - 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 4, z - 2))) {
				world.setBlock(BlockPos.containing(x, y + 4, z - 2), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 8, z - 0))) {
				world.setBlock(BlockPos.containing(x, y + 8, z - 0), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 7, z - 1))) {
				world.setBlock(BlockPos.containing(x, y + 7, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 7, z + 1))) {
				world.setBlock(BlockPos.containing(x, y + 7, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 7, z + 0))) {
				world.setBlock(BlockPos.containing(x + 1, y + 7, z + 0), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 7, z + 0))) {
				world.setBlock(BlockPos.containing(x - 1, y + 7, z + 0), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 6, z - 1))) {
				world.setBlock(BlockPos.containing(x, y + 6, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 6, z + 1))) {
				world.setBlock(BlockPos.containing(x, y + 6, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 6, z + 0))) {
				world.setBlock(BlockPos.containing(x + 1, y + 6, z + 0), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 6, z + 0))) {
				world.setBlock(BlockPos.containing(x - 1, y + 6, z + 0), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 5, z - 1))) {
				world.setBlock(BlockPos.containing(x, y + 5, z - 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y + 5, z + 1))) {
				world.setBlock(BlockPos.containing(x, y + 5, z + 1), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 5, z + 0))) {
				world.setBlock(BlockPos.containing(x + 1, y + 5, z + 0), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 5, z + 0))) {
				world.setBlock(BlockPos.containing(x - 1, y + 5, z + 0), GoodblockModBlocks.PALE_WOOD_LEAVES.get().defaultBlockState(), 3);
			}
		}
	}
}
