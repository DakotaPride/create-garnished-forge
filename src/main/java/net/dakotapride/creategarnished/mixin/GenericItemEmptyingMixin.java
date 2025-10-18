package net.dakotapride.creategarnished.mixin;

import com.simibubi.create.content.fluids.transfer.GenericItemEmptying;
import net.createmod.catnip.data.Pair;
import net.dakotapride.creategarnished.item.CandyWrapperUtils;
import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = GenericItemEmptying.class, remap = false)
public class GenericItemEmptyingMixin {

    @Inject(method = "canItemBeEmptied", at = @At("HEAD"), cancellable = true)
    private static void canItemBeEmptied(Level world, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getItem() == CreateGarnishedItems.WRAPPED_CANDY.asItem() && stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).hasEffects())
            cir.setReturnValue(true);
    }

    @Inject(method = "emptyItem", at = @At("HEAD"), cancellable = true)
    private static void emptyItem(Level world, ItemStack stack, boolean simulate, CallbackInfoReturnable<Pair<FluidStack, ItemStack>> cir) {
        if (stack.getItem() == CreateGarnishedItems.WRAPPED_CANDY.asItem())
            cir.setReturnValue(CandyWrapperUtils.empty(stack, simulate));
    }

}
