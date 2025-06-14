package net.dakotapride.garnished.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dakotapride.garnished.registry.recipe.GarnishedRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class LightBlueDyeBlowingFanRecipe extends DyeBlowingFanRecipe {
    public LightBlueDyeBlowingFanRecipe(ProcessingRecipeParams params) {
        super(GarnishedRecipeTypes.LIGHT_BLUE_DYE_BLOWING, params);
    }


}