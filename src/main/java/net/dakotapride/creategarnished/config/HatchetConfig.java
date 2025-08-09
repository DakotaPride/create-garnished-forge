package net.dakotapride.creategarnished.config;

import net.createmod.catnip.config.ConfigBase;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class HatchetConfig extends ConfigBase {
    public ConfigBool disableHatchetDrops = b(false, "disableHatchetDrops", Comments.disableHatchetDrops);
    public ConfigBool disableGlobalHatchetDrops = b(false, "disableGlobalHatchetDrops", Comments.disableGlobalHatchetDrops);
    public ConfigInt maxPressurisedHatchetActions = i(2000, 0, "maxPressurisedHatchetActions", Comments.maxPressurisedHatchetActions);
    public ConfigBool allowDropsFromBabyMobs = b(true, "allowDropsFromBabyMobs", Comments.allowDropsFromBabyMobs);
    // Mainly a joke option
    // https://youtu.be/K6mi8MFPoog - Thank you, Ford, for showing me this masterpiece that I somehow never saw
    public ConfigBool allowShotgunAxe = b(false, "allowShotgunAxe", Comments.allowShotgunAxe);

    // Setting chance to 0 disables the individual drop without disabling the entire group of drops

    public final ConfigGroup zombies = group(0, "zombies", "Controls drops from the mobs tagged as zombies.");
    public ConfigBool disableZombieDrops = b(false, "disableZombieDrops", Comments.disableZombieDrops);
    public ConfigInt chanceToDropLeather = i(65, 1, 100, "chanceToDropLeather", Comments.chanceToDropLeather);
    public ConfigInt leatherMaxCount = i(2, 1, "leatherMaxCount", Comments.leatherMaxCount);
    public final ConfigGroup husk = group(1, "husk", "Controls drops from the Husk mob.");
    public ConfigBool disableHuskDrops = b(false, "disableHuskDrops", Comments.disableHuskDrops);
    public ConfigInt chanceToDropGoldNugget = i(5, 1, 100, "chanceToDropGoldNugget", Comments.chanceToDropGoldNugget);
    public ConfigInt goldNuggetMaxCount = i(3, 1, "goldNuggetMaxCount", Comments.goldNuggetMaxCount);
    public final ConfigGroup drowned = group(1, "drowned", "Controls drops from the Drowned mob.");
    public ConfigBool disableDrownedDrops = b(false, "disableDrownedDrops", Comments.disableDrownedDrops);
    public ConfigInt chanceToDropCopperNugget = i(5, 1, 100, "chanceToDropCopperNugget", Comments.chanceToDropCopperNugget);
    public ConfigInt copperNuggetMaxCount = i(3, 1, "copperNuggetMaxCount", Comments.copperNuggetMaxCount);

    public final ConfigGroup skeletons = group(0, "skeletons", "Controls drops from the mobs tagged as skeletons.");
    public ConfigBool disableSkeletonDrops = b(false, "disableSkeletonDrops", Comments.disableSkeletonDrops);
    public ConfigInt chanceToDropBoneMeal = i(45, 1, 100, "chanceToDropBoneMeal", Comments.chanceToDropBoneMeal);
    public ConfigInt boneMealMaxCount = i(2, 1, "boneMealMaxCount", Comments.boneMealMaxCount);
    public final ConfigGroup bogged = group(1, "bogged", "Controls drops from the Bogged mob.");
    public ConfigBool disableBoggedDrops = b(false, "disableBoggedDrops", Comments.disableBoggedDrops);
    public ConfigInt chanceToDropMossBlock = i(20, 1, 100, "chanceToDropMossBlock", Comments.chanceToDropMossBlock);
    public ConfigInt mossBlockMaxCount = i(3, 1, "mossBlockMaxCount", Comments.mossBlockMaxCount);
    public final ConfigGroup stray = group(1, "stray", "Controls drops from the Stray mob.");
    public ConfigBool disableStrayDrops = b(false, "disableStrayDrops", Comments.disableStrayDrops);
    public final ConfigGroup witherSkeleton = group(1, "witherSkeleton", "Controls drops from the Wither Skeleton mob.");
    public ConfigBool disableWitherSkeletonDrops = b(false, "disableWitherSkeletonDrops", Comments.disableWitherSkeletonDrops);
    public ConfigInt chanceToDropExtraCoal = i(20, 1, 100, "chanceToDropExtraCoal", Comments.chanceToDropExtraCoal);
    public ConfigInt extraCoalMaxCount = i(2, 1, "extraCoalMaxCount", Comments.extraCoalMaxCount);

    public final ConfigGroup gelatinousCreatures = group(0, "gelatinousCreatures", "Controls drops from mobs tagged as gelatinous creatures.");
    public ConfigBool disableGelatinousCreatureDrops = b(false, "disableGelatinousCreatureDrops", Comments.disableGelatinousCreatureDrops);
    public ConfigInt chanceToDropElasticStrand = i(25, 1, 100, "chanceToDropElasticStrand", Comments.chanceToDropElasticStrand);
    public ConfigInt elasticStrandMaxCount = i(2, 1, "elasticStrandMaxCount", Comments.elasticStrandMaxCount);
    public final ConfigGroup slime = group(1, "slime", "Controls drops from the Slime mob.");
    public ConfigBool disableSlimeDrops = b(false, "disableSlimeDrops", Comments.disableSlimeDrops);
    public ConfigInt chanceToDropExtraSlimeBalls = i(15, 1, 100, "chanceToDropSlimeBall", Comments.chanceToDropExtraSlimeBalls);
    public ConfigInt slimeBallMaxCount = i(2, 1, "slimeBallMaxCount", Comments.slimeBallMaxCount);
    public final ConfigGroup magmaCube = group(1, "magmaCube", "Controls drops from the Magma Cube mob.");
    public ConfigBool disableMagmaCubeDrops = b(false, "disableMagmaCubeDrops", Comments.disableMagmaCubeDrops);
    public ConfigInt chanceToDropExtraMagmaCream = i(15, 1, 100, "chanceToDropExtraMagmaCream", Comments.chanceToDropExtraMagmaCream);
    public ConfigInt magmaCreamMaxCount = i(2, 1, "magmaCreamMaxCount", Comments.magmaCreamMaxCount);

    public final ConfigGroup shulker = group(0, "shulker", "Controls drops from the Shulker mob.");
    public ConfigBool disableShulkerDrops = b(false, "disableShulkerDrops", Comments.disableShulkerDrops);
    public ConfigInt chanceToDropExtraShulkerShells = i(15, 1, 100, "chanceToDropExtraShulkerShells", Comments.chanceToDropExtraShulkerShells);
    public ConfigInt shulkerShellMaxCount = i(1, 1, "shulkerShellMaxCount", Comments.shulkerShellMaxCount);

    public final ConfigGroup witch = group(0, "witch", "Controls drops from the Witch mob.");
    public ConfigBool disableWitchDrops = b(false, "disableWitchDrops", Comments.disableWitchDrops);
    public ConfigInt chanceToDropExtraGlowstoneDust = i(15, 1, 100, "chanceToDropExtraGlowstoneDust", Comments.chanceToDropExtraGlowstoneDust);
    public ConfigInt glowstoneDustMaxCount = i(2, 1, "glowstoneDustMaxCount", Comments.glowstoneDustMaxCount);
    public ConfigInt chanceToDropExtraRedstoneDust = i(0, 1, 100, "chanceToDropExtraRedstoneDust", Comments.chanceToDropExtraRedstoneDust);
    public ConfigInt redstoneDustMaxCount = i(1, 1, "redstoneDustMaxCount", Comments.redstoneDustMaxCount);
    public ConfigInt chanceToDropNetherWart = i(0, 1, 100, "chanceToDropNetherWart", Comments.chanceToDropNetherWart);
    public ConfigInt netherWartMaxCount = i(1, 1, "netherWartMaxCount", Comments.netherWartMaxCount);

    public final ConfigGroup phantom = group(0, "phantom", "Controls drops from the Phantom mob.");
    public ConfigBool disablePhantomDrops = b(false, "disablePhantomDrops", Comments.disablePhantomDrops);
    public ConfigInt chanceToDropExtraPhantomMembranes = i(25, 1, 100, "chanceToDropExtraPhantomMembranes", Comments.chanceToDropExtraPhantomMembranes);
    public ConfigInt phantomMembraneMaxCount = i(1, 1, "phantomMembraneMaxCount", Comments.phantomMembraneMaxCount);

    public final ConfigGroup ravager = group(0, "ravager", "Controls drops from the Ravager mob.");
    public ConfigBool disableRavagerDrops = b(false, "disableRavagerDrops", Comments.disableRavagerDrops);
    public ConfigInt chanceToDropZincNugget = i(15, 1, 100, "chanceToDropZincNugget", Comments.chanceToDropZincNugget);
    public ConfigInt zincNuggetMaxCount = i(1, 1, "zincNuggetMaxCount", Comments.zincNuggetMaxCount);

    public final ConfigGroup sniffer = group(0, "sniffer", "Controls drops from the Sniffer mob.");
    public ConfigBool disableSnifferDrops = b(false, "disableSnifferDrops", Comments.disableSnifferDrops);
    public ConfigInt chanceToDropSnifferFluff = i(80, 1, 100, "chanceToDropSnifferFluff", Comments.chanceToDropSnifferFluff);
    public ConfigInt snifferFluffMaxCount = i(4, 1, "snifferFluffMaxCount", Comments.snifferFluffMaxCount);

    public final ConfigGroup guardians = group(0, "guardians", "Controls drops from mobs tagged as guardians.");
    public ConfigInt chanceToDropExtraPrismarineShards = i(40, 1, 100, "chanceToDropExtraPrismarineShards", Comments.chanceToDropExtraPrismarineShards);
    public ConfigInt prismarineShardMaxCount = i(4, 1, "prismarineShardMaxCount", Comments.prismarineShardMaxCount);
    public ConfigInt chanceToDropExtraPrismarineCrystals = i(25, 1, 100, "chanceToDropExtraPrismarineCrystals", Comments.chanceToDropExtraPrismarineCrystals);
    public ConfigInt prismarineCrystalsMaxCount = i(2, 1, "prismarineCrystalsMaxCount", Comments.prismarineCrystalsMaxCount);
    public ConfigBool disableGuardianDrops = b(false, "disableGuardianDrops", Comments.disableGuardianDrops);
    public final ConfigGroup lesserGuardian = group(1, "lesserGuardian", "Controls drops from the regular Guardian mob.");
    public ConfigBool disableLesserGuardianDrops = b(false, "disableLesserGuardianDrops", Comments.disableLesserGuardianDrops);
    public ConfigInt chanceToDropGuardianSpike = i(70, 1, 100, "chanceToDropGuardianSpike", Comments.chanceToDropGuardianSpike);
    public ConfigInt guardianSpikeMaxCount = i(2, 1, "guardianSpikeMaxCount", Comments.guardianSpikeMaxCount);
    public final ConfigGroup elderGuardian = group(1, "elderGuardian", "Controls drops from the Elder Guardian mob.");
    public ConfigBool disableElderGuardianDrops = b(false, "disableElderGuardianDrops", Comments.disableElderGuardianDrops);
    public ConfigInt chanceToDropElderGuardianSpike = i(70, 1, 100, "chanceToDropElderGuardianSpike", Comments.chanceToDropElderGuardianSpike);
    public ConfigInt elderGuardianSpikeMaxCount = i(2, 1, "elderGuardianSpikeMaxCount", Comments.elderGuardianSpikeMaxCount);

    public final ConfigGroup creeper = group(0, "creeper", "Controls drops from the Creeper mob.");
    public ConfigBool disableCreeperDrops = b(false, "disableCreeperDrops", Comments.disableCreeperDrops);
    public ConfigInt chanceToDropGunpowder = i(40, 1, 100, "chanceToDropGunpowder", Comments.chanceToDropExtraGunpowder);
    public ConfigInt gunpowderMaxCount = i(4, 1, "gunpowderMaxCount", Comments.extraGunpowderMaxCount);
    public final ConfigGroup ghast = group(0, "ghast", "Controls drops from the Ghast mob.");
    public ConfigBool disableGhastDrops = b(false, "disableGhastDrops", Comments.disableGhastDrops);
    public ConfigInt chanceToDropExtraGhastTear = i(40, 1, 100, "chanceToDropGhastTear", Comments.chanceToDropExtraGhastTear);
    public ConfigInt extraGhastTearMaxCount = i(1, 1, "ghastTearMaxCount", Comments.extraGhastTearMaxCount);

    public final ConfigGroup breeze = group(0, "breeze", "Controls drops from the Breeze mob.");
    public ConfigBool disableBreezeDrops = b(false, "disableBreezeDrops", Comments.disableBreezeDrops);
    public ConfigInt chanceToDropExtraBreezeRod = i(40, 1, 100, "chanceToDropExtraBreezeRod", Comments.chanceToDropExtraBreezeRod);
    public ConfigInt extraBreezeRodMaxCount = i(1, 1, "extraBreezeRodMaxCount", Comments.extraBreezeRodMaxCount);

    public final ConfigGroup blaze = group(0, "blaze", "Controls drops from the Blaze mob.");
    public ConfigBool disableBlazeDrops = b(false, "disableBlazeDrops", Comments.disableBlazeDrops);
    public ConfigInt chanceToDropExtraBlazeRod = i(40, 1, 100, "chanceToDropExtraBlazeRod", Comments.chanceToDropExtraBlazeRod);
    public ConfigInt extraBlazeRodMaxCount = i(1, 1, "extraBlazeRodMaxCount", Comments.extraBlazeRodMaxCount);

    public final ConfigGroup enderman = group(0, "enderman", "Controls drops from the Enderman mob.");
    public ConfigBool disableEndermanDrops = b(false, "disableEndermanDrops", Comments.disableEndermanDrops);
    public ConfigInt chanceToDropExtraEnderPearl = i(40, 1, 100, "chanceToDropExtraEnderPearl", Comments.chanceToDropExtraEnderPearl);
    public ConfigInt extraEnderPearlMaxCount = i(1, 1, "extraEnderPearlMaxCount", Comments.extraEnderPearlMaxCount);

    public final ConfigGroup allSquids = group(0, "allSquids", "Controls drops from squid mobs.");
    public ConfigBool disableAllSquidDrops = b(false, "disableAllSquidDrops", Comments.disableAllSquidDrops);
    public final ConfigGroup squid = group(1, "squid", "Controls drops from the Squid mob.");
    public ConfigBool disableSquidDrops = b(false, "disableSquidDrops", Comments.disableSquidDrops);
    public ConfigInt chanceToDropExtraInkSac = i(40, 1, 100, "chanceToDropExtraInkSac", Comments.chanceToDropExtraInkSac);
    public ConfigInt extraInkSacMaxCount = i(4, 1, "extraInkSacMaxCount", Comments.extraInkSacMaxCount);
    public final ConfigGroup glowSquid = group(1, "glowSquid", "Controls drops from the Glow Squid mob.");
    public ConfigBool disableGlowSquidDrops = b(false, "disableGlowSquidDrops", Comments.disableGlowSquidDrops);
    public ConfigInt chanceToDropExtraGlowInkSac = i(40, 1, 100, "chanceToDropExtraGlowInkSac", Comments.chanceToDropExtraGlowInkSac);
    public ConfigInt extraGlowInkSacMaxCount = i(1, 1, "extraGlowInkSacMaxCount", Comments.extraGlowInkSacMaxCount);

    public final ConfigGroup allSpiders = group(0, "allSpiders", "Controls drops from all spider mobs.");
    public ConfigBool disableAllSpiderDrops = b(false, "disableAllSpiderDrops", Comments.disableAllSpiderDrops);
    public ConfigInt chanceToDropExtraString = i(40, 1, 100, "chanceToDropExtraString", Comments.chanceToDropExtraString);
    public ConfigInt extraStringMaxCount = i(4, 1, "extraStringMaxCount", Comments.extraStringMaxCount);
    public final ConfigGroup spider = group(1, "spider", "Controls drops from the Spider mob.");
    public ConfigBool disableSpiderDrops = b(false, "disableSpiderDrops", Comments.disableSpiderDrops);
    public final ConfigGroup caveSpider = group(1, "caveSpider", "Controls drops from the Cave Spider mob.");
    public ConfigBool disableCaveSpiderDrops = b(false, "disableCaveSpiderDrops", Comments.disableCaveSpiderDrops);

    @Override
    public @NotNull String getName() {
        return "hatchet";
    }

    private static class Comments {
        static String disableHatchetDrops = "Disables special drops provided by hatchets.";
        static String disableGlobalHatchetDrops = "Disables special drops provided by hatchets from groups of mobs.";
        static String maxPressurisedHatchetActions = "Amount of free Pressurised Hatchet actions provided by one filled Copper Backtank. Set to 0 makes Pressurised Hatchets unbreakable";
        static String allowDropsFromBabyMobs = "Allows additional or unique drops to also be obtained through baby variant mobs. (how DARE you)";
        static String allowShotgunAxe = "Allows for extra... 'functionality', if you will";

        static String disableZombieDrops = "Disables the special item drops from mobs tagged as zombies upon defeat.";
        static String chanceToDropLeather = "The chance to drop leather upon defeat.";
        static String leatherMaxCount = "Max count for leather to drop upon defeat.";
        //
        static String disableHuskDrops = "Disables the special item drops from husks upon defeat.";
        static String chanceToDropGoldNugget = "The chance to drop gold nuggets upon defeat.";
        static String goldNuggetMaxCount = "Max count for gold nuggets to drop upon defeat.";
        //
        static String disableDrownedDrops = "Disables the special item drops from drowned upon defeat.";
        static String chanceToDropCopperNugget = "The chance to drop copper nuggets upon defeat.";
        static String copperNuggetMaxCount = "Max count for copper nuggets to drop upon defeat.";

        static String disableSkeletonDrops = "Disables the special item drops from mobs tagged as skeletons upon defeat.";
        static String chanceToDropBoneMeal = "The chance to drop bone meal upon defeat.";
        static String boneMealMaxCount = "Max count for bone meal to drop upon defeat.";
        //
        static String disableBoggedDrops = "Disables the special item drops from bogged upon defeat.";
        static String chanceToDropMossBlock = "The chance to drop moss blocks upon defeat.";
        static String mossBlockMaxCount = "Max count for moss blocks to drop upon defeat.";
        //
        static String disableStrayDrops = "Disables the special item drops from strays upon defeat.";
        //
        static String disableWitherSkeletonDrops = "Disables the special item drops from wither skeletons upon defeat.";
        static String chanceToDropExtraCoal = "The chance to drop extra coal upon defeat.";
        static String extraCoalMaxCount = "Max count for extra coal to drop upon defeat.";

        static String disableShulkerDrops = "Disables the special item drops from shulkers upon defeat.";
        static String chanceToDropExtraShulkerShells = "The chance to drop extra shulker shells upon defeat.";
        static String shulkerShellMaxCount = "Max count for extra shulker shells to drop upon defeat.";

        static String disableWitchDrops = "Disables the special item drops from witches upon defeat.";
        static String chanceToDropExtraRedstoneDust = "The chance to drop extra redstone dust upon defeat.";
        static String redstoneDustMaxCount = "Max count for extra redstone dust to drop upon defeat.";
        static String chanceToDropExtraGlowstoneDust = "The chance to drop extra glowstone dust upon defeat.";
        static String glowstoneDustMaxCount = "Max count for extra glowstone dust to drop upon defeat.";
        static String chanceToDropNetherWart = "The chance to drop nether wart upon defeat.";
        static String netherWartMaxCount = "Max count for nether wart to drop upon defeat.";

        static String disablePhantomDrops = "Disables the special item drops from phantoms upon defeat.";
        static String chanceToDropExtraPhantomMembranes = "The chance to drop extra phantom membranes upon defeat.";
        static String phantomMembraneMaxCount = "Max count for extra phantom membranes to drop upon defeat.";

        static String disableRavagerDrops = "Disables the special item drops from ravagers upon defeat.";
        static String chanceToDropZincNugget = "The chance to drop zinc nuggets upon defeat.";
        static String zincNuggetMaxCount = "Max count for zinc nuggets to drop upon defeat.";

        static String disableSnifferDrops = "Disables the special item drops from sniffers upon defeat.";
        static String chanceToDropSnifferFluff = "The chance to drop sniffer fluff upon defeat.";
        static String snifferFluffMaxCount = "Max count for sniffer fluff to drop upon defeat.";

        static String disableCreeperDrops = "Disables the special item drops from creepers upon defeat.";
        static String chanceToDropExtraGunpowder = "The chance to drop extra gunpowder upon defeat.";
        static String extraGunpowderMaxCount = "Max count for extra gunpowder to drop upon defeat.";

        static String disableGhastDrops = "Disables the special item drops from ghasts upon defeat.";
        static String chanceToDropExtraGhastTear = "The chance to drop extra ghast tears upon defeat.";
        static String extraGhastTearMaxCount = "Max count for extra ghast tears to drop upon defeat.";

        static String disableBreezeDrops = "Disables the special item drops from breezes upon defeat.";
        static String chanceToDropExtraBreezeRod = "The chance to drop extra breeze rods upon defeat.";
        static String extraBreezeRodMaxCount = "Max count for extra breeze rods to drop upon defeat.";

        static String disableBlazeDrops = "Disables the special item drops from blazes upon defeat.";
        static String chanceToDropExtraBlazeRod = "The chance to drop extra ghast tears upon defeat.";
        static String extraBlazeRodMaxCount = "Max count for extra ghast tears to drop upon defeat.";

        static String disableEndermanDrops = "Disables the special item drops from endermen upon defeat.";
        static String chanceToDropExtraEnderPearl = "The chance to drop extra ghast tears upon defeat.";
        static String extraEnderPearlMaxCount = "Max count for extra ghast tears to drop upon defeat.";

        static String disableAllSquidDrops = "Disables the special item drops from all squids upon defeat.";
        static String disableSquidDrops = "Disables the special item drops from squids upon defeat.";
        static String chanceToDropExtraInkSac = "The chance to drop extra ink sacs upon defeat.";
        static String extraInkSacMaxCount = "Max count for extra ink sacs to drop upon defeat.";
        //
        static String disableGlowSquidDrops = "Disables the special item drops from glow squids upon defeat.";
        static String chanceToDropExtraGlowInkSac = "The chance to drop extra glow ink sacs upon defeat.";
        static String extraGlowInkSacMaxCount = "Max count for extra glow ink sacs to drop upon defeat.";

        static String disableGelatinousCreatureDrops = "Disables the special item drops from mobs tagged as gelatinous creatures upon defeat.";
        static String chanceToDropElasticStrand = "The chance to drop elastic strands upon defeat. This includes fiery elastic strands.";
        static String elasticStrandMaxCount = "Max count for elastic strands to drop upon defeat. This includes fiery elastic strands.";
        //
        static String disableSlimeDrops = "Disables the special item drops from slimes upon defeat.";
        static String chanceToDropExtraSlimeBalls = "The chance to drop extra slime balls upon defeat.";
        static String slimeBallMaxCount = "Max count for extra slime balls to drop upon defeat.";
        //
        static String disableMagmaCubeDrops = "Disables the special item drops from magma cubes upon defeat.";
        static String chanceToDropExtraMagmaCream = "The chance to drop extra magma cream upon defeat.";
        static String magmaCreamMaxCount = "Max count for extra magma cream to drop upon defeat.";

        static String disableAllSpiderDrops = "Disables the special item drops from mobs tagged as spiders upon defeat.";
        static String chanceToDropExtraString = "The chance to drop extra string upon defeat.";
        static String extraStringMaxCount = "Max count for extra string to drop upon defeat.";
        //
        static String disableSpiderDrops = "Disables the special item drops from spiders upon defeat.";
        //
        static String disableCaveSpiderDrops = "Disables the special item drops from cave spiders upon defeat.";

        static String disableGuardianDrops = "Disables the special item drops from mobs tagged as some variation of a guardian upon defeat.";
        static String chanceToDropExtraPrismarineShards = "The chance to drop extra prismarine shards upon defeat.";
        static String prismarineShardMaxCount = "Max count for extra prismarine shards to drop upon defeat.";
        static String chanceToDropExtraPrismarineCrystals = "The chance to drop extra prismarine crystals upon defeat.";
        static String prismarineCrystalsMaxCount = "Max count for extra prismarine crystals to drop upon defeat.";
        //
        static String disableLesserGuardianDrops = "Disables the special item drops from regular guardians upon defeat.";
        static String chanceToDropGuardianSpike = "The chance to drop guardian spikes upon defeat.";
        static String guardianSpikeMaxCount = "Max count for guardian spikes to drop upon defeat.";
        //
        static String disableElderGuardianDrops = "Disables the special item drops from elder guardians upon defeat.";
        static String chanceToDropElderGuardianSpike = "The chance to drop elder guardian spikes upon defeat.";
        static String elderGuardianSpikeMaxCount = "Max count for elder guardian spikes to drop upon defeat.";
    }
}
