
package net.hhdsj.goodblock.item;

import net.hhdsj.goodblock.event.GoodblockProcessTransfur;
import net.hhdsj.goodblock.init.GoodblockModMobEffects;
import net.hhdsj.goodblock.procedures.ProgressTransfurExt;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.hhdsj.goodblock.init.GoodblockModTabs;
import org.jetbrains.annotations.NotNull;

import static java.lang.Math.random;

public class ImpureuraniumItem extends Item {
	private static final ResourceLocation FORM_VARIANT = new ResourceLocation("goodblock", "form_latex_yunxq_hot_dragon");

	public ImpureuraniumItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

	//如果玩家把铀粉末拿在手上时,执行下面的代码(qwp)
	@Override
	public void inventoryTick(ItemStack itemstack, Level world, @NotNull Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);

		if (selected) {
			if (entity == null) {
				return;
			}
			//获取现在的实体,给实体个效果
			if (entity instanceof LivingEntity _entity) {
				_entity.addEffect(new MobEffectInstance(GoodblockModMobEffects.RADIATION.get(), 60, 1));
                if (random() >= 0.5f) {

					ProgressTransfurExt.execute(_entity,"goodblock:form_latex_yunxq_hot_dragon");

                }
            }
		}
	}
}
