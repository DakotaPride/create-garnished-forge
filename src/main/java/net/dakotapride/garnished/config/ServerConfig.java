package net.dakotapride.garnished.config;

import net.createmod.catnip.config.ConfigBase;

public class ServerConfig extends ConfigBase {
    public final BlockConfig block = nested(0, BlockConfig::new,
            "Control certain properties of blocks to your liking (mostly)");

    @Override
    public String getName() {
        return "server";
    }
}