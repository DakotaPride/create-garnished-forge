package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.block.cake.AnniversaryCakeBlockEntity;
import net.dakotapride.garnished.block.entity.HangingSignEntity;
import net.dakotapride.garnished.block.entity.SignEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

//@EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.MOD)
public class GarnishedBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CreateGarnished.ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SignEntity>> SIGN =
            BLOCK_ENTITIES.register("sign", () -> BlockEntityType.Builder.of(SignEntity::new,
                    GarnishedBlocks.SEPIA_SIGN.get(), GarnishedBlocks.SEPIA_WALL_SIGN.get(),
                    GarnishedBlocks.NUT_SIGN.get(), GarnishedBlocks.NUT_WALL_SIGN.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HangingSignEntity>> HANGING_SIGN =
            BLOCK_ENTITIES.register("hanging_sign", () -> BlockEntityType.Builder.of(HangingSignEntity::new,
                    GarnishedBlocks.SEPIA_HANGING_SIGN.get(), GarnishedBlocks.SEPIA_WALL_HANGING_SIGN.get(),
                    GarnishedBlocks.NUT_HANGING_SIGN.get(), GarnishedBlocks.NUT_WALL_HANGING_SIGN.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AnniversaryCakeBlockEntity>> CAKE =
            BLOCK_ENTITIES.register("anniversary_cake", () ->
                    BlockEntityType.Builder.of(AnniversaryCakeBlockEntity::new,
                            GarnishedBlocks.ANNIVERSARY_CAKE.get()).build(null));

    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }

}
