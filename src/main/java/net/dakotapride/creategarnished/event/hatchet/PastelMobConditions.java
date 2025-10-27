package net.dakotapride.creategarnished.event.hatchet;

import earth.terrarium.pastel.entity.PastelEntityTypes;
import earth.terrarium.pastel.entity.entity.EggLayingWoolyPigEntity;
import earth.terrarium.pastel.registries.PastelItems;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.util.ModIds;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import reliquary.init.ModItems;

import java.util.List;

public class PastelMobConditions extends MobConditions {
    public PastelMobConditions() {}


    public static void applyConditions(LivingEntity entity, LivingEntity attacker, DamageSource source) {
        createPastelDropConditions(entity, PastelEntityTypes.EGG_LAYING_WOOLY_PIG.get(), attacker, Items.WHITE_WOOL, 2, 75, source);
        createPastelDropConditions(entity, PastelEntityTypes.EGG_LAYING_WOOLY_PIG.get(), attacker, Items.LEATHER, 2, 75, source);
        if (entity instanceof EggLayingWoolyPigEntity) {
            if (entity.isOnFire())
                createPastelDropConditions(entity, PastelEntityTypes.EGG_LAYING_WOOLY_PIG.get(), attacker, Items.COOKED_PORKCHOP, 2, 50, source);
            else createPastelDropConditions(entity, PastelEntityTypes.EGG_LAYING_WOOLY_PIG.get(), attacker, Items.PORKCHOP, 2, 50, source);
        }
        createPastelDropConditions(entity, PastelEntityTypes.KINDLING.get(), attacker, PastelItems.DRAGONBONE_CHUNK.get(), 1, 25, source);
        createPastelDropConditions(entity, PastelEntityTypes.LIZARD.get(), attacker, PastelItems.LIZARD_MEAT.get(), 2, 50, source);
        createPastelDropConditions(entity, PastelEntityTypes.LIZARD.get(), attacker, Items.RABBIT_HIDE, 3, 45, source);
        createPastelDropConditions(entity, PastelEntityTypes.LIZARD.get(), attacker, Items.LEATHER, 1, 15, source);
    }

    @EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.GAME)
    static class PastelConditionsEvent {
        @SubscribeEvent
        private static void createPastelConditions(LivingDeathEvent event) {
            LivingEntity entity = event.getEntity();
            DamageSource source = event.getSource();

            if (source.getEntity() != null && source.getEntity() instanceof LivingEntity attacker && MobConditions.accept(attacker)) {
                if (ModIds.PASTEL.isLoaded())
                    applyConditions(entity, attacker, source);
            }
        }
    }

    public static void createPastelDropConditions(LivingEntity entity, EntityType<?> entityType, LivingEntity attacker, Item item, int maxCount, int chance, DamageSource source) {
        createDropConditions(entity, entityType, attacker, item, maxCount, chance, source, ModIds.PASTEL.isLoaded());
    }
}
