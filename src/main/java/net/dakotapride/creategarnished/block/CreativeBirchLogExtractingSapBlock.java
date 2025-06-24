package net.dakotapride.creategarnished.block;

import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class CreativeBirchLogExtractingSapBlock extends RotatedPillarBlock {

    public CreativeBirchLogExtractingSapBlock(Properties properties) {
        super(properties);
        //registerDefaultState(defaultBlockState().setValue(HAS_SAP, false));
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {

        if (stack.is(Items.GLASS_BOTTLE)) {

            stack.shrink(1);
            player.addItem(new ItemStack(CreateGarnishedItems.BIRCH_SAP_BOTTLE.get(), 1));

            //level.setBlock(pos, Blocks.STRIPPED_BIRCH_LOG.defaultBlockState(), 11);
            //level.setBlockAndUpdate(pos, state.setValue(HAS_SAP, false));

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
}
