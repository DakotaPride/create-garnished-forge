package net.dakotapride.garnished.registry.JEI;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.DoubleItemIcon;
import com.simibubi.create.compat.jei.EmptyBackground;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;
import com.tterrag.registrate.util.entry.FluidEntry;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.dakotapride.garnished.recipe.DyeBlowingFanRecipe;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class DyeBlowingFanCategory <T extends StandardProcessingRecipe<?>> extends ProcessingViaFanCategory.MultiOutput<T> {
    Fluid fluid;

    public DyeBlowingFanCategory(Fluid fluid0, Info<T> info) {
        super(info);
        this.fluid = fluid0;
    }

    @Override
    protected void renderAttachedBlock(@NotNull GuiGraphics graphics) {
        GuiGameElement.of(fluid)
                .scale(SCALE)
                .atLocal(0, 0, 2)
                .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
                .render(graphics);
    }

    public static <D extends DyeBlowingFanRecipe> DyeBlowingFanCategory<?> create(net.minecraft.world.item.crafting.RecipeType<D> type,
                                                                           IGuiHelper guiHelper,
                                                                           RecipeType<RecipeHolder<D>> recipeType,
                                                                           FluidEntry<?> fluidEntry,
                                                                           String id) {

        Fluid fluid1 = fluidEntry.get();
        Component title = Component.translatable("recipe.garnished." + id);
        IDrawable background = new EmptyBackground(178, 72);
        IDrawable icon = new DoubleItemIcon(
                AllItems.PROPELLER::asStack,
                () -> new ItemStack(fluidEntry.get().getBucket())
        );
        Supplier<ItemStack> catalystStackSupplier = AllBlocks.ENCASED_FAN::asStack;
        Info<D> info = new Info<>(
                recipeType,
                title,
                background,
                icon,
                () -> getAllRecipes(type),
                List.of(catalystStackSupplier)
        );
        return new DyeBlowingFanCategory<>(fluid1, info);
    }

    private static <D extends DyeBlowingFanRecipe> List<RecipeHolder<D>> getAllRecipes(net.minecraft.world.item.crafting.RecipeType<D> type) {
        return GarnishedJEI.getRecipeManager().getAllRecipesFor(type);
    }
}
