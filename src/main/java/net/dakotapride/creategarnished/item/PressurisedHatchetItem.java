package net.dakotapride.creategarnished.item;

import com.simibubi.create.content.equipment.armor.BacktankUtil;
import net.dakotapride.creategarnished.registry.CreateGarnishedConfigs;
import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import javax.annotation.Nullable;
import java.util.Optional;

@EventBusSubscriber
public class PressurisedHatchetItem extends Item {
    private Tier tier;
    public PressurisedHatchetItem(Properties properties) {
        super(properties.attributes(AxeItem.createAttributes(Tiers.IRON, 6.0F, -3.1F)).component(DataComponents.TOOL, Tiers.IRON.createToolProperties(BlockTags.MINEABLE_WITH_AXE)));
    }

    public PressurisedHatchetItem(Tier tier, Properties properties) {
        super(properties.attributes(AxeItem.createAttributes(tier, 6.0F, -3.1F)).component(DataComponents.TOOL, tier.createToolProperties(BlockTags.MINEABLE_WITH_AXE)));
        this.tier = tier;
    }

    public Tier getTier() {
        return tier != null ? tier : Tiers.IRON;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    /**
     * Called when this item is used when targeting a Block
     */
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Player player = context.getPlayer();
        if (playerHasShieldUseIntent(context)) {
            return InteractionResult.PASS;
        } else {
            Optional<BlockState> optional = this.evaluateNewBlockState(level, blockpos, player, level.getBlockState(blockpos), context);
            if (optional.isEmpty()) {
                return InteractionResult.PASS;
            } else {
                ItemStack itemstack = context.getItemInHand();
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                }

                level.setBlock(blockpos, optional.get(), 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional.get()));
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
    }

    private static boolean playerHasShieldUseIntent(UseOnContext context) {
        Player player = context.getPlayer();
        return context.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().is(Items.SHIELD) && !player.isSecondaryUseActive();
    }

    private Optional<BlockState> evaluateNewBlockState(Level level, BlockPos pos, @Nullable Player player, BlockState state, UseOnContext p_40529_) {
        Optional<BlockState> optional = Optional.ofNullable(state.getToolModifiedState(p_40529_, net.neoforged.neoforge.common.ItemAbilities.AXE_STRIP, false));
        if (optional.isPresent()) {
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return optional;
        } else {
            Optional<BlockState> optional1 = Optional.ofNullable(state.getToolModifiedState(p_40529_, net.neoforged.neoforge.common.ItemAbilities.AXE_SCRAPE, false));
            if (optional1.isPresent()) {
                level.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3005, pos, 0);
                return optional1;
            } else {
                Optional<BlockState> optional2 = Optional.ofNullable(state.getToolModifiedState(p_40529_, net.neoforged.neoforge.common.ItemAbilities.AXE_WAX_OFF, false));
                if (optional2.isPresent()) {
                    level.playSound(player, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.levelEvent(player, 3004, pos, 0);
                    return optional2;
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
        return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_AXE_ACTIONS.contains(itemAbility);
    }

    private static int maxUses() {
        return CreateGarnishedConfigs.server().hatchet.maxPressurisedHatchetActions.get();
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void consumeDurabilityOnBlockBreak(BlockEvent.BreakEvent event) {
        findAndDamagePressurisedHatchet(event.getPlayer());
    }

//    @SubscribeEvent(priority = EventPriority.LOWEST)
//    public static void consumeDurabilityOnPlace(BlockEvent.EntityPlaceEvent event) {
//        Entity entity = event.getEntity();
//        if (entity instanceof Player)
//            findAndDamagePressurisedHatchet((Player) entity);
//    }

    private static void findAndDamagePressurisedHatchet(Player player) {
        if (player == null)
            return;
        if (player.level().isClientSide)
            return;
        EquipmentSlot equipmentSlot = EquipmentSlot.MAINHAND;
        ItemStack itemInMainHand = player.getMainHandItem();
        if (!CreateGarnishedItems.PRESSURISED_HATCHET.isIn(itemInMainHand)) {
            itemInMainHand = player.getOffhandItem();
            equipmentSlot = EquipmentSlot.OFFHAND;
        }
        if (!CreateGarnishedItems.PRESSURISED_HATCHET.isIn(itemInMainHand))
            return;
        if (!BacktankUtil.canAbsorbDamage(player, maxUses()))
            itemInMainHand.hurtAndBreak(2, player, equipmentSlot);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return BacktankUtil.isBarVisible(stack, maxUses());
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return BacktankUtil.getBarWidth(stack, maxUses());
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return BacktankUtil.getBarColor(stack, maxUses());
    }

    @Override
    public boolean doesSneakBypassUse(ItemStack stack, LevelReader level, BlockPos pos, Player player) {
        return true;
    }

    @SubscribeEvent
    public static void bufferLivingAttackEvent(LivingIncomingDamageEvent event) {
        DamageSource source = event.getSource();
        Entity entity = source.getEntity();
        if (entity instanceof Player)
            findAndDamagePressurisedHatchet((Player) entity);
    }

    @Override
    public int getEnchantmentValue() {
        return tier != null ? tier.getEnchantmentValue() : Tiers.IRON.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return tier != null ? tier.getRepairIngredient().test(repair) : Tiers.IRON.getRepairIngredient().test(repair) || super.isValidRepairItem(toRepair, repair);
    }
}
