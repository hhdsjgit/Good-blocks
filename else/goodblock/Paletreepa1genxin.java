package net.hhdsj.goodblock.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.hhdsj.goodblock.init.GoodblockModBlocks;
/*
public class Paletreepa1genxin {

    private static final int TRUNK_HEIGHT = 7;
    private static final int LEAF_LAYER_START = 3;
    private static final int LEAF_RADIUS = 2;
    private static final double GENERATION_CHANCE = 0.3;


    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (Math.random() > GENERATION_CHANCE) {
            return;
        }

        if (hasVerticalSpace(world, x, y, z, TRUNK_HEIGHT)) {
            generateTrunk(world, x, y, z);
            generateLeaves(world, x, y + LEAF_LAYER_START, z);
        }
    }


    private static boolean hasVerticalSpace(LevelAccessor world, double x, double baseY, double z, int height) {
        for (int i = 0; i <= height; i++) {
            if (!world.isEmptyBlock(new BlockPos(x, baseY + i, z))) {
                return false;
            }
        }
        return true;
    }

    private static void generateTrunk(LevelAccessor world, double x, double y, double z) {
        for (int i = 0; i <= TRUNK_HEIGHT; i++) {
            setBlockIfEmpty(world, x, y + i, z, GoodblockModBlocks.PALE_WOOD_LOG.get());
        }
    }

    private static void generateLeaves(LevelAccessor world, double centerX, double centerY, double centerZ) {
        generateLeafLayer(world, centerX, centerY, centerZ, 1);
        generateLeafLayer(world, centerX, centerY + 1, centerZ, 2);
        setBlockIfEmpty(world, centerX, centerY + 5, centerZ, GoodblockModBlocks.PALE_WOOD_LEAVES.get());
        generateVerticalLeafRing(world, centerX, centerY, centerZ, 1, 4, 6);
    }

    private static void generateLeafLayer(LevelAccessor world, double centerX, double centerY, double centerZ, int radius) {
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                if (dx * dx + dz * dz <= radius * radius) {
                    setBlockIfEmpty(world, centerX + dx, centerY, centerZ + dz, 
                                  GoodblockModBlocks.PALE_WOOD_LEAVES.get());
                }
            }
        }
    }

    private static void generateVerticalLeafRing(LevelAccessor world, double centerX, double baseY, double centerZ, 
                                              int radius, int startHeight, int endHeight) {
        for (int yOffset = startHeight; yOffset <= endHeight; yOffset++) {
            for (int i = 0; i < 4; i++) {
                double angle = i * Math.PI / 2;
                int dx = (int) Math.round(Math.cos(angle) * radius);
                int dz = (int) Math.round(Math.sin(angle) * radius);
                setBlockIfEmpty(world, centerX + dx, baseY + yOffset, centerZ + dz,
                               GoodblockModBlocks.PALE_WOOD_LEAVES.get());
            }
        }
    }

    private static void setBlockIfEmpty(LevelAccessor world, double x, double y, double z, Block block) {
        BlockPos pos = new BlockPos(x, y, z);
        if (world.isEmptyBlock(pos)) {
            world.setBlock(pos, block.defaultBlockState(), 3);
        }
    }
}*/