package net.dakotapride.garnished;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllPackets;
import com.simibubi.create.content.equipment.potatoCannon.BuiltinPotatoProjectileTypes;
import com.simibubi.create.content.fluids.tank.BoilerHeaters;
import com.simibubi.create.content.schematics.SchematicInstances;
import com.simibubi.create.foundation.advancement.AllAdvancements;
import com.simibubi.create.foundation.advancement.AllTriggers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.AttachedRegistry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.dakotapride.garnished.registry.*;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("garnished")
public class CreateGarnished
{
    // Directly reference a slf4j logger

    public static final String ID = "garnished";
    public static final String NAME = "Create: Garnished";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    private static final NonNullSupplier<CreateRegistrate> REGISTRATE =
            NonNullSupplier.lazy(() -> CreateRegistrate.create(ID));

    public CreateGarnished() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        GarnishedItems.setRegister();
        GarnishedBlocks.setRegister();
        GarnishedFluids.setRegister();
        GarnishedTabs.setRegister();
        GarnishedFoods.setRegister();
        GarnishedFeatures.setRegister(eventBus);

        REGISTRATE.get().registerEventListeners(eventBus);
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code

        event.enqueueWork(GarnishedFluids::registerFluidInteractions);

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // Some example code to dispatch IMC to another mod
        // InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event) {
        // Some example code to receive and process InterModComms from other mods
        // LOGGER.info("Got IMC {}", event.getIMCStream().
        //        map(m->m.messageSupplier().get()).
        //        collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }

    @Mod.EventBusSubscriber(modid = ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.NUT_PLANT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.NUT_LEAVES.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.ALMOND_LEAVES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.CASHEW_LEAVES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.WALNUT_LEAVES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PECAN_LEAVES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BUHG_LEAVES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PISTACHIO_LEAVES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.MACADAMIA_LEAVES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.HAZELNUT_LEAVES.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.ALMOND_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.CASHEW_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.WALNUT_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PECAN_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BUHG_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PISTACHIO_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.MACADAMIA_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.HAZELNUT_SAPLING.get(), RenderType.cutout());
        }
        @SubscribeEvent
        public static void onBlockColourProvider(RegisterColorHandlersEvent.Block event) {
            blockColourProvider(event.getBlockColors());
        }
        @SubscribeEvent
        public static void onItemColourProvider(RegisterColorHandlersEvent.Item event) {
            itemColourProvider(event.getBlockColors(), event.getItemColors());
        }
    }

    public static synchronized void blockColourProvider(BlockColors colors) {
        colors.register((unknown, lightReader, pos, unknown2) -> lightReader != null && pos != null ?
                        BiomeColors.getAverageFoliageColor(lightReader, pos) : FoliageColor.get(0.5D, 1.0D),
                GarnishedBlocks.NUT_LEAVES.get(),
                GarnishedBlocks.ALMOND_LEAVES.get(), GarnishedBlocks.CASHEW_LEAVES.get(), GarnishedBlocks.WALNUT_LEAVES.get(),
                GarnishedBlocks.PECAN_LEAVES.get(), GarnishedBlocks.BUHG_LEAVES.get(), GarnishedBlocks.PISTACHIO_LEAVES.get(),
                GarnishedBlocks.MACADAMIA_LEAVES.get(), GarnishedBlocks.HAZELNUT_LEAVES.get());
    }

    public static synchronized void itemColourProvider(BlockColors colors, ItemColors itemColors) {
        ItemColor itemBlockColourHandler = (stack, tintIndex) -> {
            BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return colors.getColor(state, null, null, tintIndex);
        };

        itemColors.register(itemBlockColourHandler, GarnishedBlocks.NUT_LEAVES.get(),
                GarnishedBlocks.ALMOND_LEAVES.get(), GarnishedBlocks.CASHEW_LEAVES.get(), GarnishedBlocks.WALNUT_LEAVES.get(),
                GarnishedBlocks.PECAN_LEAVES.get(), GarnishedBlocks.BUHG_LEAVES.get(), GarnishedBlocks.PISTACHIO_LEAVES.get(),
                GarnishedBlocks.MACADAMIA_LEAVES.get(), GarnishedBlocks.HAZELNUT_LEAVES.get());
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE.get();
    }
}
