package net.foxyas.changedaddon.init;

import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;

import static net.foxyas.changedaddon.ChangedAddonMod.MODID;

public class ChangedAddonPaintingTypes {
    public static final DeferredRegister<Motive> PAINTING_TYPES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, MODID);

    public static final RegistryObject<Motive> LUMINARCTIC_LEOPARD_FEMALE_SELFIE = register("luminarctic_leopard_female_selfie", 48, 48);
    public static final RegistryObject<Motive> LUMINARCTIC_LEOPARD_MALE_SELFIE = register("luminarctic_leopard_male_selfie", 48, 48);
    public static final RegistryObject<Motive> LUMINARCTIC_LEOPARD_MALE_MAD_SELFIE = register("luminarctic_leopard_male_mad_selfie", 48, 48);
    public static final RegistryObject<Motive> FIGHTING_EXP_9_POV = register("fighting_exp9_pov", 48, 48);

    public static List<Motive> glowPaintings() {
        return List.of(LUMINARCTIC_LEOPARD_MALE_MAD_SELFIE.get(), FIGHTING_EXP_9_POV.get());
    }

    private static RegistryObject<Motive> register(String registryName, int pWidth, int pHeight) {
        return PAINTING_TYPES.register(registryName, () -> new Motive(pWidth, pHeight));
    }
}
