package net.dakotapride.creategarnished.event;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.registry.CreateGarnishedDamageSources;
import net.dakotapride.creategarnished.registry.CreateGarnishedStatusEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

@EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.GAME)
public class AttackWhileInflictedWithVoltStruckEvent {

    @SubscribeEvent
    public static void spreadVolts(AttackEntityEvent event) {
        LivingEntity entity = event.getEntity();
        Entity target = event.getTarget();

        if (entity.hasEffect(CreateGarnishedStatusEffects.VOLT_STRUCK) && target instanceof LivingEntity livingTarget) {
            livingTarget.hurt(CreateGarnishedDamageSources.shock(entity.level()), 2);
            if (!entity.level().isClientSide)
                livingTarget.addEffect(new MobEffectInstance(CreateGarnishedStatusEffects.VOLT_STRUCK, 14*20, 0));
        }
    }

}
