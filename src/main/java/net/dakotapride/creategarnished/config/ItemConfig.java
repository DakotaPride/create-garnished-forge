package net.dakotapride.creategarnished.config;

import net.createmod.catnip.config.ConfigBase;

public class ItemConfig extends ConfigBase {
    public ConfigBool tameUponFlapjackAdvancement = b(true, "tameUponFlapjackAdvancement", Comments.tameUponFlapjackAdvancement);

    @Override
    public String getName() {
        return "item";
    }

    private static class Comments {
        static String tameUponFlapjackAdvancement = "Whether or not a parrot will be tamed upon achieving the 'Rest in Peace Birb' advancement.";
    }
}
