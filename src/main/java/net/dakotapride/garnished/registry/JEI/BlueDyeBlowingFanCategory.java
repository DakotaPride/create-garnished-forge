package net.dakotapride.garnished.registry.JEI;

import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.foundation.gui.element.GuiGameElement;
import net.dakotapride.garnished.recipe.BlueDyeBlowingFanRecipe;
import net.dakotapride.garnished.recipe.GreenDyeBlowingFanRecipe;
import net.dakotapride.garnished.registry.GarnishedFluids;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

public class BlueDyeBlowingFanCategory extends ProcessingViaFanCategory.MultiOutput<BlueDyeBlowingFanRecipe> {
    public BlueDyeBlowingFanCategory(Info<BlueDyeBlowingFanRecipe> info) {
        super(info);
    }

    @Override
    protected void renderAttachedBlock(@NotNull GuiGraphics graphics) {
        GuiGameElement.of(GarnishedFluids.BLUE_MASTIC_RESIN.getSource().getFlowing())
                .scale(SCALE)
                .atLocal(0, 0, 2)
                .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
                .render(graphics);
    }

}
