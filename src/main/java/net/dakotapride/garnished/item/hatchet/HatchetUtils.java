package net.dakotapride.garnished.item.hatchet;

import net.dakotapride.garnished.registry.GarnishedEnchantments;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.GlowSquid;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.frog.Tadpole;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Unique;

@SuppressWarnings("unused")
public class HatchetUtils {
    // Information
    // Maximum Level: 2
    // Minimum Level: 1
    //
    // Grants additional drops depending on the level
    static Enchantment salvaging = GarnishedEnchantments.SALVAGING.get();
    // Information
    // Maximum Level: 1
    // Minimum Level: 1
    //
    // Grants the player PVE/PVP benefits depending on the situation
    static Enchantment ravaging = GarnishedEnchantments.RAVAGING.get();
    // random shit
    public static final RandomSource random = RandomSource.create();

    public HatchetUtils() {}

    public static void getDrops(LivingEntity entity, LivingEntity attacker) {
        int singleCount = 1;
        int count = singleCount + random.nextInt(2);

        // Salvaging Loot Drops
        if (hasSalvaging(attacker)) {
            if (MobHelper.isFish(entity)) {
                int fishBoneDropChance = 0;
                int additionalFishDropChance = 0;

                if (isCorrectEnchantmentLevel(salvaging, attacker, 1)) {
                    fishBoneDropChance = random.nextInt(6);
                    additionalFishDropChance = random.nextInt(24);
                } else if (isCorrectEnchantmentLevel(salvaging, attacker, 2)) {
                    fishBoneDropChance = random.nextInt(3);
                    additionalFishDropChance = random.nextInt(12);
                }

                if (fishBoneDropChance == 1) {
                    entity.spawnAtLocation(new ItemStack(Items.BONE, count));
                } else if (additionalFishDropChance == 1 && isCorrectEnchantmentLevel(salvaging, attacker, 2)) {
                    int fishCount = singleCount + random.nextInt(1);
                    int tropicalFishCount = singleCount + random.nextInt(2);

                    if (MobHelper.isSalmon(entity)) {
                        entity.spawnAtLocation(new ItemStack(Items.SALMON, fishCount));
                    } else if (MobHelper.isCod(entity)) {
                        entity.spawnAtLocation(new ItemStack(Items.COD, fishCount));
                    } else if (MobHelper.isPufferfish(entity)) {
                        entity.spawnAtLocation(new ItemStack(Items.PUFFERFISH, singleCount));
                    } else if (MobHelper.isTropicalFish(entity)) {
                        entity.spawnAtLocation(new ItemStack(Items.TROPICAL_FISH, tropicalFishCount));
                    }
                }
            }

            if (MobHelper.isSquidOrSimilar(entity)) {
                int additionalSacDropChance = 0;

                if (isCorrectEnchantmentLevel(salvaging, attacker, 1)) {
                    additionalSacDropChance = random.nextInt(12);
                } else if (isCorrectEnchantmentLevel(salvaging, attacker, 2)) {
                    additionalSacDropChance = random.nextInt(6);
                }

                if (additionalSacDropChance == 1) {
                    Item sacItem = null;
                    int sacCount = singleCount + random.nextInt(2);

                    if (MobHelper.isSquid(entity)) {
                        sacItem = Items.INK_SAC;
                    } else if (MobHelper.isGlowSquid(entity)) {
                        sacItem = Items.GLOW_INK_SAC;
                    }

                    entity.spawnAtLocation(new ItemStack(sacItem, sacCount));
                }
            }

            if (MobHelper.isMagmaCube(entity)) {
                int froglightDropChance = 0;
                int moltenRemnantDropChance = 0;

                if (isCorrectEnchantmentLevel(salvaging, attacker, 1)) {
                    froglightDropChance = random.nextInt(80);
                    moltenRemnantDropChance = random.nextInt(110);
                } else if (isCorrectEnchantmentLevel(salvaging, attacker, 2)) {
                    froglightDropChance = random.nextInt(60);
                    moltenRemnantDropChance = random.nextInt(70);
                }

                if (froglightDropChance == 1 && isCorrectEnchantmentLevel(salvaging, attacker, 2)) {
                    Item froglightItem = null;
                    int froglightVariantChance = random.nextInt(3);

                    if (froglightVariantChance == 1) {
                        froglightItem = Items.OCHRE_FROGLIGHT;
                    } else if (froglightVariantChance == 2) {
                        froglightItem = Items.PEARLESCENT_FROGLIGHT;
                    } else if (froglightVariantChance == 3) {
                        froglightItem = Items.VERDANT_FROGLIGHT;
                    }

                    entity.spawnAtLocation(new ItemStack(froglightItem, singleCount));
                }

                if (moltenRemnantDropChance == 1) {
                    int moltenRemnantCount = singleCount + random.nextInt(2);

                    entity.spawnAtLocation(new ItemStack(GarnishedItems.MOLTEN_REMNANT.get(), moltenRemnantCount));
                }
            }

            if (MobHelper.isFrog(entity)) {
                int magmaCreamDropChance = random.nextInt(60);
                int moltenRemnantDropChance = 0;

                if (isCorrectEnchantmentLevel(salvaging, attacker, 1)) {
                    moltenRemnantDropChance = random.nextInt(120);
                } else if (isCorrectEnchantmentLevel(salvaging, attacker, 2)) {
                    moltenRemnantDropChance = random.nextInt(100);
                }

                if (magmaCreamDropChance == 1) {
                    int magmaCreamCount = singleCount + random.nextInt(2);

                    entity.spawnAtLocation(new ItemStack(Items.MAGMA_CREAM, magmaCreamCount));
                }

                if (moltenRemnantDropChance == 1) {
                    int moltenRemnantCount = singleCount + random.nextInt(1);

                    entity.spawnAtLocation(new ItemStack(GarnishedItems.MOLTEN_REMNANT.get(), moltenRemnantCount));
                }
            }
        }

        // Ravaging Loot Drops
        if (hasRavaging(attacker)) {
            if (MobHelper.isUndead(entity)) {
                int additionalLootDropChance = 0;
                int additionalLootDropCount = 0;

                if (MobHelper.isPhantom(entity)) {
                    additionalLootDropChance = random.nextInt(4);
                    additionalLootDropCount = singleCount + random.nextInt(1);

                    if (additionalLootDropChance == 1) {
                        entity.spawnAtLocation(new ItemStack(Items.PHANTOM_MEMBRANE, additionalLootDropCount));
                    }
                }

                if (MobHelper.isSkeletonOrSimilar(entity)) {
                    additionalLootDropChance = random.nextInt(16);
                    additionalLootDropCount = singleCount + random.nextInt(3);

                    if (additionalLootDropChance == 1) {
                        entity.spawnAtLocation(new ItemStack(Items.BONE, additionalLootDropCount));
                    }

                    if (MobHelper.isWitherSkeleton(entity)) {
                        additionalLootDropChance = random.nextInt(24);
                        additionalLootDropCount = singleCount + random.nextInt(1);

                        if (additionalLootDropChance == 1) {
                            entity.spawnAtLocation(new ItemStack(Items.COAL, additionalLootDropCount));
                        }
                    }
                }
            }
        }
    }


