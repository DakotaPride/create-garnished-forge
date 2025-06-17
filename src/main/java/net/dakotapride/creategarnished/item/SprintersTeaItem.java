package net.dakotapride.creategarnished.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;

public class SprintersTeaItem extends Item {

    public SprintersTeaItem(Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.6F)
                        .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3 * 60 * 20, 0, false, false, false), 1.0F)
                .usingConvertsTo(Items.GLASS_BOTTLE).alwaysEdible().build()));
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 42;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

}
