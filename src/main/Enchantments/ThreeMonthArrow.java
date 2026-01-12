package net.hhdsj.goodblock.Enchantments;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ThreeMonthArrow extends Enchantment {

    public ThreeMonthArrow() {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
    @Override
    public int getMaxLevel() {
        return 1;
    }
    @Override
    public boolean isCurse() {
        return true;
    }
    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }
    @Override
    public boolean isDiscoverable() {
        return true;
    }
}
