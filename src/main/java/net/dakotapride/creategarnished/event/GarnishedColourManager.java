package net.dakotapride.creategarnished.event;

import net.dakotapride.creategarnished.registry.CreateGarnishedBlocks;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
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
        colors.register((unknown, lightReader, pos, unknown2) -> FoliageColor.getEvergreenColor(), CreateGarnishedBlocks.PINE_NUT_LEAVES.get());
        colors.register((unknown, lightReader, pos, unknown2) -> FoliageColor.getBirchColor(), CreateGarnishedBlocks.HAZELNUT_LEAVES.get());
    }

    public static synchronized void itemColourProvider(BlockColors colors, ItemColors itemColors) {
        ItemColor itemBlockColourHandler = (stack, tintIndex) -> {
            BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return colors.getColor(state, null, null, tintIndex);
        };

        itemColors.register(itemBlockColourHandler, CreateGarnishedBlocks.PINE_NUT_LEAVES.get(), CreateGarnishedBlocks.HAZELNUT_LEAVES);
    }
}