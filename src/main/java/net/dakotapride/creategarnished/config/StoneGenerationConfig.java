package net.dakotapride.creategarnished.config;

import net.createmod.catnip.config.ConfigBase;

public class StoneGenerationConfig extends ConfigBase {
    public ConfigBase.ConfigBool allowCrimsiteFluidInteraction = b(false, "allowCrimsiteFluidInteraction", Comments.allowCrimsiteFluidInteraction);

    @Override
    public String getName() {
        return "stone-generation";
    }

    private static class Comments {
        static String allowCrimsiteFluidInteraction = "Controls whether or not Crimsite can be generated via Lava Source + Flowing Birch Syrup.";
    }
}
