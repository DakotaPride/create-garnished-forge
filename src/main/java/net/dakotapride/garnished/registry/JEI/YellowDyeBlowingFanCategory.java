package net.dakotapride.garnished.registry.JEI;

import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.foundation.gui.element.GuiGameElement;
import net.dakotapride.garnished.recipe.OrangeDyeBlowingFanRecipe;
import net.dakotapride.garnished.recipe.YellowDyeBlowingFanRecipe;
import net.dakotapride.garnished.registry.GarnishedFluids;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

public class YellowDyeBlowingFanCategory extends DyeBlowingFanCategory<YellowDyeBlowingFanRecipe> {
    public YellowDyeBlowingFanCategory(Info<YellowDyeBlowingFanRecipe> info) {
        super(GarnishedFluids.YELLOW_MASTIC_RESIN.getSource(), info);
    }

}
