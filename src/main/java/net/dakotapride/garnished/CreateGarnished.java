package net.dakotapride.garnished;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.infrastructure.data.CreateDatagen;
import net.createmod.catnip.lang.FontHelper;
import net.dakotapride.garnished.block.cake.AnniversaryCakeBlockRenderer;
import net.dakotapride.garnished.datagen.CreateGarnishedDatagen;
import net.dakotapride.garnished.entity.render.NutBoatRenderer;
import net.dakotapride.garnished.neoforge.LootModifiers;
import net.dakotapride.garnished.recipe.GarnishedFanProcessing;
import net.dakotapride.garnished.registry.*;
import net.dakotapride.garnished.registry.recipe.GarnishedRecipeTypes;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.fml.event.lifecycle.InterModProcessEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("garnished")
public class CreateGarnished {




    // T.ODO: FIX THE RAVAGING LOOT TABLES
    // T.ODO: FIX THE SALVAGING LOOT TABLES
    // TODO: FIX FAN PROCESSING TYPES
    // TODO: FIX FAN PROCESSING RECIPE TYPES
    // T.ODO: FIX STRIKING DAMAGE MULTIPLIER NOT BEING APPLIED NO MATTER THE ENCHANTMENT LEVEL - WAS APPARENTLY NEVER AN ISSUE, MINECRAFT JUST CHANGED HOW DAMAGE IS SHOWN IN THE TOOLTIP FOR SOME REASON
    // TODO: PORT ALL RECIPES TO HAVE "item": { "id": "<ITEM>" } because of 1.21 changes
    // TODO: MAKE SURE THAT ALL RECIPES USING A HEAT REQUIREMENT ARE FORMATTED CORRECTLY
    // TODO: MAKE SURE THAT ALL RECIPES USING PROCESSING SPEED ARE FORMATTED CORRECTLY




