package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Random;

public class EggnogItem extends Item {
    public EggnogItem(Properties properties) {
        super(properties.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.6F).usingConvertsTo(Items.GLASS_BOTTLE).build()));
    }

    // Should remove a random status effect applied to the player, either positive, negative, or neutral
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        List<MobEffectInstance> effectsList = livingEntity.getActiveEffects().stream().toList();

        Random random = new Random();
        int f = random.nextInt(effectsList.size());

        if (!level.isClientSide()) {
            livingEntity.removeEffect(effectsList.get(f).getEffect());
        }


        return super.finishUsingItem(stack, level, livingEntity);
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
