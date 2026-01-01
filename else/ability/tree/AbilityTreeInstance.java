package net.ltxprogrammer.changed.ability.tree;

import com.mojang.datafixers.util.Pair;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Instantiated per player, exists outside TransfurVariantInstance to persist between variants
 */
public class AbilityTreeInstance {
    public static final int POINTS_PER_LEVEL = 10;

    public record AccountedPurchase(ResourceLocation nodeName, TransfurVariant<?> variant, int price) {
        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (obj instanceof AccountedPurchase other)
                return other.nodeName.equals(nodeName) && other.variant.equals(variant) && other.price == price;
            return false;
        }
    }

    public record NodeState(ResourceLocation nodeName, AbilityTree.Node node, boolean unlocked) {}

    public static class AccountedTree {
        private final AbilityTree tree;
        private final Set<AccountedPurchase> purchasedNodes = new HashSet<>();

        private final Map<TransfurVariant<?>, Integer> pointStores = new HashMap<>();

        public AccountedTree(AbilityTree tree) {
            this.tree = tree;
        }

        public Stream<AccountedPurchase> getPurchasesFor(ResourceLocation nodeName) {
            return purchasedNodes.stream().filter(purchase -> purchase.nodeName.equals(nodeName));
        }

        public boolean hasPrerequisites(ResourceLocation nodeName, TransfurVariant<?> forVariant) {
            final var node = tree.getNode(nodeName);
            if (node == null)
                return false;
            // TODO maybe let node specify criteria as well
            if (node.parentNode.equals(AbilityTree.ROOT_NAME))
                return true;

            return getNodeStates(forVariant, pair -> {
                return pair.getFirst().equals(node.parentNode);
            }).allMatch(NodeState::unlocked);
        }

        public Stream<NodeState> getNodeStates(TransfurVariant<?> forVariant) {
            return getNodeStates(forVariant, pair -> true);
        }

        public Stream<NodeState> getNodeStates(TransfurVariant<?> forVariant, Predicate<Pair<ResourceLocation, AbilityTree.Node>> nodePredicate) {
            return tree.getNodes().filter(nodePredicate)
                    .map(node -> {
                        boolean unlocked = getPurchasesFor(node.getFirst()).anyMatch(purchase -> {
                            if (purchase.variant == forVariant)
                                return true; // This variant paid for the node
                            if (node.getSecond().price + node.getSecond().groupDiscount <= 0)
                                return true; // Another variant paid for the node, and the discount makes it free
                            return false;
                        });
                        return new NodeState(node.getFirst(), node.getSecond(), unlocked);
                    });
        }

        public int getEffectivePrice(ResourceLocation nodeName, TransfurVariant<?> forVariant) {
            return tree.getNodeSafe(nodeName).map(node -> {
                boolean applyDiscount = getPurchasesFor(nodeName).anyMatch(purchase -> purchase.variant != forVariant && purchase.price >= node.price);
                return applyDiscount ? node.price + node.groupDiscount : node.price;
            }).orElseThrow(() -> new IllegalArgumentException("Unknown node by name " + nodeName));
        }

        public void refundInvalidNodes() {
            Set<AccountedPurchase> invalid = new HashSet<>();
            purchasedNodes.forEach(purchase -> {
                if (tree.getNode(purchase.nodeName) == null)
                    invalid.add(purchase);
            });
            invalid.forEach(purchase -> {
                purchasedNodes.remove(purchase);
                pointStores.compute(purchase.variant, (variant, points) -> {
                    if (points == null)
                        return purchase.price;
                    else
                        return points + purchase.price;
                });
            });
        }

        public void applyEffects(AbilityCounter counter) {
            getNodeStates(counter.variantInstance.getParent()).forEach(nodeState -> {
                nodeState.node.effects.forEach(nodeEffect -> {
                    nodeEffect.applyEffect(counter, nodeState.unlocked);
                });
            });
        }

        public boolean appliesTo(TransfurVariant<?> variant) {
            return tree.appliesTo(variant);
        }
    }

    private final Set<AccountedTree> trees = new HashSet<>();

    public Set<AccountedTree> getTrees(TransfurVariant<?> forVariant) {
        return trees.stream().filter(tree -> tree.appliesTo(forVariant)).collect(Collectors.toSet());
    }

    public void applyEffects(AbilityCounter counter) {
        trees.forEach(tree -> {
            if (tree.appliesTo(counter.variantInstance.getParent()))
                tree.applyEffects(counter);
        });
    }
}
