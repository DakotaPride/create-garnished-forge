package net.dakotapride.garnished.block.nut;

import net.dakotapride.garnished.registry.GarnishedBlockEntities;
import net.dakotapride.garnished.registry.GarnishedWoodType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class NutWallHangingSignBlock extends WallHangingSignBlock {

    public NutWallHangingSignBlock(Properties properties) {
        super(properties, GarnishedWoodType.NUT);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return GarnishedBlockEntities.HANGING_SIGN.get().create(pos, state);
    }

}