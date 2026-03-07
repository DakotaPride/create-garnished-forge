package net.dakotapride.garnished.config;

import net.createmod.catnip.config.ConfigBase;

public class BlockConfig extends ConfigBase {
    public ConfigGroup voltaicSeaGrass = group(1, "Voltaic Sea Grass", "");
    public ConfigBool voltaicSeaGrassDoesDamageToNonPlayerEntities = b(true, "voltaicSeaGrassDoesDamageToNonPlayerEntities", Comments.voltaicSeaGrassDoesDamageToNonPlayerEntities);
    public ConfigBool voltaicSeaGrassDoesDamageToPlayers = b(true, "voltaicSeaGrassDoesDamageToPlayers", Comments.voltaicSeaGrassDoesDamageToPlayers);
    public ConfigFloat nonPlayerDamage = f(2.0F, 1.0F, "nonPlayerDamage", Comments.nonPlayerDamage);
    public ConfigFloat playerDamage = f(2.0F, 1.0F, "playerDamage", Comments.playerDamage);

    public ConfigGroup masticBlocks = group(1, "Mastic Blocks", "");
    public ConfigBool hasFriction = b(true, "hasFriction", Comments.hasFriction);
    public ConfigFloat friction = f(0.8F, 0.1F, 1.0F, "friction", Comments.friction);

    public ConfigGroup abyssalStone = group(1, "Abyssal Stone", "");
    public ConfigBool providesBlindness = b(true, "providesBlindness", Comments.providesBlindness);
    public ConfigInt blindnessDuration = i(15, 1, "blindnessDurationSeconds", Comments.blindnessDuration);

    public ConfigGroup unstableStone = group(1, "Unstable Stone", "");
    public ConfigBool providesSpeed = b(true, "providesSpeed", Comments.providesSpeed);
    public ConfigInt speedDuration = i(15, 1, "speedDurationSeconds", Comments.speedDuration);
    public ConfigInt speedAmplifier = i(1, 0, 255, "speedAmplifier", Comments.speedAmplifier);

    public ConfigGroup wyvernStone = group(1, "Wyvern Stone", "");
    public ConfigBool providesRandomEffects = b(true, "providesRandomEffects", Comments.providesRandomEffects);
    public ConfigInt effectsDuration = i(15, 1, "effectsDurationSeconds", Comments.effectsDuration);
    public ConfigInt effectsAmplifier = i(0, 0, 255, "effectsAmplifier", Comments.effectsAmplifier);

    public ConfigGroup numbingParchmentBlocks = group(1, "Numbing Parchment Blocks", "");
    public ConfigBool providesSlowness = b(true, "providesSlowness", Comments.providesSlowness);
    public ConfigInt slownessDuration = i(15, 1, "slownessDurationSeconds", Comments.slownessDuration);
    public ConfigInt slownessAmplifier = i(1, 0, 255, "slownessAmplifier", Comments.slownessAmplifier);

    @Override
    public String getName() {
        return "block";
    }

    private static class Comments {
        static String voltaicSeaGrassDoesDamageToNonPlayerEntities = "Controls whether or not voltaic sea grass deals damage to non-player entities.";
        static String voltaicSeaGrassDoesDamageToPlayers = "Controls whether or not voltaic sea grass deals damage to players.";
        static String nonPlayerDamage = "The amount of damage dealt to non-player entities when within voltaic sea grass.";
        static String playerDamage = "The amount of damage dealt to players when within voltaic sea grass.";

        static String hasFriction = "Controls whether or not blocks of mastic resin have friction.";
        static String friction = "Controls the friction value utilised when determining how blocks of mastic resin interact with entities atop of them.";

        static String providesBlindness = "Controls whether or not abyssal stone provides the blindness effect when standing atop of it.";
        static String blindnessDuration = "Controls the duration of blindness inflicted if standing on top of abyssal stone.";

        static String providesSpeed = "Controls whether or not abyssal stone provides the blindness effect when standing atop of it.";
        static String speedDuration = "Controls the duration of blindness inflicted if standing on top of abyssal stone.";
        static String speedAmplifier = "Controls the duration of blindness inflicted if standing on top of abyssal stone.";

        static String providesRandomEffects = "Controls whether or not unstable stone provides random effects when standing atop of it.";
        static String effectsDuration = "Controls the duration of the random effect inflicted if standing on top of unstable stone.";
        static String effectsAmplifier = "Controls the amplifier of the random effect inflicted if standing on top of unstable stone.";

        static String providesSlowness = "Controls whether or not numbing parchment blocks provides slowness when standing atop of it.";
        static String slownessDuration = "Controls the duration of slowness while standing atop numbing parchment blocks.";
        static String slownessAmplifier = "Controls the amplifier of slowness while standing atop numbing parchment blocks.";
    }
}