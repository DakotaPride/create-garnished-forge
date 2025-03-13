package net.dakotapride.creategarnished;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import net.createmod.catnip.lang.FontHelper;
import net.dakotapride.creategarnished.event.GarnishedColourManager;
import net.dakotapride.creategarnished.registry.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CreateGarnished.ID)
public class CreateGarnished {
    public static final String ID = "creategarnished";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);

    static {
        REGISTRATE.setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE));
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }

    public CreateGarnished() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //modEventBus.addListener(this::commonSetup);

        //BLOCKS.register(modEventBus);
        //ITEMS.register(modEventBus);
        //CREATIVE_MODE_TABS.register(modEventBus);

        CreateGarnishedBlocks.register();
        CreateGarnishedItems.register();
        GarnishedCreativeModeTabs.register(eventBus);
        CreateGarnishedFluids.register();

        CreateGarnishedAdvancements.register(eventBus);

        REGISTRATE.registerEventListeners(eventBus);
        MinecraftForge.EVENT_BUS.register(this);

        //modEventBus.addListener(this::addCreative);
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

    @Mod.EventBusSubscriber(modid = ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            //LOGGER.info("HELLO FROM CLIENT SETUP");
            //LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
