package net.dakotapride.garnished.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class AbyssalStoneBlock extends Block {
    public AbyssalStoneBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        SpecialEffectsBlock.Abyssal.getParticles(state, level, pos, random);
    }

    @Override
    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        SpecialEffectsBlock.Abyssal.getEffects(level, pos, state, entity);

        super.stepOn(level, pos, state, entity);
    }
}
