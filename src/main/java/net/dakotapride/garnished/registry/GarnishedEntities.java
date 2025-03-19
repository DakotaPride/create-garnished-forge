package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.entity.boat.NutBoatEntity;
import net.dakotapride.garnished.entity.boat.NutChestBoatEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

//@EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.MOD)
public class GarnishedEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, CreateGarnished.ID);

    public static final DeferredHolder<EntityType<?>, EntityType<NutBoatEntity>> NUT_BOAT =
            ENTITIES.register("nut_boat", () -> EntityType.Builder.<NutBoatEntity>of(NutBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("nut_boat"));
    public static final DeferredHolder<EntityType<?>, EntityType<NutChestBoatEntity>> NUT_CHEST_BOAT =
            ENTITIES.register("nut_chest_boat", () -> EntityType.Builder.<NutChestBoatEntity>of(NutChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("nut_chest_boat"));

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }

}
