package net.hhdsj.goodblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.hhdsj.goodblock.block.UraniummineralBlock;
import net.hhdsj.goodblock.block.UraniumblockBlock;
import net.hhdsj.goodblock.block.SulphurblockBlock;
import net.hhdsj.goodblock.block.Paletreespa1Block;
import net.hhdsj.goodblock.block.Pale_woodWoodBlock;
import net.hhdsj.goodblock.block.Pale_woodStairsBlock;
import net.hhdsj.goodblock.block.Pale_woodSlabBlock;
import net.hhdsj.goodblock.block.Pale_woodPressurePlateBlock;
import net.hhdsj.goodblock.block.Pale_woodPlanksBlock;
import net.hhdsj.goodblock.block.Pale_woodLogBlock;
import net.hhdsj.goodblock.block.Pale_woodLeavesBlock;
import net.hhdsj.goodblock.block.Pale_woodFenceGateBlock;
import net.hhdsj.goodblock.block.Pale_woodFenceBlock;
import net.hhdsj.goodblock.block.Pale_woodButtonBlock;
import net.hhdsj.goodblock.block.NitreblockBlock;
import net.hhdsj.goodblock.block.IronhotBlock;
import net.hhdsj.goodblock.block.FluidhottestBlock;
import net.hhdsj.goodblock.block.CatalyzerBlock;
import net.hhdsj.goodblock.block.BlueblockBlock;
import net.hhdsj.goodblock.block.BlueCrystaloreBlock;
import net.hhdsj.goodblock.block.Blockbw2Block;
import net.hhdsj.goodblock.block.Blockbw1Block;
import net.hhdsj.goodblock.block.BlackblockBlock;
import net.hhdsj.goodblock.GoodblockMod;

public class GoodblockModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, GoodblockMod.MODID);
	public static final RegistryObject<Block> SULPHURBLOCK = REGISTRY.register("sulphurblock", SulphurblockBlock::new);
	public static final RegistryObject<Block> NITREBLOCK = REGISTRY.register("nitreblock", NitreblockBlock::new);
	public static final RegistryObject<Block> URANIUMMINERAL = REGISTRY.register("uraniummineral", UraniummineralBlock::new);
	public static final RegistryObject<Block> PALE_WOOD_PLANKS = REGISTRY.register("pale_wood_planks", Pale_woodPlanksBlock::new);
	public static final RegistryObject<Block> PALE_WOOD_LEAVES = REGISTRY.register("pale_wood_leaves", Pale_woodLeavesBlock::new);
	public static final RegistryObject<Block> PALE_WOOD_LOG = REGISTRY.register("pale_wood_log", Pale_woodLogBlock::new);
	public static final RegistryObject<Block> PALE_WOOD_WOOD = REGISTRY.register("pale_wood_wood", Pale_woodWoodBlock::new);
	public static final RegistryObject<Block> URANIUMBLOCK = REGISTRY.register("uraniumblock", UraniumblockBlock::new);
	public static final RegistryObject<Block> BLUEBLOCK = REGISTRY.register("blueblock", BlueblockBlock::new);
	public static final RegistryObject<Block> IRONHOT = REGISTRY.register("ironhot", IronhotBlock::new);
	public static final RegistryObject<Block> PALE_WOOD_STAIRS = REGISTRY.register("pale_wood_stairs", Pale_woodStairsBlock::new);
	public static final RegistryObject<Block> PALE_WOOD_SLAB = REGISTRY.register("pale_wood_slab", Pale_woodSlabBlock::new);
	public static final RegistryObject<Block> PALE_WOOD_BUTTON = REGISTRY.register("pale_wood_button", Pale_woodButtonBlock::new);
	public static final RegistryObject<Block> PALETREESPA_1 = REGISTRY.register("paletreespa_1", Paletreespa1Block::new);
	public static final RegistryObject<Block> BLACKBLOCK = REGISTRY.register("blackblock", BlackblockBlock::new);
	public static final RegistryObject<Block> PALE_WOOD_FENCE = REGISTRY.register("pale_wood_fence", Pale_woodFenceBlock::new);
	public static final RegistryObject<Block> PALE_WOOD_FENCE_GATE = REGISTRY.register("pale_wood_fence_gate", Pale_woodFenceGateBlock::new);
	public static final RegistryObject<Block> PALE_WOOD_PRESSURE_PLATE = REGISTRY.register("pale_wood_pressure_plate", Pale_woodPressurePlateBlock::new);
	public static final RegistryObject<Block> BLOCKBW_1 = REGISTRY.register("blockbw_1", Blockbw1Block::new);
	public static final RegistryObject<Block> BLOCKBW_2 = REGISTRY.register("blockbw_2", Blockbw2Block::new);
	public static final RegistryObject<Block> BLUE_CRYSTALORE = REGISTRY.register("blue_crystalore", BlueCrystaloreBlock::new);
	public static final RegistryObject<Block> CATALYZER = REGISTRY.register("catalyzer", CatalyzerBlock::new);
	public static final RegistryObject<Block> FLUIDHOTTEST = REGISTRY.register("fluidhottest", FluidhottestBlock::new);

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			BlueblockBlock.registerRenderLayer();
			IronhotBlock.registerRenderLayer();
			Paletreespa1Block.registerRenderLayer();
		}
	}
}
