package net.dakotapride.creategarnished.mixin;

import com.simibubi.create.content.fluids.potion.PotionFluidHandler;
import com.simibubi.create.content.fluids.transfer.GenericItemFilling;
import com.simibubi.create.foundation.fluid.FluidHelper;
import net.dakotapride.creategarnished.item.CandyWrapperUtils;
import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.neoforged.neoforge.fluids.capability.wrappers.FluidBucketWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = GenericItemFilling.class, remap = false)
public class GenericItemFillingMixin {

    @Inject(method = "canItemBeFilled", at = @At("HEAD"), cancellable = true)
    private static void canItemBeFilled(Level world, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getItem() == CreateGarnishedItems.WRAPPED_CANDY.asItem() && !stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).hasEffects())
            cir.setReturnValue(true);
    }

    @Inject(method = "getRequiredAmountForItem", at = @At("HEAD"), cancellable = true)
    private static void getRequiredAmountForItem(Level world, ItemStack stack, FluidStack availableFluid, CallbackInfoReturnable<Integer> cir) {
        if (stack.getItem() == CreateGarnishedItems.WRAPPED_CANDY.asItem() && CandyWrapperUtils.canFillInternally(availableFluid))
            cir.setReturnValue(250);
    }

    @Inject(method = "fillItem", at = @At("HEAD"), cancellable = true)
    private static void fillItem(Level world, int requiredAmount, ItemStack stack, FluidStack availableFluid, CallbackInfoReturnable<ItemStack> cir) {
        if (stack.getItem() == CreateGarnishedItems.WRAPPED_CANDY.asItem()) {
            FluidStack toFill = availableFluid.copy();
            toFill.setAmount(requiredAmount);
            availableFluid.shrink(requiredAmount);

            if (CandyWrapperUtils.canFillInternally(toFill)) {
                ItemStack fillBottle;
                Fluid fluid = toFill.getFluid();
                if (FluidHelper.isWater(fluid))
                    fillBottle = CandyWrapperUtils.createItemStack(CreateGarnishedItems.WRAPPED_CANDY.asItem(), Potions.WATER, stack);
                else
                    fillBottle = CandyWrapperUtils.fill(toFill, stack);
                stack.shrink(1);
                cir.setReturnValue(fillBottle);
            }
        }
    }

}
