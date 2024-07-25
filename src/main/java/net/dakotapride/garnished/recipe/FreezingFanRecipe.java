package net.dakotapride.garnished.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import net.dakotapride.garnished.registry.GarnishedRecipeTypes;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FreezingFanRecipe extends ProcessingRecipe<FreezingFanRecipe.FreezingWrapper> {

	public FreezingFanRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
		super(GarnishedRecipeTypes.FREEZING, params);
	}

	@Override
	public boolean matches(FreezingWrapper inv, Level worldIn) {
		if (inv.isEmpty())
			return false;
		return ingredients.get(0)
				.test(inv.getItem(0));
	}

	@Override
	protected int getMaxInputCount() {
		return 1;
	}

	@Override
	protected int getMaxOutputCount() {
		return 12;
	}

	public static class FreezingWrapper extends RecipeWrapper {
		public FreezingWrapper() {
			super(new ItemStackHandler(1));
		}
	}

}