package net.dakotapride.creategarnished.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class MushroomSlopBucketItem extends BucketItem {
    public MushroomSlopBucketItem(Fluid content, Properties properties) {
        super(content, properties.food(new FoodProperties.Builder().alwaysEdible().nutrition(24).saturationModifier(1.2F).usingConvertsTo(Items.BUCKET).build()));
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 192;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        BlockHitResult blockhitresult = getPlayerPOVHitResult(level, player, this.content == Fluids.EMPTY ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE);
        if (blockhitresult.getType() == HitResult.Type.MISS)
            return ItemUtils.startUsingInstantly(level, player, hand);
        else return super.use(level, player, hand);
    }
}
