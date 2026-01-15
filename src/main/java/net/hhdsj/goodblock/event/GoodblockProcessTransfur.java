package net.hhdsj.goodblock.event;

import com.mojang.logging.LogUtils;
import net.hhdsj.goodblock.GoodblockMod;
import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.entity.*;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.extension.ChangedCompatibility;
import net.ltxprogrammer.changed.init.*;
import net.ltxprogrammer.changed.util.PatreonBenefits;
import net.ltxprogrammer.changed.world.enchantments.LatexProtectionEnchantment;
import net.minecraft.Util;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import net.ltxprogrammer.changed.process.ProcessTransfur;

import java.util.List;

import static net.ltxprogrammer.changed.process.ProcessTransfur.*;

@Mod.EventBusSubscriber(modid = GoodblockMod.MODID)
public class GoodblockProcessTransfur {
    private static final Logger LOGGER = LogUtils.getLogger();

    /*
    @Deprecated
    public static boolean progressTransfur(LivingEntity entity, float amount, TransfurVariant<?> transfurVariant) {
        return progressTransfur(entity, amount, transfurVariant, TransfurContext.hazard(TransfurCause.GRAB_REPLICATE));
    }*/

    public static boolean progressTransfur(LivingEntity entity, float amount, TransfurVariant<?> transfurVariant, TransfurContext context) {
        if (entity instanceof Player player)
            return progressPlayerTransfur(player, amount, transfurVariant, context);
        else {
            if (entity.isDeadOrDying() || entity.isRemoved())
                return false;

            amount = LatexProtectionEnchantment.getLatexProtection(entity, amount);
            float health = entity.getHealth();
            float scale = 20.0f / Math.max(0.1f, (float)ProcessTransfur.getEntityTransfurTolerance(entity));

            if (entity.getType().is(ChangedTags.EntityTypes.HUMANOIDS)) {
                if (health <= amount * scale && health > 0.0F) {
                    transfur(entity, entity.level, transfurVariant, false, context);
                    return true;
                }

                else {
                    // 直接应用伤害而不调用hurt()，避免触发事件
                    applyDirectDamage(entity, amount * scale);
                    return false;
                }
            }

            else {
                List<TransfurVariant<?>> mobFusion = ChangedFusions.INSTANCE.getFusionsFor(transfurVariant, entity.getClass()).toList();

                if (mobFusion.isEmpty())
                    return false;

                if (health <= amount * scale && health > 0.0F) {
                    transfur(entity, entity.level, Util.getRandom(mobFusion, entity.getRandom()), false, context);
                    return true;
                }

                else {
                    // 直接应用伤害而不调用hurt()，避免触发事件
                    applyDirectDamage(entity, amount * scale);
                    return false;
                }
            }
        }
    }

    protected static boolean progressPlayerTransfur(Player player, float amount, TransfurVariant<?> transfurVariant, TransfurContext context) {
        if (player.isCreative() || player.isSpectator() || ProcessTransfur.isPlayerPermTransfurred(player))
            return false;
        if (player.isDeadOrDying() || player.isRemoved())
            return false;
        boolean justHit = player.invulnerableTime == 20 && player.hurtDuration == 10;

        if (player.invulnerableTime > 10 && !justHit) {
            return false;
        }

        else {
            amount = LatexProtectionEnchantment.getLatexProtection(player, amount);
            if (ChangedCompatibility.isPlayerUsedByOtherMod(player)) {
                setPlayerTransfurProgress(player, 0.0f);
                // 直接应用伤害而不调用hurt()，避免触发事件
                applyDirectDamage(player, amount);
                return false;
            }

            if (amount <= 0.0f)
                return false;

            player.invulnerableTime = 20;
            player.hurtDuration = 10;
            player.hurtTime = player.hurtDuration;
            player.setLastHurtByMob(null);

            float old = getPlayerTransfurProgress(player);
            float next = old + amount;
            float max = (float)ProcessTransfur.getEntityTransfurTolerance(player);
            setPlayerTransfurProgress(player, next);
            if (next >= max && old < max) {
                if (TransfurVariant.getPublicTransfurVariants().anyMatch(transfurVariant::equals))
                    transfur(player, player.level, transfurVariant, false, context);
                else {
                    var variant = PatreonBenefits.getPlayerSpecialVariant(player.getUUID());
                    transfur(player, player.level, variant == null ? ChangedTransfurVariants.FALLBACK_VARIANT.get() : variant, false, context);
                }

                return true;
            }

            return false;
        }
    }

    // 直接应用伤害而不触发事件
    private static void applyDirectDamage(LivingEntity entity, float damage) {
        if (entity.isInvulnerable())
            return;

        boolean justHit = entity.invulnerableTime == 20 && entity.hurtDuration == 10;

        if (justHit || entity.invulnerableTime <= 0) {
            float health = entity.getHealth();
            if (health - damage > 0.0F) {
                //entity.setHealth(health - damage);
            } else {
                // 只有致命伤害才调用hurt()
                //entity.hurt(DamageSource.GENERIC, damage);
            }
        }
    }

}