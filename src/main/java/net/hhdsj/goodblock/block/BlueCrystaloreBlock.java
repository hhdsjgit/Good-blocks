
package net.hhdsj.goodblock.block;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.List;
import java.util.Collections;

public class BlueCrystaloreBlock extends Block {
	public BlueCrystaloreBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		LootContext context = builder.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);

		// 检查是否使用精准采集
		if (context.getParamOrNull(LootContextParams.TOOL) != null) {
			ItemStack tool = context.getParam(LootContextParams.TOOL);

			// 如果工具上有精准采集附魔
			if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, tool) > 0) {
				// 精准采集时掉落原矿石方块
				return Collections.singletonList(new ItemStack(this));
			}
		}
		ItemStack customDrop = new ItemStack(Items.DIAMOND);
		customDrop.setCount(1 + context.getRandom().nextInt(3)); // 1-3个
		// 非精准采集时掉落自定义物品
		return Collections.singletonList(customDrop);
	}
}