    // Directly reference a slf4j logger
    public static final String ID = "garnished";
    public static final String NAME = "Create: Garnished";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);

    static {
        REGISTRATE.setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE));
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }

    public CreateGarnished(IEventBus eventBus, ModContainer modContainer) {

        //GarnishedEntities.ENTITIES.register(eventBus);
        GarnishedEntities.register(eventBus);
        //GarnishedBlockEntities.BLOCK_ENTITIES.register(eventBus);
        GarnishedEffects.setRegister(eventBus);
        //Removed in 1.21.x (rework parity feature)
        //GarnishedEnchantments.setRegister();
        GarnishedSetTypes.setRegister();
        GarnishedItems.setRegister();
        GarnishedBlocks.setRegister();
        GarnishedBlockEntities.register(eventBus);
        GarnishedCT.setRegister();
        GarnishedTabs.setRegister(eventBus);
        GarnishedFluids.setRegister();
        GarnishedFoodValues.setRegister();
        GarnishedFeatures.setRegister(eventBus);
        GarnishedTags.setRegister();
        GarnishedRecipeTypes.register(eventBus);
        //GarnishedFanProcessing.register();
        LootModifiers.register(eventBus);

        GarnishedAdvancementUtils.register(eventBus);
        eventBus.addListener(CreateGarnished::onRegister);
        //eventBus.addListener(EventPriority.LOWEST, CreateGarnishedDatagen::gatherData);

        REGISTRATE.registerEventListeners(eventBus);
        // Register the setup method for modloading
        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        NeoForge.EVENT_BUS.register(this);
    }

    public static void onRegister(final RegisterEvent event) {
        GarnishedFanProcessing.register();
    }

    @SubscribeEvent
    public void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, GarnishedItems.BRITTLE_DUST.get(), GarnishedEffects.AVERSION_POTION);
        builder.addMix(GarnishedEffects.AVERSION_POTION, Items.REDSTONE, GarnishedEffects.LONG_AVERSION_POTION);
        builder.addMix(Potions.AWKWARD, GarnishedItems.ENDER_JELLY_BLOB.get(), GarnishedEffects.FLAGRANT_POTION);

        builder.addMix(Potions.AWKWARD, GarnishedItems.SENILE_SWEET_BLACKSTONE.get(), GarnishedEffects.BLINDNESS_POTION);
        builder.addMix(Potions.AWKWARD, GarnishedItems.SENILE_SWEET_BASALT.get(), Potions.WEAKNESS);
        builder.addMix(Potions.AWKWARD, GarnishedItems.SENILE_SWEET_SCORIA.get(), Potions.POISON);
        builder.addMix(Potions.AWKWARD, GarnishedItems.SENILE_SWEET_SCORCHIA.get(), Potions.SLOWNESS);

        builder.addMix(Potions.AWKWARD, GarnishedItems.VOLATILE_DUST.get(), GarnishedEffects.SANCTITY_POTION);

        builder.addMix(Potions.MUNDANE, GarnishedItems.SOLEMN_DUST.get(), GarnishedEffects.MUMMIFICATION_POTION);

        builder.addMix(Potions.THICK, GarnishedItems.FROST.get(), GarnishedEffects.FREEZING_POTION);
        builder.addMix(GarnishedEffects.FREEZING_POTION, Items.REDSTONE, GarnishedEffects.LONG_FREEZING_POTION);
    }

    private void setup(FMLCommonSetupEvent event) {

        event.enqueueWork(GarnishedFluids::registerFluidInteractions);

        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GarnishedBlocks.SEPIA_FUNGUS.getId(), GarnishedBlocks.POTTED_SEPIA_FUNGUS);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GarnishedBlocks.SOUL_ROOTS.getId(), GarnishedBlocks.POTTED_SOUL_ROOTS);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GarnishedBlocks.BARREN_ROOTS.getId(), GarnishedBlocks.POTTED_BARREN_ROOTS);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GarnishedBlocks.SMALL_CHORUS_PLANT.getId(), GarnishedBlocks.POTTED_SMALL_CHORUS_PLANT);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GarnishedBlocks.PANSOPHICAL_DAISY.getId(), GarnishedBlocks.POTTED_PANSOPHICAL_DAISY);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GarnishedBlocks.INCANDESCENT_LILY.getId(), GarnishedBlocks.POTTED_INCANDESCENT_LILY);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GarnishedBlocks.AUREATE_SHRUB.getId(), GarnishedBlocks.POTTED_AUREATE_SHRUB);

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

    @EventBusSubscriber(modid = ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            Sheets.addWoodType(GarnishedWoodType.NUT);
            Sheets.addWoodType(GarnishedWoodType.SEPIA);
            // GarnishedPonderIndex.index();
            // NewIndex.index();
            // GarnishedPonderIndex.Tags.fillPonderTags();
            // NewIndex.PonderIndexTags.tags();

            EntityRenderers.register(GarnishedEntities.NUT_BOAT.get(), pContext -> new NutBoatRenderer(pContext, false));
            EntityRenderers.register(GarnishedEntities.NUT_CHEST_BOAT.get(), pContext -> new NutBoatRenderer(pContext, true));

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.NUT_PLANT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.NUT_LEAVES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.UNASSIGNED_NUT_LEAVES.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.ALMOND_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.CASHEW_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.WALNUT_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PECAN_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BUHG_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PISTACHIO_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.MACADAMIA_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.HAZELNUT_LEAVES.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.CHESTNUT_LEAVES.get(), RenderType.cutoutMipped());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.ALMOND_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.CASHEW_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.WALNUT_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PECAN_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BUHG_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PISTACHIO_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.MACADAMIA_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.HAZELNUT_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.CHESTNUT_SAPLING.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.SEPIA_FUNGUS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.SEPIA_DOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.SEPIA_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.SEPIA_WINDOW.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.SEPIA_WINDOW_PANE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.SOUL_ROOTS.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BLOCK_OF_ENDER_JELLY.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BARREN_ROOTS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.SMALL_CHORUS_PLANT.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.NUT_DOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.NUT_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.NUT_WINDOW.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.NUT_WINDOW_PANE.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.RED_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.ORANGE_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.YELLOW_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.GREEN_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.LIME_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BLUE_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.LIGHT_BLUE_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.CYAN_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PURPLE_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.MAGENTA_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PINK_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BLACK_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.GRAY_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.LIGHT_GRAY_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.WHITE_MASTIC_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BROWN_MASTIC_BLOCK.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.VERMILION_KELP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.VERMILION_KELP_PLANT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.DULSE_KELP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.DULSE_KELP_PLANT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.VOLTAIC_SEA_GRASS.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.PANSOPHICAL_DAISY.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.POTTED_PANSOPHICAL_DAISY.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.INCANDESCENT_LILY.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.POTTED_INCANDESCENT_LILY.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.SORROWFUL_LICHEN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.AUREATE_SHRUB.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.POTTED_SEPIA_FUNGUS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.POTTED_SOUL_ROOTS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.POTTED_BARREN_ROOTS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.POTTED_SMALL_CHORUS_PLANT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.POTTED_AUREATE_SHRUB.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(GarnishedBlocks.BOK_CHOY_PLANT.get(), RenderType.cutout());
        }

        @SubscribeEvent
        public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
            // event.registerEntityRenderer(HibernalEntityTypes.MYQUESTE_BOAT.get(), context -> new MyquesteBoatRenderer(context, false));
            // event.registerEntityRenderer(HibernalEntityTypes.MYQUESTE_CHEST_BOAT.get(), context -> new MyquesteBoatRenderer(context, true));
            event.registerBlockEntityRenderer(GarnishedBlockEntities.SIGN.get(), SignRenderer::new);
            event.registerBlockEntityRenderer(GarnishedBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
            event.registerBlockEntityRenderer(GarnishedBlockEntities.CAKE.get(), AnniversaryCakeBlockRenderer::new);
        }

        public static final ModelLayerLocation NUT_BOAT_LAYER = new ModelLayerLocation(
                CreateGarnished.asResource("boat/nut"), "main");
        public static final ModelLayerLocation NUT_CHEST_BOAT_LAYER = new ModelLayerLocation(
                CreateGarnished.asResource("chest_boat/nut"), "main");

        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(NUT_BOAT_LAYER, BoatModel::createBodyModel);
            event.registerLayerDefinition(NUT_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        }

        @SubscribeEvent
        public static void onAddPackFinders(AddPackFindersEvent event) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                registerBuiltinResourcePack(event, "legacy_amber");
            }
        }

        private static void registerBuiltinResourcePack(AddPackFindersEvent event, String folder) {
            event.addPackFinders(
                    asResource("resourcepacks/" + folder),
                    PackType.CLIENT_RESOURCES,
                    Component.literal(ID + "/" + folder),
                    PackSource.BUILT_IN,
                    false,
                    Pack.Position.TOP);
        }
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }
}
