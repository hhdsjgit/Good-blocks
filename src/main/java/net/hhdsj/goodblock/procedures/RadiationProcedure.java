package net.hhdsj.goodblock.procedures;

import net.hhdsj.goodblock.procedures.api.ProgressTransfurExt;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

public class RadiationProcedure {
	public static void execute(LevelAccessor world, LivingEntity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player player) {
			TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant(player);
			if (variant != null) {
				return;
			}
		}
		if (entity.getHealth() >= 5) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE)), 1);
		}else{
			if (entity instanceof Player player) {
				player.displayClientMessage(Component.translatable("effect.goodblock.radiation.tf").withStyle((style -> {
					Style returnStyle = style.withColor(ChatFormatting.WHITE);
					returnStyle = returnStyle.withItalic(true);
					return returnStyle;
				})), true);
			}
			ProgressTransfurExt.tf(entity,5f,"goodblock:form_latex_radiation_fox", TransfurCause.FACE_HAZARD);
			entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 90, 2, false, false), entity);
			entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 2, false, false), entity);
		}
	}
}
