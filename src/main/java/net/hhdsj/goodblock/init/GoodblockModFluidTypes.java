package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.GoodblockMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GoodblockModFluidTypes {
    public static final DeferredRegister<FluidType> REGISTRY =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, GoodblockMod.MODID);

    public static final RegistryObject<FluidType> FLUIDHOTTEST_TYPE = REGISTRY.register("fluidhottest",
            () -> {
                FluidType type = new FluidType(FluidType.Properties.create()
                        .descriptionId("block.goodblock.fluidhottest")
                        .canSwim(false)
                        .canDrown(true)
                        .canExtinguish(false)
                        .canConvertToSource(false)
                        .supportsBoating(false)
                        .density(3000)
                        .viscosity(6000)
                        .temperature(1000)
                        .lightLevel(15)
                        .rarity(net.minecraft.world.item.Rarity.EPIC)
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                        .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)

                );
                return type;
            }
    );
}