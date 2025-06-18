package net.dakotapride.creategarnished.config;

import net.createmod.catnip.config.ConfigBase;

public class ServerConfig extends ConfigBase {
    public final StoneGenerationConfig stoneGeneration = nested(0, StoneGenerationConfig::new,
            "Control Stone Generation within Create: Garnished Reworked");
    public final BlockConfig block = nested(0, BlockConfig::new,
            "Control certain properties of blocks within Create: Garnished Reworked");
    public final EntityConfig entity = nested(0, EntityConfig::new,
            "Control how entities interact with content from Create: Garnished Reworked");

    @Override
    public String getName() {
        return "server";
    }
}
