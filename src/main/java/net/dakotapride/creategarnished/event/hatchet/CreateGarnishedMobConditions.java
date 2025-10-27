package net.dakotapride.creategarnished.event.hatchet;

import com.simibubi.create.AllItems;
import earth.terrarium.pastel.entity.PastelEntityTypes;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.registry.CreateGarnishedEntityTypes;
import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.dakotapride.creategarnished.util.ModIds;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public class CreateGarnishedMobConditions extends MobConditions {
    public CreateGarnishedMobConditions() {}

    // Ponder concept
    // Go over the base functionality of the Pressurised Hatchet
    // Go over the two drop systems
    // - Global Drops
    //   Drops a given item from a specific group of mobs (i.e. zombies, skeletons, spiders)
    // - Isolated Drops
    //   Drops a given item from individual mobs

    // Voltified Drops
    // - Drops a unique, voltified variant of certain items or a unique voltified item

    @EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.GAME)
    static class DropItemsFromHatchetUseEvent {
        @SubscribeEvent
        private static void addDropsUponDeath(LivingDeathEvent event) {
            LivingEntity entity = event.getEntity();
            DamageSource source = event.getSource();

            if (source.getEntity() != null && source.getEntity() instanceof LivingEntity attacker && MobConditions.accept(attacker)) {
                applyConditions(entity, attacker, source);

            }
        }
    }

    public static void applyConditions(LivingEntity entity, LivingEntity attacker, DamageSource source) {
        createVoltStruckEffects(entity, EntityType.COD, CreateGarnishedEntityTypes.VOLTFISH.get(), attacker, config.enableVoltfishAnomaly.get());

        registerZombieDropConditions(entity, attacker, source);
        registerSkeletonDropConditions(entity, attacker, source);
        registerGelatinousCreatureDropConditions(entity, attacker, source);
        registerGuardianDropConditions(entity, attacker, source);
        registerSpiderDropConditions(entity, attacker, source);
        registerSquidDropConditions(entity, attacker, source);

        createDropConditions(entity, EntityType.SHULKER, attacker, Items.SHULKER_SHELL, config.shulkerShellMaxCount.get(), config.chanceToDropExtraShulkerShells.get(), source, config.enableShulkerDrops.get());

        createDropConditions(entity, EntityType.PHANTOM, attacker, Items.PHANTOM_MEMBRANE, config.phantomMembraneMaxCount.get(), config.chanceToDropExtraPhantomMembranes.get(), source, config.enablePhantomDrops.get());

        createDropConditions(entity, EntityType.WITCH, attacker, Items.REDSTONE, config.redstoneDustMaxCount.get(), config.chanceToDropExtraRedstoneDust.get(), source, config.enableWitchDrops.get());
        createDropConditions(entity, EntityType.WITCH, attacker, Items.GLOWSTONE_DUST, config.glowstoneDustMaxCount.get(), config.chanceToDropExtraGlowstoneDust.get(), source, config.enableWitchDrops.get());
        createDropConditions(entity, EntityType.WITCH, attacker, Items.NETHER_WART, config.netherWartMaxCount.get(), config.chanceToDropNetherWart.get(), source, config.enableWitchDrops.get());

        createDropConditions(entity, EntityType.RAVAGER, attacker, AllItems.ZINC_NUGGET.get(), config.zincNuggetMaxCount.get(), config.chanceToDropZincNugget.get(), source, config.enableRavagerDrops.get());

        createDropConditions(entity, EntityType.SNIFFER, attacker, CreateGarnishedItems.SNIFFER_FLUFF.get(), config.snifferFluffMaxCount.get(), config.chanceToDropSnifferFluff.get(), source, config.enableSnifferDrops.get());

        createDropConditions(entity, EntityType.CREEPER, attacker, Items.GUNPOWDER, config.gunpowderMaxCount.get(), config.chanceToDropGunpowder.get(), source, config.enableCreeperDrops.get());

        createDropConditions(entity, EntityType.GHAST, attacker, Items.GUNPOWDER, config.gunpowderMaxCount.get(), config.chanceToDropGunpowder.get(), source, config.enableGhastDrops.get());
        createDropConditions(entity, EntityType.GHAST, attacker, Items.GHAST_TEAR, config.extraGhastTearMaxCount.get(), config.chanceToDropExtraGhastTear.get(), source, config.enableGhastDrops.get());

        createDropConditions(entity, EntityType.BREEZE, attacker, Items.BREEZE_ROD, config.extraBreezeRodMaxCount.get(), config.chanceToDropExtraBreezeRod.get(), source, config.enableBreezeDrops.get());
        createDropConditions(entity, EntityType.BLAZE, attacker, Items.BLAZE_ROD, config.extraBlazeRodMaxCount.get(), config.chanceToDropExtraBlazeRod.get(), source, config.enableBlazeDrops.get());

        createDropConditions(entity, EntityType.ENDERMAN, attacker, Items.ENDER_PEARL, config.extraEnderPearlMaxCount.get(), config.chanceToDropExtraEnderPearl.get(), source, config.enableEndermanDrops.get());
    }

    private static void registerZombieDropConditions(LivingEntity entity, LivingEntity attacker, DamageSource source) {
        boolean z = config.enableZombieDrops.get();

        createDropConditions(entity, EntityType.ZOMBIE, attacker, Items.LEATHER, config.leatherMaxCount.get(),
                config.chanceToDropLeather.get(), source, z, global);
        createDropConditions(entity, EntityType.HUSK, attacker, Items.LEATHER, config.leatherMaxCount.get(),
                config.chanceToDropLeather.get(), source, config.enableHuskDrops.get(), z, global);
        createDropConditions(entity, EntityType.DROWNED, attacker, Items.LEATHER, config.leatherMaxCount.get(),
                config.chanceToDropLeather.get(), source, config.enableDrownedDrops.get(), z, global);

        createDropConditions(entity, EntityType.HUSK, attacker, Items.GOLD_NUGGET, config.goldNuggetMaxCount.get(),
                config.chanceToDropGoldNugget.get(), source, config.enableHuskDrops.get(), z);
        createDropConditions(entity, EntityType.DROWNED, attacker, AllItems.COPPER_NUGGET.get(), config.copperNuggetMaxCount.get(),
                config.chanceToDropCopperNugget.get(), source, config.enableDrownedDrops.get(), z);
    }

    private static void registerSkeletonDropConditions(LivingEntity entity, LivingEntity attacker, DamageSource source) {
        boolean s = config.enableSkeletonDrops.get();

        createDropConditions(entity, EntityType.SKELETON, attacker, Items.BONE_MEAL, config.boneMealMaxCount.get(),
                config.chanceToDropBoneMeal.get(), source, s, global);
        createDropConditions(entity, EntityType.BOGGED, attacker, Items.BONE_MEAL, config.boneMealMaxCount.get(),
                config.chanceToDropBoneMeal.get(), source, config.enableBoggedDrops.get(), s, global);
        createDropConditions(entity, EntityType.STRAY, attacker, Items.BONE_MEAL, config.boneMealMaxCount.get(),
                config.chanceToDropBoneMeal.get(), source, config.enableStrayDrops.get(), s, global);

        createDropConditions(entity, EntityType.BOGGED, attacker, Items.MOSS_BLOCK, config.mossBlockMaxCount.get(),
                config.chanceToDropMossBlock.get(), source, config.enableBoggedDrops.get(), s);
        createDropConditions(entity, EntityType.WITHER_SKELETON, attacker, Items.COAL, config.extraCoalMaxCount.get(),
                config.chanceToDropExtraCoal.get(), source, config.enableWitherSkeletonDrops.get(), s);
    }

    private static void registerGelatinousCreatureDropConditions(LivingEntity entity, LivingEntity attacker, DamageSource source) {
        boolean gC = config.enableGelatinousCreatureDrops.get();

        createDropConditions(entity, EntityType.SLIME, attacker, CreateGarnishedItems.ELASTIC_STRAND.get(), config.elasticStrandMaxCount.get(),
                config.chanceToDropElasticStrand.get(), source, gC);
        createDropConditions(entity, EntityType.SLIME, attacker, Items.SLIME_BALL, config.slimeBallMaxCount.get(),
                config.chanceToDropExtraSlimeBalls.get(), source, config.enableSlimeDrops.get(), gC);
        createDropConditions(entity, EntityType.MAGMA_CUBE, attacker, CreateGarnishedItems.FIERY_ELASTIC_STRAND.get(), config.elasticStrandMaxCount.get(),
                config.chanceToDropElasticStrand.get(), source, gC);
        createDropConditions(entity, EntityType.MAGMA_CUBE, attacker, Items.MAGMA_CREAM, config.magmaCreamMaxCount.get(),
                config.chanceToDropExtraMagmaCream.get(), source, config.enableMagmaCubeDrops.get(), gC);
    }

    private static void registerGuardianDropConditions(LivingEntity entity, LivingEntity attacker, DamageSource source) {
        boolean g = config.enableGuardianDrops.get();

        createDropConditions(entity, EntityType.GUARDIAN, attacker, Items.PRISMARINE_SHARD, config.prismarineShardMaxCount.get(),
                config.chanceToDropExtraPrismarineShards.get(), source, config.enableLesserGuardianDrops.get(), g, global);
        createDropConditions(entity, EntityType.GUARDIAN, attacker, Items.PRISMARINE_CRYSTALS, config.prismarineCrystalsMaxCount.get(),
                config.chanceToDropExtraPrismarineCrystals.get(), source, config.enableLesserGuardianDrops.get(), g, global);
        createDropConditions(entity, EntityType.ELDER_GUARDIAN, attacker, Items.PRISMARINE_SHARD, config.prismarineShardMaxCount.get(),
                config.chanceToDropExtraPrismarineShards.get(), source, config.enableElderGuardianDrops.get(), g, global);
        createDropConditions(entity, EntityType.ELDER_GUARDIAN, attacker, Items.PRISMARINE_CRYSTALS, config.prismarineCrystalsMaxCount.get(),
                config.chanceToDropExtraPrismarineCrystals.get(), source, config.enableElderGuardianDrops.get(), g, global);

        createDropConditions(entity, EntityType.GUARDIAN, attacker, CreateGarnishedItems.GUARDIAN_SPIKE.get(), config.guardianSpikeMaxCount.get(),
                config.chanceToDropGuardianSpike.get(), source, config.enableLesserGuardianDrops.get(), g, !ModIds.RELIQUARY.isLoaded());

        createDropConditions(entity, EntityType.ELDER_GUARDIAN, attacker, CreateGarnishedItems.ELDER_GUARDIAN_SPIKE.get(), config.elderGuardianSpikeMaxCount.get(),
                config.chanceToDropElderGuardianSpike.get(), source, config.enableElderGuardianDrops.get(), g);
    }

    private static void registerSpiderDropConditions(LivingEntity entity, LivingEntity attacker, DamageSource source) {
        boolean s = config.enableAllSpiderDrops.get();

        createDropConditions(entity, EntityType.SPIDER, attacker, Items.STRING, config.extraStringMaxCount.get(),
                config.chanceToDropExtraString.get(), source, config.enableSpiderDrops.get(), s, global);
        createDropConditions(entity, EntityType.CAVE_SPIDER, attacker, Items.STRING, config.extraStringMaxCount.get(),
                config.chanceToDropExtraString.get(), source, config.enableCaveSpiderDrops.get(), s, global);

        if (ModIds.PASTEL.isLoaded())
            createDropConditions(entity, PastelEntityTypes.ERASER.get(), attacker, Items.STRING, config.extraStringMaxCount.get(),
                config.chanceToDropExtraString.get(), source, config.enableGlobalHatchetDrops.get(), s);
    }

    private static void registerSquidDropConditions(LivingEntity entity, LivingEntity attacker, DamageSource source) {
        boolean s = config.enableAllSquidDrops.get();
            createDropConditions(entity, EntityType.SQUID, attacker, Items.INK_SAC, config.extraInkSacMaxCount.get(),
                    config.chanceToDropExtraInkSac.get(), source, config.enableSquidDrops.get(), s);
            createDropConditions(entity, EntityType.GLOW_SQUID, attacker, Items.GLOW_INK_SAC, config.extraGlowInkSacMaxCount.get(),
                    config.chanceToDropExtraGlowInkSac.get(), source, config.enableGlowSquidDrops.get(), s);
    }
}
