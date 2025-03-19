package net.dakotapride.garnished.registry.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.createmod.catnip.lang.Lang;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.recipe.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

public enum GarnishedRecipeTypes implements IRecipeTypeInfo, StringRepresentable {
    FREEZING(FreezingFanRecipe::new),
    RED_DYE_BLOWING(RedDyeBlowingFanRecipe::new),
    ORANGE_DYE_BLOWING(OrangeDyeBlowingFanRecipe::new),
    YELLOW_DYE_BLOWING(YellowDyeBlowingFanRecipe::new),
    GREEN_DYE_BLOWING(GreenDyeBlowingFanRecipe::new),
    LIME_DYE_BLOWING(LimeDyeBlowingFanRecipe::new),
    BLUE_DYE_BLOWING(BlueDyeBlowingFanRecipe::new),
    LIGHT_BLUE_DYE_BLOWING(LightBlueDyeBlowingFanRecipe::new),
    CYAN_DYE_BLOWING(CyanDyeBlowingFanRecipe::new),
    PURPLE_DYE_BLOWING(PurpleDyeBlowingFanRecipe::new),
    MAGENTA_DYE_BLOWING(MagentaDyeBlowingFanRecipe::new),
    PINK_DYE_BLOWING(PinkDyeBlowingFanRecipe::new),
    BLACK_DYE_BLOWING(BlackDyeBlowingFanRecipe::new),
    GRAY_DYE_BLOWING(GrayDyeBlowingFanRecipe::new),
    LIGHT_GRAY_DYE_BLOWING(LightGrayDyeBlowingFanRecipe::new),
    WHITE_DYE_BLOWING(WhiteDyeBlowingFanRecipe::new),
    BROWN_DYE_BLOWING(BrownDyeBlowingFanRecipe::new);

    public final ResourceLocation id;
    public final Supplier<RecipeSerializer<?>> serializerSupplier;
    public final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> serializerObject;
    public final Supplier<RecipeType<?>> type;

    public static final Codec<GarnishedRecipeTypes> CODEC = StringRepresentable.fromEnum(GarnishedRecipeTypes::values);

    GarnishedRecipeTypes(Supplier<RecipeSerializer<?>> serializerSupplier) {
        String name = Lang.asId(name());
        id = CreateGarnished.asResource(name);
        serializerObject = Registers.SERIALIZER_REGISTER.register(name, serializerSupplier);
        @Nullable Supplier<RecipeType<?>> typeObject = Registers.TYPE_REGISTER.register(name, () -> RecipeType.simple(id));
        type = typeObject;
        this.serializerSupplier = serializerSupplier;
    }

    GarnishedRecipeTypes(ProcessingRecipeBuilder.ProcessingRecipeFactory<?> processingFactory) {
        this(() -> new ProcessingRecipeSerializer<>(processingFactory));
    }

    public static void register(IEventBus modEventBus) {
        ShapedRecipePattern.setCraftingSize(9, 9);
        Registers.SERIALIZER_REGISTER.register(modEventBus);
        Registers.TYPE_REGISTER.register(modEventBus);
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) serializerObject.get();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I extends RecipeInput, R extends Recipe<I>> RecipeType<R> getType() {
        return (RecipeType<R>) type.get();
    }

    public <I extends RecipeInput, R extends Recipe<I>> Optional<RecipeHolder<R>> find(I inv, Level world) {
        return world.getRecipeManager()
                .getRecipeFor(getType(), inv, world);
    }

    @Override
    public @NotNull String getSerializedName() {
        return id.toString();
    }

//    public <T extends ProcessingRecipe<?>> MapCodec<T> processingCodec() {
////        if (!isProcessingRecipe)
////            throw new AssertionError("AllRecipeTypes#processingCodec called on " + name() + ", which is not a processing recipe");
////        if (this == DEPLOYING || this == ITEM_APPLICATION)
////            return ItemApplicationRecipe.codec(this);
//        return ProcessingRecipeSerializer.codec(this);
//    }

    private static class Registers {
        private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, CreateGarnished.ID);
        private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, CreateGarnished.ID);
    }

}