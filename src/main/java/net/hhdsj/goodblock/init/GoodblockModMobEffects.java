
/*
 *	这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.hhdsj.goodblock.potion.SlowinfectionMobEffect;
import net.hhdsj.goodblock.potion.RadiationMobEffect;
import net.hhdsj.goodblock.potion.LatexhotparMobEffect;
import net.hhdsj.goodblock.GoodblockMod;

public class GoodblockModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GoodblockMod.MODID);
	public static final RegistryObject<MobEffect> RADIATION = REGISTRY.register("radiation", () -> new RadiationMobEffect());
	public static final RegistryObject<MobEffect> LATEXHOTPAR = REGISTRY.register("latexhotpar", () -> new LatexhotparMobEffect());
	public static final RegistryObject<MobEffect> SLOWINFECTION = REGISTRY.register("slowinfection", () -> new SlowinfectionMobEffect());
}
