package net.foxyas.changedaddon.abilities;

import net.foxyas.changedaddon.entity.advanced.AvaliEntity;
import net.foxyas.changedaddon.entity.advanced.LatexSnepEntity;
import net.foxyas.changedaddon.entity.advanced.LuminaraFlowerBeastEntity;
import net.foxyas.changedaddon.entity.defaults.AbstractLuminarcticLeopard;
import net.ltxprogrammer.changed.ability.AbstractAbility;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;

public class CustomInteraction extends AbstractAbility<CustomInteractionInstance> {

    public CustomInteraction() {
        super(CustomInteractionInstance::new);
    }

    @Override
    public TranslatableComponent getAbilityName(IAbstractChangedEntity entity) {
        return new TranslatableComponent("changed_addon.ability.custom_interaction");
    }

    public ResourceLocation getTexture(IAbstractChangedEntity entity) {
        return new ResourceLocation("changed_addon:textures/screens/normal_paw.png");
    }

    @Override
    public int getCoolDown(IAbstractChangedEntity entity) {
        if (entity.getChangedEntity() instanceof AvaliEntity) {
            return 160;
        }

        return super.getCoolDown(entity);
    }

    @Override
    public Collection<Component> getAbilityDescription(IAbstractChangedEntity entity) {
        ArrayList<Component> description = new ArrayList<>(super.getAbilityDescription(entity));
        if (entity.getChangedEntity() instanceof LatexSnepEntity) {
                description.add(new TranslatableComponent("changed_addon.ability.custom_interaction.have_interaction.latex_snep"));
            } else if (entity.getChangedEntity() instanceof AvaliEntity avaliEntity) {
                description.add(new TranslatableComponent("changed_addon.ability.custom_interaction.have_interaction.avali"));
                description.add(new TranslatableComponent("changed_addon.ability.custom_interaction.have_interaction.avali.extra", avaliEntity.getDimensionScale()));
            } else if (entity.getChangedEntity() instanceof LuminaraFlowerBeastEntity luminaraFlowerBeast) {
                TranslatableComponent luminaraBeastDescription = new TranslatableComponent("changed_addon.ability.custom_interaction.have_interaction.luminara_beast");
                String string = luminaraBeastDescription.getString();
                description.add(new TextComponent(string).withStyle((style -> style.withObfuscated(!luminaraFlowerBeast.isHyperAwakened()))));
                if (luminaraFlowerBeast.isHyperAwakened()) {
                    TranslatableComponent luminaraBeastDescriptionExtra = new TranslatableComponent("changed_addon.ability.custom_interaction.have_interaction.luminara_beast.extra", luminaraFlowerBeast.spawnParticles);
                    description.add(luminaraBeastDescriptionExtra);
                }
            } else if (entity.getChangedEntity() instanceof AbstractLuminarcticLeopard) {
                description.add(new TranslatableComponent("changed_addon.ability.custom_interaction.have_interaction.luminarctic_leopards"));
            }
        return description;
    }

    @Nullable
    @Override
    public Component getSelectedDisplayText(IAbstractChangedEntity entity) {
        if (entity.getChangedEntity() instanceof LatexSnepEntity || entity.getChangedEntity() instanceof AbstractLuminarcticLeopard) {
            return new TranslatableComponent("changed_addon.ability.custom_interaction.have_interaction");
        }
        if (entity.getChangedEntity() instanceof AvaliEntity) {
            return new TranslatableComponent("changed_addon.ability.custom_interaction.have_interaction.avali");
        }
        return super.getSelectedDisplayText(entity);
    }
}
