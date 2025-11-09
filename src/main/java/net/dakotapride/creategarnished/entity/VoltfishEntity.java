package net.dakotapride.creategarnished.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VoltfishEntity extends AbstractFish {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public VoltfishEntity(EntityType<? extends AbstractFish> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        //0 = highest selector
        //this.goalSelector.addGoal(0, GOAL);
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, true));
        super.registerGoals();
    }

    public static AttributeSupplier.@NotNull Builder createAttributes() {
        return AbstractFish.createAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY)
                .add(Attributes.FOLLOW_RANGE, 240.0D);
    }

    @Override
    protected @NotNull SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    public @NotNull ItemStack getBucketItemStack() {
        return null;
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 60;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    static class VoltfishMoveControl extends MoveControl {
        private final AbstractFish fish;

        VoltfishMoveControl(AbstractFish fish) {
            super(fish);
            this.fish = fish;
        }

        public void tick() {
            if (this.fish.isEyeInFluid(FluidTags.WATER)) {
                this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0F, 0.005, 0.0F));
            }

            if (this.operation == Operation.MOVE_TO && !this.fish.getNavigation().isDone()) {
                if (this.fish.isAggressive()) {
                    float f = (float) (this.speedModifier * this.fish.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    this.fish.setSpeed((float) (Mth.lerp(0.125F, this.fish.getSpeed(), f) * 1.5));
                    double d0 = this.wantedX - this.fish.getX();
                    double d1 = this.wantedY - this.fish.getY();
                    double d2 = this.wantedZ - this.fish.getZ();
                    if (d1 != (double) 0.0F) {
                        double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                        this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0F, (double) this.fish.getSpeed() * (d1 / d3) * 0.1, 0.0F));
                    }

                    if (d0 != (double) 0.0F || d2 != (double) 0.0F) {
                        float f1 = (float) (Mth.atan2(d2, d0) * (double) 180.0F / (double) (float) Math.PI) - 90.0F;
                        this.fish.setYRot(this.rotlerp(this.fish.getYRot(), f1, 90.0F));
                        this.fish.yBodyRot = this.fish.getYRot();
                    }
                } else {
                    float f = (float) (this.speedModifier * this.fish.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    this.fish.setSpeed(Mth.lerp(0.125F, this.fish.getSpeed(), f));
                    double d0 = this.wantedX - this.fish.getX();
                    double d1 = this.wantedY - this.fish.getY();
                    double d2 = this.wantedZ - this.fish.getZ();
                    if (d1 != (double) 0.0F) {
                        double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                        this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0F, (double) this.fish.getSpeed() * (d1 / d3) * 0.1, 0.0F));
                    }

                    if (d0 != (double) 0.0F || d2 != (double) 0.0F) {
                        float f1 = (float) (Mth.atan2(d2, d0) * (double) 180.0F / (double) (float) Math.PI) - 90.0F;
                        this.fish.setYRot(this.rotlerp(this.fish.getYRot(), f1, 90.0F));
                        this.fish.yBodyRot = this.fish.getYRot();
                    }
                }
            } else {
                this.fish.setSpeed(0.0F);
            }

        }
    }
}
