package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.entity.gingerbread_man.GingerManiacEntity;
import net.dakotapride.creategarnished.entity.squirrel.SquirrelEntity;
import net.dakotapride.creategarnished.entity.voltfish.VoltfishEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreateGarnishedEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, CreateGarnished.ID);

    public static final Supplier<EntityType<VoltfishEntity>> VOLTFISH = ENTITY_TYPES.register("voltfish",
            () -> EntityType.Builder.of(VoltfishEntity::new, MobCategory.WATER_CREATURE)
                    .sized(0.65F, 0.5F).eyeHeight(0.2F).build("voltfish"));
    public static final Supplier<EntityType<SquirrelEntity>> SQUIRREL = ENTITY_TYPES.register("squirrel",
            () -> EntityType.Builder.of(SquirrelEntity::new, MobCategory.CREATURE)
                    .sized(0.5F, 0.2F).eyeHeight(0.05F).build("squirrel"));
    public static final Supplier<EntityType<GingerManiacEntity>> GINGERMANIAC = ENTITY_TYPES.register("gingermaniac",
            () -> EntityType.Builder.of(GingerManiacEntity::new, MobCategory.MONSTER)
                    .sized(0.35F, 0.55F).eyeHeight(0.45F).build("gingermaniac"));

    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}
