/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.entity.*;
import net.hhdsj.goodblock.entity.boss.*;
import net.hhdsj.goodblock.entity.simple.LatexIqGoldDragonEntity;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
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
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.hhdsj.goodblock.GoodblockMod;

import net.ltxprogrammer.changed.entity.ChangedEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodblockModEntities {
    public interface VoidConsumer { void accept(); }

    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GoodblockMod.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GoodblockMod.MODID);

    // 存储实体颜色（用于刷怪蛋）
    private static final Map<ResourceLocation, Pair<Integer, Integer>> ENTITY_COLOR_MAP = new HashMap<>();

    // 存储属性构建器
    private static final List<Pair<Supplier<EntityType<? extends ChangedEntity>>, Supplier<AttributeSupplier.Builder>>> ATTR_FUNC_REGISTRY = new ArrayList<>();

    // 存储初始化函数（如生成规则）
    private static final List<VoidConsumer> INIT_FUNC_REGISTRY = new ArrayList<>();

    // 存储刷怪蛋
    public static final Map<RegistryObject<? extends EntityType<?>>, RegistryObject<ForgeSpawnEggItem>> SPAWN_EGGS = new HashMap<>();

    // 简单的Pair类
    public static class Pair<F, S> {
        private final F first;
        private final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() { return first; }
        public S getSecond() { return second; }
    }

    // 狐狸变体
    public static final RegistryObject<EntityType<LatexOrangeFoxEntity>> LATEX_ORANGE_FOX;
    public static final RegistryObject<EntityType<LatexRadiationFoxEntity>> LATEXRADIATIONFOX;

    // 鲨鱼变体
    public static final RegistryObject<EntityType<LatexKcahraSharkEntity>> LATEX_KCAHRA_SHARK;

    // 狼变体
    public static final RegistryObject<EntityType<DarkfuLatexWolfMaleEntity>> DARKFU_LATEX_WOLF_MALE;
    public static final RegistryObject<EntityType<LatexpurplewswolfEntity>> LATEXPURPLEWSWOLF;
    public static final RegistryObject<EntityType<LatexthreemonthwolfEntity>> LATEXTHREEMONTHWOLF;
    public static final RegistryObject<EntityType<LatexPurplecoocwolfEntity>> LATEXPRTPLECOOCWOLF;
    public static final RegistryObject<EntityType<LatexIceFieldWolfDragonEntity>> LATEX_ICE_FIELD_WOLF_DRAGON;
    public static final RegistryObject<EntityType<LatexDragonFruitWolfEntity>> LATEXDRAGONFRUITWOLF;

    // 幼崽变体
    public static final RegistryObject<EntityType<BlackpupmaleEntity>> BLACKPUPMALE;
    public static final RegistryObject<EntityType<WhitebluepupEntity>> WHITEBLUEPUP;

    // 龙变体
    public static final RegistryObject<EntityType<LatexiceDragonEntity>> LATEXICE_DRAGON;
    public static final RegistryObject<EntityType<LatexyunxqhotdragonEntity>> LATEXYUNXQHOTDRAGON;
    public static final RegistryObject<EntityType<LatexyunxqicedragonEntity>> LATEXYUNXQICEDRAGON;
    public static final RegistryObject<EntityType<LatexbluedragonEntity>> LATEXBLUEDRAGON;
    public static final RegistryObject<EntityType<LatexYunQiIceDragonEntity>> LATEXYUNQIICEDRAGON;
    public static final RegistryObject<EntityType<LatexDarkPurpleDragonTaurEntity>> LATEXDARKPURPLEDRAGONTAUR;
    public static final RegistryObject<EntityType<DarkPurpleLatexDragonEntity>> LATEXDARKPURPLEDRAGON;

    // BOSS变体
    public static final RegistryObject<EntityType<LatexIceFieldWolfDragonBossEntity>> LATEX_ICE_FIELD_WOLF_DRAGON_BOSS;
    public static final RegistryObject<EntityType<LatexNightOwlBossEntity>> LATEXNIGHTOWLDRAGONBOSS;
    public static final RegistryObject<EntityType<LatexNightOwlEntity>> LATEXNIGHTOWLDRAGON;
    public static final RegistryObject<EntityType<LatexIqGoldDragonEntity>> LATEXIQGOLDDRAGON;

    // 其他变体
    public static final RegistryObject<EntityType<InksugerEntity>> INKSUGER;
    public static final RegistryObject<EntityType<LatexthreemonthwolfEntityProjectile>> LATEXTHREEMONTHWOLF_PROJECTILE;

    static {
        // 狐狸变体 - 使用注册方法
        LATEX_ORANGE_FOX = registerSpawning("latex_orange_fox", 0xFF8C42, 0xFF5500,
                EntityType.Builder.<LatexOrangeFoxEntity>of(LatexOrangeFoxEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexOrangeFoxEntity::new)
                        .sized(0.6f, 1.95f),
                LatexOrangeFoxEntity::createLatexAttributes);  // 使用父类默认属性

        LATEXRADIATIONFOX = registerSpawning("latex_radiation_fox", 0x7CFC00, 0x32CD32,
                EntityType.Builder.<LatexRadiationFoxEntity>of(LatexRadiationFoxEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexRadiationFoxEntity::new)
                        .sized(0.7f, 1.93f),
                LatexRadiationFoxEntity::createLatexAttributes);

        // 鲨鱼变体
        LATEX_KCAHRA_SHARK = registerSpawning("latex_kcahra_shark", 0x2E8B57, 0x228B22,
                EntityType.Builder.<LatexKcahraSharkEntity>of(LatexKcahraSharkEntity::new, MobCategory.WATER_CREATURE)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexKcahraSharkEntity::new)
                        .sized(0.6f, 1.8f),
                LatexKcahraSharkEntity::createLatexAttributes);

        // 狼变体
        DARKFU_LATEX_WOLF_MALE = registerSpawning("darkfu_latex_wolf_male", 0x4A4A4A, 0x2D2D2D,
                EntityType.Builder.<DarkfuLatexWolfMaleEntity>of(DarkfuLatexWolfMaleEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(DarkfuLatexWolfMaleEntity::new)
                        .sized(0.6f, 1.99f),
                DarkfuLatexWolfMaleEntity::createLatexAttributes);

        LATEXPURPLEWSWOLF = registerSpawning("latexpurplewswolf", 0x800080, 0x9932CC,
                EntityType.Builder.<LatexpurplewswolfEntity>of(LatexpurplewswolfEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexpurplewswolfEntity::new)
                        .sized(0.6f, 1.9f),
                LatexpurplewswolfEntity::createLatexAttributes);

        LATEXTHREEMONTHWOLF = registerSpawning("latexthreemonthwolf", 0x8B4513, 0xCD853F,
                EntityType.Builder.<LatexthreemonthwolfEntity>of(LatexthreemonthwolfEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexthreemonthwolfEntity::new)
                        .sized(0.9f, 2.15f),
                LatexthreemonthwolfEntity::createLatexAttributes);

        LATEXPRTPLECOOCWOLF = registerSpawning("latex_purple_cooc_wolf", 0x9370DB, 0xBA55D3,
                EntityType.Builder.<LatexPurplecoocwolfEntity>of(LatexPurplecoocwolfEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexPurplecoocwolfEntity::new)
                        .sized(0.6f, 1.8f),
                LatexPurplecoocwolfEntity::createLatexAttributes);

        LATEX_ICE_FIELD_WOLF_DRAGON = registerSpawning("latex_ice_field_wolf_dragon", 0x87CEEB, 0x4682B4,
                EntityType.Builder.<LatexIceFieldWolfDragonEntity>of(LatexIceFieldWolfDragonEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexIceFieldWolfDragonEntity::new)
                        .sized(0.7f, 1.93f),
                LatexIceFieldWolfDragonEntity::createLatexAttributes);

        LATEXDRAGONFRUITWOLF = registerSpawning("latex_dragon_fruit_wolf", 0xFF6B8B, 0xFF1493,
                EntityType.Builder.<LatexDragonFruitWolfEntity>of(LatexDragonFruitWolfEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexDragonFruitWolfEntity::new)
                        .sized(0.7f, 1.93f),
                LatexDragonFruitWolfEntity::createLatexAttributes);

        // 幼崽变体
        BLACKPUPMALE = registerSpawning("blackpupmale", 0x000000, 0x333333,
                EntityType.Builder.<BlackpupmaleEntity>of(BlackpupmaleEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(BlackpupmaleEntity::new)
                        .sized(0.4f, 0.7f),
                BlackpupmaleEntity::createLatexAttributes);

        WHITEBLUEPUP = registerSpawning("whitebluepup", 0xFFFFFF, 0x87CEEB,
                EntityType.Builder.<WhitebluepupEntity>of(WhitebluepupEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(WhitebluepupEntity::new)
                        .sized(0.6f, 0.6f),
                WhitebluepupEntity::createLatexAttributes);

        // 龙变体
        LATEXICE_DRAGON = registerSpawning("latex_ko_qi_ice_dragon", 0x00CED1, 0x48D1CC,
                EntityType.Builder.<LatexiceDragonEntity>of(LatexiceDragonEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexiceDragonEntity::new)
                        .sized(0.6f, 1.8f),
                LatexiceDragonEntity::createLatexAttributes);

        LATEXYUNXQHOTDRAGON = registerSpawning("latexyunxqhotdragon", 0xFF4500, 0xFF6347,
                EntityType.Builder.<LatexyunxqhotdragonEntity>of(LatexyunxqhotdragonEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexyunxqhotdragonEntity::new)
                        .fireImmune()
                        .sized(0.6f, 1.9f),
                LatexyunxqhotdragonEntity::createLatexAttributes);

        LATEXYUNXQICEDRAGON = registerSpawning("latexyunxqicedragon", 0x87CEFA, 0xB0E2FF,
                EntityType.Builder.<LatexyunxqicedragonEntity>of(LatexyunxqicedragonEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexyunxqicedragonEntity::new)
                        .sized(0.6f, 2f),
                LatexyunxqicedragonEntity::createLatexAttributes);

        LATEXBLUEDRAGON = registerSpawning("latexbluedragon", 0x1E90FF, 0x4169E1,
                EntityType.Builder.<LatexbluedragonEntity>of(LatexbluedragonEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexbluedragonEntity::new)
                        .sized(0.6f, 1.8f),
                LatexbluedragonEntity::createLatexAttributes);

        LATEXYUNQIICEDRAGON = registerSpawning("latex_yun_qi_ice_dragon", 0x00BFFF, 0x87CEEB,
                EntityType.Builder.<LatexYunQiIceDragonEntity>of(LatexYunQiIceDragonEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexYunQiIceDragonEntity::new)
                        .sized(0.7f, 1.93f),
                LatexYunQiIceDragonEntity::createLatexAttributes);

        LATEXDARKPURPLEDRAGONTAUR = registerSpawning("latex_dark_purple_dragon_taur", 0x4B0082, 0x800080,
                EntityType.Builder.<LatexDarkPurpleDragonTaurEntity>of(LatexDarkPurpleDragonTaurEntity::new, MobCategory.MONSTER)
                        .clientTrackingRange(10)
                        .sized(1.6f, 2.5f),
                LatexDarkPurpleDragonTaurEntity::createLatexAttributes);

        LATEXDARKPURPLEDRAGON = registerSpawning("latex_dark_purple_dragon", 0x483D8B, 0x6A5ACD,
                EntityType.Builder.<DarkPurpleLatexDragonEntity>of(DarkPurpleLatexDragonEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(DarkPurpleLatexDragonEntity::new)
                        .sized(0.7f, 1.92f),
                DarkPurpleLatexDragonEntity::createLatexAttributes);

        // BOSS变体 - 可以自定义属性构建器
        LATEX_ICE_FIELD_WOLF_DRAGON_BOSS = registerSpawning("latex_ice_field_wolf_dragon_boss", 0x4682B4, 0x5F9EA0,
                EntityType.Builder.<LatexIceFieldWolfDragonBossEntity>of(LatexIceFieldWolfDragonBossEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexIceFieldWolfDragonBossEntity::new)
                        .sized(1.0f, 2.5f),  // Boss更大
                () -> {  // 自定义Boss属性
                    AttributeSupplier.Builder builder = ChangedEntity.createLatexAttributes();
                    builder.add(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, 500);
                    builder.add(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR, 35);
                    builder.add(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE, 6.0);
                    builder.add(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE, 1.0);
                    return builder;
                });

        LATEXNIGHTOWLDRAGONBOSS = registerSpawning("latex_night_owl_dragon_boss", 0x2C3E50, 0x34495E,
                EntityType.Builder.<LatexNightOwlBossEntity>of(LatexNightOwlBossEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexNightOwlBossEntity::new)
                        .sized(0.9f, 2.2f),
                LatexNightOwlBossEntity::createLatexAttributes);

        LATEXNIGHTOWLDRAGON = registerSpawning("latex_night_owl_dragon", 0x4A6E8B, 0x5D7A9C,
                EntityType.Builder.<LatexNightOwlEntity>of(LatexNightOwlEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexNightOwlEntity::new)
                        .sized(0.7f, 1.92f),
                LatexNightOwlEntity::createLatexAttributes);

        LATEXIQGOLDDRAGON = registerSpawning("latex_iq_gold_dragon", 0xFFD700, 0xDAA520,
                EntityType.Builder.<LatexIqGoldDragonEntity>of(LatexIqGoldDragonEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(LatexIqGoldDragonEntity::new)
                        .sized(0.7f, 1.92f),
                LatexIqGoldDragonEntity::createLatexAttributes);

        // 其他变体
        INKSUGER = registerSpawning("inksuger", 0x000000, 0x333333,
                EntityType.Builder.<InksugerEntity>of(InksugerEntity::new, MobCategory.MONSTER)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(3)
                        .setCustomClientFactory(InksugerEntity::new)
                        .sized(0.6f, 0.6f),
                InksugerEntity::createLatexAttributes);

        // 抛射物不需要刷怪蛋和生成规则
        LATEXTHREEMONTHWOLF_PROJECTILE = registerProjectile("projectile_latexthreemonthwolf",
                EntityType.Builder.<LatexthreemonthwolfEntityProjectile>of(LatexthreemonthwolfEntityProjectile::new, MobCategory.MISC)
                        .setShouldReceiveVelocityUpdates(true)
                        .setTrackingRange(64)
                        .setUpdateInterval(1)
                        .setCustomClientFactory(LatexthreemonthwolfEntityProjectile::new)
                        .sized(0.5f, 0.5f));
    }

    /**
     * 注册可生成实体（带刷怪蛋）
     */
    private static <T extends ChangedEntity> RegistryObject<EntityType<T>> registerSpawning(
            String name,
            int eggBack,
            int eggHighlight,
            EntityType.Builder<T> builder,
            Supplier<AttributeSupplier.Builder> attributes) {

        ResourceLocation resourceLocation = new ResourceLocation(GoodblockMod.MODID, name);
        ENTITY_COLOR_MAP.put(resourceLocation, new Pair<>(eggBack, eggHighlight));

        String regName = resourceLocation.toString();
        RegistryObject<EntityType<T>> entityType = REGISTRY.register(name, () -> builder.build(regName));

        // 存储属性构建器
        ATTR_FUNC_REGISTRY.add(new Pair<>(entityType::get, attributes));

        // 创建刷怪蛋 - 移除 .tab()
        RegistryObject<ForgeSpawnEggItem> spawnEggItem = ITEMS.register(name + "_spawn_egg",
                () -> new ForgeSpawnEggItem(entityType, eggBack, eggHighlight, new Item.Properties()));
        SPAWN_EGGS.put(entityType, spawnEggItem);

        return entityType;
    }

    // 在同一个类中添加事件监听器
    @SubscribeEvent
    public static void addSpawnEggsToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        // 检查是否是自定义的实体Tab
        if (event.getTab() == GoodblockModTabs.GOODBLOCK_ENTITY.get()) {
            // 添加所有刷怪蛋，并检查是否存在
            SPAWN_EGGS.values().forEach(egg -> {
                try {
                    if (egg != null && egg.isPresent()) {
                        event.accept(egg.get());
                    } else {
                        System.out.println("警告: 刷怪蛋不存在 - " + egg);
                    }
                } catch (Exception e) {
                    System.err.println("添加刷怪蛋到创造栏时出错: " + e.getMessage());
                }
            });
        }
    }

    /**
     * 注册抛射物（不带刷怪蛋）
     */
    private static <T extends Entity> RegistryObject<EntityType<T>> registerProjectile(
            String name,
            EntityType.Builder<T> builder) {

        String regName = new ResourceLocation(GoodblockMod.MODID, name).toString();
        return REGISTRY.register(name, () -> builder.build(regName));
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // 执行所有初始化函数
            INIT_FUNC_REGISTRY.forEach(VoidConsumer::accept);

            // 原有的初始化调用
            LatexOrangeFoxEntity.init();
            LatexKcahraSharkEntity.init();
            DarkfuLatexWolfMaleEntity.init();
            DarkPurpleLatexDragonEntity.init();
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
            LatexIceFieldWolfDragonEntity.init();
            LatexDragonFruitWolfEntity.init();
            LatexYunQiIceDragonEntity.init();
            LatexRadiationFoxEntity.init();
            LatexNightOwlBossEntity.init();
            LatexNightOwlEntity.init();
            LatexIqGoldDragonEntity.init();
            LatexDarkPurpleDragonTaurEntity.init();
            LatexIceFieldWolfDragonBossEntity.init();
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        // 使用存储的属性构建器注册所有实体
        ATTR_FUNC_REGISTRY.forEach((pair) ->
                event.put(pair.getFirst().get(), pair.getSecond().get().build())
        );
    }
}