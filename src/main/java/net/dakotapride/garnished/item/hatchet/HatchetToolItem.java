package net.dakotapride.garnished.item.hatchet;

import com.google.common.collect.ImmutableMap;
import net.dakotapride.garnished.registry.GarnishedEnchantments;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class HatchetToolItem extends DiggerItem implements Vanishable {
    protected static final Map<Block, Block> STRIPPABLES =
            (new ImmutableMap.Builder<Block, Block>())
                    .put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD)
                    .put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG)
                    .put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD)
                    .put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG)
                    .put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD)
                    .put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG)
                    .put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD)
                    .put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG)
                    .put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD)
                    .put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG)
                    .put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD)
                    .put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG)
                    .put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM)
                    .put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE)
                    .put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM)
                    .put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE)
                    .put(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD)
                    .put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG).build();

    public HatchetToolItem(Tier tier, float damage, float speed, Properties properties) {
        super(damage, speed, tier, GarnishedTags.MINEABLE_WITH_HATCHET, properties);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment == Enchantments.SHARPNESS)
            return true;
        if (enchantment == Enchantments.SMITE)
            return true;
        if (enchantment == Enchantments.UNBREAKING)
            return true;
        if (enchantment == Enchantments.MOB_LOOTING)
            return true;
        if (enchantment == Enchantments.BANE_OF_ARTHROPODS)
            return true;
        if (enchantment == Enchantments.VANISHING_CURSE)
            return true;
        if (enchantment == Enchantments.MENDING)
            return true;
        if (enchantment == Enchantments.BLOCK_EFFICIENCY)
            return true;
        if (enchantment == Enchantments.BLOCK_FORTUNE)
            return true;
        if (enchantment == Enchantments.FIRE_ASPECT)
            return true;
        if (enchantment == Enchantments.KNOCKBACK)
            return true;
        if (enchantment == Enchantments.SILK_TOUCH)
            return true;
        if (enchantment == GarnishedEnchantments.SALVAGING.get())
            return true;
        if (enchantment == GarnishedEnchantments.RAVAGING.get())
            return true;

        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);
        Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.AXE_STRIP, false));
        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.AXE_SCRAPE, false));
        Optional<BlockState> optional2 = optional.isPresent() || optional1.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.AXE_WAX_OFF, false));
        ItemStack itemstack = pContext.getItemInHand();
        Optional<BlockState> optional3 = Optional.empty();
        if (optional.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            optional3 = optional;
        } else if (optional1.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3005, blockpos, 0);
            optional3 = optional1;
        } else if (optional2.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3004, blockpos, 0);
            optional3 = optional2;
        }

        if (optional3.isPresent()) {
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
            }

            level.setBlock(blockpos, optional3.get(), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional3.get()));
            if (player != null) {
                itemstack.hurtAndBreak(1, player, (p_150686_) -> {
                    p_150686_.broadcastBreakEvent(pContext.getHand());
                });
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    @Nullable
    public static BlockState getAxeStrippingState(BlockState originalState) {
        Block block = STRIPPABLES.get(originalState.getBlock());
        return block != null ? block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, originalState.getValue(RotatedPillarBlock.AXIS)) : null;
    }

    private Optional<BlockState> getStripped(BlockState pUnstrippedState) {
        return Optional.ofNullable(STRIPPABLES.get(pUnstrippedState.getBlock())).map((block) -> {
            return block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, pUnstrippedState.getValue(RotatedPillarBlock.AXIS));
        });
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return net.minecraftforge.common.ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) {
            return 15.0F;
        }

        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        pStack.hurtAndBreak(1, attacker, (entity) -> {
            entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });

        return true;
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState block) {
        if (block.is(Blocks.COBWEB)) {
            return true;
        }

        return block.is(GarnishedTags.MINEABLE_WITH_HATCHET);
    }
}
