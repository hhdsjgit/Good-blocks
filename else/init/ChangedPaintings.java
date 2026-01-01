package net.ltxprogrammer.changed.init;

import net.ltxprogrammer.changed.Changed;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.*;

public class ChangedPaintings {
    public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, Changed.MODID);

    private static RegistryObject<PaintingVariant> register(int width, int height, String name) {
        return REGISTRY.register(name, () -> new PaintingVariant(width, height));
    }

    public static final RegistryObject<PaintingVariant> A_LAZY_FOX_ON_THE_PAPER = register(48, 48, "a_lazy_fox_on_the_paper");
    public static final RegistryObject<PaintingVariant> CREATION_OF_LIN = register(64, 32, "creation_of_lin");
    public static final RegistryObject<PaintingVariant> DARK_LATEX_MASK = register(16, 16, "dark_latex_mask");
    public static final RegistryObject<PaintingVariant> DR_K = register(32, 32, "dr_k");
    public static final RegistryObject<PaintingVariant> EARTH_AND_MOON = register(48, 32, "earth_and_moon");
    public static final RegistryObject<PaintingVariant> KADE_TAIL = register(32, 32, "kade_tail");
    public static final RegistryObject<PaintingVariant> PURO_DOODLE = register(32, 32, "puro_doodle");
    public static final RegistryObject<PaintingVariant> PURO_PLACE = register(32, 32, "puro_place");
    public static final RegistryObject<PaintingVariant> PURO_POINT = register(48, 32, "puro_point");
    public static final RegistryObject<PaintingVariant> PURO_PORTRAIT = register(32, 48, "puro_portrait");
    public static final RegistryObject<PaintingVariant> SHARKS_GAZE = register(64, 64, "sharks_gaze");
    public static final RegistryObject<PaintingVariant> TSC_BUILDING = register(64, 48, "thunder_science_building");
}
