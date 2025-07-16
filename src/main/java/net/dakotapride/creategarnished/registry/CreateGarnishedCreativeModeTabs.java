package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

//@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CreateGarnishedCreativeModeTabs {
    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateGarnished.ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GARNISHED = REGISTER.register("tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.creategarnished.tab"))
                    .icon(CreateGarnishedBlocks.GINGER_ROOT_BARREL::asStack)
                    .displayItems(new CreateGarnishedDisplayItemsGenerator())
                    .build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GARNISHED_BLOCKS = REGISTER.register("tab_blocks",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.creategarnished.tab.blocks"))
                    .icon(CreateGarnishedStoneTypes.PORPHYRY.getStoneType().getBaseStoneBlock()::asStack)
                    .displayItems(new CreateGarnishedDisplayDecorativeBlocksGenerator())
                    .build());

    @ApiStatus.Internal
    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }

    public static class CreateGarnishedDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {
        public CreateGarnishedDisplayItemsGenerator() {}

        @Override
        public void accept(CreativeModeTab.@NotNull ItemDisplayParameters parameters, CreativeModeTab.@NotNull Output output) {
            //output.accept(GarnishedItems.CRACKED_CASHEW.asStack());
            output.accept(CreateGarnishedItems.GARNISHMENT_BOOK);

            output.accept(CreateGarnishedItems.PRESSURISED_HATCHET);

            output.accept(CreateGarnishedItems.PEANUT);
            output.accept(CreateGarnishedItems.GINGER_ROOT);
            output.accept(CreateGarnishedItems.PEANUT_BUTTER_COOKIE);

            output.accept(CreateGarnishedItems.PINE_NUT);
            output.accept(CreateGarnishedItems.ELVEN_SWEET_BERRIES);
            output.accept(CreateGarnishedItems.GARLIC_BULB);
            output.accept(CreateGarnishedItems.VEGETABLE_STEW);
            output.accept(CreateGarnishedItems.GARLIC_BREAD);
            output.accept(CreateGarnishedItems.PINE_NUT_FLOUR);
            output.accept(CreateGarnishedItems.MINCED_GARLIC);
            output.accept(CreateGarnishedItems.CRYSTALLINE_GARLIC_BULB);
            output.accept(CreateGarnishedItems.MINCED_CRYSTALLINE_GARLIC);

            output.accept(CreateGarnishedItems.HAZELNUT);
            output.accept(CreateGarnishedItems.CHOCOLATE_TRUFFLE);
            output.accept(CreateGarnishedItems.PRALINE);
            output.accept(CreateGarnishedItems.PANCAKES);
            output.accept(CreateGarnishedItems.SYRUP_COVERED_PANCAKES);
            output.accept(CreateGarnishedItems.CRUSHED_HAZELNUT_POWDER);

            output.accept(CreateGarnishedItems.ALMOND);
            output.accept(CreateGarnishedItems.BEAR_CLAW);
            output.accept(CreateGarnishedItems.CHURCHKHELA);
            output.accept(CreateGarnishedBlocks.POUND_CAKE);
            output.accept(CreateGarnishedItems.ALMOND_PASTE);
            output.accept(CreateGarnishedItems.CREAM);

            output.accept(CreateGarnishedItems.ELASTIC_STRAND);
            output.accept(CreateGarnishedItems.FIERY_ELASTIC_STRAND);
            output.accept(CreateGarnishedItems.GUARDIAN_SPIKE);
            output.accept(CreateGarnishedItems.ELDER_GUARDIAN_SPIKE);
            output.accept(CreateGarnishedItems.SNIFFER_FLUFF);

            output.accept(CreateGarnishedItems.SLLIMY);
            output.accept(CreateGarnishedItems.FIERY_SLLIMY);
            output.accept(CreateGarnishedItems.GLAZED_MONUMENT_MEDLEY);

            output.accept(CreateGarnishedItems.PEANUT_BUTTER_BOTTLE);
            output.accept(CreateGarnishedItems.BIRCH_SAP_BOTTLE);
            output.accept(CreateGarnishedItems.BIRCH_SYRUP_BOTTLE);
            output.accept(CreateGarnishedItems.BEETROOT_JUICE_BOTTLE);
            output.accept(CreateGarnishedItems.ROYAL_CIDER);

            output.accept(CreateGarnishedItems.SPRINTERS_TEA);
            output.accept(CreateGarnishedItems.SWEET_TEA);
            output.accept(CreateGarnishedItems.ELVEN_TEA);

            output.accept(CreateGarnishedFluids.PEANUT_BUTTER.get().getBucket());
            output.accept(CreateGarnishedFluids.BIRCH_SYRUP.get().getBucket());
            output.accept(CreateGarnishedFluids.ALMOND_EXTRACT.get().getBucket());
            output.accept(CreateGarnishedFluids.ROYAL_CIDER.get().getBucket());
            output.accept(CreateGarnishedFluids.BEETROOT_JUICE.get().getBucket());
            output.accept(CreateGarnishedFluids.MUSHROOM_SLOP.get().getBucket());
        }
    }

    public static class CreateGarnishedDisplayDecorativeBlocksGenerator implements CreativeModeTab.DisplayItemsGenerator {
        public CreateGarnishedDisplayDecorativeBlocksGenerator() {}

        @Override
        public void accept(CreativeModeTab.@NotNull ItemDisplayParameters parameters, CreativeModeTab.@NotNull Output output) {
            //output.accept(GarnishedItems.CRACKED_CASHEW.asStack());
            output.accept(CreateGarnishedBlocks.MARIGOLD);
            output.accept(CreateGarnishedBlocks.WILD_PEANUT);
            output.accept(CreateGarnishedBlocks.WILD_GINGER_ROOT);
            output.accept(CreateGarnishedBlocks.WILD_GARLIC);

            output.accept(CreateGarnishedBlocks.PEANUT_BARREL);
            output.accept(CreateGarnishedBlocks.PINE_NUT_BARREL);
            output.accept(CreateGarnishedBlocks.HAZELNUT_BARREL);
            output.accept(CreateGarnishedBlocks.ALMOND_BARREL);
            output.accept(CreateGarnishedBlocks.SWEET_BERRY_BARREL);
            output.accept(CreateGarnishedBlocks.ELVEN_SWEET_BERRY_BARREL);
            output.accept(CreateGarnishedBlocks.GARLIC_BARREL);

            output.accept(CreateGarnishedBlocks.PINE_NUT_LEAVES);
            output.accept(CreateGarnishedBlocks.HAZELNUT_LEAVES);
            output.accept(CreateGarnishedBlocks.ALMOND_LEAVES);
            output.accept(CreateGarnishedBlocks.BLOSSOMING_ALMOND_LEAVES);
            output.accept(CreateGarnishedBlocks.BIRCH_SAP_LOG);

//            output.accept(CreateGarnishedBlocks.PINE_NUT_SAPLING);
//            output.accept(CreateGarnishedBlocks.HAZELNUT_SAPLING);
//            output.accept(CreateGarnishedBlocks.ALMOND_SAPLING);

            for (CreateGarnishedStoneTypes stoneTypes : CreateGarnishedStoneTypes.values()) {
                output.accept(stoneTypes.getStoneType().getBaseStoneBlock());
                output.accept(stoneTypes.getStoneType().getCutBlock());
                output.accept(stoneTypes.getStoneType().getSlabBlock());
                output.accept(stoneTypes.getStoneType().getStairsBlock());
                output.accept(stoneTypes.getStoneType().getWallBlock());
                output.accept(stoneTypes.getStoneType().getBricksBlock());
                output.accept(stoneTypes.getStoneType().getBrickSlabBlock());
                output.accept(stoneTypes.getStoneType().getBrickStairsBlock());
                output.accept(stoneTypes.getStoneType().getBrickWallBlock());
                output.accept(stoneTypes.getStoneType().getSmallBricksBlock());
                output.accept(stoneTypes.getStoneType().getSmallBrickSlabBlock());
                output.accept(stoneTypes.getStoneType().getSmallBrickStairsBlock());
                output.accept(stoneTypes.getStoneType().getSmallBrickWallBlock());
                output.accept(stoneTypes.getStoneType().getPolishedBlock());
                output.accept(stoneTypes.getStoneType().getPolishedSlabBlock());
                output.accept(stoneTypes.getStoneType().getPolishedStairsBlock());
                output.accept(stoneTypes.getStoneType().getPolishedWallBlock());
//                output.accept(stoneTypes.getStoneType().getLayeredBlock());
//                output.accept(stoneTypes.getStoneType().getPillarBlock());
            }
            output.accept(CreateGarnishedBlocks.LAYERED_PORPHYRY);
            output.accept(CreateGarnishedBlocks.PORPHYRY_PILLAR);

            output.accept(CreateGarnishedBlocks.CREAM_BLOCK);

            output.accept(CreateGarnishedBlocks.SNIFFER_FLUFF_BLOCK);
            output.accept(CreateGarnishedBlocks.SNIFFER_FLUFF_CARPET);

            // Creative Blocks

            output.accept(CreateGarnishedBlocks.CREATIVE_BIRCH_SAP_LOG);
        }
    }
}
