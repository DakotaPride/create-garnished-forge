package net.dakotapride.creategarnished.event;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.entity.VoltfishEntity;
import net.dakotapride.creategarnished.entity.client.VoltfishModel;
import net.dakotapride.creategarnished.registry.CreateGarnishedEntityTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.MOD)
public class CreateGarnishedMobCreationEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(VoltfishModel.LAYER_LOCATION, VoltfishModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(CreateGarnishedEntityTypes.VOLTFISH.get(), VoltfishEntity.createAttributes().build());
    }

}
