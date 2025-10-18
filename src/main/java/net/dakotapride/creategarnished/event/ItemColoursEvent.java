package net.dakotapride.creategarnished.event;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.registry.CreateGarnishedItems;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = CreateGarnished.ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ItemColoursEvent {
    @SubscribeEvent
    public static void onColourHandlers$itemRegister(RegisterColorHandlersEvent.Item event) {
        itemColourProvider(event.getBlockColors(), event.getItemColors());
    }

    public static synchronized void itemColourProvider(BlockColors colors, ItemColors itemColours) {
        itemColours.register(
                (itemStack, i) -> DyedItemColor.getOrDefault(itemStack, FastColor.ABGR32.color(255, 0, 255,  153)),
                CreateGarnishedItems.CANDY_WRAPPING,
                CreateGarnishedItems.WRAPPED_CANDY
        );
    }
}
