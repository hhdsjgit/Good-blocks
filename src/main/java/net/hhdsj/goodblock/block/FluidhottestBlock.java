
package net.hhdsj.goodblock.block;

import net.minecraft.world.level.material.MapColor;
import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.hhdsj.goodblock.procedures.FluidhottestDangShengWuWanJiaPengZhuangFangKuaiShiProcedure;
import net.hhdsj.goodblock.init.GoodblockModFluids;

public class FluidhottestBlock extends LiquidBlock {
	public FluidhottestBlock() {
		super(() -> (FlowingFluid) GoodblockModFluids.FLUIDHOTTEST.get(),
				BlockBehaviour.Properties.of().strength(100f).mapColor(MapColor.TERRACOTTA_ORANGE).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 15));
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		FluidhottestDangShengWuWanJiaPengZhuangFangKuaiShiProcedure.execute(entity);
	}
}
