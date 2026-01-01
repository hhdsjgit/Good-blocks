package net.foxyas.changedaddon.init;

import com.mojang.serialization.Codec;
import net.foxyas.changedaddon.ChangedAddonMod;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ChangedAddonParticleTypes {
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ChangedAddonMod.MODID);
    public static final RegistryObject<ParticleType<?>> SOLVENT_PARTICLE = REGISTRY.register("solvent_particle", () -> new SimpleParticleType(true));



    private static <T extends ParticleOptions> RegistryObject<ParticleType<T>> register(String name, ParticleOptions.Deserializer<T> dec, final Function<ParticleType<T>, Codec<T>> fn) {
        var type = new ParticleType<T>(false, dec) {
            public Codec<T> codec() {
                return fn.apply(this);
            }
        };

        return REGISTRY.register(name, () -> new ParticleType<T>(false, dec) {
            public Codec<T> codec() {
                return fn.apply(this);
            }
        });
    }

}
