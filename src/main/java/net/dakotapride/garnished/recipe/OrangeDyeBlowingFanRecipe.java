package net.dakotapride.garnished.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import net.dakotapride.garnished.registry.GarnishedRecipeTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class OrangeDyeBlowingFanRecipe extends DyeBlowingFanRecipe {

    public OrangeDyeBlowingFanRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(GarnishedRecipeTypes.ORANGE_DYE_BLOWING, params);
    }

}
