package net.dakotapride.garnished.block.nut;

import net.dakotapride.garnished.registry.GarnishedBlockEntities;
import net.dakotapride.garnished.registry.GarnishedWoodType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class NutSignBlock extends StandingSignBlock {

    public NutSignBlock(Properties properties) {
        super(properties, GarnishedWoodType.NUT);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return GarnishedBlockEntities.SIGN.get().create(pos, state);
    }

}