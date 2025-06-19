package net.dakotapride.creategarnished.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;

public class RoyalCiderItem extends Item {
    public RoyalCiderItem(Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.8F)
                        .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3 * 60 * 20, 0, false, true, false), 1.0F)
                        .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 60 * 20, 0, false, false, false), 1.0F)
                        .effect(() -> new MobEffectInstance(MobEffects.LUCK, 3 * 60 * 20, 0, false, false, false), 1.0F)
                .usingConvertsTo(Items.GLASS_BOTTLE).build()));
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
