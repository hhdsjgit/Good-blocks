
package net.hhdsj.goodblock.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;

import net.hhdsj.goodblock.init.GoodblockModFluids;

public class TESTGBKBlock extends LiquidBlock {
	public TESTGBKBlock() {
		super(() -> (FlowingFluid) GoodblockModFluids.TESTGBK.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
	}
}
