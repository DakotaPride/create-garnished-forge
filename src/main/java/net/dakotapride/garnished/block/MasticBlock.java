package net.dakotapride.garnished.block;

import net.dakotapride.garnished.GarnishedConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class MasticBlock extends Block {
    public MasticBlock(Properties properties) {
        super(properties);
    }

    @Override
    public float getFriction(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity) {
        if (GarnishedConfigs.server().block.hasFriction.get())
            return super.getFriction(state, level, pos, entity);
        return GarnishedConfigs.server().block.friction.getF();
    }
}
