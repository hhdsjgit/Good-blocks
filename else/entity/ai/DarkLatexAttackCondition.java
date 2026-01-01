package net.ltxprogrammer.changed.entity.ai;

import com.mojang.serialization.DataResult;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;

import java.util.Arrays;

public enum DarkLatexAttackCondition implements StringRepresentable {
    NEVER("never"),
    ALWAYS("always"),
    OWNER_IS_HOSTILE("owner_is_hostile");

    private final String serializedName;

    DarkLatexAttackCondition(String serializedName) {
        this.serializedName = serializedName;
    }

    @Override
    public String getSerializedName() {
        return serializedName;
    }

    public static DataResult<DarkLatexAttackCondition> fromSerial(String serializedName) {
        return Arrays.stream(values()).filter(value -> value.serializedName.equals(serializedName))
                .findAny().map(DataResult::success).orElse(DataResult.error(
                        () -> "Invalid attack condition " + serializedName
                ));
    }

    public DarkLatexAttackCondition cycle() {
        if (this.ordinal() + 1 == values().length)
            return values()[0];
        else
            return values()[this.ordinal() + 1];
    }

    public Component getDisplayText() {
        return Component.translatable("changed.tamed_dark_latex.attack_condition." + serializedName);
    }
}
