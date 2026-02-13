
/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.GoodblockMod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GoodblockModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, GoodblockMod.MODID);
	public static final RegistryObject<PaintingVariant> HOME = REGISTRY.register("home", () -> new PaintingVariant(64, 64));
	public static final RegistryObject<PaintingVariant> CITYOLD = REGISTRY.register("cityold", () -> new PaintingVariant(32, 32));
	public static final RegistryObject<PaintingVariant> PAINTINKSUGER = REGISTRY.register("paintinksuger", () -> new PaintingVariant(32, 32));
}
