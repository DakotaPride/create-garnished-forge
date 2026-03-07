package net.dakotapride.garnished.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public class GarnishedFlowingFluid extends BaseFlowingFluid {
    public GarnishedFlowingFluid(Properties properties) {
        super(properties);
    }

    public static class Flowing extends BaseFlowingFluid.Flowing {
        private final GameRules.Key<GameRules.BooleanValue> convertToSourceRule;
        public Flowing(Properties properties, GameRules.Key<GameRules.BooleanValue> convertToSourceRule) {
            super(properties);
            this.convertToSourceRule = convertToSourceRule;
        }

        @Override
        public boolean canConvertToSource(FluidState state, Level level, BlockPos pos) {
            return level.getGameRules().getBoolean(convertToSourceRule);
        }
    }

    public static class Source extends BaseFlowingFluid.Source {
        private final GameRules.Key<GameRules.BooleanValue> convertToSourceRule;
        public Source(Properties properties, GameRules.Key<GameRules.BooleanValue> convertToSourceRule) {
            super(properties);
            this.convertToSourceRule = convertToSourceRule;
        }

        @Override
        public boolean canConvertToSource(FluidState state, Level level, BlockPos pos) {
            return level.getGameRules().getBoolean(convertToSourceRule);
        }
    }

    @Override
    public boolean isSource(FluidState state) {
        return false;
    }

    @Override
    public int getAmount(FluidState state) {
        return 0;
    }
}
