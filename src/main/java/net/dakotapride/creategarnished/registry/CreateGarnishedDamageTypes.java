package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public class CreateGarnishedDamageTypes {
    public static final ResourceKey<DamageType>
            ELVEN_SWEET_BERRY_BUSH = key("elven_sweet_berry_bush");

    private static ResourceKey<DamageType> key(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, CreateGarnished.asResource(name));
    }
}
