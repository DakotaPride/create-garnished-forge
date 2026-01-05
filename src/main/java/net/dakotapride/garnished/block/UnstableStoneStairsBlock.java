package net.dakotapride.garnished.block;

import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.dakotapride.garnished.registry.GarnishedPaletteStoneTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class UnstableStoneStairsBlock extends StairBlock {
    public UnstableStoneStairsBlock(Properties pProperties) {
        super(() -> GarnishedPaletteStoneTypes.UNSTABLE_STONE.getBlock().get().defaultBlockState(), pProperties);
    }

    @Override
    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        SpecialEffectsBlock.Unstable.getEffects(level, pos, state, entity);

        super.stepOn(level, pos, state, entity);
    }
}
