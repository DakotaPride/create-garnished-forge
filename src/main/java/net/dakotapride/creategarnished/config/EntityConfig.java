package net.dakotapride.creategarnished.config;

import net.createmod.catnip.config.ConfigBase;

public class EntityConfig extends ConfigBase {
    public ConfigBool enableNutAllergy = b(true, "enableNutAllergy", Comments.enableNutAllergy);

    public ConfigBool tameUponFlapjackAdvancement = b(true, "tameUponFlapjackAdvancement", Comments.tameUponFlapjackAdvancement);

    public ConfigFloat nutAllergyDamageAmount = f(2.0F, 1.0F, 64.0F, "nutAllergyDamageAmount", Comments.nutAllergyDamageAmount);
    public ConfigFloat elvenSweetBerryBushPrickDamageAmount = f(0.5F, 0.0F, 64.0F, "elvenSweetBerryBushPrickDamageAmount", Comments.elvenSweetBerryBushPrickDamageAmount);

    public ConfigBool squirrelsPickUpDroppedFoods = b(false, "squirrelsPickUpDroppedFoods", Comments.squirrelsPickUpDroppedFoods);
    public ConfigBool squirrelsAttemptToPlantNutCrops = b(false, "squirrelsAttemptToPlantNutCrops", Comments.squirrelsAttemptToPlantNutCrops);
    public ConfigInt squirrelItemSearchRadius = i(0, 4, 1024, "squirrelItemSearchRadius", Comments.squirrelItemSearchRadius);
    public ConfigInt squirrelBlockSearchRadius = i(0, 24, 1024, "squirrelBlockSearchRadius", Comments.squirrelBlockSearchRadius);

    public ConfigBool enableElderGuardianConversion = b(false, "enableElderGuardianConversion", Comments.enableElderGuardianConversion);
    public ConfigBool enableMooshroomConversion = b(true, "enableMooshroomConversion", Comments.enableMooshroomConversion);

    @Override
    public String getName() {
        return "entity";
    }

    private static class Comments {
        static String enableNutAllergy = "Controls whether or not you can experience a Nut Allergy when submerged in the proper fluid.";

        static String tameUponFlapjackAdvancement = "Whether or not a parrot will be tamed upon achieving the 'Rest in Peace Birb' advancement.";

        static String nutAllergyDamageAmount = "Controls the amount of damage taken from eating a nut-based food whilst under the effects of a Nut Allergy.";
        static String elvenSweetBerryBushPrickDamageAmount = "Controls the amount of damage taken from walking within an Elven Sweet Berry Bush.";

        static String squirrelsPickUpDroppedFoods = "[DISABLED BY DEFAULT DUE TO MSPT/TPS ISSUES] Controls whether the squirrel entity can pick up and consume dropped food items.";
        static String squirrelsAttemptToPlantNutCrops = "(Ineffective if 'squirrelsPickUpDroppedFoods' is disabled) Controls whether the squirrel entity can replant nut crops/saplings.";
        static String squirrelItemSearchRadius = "The distance that squirrels will search for items to pick up.";
        static String squirrelBlockSearchRadius = "The distance that squirrels will search for acceptable farmland/ground to plant nuts.";

        static String enableElderGuardianConversion = "Allows for Guardians to be haunted into Elder Guardians.";
        static String enableMooshroomConversion = "Allows for Cows to be haunted into Mooshrooms.";
    }
}
