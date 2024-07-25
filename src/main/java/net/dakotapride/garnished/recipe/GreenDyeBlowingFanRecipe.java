package net.dakotapride.garnished.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import net.dakotapride.garnished.registry.GarnishedRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class GreenDyeBlowingFanRecipe extends DyeBlowingFanRecipe {

    public GreenDyeBlowingFanRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(GarnishedRecipeTypes.GREEN_DYE_BLOWING, params);
    }


}
