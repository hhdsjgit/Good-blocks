package net.hhdsj.changed_creatures.item;

import net.hhdsj.changed_creatures.init.ChangedCreatureModItems;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.init.ChangedBlocks;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.init.ChangedTransfurVariants;
import net.ltxprogrammer.changed.item.FilledMug;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class LatexFilledAllMugItem extends FilledMug {

    private static final String NBT_FORM_VARIANT = "form_variant";


    public LatexFilledAllMugItem(Properties properties) {
        super(properties);
    }
    @Override
    public int getMaxStackSize(ItemStack stack) {
        return hasVariant(stack) ? 1 : 16;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity user) {
        if (stack.isEdible()) {
            user.eat(level, stack);
        } else {
            stack.shrink(1);
        }

        if (user instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, stack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!level.isClientSide) {
            this.onDrink(stack, level, user);
        }

        ItemStack mugStack = new ItemStack(ChangedBlocks.MUG.get());
       // CompoundTag tag = mugStack.getOrCreateTag();
        //tag.putString(NBT_FORM_VARIANT, "");
        //System.out.print("Debug:Get drink ok");
        //System.out.print(tag.getString(NBT_FORM_VARIANT));
        if (stack.isEmpty()) {
            return mugStack;
        } else {
            if (user instanceof Player player && !player.getAbilities().instabuild) {
                if (!player.getInventory().add(mugStack)) {
                    player.drop(mugStack, false);
                }
            }
            return stack;
        }
    }
    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, @Nullable Level world,
                                @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);

        String variantDescId = getVariantDescIDFromStack(itemstack);
        if (variantDescId != null) {
            list.add(
                    Component.translatable("item.changed_creatures.latex_mug.show4", Component.translatable(variantDescId))
                    //Component.literal("§7内容物: §b" + variantId)
            );
        } else {
            list.add(
                    Component.translatable("item.changed_creatures.latex_mug.show3")
                    //Component.literal("§7内容物: §8空")
            );
        }
    }

    @Override
    protected void onDrink(ItemStack stack, Level level, LivingEntity user) {
        String variantId = getVariantIdFromStack(stack);
        ResourceLocation variantLocation = ResourceLocation.tryParse(variantId);
        if (variantLocation == null) {
            variantLocation = ChangedTransfurVariants.WHITE_WOLF_MALE.getId();
        }

        var variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(variantLocation);
        if (variant != null) {
            ProcessTransfur.progressTransfur(user, 20f, variant,
                    TransfurContext.hazard(TransfurCause.FACE_HAZARD));
        }
    }

    @Override
    public @NotNull ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains(NBT_FORM_VARIANT)) {
            tag.putString(NBT_FORM_VARIANT, "");
        }
        return stack;
    }

    private String getVariantDescIDFromStack(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null && tag.contains(NBT_FORM_VARIANT)) {
            String value = tag.getString(NBT_FORM_VARIANT);
            if (!value.isEmpty()) {
                TransfurVariant<?> variant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(ResourceLocation.tryParse(value));
                if (variant != null) {
                    return variant.getEntityType().getDescriptionId();
                }
                return value; // fallback
            }
        }
        return null;
    }

    private String getVariantIdFromStack(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null && tag.contains(NBT_FORM_VARIANT)) {
            String value = tag.getString(NBT_FORM_VARIANT);
            if (!value.isEmpty()) {
                return value;
            }
        }
        return null;
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack,
                                                           @NotNull Player player,
                                                           @NotNull LivingEntity target,
                                                           @NotNull InteractionHand hand) {
        if (getVariantIdFromStack(stack) != null) {
            return InteractionResult.PASS;
        }

        if (player.level().isClientSide) {
            return InteractionResult.SUCCESS;
        }

        // 服务端逻辑
        String variantId = extractVariantFromEntity(target);

        if (variantId != null) {
            ItemStack filledMug = new ItemStack(ChangedCreatureModItems.LATEX_FILLED_ALL_MUG_ITEM.get());
            CompoundTag tag = filledMug.getOrCreateTag();
            tag.putString(NBT_FORM_VARIANT, variantId);

            // 消耗1个手中的空杯子
            stack.shrink(1);

            // 给玩家满杯子
            if (!player.getInventory().add(filledMug)) {
                player.drop(filledMug, false);
            }

            player.displayClientMessage(
                    Component.translatable("item.changed_creatures.latex_mug.show2",variantId), true
                    //Component.literal("§a舀取胶液: §e" + variantId), true
            );
            //System.out.print("添加入 : true\n");
        } else {
            player.displayClientMessage(
                    Component.translatable("item.changed_creatures.latex_mug.show1"), true
                    //Component.literal("§c你舀取的对象不是胶液"), true
            );
        }
        //System.out.print("Debug Get ok : " + variantId + "\n");
        return InteractionResult.SUCCESS;
    }

    @Nullable
    private String extractVariantFromEntity(LivingEntity entity) {
        TransfurVariant<?> variant = TransfurVariant.getEntityVariant(entity);
        if (variant != null) {
            return variant.getFormId().toString();
        }

        if (entity instanceof Player player) {
            TransfurVariantInstance<?> instance = ProcessTransfur.getPlayerTransfurVariant(player);
            if (instance != null) {
                TransfurVariant<?> parentVariant = instance.getParent();
                return parentVariant.getFormId().toString();
            }
        }

        return null;
    }

    private boolean hasVariant(ItemStack stack) {
        return getVariantIdFromStack(stack) != null;
    }

    // ========== 重写 use：空杯子禁止饮用 ==========
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player,
                                                           @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        //System.out.print("Get latex : "+hasVariant(stack) + "\n");
        if (!hasVariant(stack)) {
            if (!level.isClientSide) {

                player.displayClientMessage(
                        Component.translatable("item.changed_creatures.latex_mug.show0"), true
                        //Component.literal("§c杯子是空的"), true
                );
            }
            return InteractionResultHolder.fail(stack);
        }

        return super.use(level, player, hand);
    }
}