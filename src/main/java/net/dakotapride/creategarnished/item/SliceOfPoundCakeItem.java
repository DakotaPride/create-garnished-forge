package net.dakotapride.creategarnished.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SliceOfPoundCakeItem extends Item {
    public SliceOfPoundCakeItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120 * 20, 99, false, false, false));
            player.displayClientMessage(Component.translatable("creategarnished.text.april_foods.pound_cake_slow_movement").withStyle(ChatFormatting.RED), true);
        }
        return super.finishUsingItem(stack, level, livingEntity);
    }
}
