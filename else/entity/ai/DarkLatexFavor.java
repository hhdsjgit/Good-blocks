package net.ltxprogrammer.changed.entity.ai;

import com.mojang.serialization.DataResult;
import net.minecraft.util.StringRepresentable;

import java.util.Arrays;

public enum DarkLatexFavor implements StringRepresentable {
    NONE("none"),
    FISHING("fishing"),
    CAVING("caving"),
    SUIT_OWNER("suit_owner");

    private final String serializedName;

    DarkLatexFavor(String serializedName) {
        this.serializedName = serializedName;
    }

    @Override
    public String getSerializedName() {
        return serializedName;
    }

    public static DataResult<DarkLatexFavor> fromSerial(String serializedName) {
        return Arrays.stream(values()).filter(value -> value.serializedName.equals(serializedName))
                .findAny().map(DataResult::success).orElse(DataResult.error(
                        () -> "Invalid favor " + serializedName
                ));
    }
}
