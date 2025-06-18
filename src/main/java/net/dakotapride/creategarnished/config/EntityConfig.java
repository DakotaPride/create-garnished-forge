package net.dakotapride.creategarnished.config;

import net.createmod.catnip.config.ConfigBase;

public class EntityConfig extends ConfigBase {
    public ConfigBool enableNutAllergy = b(true, "enableNutAllergy", Comments.enableNutAllergy);
    public ConfigBool provideSpecialEffectsFromBiome = b(true, "provideSpecialEffectsFromBiome", Comments.provideSpecialEffectsFromBiome);

    @Override
    public String getName() {
        return "entity";
    }

    private static class Comments {
        static String enableNutAllergy = "Controls whether or not you can experience a Nut Allergy when submerged in the proper fluid.";
        static String provideSpecialEffectsFromBiome = "Controls whether or not you get status effects from eating foods by being within a certain biome.";
    }
}
