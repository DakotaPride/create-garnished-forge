package net.dakotapride.garnished.block.sepia;

import net.dakotapride.garnished.registry.GarnishedBlockEntities;
import net.dakotapride.garnished.registry.GarnishedWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class SepiaWallSignBlock extends WallSignBlock {

    public SepiaWallSignBlock(Properties properties) {
        super(properties, GarnishedWoodTypes.SEPIA);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return GarnishedBlockEntities.SIGN.get().create(pos, state);
    }

}