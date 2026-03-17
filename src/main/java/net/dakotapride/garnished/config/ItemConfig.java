package net.dakotapride.garnished.config;

import net.createmod.catnip.config.ConfigBase;

public class ItemConfig extends ConfigBase {
    public ConfigBool conditionalEffectsUponConsumption = b(true, "conditionalEffectsUponConsumption", Comments.conditionalEffectsUponConsumption);


    @Override
    public String getName() {
        return "item";
    }

    private static class Comments {
        static String conditionalEffectsUponConsumption = "Controls whether or not special status effects are provided upon consuming certain foods.";
    }
}