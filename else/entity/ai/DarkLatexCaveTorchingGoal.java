package net.ltxprogrammer.changed.entity.ai;

import net.ltxprogrammer.changed.entity.beast.AbstractDarkLatexEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class DarkLatexCaveTorchingGoal extends MoveToBlockGoal {
    private static final int TIME_LIMIT_TO_PATHFIND = 5 * 20;

    public final AbstractDarkLatexEntity entity;
    public final Level level;

    public DarkLatexCaveTorchingGoal(AbstractDarkLatexEntity entity, double speedModifier, int searchRange, int verticalSearchRange) {
        super(entity, speedModifier, searchRange, verticalSearchRange);
        this.entity = entity;
        this.level = entity.level();
    }

    @Override
    protected int nextStartTick(PathfinderMob mob) {
        return 30;
    }

    public double acceptedDistance() {
        return 2.0D;
    }

    @Override
    public boolean canUse() {
        if (entity.getTarget() != null)
            return false;
        var inventory = entity.getInventory();
        if (inventory == null)
            return false;
        if (entity.getCurrentFavor() != DarkLatexFavor.CAVING)
            return false;
        if (!entity.getOffhandItem().is(Items.TORCH))
            return false;

        return super.canUse();
    }

    @Override
    public boolean canContinueToUse() {
        if (entity.getTarget() != null)
            return false;
        if (entity.getCurrentFavor() != DarkLatexFavor.CAVING)
            return false;
        if (!entity.getOffhandItem().is(Items.TORCH))
            return false;

        return this.tryTicks <= TIME_LIMIT_TO_PATHFIND && super.canContinueToUse();
    }

    @Override
    protected boolean isValidTarget(LevelReader level, BlockPos blockPos) {
        if (!level.isEmptyBlock(blockPos.above()))
            return false;
        if (!level.getBlockState(blockPos).is(Tags.Blocks.STONE) && !level.getBlockState(blockPos).is(BlockTags.DIRT))
            return false;

        return level.getRawBrightness(blockPos.above(), level.getSkyDarken() + 2) < 3;
    }

    protected boolean placed = false;

    @Override
    public void start() {
        super.start();
        placed = false;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isReachedTarget() && !placed) {
            var torchPos = blockPos.above();
            this.entity.swing(InteractionHand.OFF_HAND);
            this.level.setBlockAndUpdate(torchPos, Blocks.TORCH.defaultBlockState);
            this.entity.getOffhandItem().shrink(1);

            SoundType soundtype = Blocks.TORCH.defaultBlockState.getSoundType(level, torchPos, entity);
            level.playSound(entity, torchPos, soundtype.getPlaceSound(), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
            level.gameEvent(GameEvent.BLOCK_PLACE, torchPos, GameEvent.Context.of(entity, Blocks.TORCH.defaultBlockState));

            placed = true;
            this.nextStartTick = 10; // Shorter cooldown after placing a torch
        }
    }
}
