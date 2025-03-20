
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hhdsj.goodblock.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoodblockModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("goodblock", "gnusmas_gm_soundfont_2.00"), new SoundEvent(new ResourceLocation("goodblock", "gnusmas_gm_soundfont_2.00")));
		REGISTRY.put(new ResourceLocation("goodblock", "anit_furry_music"), new SoundEvent(new ResourceLocation("goodblock", "anit_furry_music")));
		REGISTRY.put(new ResourceLocation("goodblock", "item.armor.equip_netherite"), new SoundEvent(new ResourceLocation("goodblock", "item.armor.equip_netherite")));
		REGISTRY.put(new ResourceLocation("goodblock", "no_stop"), new SoundEvent(new ResourceLocation("goodblock", "no_stop")));
		REGISTRY.put(new ResourceLocation("goodblock", "ink_sans"), new SoundEvent(new ResourceLocation("goodblock", "ink_sans")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
