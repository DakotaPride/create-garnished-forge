package net.dakotapride.creategarnished.util;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

import java.util.List;

public class CustomSuspiciousStewTradeOptions extends MerchantOffer {
        private static SuspiciousStewEffects effects;

        public CustomSuspiciousStewTradeOptions(ItemStack result, Holder<MobEffect> effect) {
            this(result, 1, 10, 0.2F, effect, 200);
        }

        public CustomSuspiciousStewTradeOptions(ItemStack result, int maxUses, int xp, float priceMultiplier, Holder<MobEffect> effect, int duration) {
            this(new SuspiciousStewEffects(List.of(new SuspiciousStewEffects.Entry(effect, duration))), new ItemCost(Items.EMERALD, 16), result, maxUses, xp, priceMultiplier);
        }

        public CustomSuspiciousStewTradeOptions(SuspiciousStewEffects effects, ItemCost cost, ItemStack result, int maxUses, int xp, float priceMultiplier) {
            super(cost, result, maxUses, xp, priceMultiplier);
            this.effects = effects;
        }

        public static ItemStack getSuspiciousStewForTradeOffer() {
            ItemStack itemstack = new ItemStack(Items.SUSPICIOUS_STEW, 1);
            itemstack.set(DataComponents.SUSPICIOUS_STEW_EFFECTS, effects);
            return itemstack;
        }
    }