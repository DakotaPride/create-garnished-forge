package net.dakotapride.creategarnished;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import net.createmod.catnip.lang.FontHelper;
import net.dakotapride.creategarnished.particle.ElvenMysticalParticleType;
import net.dakotapride.creategarnished.registry.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
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
        GarnishedCreativeModeTabs.register(modEventBus);
        CreateGarnishedFluids.register();
        CreateGarnishedParticles.register(modEventBus);
        CreateGarnishedStatusEffects.register(modEventBus);
        CreateGarnishedPotions.register(modEventBus);

        CreateGarnishedAdvancements.register(modEventBus);

        CreateGarnishedConfigs.register(modLoadingContext, modContainer);

        //NeoForge.EVENT_BUS.register(this);

        //modEventBus.addListener(this::addCreative);

        LOGGER.info("[WARNING] Create: Garnished Reworked EMI Compatibility is limited and may be incorrect depending on the config settings presented by the mod.");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        CreateGarnishedFluids.registerFluidInteractions();
    }

//    private void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
//            event.accept(EXAMPLE_BLOCK_ITEM);
//    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        //LOGGER.info("HELLO from server starting");
    }

    @EventBusSubscriber(modid = ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }

        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(CreateGarnishedParticles.ELVEN_MYSTICAL_PARTICLE.get(), ElvenMysticalParticleType.Provider::new);
        }
    }
}
