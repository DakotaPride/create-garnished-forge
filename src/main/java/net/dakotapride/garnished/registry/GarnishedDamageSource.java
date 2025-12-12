package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class GarnishedDamageSource {
	public static final ResourceKey<DamageType> MULCH_MUNCHING = create("mulch_munching");
	public static final ResourceKey<DamageType> FAN_FREEZING = create("fan_freezing");
	public static final ResourceKey<DamageType> LEECHING = create("leeching");
	public static final ResourceKey<DamageType> NUT_ACHE = create("nut_ache");

	private static ResourceKey<DamageType> create(String name) {
		return ResourceKey.create(Registries.DAMAGE_TYPE, CreateGarnished.asResource(name));
	}
}
