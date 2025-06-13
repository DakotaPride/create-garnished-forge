package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public class CreateGarnishedDamageTypes {
    public static final ResourceKey<DamageType>
            ELVEN_SWEET_BERRY_BUSH = key("elven_sweet_berry_bush");
    public static final ResourceKey<DamageType>
            NUT_ALLERGY = key("nut_allergy");

    private static ResourceKey<DamageType> key(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, CreateGarnished.asResource(name));
    }
}
