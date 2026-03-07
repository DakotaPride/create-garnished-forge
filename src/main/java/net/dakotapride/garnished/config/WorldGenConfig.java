package net.dakotapride.garnished.config;

import net.createmod.catnip.config.ConfigBase;

public class WorldGenConfig extends ConfigBase {
	public final ConfigBool disable = b(false, "disableWorldGen", Comments.disable);

	public final ConfigGroup overworldGroup = group(1, "Overworld", "");
	public final ConfigBool disableNutTrees = b(false, "disableNutTrees", Comments.disableNutTrees);
	public final ConfigBool disableKelpVariants = b(false, "disableKelpVariants", Comments.disableKelpVariants);
	public final ConfigBool disableVoltaicSeaGrass = b(false, "disableVoltaicSeaGrass", Comments.disableVoltaicSeaGrass);
	public final ConfigBool disableRitualisticStoneClusters = b(false, "disableRitualisticStoneClusters", Comments.disableRitualisticStoneClusters);

	public final ConfigGroup netherGroup = group(1, "The Nether", "");
	public final ConfigBool disableSepiaFungusPlant = b(false, "disableSepiaFungusPlant", Comments.disableSepiaFungusPlant);
	public final ConfigBool disableSepiaFungusTree = b(false, "disableSepiaFungusTree", Comments.disableSepiaFungusTree);
	public final ConfigBool disableSoulRoots = b(false, "disableSoulRoots", Comments.disableSoulRoots);
	public final ConfigBool disableIncandescentLily = b(false, "disableIncandescentLily", Comments.disableIncandescentLily);
	public final ConfigBool disablePansophicalDaisy = b(false, "disablePansophicalDaisy", Comments.disablePansophicalDaisy);
	public final ConfigBool disableSorrowfulLichen = b(false, "disableSorrowfulLichen", Comments.disableSorrowfulLichen);

	public final ConfigGroup endGroup = group(1, "The End", "");
	public final ConfigBool disableAureateShrub = b(false, "disableAureateShrub", Comments.disableAureateShrub);
	public final ConfigBool disableMiscEndVegetation = b(false, "disableMiscEndVegetation", Comments.disableMiscEndVegetation);

	@Override
	public String getName() {
		return "worldgen";
	}

	private static class Comments {
		static String disable = "Prevents all worldgen added by Create: Garnished from taking effect.";
		static String disableNutTrees = "Prevents nut trees from being generated in-world.";
		static String disableKelpVariants = "Prevents dulse and vermilion kelp from being generated in-world.";
		static String disableVoltaicSeaGrass = "Prevents voltaic sea grass from being generated in-world.";
		static String disableRitualisticStoneClusters = "Prevents ritualistic stone clusters from being generated in-world.";

		static String disableSepiaFungusPlant = "Prevents sepia fungus from being generated in-world.";
		static String disableSepiaFungusTree = "Prevents grown sepia fungus from being generated in-world.";
		static String disableSoulRoots = "Prevents soul roots from being generated in-world.";
		static String disableIncandescentLily = "Prevents incandescent lilies from being generated in-world.";
		static String disablePansophicalDaisy = "Prevents pansophical daisies from being generated in-world.";
		static String disableSorrowfulLichen = "Prevents sorrowful lichen from being generated in-world.";

		static String disableAureateShrub = "Prevents aureate shrubs from being generated in-world.";
		static String disableMiscEndVegetation = "Prevents other end-related vegetation from being generated in-world.";
	}

}