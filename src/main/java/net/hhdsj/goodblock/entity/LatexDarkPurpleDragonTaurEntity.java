package net.hhdsj.goodblock.entity;

import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.hhdsj.goodblock.init.GoodblockModTransfurVariants;
import net.ltxprogrammer.changed.entity.*;
import net.ltxprogrammer.changed.entity.beast.LatexTaur;
import net.ltxprogrammer.changed.entity.beast.WhiteLatexKnight;
import net.ltxprogrammer.changed.entity.latex.LatexType;
import net.ltxprogrammer.changed.entity.variant.EntityShape;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedAttributes;
import net.ltxprogrammer.changed.init.ChangedTransfurVariants;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class LatexDarkPurpleDragonTaurEntity extends ChangedEntity implements LatexTaur<LatexDarkPurpleDragonTaurEntity> {
    private Object level;

    public LatexDarkPurpleDragonTaurEntity(EntityType<? extends LatexDarkPurpleDragonTaurEntity> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
		/*
        Objects.requireNonNull(attributes.getInstance(Attributes.MOVEMENT_SPEED)).setBaseValue(1.2);
        Objects.requireNonNull(attributes.getInstance(ForgeMod.SWIM_SPEED.get())).setBaseValue(0.9);
        Objects.requireNonNull(attributes.getInstance(Attributes.MAX_HEALTH)).setBaseValue(30);
        Objects.requireNonNull(attributes.getInstance(ForgeMod.STEP_HEIGHT_ADDITION.get())).setBaseValue(computeStepHeightOffset(1.1));
        Objects.requireNonNull(attributes.getInstance(ChangedAttributes.JUMP_STRENGTH.get())).setBaseValue(1.25);
        Objects.requireNonNull(attributes.getInstance(ChangedAttributes.FALL_RESISTANCE.get())).setBaseValue(2.5);*/
		var movementSpeed = attributes.getInstance(Attributes.MOVEMENT_SPEED);
		if (movementSpeed != null) {
			movementSpeed.setBaseValue(1.2);
		}
		
		// 安全地设置游泳速度
		var swimSpeed = attributes.getInstance(ForgeMod.SWIM_SPEED.get());
		if (swimSpeed != null) {
			swimSpeed.setBaseValue(0.9);
		}
		
		// 安全地设置最大生命值
		var maxHealth = attributes.getInstance(Attributes.MAX_HEALTH);
		if (maxHealth != null) {
			maxHealth.setBaseValue(30);
		}
		
		// 安全地设置步高
		var stepHeight = attributes.getInstance(ForgeMod.STEP_HEIGHT_ADDITION.get());
		if (stepHeight != null) {
			stepHeight.setBaseValue(computeStepHeightOffset(1.1));
		}
		
		// 安全地设置跳跃强度
		var jumpStrength = attributes.getInstance(ChangedAttributes.JUMP_STRENGTH.get());
		if (jumpStrength != null) {
			jumpStrength.setBaseValue(1.25);
		}
		
		// 安全地设置摔落抗性
		var fallResistance = attributes.getInstance(ChangedAttributes.FALL_RESISTANCE.get());
		if (fallResistance != null) {
			fallResistance.setBaseValue(2.5);
		}
    }

    public TransfurVariant<?> getTransfurVariant() {
        return (TransfurVariant) GoodblockModTransfurVariants.LATEXDARKPURPLEDRAGONTAUR.get();
    }

    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.getColor("#ca00ff");
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.REPLICATION;
    }

    @Override
    public boolean isSaddleable() {
        return false;
    }

    @Override
    public void equipSaddle(@Nullable SoundSource p_21748_) {
        this.equipSaddle(this, p_21748_);
    }

    @Override
    public boolean isSaddled() {
        return this.isSaddled(this);
    }

    protected void doPlayerRide(Player player) {
        this.doPlayerRide(this, player);
    }

    public double getPassengersRidingOffset() {
        return super.getPassengersRidingOffset() + getTorsoYOffset(this) - (2.0 / 16.0);
    }

    public InteractionResult mobInteract(Player p_30713_, InteractionHand p_30714_) {
        if (isSaddled()) {
            this.doPlayerRide(p_30713_);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }

        return InteractionResult.PASS;
    }

    public static void init() {
        SpawnPlacements.register(GoodblockModEntities.LATEXDARKPURPLEDRAGONTAUR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
    }

    @Override
    public @NotNull EntityShape getEntityShape() {
        return EntityShape.TAUR;
    }
    /*
    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        // 添加 Changed 模组特有的属性
        builder = builder.add(ChangedAttributes.TRANSFUR_DAMAGE.get(), 3);
        builder = builder.add(ChangedAttributes.JUMP_STRENGTH.get(), 1.25);
        builder = builder.add(ChangedAttributes.FALL_RESISTANCE.get(), 2.5);

        // 添加原版属性
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 30);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);

        // 添加 Forge 模组属性
        builder = builder.add(ForgeMod.SWIM_SPEED.get(), 0.9);
        builder = builder.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 0.6);
        return builder;
    }*/
    public static AttributeSupplier.Builder createAttributes() {
        return ChangedEntity.createLatexAttributes();  // 返回父类的默认属性
    }
}
