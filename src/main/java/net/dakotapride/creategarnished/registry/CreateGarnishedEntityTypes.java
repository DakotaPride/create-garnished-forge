package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.entity.VoltfishEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreateGarnishedEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, CreateGarnished.ID);

    public static final Supplier<EntityType<VoltfishEntity>> VOLTFISH = ENTITY_TYPES.register("voltfish", () -> EntityType.Builder.of(VoltfishEntity::new, MobCategory.WATER_CREATURE)
            .sized(0.5F, 0.5F).build("voltfish"));

    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}
