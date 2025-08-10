
package net.hhdsj.goodblock.entity;

import net.ltxprogrammer.changed.*;
import net.ltxprogrammer.changed.entity.*;
import net.ltxprogrammer.changed.util.Color3;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.common.ForgeMod;


import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.hhdsj.goodblock.init.GoodblockModEntities;


import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;

import net.minecraftforge.common.ForgeMod;

import java.util.Set;

@Mod.EventBusSubscriber
public class LatexKcahraSharkEntity extends ChangedEntity {
	private static final Set<ResourceLocation> SPAWN_BIOMES = Set.of(new ResourceLocation("river"));


	@Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        attributes.getInstance(Attributes.MOVEMENT_SPEED).setBaseValue(0.99);
        attributes.getInstance(ForgeMod.SWIM_SPEED.get()).setBaseValue(1.24);
        attributes.getInstance(Attributes.MAX_HEALTH).setBaseValue(28.0);
    }
    
	@Override
    public LatexType getLatexType() {
        return LatexType.NEUTRAL;
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.REPLICATION;
    }
    
    public Color3 getDripColor() {
        return Color3.getColor("#0793f7");
    }

	@Override
    public HairStyle getDefaultHairStyle() {
        return HairStyle.SHORT_MESSY.get();
    }

    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.getColor("#0793f7");
    }
    
	@SubscribeEvent
	public static void addLivingEntityToBiomes(BiomeLoadingEvent event) {
		if (SPAWN_BIOMES.contains(event.getName()))
			event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(GoodblockModEntities.LATEX_KCAHRA_SHARK.get(), 10, 1, 2));
	}

	public LatexKcahraSharkEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(GoodblockModEntities.LATEX_KCAHRA_SHARK.get(), world);
	}

	public LatexKcahraSharkEntity(EntityType<LatexKcahraSharkEntity> type, Level world) {
		super(type, world);
		xpReward = 5;
		setNoAi(false);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
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
	public boolean hurt(DamageSource source, float amount) {
		if (source == DamageSource.DROWN)
			return false;
		return super.hurt(source, amount);
	}

	public static void init() {
		SpawnPlacements.register(GoodblockModEntities.LATEX_KCAHRA_SHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos).is(Blocks.WATER) && world.getBlockState(pos.above()).is(Blocks.WATER)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 12);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
