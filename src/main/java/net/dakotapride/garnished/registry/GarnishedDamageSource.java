package net.dakotapride.garnished.registry;

import net.minecraft.world.damagesource.DamageSource;

public class GarnishedDamageSource {

    public static final DamageSource MULCH_MUNCHING = (new DamageSource("garnished.mulch_munching")).bypassArmor().setIsFire();
    public static final DamageSource FAN_FREEZING = (new DamageSource("garnished.fan_freezing")).bypassArmor().setIsFire();
    public static final DamageSource LEECHING = (new DamageSource("garnished.leeching")).bypassArmor().setIsFire();

}
