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

import java.util.function.Supplier;
/**
public class ModTransfurVariants {
    public static final DeferredRegister<TransfurVariant<?>> REGISTRY = 
        ChangedRegistry.TRANSFUR_VARIANT.createDeferred("goodblock");

    public static final RegistryObject<TransfurVariant<?>> DRAGON = REGISTRY.register("dragon",
        () -> TransfurVariant.Builder.of(ModEntities.DRAGON_LATEX.get())
            .stepSize(0.8f) // 更大的步伐
            .glide()        // 允许滑翔
            .addAbility(ModAbilities.DRAGON_BREATH) // 添加龙息技能
            .breatheMode(BreatheMode.ANY) // 水下呼吸
            .sound(new ResourceLocation("goodblock:entity.dragon.roar"))
            .build()
    );
}
*/