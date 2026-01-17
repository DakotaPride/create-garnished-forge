package net.dakotapride.creategarnished.config;

import net.createmod.catnip.config.ConfigBase;

public class EntityConfig extends ConfigBase {
    public ConfigBool enableNutAllergy = b(true, "enableNutAllergy", Comments.enableNutAllergy);
    public ConfigBool provideSpecialEffectsFromBiome = b(true, "provideSpecialEffectsFromBiome", Comments.provideSpecialEffectsFromBiome);

    public ConfigFloat nutAllergyDamageAmount = f(2.0F, 1.0F, 64.0F, "nutAllergyDamageAmount", Comments.nutAllergyDamageAmount);
    public ConfigFloat elvenSweetBerryBushPrickDamageAmount = f(0.5F, 0.0F, 64.0F, "elvenSweetBerryBushPrickDamageAmount", Comments.elvenSweetBerryBushPrickDamageAmount);

    public ConfigBool squirrelsPickUpDroppedFoods = b(false, "squirrelsPickUpDroppedFoods", Comments.squirrelsPickUpDroppedFoods);

    public ConfigBool enableElderGuardianConversion = b(false, "enableElderGuardianConversion", Comments.enableElderGuardianConversion);
    public ConfigBool enableMooshroomConversion = b(true, "enableMooshroomConversion", Comments.enableMooshroomConversion);

    @Override
    public String getName() {
        return "entity";
    }

    private static class Comments {
        static String enableNutAllergy = "Controls whether or not you can experience a Nut Allergy when submerged in the proper fluid.";
        static String provideSpecialEffectsFromBiome = "Controls whether or not you get status effects from eating foods by being within a certain biome.";

        static String nutAllergyDamageAmount = "Controls the amount of damage taken from eating a nut-based food whilst under the effects of a Nut Allergy.";
        static String elvenSweetBerryBushPrickDamageAmount = "Controls the amount of damage taken from walking within an Elven Sweet Berry Bush.";

        static String squirrelsPickUpDroppedFoods = "[DISABLED BY DEFAULT DUE TO MSPT/TPS ISSUES] Controls whether the squirrel entity can pick up and consume dropped food items.";

        static String enableElderGuardianConversion = "Allows for Guardians to be haunted into Elder Guardians.";
        static String enableMooshroomConversion = "Allows for Cows to be haunted into Mooshrooms.";
    }
}
