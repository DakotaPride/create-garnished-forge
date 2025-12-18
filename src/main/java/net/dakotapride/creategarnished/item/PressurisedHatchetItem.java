package net.dakotapride.creategarnished.item;

import com.simibubi.create.content.equipment.armor.BacktankUtil;
import com.simibubi.create.content.equipment.tool.KnockbackPacket;
import net.createmod.catnip.platform.CatnipServices;
import net.dakotapride.creategarnished.registry.CreateGarnishedConfigs;
import net.dakotapride.creategarnished.registry.CreateGarnishedTags;
import net.dakotapride.creategarnished.util.ModIds;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import vectorwing.farmersdelight.common.block.entity.CuttingBoardBlockEntity;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

import static com.simibubi.create.content.equipment.tool.CardboardSwordItem.knockback;

@EventBusSubscriber
public class PressurisedHatchetItem extends Item {
    private Tier tier;
    private final boolean creative;
    public PressurisedHatchetItem(Properties properties, boolean creative) {
        super(properties.attributes(AxeItem.createAttributes(Tiers.IRON, 6.0F, -3.1F)).component(DataComponents.TOOL, Tiers.IRON.createToolProperties(BlockTags.MINEABLE_WITH_AXE)));
        this.creative = creative;
    }

    public PressurisedHatchetItem(Tier tier, Properties properties, boolean creative) {
        super(properties.attributes(AxeItem.createAttributes(tier, 6.0F, -3.1F)).component(DataComponents.TOOL, tier.createToolProperties(BlockTags.MINEABLE_WITH_AXE)));
        this.tier = tier;
        this.creative = creative;
    }

    public boolean isCreative() {
        return creative;
    }

