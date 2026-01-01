package net.ltxprogrammer.changed.init;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.world.features.structures.Beehive;
import net.ltxprogrammer.changed.world.features.structures.DecayedLab;
import net.ltxprogrammer.changed.world.features.structures.Facility;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ChangedStructureTypes {
    public static DeferredRegister<StructureType<?>> REGISTRY = DeferredRegister.create(Registries.STRUCTURE_TYPE, Changed.MODID);

    public static RegistryObject<StructureType<Beehive>> BEEHIVE = REGISTRY.register("beehive", () -> () -> Beehive.CODEC);
    public static RegistryObject<StructureType<DecayedLab>> DECAYED_LAB = REGISTRY.register("decayed_lab", () -> () -> DecayedLab.CODEC);
    public static RegistryObject<StructureType<Facility>> FACILITY = REGISTRY.register("facility", () -> () -> Facility.CODEC);
}
