package net.foxyas.changedaddon.init;

import net.foxyas.changedaddon.ChangedAddonMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChangedAddonSounds {

    private static final Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();

    public static final SoundEvent ARMOR_EQUIP = registerSimple("armor_equip");
    public static final SoundEvent GECKO_BEEP = registerSimple("gecko_sound");
    public static final SoundEvent PLUSHY_SOUND = registerSimple("block.plushes.sfx");
    public static final SoundEvent SPRAY_SOUND = registerSimple("spray.sound");
    public static final SoundEvent UNTRANSFUR = registerSimple("untransfur.sound");
    public static final SoundEvent WARN = registerSimple("warn");

    public static final SoundEvent EXP10_THEME = registerSimple("experiment10_theme");
    public static final SoundEvent EXP9_THEME = registerSimple("music.boss.exp9");
    public static final SoundEvent LUMINARCTIC_LEOPARD = registerSimple("music.boss.luminarctic_leopard");
    public static final SoundEvent HAMMER_SWING = registerSimple("hammer_swing");
    public static final SoundEvent HAMMER_GUN_SHOT = registerSimple("hammer_gun_shot");

    public static final SoundEvent PROTOTYPE_IDEA = registerSimple("entity.prototype.idea_sfx");

    public static void playSimpleSound(SoundEvent soundEvent, SoundSource source, Entity entity, float volume, float p) {
        entity.getLevel().playSound(null, entity.getX(), entity.getY(), entity.getZ(), soundEvent, source, volume, p);
    }

    public static void playSimpleSound(SoundEvent soundEvent, SoundSource source, Level level, Vec3 position, float volume, float p) {
        level.playSound(null, position.x(), position.y(), position.z(), soundEvent, source, volume, p);
    }


    private static SoundEvent registerSimple(String path) {
        ResourceLocation loc = ChangedAddonMod.resourceLoc(path);
        SoundEvent sound = new SoundEvent(loc);
        REGISTRY.put(loc, sound);
        return sound;
    }

    private static SoundEvent register(String path, SoundEvent sound) {
        REGISTRY.put(ChangedAddonMod.resourceLoc(path), sound);
        return sound;
    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
            event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
    }
}
