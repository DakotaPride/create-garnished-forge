package net.dakotapride.creategarnished.event;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.registry.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.List;

@EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.GAME)
public class NutAllergyEvents {

    @SubscribeEvent
    public static void applyNutAllergyFromFluid(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();
        BlockPos pos = entity.blockPosition();
        FluidState fluidState = entity.level().getFluidState(pos);

        if (CreateGarnishedConfigs.server().entity.enableNutAllergy.get())
            if (entity instanceof LivingEntity living && !living.hasEffect(CreateGarnishedStatusEffects.NUT_ALLERGY)) {
                if (fluidState.is(CreateGarnishedTags.APPLIES_NUT_ALLERGY))
                    living.addEffect(new MobEffectInstance(CreateGarnishedStatusEffects.NUT_ALLERGY, 2400, 0, false, false, false));
            }

    }

    @SubscribeEvent
    public static void applyNutAllergyConsequences(LivingEntityUseItemEvent.Finish event) {
        LivingEntity entity = event.getEntity();
        ItemStack stack = event.getItem();

        if (stack.is(CreateGarnishedTags.CAUSES_NUT_ALLERGY_CONSEQUENCES) && entity.hasEffect(CreateGarnishedStatusEffects.NUT_ALLERGY)) {
            entity.hurt(CreateGarnishedDamageSources.nutAllergy(entity.level()), CreateGarnishedConfigs.server().entity.nutAllergyDamageAmount.get().floatValue());
        }
    }

}
