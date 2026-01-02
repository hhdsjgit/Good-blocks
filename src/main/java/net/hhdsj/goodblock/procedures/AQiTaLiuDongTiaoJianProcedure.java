package net.hhdsj.goodblock.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.hhdsj.goodblock.init.GoodblockModBlocks;

import java.util.Random;

public class AQiTaLiuDongTiaoJianProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double AZ = 0;
		double AX = 0;
		double AY = 0;
		for (int index0 = 0; index0 < (int) (8); index0++) {
			AZ = z + Mth.nextInt(new Random(), -1, 1);
			AX = x + Mth.nextInt(new Random(), -1, 1);
			AY = y + Mth.nextInt(new Random(), -1, 1);
			if ((world.getBlockState(new BlockPos(AX, AZ, AY))).getBlock() == Blocks.AIR) {
				sx = -3;
				found = false;
				for (int index1 = 0; index1 < (int) (6); index1++) {
					sy = -3;
					for (int index2 = 0; index2 < (int) (6); index2++) {
						sz = -3;
						for (int index3 = 0; index3 < (int) (6); index3++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == GoodblockModBlocks.A.get()) {
								found = true;
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
				if (found == true) {
					world.setBlock(new BlockPos(AX, AY, AZ), GoodblockModBlocks.A.get().defaultBlockState(), 3);
				}
			}
		}
	}
}
