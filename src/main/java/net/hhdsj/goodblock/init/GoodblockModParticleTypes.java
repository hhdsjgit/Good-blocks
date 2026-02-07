
/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 * 					粒子
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.hhdsj.goodblock.GoodblockMod;

public class GoodblockModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, GoodblockMod.MODID);
	public static final RegistryObject<ParticleType<?>> PARHOTX = REGISTRY.register("parhotx", () -> new SimpleParticleType(true));
}
