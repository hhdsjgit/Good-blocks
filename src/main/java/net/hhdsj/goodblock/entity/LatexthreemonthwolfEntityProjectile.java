package net.hhdsj.goodblock.entity;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.init.ChangedTabs;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import net.hhdsj.goodblock.registers.GoodblockEntities;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.protocol.Packet;

import net.ltxprogrammer.changed.init.ChangedItems;
import org.jetbrains.annotations.NotNull;

//@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)

public class LatexthreemonthwolfEntityProjectile extends Arrow {
    
    private ResourceLocation formVariant = new ResourceLocation("goodblock", "form_latex_three_month_wolf");

    public LatexthreemonthwolfEntityProjectile(PlayMessages.SpawnEntity packet, Level world) {
        super(GoodblockEntities.LATEXTHREEMONTHWOLF_PROJECTILE.get(), world);
    }

    // 主要构造函数
    public LatexthreemonthwolfEntityProjectile(EntityType<? extends LatexthreemonthwolfEntityProjectile> type, Level world) {
        super(type, world);
        this.setNoGravity(false);
    }

    // 射击者构造函数
    public LatexthreemonthwolfEntityProjectile(Level world, LivingEntity shooter) {
        super(world, shooter);
        this.setNoGravity(false);
    }

    @Override
    public @NotNull Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void doPostHurtEffects(@NotNull LivingEntity livingEntity) {
        super.doPostHurtEffects(livingEntity);
        livingEntity.setArrowCount(livingEntity.getArrowCount() - 1);

        //尝试修复问题 Not Enough Gamerules
        if (livingEntity == null || livingEntity.isRemoved() || !livingEntity.isAlive()) {
            this.discard();
            return;
        }

        try {
            // 从箭矢的形态信息获取对应的TransfurVariant
            final var variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(this.formVariant);
            
            if (variant != null) {
                ProcessTransfur.progressTransfur(livingEntity, 0.5f, variant, TransfurContext.hazard(TransfurCause.GRAB_REPLICATE));
            }
        } catch (Exception e) {
            System.err.println("Error during transfur process: " + e.getMessage());
        }
        this.discard();
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        ItemStack stack = new ItemStack(ChangedItems.LATEX_TIPPED_ARROW.get());
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString("form", formVariant.toString());
        return stack;
    }
    
    public void setFormVariant(ResourceLocation variant) {
        this.formVariant = variant;
    }
    
    public ResourceLocation getFormVariant() {
        return this.formVariant;
    }

}