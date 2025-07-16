package net.dakotapride.creategarnished.registry;

import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class CreateGarnishedTreeGrower {
    public static final TreeGrower PINE_NUT = new TreeGrower("pine_nut", 0.5F,
            Optional.empty(), Optional.empty(),
            Optional.of(CreateGarnishedFeatureKeys.PINE_NUT), Optional.empty(), Optional.empty(), Optional.empty());
    public static final TreeGrower HAZELNUT = new TreeGrower("hazelnut", 0.5F,
            Optional.empty(), Optional.empty(),
            Optional.of(CreateGarnishedFeatureKeys.HAZELNUT), Optional.empty(), Optional.empty(), Optional.empty());
    public static final TreeGrower ALMOND = new TreeGrower("almond", 0.5F,
            Optional.empty(), Optional.empty(),
            Optional.of(CreateGarnishedFeatureKeys.ALMOND), Optional.empty(), Optional.empty(), Optional.empty());
}