package net.dakotapride.creategarnished.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;

public class CreateGarnishedDamageSources {
    public static DamageSource elvenSweetBerryBush(Level level) {
        return source(CreateGarnishedDamageTypes.ELVEN_SWEET_BERRY_BUSH, level);
    }
    public static DamageSource nutAllergy(Level level) {
        return source(CreateGarnishedDamageTypes.NUT_ALLERGY, level);
    }

    private static DamageSource source(ResourceKey<DamageType> key, LevelReader level) {
        Registry<DamageType> registry = level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE);
        return new DamageSource(registry.getHolderOrThrow(key));
    }
}
