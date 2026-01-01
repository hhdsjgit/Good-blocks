package net.foxyas.changedaddon.abilities.interfaces;

import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.AbstractAbilityInstance;

public interface AbilityExtension {

    static AbilityExtension of(AbstractAbilityInstance abilityInstance){
        return (AbilityExtension) abilityInstance;
    }

    default boolean shouldApplyCooldown() {
        return true;
    }
}
