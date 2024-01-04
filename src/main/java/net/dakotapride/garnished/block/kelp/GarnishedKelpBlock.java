package net.dakotapride.garnished.block.kelp;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import org.jetbrains.annotations.NotNull;

public class GarnishedKelpBlock extends KelpBlock implements LiquidBlockContainer {
    public GarnishedKelpBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(@NotNull RandomSource random) {
        return random.nextInt(5);
    }
}
