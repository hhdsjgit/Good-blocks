package net.ltxprogrammer.changed.init;

import net.ltxprogrammer.changed.Changed;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ChangedSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Changed.MODID);

    private static RegistryObject<SoundEvent> register(String id) {
        return REGISTRY.register(id, () -> SoundEvent.createVariableRangeEvent(Changed.modResource(id)));
    }

    private static RegistryObject<SoundEvent> register(String id, Function<ResourceLocation, SoundEvent> finalizer) {
        return REGISTRY.register(id, () -> finalizer.apply(Changed.modResource(id)));
    }

    public static final RegistryObject<SoundEvent> ATTACK1 = register("attack1");
    public static final RegistryObject<SoundEvent> BLOW1 = register("blow1");
    public static final RegistryObject<SoundEvent> BOW2 = register("bow2");
    public static final RegistryObject<SoundEvent> CLOSE1 = register("close1");
    public static final RegistryObject<SoundEvent> BUZZER1 = register("buzzer1");
    public static final RegistryObject<SoundEvent> CHIME2 = register("chime2");
    public static final RegistryObject<SoundEvent> CLOSE3 = register("close3");
    public static final RegistryObject<SoundEvent> CRASH = register("crash");
    public static final RegistryObject<SoundEvent> EQUIP1 = register("equip1");
    public static final RegistryObject<SoundEvent> EQUIP2 = register("equip2");
    public static final RegistryObject<SoundEvent> EQUIP3 = register("equip3");
    public static final RegistryObject<SoundEvent> EVASION = register("evasion");
    public static final RegistryObject<SoundEvent> FIRE = register("fire");
    public static final RegistryObject<SoundEvent> GOO = register("goo");
    public static final RegistryObject<SoundEvent> ICE2 = register("ice2");
    public static final RegistryObject<SoundEvent> KEY = register("key");
    public static final RegistryObject<SoundEvent> LATEX_DRIP = register("latex_drip");
    public static final RegistryObject<SoundEvent> MONSTER2 = register("monster2");
    public static final RegistryObject<SoundEvent> OPEN1 = register("open1");
    public static final RegistryObject<SoundEvent> OPEN2 = register("open2");
    public static final RegistryObject<SoundEvent> OPEN3 = register("open3");
    public static final RegistryObject<SoundEvent> PARALYZE1 = register("paralyze1");
    public static final RegistryObject<SoundEvent> PARALYZE3 = register("paralyze3");
    public static final RegistryObject<SoundEvent> POISON = register("poison");
    public static final RegistryObject<SoundEvent> SAVE = register("save");
    public static final RegistryObject<SoundEvent> SOUND3 = register("sound3");
    public static final RegistryObject<SoundEvent> SHOT1 = register("shot1");
    public static final RegistryObject<SoundEvent> SIREN = register("siren");
    public static final RegistryObject<SoundEvent> SLASH10 = register("slash10");
    public static final RegistryObject<SoundEvent> SWITCH1 = register("switch1");
    public static final RegistryObject<SoundEvent> SWITCH2 = register("switch2");
    public static final RegistryObject<SoundEvent> SWORD1 = register("sword1");
    public static final RegistryObject<SoundEvent> VACUUM = register("vacuum");

    public static final RegistryObject<SoundEvent> PUDDLE_ALERT = register("puddle_alert");

    public static final RegistryObject<SoundEvent> EXOSKELETON_STEP = register("exoskeleton_step");
    public static final RegistryObject<SoundEvent> EXOSKELETON_CHIME = register("exoskeleton_chime");
    public static final RegistryObject<SoundEvent> EXOSKELETON_LOCK = register("exoskeleton_lock");

    public static final RegistryObject<SoundEvent> MUSIC_BLACK_GOO_ZONE = register("music.black_goo_zone");
    public static final RegistryObject<SoundEvent> MUSIC_CRYSTAL_ZONE = register("music.crystal_zone");
    public static final RegistryObject<SoundEvent> MUSIC_GAS_ROOM = register("music.gas_room");
    public static final RegistryObject<SoundEvent> MUSIC_LABORATORY = register("music.laboratory");
    public static final RegistryObject<SoundEvent> MUSIC_OUTSIDE_THE_TOWER = register("music.outside_the_tower");
    public static final RegistryObject<SoundEvent> MUSIC_PURO_THE_BLACK_GOO = register("music.puro_the_black_goo");
    public static final RegistryObject<SoundEvent> MUSIC_PUROS_HOME = register("music.puros_home");
    public static final RegistryObject<SoundEvent> MUSIC_THE_LIBRARY = register("music.the_library");
    public static final RegistryObject<SoundEvent> MUSIC_THE_LION_CHASE = register("music.the_lion_chase");
    public static final RegistryObject<SoundEvent> MUSIC_THE_SCARLET_CRYSTAL_MINE = register("music.the_scarlet_crystal_mine");
    public static final RegistryObject<SoundEvent> MUSIC_THE_SHARK = register("music.the_shark");
    public static final RegistryObject<SoundEvent> MUSIC_THE_SQUID_DOG = register("music.the_squid_dog");
    public static final RegistryObject<SoundEvent> MUSIC_THE_WHITE_GOO_JUNGLE = register("music.the_white_goo_jungle");
    public static final RegistryObject<SoundEvent> MUSIC_THE_WHITE_TAIL_CHASE_PART_1 = register("music.the_white_tail_chase_part_1");
    public static final RegistryObject<SoundEvent> MUSIC_THE_WHITE_TAIL_CHASE_PART_2 = register("music.the_white_tail_chase_part_2");
    public static final RegistryObject<SoundEvent> MUSIC_VENT_PIPE = register("music.vent_pipe");

    public static class Types {
        // Represents a sound type that has no sound
        public static final SoundType NONE = new SoundType(-100, 1, SoundEvents.METAL_BREAK, SoundEvents.METAL_STEP, SoundEvents.METAL_PLACE, SoundEvents.METAL_HIT, SoundEvents.METAL_FALL);
    }

    public static void broadcastSound(ServerLevel level, RegistryObject<SoundEvent> event, SoundSource source, double x, double y, double z, float volume, float pitch) {
        level.getServer().getPlayerList().broadcastAll(new ClientboundSoundPacket(
                event.getHolder().orElseThrow(), SoundSource.BLOCKS, x, y, z, volume, pitch, level.random.nextLong()));
    }

    public static void broadcastSound(ServerLevel level, RegistryObject<SoundEvent> event, BlockPos blockPos, float volume, float pitch) {
        broadcastSound(level, event, SoundSource.BLOCKS, blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5, volume, pitch);
    }

    public static void broadcastSound(Entity entity, RegistryObject<SoundEvent> event, float volume, float pitch) {
        if (entity.level() instanceof ServerLevel serverLevel) {
            broadcastSound(serverLevel, event, SoundSource.NEUTRAL, entity.getX(), entity.getY(), entity.getZ(), volume, pitch);
        }
    }

    public static void broadcastSound(ServerLevel level, ResourceLocation name, SoundSource source, double x, double y, double z, float volume, float pitch) {
        level.getServer().getPlayerList().broadcastAll(new ClientboundSoundPacket(
                ForgeRegistries.SOUND_EVENTS.getHolder(name).orElseThrow(), source, x, y, z, volume, pitch, level.random.nextLong()));
    }

    public static void broadcastSound(Entity entity, ResourceLocation name, float volume, float pitch) {
        if (entity.level() instanceof ServerLevel serverLevel) {
            serverLevel.getChunkSource().broadcastAndSend(entity, new ClientboundSoundPacket(
                    ForgeRegistries.SOUND_EVENTS.getHolder(name).orElseThrow(), SoundSource.NEUTRAL, entity.getX(), entity.getY(), entity.getZ(), volume, pitch, serverLevel.random.nextLong()));
        }
    }

    public static void sendLocalSound(Player player, RegistryObject<SoundEvent> event, float volume, float pitch) {
        if (player instanceof ServerPlayer serverPlayer)
            serverPlayer.connection.send(new ClientboundSoundPacket(
                    event.getHolder().orElseThrow(), SoundSource.NEUTRAL, player.getX(), player.getY(), player.getZ(), volume, pitch, player.getRandom().nextLong()));
    }

    public static void sendLocalSound(Player player, BlockPos blockPos, RegistryObject<SoundEvent> event, float volume, float pitch) {
        if (player instanceof ServerPlayer serverPlayer)
            serverPlayer.connection.send(new ClientboundSoundPacket(
                    event.getHolder().orElseThrow(), SoundSource.NEUTRAL, blockPos.getX(), blockPos.getY(), blockPos.getZ(), volume, pitch, player.getRandom().nextLong()));
    }

    public static void sendLocalSound(Player player, Vec3 pos, RegistryObject<SoundEvent> event, float volume, float pitch) {
        if (player instanceof ServerPlayer serverPlayer)
            serverPlayer.connection.send(new ClientboundSoundPacket(
                    event.getHolder().orElseThrow(), SoundSource.NEUTRAL, pos.x(), pos.y(), pos.z(), volume, pitch, player.getRandom().nextLong()));
    }
}
