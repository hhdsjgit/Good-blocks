
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.hhdsj.goodblock.entity.LatexiceDragonEntity;
import net.hhdsj.goodblock.entity.LatexgreendragonEntity;
import net.hhdsj.goodblock.entity.LatexfoxEntity;
import net.hhdsj.goodblock.entity.LatexOrangeFoxEntity;
import net.hhdsj.goodblock.entity.LatexKcahraSharkEntity;
import net.hhdsj.goodblock.entity.DarkfuLatexWolfMaleEntity;
import net.hhdsj.goodblock.GoodblockMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodblockModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, GoodblockMod.MODID);
	public static final RegistryObject<EntityType<LatexfoxEntity>> LATEXFOX = register("latexfox",
			EntityType.Builder.<LatexfoxEntity>of(LatexfoxEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexfoxEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LatexOrangeFoxEntity>> LATEX_ORANGE_FOX = register("latex_orange_fox",
			EntityType.Builder.<LatexOrangeFoxEntity>of(LatexOrangeFoxEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexOrangeFoxEntity::new)

					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<LatexKcahraSharkEntity>> LATEX_KCAHRA_SHARK = register("latex_kcahra_shark",
			EntityType.Builder.<LatexKcahraSharkEntity>of(LatexKcahraSharkEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexKcahraSharkEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LatexgreendragonEntity>> LATEXGREENDRAGON = register("latexgreendragon",
			EntityType.Builder.<LatexgreendragonEntity>of(LatexgreendragonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexgreendragonEntity::new)

					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<DarkfuLatexWolfMaleEntity>> DARKFU_LATEX_WOLF_MALE = register("darkfu_latex_wolf_male",
			EntityType.Builder.<DarkfuLatexWolfMaleEntity>of(DarkfuLatexWolfMaleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DarkfuLatexWolfMaleEntity::new)

					.sized(0.6f, 1.99f));
	public static final RegistryObject<EntityType<LatexiceDragonEntity>> LATEXICE_DRAGON = register("latexice_dragon",
			EntityType.Builder.<LatexiceDragonEntity>of(LatexiceDragonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexiceDragonEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			LatexfoxEntity.init();
			LatexOrangeFoxEntity.init();
			LatexKcahraSharkEntity.init();
			LatexgreendragonEntity.init();
			DarkfuLatexWolfMaleEntity.init();
			LatexiceDragonEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(LATEXFOX.get(), LatexfoxEntity.createAttributes().build());
		event.put(LATEX_ORANGE_FOX.get(), LatexOrangeFoxEntity.createAttributes().build());
		event.put(LATEX_KCAHRA_SHARK.get(), LatexKcahraSharkEntity.createAttributes().build());
		event.put(LATEXGREENDRAGON.get(), LatexgreendragonEntity.createAttributes().build());
		event.put(DARKFU_LATEX_WOLF_MALE.get(), DarkfuLatexWolfMaleEntity.createAttributes().build());
		event.put(LATEXICE_DRAGON.get(), LatexiceDragonEntity.createAttributes().build());
	}
}
