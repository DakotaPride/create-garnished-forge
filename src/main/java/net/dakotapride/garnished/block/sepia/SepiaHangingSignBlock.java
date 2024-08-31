package net.dakotapride.garnished.block.sepia;

import net.dakotapride.garnished.registry.GarnishedBlockEntities;
import net.dakotapride.garnished.registry.GarnishedWoodType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SepiaHangingSignBlock extends CeilingHangingSignBlock {

    public SepiaHangingSignBlock(Properties properties) {
        super(properties, GarnishedWoodType.SEPIA);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return GarnishedBlockEntities.HANGING_SIGN.get().create(pos, state);
    }

}