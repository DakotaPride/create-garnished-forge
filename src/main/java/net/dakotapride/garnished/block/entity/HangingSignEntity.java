package net.dakotapride.garnished.block.entity;

import net.dakotapride.garnished.registry.GarnishedBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class HangingSignEntity extends HangingSignBlockEntity {

    public HangingSignEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return GarnishedBlockEntities.HANGING_SIGN.get();
    }

}
