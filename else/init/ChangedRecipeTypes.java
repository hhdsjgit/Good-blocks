package net.ltxprogrammer.changed.init;

import net.ltxprogrammer.changed.Changed;
import net.ltxprogrammer.changed.recipe.InfuserRecipe;
import net.ltxprogrammer.changed.recipe.PurifierRecipe;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangedRecipeTypes {
    public static DeferredRegister<RecipeType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Changed.MODID);
    private static <T extends Recipe<?>> RegistryObject<RecipeType<T>> register(String name) {
        return REGISTRY.register(name, () -> new RecipeType<T>() {
            public String toString() {
                return Changed.modResourceStr(name);
            }
        });
    }

    private static <T extends Recipe<?>> RecipeBookType registerBookType(String name) {
        return RecipeBookType.create(name);
    }

    public static RegistryObject<RecipeType<InfuserRecipe>> INFUSER_RECIPE = register("infuser");
    public static RegistryObject<RecipeType<PurifierRecipe>> PURIFIER_RECIPE = register("purifier");

    public static final RecipeBookType INFUSER_BOOK = registerBookType( "CHANGED_INFUSER");
}
