package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.block.CreateGarnishedStoneType;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

public enum CreateGarnishedStoneTypes {
    PORPHYRY(CreateGarnishedStoneType.getDefaultBehaviour().instrument(NoteBlockInstrument.DIDGERIDOO).mapColor(MapColor.TERRACOTTA_RED),
            CreateGarnishedSpriteShifts.LAYERED_PORPHYRY_PROVIDER, CreateGarnishedSpriteShifts.PORPHYRY_PILLAR_PROVIDER),


    ;

    public final CreateGarnishedStoneType stoneType;

    CreateGarnishedStoneTypes(CreateGarnishedSpriteShifts.CTModelProvider layered, CreateGarnishedSpriteShifts.CTModelProvider pillar) {
        String id = name().toLowerCase(Locale.ROOT);

        stoneType = new CreateGarnishedStoneType(id, layered, pillar);
    }

    CreateGarnishedStoneTypes(BlockBehaviour.Properties properties, CreateGarnishedSpriteShifts.CTModelProvider layered, CreateGarnishedSpriteShifts.CTModelProvider pillar) {
        String id = name().toLowerCase(Locale.ROOT);

        stoneType = new CreateGarnishedStoneType(id, layered, pillar);
        CreateGarnishedStoneType.defaultBehaviour = properties;
    }

    public CreateGarnishedStoneType getStoneType() {
        return stoneType;
    }

    public static void register() {}
}
