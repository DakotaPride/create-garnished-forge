package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.CreateGarnishedBlocks;
import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.dakotapride.creategarnished.registry.CreateGarnishedStatusEffects;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RoyalCiderItem extends BlockItem {
    public RoyalCiderItem(Properties properties) {
        super(CreateGarnishedBlocks.ROYAL_CIDER_GLASS.get(), properties.food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.8F)
                        .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3 * 60 * 20, 0, false, true, false), 1.0F)
                        .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 60 * 20, 0, false, false, false), 1.0F)
                        .effect(() -> new MobEffectInstance(MobEffects.LUCK, 3 * 60 * 20, 0, false, false, false), 1.0F)
                .usingConvertsTo(Items.GLASS_BOTTLE).build()));
    }

    public static class Caramel extends BlockItem {
        public Caramel(Properties properties) {
            super(CreateGarnishedBlocks.CARAMEL_ROYAL_CIDER_GLASS.get(), properties.food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.8F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3 * 60 * 20, 0, false, true, false), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.LUCK, 3 * 60 * 20, 0, false, false, false), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 60 * 20, 1, false, false, false), 0.5F)
                    .effect(() -> new MobEffectInstance(CreateGarnishedStatusEffects.STICKY, 2 * 60 * 20, 1, false, false, false), 0.25F)
                    .usingConvertsTo(Items.GLASS_BOTTLE).build()));
        }
    }

    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.375, 0, 0.375, 0.625, 0.0625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.0625, 0.4375, 0.5625, 0.25, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.25, 0.3125, 0.6875, 0.5625, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.25, 0.625, 0.6875, 0.5625, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 0.25, 0.375, 0.6875, 0.5625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.25, 0.375, 0.375, 0.5625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.25, 0.375, 0.625, 0.3125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.28125, 0.375, 0.625, 0.53125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.0625, 0.5, 0.6875, 0.25, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 0.0625, 0.3125, 0.5, 0.25, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.5625, 0.6875), BooleanOp.OR);

        return shape;
    }

    @Override
    protected boolean canPlace(BlockPlaceContext context, BlockState state) {
        return Screen.hasShiftDown();
    }

    @Override
    public String getDescriptionId(ItemStack stack) {
        return stack.is(CreateGarnishedItems.CARAMEL_TOPPED_ROYAL_CIDER) ? "item.creategarnished.caramel_topped_royal_cider" : "item.creategarnished.royal_cider";
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 42;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

}
