package net.dakotapride.creategarnished.event;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.registry.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.player.UseItemOnBlockEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.List;

@EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.GAME)
public class NutAllergyEvents {

    @SubscribeEvent
    public static void applyNutAllergyFromFluid(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();

        List<FluidType> list = List.of(
                CreateGarnishedFluids.ALMOND_EXTRACT.getType(),
                CreateGarnishedFluids.PEANUT_BUTTER.getType()
        );

        if (CreateGarnishedConfigs.server().entity.enableNutAllergy.get())
            if (entity instanceof LivingEntity living && !living.hasEffect(CreateGarnishedStatusEffects.NUT_ALLERGY)) {
                list.forEach(p -> {
                    if (living.isInFluidType(p))
                        living.addEffect(new MobEffectInstance(CreateGarnishedStatusEffects.NUT_ALLERGY, 2400, 0, false, true, false));
                });
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
