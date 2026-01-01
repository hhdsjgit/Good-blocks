package net.ltxprogrammer.changed.ability.tree;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.data.RegistryElementPredicate;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbilityTree {
    public static final Codec<AbilityTree> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.list(RegistryElementPredicate.codec(ChangedRegistry.TRANSFUR_VARIANT.get())).fieldOf("variants")
                    .forGetter(tree -> List.copyOf(tree.variants)),
            Codec.unboundedMap(ResourceLocation.CODEC, Node.CODEC).fieldOf("nodes").forGetter(tree -> tree.nodes)
    ).apply(builder, AbilityTree::new));

    public static final ResourceLocation ROOT_NAME = Changed.modResource("root");

    private final Set<RegistryElementPredicate<TransfurVariant<?>>> variants;
    private final Map<ResourceLocation, Node> nodes;
    //private final Set<TreeView> treeRoots;

    public AbilityTree(List<RegistryElementPredicate<TransfurVariant<?>>> variants, Map<ResourceLocation, Node> nodes) {
        this.variants = Set.copyOf(variants);
        this.nodes = nodes;

        // TODO cache roots after resources have been processed
        /*this.treeRoots = nodes.entrySet().stream().filter(entry -> entry.getValue().parentNode.equals(ROOT_NAME))
                .map(entry -> new TreeView(entry.getKey(), entry.getValue(), nodes))
                .collect(Collectors.toSet());*/
    }

    public boolean appliesTo(TransfurVariant<?> variant) {
        return variants.stream().anyMatch(predicate -> predicate.test(variant));
    }

    public @Nullable Node getNode(ResourceLocation name) {
        return nodes.get(name);
    }

    public @NotNull Optional<Node> getNodeSafe(ResourceLocation name) {
        return Optional.ofNullable(nodes.get(name));
    }

    public Stream<Pair<ResourceLocation, Node>> getNodes() {
        return nodes.entrySet().stream().map(entry -> Pair.of(entry.getKey(), entry.getValue()));
    }

    public static class Node {
        public static final Codec<Node> CODEC = RecordCodecBuilder.create(builder -> builder.group(
                ResourceLocation.CODEC.fieldOf("parent").forGetter(node -> node.parentNode),
                Codec.STRING.fieldOf("titleId").forGetter(node -> node.titleId),
                Codec.STRING.fieldOf("descriptionId").forGetter(node -> node.descriptionId),
                Codec.INT.fieldOf("price").forGetter(node -> node.price),
                Codec.INT.fieldOf("groupDiscount").orElse(0).forGetter(node -> node.groupDiscount),
                Codec.list(NodeEffect.CODEC).fieldOf("effects").forGetter(node -> node.effects)
        ).apply(builder, Node::new));

        public final ResourceLocation parentNode;
        public final String titleId;
        public final String descriptionId;
        public final int price;
        public final int groupDiscount;
        public final List<NodeEffect> effects;

        public Node(ResourceLocation parentNode, String titleId, String descriptionId, int price, int groupDiscount,
                    List<NodeEffect> effects) {
            this.parentNode = parentNode;
            this.titleId = titleId;
            this.descriptionId = descriptionId;
            this.price = price;
            this.groupDiscount = groupDiscount;
            this.effects = effects;
        }

        public Component getTitle() {
            return Component.translatable(titleId);
        }

        public Component getDescription() {
            return Component.translatable(descriptionId);
        }
    }

    public static class NodeEffect {
        // TODO move codec to a registry
        public static final Codec<NodeEffect> CODEC = Codec.unit(NodeEffect::new);

        public void applyEffect(AbilityCounter counter, boolean unlocked) {

        }
    }

    public static class TreeView {
        private final Node node;
        private final Set<TreeView> children;

        public TreeView(ResourceLocation thisName, Node node, Map<ResourceLocation, Node> pool) {
            this.node = node;
            this.children = pool.entrySet().stream().filter(entry -> entry.getValue().parentNode.equals(thisName))
                    .map(entry -> new TreeView(entry.getKey(), entry.getValue(), pool))
                    .collect(Collectors.toSet());
        }
    }
}
