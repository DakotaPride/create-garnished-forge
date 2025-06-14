package net.dakotapride.garnished.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import net.dakotapride.garnished.registry.recipe.GarnishedRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class OrangeDyeBlowingFanRecipe extends DyeBlowingFanRecipe {
    public OrangeDyeBlowingFanRecipe(ProcessingRecipeParams params) {
        super(GarnishedRecipeTypes.ORANGE_DYE_BLOWING, params);
    }

}