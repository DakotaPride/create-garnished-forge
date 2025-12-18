package net.dakotapride.creategarnished.entity.squirrel;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.registry.CreateGarnishedTriggers;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

// From Alex's Caves
public class AnimalLootChestsGoal extends MoveToBlockGoal {
    private final SquirrelEntity entity;
    private boolean hasOpenedChest = false;

    public AnimalLootChestsGoal(SquirrelEntity entity, int range) {
        super(entity, 1.0F, range, 6);
        this.entity = entity;
    }

    protected int nextStartTick(@NotNull PathfinderMob mob) {
        entity.setThieving(true);
        return reducedTickDelay(100 + entity.getRandom().nextInt(100));
    }

    @Override
    public void start() {
        entity.setThieving(true);
        super.start();
    }

    public boolean isChestRaidable(LevelReader world, BlockPos pos) {
        if (world.getBlockState(pos).getBlock() instanceof BaseEntityBlock) {
            BlockEntity entity = world.getBlockEntity(pos);
            if (entity instanceof Container inventory) {
                try {
                    if (!inventory.isEmpty()) {
                        return true;
                    }
                } catch (Exception e) {
                    CreateGarnished.LOGGER.warn("Successfully stopped a {} from causing a crash during access", entity.getClass().getSimpleName());
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    protected @NotNull BlockPos getMoveToTarget() {
        return this.blockPos;
    }

    protected void moveMobToBlock() {
        BlockPos pos = getMoveToTarget();
        this.mob.getNavigation().moveTo((double) ((float) pos.getX()) + 0.5D, (pos.getY() + 1), (double) ((float) pos.getZ()) + 0.5D, this.speedModifier);
    }

    @Override
    public boolean canUse() {
        if (this.entity != null && entity.isTame()) {
            return false;
        }
        if (!this.entity.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
            return false;
        }
        return super.canUse() && !entity.isDancing();
    }

    @Override
    public boolean canContinueToUse() {
        return super.canContinueToUse() && this.entity.getItemInHand(InteractionHand.MAIN_HAND).isEmpty();
    }

    public boolean hasLineOfSightChest() {
        HitResult raytraceresult = entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), new Vec3(blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity));
        if (raytraceresult instanceof BlockHitResult blockRayTraceResult) {
            BlockPos pos = blockRayTraceResult.getBlockPos();
            return pos.equals(blockPos) || entity.level().isEmptyBlock(pos) || this.entity.level().getBlockEntity(pos) == this.entity.level().getBlockEntity(blockPos);
        }
        return true;
    }

    public ItemStack getFoodFromInventory(Container inventory, RandomSource random) {
        List<ItemStack> items = new ArrayList<>();
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack stack = inventory.getItem(i);
            if (!stack.isEmpty() && stack.has(DataComponents.FOOD)) {
                items.add(stack);
            }
        }
        if (items.isEmpty()) {
            return ItemStack.EMPTY;
        } else if (items.size() == 1) {
            return items.getFirst();
        } else {
            return items.get(random.nextInt(items.size() - 1));
        }
    }

    public double acceptedDistance() {
        return Math.pow(entity.getBbWidth(), 2) + 1.0F;
    }

    public boolean shouldRecalculatePath() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        BlockEntity te = this.entity.level().getBlockEntity(this.blockPos);
        if (te instanceof Container feeder) {
            double distance = this.entity.distanceToSqr(this.blockPos.getX() + 0.5F, this.blockPos.getY() + 0.5F, this.blockPos.getZ() + 0.5F);
            entity.getNavigation().moveTo(this.blockPos.getX() + 0.5F, this.blockPos.getY() - 1, this.blockPos.getZ() + 0.5F, 1.0F);
            if (hasLineOfSightChest()) {
                entity.lookAt(EntityAnchorArgument.Anchor.EYES, Vec3.atCenterOf(blockPos));
                if (distance <= acceptedDistance()) {
                    entity.getNavigation().stop();
                    if (!hasOpenedChest) {
                        hasOpenedChest = true;
                        toggleChest(feeder, true);
                    }
                    if (hasOpenedChest) {
                        //toggleChest(feeder, false);
                        ItemStack stack = getFoodFromInventory(feeder, this.entity.level().random);
                        if (stack == ItemStack.EMPTY) {
                            this.stop();
                        } else {
                            ItemStack duplicate = stack.copy();
                            duplicate.setCount(1);
                            if (!this.entity.getItemInHand(InteractionHand.MAIN_HAND).isEmpty() && !this.entity.level().isClientSide) {
                                this.entity.spawnAtLocation(this.entity.getItemInHand(InteractionHand.MAIN_HAND), 0.0F);
                            }
                            this.entity.setItemInHand(InteractionHand.MAIN_HAND, duplicate);
                            stack.shrink(1);
                            if (this.entity.level() instanceof ServerLevel) {
                                for (ServerPlayer serverplayer : ((ServerLevel)this.entity.level()).getPlayers(server -> server.distanceTo(this.entity) < 256.0F)) {
                                    CreateGarnishedTriggers.SQUIRREL_THIEVING.get().trigger(serverplayer);
                                }
                            }
                            this.stop();
                        }
                    }
                }
            }
        }
    }


    public void stop() {
        super.stop();
        BlockEntity te = this.entity.level().getBlockEntity(this.blockPos);
        if (te instanceof Container) {
            toggleChest((Container) te, false);
        }
        this.blockPos = BlockPos.ZERO;
        this.hasOpenedChest = false;
        this.entity.setThieving(false);
    }


    @Override
    protected boolean isValidTarget(@NotNull LevelReader worldIn, @NotNull BlockPos pos) {
        return isChestRaidable(worldIn, pos);
    }

    public void toggleChest(Container te, boolean open) {
        if (te instanceof ChestBlockEntity chest) {
            if (open) {
                this.entity.level().blockEvent(this.blockPos, chest.getBlockState().getBlock(), 1, 1);
            } else {
                this.entity.level().blockEvent(this.blockPos, chest.getBlockState().getBlock(), 1, 0);
            }
            this.entity.level().updateNeighborsAt(blockPos, chest.getBlockState().getBlock());
            this.entity.level().updateNeighborsAt(blockPos.below(), chest.getBlockState().getBlock());
        }
    }
}