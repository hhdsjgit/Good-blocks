
/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.hhdsj.goodblock.GoodblockMod;

public class GoodblockModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GoodblockMod.MODID);
	public static final RegistryObject<SoundEvent> INK_SANS = REGISTRY.register("ink_sans", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("goodblock", "ink_sans")));
	public static final RegistryObject<SoundEvent> ITEM_ARMOR_EQUIP_NETHERITE = REGISTRY.register("item.armor.equip_netherite", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("goodblock", "item.armor.equip_netherite")));
	public static final RegistryObject<SoundEvent> GNUSMAS_GM_SOUNDFONT_2_00 = REGISTRY.register("gnusmas_gm_soundfont_2.00", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("goodblock", "gnusmas_gm_soundfont_2.00")));
	public static final RegistryObject<SoundEvent> NO_STOP = REGISTRY.register("no_stop", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("goodblock", "no_stop")));
	public static final RegistryObject<SoundEvent> THE_FLUFFY_HEARTBEAT_IN_THE_CUBICLE = REGISTRY.register("the_fluffy_heartbeat_in_the_cubicle",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation("goodblock", "the_fluffy_heartbeat_in_the_cubicle")));
	public static final RegistryObject<SoundEvent> ANIT_FURRY_MUSIC = REGISTRY.register("anit_furry_music", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("goodblock", "anit_furry_music")));
	public static final RegistryObject<SoundEvent> SRENING_OGG1 = REGISTRY.register("srening_ogg1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("goodblock", "srening_ogg1")));
	public static final RegistryObject<SoundEvent> THE_FLUFFY_HEARTBEATINTHE_CUBICLEMUSIC = REGISTRY.register("the_fluffy_heartbeatinthe_cubiclemusic",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation("goodblock", "the_fluffy_heartbeatinthe_cubiclemusic")));
	public static final RegistryObject<SoundEvent> FLUTEMUSICA_1RECORDS = REGISTRY.register("flutemusica_1records", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("goodblock", "flutemusica_1records")));
}
