package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.entity.bucketfish.BucketFishEntity;
import net.dakotapride.creategarnished.registry.CreateGarnishedEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nullable;

public class BucketfishBucketItem extends MobBucketItem {
    public BucketfishBucketItem(Properties properties) {
        super(CreateGarnishedEntityTypes.BUCKETFISH.get(), Fluids.WATER, SoundEvents.HONEY_BLOCK_PLACE, properties);
    }

    @Override
    public void checkExtraContent(@Nullable Player player, Level level, ItemStack containerStack, BlockPos pos) {
        if (level instanceof ServerLevel) {
            this.spawn((ServerLevel)level, containerStack, pos);
            level.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
        }
    }

    private void spawn(ServerLevel serverLevel, ItemStack bucketedMobStack, BlockPos pos) {
        if (CreateGarnishedEntityTypes.BUCKETFISH.get().spawn(serverLevel, bucketedMobStack, null, pos, MobSpawnType.BUCKET,
                true, false) instanceof BucketFishEntity bucketFish) {
            CustomData customdata = bucketedMobStack.getOrDefault(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY);
            CompoundTag compoundTag = customdata.copyTag();
            bucketFish.loadFromBucketTag(compoundTag);
            bucketFish.setVariant(BucketFishEntity.Type.byName(compoundTag.getString("Type")));
            bucketFish.setFromBucket(true);
        }
    }
}
