package net.dakotapride.garnished.registry.JEI;

import com.google.common.base.Preconditions;
import com.simibubi.create.compat.jei.BlueprintTransferHandler;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.api.runtime.IJeiRuntime;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.registry.GarnishedFluids;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.dakotapride.garnished.registry.recipe.GarnishedRecipeTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLLoader;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

@JeiPlugin
@SuppressWarnings("unused")
@ParametersAreNonnullByDefault
public class GarnishedJEI implements IModPlugin {
    private static final ResourceLocation MOD_ID = CreateGarnished.asResource("jei_plugin");

    @Override
    @Nonnull
    public ResourceLocation getPluginUid() {
        return MOD_ID;
    }

    //private final List<CreateRecipeCategory<?>> allCategories = new ArrayList<>();
    private final List<IRecipeCategory<?>> categories = new ArrayList<>();
    private IIngredientManager ingredientManager;

    public static IJeiRuntime runtime;

    private void loadCategories(IRecipeCategoryRegistration registration) {
        categories.clear();

        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        List<IRecipeCategory<?>> localCategories = new ArrayList<>();


        localCategories.add(FreezingFanCategory.create(guiHelper));

        localCategories.add(RedDyeBlowingFanCategory.create(GarnishedRecipeTypes.RED_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("red_dye_blowing")),
                GarnishedFluids.RED_MASTIC_RESIN, "red_dye_blowing"));
        localCategories.add(OrangeDyeBlowingFanCategory.create(GarnishedRecipeTypes.ORANGE_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("orange_dye_blowing")),
                GarnishedFluids.ORANGE_MASTIC_RESIN, "orange_dye_blowing"));
        localCategories.add(YellowDyeBlowingFanCategory.create(GarnishedRecipeTypes.YELLOW_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("yellow_dye_blowing")),
                GarnishedFluids.YELLOW_MASTIC_RESIN, "yellow_dye_blowing"));
        localCategories.add(GreenDyeBlowingFanCategory.create(GarnishedRecipeTypes.GREEN_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("green_dye_blowing")),
                GarnishedFluids.GREEN_MASTIC_RESIN, "green_dye_blowing"));
        localCategories.add(LimeDyeBlowingFanCategory.create(GarnishedRecipeTypes.LIME_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("lime_dye_blowing")),
                GarnishedFluids.LIME_MASTIC_RESIN, "lime_dye_blowing"));
        localCategories.add(BlueDyeBlowingFanCategory.create(GarnishedRecipeTypes.BLUE_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("blue_dye_blowing")),
                GarnishedFluids.BLUE_MASTIC_RESIN, "blue_dye_blowing"));
        localCategories.add(LightBlueDyeBlowingFanCategory.create(GarnishedRecipeTypes.LIGHT_BLUE_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("light_blue_dye_blowing")),
                GarnishedFluids.LIGHT_BLUE_MASTIC_RESIN, "light_blue_dye_blowing"));
        localCategories.add(CyanDyeBlowingFanCategory.create(GarnishedRecipeTypes.CYAN_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("cyan_dye_blowing")),
                GarnishedFluids.CYAN_MASTIC_RESIN, "cyan_dye_blowing"));
        localCategories.add(PurpleDyeBlowingFanCategory.create(GarnishedRecipeTypes.PURPLE_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("purple_dye_blowing")),
                GarnishedFluids.PURPLE_MASTIC_RESIN, "purple_dye_blowing"));
        localCategories.add(MagentaDyeBlowingFanCategory.create(GarnishedRecipeTypes.MAGENTA_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("magenta_dye_blowing")),
                GarnishedFluids.MAGENTA_MASTIC_RESIN, "magenta_dye_blowing"));
        localCategories.add(PinkDyeBlowingFanCategory.create(GarnishedRecipeTypes.PINK_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("pink_dye_blowing")),
                GarnishedFluids.PINK_MASTIC_RESIN, "pink_dye_blowing"));
        localCategories.add(BlackDyeBlowingFanCategory.create(GarnishedRecipeTypes.BLACK_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("black_dye_blowing")),
                GarnishedFluids.BLACK_MASTIC_RESIN, "black_dye_blowing"));
        localCategories.add(GrayDyeBlowingFanCategory.create(GarnishedRecipeTypes.GRAY_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("gray_dye_blowing")),
                GarnishedFluids.GRAY_MASTIC_RESIN, "gray_dye_blowing"));
        localCategories.add(LightGrayDyeBlowingFanCategory.create(GarnishedRecipeTypes.LIGHT_GRAY_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("light_gray_dye_blowing")),
                GarnishedFluids.LIGHT_GRAY_MASTIC_RESIN, "light_gray_dye_blowing"));
        localCategories.add(WhiteDyeBlowingFanCategory.create(GarnishedRecipeTypes.WHITE_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("white_dye_blowing")),
                GarnishedFluids.WHITE_MASTIC_RESIN, "white_dye_blowing"));
        localCategories.add(BrownDyeBlowingFanCategory.create(GarnishedRecipeTypes.BROWN_DYE_BLOWING.getType(),
                guiHelper, RecipeType.createRecipeHolderType(CreateGarnished.asResource("brown_dye_blowing")),
                GarnishedFluids.BROWN_MASTIC_RESIN, "brown_dye_blowing"));

        registration.addRecipeCategories(localCategories.toArray(new IRecipeCategory[0]));

        this.categories.clear();
        this.categories.addAll(localCategories);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        ingredientManager = registration.getIngredientManager();

        for (IRecipeCategory<?> category : categories) {
            if (category instanceof CreateRecipeCategory) {
                ((CreateRecipeCategory<?>) category).registerRecipes(registration);
            }
        }

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
        loadCategories(registration);
        registration.addRecipeCategories(categories.toArray(IRecipeCategory[]::new));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {

        registration.getJeiHelpers().getRecipeType(ResourceLocation.fromNamespaceAndPath("create", "sandpaper_polishing")).ifPresent(type -> {
            registration.addRecipeCatalyst(new ItemStack(GarnishedItems.POLAR_HIDE_SCRATCH_PAPER.get()), type);
        });

        for (IRecipeCategory<?> category : categories) {
            if (category instanceof CreateRecipeCategory) {
                ((CreateRecipeCategory<?>) category).registerCatalysts(registration);
            }
        }
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(new BlueprintTransferHandler(), RecipeTypes.CRAFTING);
    }

    public static RecipeManager getRecipeManager() {
        if (FMLLoader.getDist() != Dist.CLIENT)
            throw new IllegalStateException();
        var minecraft = Minecraft.getInstance();
        Preconditions.checkNotNull(minecraft);
        var level = minecraft.level;
        Preconditions.checkNotNull(level);
        return level.getRecipeManager();
    }

}
