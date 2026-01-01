package net.ltxprogrammer.changed.ability.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.registries.ForgeRegistries;

public class AttributeModifierNodeEffect extends AbilityTree.NodeEffect {
    public static final Codec<AttributeModifierNodeEffect> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            ForgeRegistries.ATTRIBUTES.getCodec().fieldOf("attribute").forGetter(node -> node.attribute),
            Codec.DOUBLE.fieldOf("acquiredBonus").forGetter(node -> node.acquiredBonus),
            Codec.DOUBLE.fieldOf("missingPenalty").forGetter(node -> node.missingPenalty)
    ).apply(builder, AttributeModifierNodeEffect::new));

    public final Attribute attribute;
    public final double acquiredBonus;
    public final double missingPenalty;

    public AttributeModifierNodeEffect(Attribute attribute, double acquiredBonus, double missingPenalty) {
        this.attribute = attribute;
        this.acquiredBonus = acquiredBonus;
        this.missingPenalty = missingPenalty;
    }

    @Override
    public void applyEffect(AbilityCounter counter, boolean unlocked) {
        if (!unlocked)
            counter.addAttributeMultiplier(attribute, missingPenalty);
        else
            counter.addAttributeMultiplier(attribute, acquiredBonus);
    }
}
