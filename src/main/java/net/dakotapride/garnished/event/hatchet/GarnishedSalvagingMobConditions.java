package net.dakotapride.garnished.event.hatchet;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.GAME)
public class GarnishedSalvagingMobConditions extends MobConditions {
    public GarnishedSalvagingMobConditions() {}

    @SubscribeEvent
    private static void addDropsUponDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();

        if (source.getEntity() != null && source.getEntity() instanceof LivingEntity attacker && MobConditions.accept(attacker)) {
            applyConditions(entity, attacker);
        }
    }

    public static void applyConditions(LivingEntity entity, LivingEntity attacker) {
        createAllayDropConditions(entity, attacker);
        createBeeDropConditions(entity, attacker);
        createCowDropConditions(entity, attacker);
        createDolphinDropConditions(entity, attacker);
        createFrogDropConditions(entity, attacker);
        createPigDropConditions(entity, attacker);
        createFishDropConditions(entity, attacker);
        createRabbitDropConditions(entity, attacker);
        createTurtleDropConditions(entity, attacker);
        createCatDropConditions(entity, attacker);
        createHorseDropConditions(entity, attacker);
        createSquidDropConditions(entity, attacker);
    }

    private static void createAllayDropConditions(LivingEntity entity, LivingEntity attacker) {
        createSalvagingDropConditions(entity, EntityType.ALLAY, attacker, GarnishedItems.VEX_WING.get(), 1, 1, 0.625F, 6.25F);
    }

    private static void createBeeDropConditions(LivingEntity entity, LivingEntity attacker) {
        createSalvagingDropConditions(entity, EntityType.BEE, attacker, Items.HONEYCOMB, 1, 1, 16.66F, 25.0F);
    }

    private static void createCowDropConditions(LivingEntity entity, LivingEntity attacker) {
        if (fitWithinBounds(25, 60))
            createSalvagingDropConditions(entity, EntityType.COW, attacker, Items.LEATHER, 1, 3, 16.66F, 25.0F);
        else createSalvagingDropConditions(entity, EntityType.COW, attacker, Items.BEEF, 1, 2, 25.0F, 33.33F);
    }

    private static void createDolphinDropConditions(LivingEntity entity, LivingEntity attacker) {
        createSalvagingDropConditions(entity, EntityType.DOLPHIN, attacker, GarnishedItems.LUSTROUS_PEARL.get(), 1, 1, 16.66F, 25.0F);
    }

    private static void createFrogDropConditions(LivingEntity entity, LivingEntity attacker) {
        createSalvagingDropConditions(entity, EntityType.FROG, attacker, Items.MAGMA_CREAM, 1, 3, 0.625F, 6.25F);
        createSalvagingDropConditions(entity, EntityType.FROG, attacker, GarnishedItems.MOLTEN_STEW.get(), 1, 2, 0.625F, 6.25F);
    }

    private static void createPigDropConditions(LivingEntity entity, LivingEntity attacker) {
        createSalvagingDropConditions(entity, EntityType.PIG, attacker, Items.PORKCHOP, 1, 3, 16.66F, 25.0F);
        createSalvagingDropConditions(entity, EntityType.PIG, attacker, GarnishedItems.TUSK.get(), 1, 1, 6.25F, 16.66F);
    }

    private static void createFishDropConditions(LivingEntity entity, LivingEntity attacker) {
        if (fitWithinBounds(50))
            createSalvagingDropConditions(entity, EntityType.PUFFERFISH, attacker, Items.PUFFERFISH, 1, 3, 5.0F, 12.5F);
        else createSalvagingDropConditions(entity, EntityType.PUFFERFISH, attacker, Items.BONE, 0, 1, 16.66F, 33.33F);

        if (fitWithinBounds(50))
            createSalvagingDropConditions(entity, EntityType.COD, attacker, Items.COD, 1, 3, 5.0F, 12.5F);
        else createSalvagingDropConditions(entity, EntityType.COD, attacker, Items.BONE, 0, 1, 16.66F, 33.33F);

        if (fitWithinBounds(50))
            createSalvagingDropConditions(entity, EntityType.SALMON, attacker, Items.SALMON, 1, 3, 5.0F, 12.5F);
        else createSalvagingDropConditions(entity, EntityType.SALMON, attacker, Items.BONE, 0, 1, 16.66F, 33.33F);

        if (fitWithinBounds(50))
            createSalvagingDropConditions(entity, EntityType.TROPICAL_FISH, attacker, Items.TROPICAL_FISH, 1, 3, 5.0F, 12.5F);
        else createSalvagingDropConditions(entity, EntityType.TROPICAL_FISH, attacker, Items.BONE, 0, 1, 16.66F, 33.33F);
    }

    private static void createRabbitDropConditions(LivingEntity entity, LivingEntity attacker) {
        createSalvagingDropConditions(entity, EntityType.RABBIT, attacker, Items.RABBIT_HIDE, 1, 3, 16.66F, 25.0F);
    }

    private static void createTurtleDropConditions(LivingEntity entity, LivingEntity attacker) {
        createBasicSalvagingDropConditions(entity, EntityType.TURTLE, attacker, GarnishedBlocks.VOLTAIC_SEA_GRASS.asItem(), 1, 8.3F);
    }

    private static void createCatDropConditions(LivingEntity entity, LivingEntity attacker) {
        createSalvagingDropConditions(entity, EntityType.OCELOT, attacker, Items.COD, 1, 1, 6.25F, 16.66F);
        if (fitWithinBounds(5, 50))
            createBasicSalvagingDropConditions(entity, EntityType.CAT, attacker, Items.COOKED_COD, 1, 6.25F);
        else createSalvagingDropConditions(entity, EntityType.CAT, attacker, Items.COD, 1, 1, 6.25F, 16.66F);
    }

    private static void createHorseDropConditions(LivingEntity entity, LivingEntity attacker) {
        createSalvagingDropConditions(entity, EntityType.HORSE, attacker, Items.LEATHER, 1, 3, 6.25F, 16.66F);
        createSalvagingDropConditions(entity, EntityType.MULE, attacker, Items.LEATHER, 1, 3, 6.25F, 16.66F);
        createSalvagingDropConditions(entity, EntityType.DONKEY, attacker, Items.LEATHER, 1, 3, 6.25F, 16.66F);
    }

    private static void createSquidDropConditions(LivingEntity entity, LivingEntity attacker) {
        createSalvagingDropConditions(entity, EntityType.SQUID, attacker, Items.INK_SAC, 1, 4, 16.66F, 25.0F);
        if (fitWithinBounds(50))
            createSalvagingDropConditions(entity, EntityType.GLOW_SQUID, attacker, Items.INK_SAC, 1, 4, 16.66F, 25.0F);
        else createSalvagingDropConditions(entity, EntityType.GLOW_SQUID, attacker, Items.GLOW_LICHEN, 1, 1, 12.5F, 16.66F);
    }
}