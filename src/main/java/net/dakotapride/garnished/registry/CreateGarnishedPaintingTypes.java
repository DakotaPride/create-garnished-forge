package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CreateGarnishedPaintingTypes {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, CreateGarnished.ID);

    public static final RegistryObject<PaintingVariant> ABSOLUTE_NUTZ = registerPaintingType("absolute_nutz", 4, 4);
    public static final RegistryObject<PaintingVariant> CANDIED_OBSIDIAN = registerPaintingType("candied_obsidian", 1, 1);
    public static final RegistryObject<PaintingVariant> DEAUDIE = registerPaintingType("deaudie", 1, 2);
    public static final RegistryObject<PaintingVariant> DEVELOPER = registerPaintingType("developer", 1, 2);
    public static final RegistryObject<PaintingVariant> INSPIRATION = registerPaintingType("inspiration", 1, 2);
    public static final RegistryObject<PaintingVariant> OLD_ASURINE = registerPaintingType("asurine_generation", 4, 4);
    public static final RegistryObject<PaintingVariant> OLD_CRIMSITE = registerPaintingType("crimsite_generation", 4, 4);
    public static final RegistryObject<PaintingVariant> OLD_OCHRUM = registerPaintingType("ochrum_generation", 4, 4);
    public static final RegistryObject<PaintingVariant> OLD_VERIDIUM = registerPaintingType("veridium_generation", 4, 4);
    public static final RegistryObject<PaintingVariant> PANDA = registerPaintingType("panda", 1, 2);
    public static final RegistryObject<PaintingVariant> QUACK = registerPaintingType("quack", 1, 2);
    public static final RegistryObject<PaintingVariant> SALTY = registerPaintingType("salty", 2, 2);

    private static RegistryObject<PaintingVariant> registerPaintingType(String id, int w, int h) {
        return PAINTING_VARIANTS.register(id, () -> new PaintingVariant(w*16, h*16));
    }

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}