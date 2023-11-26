package net.dakotapride.garnished;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.dakotapride.garnished.entity.render.NutBoatRenderer;
import net.dakotapride.garnished.registry.*;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
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
    public static final NonNullSupplier<CreateRegistrate> REGISTRATE =
            NonNullSupplier.lazy(() -> CreateRegistrate.create(ID));

    public CreateGarnished() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        GarnishedEntities.ENTITIES.register(eventBus);
        GarnishedBlockEntities.BLOCK_ENTITIES.register(eventBus);
        GarnishedEffects.setRegister(eventBus);
        GarnishedEnchantments.setRegister();
        GarnishedSetTypes.setRegister();
        GarnishedItems.setRegister();
        GarnishedBlocks.setRegister();
        GarnishedTabs.setRegister(eventBus);
        GarnishedFluids.setRegister();
        GarnishedFoods.setRegister();
        GarnishedFeatures.setRegister();
        GarnishedTags.setRegister();

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

    private void setup(FMLCommonSetupEvent event) {

        PotionBrewing.addMix(Potions.AWKWARD, GarnishedItems.BRITTLE_DUST.get(), GarnishedEffects.AVERSION_POTION.get());
        PotionBrewing.addMix(GarnishedEffects.AVERSION_POTION.get(), Items.REDSTONE, GarnishedEffects.LONG_AVERSION_POTION.get());
        PotionBrewing.addMix(Potions.AWKWARD, GarnishedItems.ENDER_JELLY_BLOB.get(), GarnishedEffects.FLAGRANT_POTION.get());

        PotionBrewing.addMix(Potions.AWKWARD, GarnishedItems.SENILE_SWEET_BLACKSTONE.get(), GarnishedEffects.BLINDNESS_POTION.get());
        PotionBrewing.addMix(Potions.AWKWARD, GarnishedItems.SENILE_SWEET_BASALT.get(), Potions.WEAKNESS);
        PotionBrewing.addMix(Potions.AWKWARD, GarnishedItems.SENILE_SWEET_SCORIA.get(), Potions.POISON);
        PotionBrewing.addMix(Potions.AWKWARD, GarnishedItems.SENILE_SWEET_SCORCHIA.get(), Potions.SLOWNESS);

        PotionBrewing.addMix(Potions.MUNDANE, GarnishedItems.VOLATILE_DUST.get(), GarnishedEffects.SANCTITY_POTION.get());

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
            EntityRenderers.register(GarnishedEntities.NUT_BOAT.get(), pContext -> new NutBoatRenderer(pContext, false));
            EntityRenderers.register(GarnishedEntities.NUT_CHEST_BOAT.get(), pContext -> new NutBoatRenderer(pContext, true));

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.NUT_PLANT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.NUT_LEAVES.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.ALMOND_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.CASHEW_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.WALNUT_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PECAN_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BUHG_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PISTACHIO_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.MACADAMIA_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.HAZELNUT_LEAVES.get(), RenderType.cutoutMipped());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.ALMOND_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.CASHEW_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.WALNUT_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PECAN_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BUHG_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PISTACHIO_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.MACADAMIA_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.HAZELNUT_SAPLING.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.SEPIA_FUNGUS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.SEPIA_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.SOUL_ROOTS.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BLOCK_OF_ENDER_JELLY.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BARREN_ROOTS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.SMALL_CHORUS_PLANT.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.NUT_DOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.NUT_TRAPDOOR.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.RED_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.ORANGE_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.YELLOW_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.GREEN_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BLUE_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PURPLE_MASTIC_BLOCK.get(), RenderType.translucent());
        }

        @SubscribeEvent
        public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
            // event.registerEntityRenderer(HibernalEntityTypes.MYQUESTE_BOAT.get(), context -> new MyquesteBoatRenderer(context, false));
            // event.registerEntityRenderer(HibernalEntityTypes.MYQUESTE_CHEST_BOAT.get(), context -> new MyquesteBoatRenderer(context, true));
            event.registerBlockEntityRenderer(GarnishedBlockEntities.SIGN.get(), SignRenderer::new);
            event.registerBlockEntityRenderer(GarnishedBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
        }

        public static final ModelLayerLocation NUT_BOAT_LAYER = new ModelLayerLocation(
                new ResourceLocation(CreateGarnished.ID, "boat/nut"), "main");
        public static final ModelLayerLocation NUT_CHEST_BOAT_LAYER = new ModelLayerLocation(
                new ResourceLocation(CreateGarnished.ID, "chest_boat/nut"), "main");

        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(NUT_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(NUT_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        }
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE.get();
    }
}
