package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.CreateGarnishedSounds;
import net.dakotapride.creategarnished.registry.CreateGarnishedTags;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class WrappedCandyItem extends Item {
    public WrappedCandyItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull Component getName(ItemStack stack) {
        return Component.translatable("item.creategarnished.wrapped_candy");
    }

    @Override
    public @NotNull SoundEvent getEatingSound() {
        return CreateGarnishedSounds.CANDY_WRAPPER_WRINKLES.get();
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {}

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player) livingEntity : null;

        if (!level.isClientSide) {
            int random = new Random().nextInt(BuiltInRegistries.MOB_EFFECT.size());


            if (BuiltInRegistries.MOB_EFFECT.getHolder(random).isPresent()
                    && BuiltInRegistries.MOB_EFFECT.getHolder(random).get().is(CreateGarnishedTags.BLACKLISTED_FROM_APPLICATION)) {
                random = new Random().nextInt(BuiltInRegistries.MOB_EFFECT.size());
                //CreateGarnished.LOGGER.info("Effect was rerolled, as it was blacklisted");
            }

            if (!itemStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).hasEffects())
                livingEntity.addEffect(new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.getHolder(random).orElseThrow(), 140, 2));
            else {
                PotionContents potionContents = itemStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
                potionContents.forEachEffect(mobEffectInstance -> {
                    if (mobEffectInstance.getEffect().value().isInstantenous()) {
                        mobEffectInstance.getEffect().value().applyInstantenousEffect(player, player, livingEntity, 2, 1.0);
                    } else {
                        livingEntity.addEffect(new MobEffectInstance(mobEffectInstance.getEffect(), mobEffectInstance.getDuration(), mobEffectInstance.getAmplifier()));
                    }
                });
            }
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }

}