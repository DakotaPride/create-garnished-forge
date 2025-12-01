package net.dakotapride.creategarnished.mixin;

import net.dakotapride.creategarnished.entity.squirrel.SquirrelEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AbstractIllager.class, remap = false)
public abstract class AbstractIllagerMixin extends Raider {
    public AbstractIllagerMixin(EntityType<? extends Raider> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "registerGoals", at = @At("HEAD"))
    private void registerGoals(CallbackInfo ci) {
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, SquirrelEntity.class, 6.0F, 1.0, 1.2));
    }

}
