package net.dakotapride.garnished.block.sepia;

import net.dakotapride.garnished.registry.GarnishedBlockEntities;
import net.dakotapride.garnished.registry.GarnishedWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class SepiaSignBlock extends StandingSignBlock {

    public SepiaSignBlock(Properties properties) {
        super(properties, GarnishedWoodTypes.SEPIA);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return GarnishedBlockEntities.SIGN.get().create(pos, state);
    }

}