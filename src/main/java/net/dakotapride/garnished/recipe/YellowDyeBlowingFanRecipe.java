package net.dakotapride.garnished.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import net.dakotapride.garnished.registry.GarnishedRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class YellowDyeBlowingFanRecipe extends DyeBlowingFanRecipe {

    public YellowDyeBlowingFanRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(GarnishedRecipeTypes.YELLOW_DYE_BLOWING, params);
    }

}
