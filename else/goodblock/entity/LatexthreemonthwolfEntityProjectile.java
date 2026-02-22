package net.hhdsj.goodblock.entity;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.init.ChangedTabs;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.ltxprogrammer.changed.util.TagUtil;
import net.ltxprogrammer.changed.util.UniversalDist;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

import net.hhdsj.goodblock.registers.GoodblockEntities;

import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;

// 导入你的Mod相关类
import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.ltxprogrammer.changed.init.ChangedItems;
import net.ltxprogrammer.changed.item.LatexTippedArrowItem; // 根据实际路径修改
//1.20.1 ADD
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
//
//@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class LatexthreemonthwolfEntityProjectile extends Arrow {
    
    private ResourceLocation formVariant = new ResourceLocation("goodblock", "from_latex_purplews_wolf");
    
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
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

    @Override
    protected void doPostHurtEffects(LivingEntity livingEntity) {
        super.doPostHurtEffects(livingEntity);
        livingEntity.setArrowCount(livingEntity.getArrowCount() - 1);
        

        //ProcessTransfur.progressTransfur(livingEntity, 8.0f, variant, TransfurContext.hazard(TransfurCause.GRAB_REPLICATE));
        try {
            // 从箭矢的形态信息获取对应的TransfurVariant
            final var variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(this.formVariant);
            
            if (variant != null) {
                ProcessTransfur.progressTransfur(livingEntity, 8.0f, variant, TransfurContext.hazard(TransfurCause.GRAB_REPLICATE));
            } else {
                System.err.println("Could not find TransfurVariant for: " + this.formVariant);
            }
        } catch (Exception e) {
            System.err.println("Error during transfur process: " + e.getMessage());
        }
        // 转化后移除箭矢
        this.discard();
    }

    @Override
    protected ItemStack getPickupItem() {
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
    /*
    // NBT持久化
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("FormVariant", formVariant.toString());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("FormVariant")) {
            this.formVariant = new ResourceLocation(compound.getString("FormVariant"));
        }
    }*/
}