package net.hhdsj.goodblock.init;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.behavior.GoOutsideToCelebrate;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.event.IModBusEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

import net.ltxprogrammer.changed.*;
import net.ltxprogrammer.changed.ability.*;
import net.ltxprogrammer.changed.entity.*;
import net.ltxprogrammer.changed.entity.beast.*;
import net.ltxprogrammer.changed.init.*;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.ltxprogrammer.changed.util.*;
import net.ltxprogrammer.changed.entity.variant.*;

import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.init.ChangedAddonAbilities;
//import net.foxyas.changedaddon.entity.*;
import net.foxyas.changedaddon.entity.advanced.AvaliEntity;
import net.foxyas.changedaddon.entity.advanced.LatexKitsuneFemaleEntity;
import net.foxyas.changedaddon.entity.advanced.LatexKitsuneMaleEntity;
import net.foxyas.changedaddon.entity.simple.LatexCalicoCatEntity;
import net.foxyas.changedaddon.init.ChangedAddonEntities;
//import net.foxyas.changedaddon.registers.ChangedAddonEntities;

import com.mojang.datafixers.util.Pair;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.hhdsj.goodblock.GoodblockMod;
import net.hhdsj.goodblock.entity.*;
import net.hhdsj.goodblock.registers.GoodblockEntities;


public class GoodblockModTransfurVariants {
    public static final DeferredRegister<TransfurVariant<?>> REGISTRY = ChangedRegistry.TRANSFUR_VARIANT.createDeferred("goodblock");

    
	/* Test latex
    public static final RegistryObject<TransfurVariant<LatexfoxEntity>> LATEXFOX = REGISTRY.register("from_latex_fox",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXFOX)
	    .stepSize(0.7f)
	    .build());
	*/

    public static final RegistryObject<TransfurVariant<LatexOrangeFoxEntity>> LATEX_ORANGE_FOX = REGISTRY.register("from_orange_fox",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_ORANGE_FOX)
	    .stepSize(0.7f)
	    .nightVision()
	    .transfurMode(TransfurMode.ABSORPTION)
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .build());

	public static final RegistryObject<TransfurVariant<LatexKcahraSharkEntity>> LATEX_KCAHRA_SHARK = REGISTRY.register("from_latex_kcahra_shark",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEX_KCAHRA_SHARK)
	    .stepSize(0.7f)
	    .gills()
	    .breatheMode(TransfurVariant.BreatheMode.ANY)
	    .transfurMode(TransfurMode.ABSORPTION)
	    .replicating()
	    .build());

	public static final RegistryObject<TransfurVariant<LatexgreendragonEntity>> LATEXGREENDRAGON = REGISTRY.register("from_green_dragon",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXGREENDRAGON)
	    .stepSize(0.7f)
	    .glide()
	    .addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
	    //.breatheMode(TransfurVariant.BreatheMode.NORMAL)
	    .addAbility(() -> ChangedAbilities.SWITCH_TRANSFUR_MODE.get())
	    .transfurMode(TransfurMode.ABSORPTION)
	    .replicating()
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .build());

	public static final RegistryObject<TransfurVariant<DarkfuLatexWolfMaleEntity>> DARKFU_LATEX_WOLF_MALE = REGISTRY.register("from_darkfu_latex_wolf_male",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.DARKFU_LATEX_WOLF_MALE)
	    .stepSize(0.7f)
	    .faction(LatexType.DARK_LATEX)
	    .breatheMode(TransfurVariant.BreatheMode.NORMAL)
	    .transfurMode(TransfurMode.ABSORPTION)
	    .addAbility(() -> ChangedAbilities.SWITCH_TRANSFUR_MODE.get())
	    .replicating()
	    .build());

	public static final RegistryObject<TransfurVariant<LatexiceDragonEntity>> LATEXICE_DRAGON = REGISTRY.register("from_latex_ice_dragon",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXICE_DRAGON)
	    .stepSize(0.7f)
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .addAbility(() -> ChangedAbilities.SWITCH_TRANSFUR_MODE.get())
	    .replicating()
	    .build());

	public static final RegistryObject<TransfurVariant<InksugerEntity>> INKSUGER = REGISTRY.register("from_ink_suger",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.INKSUGER)
	    .stepSize(0.7f)
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .transfurMode(TransfurMode.ABSORPTION)
	    .holdItemsInMouth()
	    .reducedFall()
	    .build());
	
	public static final RegistryObject<TransfurVariant<LatexkamonaHSguydragonwolfEntity>> LATEXKAMONA_H_SGUYDRAGONWOLF = REGISTRY.register("from_latex_kamona_hsguy_dragon_wolf",
    () -> TransfurVariant.Builder.of(GoodblockEntities.LATEXKAMONA_H_SGUYDRAGONWOLF)
	    .stepSize(0.7f)
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .transfurMode(TransfurMode.ABSORPTION)
	    .addAbility(() -> ChangedAbilities.SWITCH_TRANSFUR_MODE.get())
	    .replicating()
	    .build());	

	public static final RegistryObject<TransfurVariant<BlackpupmaleEntity>> BLACKPUPMALE = REGISTRY.register("from_black_pup",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.BLACKPUPMALE)
	    .stepSize(0.7f)
	    .nightVision()
	    .transfurMode(TransfurMode.NONE)
	    .holdItemsInMouth()
	    .reducedFall()
	    .build());

	public static final RegistryObject<TransfurVariant<WhitebluepupEntity>> WHITEBLUEPUP = REGISTRY.register("from_white_blue_pup",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.WHITEBLUEPUP)
	    .stepSize(0.7f)
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .transfurMode(TransfurMode.NONE)
	    .holdItemsInMouth()
	    .reducedFall()
	    .build());

	public static final RegistryObject<TransfurVariant<LatexpurplewswolfEntity>> LATEXPURPLEWSWOLF = REGISTRY.register("from_latex_purplews_wolf",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXPURPLEWSWOLF)
	    .stepSize(0.7f)
		.breatheMode(TransfurVariant.BreatheMode.WEAK)
		.reducedFall()
		.scares(Creeper.class)
		.nightVision()
		.addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
		.jumpStrength(2f)
	    .build());
	    //LATEXYUNXQHOTDRAGON

	public static final RegistryObject<TransfurVariant<LatexyunxqhotdragonEntity>> LATEXYUNXQHOTDRAGON = REGISTRY.register("from_latex_yunxq_hot_dragon",
    () -> TransfurVariant.Builder.of(GoodblockModEntities.LATEXYUNXQHOTDRAGON)
	    .stepSize(0.7f)
	    .glide()
	    .addAbility(entityType -> ChangedAddonAbilities.WING_FLAP_ABILITY.get())
	    .addAbility(() -> ChangedAbilities.SWITCH_TRANSFUR_MODE.get())
	    .transfurMode(TransfurMode.ABSORPTION)
	    .replicating()
	    .nightVision()
	    .addAbility(ChangedAbilities.TOGGLE_NIGHT_VISION)
	    .build());
	    
	public static void register(IEventBus bus) {
        REGISTRY.register(bus);
    }


}












