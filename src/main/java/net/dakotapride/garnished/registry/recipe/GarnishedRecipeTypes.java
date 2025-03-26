package net.dakotapride.garnished.registry.recipe;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.simibubi.create.content.processing.recipe.*;
import com.simibubi.create.foundation.fluid.FluidIngredient;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.createmod.catnip.lang.Lang;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.recipe.*;
import net.dakotapride.garnished.registry.recipe.md.CustomProcessingSerializer;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
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

    private boolean isProcessingRecipe;

    GarnishedRecipeTypes(Supplier<RecipeSerializer<?>> serializerSupplier) {
        String name = Lang.asId(name());
        id = CreateGarnished.asResource(name);
        serializerObject = Registers.SERIALIZER_REGISTER.register(name, serializerSupplier);
        @Nullable Supplier<RecipeType<?>> typeObject = Registers.TYPE_REGISTER.register(name, () -> RecipeType.simple(id));
        type = typeObject;
        this.serializerSupplier = serializerSupplier;
        this.isProcessingRecipe = false;
    }

    GarnishedRecipeTypes(ProcessingRecipeBuilder.ProcessingRecipeFactory<?> processingFactory) {
        this(() -> new CustomProcessingSerializer<>(processingFactory));
        this.isProcessingRecipe = true;
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

    public <T extends ProcessingRecipe<?>> MapCodec<T> processingCodec() {
        if (!isProcessingRecipe)
            throw new AssertionError("GarnishedRecipeTypes#processingCodec called on "+name()+", which is not a processing recipe");
        return RecordCodecBuilder.mapCodec(instance -> instance.group(
                Codec.either(Ingredient.CODEC, FluidIngredient.CODEC).listOf().fieldOf("ingredients").forGetter(i -> {
                    List<Either<Ingredient, FluidIngredient>> list = new ArrayList<>();
                    i.getIngredients().forEach(o -> list.add(Either.left(o)));
                    i.getFluidIngredients().forEach(o -> list.add(Either.right(o)));
                    return list;
                }),
                Codec.either(ProcessingOutput.CODEC, FluidStack.CODEC).listOf().fieldOf("results").forGetter(i -> {
                    List<Either<ProcessingOutput, FluidStack>> list = new ArrayList<>();
                    i.getRollableResults().forEach(o -> list.add(Either.left(o)));
                    i.getFluidResults().forEach(o -> list.add(Either.right(o)));
                    return list;
                }),
                ExtraCodecs.NON_NEGATIVE_INT.optionalFieldOf("processing_time", 0).forGetter(T::getProcessingDuration),
                StringRepresentable.fromEnum(HeatCondition::values).optionalFieldOf("heat_requirement", HeatCondition.NONE).forGetter(T::getRequiredHeat)
        ).apply(instance, (ingredients, results, processingTime, heatRequirement) -> {
            if (!(serializerSupplier.get() instanceof CustomProcessingSerializer processingRecipeSerializer))
                throw new RuntimeException("Not a processing recipe serializer " + serializerSupplier.get());

            ProcessingRecipeBuilder<T> builder = new ProcessingRecipeBuilder<T>(processingRecipeSerializer.getFactory(), this.id);

            NonNullList<Ingredient> ingredientList = NonNullList.create();
            NonNullList<FluidIngredient> fluidIngredientList = NonNullList.create();

            NonNullList<ProcessingOutput> processingOutputList = NonNullList.create();
            NonNullList<FluidStack> fluidStackOutputList = NonNullList.create();

            for (Either<Ingredient, FluidIngredient> either : ingredients) {
                either.left().ifPresent(ingredientList::add);
                either.right().ifPresent(fluidIngredientList::add);
            }

            for (Either<ProcessingOutput, FluidStack> either : results) {
                either.left().ifPresent(processingOutputList::add);
                either.right().ifPresent(fluidStackOutputList::add);
            }

            builder.withItemIngredients(ingredientList)
                    .withItemOutputs(processingOutputList)
                    .withFluidIngredients(fluidIngredientList)
                    .withFluidOutputs(fluidStackOutputList)
                    .duration(processingTime)
                    .requiresHeat(heatRequirement);

            return builder.build();
        }));
    }

    private static class Registers {
        private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, CreateGarnished.ID);
        private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, CreateGarnished.ID);
    }

}