package net.foxyas.changedaddon.init;

import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.entity.projectile.WitherParticleProjectile;
import net.foxyas.changedaddon.entity.simple.PinkCyanSkunkEntity;
import net.foxyas.changedaddon.entity.advanced.*;
import net.foxyas.changedaddon.entity.bosses.*;
import net.foxyas.changedaddon.entity.mobs.ErikEntity;
import net.foxyas.changedaddon.entity.mobs.FoxyasEntity;
import net.foxyas.changedaddon.entity.projectile.LuminarCrystalSpearEntity;
import net.foxyas.changedaddon.entity.projectile.VoidFoxParticleProjectile;
import net.foxyas.changedaddon.entity.simple.*;
import net.ltxprogrammer.changed.init.ChangedMobCategories;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChangedAddonEntities {

    /**
     * Todo: Make this Class Use HashMaps to make it registration more dynamic
     * example -> ATTRIBUTES.put(PROTOTYPE, PrototypeEntity::createAttributes);
     */

    public static @NotNull List<EntityType<?>> canUseAccessories() {
        final List<EntityType<?>> ADDON_CHANGED_ENTITIES = getAddonHumanoidsChangedEntities();
        ADDON_CHANGED_ENTITIES.remove(REYN.get());
        ADDON_CHANGED_ENTITIES.remove(BUNY.get());
        return ADDON_CHANGED_ENTITIES;
    }

    public static @NotNull List<EntityType<?>> canUseExoskeleton() {
        final List<EntityType<?>> ADDON_CHANGED_ENTITIES = getAddonHumanoidsChangedEntities();
        ADDON_CHANGED_ENTITIES.remove(REYN.get());
        return ADDON_CHANGED_ENTITIES;
    }

    @Contract(" -> new")
    public static @NotNull List<EntityType<?>> getAddonHumanoidsChangedEntities() {
        return new ArrayList<>(List.of(
                // Snow foxes
                LATEX_SNOW_FOX_MALE.get(),
                LATEX_SNOW_FOX_FEMALE.get(),

                // Foxes
                FOXTA_FOXY.get(),
                VOID_FOX.get(),
                HAYDEN_FENNEC_FOX.get(),
                LATEX_KITSUNE_MALE.get(),
                LATEX_KITSUNE_FEMALE.get(),

                // Leopards
                SNOW_LEOPARD_FEMALE_ORGANIC.get(),
                SNOW_LEOPARD_MALE_ORGANIC.get(),
                SNOW_LEOPARD_PARTIAL.get(),
                LUMINARCTIC_LEOPARD_MALE.get(),
                LUMINARCTIC_LEOPARD_FEMALE.get(),
                SNEPSI_LEOPARD.get(),

                // Felines
                MIRROR_WHITE_TIGER.get(),
                LYNX.get(),
                LATEX_WIND_CAT_MALE.get(),
                LATEX_WIND_CAT_FEMALE.get(),
                CRYSTAL_GAS_CAT_MALE.get(),
                CRYSTAL_GAS_CAT_FEMALE.get(),
                LATEX_CALICO_CAT.get(),
                LATEX_CHEETAH_MALE.get(),
                LATEX_CHEETAH_FEMALE.get(),

                // Half/Partial Ones
                SNOW_LEOPARD_PARTIAL.get(),

                // Birds
                AVALI.get(),

                // Experiments
                EXPERIMENT_009.get(),
                EXPERIMENT_009_BOSS.get(),
                EXPERIMENT_10.get(),
                EXPERIMENT_10_BOSS.get(),
                EXP_1_MALE.get(),
                EXP_1_FEMALE.get(),
                EXP_2_MALE.get(),
                EXP_2_FEMALE.get(),
                EXP_6.get(),

                // Fusions
                LATEX_SQUID_TIGER_SHARK.get(),
                LATEX_DRAGON_SNOW_LEOPARD_SHARK.get(),

                // Dragons
                LUMINARA_FLOWER_BEAST.get(),

                // Others...
                REYN.get(),
                DAZED_LATEX.get(),
                PURO_KIND_MALE.get(),
                PURO_KIND_FEMALE.get(),
                BUNY.get(),
                WOLFY.get(),
                BAGEL.get(),
                FENGQI_WOLF.get(),
                BLUE_LIZARD.get(),
                MONGOOSE.get(),
                PINK_CYAN_SKUNK.get(),

                // Protogens/Robot like
                PROTOGEN.get(),
                PROTOTYPE.get(),
                BOREALIS_MALE.get(),
                BOREALIS_FEMALE.get()

        ));
    }

    //Todo: Make this Class a bit less Chaotic
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, ChangedAddonMod.MODID);

    private static <T extends Entity> RegistryObject<EntityType<T>> registerChangedEntity(String registryName, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryName, () -> entityTypeBuilder.build(registryName));
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryName, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryName, () -> entityTypeBuilder.build(registryName));
    }

    // --- PROJECTILES ---
    public static final RegistryObject<EntityType<VoidFoxParticleProjectile>> PARTICLE_PROJECTILE = register("particle_projectile",
            EntityType.Builder.<VoidFoxParticleProjectile>of(VoidFoxParticleProjectile::new, MobCategory.MISC)
                    .setShouldReceiveVelocityUpdates(true)
                    .clientTrackingRange(64)
                    .updateInterval(1)

                    .sized(0.25F, 0.25F));

    public static final RegistryObject<EntityType<WitherParticleProjectile>> WITHER_PARTICLE_PROJECTILE = register("wither_particle_projectile",
            EntityType.Builder.of(WitherParticleProjectile::new, MobCategory.MISC)
                    .setShouldReceiveVelocityUpdates(true)
                    .clientTrackingRange(64)
                    .updateInterval(1)

                    .sized(0.25F, 0.25F));

    public static final RegistryObject<EntityType<LuminarCrystalSpearEntity>> LUMINAR_CRYSTAL_SPEAR = register("projectile_luminar_crystal_spear",
            EntityType.Builder.<LuminarCrystalSpearEntity>of(LuminarCrystalSpearEntity::new, MobCategory.MISC)
                    .setCustomClientFactory(LuminarCrystalSpearEntity::new)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)

                    .sized(0.5f, 0.5f));


    // --- CHANGED ENTITIES ---
    public static final RegistryObject<EntityType<LatexSnowFoxMaleEntity>> LATEX_SNOW_FOX_MALE = registerChangedEntity("latex_snow_fox_male",
            EntityType.Builder.<LatexSnowFoxMaleEntity>of(LatexSnowFoxMaleEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(LatexSnowFoxMaleEntity::new)
                    .sized(0.7f, 1.93f));

    private static <T extends Entity> RegistryObject<EntityType<T>> registerMob(String registryName, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryName, () -> entityTypeBuilder.build(registryName));
    }

    public static final RegistryObject<EntityType<LatexSnowFoxFemaleEntity>> LATEX_SNOW_FOX_FEMALE = registerChangedEntity("latex_snow_fox_female",
            EntityType.Builder.<LatexSnowFoxFemaleEntity>of(LatexSnowFoxFemaleEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(LatexSnowFoxFemaleEntity::new)
                    .sized(0.7f, 1.93f));


    public static final RegistryObject<EntityType<DazedLatexEntity>> DAZED_LATEX = registerChangedEntity("latex_dazed",
            EntityType.Builder.<DazedLatexEntity>of(DazedLatexEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(DazedLatexEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<PuroKindMaleEntity>> PURO_KIND_MALE = registerChangedEntity("puro_kind_male",
            EntityType.Builder.<PuroKindMaleEntity>of(PuroKindMaleEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(PuroKindMaleEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<PuroKindFemaleEntity>> PURO_KIND_FEMALE = registerChangedEntity("puro_kind_female",
            EntityType.Builder.<PuroKindFemaleEntity>of(PuroKindFemaleEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(PuroKindFemaleEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<BunyEntity>> BUNY = registerChangedEntity("buny",
            EntityType.Builder.<BunyEntity>of(BunyEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(BunyEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<SnowLeopardFemaleOrganicEntity>> SNOW_LEOPARD_FEMALE_ORGANIC = registerChangedEntity("snow_leopard_female_organic",
            EntityType.Builder.<SnowLeopardFemaleOrganicEntity>of(SnowLeopardFemaleOrganicEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(SnowLeopardFemaleOrganicEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<SnowLeopardMaleOrganicEntity>> SNOW_LEOPARD_MALE_ORGANIC = registerChangedEntity("snow_leopard_male_organic",
            EntityType.Builder.<SnowLeopardMaleOrganicEntity>of(SnowLeopardMaleOrganicEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(SnowLeopardMaleOrganicEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<MirrorWhiteTigerEntity>> MIRROR_WHITE_TIGER = registerChangedEntity("mirror_white_tiger",
            EntityType.Builder.<MirrorWhiteTigerEntity>of(MirrorWhiteTigerEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(MirrorWhiteTigerEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<Exp2MaleEntity>> EXP_2_MALE = registerChangedEntity("exp_2_male",
            EntityType.Builder.<Exp2MaleEntity>of(Exp2MaleEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(Exp2MaleEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<Exp2FemaleEntity>> EXP_2_FEMALE = registerChangedEntity("exp_2_female",
            EntityType.Builder.<Exp2FemaleEntity>of(Exp2FemaleEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(Exp2FemaleEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<WolfyEntity>> WOLFY = registerChangedEntity("wolfy",
            EntityType.Builder.<WolfyEntity>of(WolfyEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(WolfyEntity::new)
                    .fireImmune()
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<Exp6Entity>> EXP_6 = registerChangedEntity("exp_6",
            EntityType.Builder.<Exp6Entity>of(Exp6Entity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(Exp6Entity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<ReynEntity>> REYN = registerChangedEntity("reyn",
            EntityType.Builder.<ReynEntity>of(ReynEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(ReynEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<Experiment009Entity>> EXPERIMENT_009 = registerChangedEntity("experiment_009", EntityType.Builder.<Experiment009Entity>of(Experiment009Entity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .setCustomClientFactory(Experiment009Entity::new)
            .fireImmune()
            .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<Experiment009BossEntity>> EXPERIMENT_009_BOSS = registerChangedEntity("experiment_009_boss",
            EntityType.Builder.<Experiment009BossEntity>of(Experiment009BossEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(Experiment009BossEntity::new)
                    .fireImmune()
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<Experiment10Entity>> EXPERIMENT_10 = registerChangedEntity("experiment_10",
            EntityType.Builder.<Experiment10Entity>of(Experiment10Entity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(Experiment10Entity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<Experiment10BossEntity>> EXPERIMENT_10_BOSS = registerChangedEntity("experiment_10_boss",
            EntityType.Builder.<Experiment10BossEntity>of(Experiment10BossEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(Experiment10BossEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<Exp1MaleEntity>> EXP_1_MALE = registerChangedEntity("exp_1_male",
            EntityType.Builder.<Exp1MaleEntity>of(Exp1MaleEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(Exp1MaleEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<Exp1FemaleEntity>> EXP_1_FEMALE = registerChangedEntity("exp_1_female",
            EntityType.Builder.<Exp1FemaleEntity>of(Exp1FemaleEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(Exp1FemaleEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<LatexSnepEntity>> LATEX_SNEP = registerChangedEntity("latex_snep",
            EntityType.Builder.<LatexSnepEntity>of(LatexSnepEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(LatexSnepEntity::new)
                    .sized(0.6f, 0.7f));

    public static final RegistryObject<EntityType<LuminarcticLeopardMaleEntity>> LUMINARCTIC_LEOPARD_MALE = registerChangedEntity("luminarctic_leopard_male",
            EntityType.Builder.<LuminarcticLeopardMaleEntity>of(LuminarcticLeopardMaleEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(LuminarcticLeopardMaleEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<LuminarcticLeopardFemaleEntity>> LUMINARCTIC_LEOPARD_FEMALE = registerChangedEntity("luminarctic_leopard_female",
            EntityType.Builder.<LuminarcticLeopardFemaleEntity>of(LuminarcticLeopardFemaleEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(LuminarcticLeopardFemaleEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<LatexSquidTigerSharkEntity>> LATEX_SQUID_TIGER_SHARK = registerChangedEntity("latex_squid_tiger_shark",
            EntityType.Builder.<LatexSquidTigerSharkEntity>of(LatexSquidTigerSharkEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(LatexSquidTigerSharkEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<LynxEntity>> LYNX = registerChangedEntity("lynx",
            EntityType.Builder.<LynxEntity>of(LynxEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(LynxEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<FoxtaFoxyEntity>> FOXTA_FOXY = registerChangedEntity("foxta_foxy",
            EntityType.Builder.<FoxtaFoxyEntity>of(FoxtaFoxyEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(FoxtaFoxyEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<SnepsiLeopardEntity>> SNEPSI_LEOPARD = registerChangedEntity("snepsi_leopard",
            EntityType.Builder.<SnepsiLeopardEntity>of(SnepsiLeopardEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(SnepsiLeopardEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<BagelEntity>> BAGEL = registerChangedEntity("bagel",
            EntityType.Builder.<BagelEntity>of(BagelEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(BagelEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<LatexDragonSnowLeopardSharkEntity>> LATEX_DRAGON_SNOW_LEOPARD_SHARK = registerChangedEntity("latex_dragon_snow_leopard_shark",
            EntityType.Builder.<LatexDragonSnowLeopardSharkEntity>of(LatexDragonSnowLeopardSharkEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(LatexDragonSnowLeopardSharkEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<CrystalGasCatMaleEntity>> CRYSTAL_GAS_CAT_MALE = registerChangedEntity("crystal_gas_cat_male",
            EntityType.Builder.<CrystalGasCatMaleEntity>of(CrystalGasCatMaleEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(CrystalGasCatMaleEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<CrystalGasCatFemaleEntity>> CRYSTAL_GAS_CAT_FEMALE = registerChangedEntity("crystal_gas_cat_female",
            EntityType.Builder.<CrystalGasCatFemaleEntity>of(CrystalGasCatFemaleEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(CrystalGasCatFemaleEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<VoidFoxEntity>> VOID_FOX = registerChangedEntity("void_fox",
            EntityType.Builder.<VoidFoxEntity>of(VoidFoxEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(VoidFoxEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<FengQIWolfEntity>> FENGQI_WOLF = registerChangedEntity("fengqi_wolf",
            EntityType.Builder.<FengQIWolfEntity>of(FengQIWolfEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(FengQIWolfEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<HaydenFennecFoxEntity>> HAYDEN_FENNEC_FOX = registerChangedEntity("hayden_fennec_fox",
            EntityType.Builder.<HaydenFennecFoxEntity>of(HaydenFennecFoxEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(HaydenFennecFoxEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<SnowLeopardPartialEntity>> SNOW_LEOPARD_PARTIAL = registerChangedEntity("latex_snow_leopard_partial",
            EntityType.Builder.<SnowLeopardPartialEntity>of(SnowLeopardPartialEntity::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(SnowLeopardPartialEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<BlueLizard>> BLUE_LIZARD = registerChangedEntity("blue_lizard",
            EntityType.Builder.<BlueLizard>of(BlueLizard::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(BlueLizard::new)
                    .clientTrackingRange(10)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<AvaliEntity>> AVALI = registerChangedEntity("avali",
            EntityType.Builder.<AvaliEntity>of(AvaliEntity::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(AvaliEntity::new)
                    .clientTrackingRange(10)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<LatexKitsuneMaleEntity>> LATEX_KITSUNE_MALE = registerChangedEntity("latex_kitsune_male",
            EntityType.Builder.<LatexKitsuneMaleEntity>of(LatexKitsuneMaleEntity::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(LatexKitsuneMaleEntity::new)
                    .clientTrackingRange(10)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<LatexKitsuneFemaleEntity>> LATEX_KITSUNE_FEMALE = registerChangedEntity("latex_kitsune_female",
            EntityType.Builder.<LatexKitsuneFemaleEntity>of(LatexKitsuneFemaleEntity::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(LatexKitsuneFemaleEntity::new)
                    .clientTrackingRange(10)
                    .sized(0.7f, 1.93f));


    public static final RegistryObject<EntityType<LatexCalicoCatEntity>> LATEX_CALICO_CAT = registerChangedEntity("latex_calico_cat",
            EntityType.Builder.<LatexCalicoCatEntity>of(LatexCalicoCatEntity::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(LatexCalicoCatEntity::new)
                    .clientTrackingRange(10)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<ProtogenEntity>> PROTOGEN = registerChangedEntity("protogen",
            EntityType.Builder.<ProtogenEntity>of(ProtogenEntity::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(ProtogenEntity::new)
                    .clientTrackingRange(10)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<MongooseEntity>> MONGOOSE = registerChangedEntity("mongoose",
            EntityType.Builder.<MongooseEntity>of(MongooseEntity::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(MongooseEntity::new)
                    .clientTrackingRange(10)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<BorealisMaleEntity>> BOREALIS_MALE = registerChangedEntity("borealis_male",
            EntityType.Builder.<BorealisMaleEntity>of(BorealisMaleEntity::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(BorealisMaleEntity::new)
                    .clientTrackingRange(10)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<BorealisFemaleEntity>> BOREALIS_FEMALE = registerChangedEntity("borealis_female",
            EntityType.Builder.<BorealisFemaleEntity>of(BorealisFemaleEntity::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(BorealisFemaleEntity::new)
                    .clientTrackingRange(10)
                    .sized(0.7f, 1.93f));

    // --- MONSTER/MOB ENTITIES ---
    public static final RegistryObject<EntityType<PrototypeEntity>> PROTOTYPE = registerMob("prototype",
            EntityType.Builder.<PrototypeEntity>of(PrototypeEntity::new, ChangedMobCategories.CHANGED)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(PrototypeEntity::new)
                    .sized(0.7f, 1.93f));

    public static final RegistryObject<EntityType<FoxyasEntity>> FOXYAS = registerMob("foxyas",
            EntityType.Builder.<FoxyasEntity>of(FoxyasEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(FoxyasEntity::new)
                    .sized(0.7f, 1.9f));

    public static final RegistryObject<EntityType<ErikEntity>> ERIK = registerChangedEntity("erik",
            EntityType.Builder.<ErikEntity>of(ErikEntity::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .setCustomClientFactory(ErikEntity::new)
                    .sized(0.6f, 1.8f));

    public static final RegistryObject<EntityType<PinkCyanSkunkEntity>> PINK_CYAN_SKUNK = registerChangedEntity("pink_cyan_skunk",
            EntityType.Builder.of(PinkCyanSkunkEntity::new, ChangedMobCategories.CHANGED)
                    .clientTrackingRange(10)
                    .sized(0.7F, 1.93F));

    public static final RegistryObject<EntityType<LatexWindCatMaleEntity>> LATEX_WIND_CAT_MALE = registerChangedEntity("latex_wind_cat_male",
            EntityType.Builder.of(LatexWindCatMaleEntity::new, ChangedMobCategories.CHANGED)
                    .clientTrackingRange(10)
                    .sized(0.7F, 1.93F));

    public static final RegistryObject<EntityType<LatexWindCatFemaleEntity>> LATEX_WIND_CAT_FEMALE = registerChangedEntity("latex_wind_cat_female",
            EntityType.Builder.of(LatexWindCatFemaleEntity::new, ChangedMobCategories.CHANGED)
                    .clientTrackingRange(10)
                    .sized(0.7F, 1.93F));

    public static final RegistryObject<EntityType<LatexWhiteSnowLeopardMale>> LATEX_WHITE_SNOW_LEOPARD_MALE = registerChangedEntity("latex_white_snow_leopard_male",
            EntityType.Builder.of(LatexWhiteSnowLeopardMale::new, ChangedMobCategories.CHANGED)
                    .clientTrackingRange(10)
                    .sized(0.7F, 1.93F));

    public static final RegistryObject<EntityType<LatexWhiteSnowLeopardFemale>> LATEX_WHITE_SNOW_LEOPARD_FEMALE = registerChangedEntity("latex_white_snow_leopard_female",
            EntityType.Builder.of(LatexWhiteSnowLeopardFemale::new, ChangedMobCategories.CHANGED)
                    .clientTrackingRange(10)
                    .sized(0.7F, 1.93F));

    public static final RegistryObject<EntityType<LatexCheetahFemale>> LATEX_CHEETAH_FEMALE = registerChangedEntity("latex_cheetah_female",
            EntityType.Builder.of(LatexCheetahFemale::new, ChangedMobCategories.CHANGED)
                    .clientTrackingRange(10)
                    .sized(0.7F, 1.93F));

    public static final RegistryObject<EntityType<LatexCheetahMale>> LATEX_CHEETAH_MALE = registerChangedEntity("latex_cheetah_male",
            EntityType.Builder.of(LatexCheetahMale::new, ChangedMobCategories.CHANGED)
                    .clientTrackingRange(10)
                    .sized(0.7F, 1.93F));

    public static final RegistryObject<EntityType<LuminaraFlowerBeastEntity>> LUMINARA_FLOWER_BEAST = registerChangedEntity("luminara_flower_beast",
            EntityType.Builder.<LuminaraFlowerBeastEntity>of(LuminaraFlowerBeastEntity::new, ChangedMobCategories.CHANGED)
                    .clientTrackingRange(10)
                    .sized(0.7F, 1.93F));

    @SubscribeEvent
    public static void registerAttributes(@NotNull EntityAttributeCreationEvent event) {
        event.put(PROTOTYPE.get(), PrototypeEntity.createAttributes().build());
        event.put(FOXYAS.get(), FoxyasEntity.createAttributes().build());
        event.put(LATEX_SNOW_FOX_MALE.get(), LatexSnowFoxMaleEntity.createAttributes().build());
        event.put(LATEX_SNOW_FOX_FEMALE.get(), LatexSnowFoxFemaleEntity.createAttributes().build());
        event.put(DAZED_LATEX.get(), DazedLatexEntity.createAttributes().build());
        event.put(PURO_KIND_MALE.get(), PuroKindMaleEntity.createAttributes().build());
        event.put(PURO_KIND_FEMALE.get(), PuroKindFemaleEntity.createAttributes().build());
        event.put(BUNY.get(), BunyEntity.createAttributes().build());
        event.put(SNOW_LEOPARD_FEMALE_ORGANIC.get(), SnowLeopardFemaleOrganicEntity.createAttributes().build());
        event.put(EXPERIMENT_009.get(), Experiment009Entity.createAttributes().build());
        event.put(MIRROR_WHITE_TIGER.get(), MirrorWhiteTigerEntity.createAttributes().build());
        event.put(SNOW_LEOPARD_MALE_ORGANIC.get(), SnowLeopardMaleOrganicEntity.createAttributes().build());
        event.put(EXPERIMENT_10.get(), Experiment10Entity.createAttributes().build());
        event.put(EXP_2_MALE.get(), Exp2MaleEntity.createAttributes().build());
        event.put(EXP_2_FEMALE.get(), Exp2FemaleEntity.createAttributes().build());
        event.put(WOLFY.get(), WolfyEntity.createAttributes().build());
        event.put(ERIK.get(), ErikEntity.createAttributes().build());
        event.put(EXP_6.get(), Exp6Entity.createAttributes().build());
        event.put(REYN.get(), ReynEntity.createAttributes().build());
        event.put(EXPERIMENT_009_BOSS.get(), Experiment009BossEntity.createAttributes().build());
        event.put(EXPERIMENT_10_BOSS.get(), Experiment10BossEntity.createAttributes().build());
        event.put(EXP_1_MALE.get(), Exp1MaleEntity.createAttributes().build());
        event.put(EXP_1_FEMALE.get(), Exp1FemaleEntity.createAttributes().build());
        event.put(LATEX_SNEP.get(), LatexSnepEntity.createAttributes().build());
        event.put(LUMINARCTIC_LEOPARD_MALE.get(), LuminarcticLeopardMaleEntity.createAttributes().build());
        event.put(LUMINARCTIC_LEOPARD_FEMALE.get(), LuminarcticLeopardFemaleEntity.createAttributes().build());
        event.put(LATEX_SQUID_TIGER_SHARK.get(), LatexSquidTigerSharkEntity.createAttributes().build());
        event.put(LYNX.get(), LynxEntity.createAttributes().build());
        event.put(FOXTA_FOXY.get(), FoxtaFoxyEntity.createAttributes().build());
        event.put(SNEPSI_LEOPARD.get(), SnepsiLeopardEntity.createAttributes().build());
        event.put(BAGEL.get(), BagelEntity.createAttributes().build());
        event.put(LATEX_DRAGON_SNOW_LEOPARD_SHARK.get(), LatexDragonSnowLeopardSharkEntity.createAttributes().build());
        event.put(CRYSTAL_GAS_CAT_MALE.get(), CrystalGasCatMaleEntity.createAttributes().build());
        event.put(CRYSTAL_GAS_CAT_FEMALE.get(), CrystalGasCatFemaleEntity.createAttributes().build());
        event.put(VOID_FOX.get(), VoidFoxEntity.createAttributes().build());
        event.put(FENGQI_WOLF.get(), FengQIWolfEntity.createAttributes().build());
        event.put(HAYDEN_FENNEC_FOX.get(), HaydenFennecFoxEntity.createAttributes().build());
        event.put(SNOW_LEOPARD_PARTIAL.get(), SnowLeopardPartialEntity.createAttributes().build());
        event.put(BLUE_LIZARD.get(), BlueLizard.createAttributes().build());
        event.put(AVALI.get(), AvaliEntity.createAttributes().build());
        event.put(LATEX_KITSUNE_MALE.get(), LatexKitsuneMaleEntity.createAttributes().build());
        event.put(LATEX_KITSUNE_FEMALE.get(), LatexKitsuneFemaleEntity.createAttributes().build());
        event.put(LATEX_CALICO_CAT.get(), LatexCalicoCatEntity.createAttributes().build());
        event.put(PROTOGEN.get(), ProtogenEntity.createAttributes().build());
        event.put(MONGOOSE.get(), MongooseEntity.createAttributes().build());
        event.put(BOREALIS_MALE.get(), BorealisMaleEntity.createAttributes().build());
        event.put(BOREALIS_FEMALE.get(), BorealisFemaleEntity.createAttributes().build());
        event.put(PINK_CYAN_SKUNK.get(), PinkCyanSkunkEntity.createLatexAttributes().build());
        event.put(LATEX_WIND_CAT_FEMALE.get(), LatexWindCatFemaleEntity.createLatexAttributes().build());
        event.put(LATEX_WIND_CAT_MALE.get(), LatexWindCatMaleEntity.createLatexAttributes().build());
        event.put(LATEX_WHITE_SNOW_LEOPARD_MALE.get(), LatexWhiteSnowLeopardMale.createLatexAttributes().build());
        event.put(LATEX_WHITE_SNOW_LEOPARD_FEMALE.get(), LatexWhiteSnowLeopardFemale.createLatexAttributes().build());
        event.put(LATEX_CHEETAH_MALE.get(), LatexCheetahMale.createLatexAttributes().build());
        event.put(LATEX_CHEETAH_FEMALE.get(), LatexCheetahFemale.createLatexAttributes().build());
        event.put(LUMINARA_FLOWER_BEAST.get(), LuminaraFlowerBeastEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void init(@NotNull FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PrototypeEntity.init();
            FoxyasEntity.init();
            LatexSnowFoxMaleEntity.init();
            LatexSnowFoxFemaleEntity.init();
            DazedLatexEntity.init();
            PuroKindMaleEntity.init();
            PuroKindFemaleEntity.init();
            BunyEntity.init();
            SnowLeopardFemaleOrganicEntity.init();
            Experiment009Entity.init();
            MirrorWhiteTigerEntity.init();
            SnowLeopardMaleOrganicEntity.init();
            Experiment10Entity.init();
            Exp2MaleEntity.init();
            Exp2FemaleEntity.init();
            WolfyEntity.init();
            ErikEntity.init();
            Exp6Entity.init();
            ReynEntity.init();
            Experiment009BossEntity.init();
            Experiment10BossEntity.init();
            Exp1MaleEntity.init();
            Exp1FemaleEntity.init();
            LatexSnepEntity.init();
            LuminarcticLeopardMaleEntity.init();
            LuminarcticLeopardFemaleEntity.init();
            LatexSquidTigerSharkEntity.init();
            LynxEntity.init();
            FoxtaFoxyEntity.init();
            SnepsiLeopardEntity.init();
            BagelEntity.init();
            LatexDragonSnowLeopardSharkEntity.init();
            CrystalGasCatMaleEntity.init();
            CrystalGasCatFemaleEntity.init();
            VoidFoxEntity.init();
            FengQIWolfEntity.init();
            HaydenFennecFoxEntity.init();
            SnowLeopardPartialEntity.init();
            VoidFoxParticleProjectile.init();
            BlueLizard.init();
            AvaliEntity.init();
            LatexKitsuneMaleEntity.init();
            LatexKitsuneFemaleEntity.init();
            LatexCalicoCatEntity.init();
            ProtogenEntity.init();
            MongooseEntity.init();
            BorealisMaleEntity.init();
            BorealisFemaleEntity.init();
            LatexWindCatFemaleEntity.init();
            LatexWindCatMaleEntity.init();
            LatexWhiteSnowLeopardMale.init();
            LatexWhiteSnowLeopardFemale.init();
            LuminaraFlowerBeastEntity.init();
            LatexCheetahFemale.init();
            LatexCheetahMale.init();
        });
    }

}
