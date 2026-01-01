package net.ltxprogrammer.changed.init;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.effect.Caffeinated;
import net.ltxprogrammer.changed.effect.Hypercoagulation;
import net.ltxprogrammer.changed.effect.Shock;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangedEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Changed.MODID);

    public static final RegistryObject<Hypercoagulation> HYPERCOAGULATION = REGISTRY.register("hypercoagulation", Hypercoagulation::new);
    public static final RegistryObject<Shock> SHOCK = REGISTRY.register("shock", Shock::new);
    public static final RegistryObject<Caffeinated> CAFFEINATED = REGISTRY.register("caffeinated", Caffeinated::new);
}