    public static boolean isAffectedByRavaging(Entity entity) {
        return entity.getType().is(GarnishedTags.IS_AFFECTED_BY_RAVAGING);
    }

    public static boolean isAffectedBySalvaging(Entity entity) {
        return entity.getType().is(GarnishedTags.IS_AFFECTED_BY_SALVAGING);
    }

    public static boolean hasRavaging(LivingEntity entity) {
        return hasEnchantment(ravaging, entity);
    }

    public static boolean hasSalvaging(LivingEntity entity) {
        return hasEnchantment(salvaging, entity);
    }

    public static boolean canApplyRavaging(LivingEntity entity) {
        return entity.getMainHandItem().is(GarnishedTags.HATCHETS_TAG) && hasEnchantment(ravaging, entity) && entity.getHealth() <= 10;
    }



    @Unique
    private static boolean hasEnchantment(Enchantment enchantment, LivingEntity entity) {
        return EnchantmentHelper.getEnchantmentLevel(enchantment, entity) > 0;
    }

    @Unique
    private static boolean isCorrectEnchantmentLevel(Enchantment enchantment, LivingEntity entity, int level) {
        return EnchantmentHelper.getEnchantmentLevel(enchantment, entity) == level;
    }


    public static class MobHelper {
        public MobHelper() {}

        public static boolean isPhantom(Entity entity) {
            return entity instanceof Phantom;
        }

        public static boolean isWitherBoss(Entity entity) {
            return entity instanceof WitherBoss;
        }

        public static boolean isWitherSkeleton(Entity entity) {
            return entity instanceof WitherSkeleton;
        }

        public static boolean isSkeleton(Entity entity) {
            return entity instanceof Skeleton;
        }

        public static boolean isSkeletonOrSimilar(Entity entity) {
            return isWitherBoss(entity) || isWitherSkeleton(entity) || isSkeleton(entity);
        }

        public static boolean isHusk(Entity entity) {
            return entity instanceof Husk;
        }

        public static boolean isZombie(Entity entity) {
            return entity instanceof Zombie;
        }

        public static boolean isZombieOrSimilar(Entity entity) {
            return isZombie(entity) || isHusk(entity);
        }

        public static boolean isUndead(Entity entity) {
            return isZombieOrSimilar(entity) || isSkeletonOrSimilar(entity) || isPhantom(entity);
        }

        public static boolean isMagmaCube(Entity entity) {
            return entity instanceof MagmaCube;
        }

        public static boolean isSalmon(Entity entity) {
            return entity instanceof Salmon;
        }

        public static boolean isCod(Entity entity) {
            return entity instanceof Cod;
        }

        public static boolean isPufferfish(Entity entity) {
            return entity instanceof Pufferfish;
        }

        public static boolean isTropicalFish(Entity entity) {
            return entity instanceof TropicalFish;
        }

        public static boolean isFish(Entity entity) {
            return isSalmon(entity) || isCod(entity) || isPufferfish(entity) || isTropicalFish(entity);
        }

        public static boolean isSquid(Entity entity) {
            return entity instanceof Squid;
        }

        public static boolean isGlowSquid(Entity entity) {
            return entity instanceof GlowSquid;
        }

        public static boolean isSquidOrSimilar(Entity entity) {
            return isSquid(entity) || isGlowSquid(entity);
        }

        public static boolean isFrog(Entity entity) {
            return entity instanceof Frog;
        }

        public static boolean isTadpole(Entity entity) {
            return entity instanceof Tadpole;
        }

        public static boolean isFrogOrSimilar(Entity entity) {
            return isFrog(entity) || isTadpole(entity);
        }
    }

}
