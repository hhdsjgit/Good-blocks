
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
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
import net.hhdsj.goodblock.block.TESTGBKBlock;
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
import net.hhdsj.goodblock.block.BlueblockBlock;
import net.hhdsj.goodblock.block.Blockbw1Block;
import net.hhdsj.goodblock.block.BlackblockBlock;
import net.hhdsj.goodblock.GoodblockMod;

public class GoodblockModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, GoodblockMod.MODID);
	public static final RegistryObject<Block> SULPHURBLOCK = REGISTRY.register("sulphurblock", () -> new SulphurblockBlock());
	public static final RegistryObject<Block> NITREBLOCK = REGISTRY.register("nitreblock", () -> new NitreblockBlock());
	public static final RegistryObject<Block> URANIUMMINERAL = REGISTRY.register("uraniummineral", () -> new UraniummineralBlock());
	public static final RegistryObject<Block> PALE_WOOD_PLANKS = REGISTRY.register("pale_wood_planks", () -> new Pale_woodPlanksBlock());
	public static final RegistryObject<Block> PALE_WOOD_LEAVES = REGISTRY.register("pale_wood_leaves", () -> new Pale_woodLeavesBlock());
	public static final RegistryObject<Block> PALE_WOOD_LOG = REGISTRY.register("pale_wood_log", () -> new Pale_woodLogBlock());
	public static final RegistryObject<Block> PALE_WOOD_WOOD = REGISTRY.register("pale_wood_wood", () -> new Pale_woodWoodBlock());
	public static final RegistryObject<Block> URANIUMBLOCK = REGISTRY.register("uraniumblock", () -> new UraniumblockBlock());
	public static final RegistryObject<Block> BLUEBLOCK = REGISTRY.register("blueblock", () -> new BlueblockBlock());
	public static final RegistryObject<Block> IRONHOT = REGISTRY.register("ironhot", () -> new IronhotBlock());
	public static final RegistryObject<Block> PALE_WOOD_STAIRS = REGISTRY.register("pale_wood_stairs", () -> new Pale_woodStairsBlock());
	public static final RegistryObject<Block> PALE_WOOD_SLAB = REGISTRY.register("pale_wood_slab", () -> new Pale_woodSlabBlock());
	public static final RegistryObject<Block> PALE_WOOD_BUTTON = REGISTRY.register("pale_wood_button", () -> new Pale_woodButtonBlock());
	public static final RegistryObject<Block> PALETREESPA_1 = REGISTRY.register("paletreespa_1", () -> new Paletreespa1Block());
	public static final RegistryObject<Block> BLACKBLOCK = REGISTRY.register("blackblock", () -> new BlackblockBlock());
	public static final RegistryObject<Block> PALE_WOOD_FENCE = REGISTRY.register("pale_wood_fence", () -> new Pale_woodFenceBlock());
	public static final RegistryObject<Block> PALE_WOOD_FENCE_GATE = REGISTRY.register("pale_wood_fence_gate", () -> new Pale_woodFenceGateBlock());
	public static final RegistryObject<Block> PALE_WOOD_PRESSURE_PLATE = REGISTRY.register("pale_wood_pressure_plate", () -> new Pale_woodPressurePlateBlock());
	public static final RegistryObject<Block> TESTGBK = REGISTRY.register("testgbk", () -> new TESTGBKBlock());
	public static final RegistryObject<Block> BLOCKBW_1 = REGISTRY.register("blockbw_1", () -> new Blockbw1Block());

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
