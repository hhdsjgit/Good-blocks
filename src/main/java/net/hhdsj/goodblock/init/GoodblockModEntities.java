
/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.entity.*;
import net.ltxprogrammer.changed.init.ChangedMobCategories;
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

import net.hhdsj.goodblock.GoodblockMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodblockModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, GoodblockMod.MODID);
	public static final RegistryObject<EntityType<LatexOrangeFoxEntity>> LATEX_ORANGE_FOX = register("latex_orange_fox",
			EntityType.Builder.<LatexOrangeFoxEntity>of(LatexOrangeFoxEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexOrangeFoxEntity::new)

					.sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<LatexKcahraSharkEntity>> LATEX_KCAHRA_SHARK = register("latex_kcahra_shark",
			EntityType.Builder.<LatexKcahraSharkEntity>of(LatexKcahraSharkEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexKcahraSharkEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DarkfuLatexWolfMaleEntity>> DARKFU_LATEX_WOLF_MALE = register("darkfu_latex_wolf_male",
			EntityType.Builder.<DarkfuLatexWolfMaleEntity>of(DarkfuLatexWolfMaleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DarkfuLatexWolfMaleEntity::new)

					.sized(0.6f, 1.99f));
	public static final RegistryObject<EntityType<LatexiceDragonEntity>> LATEXICE_DRAGON = register("latex_ice_dragon",
			EntityType.Builder.<LatexiceDragonEntity>of(LatexiceDragonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexiceDragonEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<InksugerEntity>> INKSUGER = register("inksuger",
			EntityType.Builder.<InksugerEntity>of(InksugerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InksugerEntity::new)

					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<BlackpupmaleEntity>> BLACKPUPMALE = register("blackpupmale",
			EntityType.Builder.<BlackpupmaleEntity>of(BlackpupmaleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlackpupmaleEntity::new)

					.sized(0.4f, 0.7f));
	public static final RegistryObject<EntityType<WhitebluepupEntity>> WHITEBLUEPUP = register("whitebluepup",
			EntityType.Builder.<WhitebluepupEntity>of(WhitebluepupEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WhitebluepupEntity::new)

					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<LatexpurplewswolfEntity>> LATEXPURPLEWSWOLF = register("latexpurplewswolf",
			EntityType.Builder.<LatexpurplewswolfEntity>of(LatexpurplewswolfEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexpurplewswolfEntity::new)

					.sized(0.6f, 1.9f));
	public static final RegistryObject<EntityType<LatexthreemonthwolfEntity>> LATEXTHREEMONTHWOLF = register("latexthreemonthwolf",
			EntityType.Builder.<LatexthreemonthwolfEntity>of(LatexthreemonthwolfEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexthreemonthwolfEntity::new)

					.sized(0.9f, 2.15f));
	public static final RegistryObject<EntityType<LatexyunxqhotdragonEntity>> LATEXYUNXQHOTDRAGON = register("latexyunxqhotdragon", EntityType.Builder.<LatexyunxqhotdragonEntity>of(LatexyunxqhotdragonEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexyunxqhotdragonEntity::new).fireImmune().sized(0.6f, 1.9f));
	public static final RegistryObject<EntityType<LatexyunxqicedragonEntity>> LATEXYUNXQICEDRAGON = register("latexyunxqicedragon",
			EntityType.Builder.<LatexyunxqicedragonEntity>of(LatexyunxqicedragonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexyunxqicedragonEntity::new)

					.sized(0.6f, 2f));
	public static final RegistryObject<EntityType<LatexbluedragonEntity>> LATEXBLUEDRAGON = register("latexbluedragon",
			EntityType.Builder.<LatexbluedragonEntity>of(LatexbluedragonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexbluedragonEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LatexPurplecoocwolfEntity>> LATEXPRTPLECOOCWOLF = register("latex_purple_cooc_wolf",
			EntityType.Builder.<LatexPurplecoocwolfEntity>of(LatexPurplecoocwolfEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LatexPurplecoocwolfEntity::new)

					.sized(0.6f, 1.8f));

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

	public static final RegistryObject<EntityType<LatexYunQiIceDragonEntity>> LATEXYUNQIICEDRAGON = register("latex_yun_qi_ice_dragon",
			EntityType.Builder.<LatexYunQiIceDragonEntity>of(LatexYunQiIceDragonEntity::new, ChangedMobCategories.CHANGED)
					.setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64)
					.setUpdateInterval(3)
					.setCustomClientFactory(LatexYunQiIceDragonEntity::new)
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
			LatexOrangeFoxEntity.init();
			LatexKcahraSharkEntity.init();
			DarkfuLatexWolfMaleEntity.init();
			LatexiceDragonEntity.init();
			InksugerEntity.init();
			BlackpupmaleEntity.init();
			WhitebluepupEntity.init();
			LatexpurplewswolfEntity.init();
			LatexthreemonthwolfEntity.init();
			LatexyunxqhotdragonEntity.init();
			LatexyunxqicedragonEntity.init();
			LatexbluedragonEntity.init();
			LatexPurplecoocwolfEntity.init();
			LatexkamonaHSguydragonwolfEntity.init();
			LatexDragonFruitWolfEntity.init();
			LatexYunQiIceDragonEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(LATEX_ORANGE_FOX.get(), LatexOrangeFoxEntity.createAttributes().build());
		event.put(LATEX_KCAHRA_SHARK.get(), LatexKcahraSharkEntity.createAttributes().build());
		event.put(DARKFU_LATEX_WOLF_MALE.get(), DarkfuLatexWolfMaleEntity.createAttributes().build());
		event.put(LATEXICE_DRAGON.get(), LatexiceDragonEntity.createAttributes().build());
		event.put(INKSUGER.get(), InksugerEntity.createAttributes().build());
		event.put(BLACKPUPMALE.get(), BlackpupmaleEntity.createAttributes().build());
		event.put(WHITEBLUEPUP.get(), WhitebluepupEntity.createAttributes().build());
		event.put(LATEXPURPLEWSWOLF.get(), LatexpurplewswolfEntity.createAttributes().build());
		event.put(LATEXTHREEMONTHWOLF.get(), LatexthreemonthwolfEntity.createAttributes().build());
		event.put(LATEXYUNXQHOTDRAGON.get(), LatexyunxqhotdragonEntity.createAttributes().build());
		event.put(LATEXYUNXQICEDRAGON.get(), LatexyunxqicedragonEntity.createAttributes().build());
		event.put(LATEXBLUEDRAGON.get(), LatexbluedragonEntity.createAttributes().build());
		event.put(LATEXPRTPLECOOCWOLF.get(), LatexPurplecoocwolfEntity.createAttributes().build());
		event.put(LATEX_KAMONA_HSGUY_DRAGON_WOLF.get(), LatexkamonaHSguydragonwolfEntity.createAttributes().build());
		event.put(LATEXDRAGONFRUITWOLF.get(), LatexDragonFruitWolfEntity.createAttributes().build());
		event.put(LATEXYUNQIICEDRAGON.get(), LatexYunQiIceDragonEntity.createAttributes().build());
	}
}
