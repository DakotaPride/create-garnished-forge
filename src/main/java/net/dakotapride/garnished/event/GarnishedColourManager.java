package net.dakotapride.garnished.event;

import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GarnishedColourManager {
    @SubscribeEvent
    public static void onColourHandlers$blockRegister(RegisterColorHandlersEvent.Block event) {
        blockColourProvider(event.getBlockColors());
    }

    @SubscribeEvent
    public static void onColourHandlers$itemRegister(RegisterColorHandlersEvent.Item event) {
        itemColourProvider(event.getBlockColors(), event.getItemColors());
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
}
