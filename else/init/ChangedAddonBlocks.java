package net.foxyas.changedaddon.init;

import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.block.*;
import net.foxyas.changedaddon.block.advanced.HandScanner;
import net.foxyas.changedaddon.block.advanced.PawsScanner;
import net.foxyas.changedaddon.block.advanced.TimedKeypad;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangedAddonBlocks {

    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ChangedAddonMod.MODID);

    public static final RegistryObject<Block> LATEX_INSULATOR = REGISTRY.register("latex_insulator", LatexInsulatorBlock::new);
    public static final RegistryObject<Block> IRIDIUM_ORE = REGISTRY.register("iridium_ore", IridiumOreBlock::new);
    public static final RegistryObject<Block> IRIDIUM_BLOCK = REGISTRY.register("iridium_block", IridiumBlock::new);
    public static final RegistryObject<Block> DEEPSLATE_PAINITE_ORE = REGISTRY.register("deepslate_painite_ore", DeepslatePainiteOreBlock::new);
    public static final RegistryObject<Block> PAINITE_BLOCK = REGISTRY.register("painite_block", PainiteBlock::new);
    public static final RegistryObject<LiquidBlock> LITIX_CAMONIA_FLUID = REGISTRY.register("litix_camonia_fluid", LitixCamoniaFluidBlock::new);
    public static final RegistryObject<CatalyzerBlock> CATALYZER = REGISTRY.register("catalyzer", CatalyzerBlock::new);
    public static final RegistryObject<UnifuserBlock> UNIFUSER = REGISTRY.register("unifuser", UnifuserBlock::new);
    public static final RegistryObject<DarkLatexPuddleBlock> DARK_LATEX_PUDDLE = REGISTRY.register("dark_latex_puddle", DarkLatexPuddleBlock::new);
    public static final RegistryObject<Block> SIGNAL_BLOCK = REGISTRY.register("signal_block", SignalBlockBlock::new);
    public static final RegistryObject<InformantBlock> INFORMANT_BLOCK = REGISTRY.register("informant_block", InformantBlock::new);
    public static final RegistryObject<Block> DORMANT_DARK_LATEX = REGISTRY.register("dormant_dark_latex", DormantDarkLatexBlock::new);
    public static final RegistryObject<Block> DORMANT_WHITE_LATEX = REGISTRY.register("dormant_white_latex", DormantWhiteLatexBlock::new);
    public static final RegistryObject<Block> SNEP_PLUSH = REGISTRY.register("snep_plush", SnepPlushBlock::new);
    public static final RegistryObject<WolfPlushBlock> WOLF_PLUSH = REGISTRY.register("wolf_plush", WolfPlushBlock::new);
    public static final RegistryObject<Block> CONTAINMENT_CONTAINER = REGISTRY.register("containment_container", ContainmentContainerBlock::new);
    public static final RegistryObject<AdvancedUnifuserBlock> ADVANCED_UNIFUSER = REGISTRY.register("advanced_unifuser", AdvancedUnifuserBlock::new);
    public static final RegistryObject<AdvancedCatalyzerBlock> ADVANCED_CATALYZER = REGISTRY.register("advanced_catalyzer", AdvancedCatalyzerBlock::new);
    public static final RegistryObject<Block> REINFORCED_WALL = REGISTRY.register("reinforced_wall", ReinforcedWallBlock::new);
    public static final RegistryObject<Block> REINFORCED_WALL_SILVER_STRIPED = REGISTRY.register("reinforced_wall_silver_striped", ReinforcedSilverStripedWallBlock::new);
    public static final RegistryObject<Block> REINFORCED_WALL_SILVER_TILED = REGISTRY.register("reinforced_wall_silver_tiled", ReinforcedWallSilverTiledBlock::new);
    public static final RegistryObject<Block> REINFORCED_WALL_CAUTION = REGISTRY.register("reinforced_wall_caution", ReinforcedWallCautionBlock::new);
    public static final RegistryObject<Block> REINFORCED_CROSS_BLOCK = REGISTRY.register("reinforced_cross_block", ReinforcedCrossBlock::new);
    public static final RegistryObject<Block> WALL_WHITE_CRACKED = REGISTRY.register("wall_white_cracked", WallWhiteCrackedBlock::new);
    //public static final RegistryObject<Block> WALL_WHITE_STAIR = REGISTRY.register("wall_white_stair", WallWhiteStairBlock::new);
    //public static final RegistryObject<Block> WALL_WHITE_SLAB = REGISTRY.register("wall_white_slab", WallWhiteSlabBlock::new);
    public static final RegistryObject<Block> BLUE_WOLF_CRYSTAL_BLOCK = REGISTRY.register("blue_wolf_crystal_block", BlueWolfCrystalBlockBlock::new);
    public static final RegistryObject<Block> ORANGE_WOLF_CRYSTAL_BLOCK = REGISTRY.register("orange_wolf_crystal_block", OrangeWolfCrystalBlockBlock::new);
    public static final RegistryObject<Block> YELLOW_WOLF_CRYSTAL_BLOCK = REGISTRY.register("yellow_wolf_crystal_block", YellowWolfCrystalBlockBlock::new);
    public static final RegistryObject<Block> WHITE_WOLF_CRYSTAL_BLOCK = REGISTRY.register("white_wolf_crystal_block", WhiteWolfCrystalBlockBlock::new);
    public static final RegistryObject<Block> LUMINAR_CRYSTAL_BLOCK = REGISTRY.register("luminar_crystal_block", LuminarCrystalBlock::new);
    public static final RegistryObject<Block> LUMINAR_CRYSTAL_SMALL = REGISTRY.register("luminar_crystal_small", LuminarCrystalSmallBlock::new);
    public static final RegistryObject<Block> YELLOW_WOLF_CRYSTAL_SMALL = REGISTRY.register("yellow_wolf_crystal_small", YellowWolfCrystalSmallBlock::new);
    public static final RegistryObject<Block> ORANGE_WOLF_CRYSTAL_SMALL = REGISTRY.register("orange_wolf_crystal_small", OrangeWolfCrystalSmallBlock::new);
    public static final RegistryObject<Block> BLUE_WOLF_CRYSTAL_SMALL = REGISTRY.register("blue_wolf_crystal_small", BlueWolfCrystalSmallBlock::new);
    public static final RegistryObject<Block> WHITE_WOLF_CRYSTAL_SMALL = REGISTRY.register("white_wolf_crystal_small", WhiteWolfCrystalSmallBlock::new);
    public static final RegistryObject<Block> GOO_CORE = REGISTRY.register("goo_core", GooCoreBlock::new);
    public static final RegistryObject<Block> GENERATOR = REGISTRY.register("generator", GeneratorBlock::new);
    public static final RegistryObject<FoxtaCanBlock> FOXTA_CAN = REGISTRY.register("foxta_can", FoxtaCanBlock::new);
    public static final RegistryObject<SnepsiCanBlock> SNEPSI_CAN = REGISTRY.register("snepsi_can", SnepsiCanBlock::new);
    public static final RegistryObject<Block> TIMED_KEYPAD = REGISTRY.register("timed_keypad", TimedKeypad::new);
    public static final RegistryObject<Block> HAND_SCANNER = REGISTRY.register("hand_scanner", HandScanner::new);
    public static final RegistryObject<Block> PAWS_SCANNER = REGISTRY.register("paws_scanner", PawsScanner::new);
    public static final RegistryObject<Block> LUMINARA_BLOOM = REGISTRY.register("luminara_bloom", LuminaraBloomFlowerBlock::new);
    public static final RegistryObject<Block> POTTED_LUMINARA_BLOOM = REGISTRY.register("potted_luminara_bloom", PottedLuminaraBloomFlowerBlock::new);

    public static final RegistryObject<WolfCrystalPillar> WOLF_CRYSTAL_PILLAR = REGISTRY.register("wolf_crystal_pillar", WolfCrystalPillar::new);

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientSideHandler {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            LatexInsulatorBlock.registerRenderLayer();
            DarkLatexPuddleBlock.registerRenderLayer();
            SignalBlockBlock.registerRenderLayer();
            SnepPlushBlock.registerRenderLayer();
            WolfPlushBlock.registerRenderLayer();
            ContainmentContainerBlock.registerRenderLayer();
            LuminarCrystalSmallBlock.registerRenderLayer();
            YellowWolfCrystalSmallBlock.registerRenderLayer();
            OrangeWolfCrystalSmallBlock.registerRenderLayer();
            BlueWolfCrystalSmallBlock.registerRenderLayer();
            WhiteWolfCrystalSmallBlock.registerRenderLayer();
            GooCoreBlock.registerRenderLayer();
            FoxtaCanBlock.registerRenderLayer();
            SnepsiCanBlock.registerRenderLayer();
            HandScanner.registerRenderLayer();
            LuminarCrystalBlock.registerRenderLayer();
            LuminaraBloomFlowerBlock.registerRenderLayer();
            PottedLuminaraBloomFlowerBlock.registerRenderLayer();
            WolfCrystalPillar.registerRenderLayer();
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CommonSideHandler {
        @SubscribeEvent
        public static void commonSetup(FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                if (LUMINARA_BLOOM.getId() != null) {
                    ((FlowerPotBlock) Blocks.FLOWER_POT)
                            .addPlant(LUMINARA_BLOOM.getId(), POTTED_LUMINARA_BLOOM);
                }
            });
        }
    }
}
