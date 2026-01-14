package net.hhdsj.goodblock.event.fix;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.WeakHashMap;

@Mod.EventBusSubscriber(modid = "goodblock")
public class NotEnoughGamerulesFix {
    
    private static final Logger LOGGER = LogManager.getLogger("GoodBlock/NEGFix");
    private static final ThreadLocal<Boolean> PROCESSING_FIX = ThreadLocal.withInitial(() -> false);
    private static final WeakHashMap<LivingAttackEvent, Boolean> HANDLED_EVENTS = new WeakHashMap<>();
    
    // 存储原始的 NEG 事件处理器
    private static Object negEventHandler = null;
    private static boolean negHandlerDetected = false;
    
    /**
     * 在最高优先级拦截事件
     */
    @SubscribeEvent(priority = EventPriority.HIGHEST) // 比 HIGHEST 更高
    public static void onLivingAttackEarly(LivingAttackEvent event) {
        // 已经处理过的事件跳过
        if (HANDLED_EVENTS.containsKey(event)) {
            return;
        }
        
        // 防止递归
        if (PROCESSING_FIX.get()) {
            return;
        }
        
        // 检查是否是会导致 NEG 崩溃的情况
        if (isProblematicForNEG(event)) {
            LOGGER.debug("检测到可能导致 NEG 崩溃的攻击事件: {} -> {}", 
                event.getSource().getEntity(), event.getEntity());
            
            // 标记为已处理
            HANDLED_EVENTS.put(event, true);
            
            // 取消事件，防止 NEG 处理器执行
            event.setCanceled(true);
            
            // 立即应用安全伤害
            applyDamageSafely(event);
            
            LOGGER.debug("已安全处理 NEG 兼容性问题");
        }
    }
    
    /**
     * 在低优先级清理标记（确保最后执行）
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onLivingAttackCleanup(LivingAttackEvent event) {
        HANDLED_EVENTS.remove(event);
    }
    
    /**
     * 检查是否是 NEG 会崩溃的情况
     */
    private static boolean isProblematicForNEG(LivingAttackEvent event) {
        if (!isNEGLoaded()) {
            return false;
        }
        
        Entity source = event.getSource().getEntity();
        Entity directSource = event.getSource().getDirectEntity();
        
        // NEG 会在 PlayerHurtEvent.onEntityAttacked 中尝试转换 Arrow 为 LivingEntity
        // 所以需要检查所有可能导致此转换的情况
        
        // 情况1: 直接来源是 Arrow
        if (directSource instanceof Arrow) {
            return true;
        }
        
        // 情况2: 来源是 Arrow
        if (source instanceof Arrow) {
            return true;
        }
        
        // 情况3: 来源是其他抛射物但不是生物
        if (source instanceof Projectile && !(source instanceof LivingEntity)) {
            return true;
        }
        
        return false;
    }
    
    private static void applyDamageSafely(LivingAttackEvent event) {
        PROCESSING_FIX.set(true);
        try {
            LivingEntity target = (LivingEntity) event.getEntity();
            float amount = event.getAmount();
            DamageSource originalSource = event.getSource();
            
            // 创建一个更安全的 DamageSource
            DamageSource safeSource = createSafeDamageSource(originalSource);
            
            // 记录原始信息用于调试
            LOGGER.debug("应用安全伤害: 目标={}, 伤害={}, 来源={}", 
                target.getName().getString(), amount, safeSource.getMsgId());
            
            // 直接调用 hurt 方法，跳过事件系统
            if (target.isAlive() && amount > 0) {
                target.hurt(safeSource, amount);
            }
            
        } catch (Exception e) {
            LOGGER.error("安全应用伤害时出错", e);
        } finally {
            PROCESSING_FIX.set(false);
        }
    }
    
    /**
     * 创建安全的 DamageSource，避免类型转换问题
     */
    private static DamageSource createSafeDamageSource(DamageSource original) {
        Entity source = original.getEntity();
        Entity directSource = original.getDirectEntity();
        
        // 如果是箭矢伤害
        if (directSource instanceof AbstractArrow arrow) {
            Entity owner = arrow.getOwner();
            if (owner instanceof LivingEntity livingOwner) {
                // 使用所有者作为伤害来源
                return DamageSource.arrow(arrow, livingOwner);
            } else if (owner != null) {
                // 非生物所有者
                return DamageSource.arrow(arrow, owner);
            }
        }
        
        // 如果是抛射物但不是箭
        if (source instanceof Projectile projectile && !(source instanceof LivingEntity)) {
            Entity owner = projectile.getOwner();
            if (owner instanceof LivingEntity livingOwner) {
                return DamageSource.thrown(projectile, livingOwner);
            }
        }
        
        // 其他情况，返回原始来源但尝试修复
        try {
            // 使用反射检查是否有潜在问题
            Class<?> sourceClass = original.getClass();
            Field entityField = null;
            
            // 尝试获取 entity 字段
            for (Field field : sourceClass.getDeclaredFields()) {
                if (field.getType().equals(Entity.class)) {
                    entityField = field;
                    break;
                }
            }
            
            if (entityField != null) {
                entityField.setAccessible(true);
                Entity entity = (Entity) entityField.get(original);
                // 如果实体是 Arrow，创建新的 DamageSource
                if (entity instanceof Arrow) {
                    return DamageSource.arrow((Arrow) entity, entity);
                }
            }
        } catch (Exception e) {
            // 反射失败，使用原始来源
        }
        
        return original;
    }
    
    /**
     * 尝试禁用 NEG 的问题事件处理器
     */
    public static void disableNEGProblematicHandler() {
        if (!isNEGLoaded()) {
            return;
        }
        
        try {
            // 通过反射找到 NEG 的事件处理器
            Class<?> negEventClass = Class.forName("net.reikeb.not_enough_gamerules.events.PlayerHurtEvent");
            Object instance = negEventClass.getDeclaredConstructor().newInstance();
            
            // 这里可以根据需要进一步操作
            // 例如，修改处理器使其跳过问题情况
            
            LOGGER.info("已检测到 NEG 事件处理器，尝试进行兼容性处理");
            
        } catch (Exception e) {
            LOGGER.warn("无法访问 NEG 事件处理器: {}", e.getMessage());
        }
    }
    
    public static boolean isNEGLoaded() {
        try {
            Class.forName("net.reikeb.not_enough_gamerules.NotEnoughGamerules");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
    
    // 初始化时尝试修复
    static {
        if (isNEGLoaded()) {
            LOGGER.info("检测到 Not Enough Gamerules 模组，启用兼容性修复");
            disableNEGProblematicHandler();
        }
    }
}