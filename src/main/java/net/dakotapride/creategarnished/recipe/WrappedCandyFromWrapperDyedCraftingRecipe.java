package net.dakotapride.creategarnished.recipe;

import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class WrappedCandyFromWrapperDyedCraftingRecipe extends CustomRecipe {
    public WrappedCandyFromWrapperDyedCraftingRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;

        for(int i = 0; i < input.size(); ++i) {
            ItemStack itemstack = input.getItem(i);
            if (!itemstack.isEmpty()) {
                if (itemstack.is(Items.SUGAR) && !flag2) {
                    flag2 = true;
                } else if (itemstack.is(CreateGarnishedItems.CORN_SYRUP_BOTTLE) && !flag1) {
                    flag1 = true;
                } else  {
                    if ((!itemstack.is(CreateGarnishedItems.CANDY_WRAPPING) || flag)) {
                        return false;
                    }

                    flag = true;
                }
            }
        }

        return flag && flag1 && flag2;
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        ItemStack itemstack = new ItemStack(CreateGarnishedItems.WRAPPED_CANDY.asItem(), 1);

        for(int i = 0; i < input.size(); ++i) {
            ItemStack itemstack1 = input.getItem(i);
            if (!itemstack1.isEmpty()) {
                if (itemstack1.has(DataComponents.DYED_COLOR)) {
                    itemstack.set(DataComponents.DYED_COLOR, itemstack1.get(DataComponents.DYED_COLOR));
                    break;
                }
            }
        }

        return itemstack;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= 2 && height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CreateGarnishedRecipeSerializers.WRAPPED_CANDY_FROM_WRAPPER_DYED_CRAFTING.get();
    }
}
