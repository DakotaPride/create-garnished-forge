package net.dakotapride.garnished.registry.recipe;

import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import net.createmod.catnip.lang.Lang;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.recipe.*;
import net.dakotapride.garnished.registry.recipe.md.GarnishedRecipeTypeInfo;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class GarnishedRecipeTypes {

    public static final GarnishedRecipeTypeInfo<FreezingFanRecipe> FREEZING =
            register("freezing", FreezingFanRecipe.Serializer::new);

    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> RED_DYE_BLOWING =
            register("red_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(RedDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> ORANGE_DYE_BLOWING =
            register("orange_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(OrangeDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> YELLOW_DYE_BLOWING =
            register("yellow_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(YellowDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> GREEN_DYE_BLOWING =
            register("green_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(GreenDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> LIME_DYE_BLOWING =
            register("lime_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(LimeDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> BLUE_DYE_BLOWING =
            register("blue_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(BlueDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> LIGHT_BLUE_DYE_BLOWING =
            register("light_blue_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(LightBlueDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> CYAN_DYE_BLOWING =
            register("cyan_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(CyanDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> PURPLE_DYE_BLOWING =
            register("purple_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(PurpleDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> MAGENTA_DYE_BLOWING =
            register("magenta_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(MagentaDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> PINK_DYE_BLOWING =
            register("pink_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(PinkDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> BLACK_DYE_BLOWING =
            register("black_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(BlackDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> GRAY_DYE_BLOWING =
            register("gray_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(GrayDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> LIGHT_GRAY_DYE_BLOWING =
            register("light_gray_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(LightGrayDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> WHITE_DYE_BLOWING =
            register("white_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(WhiteDyeBlowingFanRecipe::new));
    public static final GarnishedRecipeTypeInfo<DyeBlowingFanRecipe> BROWN_DYE_BLOWING =
            register("brown_dye_blowing", () -> new DyeBlowingFanRecipe.Serializer<>(BrownDyeBlowingFanRecipe::new));

    private static <R extends Recipe<?>> GarnishedRecipeTypeInfo<R> register(String name, Supplier<? extends RecipeSerializer<R>> serializerSupplier) {
        return new GarnishedRecipeTypeInfo<>(name, serializerSupplier, Registers.SERIALIZER_REGISTER, Registers.TYPE_REGISTER);
    }

    public static void register(IEventBus modEventBus) {
        ShapedRecipePattern.setCraftingSize(9, 9);
        Registers.SERIALIZER_REGISTER.register(modEventBus);
        Registers.TYPE_REGISTER.register(modEventBus);
    }

    private static class Registers {
        private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, CreateGarnished.ID);
        private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, CreateGarnished.ID);
    }

}