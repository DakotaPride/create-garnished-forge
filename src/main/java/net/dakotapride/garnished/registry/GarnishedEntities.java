package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.block.entity.HangingSignEntity;
import net.dakotapride.garnished.block.entity.SignEntity;
import net.dakotapride.garnished.entity.boat.NutBoatEntity;
import net.dakotapride.garnished.entity.boat.NutChestBoatEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = CreateGarnished.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GarnishedEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CreateGarnished.ID);

    public static final RegistryObject<EntityType<NutBoatEntity>> NUT_BOAT =
            ENTITIES.register("nut_boat", () -> EntityType.Builder.<NutBoatEntity>of(NutBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("nut_boat"));
    public static final RegistryObject<EntityType<NutChestBoatEntity>> NUT_CHEST_BOAT =
            ENTITIES.register("nut_chest_boat", () -> EntityType.Builder.<NutChestBoatEntity>of(NutChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("nut_chest_boat"));

}
