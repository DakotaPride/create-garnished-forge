package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MysteriousVoltBottleItem extends Item {
    public MysteriousVoltBottleItem(Properties properties) {
        super(properties.food(new FoodProperties.Builder().alwaysEdible().usingConvertsTo(Items.GLASS_BOTTLE).build()));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof Player player && !level.isClientSide) {
            player.addEffect(new MobEffectInstance(CreateGarnishedStatusEffects.VOLT_STRUCK, 1200, 0));

            AreaEffectCloud cloud = new AreaEffectCloud(level, player.getX(), player.getY(), player.getZ());
            cloud.setOwner(player);
            cloud.setRadius(2.0F);
            cloud.setDuration(200);
            cloud.setParticle(CreateGarnishedParticles.VOLT.get());
            cloud.addEffect(new MobEffectInstance(CreateGarnishedStatusEffects.VOLT_STRUCK, 100, 0));
            level.addFreshEntity(cloud);

            player.hurt(CreateGarnishedDamageSources.shock(level), player.getHealth());

            if (player.isInWater() && player instanceof ServerPlayer server) {
                CreateGarnishedTriggers.ELECTROCUTED.get().trigger(server);
            }

//            stack.shrink(1);
//            player.addItem(new ItemStack(Items.GLASS_BOTTLE));
            return stack;
        }

        return super.finishUsingItem(stack, level, livingEntity);
    }

//    @Override
//    public UseAnim getUseAnimation(ItemStack stack) {
//        return UseAnim.BOW;
//    }
//
//    @Override
//    public int getUseDuration(ItemStack stack, LivingEntity entity) {
//        return 60;
//    }
//
//    @Override
//    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
//        ItemStack itemstack = player.getItemInHand(hand);
//
//        if (itemstack.is(this)) {
//            return ItemUtils.startUsingInstantly(level, player, hand);
//        } else {
//            return InteractionResultHolder.fail(itemstack);
//        }
//    }
}
