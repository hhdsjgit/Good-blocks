package net.hhdsj.goodblock.event;

import net.hhdsj.goodblock.entity.LatexthreemonthwolfEntityProjectile;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Level;

import java.util.Objects;

@Mod.EventBusSubscriber
public class ArrowReplacementHandler {



    //ResourceLocation variantId = ChangedRegistry.TRANSFUR_VARIANT.get().getKey(variant);

    @SubscribeEvent
    public static void onArrowLoose(ArrowLooseEvent event) {
        Player player = (Player) event.getEntity();
        TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant(player);
        ItemStack bow = event.getBow();
        int charge = event.getCharge();
        Level level = player.level;

        // 只在服务端处理
        if (level.isClientSide) return;

        if (variant == null) return;

        // 检查getFormId()返回是否为null
        ResourceLocation formId = variant.getFormId();
        if (formId == null) return;

        if (!Objects.equals(formId, new ResourceLocation("goodblock", "form_latex_three_month_wolf"))) return;

        // 检查是否使用弓
        if (!(bow.getItem() instanceof BowItem)) return;

        // 获取玩家使用的箭矢
        ItemStack arrowStack = player.getProjectile(bow);
        if (arrowStack.isEmpty() || !(arrowStack.getItem() instanceof ArrowItem)) {
            // 尝试从栏位获取
            if (player.getAbilities().instabuild) {
                arrowStack = new ItemStack(Items.ARROW);
            } else {
                return;
            }
        }

        // 计算箭矢速度
        float velocity = getArrowVelocity(charge);
        if (velocity < 0.1) return;

        // 取消原版箭矢生成
        event.setCanceled(true);

        // 创建自定义箭矢
        LatexthreemonthwolfEntityProjectile customArrow = new LatexthreemonthwolfEntityProjectile(level, player);

        // 设置变体
        customArrow.setFormVariant(new ResourceLocation("goodblock", "form_latex_three_month_wolf"));

        // 设置箭矢属性
        customArrow.shootFromRotation(player, player.getXRot(), player.getYRot(),
                0.0F, velocity * 3.0F, 1.0F);

        // 设置伤害
        customArrow.setBaseDamage(customArrow.getBaseDamage() * 0.6);

        // 播放射箭音效
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS,
                1.0F, 1.0F / (level.random.nextFloat() * 0.4F + 1.2F) + velocity * 0.5F);

        // 消耗耐久(其实没用)
        if (!player.getAbilities().instabuild) {
            bow.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));

            // 消耗箭矢
            if (!arrowStack.isEmpty()) {
                arrowStack.shrink(1);
                if (arrowStack.isEmpty()) {
                    player.getInventory().removeItem(arrowStack);
                }
            }
        }

        // 生成实体
        level.addFreshEntity(customArrow);
    }

    private static float getArrowVelocity(int charge) {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }
        return f;
    }
}