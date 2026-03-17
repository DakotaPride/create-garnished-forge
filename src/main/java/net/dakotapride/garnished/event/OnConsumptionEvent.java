package net.dakotapride.garnished.event;

import net.dakotapride.garnished.GarnishedConfigs;
import net.dakotapride.garnished.item.ConditionalEffectItem;
import net.dakotapride.garnished.registry.GarnishedDamageSource;
import net.dakotapride.garnished.registry.GarnishedEffects;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

@EventBusSubscriber
public class OnConsumptionEvent {

    @SubscribeEvent
    private static void finishUsingItem(LivingEntityUseItemEvent.Finish event) {
        LivingEntity entity = event.getEntity();
        ItemStack activeItem = entity.getUseItem();
        Level level = entity.level();

        if (entity.hasEffect(GarnishedEffects.AVERSION) && activeItem.is(GarnishedTags.AVERSION_FOODS_TAG)) {
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400, 2));
        }

        if (activeItem.is(GarnishedItems.MULCH.get())) {
            entity.hurt(level.damageSources().source(GarnishedDamageSource.MULCH_MUNCHING), 2.0F);
        }

        if (activeItem.is(GarnishedItems.MUD_PIE.get())) {
            entity.hurt(level.damageSources().source(GarnishedDamageSource.MULCH_MUNCHING), 1.0F);
        }


        if (GarnishedConfigs.server().item.conditionalEffectsUponConsumption.get()
                && activeItem.getItem() instanceof ConditionalEffectItem conditionalEffectItem)
            conditionalEffectItem.triggerConditionalEffect(conditionalEffectItem.getValue(), conditionalEffectItem.getChance(), entity);
    }
}
