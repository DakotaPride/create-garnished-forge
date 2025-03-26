package net.dakotapride.garnished.registry.recipe.md;

import com.mojang.serialization.MapCodec;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import net.dakotapride.garnished.registry.recipe.GarnishedRecipeTypes;

public class CustomProcessingSerializer<T extends ProcessingRecipe<?>> extends ProcessingRecipeSerializer<T> {

    public final MapCodec<T> CODEC = GarnishedRecipeTypes.CODEC.dispatchMap(t -> (GarnishedRecipeTypes) t.getTypeInfo(), GarnishedRecipeTypes::processingCodec);


    public CustomProcessingSerializer(ProcessingRecipeBuilder.ProcessingRecipeFactory<T> factory) {
        super(factory);
    }


    @Override
    public MapCodec<T> codec() {
        return CODEC;
    }
}
