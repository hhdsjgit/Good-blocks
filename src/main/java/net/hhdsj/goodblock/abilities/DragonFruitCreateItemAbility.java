package net.hhdsj.goodblock.abilities;

import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.ability.SimpleAbility;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class DragonFruitCreateItemAbility extends SimpleAbility {
    public DragonFruitCreateItemAbility(Supplier<ItemStack> itemSupplier, float exhaustion, float minimumHunger) {
        this.itemSupplier = itemSupplier;
        this.exhaustion = exhaustion;
        this.minimumHunger = minimumHunger;
    }

    private final Supplier<ItemStack> itemSupplier;
    private final float exhaustion;
    private final float minimumHunger;

    @Override
    public boolean canUse(IAbstractChangedEntity entity) {
        return entity.getFoodLevel() > minimumHunger || entity.isCreative();
    }

    @Override
    public boolean canKeepUsing(IAbstractChangedEntity entity) { return false; }

    @Override
    public void startUsing(IAbstractChangedEntity entity) {
        var item = itemSupplier.get();
        if (!entity.addItem(item))
            entity.drop(item, false);
        if (!entity.isCreative())
            entity.causeFoodExhaustion(exhaustion);
    }

    @Override
    public UseType getUseType(IAbstractChangedEntity entity) {
        return UseType.CHARGE_TIME;
    }

    @Override
    public int getChargeTime(IAbstractChangedEntity entity) {
        return 20;
    }

    @Override
    public int getCoolDown(IAbstractChangedEntity entity) {
        return 20;
    }
}
