package net.dakotapride.creategarnished.registry;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class CreateGarnishedUtils {

    public static <T extends LivingEntity> void hauntingEntityConversion(Level level, Entity entity, EntityType<T> convertingTo) {
        createFanProcessingEntityConversion(level, entity, convertingTo, "Haunting");
    }

    public static <T extends LivingEntity> void washingEntityConversion(Level level, Entity entity, EntityType<T> convertingTo) {
        createFanProcessingEntityConversion(level, entity, convertingTo, "Washing");
    }

    public static <T extends LivingEntity> void smokingEntityConversion(Level level, Entity entity, EntityType<T> convertingTo) {
        createFanProcessingEntityConversion(level, entity, convertingTo, "Smoking");
    }

    public static <T extends LivingEntity> void blastingEntityConversion(Level level, Entity entity, EntityType<T> convertingTo) {
        createFanProcessingEntityConversion(level, entity, convertingTo, "Blasting");
    }

    public static <T extends LivingEntity> void createFanProcessingEntityConversion(Level level, Entity entity, EntityType<T> convertingTo, String processingType) {
        String data = "Create" + processingType;
        if (entity instanceof LivingEntity living) {
            int progress = living.getPersistentData().getInt(data);
            if (progress < 100) {
                if (progress % 10 == 0) {
                    level.playSound(null, entity.blockPosition(), SoundEvents.SOUL_ESCAPE.value(), SoundSource.NEUTRAL,
                            1f, 1.5f * progress / 100f);
                }
                living.getPersistentData().putInt(data, progress + 1);
                return;
            }

            level.playSound(null, entity.blockPosition(), SoundEvents.GENERIC_EXTINGUISH_FIRE,
                    SoundSource.NEUTRAL, 1.25f, 0.65f);

            T convert = convertingTo.create(level);
            CompoundTag serializeNBT = living.saveWithoutId(new CompoundTag());
            serializeNBT.remove("UUID");

            // Deprecated .deserializeNBT();
            convert.deserializeNBT(entity.registryAccess(), serializeNBT);
            convert.setPos(living.getPosition(0));
            level.addFreshEntity(convert);
            living.discard();
        }
    }
}
