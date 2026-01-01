package net.ltxprogrammer.changed.ability.tree;

import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbilityCounter {
    public final TransfurVariantInstance<?> variantInstance;
    private final Set<ResourceLocation> enabledFeatures = new HashSet<>();
    private final Map<Attribute, Double> baselineAttributes;
    private final Map<Attribute, Double> computedAttributes;

    private static Map<Attribute, Double> getBaseAttributeValues(AttributeMap attributeMap) {
        Map<Attribute, Double> map = new HashMap<>();
        ForgeRegistries.ATTRIBUTES.getValues().stream()
                .filter(attributeMap::hasAttribute)
                .forEach(attribute -> map.put(attribute, attributeMap.getBaseValue(attribute)));
        return map;
    }

    public AbilityCounter(TransfurVariantInstance<?> variantInstance) {
        this.variantInstance = variantInstance;
        this.computedAttributes = getBaseAttributeValues(variantInstance.getHost().getAttributes());
        this.baselineAttributes = Map.copyOf(computedAttributes);
    }

    /**
     * Adds a named feature that built-in processes can check for
     * @param resourceLocation name of the feature
     */
    public void addEnabledFeature(ResourceLocation resourceLocation) {
        enabledFeatures.add(resourceLocation);
    }

    public void addAttributeMultiplier(Attribute attribute, double basePercent) {
        if (!baselineAttributes.containsKey(attribute))
            return;

        computedAttributes.computeIfPresent(attribute, (attr, current) -> {
            return current + baselineAttributes.get(attr) * basePercent;
        });
    }

    public void addAttributeAdder(Attribute attribute, double value) {
        if (!baselineAttributes.containsKey(attribute))
            return;

        computedAttributes.computeIfPresent(attribute, (attr, current) -> {
            return current + value;
        });
    }
}
