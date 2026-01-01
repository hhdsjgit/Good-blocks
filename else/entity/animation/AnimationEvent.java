package net.ltxprogrammer.changed.entity.animation;

import com.mojang.serialization.Codec;

public class AnimationEvent<T extends AnimationParameters> {
    private final Codec<T> codec;

    public static final Codec<NoParameters> NO_PARAMETERS = Codec.unit(() -> NoParameters.INSTANCE);

    public AnimationEvent(Codec<T> codec) {
        this.codec = codec;
    }

    public Codec<T> getCodec() {
        return this.codec;
    }
}
