package net.dakotapride.creategarnished.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class SprintersTeaItem extends Item {

    public SprintersTeaItem(Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        Player playerentity = entity instanceof Player ? (Player) entity : null;
        if (playerentity instanceof ServerPlayer)
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) playerentity, stack);

        if (!world.isClientSide)
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3 * 60 * 20, 0, false, false, false));

        if (playerentity != null) {
            playerentity.awardStat(Stats.ITEM_USED.get(this));
            playerentity.getFoodData().eat(1, .6F);
            if (!playerentity.getAbilities().instabuild)
                stack.shrink(1);
        }

        if (playerentity == null || !playerentity.getAbilities().instabuild) {
            if (stack.isEmpty())
                return new ItemStack(Items.GLASS_BOTTLE);
            if (playerentity != null)
                playerentity.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
        }

        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 42;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

}
