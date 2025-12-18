package net.dakotapride.creategarnished;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import net.createmod.catnip.lang.FontHelper;
import net.dakotapride.creategarnished.entity.gingerbread_man.client.GingerManiacRenderer;
import net.dakotapride.creategarnished.entity.squirrel.client.SquirrelRenderer;
import net.dakotapride.creategarnished.entity.voltfish.client.VoltfishRenderer;
import net.dakotapride.creategarnished.particle.CaramelParticle;
import net.dakotapride.creategarnished.particle.ElvenMysticalParticleType;
import net.dakotapride.creategarnished.recipe.CreateGarnishedRecipeSerializers;
import net.dakotapride.creategarnished.registry.*;
import net.minecraft.client.particle.ExplodeParticle;
import net.minecraft.client.particle.SpellParticle;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CreateGarnished.ID)
public class CreateGarnished {
    public static final String ID = "creategarnished";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);

    static {
        REGISTRATE.setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE));
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }

    public CreateGarnished(IEventBus modEventBus, ModContainer modContainer) {
        ModLoadingContext modLoadingContext = ModLoadingContext.get();

        REGISTRATE.registerEventListeners(modEventBus);

        modEventBus.addListener(this::commonSetup);

        //BLOCKS.register(modEventBus);
        //ITEMS.register(modEventBus);
        //CREATIVE_MODE_TABS.register(modEventBus);

        CreateGarnishedBlocks.register();
        CreateGarnishedItems.register();
        CreateGarnishedCreativeModeTabs.register(modEventBus);
        CreateGarnishedFluids.register();
        CreateGarnishedParticles.register(modEventBus);
        CreateGarnishedStatusEffects.register(modEventBus);
        CreateGarnishedPotions.register(modEventBus);
        CreateGarnishedEntityTypes.register(modEventBus);
        CreateGarnishedRecipeSerializers.register(modEventBus);

        CreateGarnishedTriggers.register(modEventBus);
        CreateGarnishedStatisics.STATS.register(modEventBus);

        CreateGarnishedConfigs.register(modLoadingContext, modContainer);

        CreateGarnishedSounds.register(modEventBus);

        //NeoForge.EVENT_BUS.register(this);

        //modEventBus.addListener(this::addCreative);
        modEventBus.addListener(CreateGarnished::enqueue);

        LOGGER.info("[WARNING] Create: Garnished Reworked EMI Compatibility is limited and may be incorrect depending on the config settings presented by the mod.");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        CreateGarnishedFluids.registerFluidInteractions();
    }

    private static void enqueue(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Stats.CUSTOM.get(CreateGarnishedStatisics.HATCHET_KILLS.get(), StatFormatter.DEFAULT);
            Stats.CUSTOM.get(CreateGarnishedStatisics.MONSTER_HATCHET_KILLS.get(), StatFormatter.DEFAULT);
        });
    }

//    private void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
//            event.accept(EXAMPLE_BLOCK_ITEM);
//    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        //LOGGER.info("HELLO from server starting");
    }

    @EventBusSubscriber(modid = ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
    public static class ModEvents {
        @SubscribeEvent
        public static void registerCapabilities(RegisterCapabilitiesEvent event) {
            //BirchLogExtractingSapBlockEntity.registerCapabilities(event);
        }
    }

    @EventBusSubscriber(modid = ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(CreateGarnishedEntityTypes.VOLTFISH.get(), VoltfishRenderer::new);
            EntityRenderers.register(CreateGarnishedEntityTypes.SQUIRREL.get(), SquirrelRenderer::new);
            EntityRenderers.register(CreateGarnishedEntityTypes.GINGERMANIAC.get(), GingerManiacRenderer::new);
        }

        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(CreateGarnishedParticles.ELVEN_MYSTICAL_PARTICLE.get(), ElvenMysticalParticleType.Provider::new);
            event.registerSpriteSet(CreateGarnishedParticles.HATCHET_PARTICLE.get(), ExplodeParticle.Provider::new);
            event.registerSpriteSet(CreateGarnishedParticles.VOLT.get(), SpellParticle.Provider::new);
            event.registerSpriteSet(CreateGarnishedParticles.CARAMEL.get(), CaramelParticle.Provider::new);
        }

        @SubscribeEvent
        public static void onAddPackFinders(AddPackFindersEvent event) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                registerBuiltinResourcePack(event, "old_porphyry", "Old Porphyry Textures", PackSource.BUILT_IN, false);
            }
        }

        private static void registerBuiltinResourcePack(AddPackFindersEvent event, String folder, String name, PackSource source, boolean alwaysActive) {
            event.addPackFinders(
                    asResource("assets/creategarnished/resourcepacks/" + folder),
                    PackType.CLIENT_RESOURCES,
                    Component.literal(name),
                    source,
                    alwaysActive,
                    Pack.Position.TOP);
        }
    }
}
