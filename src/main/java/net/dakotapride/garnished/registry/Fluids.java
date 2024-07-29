package net.dakotapride.garnished.registry;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidType;

public interface Fluids {
    RandomSource random = RandomSource.create();

    static void basicFluidInteraction(FluidType input, FluidType addition, Block sourceOutput, Block flowingOutput) {
        FluidInteractionRegistry.addInteraction(input, new FluidInteractionRegistry.InteractionInformation(addition,
                fluidState -> {
                    if (fluidState.isSource()) {
                        return sourceOutput.defaultBlockState();
                    } else {
                        return flowingOutput.defaultBlockState();
                    }
                }
        ));

        FluidInteractionRegistry.addInteraction(addition, new FluidInteractionRegistry.InteractionInformation(input,
                fluidState -> {
                    if (fluidState.isSource()) {
                        return sourceOutput.defaultBlockState();
                    } else {
                        return flowingOutput.defaultBlockState();
                    }
                }
        ));
    }

    static BlockState lavaInteraction(FluidState fluidState, Fluid inputFluid, Block block) {
        Fluid fluid = fluidState.getType();
        if (fluid.isSame(inputFluid)) {
            return block.defaultBlockState();
        } else {
            return Blocks.COBBLESTONE.defaultBlockState();
        }
    }


}
