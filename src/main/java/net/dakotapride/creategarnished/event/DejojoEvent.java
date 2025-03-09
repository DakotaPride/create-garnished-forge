package net.dakotapride.creategarnished.event;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.registry.CreateGarnishedAdvancements;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.GAME)
public class DejojoEvent {

    @SubscribeEvent
    public static void dejojo(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();

        if (entity instanceof ServerPlayer player && player.getStringUUID().equals("7282ae0d-c2f5-4610-8be9-70af5a1322a4")) {
            CreateGarnishedAdvancements.DEJOJO.get().trigger( player);
        }

    }

}
