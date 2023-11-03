package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.block.entity.HangingSignEntity;
import net.dakotapride.garnished.block.entity.SignEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = CreateGarnished.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GarnishedBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CreateGarnished.ID);

    public static final RegistryObject<BlockEntityType<SignEntity>> SIGN =
            BLOCK_ENTITIES.register("sign", () -> BlockEntityType.Builder.of(SignEntity::new,
                    GarnishedBlocks.SEPIA_SIGN.get(), GarnishedBlocks.SEPIA_WALL_SIGN.get(),
                    GarnishedBlocks.NUT_SIGN.get(), GarnishedBlocks.NUT_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<HangingSignEntity>> HANGING_SIGN =
            BLOCK_ENTITIES.register("hanging_sign", () -> BlockEntityType.Builder.of(HangingSignEntity::new,
                    GarnishedBlocks.SEPIA_HANGING_SIGN.get(), GarnishedBlocks.SEPIA_WALL_HANGING_SIGN.get(),
                    GarnishedBlocks.NUT_HANGING_SIGN.get(), GarnishedBlocks.NUT_WALL_HANGING_SIGN.get()).build(null));

}
