package net.dakotapride.garnished.registry.JEI;

import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.*;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import com.simibubi.create.foundation.utility.Lang;
import com.simibubi.create.infrastructure.config.AllConfigs;
import com.simibubi.create.infrastructure.config.CRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.recipe.*;
import net.dakotapride.garnished.registry.GarnishedFluids;
import net.dakotapride.garnished.registry.GarnishedRecipeTypes;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static com.simibubi.create.compat.jei.CreateJEI.consumeTypedRecipes;

@JeiPlugin
@SuppressWarnings({"unused", "inline", "all"})
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GarnishedJEI implements IModPlugin {
    private static final ResourceLocation MOD_ID = new ResourceLocation(CreateGarnished.ID, "jei_plugin");

    @Override
    @Nonnull
    public ResourceLocation getPluginUid() {
        return MOD_ID;
    }


    public IIngredientManager ingredientManager;
    private static final List<CreateRecipeCategory<?>> Categories = new ArrayList<>();

    private void loadCategories() {
        Categories.clear();
        CreateRecipeCategory<?> freezing = builder(FreezingFanRecipe.class)
                .addTypedRecipes(GarnishedRecipeTypes.FREEZING::getType)
                .catalystStack(ProcessingViaFanCategory.getFan("garnished.fan_freezing"))
                .doubleItemIcon(AllItems.PROPELLER.get(), Items.POWDER_SNOW_BUCKET)
                .emptyBackground(178, 72)
                .build("garnished.fan_freezing", FreezingFanCategory::new);
        CreateRecipeCategory<?> redDyeBlowing = builder(RedDyeBlowingFanRecipe.class)
                .addTypedRecipes(GarnishedRecipeTypes.RED_DYE_BLOWING::getType)
                .catalystStack(ProcessingViaFanCategory.getFan("garnished.red_dye_blowing"))
                .doubleItemIcon(AllItems.PROPELLER.get(), GarnishedFluids.RED_MASTIC_RESIN.getBucket().get())
                .emptyBackground(178, 72)
                .build("garnished.red_dye_blowing", RedDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> orangeDyeBlowing = builder(OrangeDyeBlowingFanRecipe.class)
                .addTypedRecipes(GarnishedRecipeTypes.ORANGE_DYE_BLOWING::getType)
                .catalystStack(ProcessingViaFanCategory.getFan("garnished.orange_dye_blowing"))
                .doubleItemIcon(AllItems.PROPELLER.get(), GarnishedFluids.ORANGE_MASTIC_RESIN.getBucket().get())
                .emptyBackground(178, 72)
                .build("garnished.orange_dye_blowing", OrangeDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> yellowDyeBlowing = builder(YellowDyeBlowingFanRecipe.class)
                .addTypedRecipes(GarnishedRecipeTypes.YELLOW_DYE_BLOWING::getType)
                .catalystStack(ProcessingViaFanCategory.getFan("garnished.yellow_dye_blowing"))
                .doubleItemIcon(AllItems.PROPELLER.get(), GarnishedFluids.YELLOW_MASTIC_RESIN.getBucket().get())
                .emptyBackground(178, 72)
                .build("garnished.yellow_dye_blowing", YellowDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> greenDyeBlowing = builder(GreenDyeBlowingFanRecipe.class)
                .addTypedRecipes(GarnishedRecipeTypes.GREEN_DYE_BLOWING::getType)
                .catalystStack(ProcessingViaFanCategory.getFan("garnished.green_dye_blowing"))
                .doubleItemIcon(AllItems.PROPELLER.get(), GarnishedFluids.GREEN_MASTIC_RESIN.getBucket().get())
                .emptyBackground(178, 72)
                .build("garnished.green_dye_blowing", GreenDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> blueDyeBlowing = builder(BlueDyeBlowingFanRecipe.class)
                .addTypedRecipes(GarnishedRecipeTypes.BLUE_DYE_BLOWING::getType)
                .catalystStack(ProcessingViaFanCategory.getFan("garnished.blue_dye_blowing"))
                .doubleItemIcon(AllItems.PROPELLER.get(), GarnishedFluids.BLUE_MASTIC_RESIN.getBucket().get())
                .emptyBackground(178, 72)
                .build("garnished.blue_dye_blowing", BlueDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> purpleDyeBlowing = builder(PurpleDyeBlowingFanRecipe.class)
                .addTypedRecipes(GarnishedRecipeTypes.PURPLE_DYE_BLOWING::getType)
                .catalystStack(ProcessingViaFanCategory.getFan("garnished.purple_dye_blowing"))
                .doubleItemIcon(AllItems.PROPELLER.get(), GarnishedFluids.PURPLE_MASTIC_RESIN.getBucket().get())
                .emptyBackground(178, 72)
                .build("garnished.purple_dye_blowing", PurpleDyeBlowingFanCategory::new);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        ingredientManager = registration.getIngredientManager();
        Categories.forEach(c -> c.registerRecipes(registration));
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        loadCategories();
        registration.addRecipeCategories(Categories.toArray(IRecipeCategory[]::new));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        Categories.forEach(c -> c.registerCatalysts(registration));
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(new BlueprintTransferHandler(), RecipeTypes.CRAFTING);
    }

    private <T extends Recipe<?>> CategoryBuilder<T> builder(Class<? extends T> recipeClass) {
        return new CategoryBuilder<>(recipeClass);
    }

    private static class CategoryBuilder<T extends Recipe<?>> {
        private final Class<? extends T> recipeClass;
        private Predicate<CRecipes> predicate = cRecipes -> true;

        private IDrawable background;
        private IDrawable icon;

        private final List<Consumer<List<T>>> recipeListConsumers = new ArrayList<>();
        private final List<Supplier<? extends ItemStack>> catalysts = new ArrayList<>();

        public CategoryBuilder(Class<? extends T> recipeClass) {
            this.recipeClass = recipeClass;
        }

        public CategoryBuilder<T> enableIf(Predicate<CRecipes> predicate) {
            this.predicate = predicate;
            return this;
        }

        public CategoryBuilder<T> enableWhen(Function<CRecipes, Object> configValue) {
            predicate = c -> (boolean) configValue.apply(c);
            return this;
        }

        public CategoryBuilder<T> addRecipeListConsumer(Consumer<List<T>> consumer) {
            recipeListConsumers.add(consumer);
            return this;
        }

        public CategoryBuilder<T> addRecipes(Supplier<Collection<? extends T>> collection) {
            return addRecipeListConsumer(recipes -> recipes.addAll(collection.get()));
        }

        public CategoryBuilder<T> addAllRecipesIf(Predicate<Recipe<?>> pred) {
            return addRecipeListConsumer(recipes -> consumeAllRecipes(recipe -> {
                if (pred.test(recipe)) {
                    recipes.add((T) recipe);
                }
            }));
        }

        public CategoryBuilder<T> addAllRecipesIf(Predicate<Recipe<?>> pred, Function<Recipe<?>, T> converter) {
            return addRecipeListConsumer(recipes -> consumeAllRecipes(recipe -> {
                if (pred.test(recipe)) {
                    recipes.add(converter.apply(recipe));
                }
            }));
        }

        public CategoryBuilder<T> addTypedRecipes(IRecipeTypeInfo recipeTypeEntry) {
            return addTypedRecipes(recipeTypeEntry::getType);
        }

        public CategoryBuilder<T> addTypedRecipes(Supplier<RecipeType<? extends T>> recipeType) {
            return addRecipeListConsumer(recipes -> CreateJEI.<T>consumeTypedRecipes(recipes::add, recipeType.get()));
        }

        public CategoryBuilder<T> addTypedRecipes(Supplier<RecipeType<? extends T>> recipeType, Function<Recipe<?>, T> converter) {
            return addRecipeListConsumer(recipes -> CreateJEI.<T>consumeTypedRecipes(recipe -> recipes.add(converter.apply(recipe)), recipeType.get()));
        }

        public CategoryBuilder<T> addTypedRecipesIf(Supplier<RecipeType<? extends T>> recipeType, Predicate<Recipe<?>> pred) {
            return addRecipeListConsumer(recipes -> CreateJEI.<T>consumeTypedRecipes(recipe -> {
                if (pred.test(recipe)) {
                    recipes.add(recipe);
                }
            }, recipeType.get()));
        }

        public CategoryBuilder<T> addTypedRecipesExcluding(Supplier<RecipeType<? extends T>> recipeType,
                                                           Supplier<RecipeType<? extends T>> excluded) {
            return addRecipeListConsumer(recipes -> {
                List<Recipe<?>> excludedRecipes = getTypedRecipes(excluded.get());
                CreateJEI.<T>consumeTypedRecipes(recipe -> {
                    for (Recipe<?> excludedRecipe : excludedRecipes) {
                        if (doInputsMatch(recipe, excludedRecipe)) {
                            return;
                        }
                    }
                    recipes.add(recipe);
                }, recipeType.get());
            });
        }

        public CategoryBuilder<T> removeRecipes(Supplier<RecipeType<? extends T>> recipeType) {
            return addRecipeListConsumer(recipes -> {
                List<Recipe<?>> excludedRecipes = getTypedRecipes(recipeType.get());
                recipes.removeIf(recipe -> {
                    for (Recipe<?> excludedRecipe : excludedRecipes) {
                        if (doInputsMatch(recipe, excludedRecipe)) {
                            return true;
                        }
                    }
                    return false;
                });
            });
        }


        public static List<Recipe<?>> getTypedRecipes(RecipeType<?> type) {
            List<Recipe<?>> recipes = new ArrayList<>();
            consumeTypedRecipes(recipes::add, type);
            return recipes;
        }

        public static List<Recipe<?>> getTypedRecipesExcluding(RecipeType<?> type, Predicate<Recipe<?>> exclusionPred) {
            List<Recipe<?>> recipes = getTypedRecipes(type);
            recipes.removeIf(exclusionPred);
            return recipes;
        }

        public static boolean doInputsMatch(Recipe<?> recipe1, Recipe<?> recipe2) {
            if (recipe1.getIngredients()
                    .isEmpty()
                    || recipe2.getIngredients()
                    .isEmpty()) {
                return false;
            }
            ItemStack[] matchingStacks = recipe1.getIngredients()
                    .get(0)
                    .getItems();
            if (matchingStacks.length == 0) {
                return false;
            }
            return recipe2.getIngredients()
                    .get(0)
                    .test(matchingStacks[0]);
        }

        public CategoryBuilder<T> catalystStack(Supplier<ItemStack> supplier) {
            catalysts.add(supplier);
            return this;
        }

        public CategoryBuilder<T> catalyst(Supplier<ItemLike> supplier) {
            return catalystStack(() -> new ItemStack(supplier.get()
                    .asItem()));
        }

        public CategoryBuilder<T> icon(IDrawable icon) {
            this.icon = icon;
            return this;
        }

        public CategoryBuilder<T> itemIcon(ItemLike item) {
            icon(new ItemIcon(() -> new ItemStack(item)));
            return this;
        }

        public CategoryBuilder<T> doubleItemIcon(ItemLike item1, ItemLike item2) {
            icon(new DoubleItemIcon(() -> new ItemStack(item1), () -> new ItemStack(item2)));
            return this;
        }

        public CategoryBuilder<T> background(IDrawable background) {
            this.background = background;
            return this;
        }

        public CategoryBuilder<T> emptyBackground(int width, int height) {
            background(new EmptyBackground(width, height));
            return this;
        }

        public CreateRecipeCategory<T> build(String name, CreateRecipeCategory.Factory<T> factory) {
            Supplier<List<T>> recipesSupplier;
            if (predicate.test(AllConfigs.server().recipes)) {
                recipesSupplier = () -> {
                    List<T> recipes = new ArrayList<>();
                    for (Consumer<List<T>> consumer : recipeListConsumers)
                        consumer.accept(recipes);
                    return recipes;
                };
            } else {
                recipesSupplier = Collections::emptyList;
            }

            CreateRecipeCategory.Info<T> info = new CreateRecipeCategory.Info<>(
                    new mezz.jei.api.recipe.RecipeType<>(CreateGarnished.asResource(name), recipeClass),
                    Lang.translateDirect("recipe." + name), background, icon, recipesSupplier, catalysts);
            CreateRecipeCategory<T> category = factory.create(info);
            Categories.add(category);
            return category;
        }
    }

    public static void consumeAllRecipes(Consumer<Recipe<?>> consumer) {
        Objects.requireNonNull(Minecraft.getInstance()
                        .getConnection())
                .getRecipeManager()
                .getRecipes()
                .forEach(consumer);
    }

}
