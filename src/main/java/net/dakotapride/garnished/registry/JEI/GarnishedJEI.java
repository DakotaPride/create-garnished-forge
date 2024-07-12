package net.dakotapride.garnished.registry.JEI;

import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.*;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import com.simibubi.create.foundation.utility.Lang;
import com.simibubi.create.infrastructure.config.AllConfigs;
import com.simibubi.create.infrastructure.config.CRecipes;
import com.tterrag.registrate.util.entry.FluidEntry;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
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
import net.dakotapride.garnished.registry.GarnishedItems;
import net.dakotapride.garnished.registry.GarnishedRecipeTypes;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;

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
        CreateRecipeCategory<?> redDyeBlowing = dyeBlowingCategory(RedDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.RED_DYE_BLOWING, "garnished.red_dye_blowing", GarnishedFluids.RED_MASTIC_RESIN)
                .build("garnished.red_dye_blowing", RedDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> orangeDyeBlowing = dyeBlowingCategory(OrangeDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.ORANGE_DYE_BLOWING, "garnished.orange_dye_blowing", GarnishedFluids.ORANGE_MASTIC_RESIN)
                .build("garnished.orange_dye_blowing", OrangeDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> yellowDyeBlowing = dyeBlowingCategory(YellowDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.YELLOW_DYE_BLOWING, "garnished.yellow_dye_blowing", GarnishedFluids.YELLOW_MASTIC_RESIN)
                .build("garnished.yellow_dye_blowing", YellowDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> greenDyeBlowing = dyeBlowingCategory(GreenDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.GREEN_DYE_BLOWING, "garnished.green_dye_blowing", GarnishedFluids.GREEN_MASTIC_RESIN)
                .build("garnished.green_dye_blowing", GreenDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> limeDyeBlowing = dyeBlowingCategory(LimeDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.LIME_DYE_BLOWING, "garnished.lime_dye_blowing", GarnishedFluids.LIME_MASTIC_RESIN)
                .build("garnished.lime_dye_blowing", LimeDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> blueDyeBlowing = dyeBlowingCategory(BlueDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.BLUE_DYE_BLOWING, "garnished.blue_dye_blowing", GarnishedFluids.BLUE_MASTIC_RESIN)
                .build("garnished.blue_dye_blowing", BlueDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> lightBlueDyeBlowing = dyeBlowingCategory(LightBlueDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.LIGHT_BLUE_DYE_BLOWING, "garnished.light_blue_dye_blowing", GarnishedFluids.LIGHT_BLUE_MASTIC_RESIN)
                .build("garnished.light_blue_dye_blowing", LightBlueDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> cyanDyeBlowing = dyeBlowingCategory(CyanDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.CYAN_DYE_BLOWING, "garnished.cyan_dye_blowing", GarnishedFluids.CYAN_MASTIC_RESIN)
                .build("garnished.cyan_dye_blowing", CyanDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> purpleDyeBlowing = dyeBlowingCategory(PurpleDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.PURPLE_DYE_BLOWING, "garnished.purple_dye_blowing", GarnishedFluids.PURPLE_MASTIC_RESIN)
                .build("garnished.purple_dye_blowing", PurpleDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> magentaDyeBlowing = dyeBlowingCategory(MagentaDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.MAGENTA_DYE_BLOWING, "garnished.magenta_dye_blowing", GarnishedFluids.MAGENTA_MASTIC_RESIN)
                .build("garnished.magenta_dye_blowing", MagentaDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> pinkDyeBlowing = dyeBlowingCategory(PinkDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.PINK_DYE_BLOWING, "garnished.pink_dye_blowing", GarnishedFluids.PINK_MASTIC_RESIN)
                .build("garnished.pink_dye_blowing", PinkDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> blackDyeBlowing = dyeBlowingCategory(BlackDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.BLACK_DYE_BLOWING, "garnished.black_dye_blowing", GarnishedFluids.BLACK_MASTIC_RESIN)
                .build("garnished.black_dye_blowing", BlackDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> grayDyeBlowing = dyeBlowingCategory(GrayDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.GRAY_DYE_BLOWING, "garnished.gray_dye_blowing", GarnishedFluids.GRAY_MASTIC_RESIN)
                .build("garnished.gray_dye_blowing", GrayDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> lightGrayDyeBlowing = dyeBlowingCategory(LightGrayDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.LIGHT_GRAY_DYE_BLOWING, "garnished.light_gray_dye_blowing", GarnishedFluids.LIGHT_GRAY_MASTIC_RESIN)
                .build("garnished.light_gray_dye_blowing", LightGrayDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> whiteDyeBlowing = dyeBlowingCategory(WhiteDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.WHITE_DYE_BLOWING, "garnished.white_dye_blowing", GarnishedFluids.WHITE_MASTIC_RESIN)
                .build("garnished.white_dye_blowing", WhiteDyeBlowingFanCategory::new);
        CreateRecipeCategory<?> brownDyeBlowing = dyeBlowingCategory(BrownDyeBlowingFanRecipe.class,
                GarnishedRecipeTypes.BROWN_DYE_BLOWING, "garnished.brown_dye_blowing", GarnishedFluids.BROWN_MASTIC_RESIN)
                .build("garnished.brown_dye_blowing", BrownDyeBlowingFanCategory::new);

    }

    public <T extends Recipe<?>> CategoryBuilder<T> dyeBlowingCategory(Class<T> recipe, GarnishedRecipeTypes types, String name, FluidEntry<ForgeFlowingFluid.Flowing> fluidEntry) {
        return builder(recipe)
                .addTypedRecipes(types::getType)
                .catalystStack(ProcessingViaFanCategory.getFan(name))
                .doubleItemIcon(AllItems.PROPELLER.get(), fluidEntry.getBucket().get())
                .emptyBackground(178, 72);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        ingredientManager = registration.getIngredientManager();
        Categories.forEach(c -> c.registerRecipes(registration));

        registration.addIngredientInfo(new ItemStack(GarnishedItems.ENFLAMED_MANDIBLE.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.enflamed_mandible.information"));
        registration.addIngredientInfo(new ItemStack(GarnishedItems.GHAST_TENDRIL.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.ghast_tendril.information"));
        registration.addIngredientInfo(new ItemStack(GarnishedItems.MOLTEN_REMNANT.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.molten_remnant.information"));
        registration.addIngredientInfo(new ItemStack(GarnishedItems.RAW_POLAR_BEAR_MEAT.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.polar_bear_meat.information"));
        registration.addIngredientInfo(new ItemStack(GarnishedItems.POLAR_BEAR_HIDE.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.polar_bear_hide.information"));
        registration.addIngredientInfo(new ItemStack(GarnishedItems.NUMBING_PARCHMENT.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.stray_parchment.information"));
        registration.addIngredientInfo(new ItemStack(GarnishedItems.RAW_TENEBROUS_MEAT.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.tenebrous_meat.information"));
        registration.addIngredientInfo(new ItemStack(GarnishedItems.TUSK.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.tusk.information"));
        registration.addIngredientInfo(new ItemStack(GarnishedItems.IRATE_TUSK.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.irate_tusk.information"));
        registration.addIngredientInfo(new ItemStack(GarnishedItems.DIMMED_SCALE.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.ender_scale.information"));
        registration.addIngredientInfo(new ItemStack(GarnishedItems.PRELIMINARY_NUCLEUS.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.endermite_heart.information"));
        registration.addIngredientInfo(new ItemStack(GarnishedItems.MEAT_SCRAPS.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.ravager_meat.information"));
        registration.addIngredientInfo(new ItemStack(GarnishedItems.VEX_WING.get()), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.garnished.vex_wing.information"));
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
