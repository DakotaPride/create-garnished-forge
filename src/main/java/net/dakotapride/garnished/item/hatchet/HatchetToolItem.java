package net.dakotapride.garnished.item.hatchet;

import com.simibubi.create.content.equipment.tool.KnockbackPacket;
import net.createmod.catnip.platform.CatnipServices;
import net.dakotapride.garnished.registry.GarnishedEnchantments;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

import static com.simibubi.create.content.equipment.tool.CardboardSwordItem.knockback;

@EventBusSubscriber
public class HatchetToolItem extends DiggerItem {

    public HatchetToolItem(Tier tier, Properties properties) {
        super(tier, GarnishedTags.MINEABLE_WITH_HATCHET, properties);
    }

    // -> CardboardSwordItem.cardboardSwordsCannotHurtYou
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void calculateKnockbackFromShotgun(AttackEntityEvent event) {

        Player attacker = event.getEntity();
        if (!(event.getTarget() instanceof LivingEntity target))
            return;
        ItemStack stack = attacker.getItemInHand(InteractionHand.MAIN_HAND);

        if (!stack.is(GarnishedTags.HATCHETS_TAG))
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

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void shotgun(BlockEvent.BreakEvent event) {
        if (event.getPlayer().getItemInHand(InteractionHand.MAIN_HAND).is(GarnishedTags.HATCHETS_TAG)) {
            if (event.getLevel() instanceof ServerLevel level) {
                level.playSound(null, event.getPos(), SoundEvents.ANVIL_LAND, event.getPlayer().getSoundSource(), 10.0F, 1.0F);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void shotgunAttack(AttackEntityEvent event) {
        if (event.getEntity().getMainHandItem().is(GarnishedTags.HATCHETS_TAG)) {
            if (event.getEntity().level() instanceof ServerLevel level) {
                level.playSound(null, event.getEntity().blockPosition(), SoundEvents.ANVIL_LAND, event.getEntity().getSoundSource(), 10.0F, 1.0F);
            }
        }
    }


    public static @NotNull ItemAttributeModifiers createAttributes(Tier tier, float damage, float speed) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (damage + tier.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, speed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }

    @Override
    public @NotNull ItemStack applyEnchantments(ItemStack stack, List<EnchantmentInstance> enchantments) {
        return super.applyEnchantments(stack, enchantments);
    }

    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        if (enchantment.getKey() == Enchantments.UNBREAKING)
            return true;
        if (enchantment.getKey() == Enchantments.VANISHING_CURSE)
            return true;
        if (enchantment.getKey() == Enchantments.MENDING)
            return true;
        if (enchantment.getKey() == Enchantments.EFFICIENCY)
            return true;
        if (enchantment.getKey() == Enchantments.FORTUNE)
            return true;
        if (enchantment.getKey() == Enchantments.FIRE_ASPECT)
            return true;
        if (enchantment.getKey() == Enchantments.KNOCKBACK)
            return true;
        if (enchantment.getKey() == Enchantments.SILK_TOUCH)
            return true;
        if (enchantment.getKey() == GarnishedEnchantments.SALVAGING)
            return true;
        if (enchantment.getKey() == GarnishedEnchantments.RAVAGING)
            return true;
        if (enchantment.getKey() == GarnishedEnchantments.STRIKING)
            return true;
        if (enchantment.getKey() == GarnishedEnchantments.QUICK_STEP)
            return true;
        if (enchantment.getKey() == GarnishedEnchantments.REJUVENATE)
            return true;
        if (enchantment.getKey() == GarnishedEnchantments.LEECHING_CURSE)
            return true;

        // Strictly forbid these enchantments
        if (enchantment.is(GarnishedTags.NOT_APPLICABLE_TO_HATCHETS))
            return false;

        return super.supportsEnchantment(stack, enchantment);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);
        Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(pContext, ItemAbilities.AXE_STRIP, false));
        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, ItemAbilities.AXE_SCRAPE, false));
        Optional<BlockState> optional2 = optional.isPresent() || optional1.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, ItemAbilities.AXE_WAX_OFF, false));
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
                itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

     @Override
     public boolean canPerformAction(ItemStack stack, ItemAbility toolAction) {
         return ItemAbilities.DEFAULT_AXE_ACTIONS.contains(toolAction);
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
//        pStack.hurtAndBreak(1, attacker, (entity) -> {
//            entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
//        });

        if (HatchetUtils.hasRejuvenate(attacker, stack) && attacker.getHealth() != attacker.getMaxHealth()) {
            Registry<Enchantment> enchantmentRegistry = attacker.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT);
            int level = EnchantmentHelper.getEnchantmentLevel(enchantmentRegistry.getHolderOrThrow(HatchetUtils.rejuvenate), attacker);
            // If max health is 20, then heal 4 health
            // attacker.heal(attacker.getMaxHealth() * (0.20F * 1));

            attacker.heal(attacker.getMaxHealth() * (0.10F * level));

            stack.hurtAndBreak(1 + level, attacker, LivingEntity.getSlotForHand(attacker.getUsedItemHand()));
        } else {
            stack.hurtAndBreak(1, attacker, LivingEntity.getSlotForHand(attacker.getUsedItemHand()));
        }

        return true;
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState block) {
        if (block.is(Blocks.COBWEB)) {
            return true;
        }

        return block.is(GarnishedTags.MINEABLE_WITH_HATCHET);
    }
}
