package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.block.CreateGarnishedStoneType;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

public enum CreateGarnishedStoneTypes {
    PORPHYRY(CreateGarnishedStoneType.getDefaultBehaviour().instrument(NoteBlockInstrument.DIDGERIDOO).mapColor(MapColor.TERRACOTTA_RED)),


    ;

    public final CreateGarnishedStoneType stoneType;

    CreateGarnishedStoneTypes() {
        String id = name().toLowerCase(Locale.ROOT);

        stoneType = new CreateGarnishedStoneType(id);
    }

    CreateGarnishedStoneTypes(BlockBehaviour.Properties properties) {
        String id = name().toLowerCase(Locale.ROOT);

        stoneType = new CreateGarnishedStoneType(id);
        CreateGarnishedStoneType.defaultBehaviour = properties;
    }

    public CreateGarnishedStoneType getStoneType() {
        return stoneType;
    }

    public static void register() {}
}
