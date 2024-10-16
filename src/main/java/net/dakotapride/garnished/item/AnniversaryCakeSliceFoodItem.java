package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class AnniversaryCakeSliceFoodItem extends FarmersDelightItem implements IGarnishedUtilities{
    public AnniversaryCakeSliceFoodItem(Properties properties) {
        super(properties.food(GarnishedFoodValues.ANNIVERSARY_CAKE_SLICE));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level world, @NotNull LivingEntity entity) {
        Player playerentity = entity instanceof Player ? (Player) entity : null;
        if (playerentity instanceof ServerPlayer)
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) playerentity, stack);

        if (!world.isClientSide)
            entity.addEffect(triggerConditionalEffect(0, 1.0F));

        return super.finishUsingItem(stack, world, entity);
    }
}
