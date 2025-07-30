package net.hhdsj.goodblock.registers;
/*
import net.ltxprogrammer.changed.init.ChangedMobCategories;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.hhdsj.goodblock.entity.*;
import net.hhdsj.goodblock.init.*;

import net.ltxprogrammer.changed.*;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.LatexType;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.entity.VisionType;
import net.ltxprogrammer.changed.entity.beast.*;
import net.ltxprogrammer.changed.entity.variant.GenderedPair;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.entity.ai.behavior.GoOutsideToCelebrate;
import net.hhdsj.goodblock.registers.GoodblockEntities;
import net.minecraftforge.eventbus.api.IEventBus;

import com.mojang.datafixers.util.Pair;
import net.ltxprogrammer.changed.*;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.SeatEntity;
import net.ltxprogrammer.changed.entity.beast.*;
import net.ltxprogrammer.changed.entity.beast.boss.BehemothHandLeft;
import net.ltxprogrammer.changed.entity.beast.boss.BehemothHandRight;
import net.ltxprogrammer.changed.entity.beast.boss.BehemothHead;
import net.ltxprogrammer.changed.entity.projectile.GasParticle;
import net.ltxprogrammer.changed.entity.projectile.LatexInkball;
import net.ltxprogrammer.changed.entity.robot.Roomba;
import net.ltxprogrammer.changed.world.biome.ChangedBiomeInterface;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

import net.hhdsj.goodblock.entity.LatexfoxEntity;
import net.hhdsj.goodblock.GoodblockMod;
*/

import static net.ltxprogrammer.changed.entity.variant.TransfurVariant.getNextEntId;

/* 代码废弃
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class GoodblockEntities extends GoodblockModEntities{
//Spawning
	//public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, GoodblockMod.MODID);


        
	public static final RegistryObject<EntityType<LatexfoxEntity>> LATEX_FOX_ENTITY = register("from_latex_fox",
            EntityType.Builder.<LatexfoxEntity>of(LatexfoxEntity::new, ChangedMobCategories.CHANGED)
            .clientTrackingRange(10)
            .sized(0.7F, 1.93F));//,
            //GoodblockEntities::overworldOnly, SpawnPlacements.Type.ON_GROUND, LatexPurpleFox::checkEntitySpawnRules);

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
    }
}*/




















/*
public static final RegistryObject<EntityType<SnowLeopardPartialEntity>> SNOW_LEOPARD_PARTIAL = register("latex_snow_leopard_partial",
            EntityType.Builder.<SnowLeopardPartialEntity>of(SnowLeopardPartialEntity::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3)*/
