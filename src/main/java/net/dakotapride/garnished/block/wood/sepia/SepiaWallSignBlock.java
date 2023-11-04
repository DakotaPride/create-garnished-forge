package net.dakotapride.garnished.block.wood.sepia;

import net.dakotapride.garnished.registry.GarnishedBlockEntities;
import net.dakotapride.garnished.registry.GarnishedWoodType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SepiaWallSignBlock extends WallSignBlock {

    public SepiaWallSignBlock(Properties properties) {
        super(properties, GarnishedWoodType.SEPIA);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return GarnishedBlockEntities.SIGN.get().create(pos, state);
    }

}