package net.dakotapride.garnished.entity.boat;

import net.dakotapride.garnished.registry.GarnishedEntities;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class NutChestBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public NutChestBoatEntity(EntityType<? extends ChestBoat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public NutChestBoatEntity(Level pLevel, double pX, double pY, double pZ) {
        this(GarnishedEntities.NUT_CHEST_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        switch (getModVariant()) {
            case NUT -> {
                return GarnishedItems.NUT_CHEST_BOAT.get();
            }
        }
        return super.getDropItem();
    }

    public void setVariant(NutBoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, NutBoatEntity.Type.NUT.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(NutBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

    public NutBoatEntity.Type getModVariant() {
        return NutBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }
}