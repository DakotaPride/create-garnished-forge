package net.dakotapride.creategarnished.mixin;

import com.simibubi.create.content.kinetics.fan.processing.AllFanProcessingTypes;
import net.dakotapride.creategarnished.registry.CreateGarnishedConfigs;
import net.dakotapride.creategarnished.util.CreateGarnishedUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AllFanProcessingTypes.HauntingType.class, remap = false)
public class HauntingTypeMixin {
    @Inject(method = "affectEntity", at = @At("RETURN"), remap = false)
    private void affectEntity(Entity entity, Level level, CallbackInfo ci) {
        if (entity.getType() == EntityType.GUARDIAN && CreateGarnishedConfigs.server().entity.enableElderGuardianConversion.get())
            CreateGarnishedUtils.hauntingEntityConversion(level, entity, EntityType.ELDER_GUARDIAN);

        if (entity.getType() == EntityType.COW && CreateGarnishedConfigs.server().entity.enableMooshroomConversion.get())
            CreateGarnishedUtils.hauntingEntityConversion(level, entity, EntityType.MOOSHROOM);
    }
}
