package net.hhdsj.goodblock.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.hhdsj.goodblock.init.GoodblockModBlocks;

public class Paletreespa1DangPiLinFangKuaiGengXinShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y - 1, z))) == Blocks.VOID_AIR.defaultBlockState() || (world.getBlockState(new BlockPos(x, y - 1, z))) == Blocks.AIR.defaultBlockState()) {
			world.levelEvent(2001, new BlockPos(x, y, z), Block.getId(GoodblockModBlocks.PALETREESPA_1.get().defaultBlockState()));
			{
				BlockPos _pos = new BlockPos(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}
