package net.dakotapride.creategarnished.entity.bucketfish;

import it.unimi.dsi.fastutil.doubles.DoubleDoubleImmutablePair;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.function.IntFunction;

public class BucketFishEntity extends AbstractFish implements VariantHolder<BucketFishEntity.Type> {
    private static final EntityDataAccessor<Integer> DATA_TYPE_ID = SynchedEntityData.defineId(BucketFishEntity.class, EntityDataSerializers.INT);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public BucketFishEntity(EntityType<? extends AbstractFish> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected @NotNull SoundEvent getFlopSound() {
        return SoundEvents.SALMON_FLOP;
    }

    @Override
    public @NotNull ItemStack getBucketItemStack() {
        return null;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (!source.is(DamageTypeTags.NO_KNOCKBACK)) {
            if (source.getSourcePosition() != null) {
                double d0 = source.getSourcePosition().x() - this.getX();
                double d1 = source.getSourcePosition().z() - this.getZ();

                this.knockback(0.8F, d0, d1);
            }
        }
        return false;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_TYPE_ID, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Type", this.getVariant().getSerializedName());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setVariant(Type.byName(compound.getString("Type")));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @javax.annotation.Nullable SpawnGroupData spawnGroupData) {
        if (spawnType == MobSpawnType.BUCKET) {
            return spawnGroupData;
        } else {
            RandomSource randomsource = level.getRandom();
            spawnGroupData = new BucketFishGroupData(Type.getSpawnVariant(randomsource));

            this.setVariant(((BucketFishGroupData)spawnGroupData).getVariant(randomsource));

            return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        }
    }

    private void setupAnimationStates() {
        if (!this.isSwimming()) {
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = 40;
                this.idleAnimationState.start(this.tickCount);
            } else {
                --this.idleAnimationTimeout;
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public void setVariant(BucketFishEntity.Type type) {
        this.entityData.set(DATA_TYPE_ID, type.getId());
    }

    @Override
    public BucketFishEntity.Type getVariant() {
        return BucketFishEntity.Type.byId(this.entityData.get(DATA_TYPE_ID));
    }

    public static class BucketFishGroupData extends AgeableMob.AgeableMobGroupData {
        public final BucketFishEntity.Type[] types;

        public BucketFishGroupData(BucketFishEntity.Type... types) {
            super(false);
            this.types = types;
        }

        public Type getVariant(RandomSource random) {
            return this.types[random.nextInt(this.types.length)];
        }
    }

    public enum Type implements StringRepresentable {
        BASIC(0, "basic"),
        RED(1, "red"),
        ORANGE(2, "orange"),
        YELLOW(3, "yellow"),
        GREEN(4, "green"),
        LIME(5, "lime"),
        BLUE(6, "blue"),
        LIGHT_BLUE(7, "light_blue"),
        CYAN(8, "cyan"),
        PURPLE(9, "purple"),
        MAGENTA(10, "magenta"),
        PINK(11, "pink"),
        BLACK(12, "black"),
        GRAY(13, "gray"),
        LIGHT_GRAY(14, "light_gray"),
        WHITE(15, "white"),
        BROWN(16, "brown"),

        ;

        public static final StringRepresentable.EnumCodec<Type> CODEC = StringRepresentable.fromEnum(Type::values);
        private static final IntFunction<Type> BY_ID = ByIdMap.continuous(Type::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
        private final int id;
        private final String name;

        private Type(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public static Type byName(String name) {
            return CODEC.byName(name, BASIC);
        }

        public static Type byId(int index) {
            return BY_ID.apply(index);
        }

        private static Type getSpawnVariant(RandomSource random) {
            Type[] type = Arrays.stream(values()).toArray(Type[]::new);
            return Util.getRandom(type, random);
        }
    }
}
