package net.dakotapride.creategarnished.event.hatchet;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.util.ModIds;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import reliquary.init.ModItems;

public class ReliquaryReincarnationsMobConditions extends MobConditions {
    public ReliquaryReincarnationsMobConditions() {}


    public static void applyConditions(LivingEntity entity, LivingEntity attacker, DamageSource source) {
        createReliquaryReincarnationsDropConditions(entity, EntityType.ZOMBIE, attacker, ModItems.ZOMBIE_HEART.get(), 2, 25, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.PIGLIN, attacker, ModItems.ZOMBIE_HEART.get(), 2, 10, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.SQUID, attacker, ModItems.SQUID_BEAK.get(), 1, 50, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.SKELETON, attacker, ModItems.RIB_BONE.get(), 3, 40, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.STRAY, attacker, ModItems.RIB_BONE.get(), 3, 40, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.BOGGED, attacker, ModItems.RIB_BONE.get(), 3, 40, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.WITHER_SKELETON, attacker, ModItems.WITHERED_RIB.get(), 3, 40, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.CREEPER, attacker, ModItems.CATALYZING_GLAND.get(), 2, 35, source);
        if (entity instanceof Creeper creeper) {
            if (!creeper.isPowered())
                createReliquaryReincarnationsDropConditions(entity, EntityType.CREEPER, attacker, ModItems.CATALYZING_GLAND.get(), 2, 35, source);
            if (creeper.isPowered())
                createReliquaryReincarnationsDropConditions(entity, EntityType.CREEPER, attacker, ModItems.EYE_OF_THE_STORM.get(), 2, 5, source);
        }
        createReliquaryReincarnationsDropConditions(entity, EntityType.GHAST, attacker, ModItems.CATALYZING_GLAND.get(), 1, 50, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.SPIDER, attacker, ModItems.CHELICERAE.get(), 2, 60, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.CAVE_SPIDER, attacker, ModItems.CHELICERAE.get(), 2, 60, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.SLIME, attacker, ModItems.SLIME_PEARL.get(), 2, 15, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.BAT, attacker, ModItems.BAT_WING.get(), 2, 80, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.BLAZE, attacker, ModItems.MOLTEN_CORE.get(), 2, 40, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.MAGMA_CUBE, attacker, ModItems.MOLTEN_CORE.get(), 2, 60, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.SNOW_GOLEM, attacker, ModItems.FROZEN_CORE.get(), 2, 40, source);
        createReliquaryReincarnationsDropConditions(entity, EntityType.ENDERMAN, attacker, ModItems.NEBULOUS_HEART.get(), 2, 40, source);
        guardianReliquaryDrops(entity, attacker, source);
    }

    public static void guardianReliquaryDrops(LivingEntity entity, LivingEntity attacker, DamageSource source) {
        if (ModIds.RELIQUARY.isLoaded())
            createDropConditions(entity, EntityType.GUARDIAN, attacker, ModItems.GUARDIAN_SPIKE.get(), config.guardianSpikeMaxCount.get(),
                    config.chanceToDropGuardianSpike.get(), source, config.disableLesserGuardianDrops.get());
    }

    @EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.GAME)
    static class ReliquaryReincarnationsConditionsEvent {
        @SubscribeEvent
        private static void createReliquaryReincarnationsConditions(LivingDeathEvent event) {
            LivingEntity entity = event.getEntity();
            DamageSource source = event.getSource();

            if (source.getEntity() != null && source.getEntity() instanceof LivingEntity attacker && MobConditions.accept(attacker)) {
                if (ModIds.RELIQUARY.isLoaded())
                    applyConditions(entity, attacker, source);
            }
        }
    }

    public static void createReliquaryReincarnationsDropConditions(LivingEntity entity, EntityType<?> entityType, LivingEntity attacker, Item item, int maxCount, int chance, DamageSource source) {
        createDropConditions(entity, entityType, attacker, item, maxCount, chance, source, !ModIds.RELIQUARY.isLoaded());
    }
}
