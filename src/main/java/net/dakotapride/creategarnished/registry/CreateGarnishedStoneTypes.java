package net.dakotapride.creategarnished.registry;

import com.simibubi.create.content.decoration.palettes.ConnectedPillarBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.dakotapride.creategarnished.block.CreateGarnishedStoneType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

public enum CreateGarnishedStoneTypes {
    PORPHYRY(CreateGarnishedStoneType.getDefaultBehaviour().instrument(NoteBlockInstrument.DIDGERIDOO).mapColor(MapColor.TERRACOTTA_RED),
            CreateGarnishedBlocks.LAYERED_PORPHYRY, CreateGarnishedBlocks.PORPHYRY_PILLAR),


    ;

    public final CreateGarnishedStoneType stoneType;

    CreateGarnishedStoneTypes(BlockEntry<Block> layered, BlockEntry<ConnectedPillarBlock> pillar) {
        String id = name().toLowerCase(Locale.ROOT);

        stoneType = new CreateGarnishedStoneType(id, layered, pillar);
    }

    CreateGarnishedStoneTypes(BlockBehaviour.Properties properties, BlockEntry<Block> layered, BlockEntry<ConnectedPillarBlock> pillar) {
        String id = name().toLowerCase(Locale.ROOT);

        stoneType = new CreateGarnishedStoneType(id, layered, pillar);
        CreateGarnishedStoneType.defaultBehaviour = properties;
    }

    public CreateGarnishedStoneType getStoneType() {
        return stoneType;
    }

    public static void register() {}
}
