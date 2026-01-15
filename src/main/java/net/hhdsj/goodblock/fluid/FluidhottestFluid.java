
package net.hhdsj.goodblock.fluid;

import net.ltxprogrammer.changed.entity.LatexType;
import net.ltxprogrammer.changed.init.ChangedTransfurVariants;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.BlockPos;

import net.hhdsj.goodblock.init.GoodblockModParticleTypes;
import net.hhdsj.goodblock.init.GoodblockModItems;
import net.hhdsj.goodblock.init.GoodblockModFluids;
import net.hhdsj.goodblock.init.GoodblockModBlocks;

import java.util.List;

public abstract class FluidhottestFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(GoodblockModFluids.FLUIDHOTTEST, GoodblockModFluids.FLOWING_FLUIDHOTTEST,
			FluidAttributes.builder(new ResourceLocation("goodblock:blocks/hot_fluid_0"), new ResourceLocation("goodblock:blocks/hot_fluid_1")).luminosity(15)

	).explosionResistance(100f)

			.tickRate(50).levelDecreasePerBlock(2)

			.bucket(GoodblockModItems.FLUIDHOTTEST_BUCKET).block(() -> (LiquidBlock) GoodblockModBlocks.FLUIDHOTTEST.get());

	private FluidhottestFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (GoodblockModParticleTypes.PARHOTX.get());
	}

	@Override
	public Vec3 getFlow(BlockGetter world, BlockPos pos, FluidState fluidstate) {
		return super.getFlow(world, pos, fluidstate).scale(-0.5);
	}

	public static class Source extends FluidhottestFluid {
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

	public static class Flowing extends FluidhottestFluid {
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
