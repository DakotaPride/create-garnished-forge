package net.dakotapride.creategarnished.item;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class PeanutButterBottleItem extends Item {
    public PeanutButterBottleItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemStack, Level level, @NotNull LivingEntity livingEntity) {
        if (!level.isClientSide) {
            List<MobEffect> effects = BuiltInRegistries.MOB_EFFECT.stream()
                    .filter(effect -> effect.getCategory() == MobEffectCategory.HARMFUL).toList();
            int f = new Random().nextInt(effects.size());

            livingEntity.addEffect(new MobEffectInstance(Holder.direct(effects.get(f)), 1200, 4));
        }

        return super.finishUsingItem(itemStack, level, livingEntity);
    }
}
