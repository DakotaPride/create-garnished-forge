package net.dakotapride.garnished.registry;

import net.minecraft.world.level.GameRules;

public class GarnishedGamerules {
    public static final GameRules.Key<GameRules.BooleanValue> RULE_LIQUID_GARNISH_SOURCE_CONVERSION = GameRules.register(
            "createGarnished-liquidGarnishSourceConversion", GameRules.Category.UPDATES, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> RULE_APPLE_CIDER_SOURCE_CONVERSION = GameRules.register(
            "createGarnished-appleCiderSourceConversion", GameRules.Category.UPDATES, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> RULE_PEANUT_OIL_SOURCE_CONVERSION = GameRules.register(
            "createGarnished-peanutOilSourceConversion", GameRules.Category.UPDATES, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> RULE_CASHEW_MIXTURE_SOURCE_CONVERSION = GameRules.register(
            "createGarnished-cashewMixtureSourceConversion", GameRules.Category.UPDATES, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> RULE_MASTIC_FLUIDS_SOURCE_CONVERSION = GameRules.register(
            "createGarnished-masticFluidsSourceConversion", GameRules.Category.UPDATES, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DRAGON_BREATH_SOURCE_CONVERSION = GameRules.register(
            "createGarnished-dragonBreathSourceConversion", GameRules.Category.UPDATES, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> RULE_SWEET_TEA_SOURCE_CONVERSION = GameRules.register(
            "createGarnished-sweetTeaSourceConversion", GameRules.Category.UPDATES, GameRules.BooleanValue.create(false));

    public static void register() {}
}
