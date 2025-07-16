package net.dakotapride.creategarnished.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GarlicBreadItem extends Item {
    public GarlicBreadItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        super.finishUsingItem(stack, level, livingEntity);

        livingEntity.removeAllEffects();

        return super.finishUsingItem(stack, level, livingEntity);
    }
}
