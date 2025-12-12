package net.dakotapride.garnished.event;

import net.dakotapride.garnished.registry.GarnishedDamageSource;
import net.dakotapride.garnished.registry.GarnishedEffects;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

import java.util.Random;

@EventBusSubscriber
public class OnConsumptionEvent {
    public static TagKey<Item> ASSEMBLY_NUT_FOODS = GarnishedTags.garnishedTag("april_foods/assembly_nut_foods", Registries.ITEM);
    public static TagKey<Item> FILLING_NUT_FOODS = GarnishedTags.garnishedTag("april_foods/filling_nut_foods", Registries.ITEM);
    public static TagKey<Item> COMPACTING_NUT_FOODS = GarnishedTags.garnishedTag("april_foods/compacting_nut_foods", Registries.ITEM);
    public static TagKey<Item> MIXING_NUT_FOODS = GarnishedTags.garnishedTag("april_foods/mixing_nut_foods", Registries.ITEM);
    public static TagKey<Item> MINOR_CRAFTING_NUT_FOODS = GarnishedTags.garnishedTag("april_foods/minor_crafting_nut_foods", Registries.ITEM);
    public static TagKey<Item> OBVIOUS_NUT_FOODS = GarnishedTags.garnishedTag("april_foods/obvious_nut_foods", Registries.ITEM);
    public static TagKey<Item> NAMED_NUT_FOODS = GarnishedTags.garnishedTag("april_foods/named_nut_foods", Registries.ITEM);
    public static TagKey<Item> WARDEN_NUT_FOODS = GarnishedTags.garnishedTag("april_foods/warden_nut_foods", Registries.ITEM);

    private static Component mes(int r) {
        return Component.translatable("text.garnished.april_foods.aversion_reason." + r).withStyle(ChatFormatting.RED);
    }
    private static Component mes(String r) {
        return Component.translatable("text.garnished.april_foods.aversion_reason." + r).withStyle(ChatFormatting.RED);
    }

    @SubscribeEvent
    private static void finishUsingItem(LivingEntityUseItemEvent.Finish event) {
        LivingEntity entity = event.getEntity();
        ItemStack activeItem = entity.getUseItem();
        Level level = entity.level();


        // Dictate how often the secret message pops up
        Random random = new Random();
        int f = random.nextInt(1000);

        if (entity instanceof Player player && player.hasEffect(GarnishedEffects.AVERSION)) {
            if (f == 1) {
                player.displayClientMessage(mes("dork"), true);
            } else {
                if (activeItem.is(ASSEMBLY_NUT_FOODS)) {
                    player.displayClientMessage(mes(4), true);
                }
                if (activeItem.is(FILLING_NUT_FOODS)) {
                    player.displayClientMessage(mes(6), true);
                }
                if (activeItem.is(COMPACTING_NUT_FOODS)) {
                    player.displayClientMessage(mes(9), true);
                }
                if (activeItem.is(MIXING_NUT_FOODS)) {
                    player.displayClientMessage(mes(5), true);
                }
                if (activeItem.is(MINOR_CRAFTING_NUT_FOODS)) {
                    player.displayClientMessage(mes(2), true);
                }
                if (activeItem.is(OBVIOUS_NUT_FOODS)) {
                    player.displayClientMessage(mes(1), true);
                }
                if (activeItem.is(NAMED_NUT_FOODS)) {
                    player.displayClientMessage(mes(3), true);
                }
                if (activeItem.is(WARDEN_NUT_FOODS)) {
                    player.displayClientMessage(mes(8), true);
                }
                if (activeItem.is(GarnishedItems.NUTTY_MELODY)) {
                    player.displayClientMessage(mes(7), true);
                }
            }
        }



        if (entity.hasEffect(GarnishedEffects.AVERSION) && activeItem.is(GarnishedTags.AVERSION_FOODS_TAG)) {
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400, 2));
        }

        if (activeItem.is(GarnishedItems.MULCH.get())) {
            entity.hurt(level.damageSources().source(GarnishedDamageSource.MULCH_MUNCHING), 2.0F);
        }

        if (activeItem.is(GarnishedItems.MUD_PIE.get())) {
            entity.hurt(level.damageSources().source(GarnishedDamageSource.MULCH_MUNCHING), 1.0F);
        }
    }
}
