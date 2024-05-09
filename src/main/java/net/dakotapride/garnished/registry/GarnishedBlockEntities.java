package net.dakotapride.garnished.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.block.cake.AnniversaryCakeBlockEntity;
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


    public class CakeModule {
        // Provide Registration method
        private static final CreateRegistrate REGISTRATE = CreateGarnished.registrate();

        public static final BlockEntityEntry<AnniversaryCakeBlockEntity> CAKE = REGISTRATE
                .blockEntity("anniversary_cake", AnniversaryCakeBlockEntity::new)
                .validBlocks(GarnishedBlocks.ANNIVERSARY_CAKE)
                .register();

        public static void setRegister() {
            // Load CreateGarnished.registrate();
        }
    }


}
