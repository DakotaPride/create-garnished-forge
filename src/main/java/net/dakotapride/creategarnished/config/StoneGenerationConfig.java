package net.dakotapride.creategarnished.config;

import net.createmod.catnip.config.ConfigBase;

public class StoneGenerationConfig extends ConfigBase {
    public ConfigBase.ConfigBool allowCrimsiteFluidInteraction = b(false, "allowCrimsiteFluidInteraction", Comments.allowCrimsiteFluidInteraction);
    public ConfigBase.ConfigBool allowDripstoneFluidInteraction = b(true, "allowDripstoneFluidInteraction", Comments.allowDripstoneFluidInteraction);
    public ConfigBase.ConfigBool allowGraniteFluidInteraction = b(true, "allowGraniteFluidInteraction", Comments.allowGraniteFluidInteraction);

    @Override
    public String getName() {
        return "stone-generation";
    }

    private static class Comments {
        static String allowCrimsiteFluidInteraction = "Controls whether or not Crimsite can be generated via Lava Source + Flowing Birch Syrup. If set to false, it will simply generate Porphyry as if both fluids were flowing.";
        static String allowDripstoneFluidInteraction = "Controls whether or not Dripstone is the fluid interaction between Flowing Lava + Flowing Peanut Butter. If set to false, it will default to the cobblestone/stone fluid interaction that you may already be familiar with.";
        static String allowGraniteFluidInteraction = "Controls whether or not Granite is the fluid interaction between Flowing Lava + Flowing Almond Extract. If set to false, it will default to the cobblestone/stone fluid interaction that you may already be familiar with.";
    }
}
