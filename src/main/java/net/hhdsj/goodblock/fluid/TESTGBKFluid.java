
package net.hhdsj.goodblock.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.Rarity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.BlockPos;

import net.hhdsj.goodblock.init.GoodblockModItems;
import net.hhdsj.goodblock.init.GoodblockModFluids;
import net.hhdsj.goodblock.init.GoodblockModBlocks;
import net.hhdsj.goodblock.fluid.attributes.TESTGBKFluidAttributes;

public abstract class TESTGBKFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(GoodblockModFluids.TESTGBK, GoodblockModFluids.FLOWING_TESTGBK,
			TESTGBKFluidAttributes.builder(new ResourceLocation("goodblock:blocks/black_block"), new ResourceLocation("goodblock:blocks/black_block"))

					.density(-1000)

					.gaseous().rarity(Rarity.EPIC).color(-4138753))
			.explosionResistance(100f)

			.tickRate(1)

			.bucket(GoodblockModItems.TESTGBK_BUCKET).block(() -> (LiquidBlock) GoodblockModBlocks.TESTGBK.get());

	private TESTGBKFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.EXPLOSION;
	}

	@Override
	public Vec3 getFlow(BlockGetter world, BlockPos pos, FluidState fluidstate) {
		return super.getFlow(world, pos, fluidstate).scale(4);
	}

	public static class Source extends TESTGBKFluid {
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

	public static class Flowing extends TESTGBKFluid {
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
