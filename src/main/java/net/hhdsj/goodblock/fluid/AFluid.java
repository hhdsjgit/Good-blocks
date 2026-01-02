
package net.hhdsj.goodblock.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

import net.hhdsj.goodblock.init.GoodblockModItems;
import net.hhdsj.goodblock.init.GoodblockModFluids;
import net.hhdsj.goodblock.init.GoodblockModBlocks;

public abstract class AFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(GoodblockModFluids.A, GoodblockModFluids.FLOWING_A,
			FluidAttributes.builder(new ResourceLocation("goodblock:blocks/pale_tree"), new ResourceLocation("goodblock:blocks/pale_tree"))

	).explosionResistance(100f)

			.bucket(GoodblockModItems.A_BUCKET).block(() -> (LiquidBlock) GoodblockModBlocks.A.get());

	private AFluid() {
		super(PROPERTIES);
	}

	public static class Source extends AFluid {
		public Source() {
			super();
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends AFluid {
		public Flowing() {
			super();
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
