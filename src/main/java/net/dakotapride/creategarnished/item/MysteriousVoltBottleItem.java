package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.dakotapride.creategarnished.registry.CreateGarnishedParticles;
import net.dakotapride.creategarnished.registry.CreateGarnishedStatusEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MysteriousVoltBottleItem extends Item {
    public MysteriousVoltBottleItem(Properties properties) {
        super(properties);
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
            return stack;
        }

        return super.finishUsingItem(stack, level, livingEntity);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 60;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (itemstack.is(this)) {
            return ItemUtils.startUsingInstantly(level, player, hand);
        } else {
            return InteractionResultHolder.fail(itemstack);
        }
    }
}
