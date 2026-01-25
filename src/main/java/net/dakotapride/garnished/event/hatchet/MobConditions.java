package net.dakotapride.garnished.event.hatchet;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.item.hatchet.HatchetToolItem;
import net.dakotapride.garnished.item.hatchet.HatchetUtils;
import net.dakotapride.garnished.registry.GarnishedEnchantments;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.fml.loading.FMLLoader;

import java.util.Random;

public class MobConditions {

    public static boolean accept(LivingEntity attacker) {
        return attacker.getMainHandItem().getItem() instanceof HatchetToolItem || attacker.getMainHandItem().is(GarnishedTags.HATCHETS_TAG);
    }

    public static boolean requireSpecificHatchetItem(LivingEntity attacker, Item item) {
        return attacker.getMainHandItem().is(item) && accept(attacker);
    }

    public static void createRavagingDropConditions(LivingEntity entity,
                                                    EntityType<?> matchType,
                                                    LivingEntity attacker,
                                                    Item itemToDrop,
                                                    int minCount,
                                                    int maxCount,
                                                    float chance) {
        setRavagingDropConditions(entity, matchType, attacker, itemToDrop, minCount, maxCount, chance);
    }

    public static void createBasicRavagingDropConditions(LivingEntity entity,
                                                    EntityType<?> matchType,
                                                    LivingEntity attacker,
                                                    Item itemToDrop,
                                                    int maxCount,
                                                    float chance) {
        setRavagingDropConditions(entity, matchType, attacker, itemToDrop, 1, maxCount, chance);
    }

    public static void createSalvagingDropConditions(LivingEntity entity,
                                                     EntityType<?> matchType,
                                                     LivingEntity attacker,
                                                     Item itemToDrop,
                                                     int minCount,
                                                     int maxCount,
                                                     float chance,
                                                     float sChance) {
        setSalvagingDropConditions(entity, matchType, attacker, itemToDrop, minCount, maxCount, chance, sChance);
    }

    public static void createBasicSalvagingDropConditions(LivingEntity entity,
                                                          EntityType<?> matchType,
                                                          LivingEntity attacker,
                                                          Item itemToDrop,
                                                          int maxCount,
                                                          float chance) {
        setSalvagingDropConditions(entity, matchType, attacker, itemToDrop, 1, maxCount, chance, chance);
    }

    public static void setRavagingDropConditions(LivingEntity entity,
                                                 EntityType<?> matchType,
                                                 LivingEntity attacker,
                                                 Item itemToDrop,
                                                 int minCount,
                                                 int maxCount,
                                                 float chance) {

        EntityType<?> type = entity.getType();

        boolean attackerHasLuck = attacker.hasEffect(MobEffects.LUCK);
        boolean attackerHasUnluck = attacker.hasEffect(MobEffects.UNLUCK);

        if (entity.isBaby())
            return;

        float r = new Random().nextFloat(0, 100);
        if (attackerHasLuck) {
            r = new Random().nextInt(0, 50);
        }
        if (attackerHasUnluck) {
            r = new Random().nextInt(0, 200);
        }

        int r0 = new Random().nextInt(minCount, maxCount + 1);
        ItemStack stack = attacker.getMainHandItem();
        if (HatchetUtils.hasRavaging(attacker, stack)) {
            if (type == matchType) {
                if (r <= chance) {
                    entity.spawnAtLocation(new ItemStack(itemToDrop, r0));
                    if (!FMLLoader.isProduction())
                        CreateGarnished.LOGGER.info("[Is Ravaging: true] rolled random as {}, the chance is equal to {}, expecting to drop {}", r, chance, itemToDrop);
                }
            }
        }
    }

    public static void setSalvagingDropConditions(LivingEntity entity,
                                                 EntityType<?> matchType,
                                                 LivingEntity attacker,
                                                 Item itemToDrop,
                                                 int minCount,
                                                 int maxCount,
                                                 float chance,
                                                 float secondaryChance) {

        EntityType<?> type = entity.getType();

        boolean attackerHasLuck = attacker.hasEffect(MobEffects.LUCK);
        boolean attackerHasUnluck = attacker.hasEffect(MobEffects.UNLUCK);

        if (entity.isBaby())
            return;

        float r = new Random().nextFloat(0, 100);
        if (attackerHasLuck) {
            r = new Random().nextInt(0, 50);
        }
        if (attackerHasUnluck) {
            r = new Random().nextInt(0, 200);
        }

        int r0 = new Random().nextInt(minCount, maxCount + 1);
        ItemStack stack = attacker.getMainHandItem();
        if (HatchetUtils.hasSalvaging(attacker, stack)) {
            Holder<Enchantment> salvagingEnchantmentHolder = attacker.level().registryAccess()
                    .registryOrThrow(Registries.ENCHANTMENT)
                    .getHolderOrThrow(GarnishedEnchantments.SALVAGING);
            boolean b = r <= chance;
            if (EnchantmentHelper.getEnchantmentLevel(salvagingEnchantmentHolder, attacker) == 2)
                b = r <= secondaryChance;
            if (type == matchType) {
                if (b) {
                    entity.spawnAtLocation(new ItemStack(itemToDrop, r0));
                    if (!FMLLoader.isProduction())
                        CreateGarnished.LOGGER.info("[Is Ravaging: false] rolled random as {}, the chance is equal to {}, expecting to drop {}", r, chance, itemToDrop);
                }
            }
        }
    }

    public static boolean fitWithinBounds(int g) {
        return g >= new Random().nextInt(100);
    }

    public static boolean fitWithinBounds(int value, int param) {
        return value >= new Random().nextInt(param);
    }
}