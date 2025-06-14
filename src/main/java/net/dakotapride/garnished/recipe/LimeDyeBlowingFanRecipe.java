package net.dakotapride.garnished.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dakotapride.garnished.registry.recipe.GarnishedRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class LimeDyeBlowingFanRecipe extends DyeBlowingFanRecipe {
    public LimeDyeBlowingFanRecipe(ProcessingRecipeParams params) {
        super(GarnishedRecipeTypes.LIME_DYE_BLOWING, params);
    }


}