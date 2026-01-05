package net.dakotapride.garnished.item.hatchet;

import net.dakotapride.garnished.registry.GarnishedEnchantments;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class HatchetToolItem extends DiggerItem implements Vanishable {
    public HatchetToolItem(Tier tier, float damage, float speed, Properties properties) {
        super(damage, speed, tier, GarnishedTags.MINEABLE_WITH_HATCHET, properties);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment == Enchantments.UNBREAKING)
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
        if (enchantment == GarnishedEnchantments.STRIKING.get())
            return true;
        if (enchantment == GarnishedEnchantments.QUICK_STEP.get())
            return true;
        if (enchantment == GarnishedEnchantments.REJUVENATE.get())
            return true;
        if (enchantment == GarnishedEnchantments.LEECHING_CURSE.get())
            return true;

        if (enchantment == Enchantments.MOB_LOOTING)
            return false;
        if (enchantment == Enchantments.SHARPNESS)
            return false;
        if (enchantment == Enchantments.SMITE)
            return false;
        if (enchantment == Enchantments.BANE_OF_ARTHROPODS)
            return false;

        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);
        Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_STRIP, false));
        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_SCRAPE, false));
        Optional<BlockState> optional2 = optional.isPresent() || optional1.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_WAX_OFF, false));
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

     @Override
     public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
         return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction);
     }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) {
            return 15.0F;
        }

        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        if (HatchetUtils.hasRejuvenate(attacker) && attacker.getHealth() != attacker.getMaxHealth()) {
            int level = EnchantmentHelper.getEnchantmentLevel(HatchetUtils.rejuvenate, attacker);
            // If max health is 20, then heal 4 health
            // attacker.heal(attacker.getMaxHealth() * (0.20F * 1));

            attacker.heal(attacker.getMaxHealth() * (0.10F * level));

            stack.hurtAndBreak(1 + level, attacker, (entity) -> entity.broadcastBreakEvent(attacker.getUsedItemHand()));
        } else {
            stack.hurtAndBreak(1, attacker, (entity) -> entity.broadcastBreakEvent(attacker.getUsedItemHand()));
        }

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
