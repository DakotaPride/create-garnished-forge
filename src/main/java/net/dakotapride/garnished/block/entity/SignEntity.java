package net.dakotapride.garnished.block.entity;

import net.dakotapride.garnished.registry.GarnishedBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SignEntity extends SignBlockEntity {

    public SignEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return GarnishedBlockEntities.SIGN.get();
    }
}