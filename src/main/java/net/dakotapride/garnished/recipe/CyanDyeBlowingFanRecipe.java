package net.dakotapride.garnished.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dakotapride.garnished.registry.recipe.GarnishedRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class CyanDyeBlowingFanRecipe extends DyeBlowingFanRecipe {
    public CyanDyeBlowingFanRecipe(ProcessingRecipeParams params) {
        super(GarnishedRecipeTypes.CYAN_DYE_BLOWING, params);
    }


}