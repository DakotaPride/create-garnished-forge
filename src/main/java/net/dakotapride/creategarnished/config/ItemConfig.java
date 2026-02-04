package net.dakotapride.creategarnished.config;

import net.createmod.catnip.config.ConfigBase;

@SuppressWarnings("unused")
public class ItemConfig extends ConfigBase {
    public final ConfigGroup biomeSpecificEffectsFromConsumption = group(0, "biomeSpecificEffectsFromConsumption", "Options for enabling/disabling biome specific effects.");
    public ConfigBool provideSpecialEffectsFromBiome = b(true, "provideSpecialEffectsFromBiome", Comments.provideSpecialEffectsFromBiome);
    public ConfigInt statusEffectAmplifier = i(1, 0, 255, "statusEffectAmplifier", "The amplifier of the given status effects");
    public ConfigInt statusEffectDurationInSeconds = i(120, 0, 1000000, "statusEffectDurationInSeconds", "The duration of the given status effects in seconds.");
    public ConfigBool isAmbient = b(false, "isAmbient", "Determines if the status effects in question are ambient.");
    public ConfigBool isVisible = b(false, "isVisible", "Determines if the status effects in question are visible (particles).");
    public ConfigBool showIcon = b(true, "showIcon", "Determines if the status effects' icons are viewable without the player's inventory open.");

    @Override
    public String getName() {
        return "item";
    }

    private static class Comments {
        static String provideSpecialEffectsFromBiome = "Controls whether or not you get status effects from eating foods by being within a certain biome.";
    }
}
