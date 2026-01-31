/*
 *    这些为注册类,请将注册写在这里,而不是其它地方!
 */
package net.hhdsj.goodblock.init;

import net.hhdsj.goodblock.Enchantments.ThreeMonthArrowEnchantments;
import net.hhdsj.goodblock.GoodblockMod;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class GoodblockModEnchantmentInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS,  GoodblockMod.MODID);

    public static final RegistryObject<ThreeMonthArrowEnchantments> ThreeMonthArrow = ENCHANTMENTS.register("three_month_latex", ThreeMonthArrowEnchantments::new);
}
