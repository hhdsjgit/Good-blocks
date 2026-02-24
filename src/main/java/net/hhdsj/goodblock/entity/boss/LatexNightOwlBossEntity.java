package net.hhdsj.goodblock.entity.boss;

import net.hhdsj.goodblock.entity.LatexYunQiIceDragonEntity;
import net.hhdsj.goodblock.init.GoodblockModEntities;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.LatexType;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.init.ChangedAttributes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import net.minecraft.network.chat.Component;

public class LatexNightOwlBossEntity extends ChangedEntity {

    public LatexNightOwlBossEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(GoodblockModEntities.LATEXNIGHTOWLDRAGONBOSS.get(), world);
    }

    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        attributes.getInstance(Attributes.MOVEMENT_SPEED).setBaseValue(1.2);
        attributes.getInstance(ForgeMod.SWIM_SPEED.get()).setBaseValue(1.1);
        attributes.getInstance(Attributes.MAX_HEALTH).setBaseValue(100.0);
    }

    @Override
    public @NotNull Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public LatexType getLatexType() {
        return LatexType.NEUTRAL;
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.REPLICATION;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (source == DamageSource.FALL)
            return false;
        if (source == DamageSource.ON_FIRE)
            return false;
        return super.hurt(source, amount);
    }

    public LatexNightOwlBossEntity(EntityType<LatexNightOwlBossEntity> type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(false);
        this.bossEvent = new ServerBossEvent(
                new TranslatableComponent("entity.goodblock.boss_heath.night_owl"), // 或者用
                BossEvent.BossBarColor.RED,
                BossEvent.BossBarOverlay.NOTCHED_10 // 进度条样式
        );
        // 默认设置为可见
        this.bossEvent.setVisible(true);
    }

    @Override
    public void tick() {
        super.tick();
        // 更新血条进度
        if (!this.level.isClientSide) {
            float healthPercent = this.getHealth() / this.getMaxHealth();
            this.bossEvent.setProgress(healthPercent);
        }
    }

    @Override
    public void startSeenByPlayer(@NotNull ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(@NotNull ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (this.getHealth() < this.getMaxHealth() * 0.3) {
            this.bossEvent.setName(
                    new TranslatableComponent("entity.goodblock.boss_heath.night_owl")
                            .withStyle(ChatFormatting.RED)
            );
        }
    }

    @Override
    public void remove(RemovalReason reason) {
        this.bossEvent.setVisible(false);
        super.remove(reason);
    }

    public static void init() {
    }

    private final ServerBossEvent bossEvent;

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(ChangedAttributes.TRANSFUR_DAMAGE.get(), 0);
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 16);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        return builder;
    }
}
