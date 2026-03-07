package net.dakotapride.garnished.config;

import net.createmod.catnip.config.ConfigBase;

public class CommonConfig extends ConfigBase {
    public final WorldGenConfig worldgen = nested(0, WorldGenConfig::new,
            "Control world generation to your liking (mostly)");

    @Override
    public String getName() {
        return "common";
    }
}