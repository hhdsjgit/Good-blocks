
package net.hhdsj.goodblock.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

import net.hhdsj.goodblock.init.GoodblockModFluids;

public class TESTGBKBlock extends LiquidBlock {
	public TESTGBKBlock() {
		super(() -> GoodblockModFluids.TESTGBK.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}
