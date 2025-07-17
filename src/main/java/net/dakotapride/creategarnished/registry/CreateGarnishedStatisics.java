package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreateGarnishedStatisics {
    public static final DeferredRegister<ResourceLocation> STATS = DeferredRegister.create(BuiltInRegistries.CUSTOM_STAT, CreateGarnished.ID);

    public static final DeferredHolder<ResourceLocation, ResourceLocation> HATCHET_KILLS = STATS.register("hatchet_kills", () -> CreateGarnished.asResource("hatchet_kills"));
    public static final DeferredHolder<ResourceLocation, ResourceLocation> MONSTER_HATCHET_KILLS = STATS.register("monster_hatchet_kills", () -> CreateGarnished.asResource("monster_hatchet_kills"));
}
