package net.hhdsj.goodblock.abilities;

import net.foxyas.changedaddon.init.ChangedAddonAbilities;
import net.hhdsj.goodblock.init.GoodblockModAbilities;
import net.hhdsj.goodblock.init.GoodblockModTransfurVariants;
import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.AbstractAbilityInstance;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurContext;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.ltxprogrammer.changed.init.ChangedSounds;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class TurnFeralLatexDarkpurpleAbilityInstance extends AbstractAbilityInstance {

    private static final String OLD_TRANSFUR_VARIANT = "OldVariant";
    public TransfurVariant<?> OldVariant = null;

    public TurnFeralLatexDarkpurpleAbilityInstance(AbstractAbility<?> ability, IAbstractChangedEntity entity) {
        super(ability, entity);
    }

    public static String getOldTransfurVariant() {
        return OLD_TRANSFUR_VARIANT;
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public boolean canKeepUsing() {
        return true;
    }

    @Override
    public void onSelected() {
        super.onSelected();
        if (entity.getEntity() instanceof Player player) {
            var Instance = ProcessTransfur.getPlayerTransfurVariant(player);
            if (this.OldVariant == null
                    && Instance != null) {
                if (Instance.getParent() != GoodblockModTransfurVariants.LATEXDARKPURPLEDRAGONTAUR.get()
                        && Instance.getParent() != GoodblockModTransfurVariants.LATEXDARKPURPLEDRAGON.get()) {
                    setOldVariant(entity.getSelfVariant());
                }
            } else if (Instance != null) {
                Component text = ability.getSelectedDisplayText(this.entity);
                if (Instance.getParent() == GoodblockModTransfurVariants.LATEXDARKPURPLEDRAGONTAUR.get() && text != null) {
                    player.displayClientMessage(text, true);
                }
            }
        }
    }

    @Override
    public void saveData(CompoundTag tag) {
        super.saveData(tag);
        if (this.OldVariant != null) {
            ResourceLocation registryName = ChangedRegistry.TRANSFUR_VARIANT.get().getKey(this.OldVariant);
            if (registryName != null) {
                tag.putString(OLD_TRANSFUR_VARIANT, registryName.toString());
            }
        }
    }

    @Override
    public void readData(CompoundTag tag) {
        super.readData(tag);

        if (tag.contains(OLD_TRANSFUR_VARIANT)) {
            ResourceLocation form;
            try {
                form = new ResourceLocation(tag.getString(OLD_TRANSFUR_VARIANT));
            } catch (Exception e) {
                form = null;
            }

            if (form != null) {
                this.OldVariant = ChangedRegistry.TRANSFUR_VARIANT.get().getValue(form);
            }
        }
    }

    public void setOldVariant(TransfurVariant<?> oldVariant) {
        OldVariant = oldVariant;
    }

    @Override
    public void startUsing() {
        if (entity.getEntity() instanceof Player player) {
            TransfurVariant<?> targetVariant = determineNextVariant(entity.getTransfurVariant());
            TransfurVariantInstance<?> variantInstance = ProcessTransfur.setPlayerTransfurVariant(
                    player,
                    targetVariant,
                    TransfurContext.hazard(TransfurCause.GRAB_REPLICATE),
                    1
            );
            if (variantInstance != null) {
                variantInstance.ifHasAbility(GoodblockModAbilities.TURN_FERA_LATEX_DARK_PURPLE.get(), abilityInstance ->
                        abilityInstance.setOldVariant(entity.getTransfurVariant())
                );
                entity.getEntity().level().playSound(null, entity.getEntity(), ChangedSounds.TRANSFUR_BY_LATEX.get(), SoundSource.PLAYERS, 1, 1);
            }
        }
    }

    private TransfurVariant<?> determineNextVariant(TransfurVariant<?> currentVariant) {
        if (currentVariant == GoodblockModTransfurVariants.LATEXDARKPURPLEDRAGON.get()) {
            return GoodblockModTransfurVariants.LATEXDARKPURPLEDRAGONTAUR.get();
        } else {
            return GoodblockModTransfurVariants.LATEXDARKPURPLEDRAGON.get();
        }
    }

    @Override
    public void tick() {
    }

    @Override
    public void stopUsing() {
    }
}