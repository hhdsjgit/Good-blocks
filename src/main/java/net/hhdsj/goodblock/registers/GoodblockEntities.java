package net.hhdsj.goodblock.registers;

import net.ltxprogrammer.changed.init.ChangedMobCategories;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.hhdsj.goodblock.entity.*;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import net.minecraftforge.registries.ForgeRegistries;

import net.hhdsj.goodblock.entity.*;
import net.hhdsj.goodblock.GoodblockMod;
import net.hhdsj.goodblock.entity.LatexthreemonthwolfEntityProjectile;
import net.hhdsj.goodblock.entity.LatexDragonFruitWolfEntity;

import static net.ltxprogrammer.changed.entity.variant.TransfurVariant.getNextEntId;




@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodblockEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, GoodblockMod.MODID);

	public static final RegistryObject<EntityType<LatexkamonaHSguydragonwolfEntity>> LATEX_KAMONA_HSGUY_DRAGON_WOLF = register("latex_kamona_hsguy_dragon_wolf",
			EntityType.Builder.<LatexkamonaHSguydragonwolfEntity>of(LatexkamonaHSguydragonwolfEntity::new, ChangedMobCategories.CHANGED)
					.setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64)
					.setUpdateInterval(3)
					.setCustomClientFactory(LatexkamonaHSguydragonwolfEntity::new)
					.sized(0.7f, 1.93f));

	public static final RegistryObject<EntityType<LatexDragonFruitWolfEntity>> LATEXDRAGONFRUITWOLF = register("latex_dragon_fruit_wolf",
			EntityType.Builder.<LatexDragonFruitWolfEntity>of(LatexDragonFruitWolfEntity::new, ChangedMobCategories.CHANGED)
					.setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64)
					.setUpdateInterval(3)
					.setCustomClientFactory(LatexDragonFruitWolfEntity::new)
					.sized(0.7f, 1.93f));

	//////////////////else///////////////////
	public static final RegistryObject<EntityType<LatexthreemonthwolfEntityProjectile>> LATEXTHREEMONTHWOLF_PROJECTILE = register("projectile_latexthreemonthwolf",
			EntityType.Builder.<LatexthreemonthwolfEntityProjectile>of(LatexthreemonthwolfEntityProjectile::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1)
					.setCustomClientFactory(LatexthreemonthwolfEntityProjectile::new).sized(0.5f, 0.5f));


	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			LatexkamonaHSguydragonwolfEntity.init();
			LatexDragonFruitWolfEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(LATEX_KAMONA_HSGUY_DRAGON_WOLF.get(), LatexkamonaHSguydragonwolfEntity.createAttributes().build());
		event.put(LATEXDRAGONFRUITWOLF.get(), LatexDragonFruitWolfEntity.createAttributes().build());
	}
}
/*
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodblockEntities extends GoodblockModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, GoodblockMod.MODID);


    public static final RegistryObject<EntityType<LatexkamonaHSguydragonwolfEntity>> LATEX_KAMONA_HSGUY_DRAGON_WOLF = 
        register("LATEX_KAMONA_HSGUY_DRAGON_WOLF",
            EntityType.Builder.of(LatexkamonaHSguydragonwolfEntity::new, ChangedMobCategories.CHANGED)
                .sized(0.7F, 1.93F)
                .clientTrackingRange(10),GoodblockEntities::overworldOnly,SpawnPlacements.Type.ON_GROUND,Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,LatexkamonaHSguydragonwolfEntity::checkEntitySpawnRules);












    private static <T extends Entity> RegistryObject<EntityType<T>> register(
        String registryname, 
        EntityType.Builder<T> entityTypeBuilder,
        BiConsumer<EntityType<T>, ForgeEventBus> spawnConfig,
        SpawnPlacements.Type placementType,
        Heightmap.Types heightmapType,
        SpawnPlacements.SpawnPredicate<T> spawnPredicate) {
        
        RegistryObject<EntityType<T>> registryObject = REGISTRY.register(registryname, 
            () -> entityTypeBuilder.build(registryname));
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener((FMLCommonSetupEvent event) -> {
            event.enqueueWork(() -> {
                spawnConfig.accept(registryObject.get(), FMLJavaModLoadingContext.get().getModEventBus());
                SpawnPlacements.register(registryObject.get(), placementType, heightmapType, spawnPredicate);
            });
        });
        
        return registryObject;
    }
}*/

/*
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class GoodblockEntities extends GoodblockModEntities{

	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, GoodblockMod.MODID);


        
	public static final RegistryObject<LatexkamonaHSguydragonwolfEntity>> LATEX_KAMONA_HSGUY_DRAGON_WOLF = register("LATEX_KAMONA_HSGUY_DRAGON_WOLF",
            EntityType.Builder.<LatexfoxEntity>of(LatexkamonaHSguydragonwolfEntity::new, ChangedMobCategories.CHANGED)
            .clientTrackingRange(10),   
            GoodblockEntities::overworldOnly, SpawnPlacements.Type.ON_GROUND, LatexPurpleFox::checkEntitySpawnRules),
            .sized(0.7F, 1.93F));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
    }
}



*/
















/*
public static final RegistryObject<EntityType<SnowLeopardPartialEntity>> SNOW_LEOPARD_PARTIAL = register("latex_snow_leopard_partial",
            EntityType.Builder.<SnowLeopardPartialEntity>of(SnowLeopardPartialEntity::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64).setUpdateInterval(3)*/
