package net.dakotapride.creategarnished.recipe;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreateGarnishedRecipeSerializers {
    public static DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, CreateGarnished.ID);

    public static DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> WRAPPED_CANDY_FROM_WRAPPER_DYED_CRAFTING = register("wrapped_candy_from_wrapper_dyed_crafting", new SimpleCraftingRecipeSerializer<>(WrappedCandyFromWrapperDyedCraftingRecipe::new));

    private static DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> register(String key, RecipeSerializer<?> recipeSerializer) {
        return RECIPE_SERIALIZERS.register(key, () -> recipeSerializer);
    }

    public static void register(IEventBus bus) {
        RECIPE_SERIALIZERS.register(bus);
    }
}
