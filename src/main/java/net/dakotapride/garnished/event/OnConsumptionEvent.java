package net.dakotapride.garnished.event;

import net.dakotapride.garnished.registry.GarnishedEffects;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class OnConsumptionEvent {

    @SubscribeEvent
    public static void finishUsingItem(LivingEntityUseItemEvent.Finish event) {
        LivingEntity entity = event.getEntity();
        ItemStack activeItem = entity.getUseItem();

        if (entity.hasEffect(GarnishedEffects.AVERSION.get()) && activeItem.is(GarnishedTags.AVERSION_FOODS_TAG)) {
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400, 2));
        }
    }
}
