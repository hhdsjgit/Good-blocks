package net.foxyas.changedaddon.abilities;

import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.AbstractAbilityInstance;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;

public class PassiveAbilityInstance extends AbstractAbilityInstance {
    public boolean isActivated = true;

    public PassiveAbilityInstance(AbstractAbility<PassiveAbilityInstance> ability, IAbstractChangedEntity entity) {
        super(ability, entity);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public boolean canKeepUsing() {
        return true;
    }

    @Override
    public void startUsing() {
        isActivated = !isActivated;
        entity.displayClientMessage(this.isActivated ?
                        new TranslatableComponent("changed_addon.ability.passive.toggle.on") :
                        new TranslatableComponent("changed_addon.ability.passive.toggle.off")
                , true);
    }

    @Override
    public void tick() {

    }

    @Override
    public void stopUsing() {

    }

    public boolean isActivated() {
        return isActivated;
    }

    @Override
    public void saveData(CompoundTag tag) {
        super.saveData(tag);
        tag.putBoolean("isActivated", this.isActivated());
    }

    @Override
    public void readData(CompoundTag tag) {
        super.readData(tag);
        if (tag.contains("isActivated")) this.isActivated = tag.getBoolean("isActivated");
    }

    @Override
    public void tickIdle() {
        super.tickIdle();
        if (this.getAbility() instanceof PassiveAbility passiveAbility) {
            if (isActivated()) {
                passiveAbility.passiveAction.accept(this.entity);
            }
        }
    }
}
