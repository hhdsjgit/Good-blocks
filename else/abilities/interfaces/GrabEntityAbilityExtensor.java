package net.foxyas.changedaddon.abilities.interfaces;

import net.foxyas.changedaddon.init.ChangedAddonCriteriaTriggers;
import net.foxyas.changedaddon.init.ChangedAddonSounds;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public interface GrabEntityAbilityExtensor {

    void setSafeMode(boolean safeMode);

    boolean isSafeMode();

    LivingEntity grabber();

    int SNUGGLED_COOLDOWN = 20;

    default void runHug(@NotNull LivingEntity livingEntity) {
        if (grabber() instanceof Player player) {
            if (!player.getLevel().isClientSide()) {
                player.displayClientMessage(new TranslatableComponent("ability.changed_addon.grab_entity.extender.hugger", livingEntity.getDisplayName()), true);
                if (player instanceof ServerPlayer serverPlayer) {
                    ChangedAddonCriteriaTriggers.GRAB_ENTITY_TRIGGER.trigger(serverPlayer, ProcessTransfur.getPlayerTransfurVariant(serverPlayer), "hug");
                }
                player.getLevel().playSound(null, player, ChangedAddonSounds.PLUSHY_SOUND, SoundSource.BLOCKS, 1, 1);
                setSnuggled(true);
            }
            if (livingEntity instanceof Player grabbedPlayer) {
                if (!grabbedPlayer.getLevel().isClientSide())
                    grabbedPlayer.displayClientMessage(new TranslatableComponent("ability.changed_addon.grab_entity.extender.hugged", player.getDisplayName()), true);
            }
        }
    }

    boolean isAlreadySnuggled();

    void setSnuggled(boolean value);

    boolean isAlreadySnuggledTight();

    void setSnuggledTight(boolean value);

    default void runTightHug(@NotNull LivingEntity livingEntity) {
        if (grabber() instanceof Player player) {
            if (!player.getLevel().isClientSide()) {
                player.displayClientMessage(new TranslatableComponent("ability.changed_addon.grab_entity.extender.hugger.tight", livingEntity.getDisplayName()), true);
                if (player instanceof ServerPlayer serverPlayer) {
                    ChangedAddonCriteriaTriggers.GRAB_ENTITY_TRIGGER.trigger(serverPlayer, ProcessTransfur.getPlayerTransfurVariant(serverPlayer), "hug");
                    ChangedAddonCriteriaTriggers.GRAB_ENTITY_TRIGGER.trigger(serverPlayer, ProcessTransfur.getPlayerTransfurVariant(serverPlayer), "hug_tight");
                }
                player.getLevel().playSound(null, player, ChangedAddonSounds.PLUSHY_SOUND, SoundSource.BLOCKS, 1, 1);
                setSnuggledTight(true);
            }
            if (livingEntity instanceof Player grabbedPlayer) {
                if (!grabbedPlayer.getLevel().isClientSide()) {
                    grabbedPlayer.displayClientMessage(new TranslatableComponent("ability.changed_addon.grab_entity.extender.hugged.tight", player.getDisplayName()), true);
                }
            }
        }
    }
}
