package net.hhdsj.goodblock.init;

import net.ltxprogrammer.changed.Changed;
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

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.entity.*;
import net.ltxprogrammer.changed.entity.beast.*;
import net.ltxprogrammer.changed.init.*;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.ltxprogrammer.changed.util.Color3;
import net.ltxprogrammer.changed.util.EntityUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.event.IModBusEvent;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;
import net.hhdsj.goodblock.entity.latex.TestEntityModel;
import net.hhdsj.goodblock.entity.latex.Latextest;
import net.hhdsj.goodblock.entity.TestEntity;

import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
public class ModTransfurVariants {
    public static final DeferredRegister<TransfurVariant<?>> REGISTRY = 
        ChangedRegistry.TRANSFUR_VARIANT.createDeferred("goodblock");

    public static final RegistryObject<TransfurVariant<?>> LATEXTEST = REGISTRY.register("latextest",
        () -> TransfurVariant.Builder.of(() -> GoodblockModEntities.LATEXTEST.get()).build());
}*/



import net.hhdsj.goodblock.entity.TestEntity;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.hhdsj.goodblock.entity.TestEntity;
import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.hhdsj.goodblock.GoodblockMod; // 导入主类
import net.hhdsj.goodblock.entity.LatextestEntity;
/*
public class ModTransfurVariants {
    public static final DeferredRegister<TransfurVariant<?>> REGISTRY = 
        DeferredRegister.create(ChangedRegistry.TRANSFUR_VARIANT.get(), "goodblock");

    public static final RegistryObject<TransfurVariant<TestEntity>> LATEXTEST = 
        REGISTRY.register("test_entity", () -> 
            TransfurVariant.Builder.<TestEntity>of(() -> 
                GoodblockModEntities.LATEXTEST.get() // 确保这里与注册名一致
            ).build()
        );
}*/
public class ModTransfurVariants {
    public static final DeferredRegister<TransfurVariant<?>> REGISTRY = 
        DeferredRegister.create(ChangedRegistry.TRANSFUR_VARIANT.get(), GoodblockMod.MODID);

    // 关键修改：确保LatextestEntity继承自ChangedEntity
    public static final RegistryObject<TransfurVariant<?>> LATEXTEST_SAFE = 
        REGISTRY.register("latextest", () -> {
            @SuppressWarnings("unchecked")
            EntityType<? extends ChangedEntity> type = 
                (EntityType<? extends ChangedEntity>)(Object)GoodblockModEntities.LATEXTEST.get();
            return TransfurVariant.Builder.of(() -> type).build();
        });
}














