package net.dakotapride.creategarnished.registry;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

public enum CreateGarnishedStoneTypes {
    PORPHYRY(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).sound(SoundType.DEEPSLATE)
            .destroyTime(0.75f).instrument(NoteBlockInstrument.DIDGERIDOO)),


    ;

    public final BlockEntry<Block> base;

    CreateGarnishedStoneTypes(BlockBehaviour.Properties properties) {
        String id = name().toLowerCase(Locale.ROOT);

        base = CreateGarnished.REGISTRATE.block(id, Block::new)
                .properties(properties1 -> properties)
                .simpleItem()
                .register();
    }

    public BlockEntry<Block> getBaseBlock() {
        return base;
    }

    public static void register() {}
}
