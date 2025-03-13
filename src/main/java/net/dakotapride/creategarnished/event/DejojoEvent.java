package net.dakotapride.creategarnished.event;

import net.dakotapride.creategarnished.registry.CreateGarnishedAdvancements;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DejojoEvent {

    @SubscribeEvent
    public static void dejojo(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof ServerPlayer player && player.getStringUUID().equals("7282ae0d-c2f5-4610-8be9-70af5a1322a4")) {
            CreateGarnishedAdvancements.DEJOJO.trigger( player);
        }

    }

}
