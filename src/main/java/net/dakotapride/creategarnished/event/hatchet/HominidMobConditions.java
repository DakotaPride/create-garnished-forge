package net.dakotapride.creategarnished.event.hatchet;

import com.alganaut.hominid.registry.entity.HominidEntityCreator;
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

public class HominidMobConditions extends MobConditions {
    public HominidMobConditions() {}


    public static void applyConditions(LivingEntity entity, LivingEntity attacker, DamageSource source) {
        if (!config.enableZombieDrops.get()) {
            createHominidDropConditions(entity, HominidEntityCreator.FAMISHED.get(), attacker, Items.BONE, 2, 15, source);
            createHominidDropConditions(entity, HominidEntityCreator.FAMISHED.get(), attacker, Items.ROTTEN_FLESH, 2, 45, source);
            createHominidDropConditions(entity, HominidEntityCreator.FAMISHED.get(), attacker, Items.LEATHER, 2, 35, source);

            createHominidDropConditions(entity, HominidEntityCreator.INCENDIARY.get(), attacker, Items.ROTTEN_FLESH, 2, 45, source);
            createHominidDropConditions(entity, HominidEntityCreator.INCENDIARY.get(), attacker, Items.GUNPOWDER, 2, 35, source);

            createHominidDropConditions(entity, HominidEntityCreator.JUGGERNAUT.get(), attacker, Items.ROTTEN_FLESH, 2, 45, source);
            createHominidDropConditions(entity, HominidEntityCreator.JUGGERNAUT.get(), attacker, Items.IRON_INGOT, 2, 35, source);

            createHominidDropConditions(entity, HominidEntityCreator.MELLIFIED.get(), attacker, Items.ROTTEN_FLESH, 2, 45, source);
            createHominidDropConditions(entity, HominidEntityCreator.MELLIFIED.get(), attacker, Items.HONEYCOMB, 2, 35, source);
        }

        if (!config.enableSkeletonDrops.get()) {
            createHominidDropConditions(entity, HominidEntityCreator.FOSSILISED.get(), attacker, Items.STONE, 4, 65, source);
        }

        createHominidDropConditions(entity, HominidEntityCreator.VAMPIRE.get(), attacker, Items.ROTTEN_FLESH, 2, 15, source);
    }

    @EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.GAME)
    static class PastelConditionsEvent {
        @SubscribeEvent
        private static void createHominidConditions(LivingDeathEvent event) {
            LivingEntity entity = event.getEntity();
            DamageSource source = event.getSource();

            if (source.getEntity() != null && source.getEntity() instanceof LivingEntity attacker && MobConditions.accept(attacker)) {
                if (ModIds.HOMINID.isLoaded())
                    applyConditions(entity, attacker, source);
            }
        }
    }

    public static void createHominidDropConditions(LivingEntity entity, EntityType<?> entityType, LivingEntity attacker, Item item, int maxCount, int chance, DamageSource source) {
        createDropConditions(entity, entityType, attacker, item, maxCount, chance, source, !ModIds.HOMINID.isLoaded());
    }
}
