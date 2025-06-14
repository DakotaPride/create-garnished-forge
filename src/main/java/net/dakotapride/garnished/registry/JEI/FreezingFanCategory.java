package net.dakotapride.garnished.registry.JEI;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.DoubleItemIcon;
import com.simibubi.create.compat.jei.EmptyBackground;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.tterrag.registrate.util.entry.FluidEntry;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.recipe.DyeBlowingFanRecipe;
import net.dakotapride.garnished.recipe.FreezingFanRecipe;
import net.dakotapride.garnished.registry.recipe.GarnishedRecipeTypes;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class FreezingFanCategory extends ProcessingViaFanCategory.MultiOutput<FreezingFanRecipe> {
    public FreezingFanCategory(Info<FreezingFanRecipe> info) {
        super(info);
    }

    @Override
    protected void renderAttachedBlock(@NotNull GuiGraphics graphics) {
        GuiGameElement.of(Blocks.POWDER_SNOW.defaultBlockState())
                .scale(SCALE)
                .atLocal(0, 0, 2)
                .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
                .render(graphics);
    }

    public static final RecipeType<RecipeHolder<FreezingFanRecipe>> TYPE =
            RecipeType.createRecipeHolderType(CreateGarnished.asResource("freezing"));

    public static FreezingFanCategory create(IGuiHelper guiHelper) {
        Component title = Component.translatable("recipe.garnished.fan_freezing");
        IDrawable background = new EmptyBackground(178, 72);
        IDrawable icon = new DoubleItemIcon(
                AllItems.PROPELLER::asStack,
                () -> new ItemStack(Items.POWDER_SNOW_BUCKET)
        );
        Supplier<ItemStack> catalystStackSupplier = AllBlocks.ENCASED_FAN::asStack;
        Info<FreezingFanRecipe> info = new Info<>(
                TYPE,
                title,
                background,
                icon,
                FreezingFanCategory::getAllRecipes,
                List.of(catalystStackSupplier)
        );
        return new FreezingFanCategory(info);
    }

    private static List<RecipeHolder<FreezingFanRecipe>> getAllRecipes() {
        return GarnishedJEI.getRecipeManager().getAllRecipesFor(GarnishedRecipeTypes.FREEZING.getType());
    }

}
