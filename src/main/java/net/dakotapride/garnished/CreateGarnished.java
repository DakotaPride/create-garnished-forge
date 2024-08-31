package net.dakotapride.garnished;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.dakotapride.garnished.block.cake.AnniversaryCakeBlockRenderer;
import net.dakotapride.garnished.entity.render.NutBoatRenderer;
import net.dakotapride.garnished.forge.LootModifiers;
import net.dakotapride.garnished.recipe.GarnishedFanProcessing;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
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
public class CreateGarnished {
    // Directly reference a slf4j logger

    public static final String ID = "garnished";
    public static final String NAME = "Create: Garnished";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final NonNullSupplier<CreateRegistrate> REGISTRATE =
            NonNullSupplier.lazy(() -> CreateRegistrate.create(ID));

    static {
        REGISTRATE.get().setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, TooltipHelper.Palette.STANDARD_CREATE));
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }

    public CreateGarnished() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        GarnishedEntities.ENTITIES.register(eventBus);
        GarnishedBlockEntities.BLOCK_ENTITIES.register(eventBus);
        GarnishedEffects.setRegister(eventBus);
        GarnishedEnchantments.setRegister();
        GarnishedSetTypes.setRegister();
        GarnishedItems.setRegister();
        GarnishedBlocks.setRegister();
        GarnishedCT.setRegister();
        GarnishedTabs.setRegister(eventBus);
        GarnishedFluids.setRegister();
        GarnishedFoodValues.setRegister();
        GarnishedFeatures.setRegister(eventBus);
        GarnishedTags.setRegister();
        GarnishedRecipeTypes.register(eventBus);
        GarnishedFanProcessing.register();
        LootModifiers.register(eventBus);

        GarnishedAdvancementUtils.register();

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

        PotionBrewing.addMix(Potions.AWKWARD, GarnishedItems.VOLATILE_DUST.get(), GarnishedEffects.SANCTITY_POTION.get());

        PotionBrewing.addMix(Potions.MUNDANE, GarnishedItems.SOLEMN_DUST.get(), GarnishedEffects.MUMMIFICATION_POTION.get());

        PotionBrewing.addMix(Potions.THICK, GarnishedItems.FROST.get(), GarnishedEffects.FREEZING_POTION.get());
        PotionBrewing.addMix(GarnishedEffects.FREEZING_POTION.get(), Items.REDSTONE, GarnishedEffects.LONG_FREEZING_POTION.get());

        event.enqueueWork(GarnishedFluids::registerFluidInteractions);

        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CRACKED_BUHG.get(), 0.10f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CRACKED_CASHEW.get(), 0.10f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CRACKED_WALNUT.get(), 0.10f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CRACKED_ALMOND.get(), 0.10f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CRACKED_PISTACHIO.get(), 0.10f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CRACKED_PECAN.get(), 0.10f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CRACKED_MACADAMIA.get(), 0.10f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CRACKED_HAZELNUT.get(), 0.10f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CRACKED_CHESTNUT.get(), 0.10f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.UNGARNISHED_BUHG.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.UNGARNISHED_CASHEW.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.UNGARNISHED_WALNUT.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.UNGARNISHED_ALMOND.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.UNGARNISHED_PISTACHIO.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.UNGARNISHED_PECAN.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.UNGARNISHED_MACADAMIA.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.UNGARNISHED_HAZELNUT.get(), 0.15f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.UNGARNISHED_CHESTNUT.get(), 0.15f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.BUHG.get(), 0.20f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CASHEW.get(), 0.20f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.WALNUT.get(), 0.20f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.ALMOND.get(), 0.20f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.PISTACHIO.get(), 0.20f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.PECAN.get(), 0.20f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.MACADAMIA.get(), 0.20f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.HAZELNUT.get(), 0.20f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CHESTNUT.get(), 0.20f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CHOCOLATE_GLAZED_BUHG.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CHOCOLATE_GLAZED_CASHEW.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CHOCOLATE_GLAZED_WALNUT.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CHOCOLATE_GLAZED_ALMOND.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CHOCOLATE_GLAZED_PISTACHIO.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CHOCOLATE_GLAZED_PECAN.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CHOCOLATE_GLAZED_MACADAMIA.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CHOCOLATE_GLAZED_HAZELNUT.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CHOCOLATE_GLAZED_CHESTNUT.get(), 0.25f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.SWEETENED_BUHG.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.SWEETENED_CASHEW.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.SWEETENED_WALNUT.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.SWEETENED_ALMOND.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.SWEETENED_PISTACHIO.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.SWEETENED_PECAN.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.SWEETENED_MACADAMIA.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.SWEETENED_HAZELNUT.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.SWEETENED_CHESTNUT.get(), 0.25f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.HONEYED_BUHG.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.HONEYED_CASHEW.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.HONEYED_WALNUT.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.HONEYED_ALMOND.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.HONEYED_PISTACHIO.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.HONEYED_PECAN.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.HONEYED_MACADAMIA.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.HONEYED_HAZELNUT.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.HONEYED_CHESTNUT.get(), 0.25f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CINDER_FLOUR_BUHG.get(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CINDER_FLOUR_CASHEW.get(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CINDER_FLOUR_WALNUT.get(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CINDER_FLOUR_ALMOND.get(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CINDER_FLOUR_PISTACHIO.get(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CINDER_FLOUR_PECAN.get(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CINDER_FLOUR_MACADAMIA.get(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CINDER_FLOUR_HAZELNUT.get(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CINDER_FLOUR_CHESTNUT.get(), 0.30f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.MELTED_CINDER_FLOUR_BUHG.get(), 0.40f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.MELTED_CINDER_FLOUR_CASHEW.get(), 0.40f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.MELTED_CINDER_FLOUR_WALNUT.get(), 0.40f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.MELTED_CINDER_FLOUR_ALMOND.get(), 0.40f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.MELTED_CINDER_FLOUR_PISTACHIO.get(), 0.40f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.MELTED_CINDER_FLOUR_PECAN.get(), 0.40f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.MELTED_CINDER_FLOUR_MACADAMIA.get(), 0.40f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.MELTED_CINDER_FLOUR_HAZELNUT.get(), 0.40f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.MELTED_CINDER_FLOUR_CHESTNUT.get(), 0.40f);

            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.NUT_LEAVES.asItem(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.UNASSIGNED_NUT_LEAVES.asItem(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.BUHG_LEAVES.asItem(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.CASHEW_LEAVES.asItem(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.WALNUT_LEAVES.asItem(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.ALMOND_LEAVES.asItem(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.PISTACHIO_LEAVES.asItem(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.PECAN_LEAVES.asItem(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.MACADAMIA_LEAVES.asItem(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.HAZELNUT_LEAVES.asItem(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.CHESTNUT_LEAVES.asItem(), 0.35f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.PECAN_PIE_SLICE.get(), 0.25f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.PECAN_PIE.get(), 1.0f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.ALMOND_CHEESE.get(), 0.20f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.SALAD.get(), 0.75f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CRUSHED_CRIMSON_FUNGUS.get(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CRUSHED_WARPED_FUNGUS.get(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CRUSHED_SEPIA_FUNGUS.get(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.SEPIA_FUNGUS.asItem(), 0.65f);

            ComposterBlock.COMPOSTABLES.put(Items.CHORUS_FRUIT, 0.45f);
            ComposterBlock.COMPOSTABLES.put(Items.CHORUS_FLOWER, 0.65f);
            ComposterBlock.COMPOSTABLES.put(Items.CHORUS_PLANT, 0.65f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.HOLLOWED_CHORUS_FRUIT.get(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.CHORUS_TUFT.get(), 0.10f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.MULCH.get(), 0.25f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.WHEAT_GRAZE.get(), 0.65f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.DRIED_DULSE_KELP.get(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.DRIED_VERMILION_KELP.get(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.DULSE_KELP.asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.VERMILION_KELP.asItem(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.DRIED_DULSE_KELP_BLOCK.asItem(), 0.50f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.DRIED_VERMILION_KELP_BLOCK.asItem(), 0.50f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.PRICKLY_PEAR.get(), 0.45f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.BAMBOO_CLOD.get(), 0.45f);

            ComposterBlock.COMPOSTABLES.put(GarnishedItems.BOK_CHOY.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.BOK_CHOY_SEEDS.get(), 0.30f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.PANSOPHICAL_PETAL.get(), 0.45f);
            ComposterBlock.COMPOSTABLES.put(GarnishedItems.INCANDESCENT_PETAL.get(), 0.45f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.PANSOPHICAL_DAISY.asItem(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.INCANDESCENT_LILY.asItem(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.SORROWFUL_LICHEN.asItem(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.SOUL_ROOTS.asItem(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.AUREATE_SHRUB.asItem(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.SMALL_CHORUS_PLANT.asItem(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(GarnishedBlocks.BARREN_ROOTS.asItem(), 0.65f);
        });

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

    @Mod.EventBusSubscriber(modid = ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
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
