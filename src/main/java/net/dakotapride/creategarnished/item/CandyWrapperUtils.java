package net.dakotapride.creategarnished.item;

import com.simibubi.create.AllDataComponents;
import com.simibubi.create.AllFluids;
import com.simibubi.create.content.fluids.potion.PotionFluid;
import net.createmod.catnip.data.Pair;
import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;

public class CandyWrapperUtils {

    public static ItemStack fill(FluidStack availableFluid, ItemStack stack) {
        ItemStack potionStack = new ItemStack(CreateGarnishedItems.WRAPPED_CANDY.asItem());
        potionStack.set(DataComponents.POTION_CONTENTS, availableFluid.get(DataComponents.POTION_CONTENTS));
        potionStack.set(DataComponents.DYED_COLOR, stack.get(DataComponents.DYED_COLOR));
        return potionStack;
    }

    public static boolean canFillInternally(FluidStack availableFluid) {
        Fluid fluid = availableFluid.getFluid();
        if (fluid.isSame(Fluids.WATER))
            return true;
        if (fluid.isSame(AllFluids.POTION.get()))
            return true;
        return false;
    }

    public static Pair<FluidStack, ItemStack> empty(ItemStack stack, boolean simulate) {
        FluidStack fluid = getFluidFromPotionItem(stack);
        ItemStack stack0 = new ItemStack(CreateGarnishedItems.WRAPPED_CANDY.asItem());
        stack0.set(DataComponents.DYED_COLOR, stack.get(DataComponents.DYED_COLOR));
        if (!simulate)
            stack.shrink(1);
        return Pair.of(fluid, stack0);
    }

    public static FluidStack getFluidFromPotionItem(ItemStack stack) {
        PotionContents potion = stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        if (potion.is(Potions.WATER) && potion.customEffects().isEmpty() )
            return new FluidStack(Fluids.WATER, 250);
        FluidStack fluid = getFluidFromPotion(potion, 250);
        fluid.set(AllDataComponents.POTION_FLUID_BOTTLE_TYPE, PotionFluid.BottleType.REGULAR);
        return fluid;
    }

    public static FluidStack getFluidFromPotion(PotionContents potionContents, int amount) {
        if (potionContents.is(Potions.WATER))
            return new FluidStack(Fluids.WATER, amount);
        return PotionFluid.of(amount, potionContents, PotionFluid.BottleType.REGULAR);
    }

    public static ItemStack createItemStack(Item item, Holder<Potion> potion, ItemStack stack) {
        ItemStack itemstack = new ItemStack(item);
        itemstack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion));
        itemstack.set(DataComponents.DYED_COLOR, stack.get(DataComponents.DYED_COLOR));
        return itemstack;
    }
}
