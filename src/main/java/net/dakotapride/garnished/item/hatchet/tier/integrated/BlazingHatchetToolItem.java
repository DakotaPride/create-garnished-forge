package net.dakotapride.garnished.item.hatchet.tier.integrated;

import net.dakotapride.garnished.GarnishedUtils;
import net.dakotapride.garnished.item.hatchet.IntegratedHatchetToolItem;
import net.dakotapride.garnished.item.hatchet.IntegratedMaterials;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlazingHatchetToolItem extends IntegratedHatchetToolItem {
    public BlazingHatchetToolItem(Properties properties) {
        super(GarnishedUtils.stuffAndAdditions(), IntegratedMaterials.BLAZING, 0.5F, -2.5F, properties);
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull BlockState blockstate, BlockPos pos, @NotNull LivingEntity entity) {
        execute(world, pos.getX(), pos.getY(), pos.getZ(), entity, itemstack);
        return super.mineBlock(itemstack, world, blockstate, pos, entity);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        execute(target, stack);
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.literal("§8Hold [§fShift§8] for Summary"));
            components.add(Component.literal(" "));
            components.add(Component.literal("§5As hot as an authentic blaze !"));
            components.add(Component.literal(" "));
            components.add(Component.literal("§7When Used"));
            components.add(Component.literal("§d Smelt§5 the block the tools break"));
        } else {
            components.add(Component.literal("§8Hold [§7Shift§8] for Summary"));
        }

        super.appendHoverText(stack, level, components, tooltipFlag);
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity != null) {
            boolean removeBlock = false;
            if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("minecraft:mineable/axe")))) {
                ItemStack stack;
                if (world instanceof Level) {
                    Level smeltResult = (Level)world;
                    stack = smeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING,
                            new SimpleContainer(new ItemStack(world.getBlockState(BlockPos.containing(x, y, z)).getBlock())),
                            smeltResult).map((recipe) -> recipe.getResultItem(smeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY);
                } else {
                    stack = ItemStack.EMPTY;
                }

                if (stack.getItem() != Blocks.AIR.asItem()) {
                    ServerLevel level = null;
                    if (world instanceof ServerLevel) {
                        level = (ServerLevel)world;
                        ItemStack stack1;
                        Level smeltResult = (Level) world;
                        stack1 = smeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING,
                                new SimpleContainer(new ItemStack(world.getBlockState(BlockPos.containing(x, y, z)).getBlock())),
                                smeltResult).map((recipe) -> recipe.getResultItem(smeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY);

                        ItemEntity entityToSpawn = new ItemEntity(level, x, y, z, stack1);
                        entityToSpawn.setPickUpDelay(10);
                        level.addFreshEntity(entityToSpawn);
                    }

                    if (world instanceof ServerLevel) {
                        level.sendParticles(ParticleTypes.FLAME, x + 0.5, y + 0.5, z + 0.5, 10, 0.25, 0.25, 0.25, 0.0);
                    }

                    removeBlock = true;
                }

                if (removeBlock) {
                    world.destroyBlock(BlockPos.containing(x, y, z), false);
                } else {
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
                    world.destroyBlock(_pos, false);
                }
            }

            if (entity.level().dimension() == Level.NETHER) {
                itemstack.setDamageValue(itemstack.getDamageValue() - 1);
            }

        }
    }

    public static void execute(Entity entity, ItemStack itemstack) {
        if (entity != null) {
            entity.setSecondsOnFire(15);
            if (entity.level().dimension() == Level.NETHER) {
                itemstack.setDamageValue(itemstack.getDamageValue() - 1);
            }

        }
    }
}
