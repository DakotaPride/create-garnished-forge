package net.dakotapride.creategarnished.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ChurchkhelaFoodItem extends Item {
    public ChurchkhelaFoodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        if (!level.isClientSide) {
            PrimedTnt primedtnt = new PrimedTnt(level, (double)livingEntity.blockPosition().getX() + 0.5D, livingEntity.blockPosition().getY(), (double)livingEntity.blockPosition().getZ() + 0.5D, livingEntity);
            int i = primedtnt.getFuse();
            primedtnt.setFuse((short)(level.random.nextInt(i / 4) + i / 2));
            level.addFreshEntity(primedtnt);
        }

        return super.finishUsingItem(stack, level, livingEntity);
    }
}
