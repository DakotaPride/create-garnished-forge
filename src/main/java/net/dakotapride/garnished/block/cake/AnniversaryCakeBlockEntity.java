package net.dakotapride.garnished.block.cake;

import net.dakotapride.garnished.registry.GarnishedBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AnniversaryCakeBlockEntity extends BlockEntity {
    public AnniversaryCakeBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(GarnishedBlockEntities.CAKE.get(), pWorldPosition, pBlockState);
    }
}
