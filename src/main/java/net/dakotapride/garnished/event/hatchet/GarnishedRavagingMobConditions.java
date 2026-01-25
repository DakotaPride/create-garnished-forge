package net.dakotapride.garnished.event.hatchet;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.GAME)
public class GarnishedRavagingMobConditions extends MobConditions {
    public GarnishedRavagingMobConditions() {}

    @SubscribeEvent
    private static void addDropsUponDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();

        if (source.getEntity() != null && source.getEntity() instanceof LivingEntity attacker && MobConditions.accept(attacker)) {
            applyConditions(entity, attacker);
        }
    }

    public static void applyConditions(LivingEntity entity, LivingEntity attacker) {
        createBlazeDropConditions(entity, attacker);
        createCaveSpiderDropConditions(entity, attacker);
        createSpiderDropConditions(entity, attacker);
        createDolphinDropConditions(entity, attacker);
        createEnderDragonDropConditions(entity, attacker);
        createEndermanDropConditions(entity, attacker);
        createEndermiteDropConditions(entity, attacker);
        createGhastDropConditions(entity, attacker);
        createHoglinDropConditions(entity, attacker);
        createMagmaCubeDropConditions(entity, attacker);
        createPiglinDropConditions(entity, attacker);
        createPolarBearDropConditions(entity, attacker);
        createRavagerDropConditions(entity, attacker);
        createShulkerDropConditions(entity, attacker);
        createSkeletonDropConditions(entity, attacker);
        createSlimeDropConditions(entity, attacker);
        createSnifferDropConditions(entity, attacker);
        createVexDropConditions(entity, attacker);
        createWardenDropConditions(entity, attacker);
        createPillagerDropConditions(entity, attacker);

    }

    private static void createBlazeDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.BLAZE, attacker, GarnishedItems.ENFLAMED_MANDIBLE.get(), 1, 6.25F);
        if (fitWithinBounds(50))
            createBasicRavagingDropConditions(entity, EntityType.BLAZE, attacker, Items.BLAZE_POWDER, 2, 10.0F);
        else createBasicRavagingDropConditions(entity, EntityType.BLAZE, attacker, Items.BLAZE_ROD, 3, 16.66F);
    }

    private static void createCaveSpiderDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.CAVE_SPIDER, attacker, Items.FERMENTED_SPIDER_EYE, 2, 16.66F);
        if (fitWithinBounds(25, 45))
            createBasicRavagingDropConditions(entity, EntityType.CAVE_SPIDER, attacker, Items.STRING, 2, 16.66F);
        else createBasicRavagingDropConditions(entity, EntityType.CAVE_SPIDER, attacker, Items.SPIDER_EYE, 2, 16.66F);
    }

    private static void createDolphinDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.DOLPHIN, attacker, Items.HEART_OF_THE_SEA, 1, 6.25F);
    }

    private static void createEnderDragonDropConditions(LivingEntity entity, LivingEntity attacker) {
        createRavagingDropConditions(entity, EntityType.ENDER_DRAGON, attacker, GarnishedItems.DIMMED_SCALE.get(), 3, 7, 100.0F);
    }

    private static void createEndermanDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.ENDERMAN, attacker, GarnishedItems.DIMMED_SCALE.get(), 3, 16.66F);
        createBasicRavagingDropConditions(entity, EntityType.ENDERMAN, attacker, GarnishedItems.CRUSHED_ENDER_PEARL.get(), 2, 25.0F);
    }

    private static void createEndermiteDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.ENDERMITE, attacker, GarnishedItems.DIMMED_SCALE.get(), 1, 6.25F);
        createBasicRavagingDropConditions(entity, EntityType.ENDERMITE, attacker, GarnishedItems.PRELIMINARY_NUCLEUS.get(), 1, 100.0F);
    }

    private static void createGhastDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.GHAST, attacker, GarnishedItems.GHAST_TENDRIL.get(),3,12.5F);
        if (fitWithinBounds(50))
            createBasicRavagingDropConditions(entity, EntityType.GHAST, attacker, Items.GHAST_TEAR, 2, 8.3F);
        else createBasicRavagingDropConditions(entity, EntityType.GHAST, attacker, Items.GUNPOWDER, 3, 12.5F);
    }

    private static void createHoglinDropConditions(LivingEntity entity, LivingEntity attacker) {
        if (fitWithinBounds(50)) {
            createBasicRavagingDropConditions(entity, EntityType.HOGLIN, attacker, GarnishedItems.TUSK.get(), 2, 100.0F);
            createBasicRavagingDropConditions(entity, EntityType.ZOGLIN, attacker, GarnishedItems.TUSK.get(), 1, 100.0F);
        } else {
            createBasicRavagingDropConditions(entity, EntityType.HOGLIN, attacker, GarnishedItems.IRATE_TUSK.get(), 1, 25.0F);
            createBasicRavagingDropConditions(entity, EntityType.ZOGLIN, attacker, GarnishedItems.IRATE_TUSK.get(), 1, 25.0F);
        }
    }

    private static void createMagmaCubeDropConditions(LivingEntity entity, LivingEntity attacker) {
        if (fitWithinBounds(33))
            createBasicRavagingDropConditions(entity, EntityType.MAGMA_CUBE, attacker, Items.OCHRE_FROGLIGHT, 1, 6.25F);
        else if (fitWithinBounds(33))
            createBasicRavagingDropConditions(entity, EntityType.MAGMA_CUBE, attacker, Items.VERDANT_FROGLIGHT, 1, 6.25F);
        else if (fitWithinBounds(33))
            createBasicRavagingDropConditions(entity, EntityType.MAGMA_CUBE, attacker, Items.PEARLESCENT_FROGLIGHT, 1, 6.25F);

        if (fitWithinBounds(50))
            createBasicRavagingDropConditions(entity, EntityType.MAGMA_CUBE, attacker, Items.MAGMA_CREAM, 3, 12.5F);
        else createBasicSalvagingDropConditions(entity, EntityType.MAGMA_CUBE, attacker, GarnishedItems.MOLTEN_REMNANT.get(), 2, 8.3F);
    }

    private static void createPiglinDropConditions(LivingEntity entity, LivingEntity attacker) {
        if (fitWithinBounds(10, 60)) {
            createBasicRavagingDropConditions(entity, EntityType.PIGLIN, attacker, Items.GOLD_INGOT, 2, 6.25F);
            createBasicRavagingDropConditions(entity, EntityType.ZOMBIFIED_PIGLIN, attacker, Items.GOLD_INGOT, 2, 6.25F);
        } else {
            createRavagingDropConditions(entity, EntityType.PIGLIN, attacker, Items.GOLD_NUGGET, 2, 6, 16.66F);
            createRavagingDropConditions(entity, EntityType.ZOMBIFIED_PIGLIN, attacker, Items.GOLD_NUGGET, 2, 6, 16.66F);
        }
        createRavagingDropConditions(entity, EntityType.ZOMBIFIED_PIGLIN, attacker, Items.ROTTEN_FLESH, 2, 3, 33.33F);
    }

    private static void createPolarBearDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.POLAR_BEAR, attacker, GarnishedItems.RAW_POLAR_BEAR_MEAT.get(), 3, 50.0F);
        createBasicRavagingDropConditions(entity, EntityType.POLAR_BEAR, attacker, GarnishedItems.POLAR_BEAR_HIDE.get(), 4, 25.0F);
    }

    private static void createRavagerDropConditions(LivingEntity entity, LivingEntity attacker) {
        createRavagingDropConditions(entity, EntityType.RAVAGER, attacker, GarnishedItems.MEAT_SCRAPS.get(), 2, 5, 16.66F);
    }

    private static void createShulkerDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.SHULKER, attacker, Items.SHULKER_SHELL,3, 33.33F);
    }

    private static void createSkeletonDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.SKELETON, attacker, Items.ARROW, 3, 16.66F);
        createBasicRavagingDropConditions(entity, EntityType.STRAY, attacker, Items.ARROW, 3, 16.66F);
        createBasicRavagingDropConditions(entity, EntityType.SKELETON, attacker, Items.BONE, 4, 16.66F);
        createBasicRavagingDropConditions(entity, EntityType.STRAY, attacker, Items.BONE, 4, 16.66F);
        createBasicRavagingDropConditions(entity, EntityType.SKELETON_HORSE, attacker, Items.BONE, 4, 25.0F);
        createBasicRavagingDropConditions(entity, EntityType.STRAY, attacker, GarnishedItems.NUMBING_PARCHMENT.get(), 4, 16.66F);
    }

    private static void createSlimeDropConditions(LivingEntity entity, LivingEntity attacker) {
        createRavagingDropConditions(entity, EntityType.SLIME, attacker, Items.SLIME_BALL, 2, 4, 16.66F);
    }

    private static void createSnifferDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.SNIFFER, attacker, Items.LEATHER, 3,25.0F);
    }

    private static void createSpiderDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.SPIDER, attacker, Items.FERMENTED_SPIDER_EYE, 2, 6.25F);
        if (fitWithinBounds(25, 45))
            createBasicRavagingDropConditions(entity, EntityType.SPIDER, attacker, Items.STRING, 2, 16.66F);
        else createBasicRavagingDropConditions(entity, EntityType.SPIDER, attacker, Items.SPIDER_EYE, 2, 16.66F);
    }

    private static void createVexDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.VEX, attacker, GarnishedItems.VEX_WING.get(), 2, 25.0F);
    }

    private static void createWardenDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.WARDEN, attacker, GarnishedItems.RAW_TENEBROUS_MEAT.get(), 6, 100.0F);
    }

    private static void createPillagerDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicRavagingDropConditions(entity, EntityType.EVOKER, attacker, Items.EMERALD, 3,16.66F);
        createBasicRavagingDropConditions(entity, EntityType.ILLUSIONER, attacker, Items.EMERALD, 3,16.66F);
        createBasicRavagingDropConditions(entity, EntityType.PILLAGER, attacker, Items.EMERALD, 3,16.66F);
        createBasicRavagingDropConditions(entity, EntityType.VINDICATOR, attacker, Items.EMERALD, 3,16.66F);
    }
}