    public Tier getTier() {
        return tier != null ? tier : Tiers.IRON;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    @Override
    public float getAttackDamageBonus(Entity target, float damage, DamageSource damageSource) {
        if (CreateGarnishedConfigs.server().hatchet.enableShotgunAxe.get())
            return super.getAttackDamageBonus(target, damage, damageSource) + 6;

        return super.getAttackDamageBonus(target, damage, damageSource);
    }

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
                if (player != null && itemstack.isDamageableItem()) {
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

    private Optional<BlockState> evaluateNewBlockState(Level level, BlockPos pos, @Nullable Player player, BlockState state, UseOnContext ctx) {
        Optional<BlockState> optional = Optional.ofNullable(state.getToolModifiedState(ctx, ItemAbilities.AXE_STRIP, false));
        if (optional.isPresent()) {
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            return optional;
        } else {
            Optional<BlockState> optional1 = Optional.ofNullable(state.getToolModifiedState(ctx, ItemAbilities.AXE_SCRAPE, false));
            if (optional1.isPresent()) {
                level.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3005, pos, 0);
                return optional1;
            } else {
                Optional<BlockState> optional2 = Optional.ofNullable(state.getToolModifiedState(ctx, ItemAbilities.AXE_WAX_OFF, false));
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
        return ItemAbilities.DEFAULT_AXE_ACTIONS.contains(itemAbility);
    }

    private static int maxUses() {
        return CreateGarnishedConfigs.server().hatchet.maxPressurisedHatchetActions.get();
    }

    // -> CardboardSwordItem.cardboardSwordsCannotHurtYou
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void calculateKnockbackFromShotgun(AttackEntityEvent event) {
//        if (!CreateGarnishedConfigs.server().hatchet.enableShotgunAxe.get())
//            return;

        Player attacker = event.getEntity();
        if (!(event.getTarget() instanceof LivingEntity target))
            return;
        ItemStack stack = attacker.getItemInHand(InteractionHand.MAIN_HAND);

        if (!stack.is(CreateGarnishedTags.HATCHETS))
            return;

        float knockbackStrength = (float) (attacker.getAttributeValue(Attributes.ATTACK_KNOCKBACK) + 100);
        if (attacker.level() instanceof ServerLevel serverLevel)
            knockbackStrength = EnchantmentHelper.modifyKnockback(serverLevel, stack, target, serverLevel.damageSources().playerAttack(attacker), knockbackStrength);
        if (attacker.isSprinting() && attacker.getAttackStrengthScale(0.5f) > 0.9f)
            ++knockbackStrength;

        if (knockbackStrength <= 0)
            return;

        float yRot = attacker.getYRot();
        knockback(target, knockbackStrength, yRot);

        if (target instanceof ServerPlayer sp)
            CatnipServices.NETWORK.sendToClient(sp, new KnockbackPacket(yRot, knockbackStrength));

        attacker.setDeltaMovement(attacker.getDeltaMovement().multiply(0.6D, 1.0D, 0.6D));
        attacker.setSprinting(false);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void consumeDurabilityOnBlockBreak(BlockEvent.BreakEvent event) {
        if (!CreateGarnishedConfigs.server().hatchet.enableShotgunAxe.get())
            findAndDamagePressurisedHatchet(event.getPlayer());
        else shotgunAxeGoBrrrrButOW(event.getPlayer());
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void shotgun(BlockEvent.BreakEvent event) {
        if (event.getPlayer().getItemInHand(InteractionHand.MAIN_HAND).is(CreateGarnishedTags.HATCHETS)) {
            if (event.getLevel() instanceof ServerLevel level) {
                level.playSound(null, event.getPos(), SoundEvents.ANVIL_LAND, event.getPlayer().getSoundSource(), 10.0F, 1.0F);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void shotgunAttack(AttackEntityEvent event) {
        if (event.getEntity().getMainHandItem().is(CreateGarnishedTags.HATCHETS)) {
            if (event.getEntity().level() instanceof ServerLevel level) {
                level.playSound(null, event.getEntity().blockPosition(), SoundEvents.ANVIL_LAND, event.getEntity().getSoundSource(), 10.0F, 1.0F);
            }
        }
    }

    @SubscribeEvent
    public static void onSneakPlaceTool(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();
        ItemStack heldStack = player.getMainHandItem();
        BlockEntity tileEntity = level.getBlockEntity(event.getPos());
        if (ModIds.FARMERS_DELIGHT.isLoaded() && player.isSecondaryUseActive() && !heldStack.isEmpty() && tileEntity instanceof CuttingBoardBlockEntity && (heldStack.getItem() instanceof PressurisedHatchetItem)) {
            boolean success = ((CuttingBoardBlockEntity)tileEntity).carveToolOnBoard(player.getAbilities().instabuild ? heldStack.copy() : heldStack);
            if (success) {
                level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F);
                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
            }
        }

    }

    private static void findAndDamagePressurisedHatchet(Player player) {
        if (player == null)
            return;
        if (player.level().isClientSide)
            return;
        EquipmentSlot equipmentSlot = EquipmentSlot.MAINHAND;
        ItemStack itemInMainHand = player.getMainHandItem();
        if (!itemInMainHand.is(CreateGarnishedTags.HATCHETS)) {
            itemInMainHand = player.getOffhandItem();
            equipmentSlot = EquipmentSlot.OFFHAND;
        }
        if (!itemInMainHand.is(CreateGarnishedTags.HATCHETS))
            return;
        if (!BacktankUtil.canAbsorbDamage(player, maxUses()) && itemInMainHand.isDamageableItem())
            itemInMainHand.hurtAndBreak(2, player, equipmentSlot);
    }

    private static void shotgunAxeGoBrrrrButOW(Player player) {
        if (player == null)
            return;
        if (player.level().isClientSide)
            return;
        EquipmentSlot equipmentSlot = EquipmentSlot.MAINHAND;
        ItemStack itemInMainHand = player.getMainHandItem();
        if (!itemInMainHand.is(CreateGarnishedTags.HATCHETS)) {
            itemInMainHand = player.getOffhandItem();
            equipmentSlot = EquipmentSlot.OFFHAND;
        }
        if (!itemInMainHand.is(CreateGarnishedTags.HATCHETS))
            return;
        if (!canShotgunAxeAbsorbDamage(player, maxUses()) && itemInMainHand.isDamageableItem())
            itemInMainHand.hurtAndBreak(4, player, equipmentSlot);
    }

    public static boolean canShotgunAxeAbsorbDamage(LivingEntity entity, int usesPerTank) {
        if (usesPerTank == 0)
            return true;
        if (entity instanceof Player && ((Player) entity).isCreative())
            return true;
        List<ItemStack> backtanks = BacktankUtil.getAllWithAir(entity);
        if (backtanks.isEmpty())
            return false;
        int cost = Math.max(BacktankUtil.maxAirWithoutEnchants() / usesPerTank, 1);
        BacktankUtil.consumeAir(entity, backtanks.getFirst(), cost * 2);
        return true;
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
