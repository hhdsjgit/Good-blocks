package net.foxyas.changedaddon.init;

import com.mojang.serialization.Codec;
import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.client.model.animations.parameters.DodgeAnimationParameters;
import net.foxyas.changedaddon.client.model.animations.parameters.PatReactionAnimationParameters;
import net.ltxprogrammer.changed.entity.animation.AnimationEvent;
import net.ltxprogrammer.changed.entity.animation.AnimationParameters;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ChangedAddonAnimationEvents {
    public static DeferredRegister<AnimationEvent<?>> REGISTRY = ChangedRegistry.ANIMATION_EVENTS.createDeferred(ChangedAddonMod.MODID);

    public static RegistryObject<AnimationEvent<DodgeAnimationParameters>> DODGE_LEFT = register("dodge_left", DodgeAnimationParameters.CODEC);
    public static RegistryObject<AnimationEvent<DodgeAnimationParameters>> DODGE_RIGHT = register("dodge_right", DodgeAnimationParameters.CODEC);
    public static RegistryObject<AnimationEvent<DodgeAnimationParameters>> DODGE_WEAVE_LEFT = register("dodge_weave_left", DodgeAnimationParameters.CODEC);
    public static RegistryObject<AnimationEvent<DodgeAnimationParameters>> DODGE_WEAVE_RIGHT = register("dodge_weave_right", DodgeAnimationParameters.CODEC);
    public static RegistryObject<AnimationEvent<DodgeAnimationParameters>> DODGE_DOWN_LEFT = register("dodge_down_left", DodgeAnimationParameters.CODEC);
    public static RegistryObject<AnimationEvent<DodgeAnimationParameters>> DODGE_DOWN_RIGHT = register("dodge_down_right", DodgeAnimationParameters.CODEC);
    public static RegistryObject<AnimationEvent<PatReactionAnimationParameters>> PAT_REACTION = register("pat_reaction", PatReactionAnimationParameters.CODEC);

    private static <T extends AnimationParameters> RegistryObject<AnimationEvent<T>> register(String name, Codec<T> parameters) {
        return REGISTRY.register(name, () -> new AnimationEvent<>(parameters));
    }
}
