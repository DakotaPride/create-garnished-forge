package net.dakotapride.creategarnished.event.hatchet;

import net.dakotapride.creategarnished.config.HatchetConfig;
import net.dakotapride.creategarnished.entity.VoltfishEntity;
import net.dakotapride.creategarnished.item.PressurisedHatchetItem;
import net.dakotapride.creategarnished.registry.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class MobConditions {
    public static HatchetConfig config = CreateGarnishedConfigs.server().hatchet;
    public static boolean global = config.enableGlobalHatchetDrops.get();
    public static boolean volt = config.enableVoltDrops.get();

    public static boolean accept(LivingEntity attacker) {
        return attacker.getMainHandItem().getItem() instanceof PressurisedHatchetItem || attacker.getMainHandItem().is(CreateGarnishedTags.HATCHETS);
    }

    public static boolean requireSpecificHatchetItem(LivingEntity attacker, Item item) {
        return attacker.getMainHandItem().is(item) && accept(attacker);
    }

    public static void createSoundEvents(LivingEntity attacker) {
        Level level = attacker.level();
        if (level instanceof ServerLevel server && attacker instanceof ServerPlayer player) {
            server.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.SOUL_ESCAPE, player.getSoundSource(), 2.0F, 1.0F);
            if (player.hasEffect(MobEffects.LUCK) && CreateGarnishedConfigs.client().allowLuckyPlingSoundEvent.get()) {
                server.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.NOTE_BLOCK_PLING, player.getSoundSource(), 0.5F, 1.0F);
            }

        }
    }

    public static void createVoltStruckEffects(LivingEntity entity, EntityType<?> matchType, EntityType<?> anomaly, LivingEntity attacker, boolean... enabled0) {
        EntityType<?> type = entity.getType();

        boolean enabled1 = false;
        for (boolean b : enabled0) {
            enabled1 = b;
        }

        if (type == matchType && (entity.hasEffect(CreateGarnishedStatusEffects.VOLT_STRUCK) || attacker.hasEffect(CreateGarnishedStatusEffects.VOLT_STRUCK)) && enabled1 && config.enableHatchetDrops.get() && volt) {
            Entity anomalyEntity = anomaly.create(attacker.level());

            anomalyEntity.setPos(entity.getPosition(0));
            attacker.level().addFreshEntity(anomalyEntity);
        }
    }

    public static void createDropConditions(LivingEntity entity,
                                            EntityType<?> matchType,
                                            LivingEntity attacker,
                                            Item itemToDrop,
                                            int count,
                                            int chance,
                                            DamageSource source,
                                            boolean... enabled0) {

        EntityType<?> type = entity.getType();

        boolean attackerHasLuck = attacker.hasEffect(MobEffects.LUCK);
        boolean attackerHasUnluck = attacker.hasEffect(MobEffects.UNLUCK);

        int r = new Random().nextInt(1, 101);
        if (attackerHasLuck) {
            r = new Random().nextInt(1, 51);
        }
        if (attackerHasUnluck) {
            r = new Random().nextInt(1, 201);
        }

        Item itemInHand = attacker.getMainHandItem().getItem();
        if (itemInHand instanceof PressurisedHatchetItem hatchetItem && hatchetItem.isCreative())
            chance = 100;

        int r0 = new Random().nextInt(1, count + 1);
        boolean enabled1 = false;
        for (boolean b : enabled0) {
            enabled1 = b;
        }
        if (type == matchType && enabled1 && (config.enableHatchetDrops.get())) {
            if (r <= chance) {
                entity.spawnAtLocation(new ItemStack(itemToDrop, r0));
                if (attacker instanceof ServerPlayer player) {
                    CreateGarnishedTriggers.KILLED_USING_HATCHET.get().trigger(player, entity, source);

                    player.awardStat(CreateGarnishedStatisics.HATCHET_KILLS.get());
                    if (entity.isBaby())
                        player.awardStat(CreateGarnishedStatisics.MONSTER_HATCHET_KILLS.get());

                    if (player.getStats().getValue(Stats.CUSTOM.get(CreateGarnishedStatisics.HATCHET_KILLS.get())) >= 1000)
                        CreateGarnishedTriggers.BLOODLUST.get().trigger(player, entity, source);
                    if (player.getStats().getValue(Stats.CUSTOM.get(CreateGarnishedStatisics.MONSTER_HATCHET_KILLS.get())) >= 1000)
                        CreateGarnishedTriggers.MONSTER.get().trigger(player, entity, source);
                }

                createSoundEvents(attacker);
            }
            //CreateGarnished.LOGGER.info("rolled random as {}, the chance is equal to {}, expecting to drop {}", r, chance, itemToDrop);
        }
    }
}
