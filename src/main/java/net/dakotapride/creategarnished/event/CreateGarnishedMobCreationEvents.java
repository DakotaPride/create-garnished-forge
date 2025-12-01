package net.dakotapride.creategarnished.event;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.entity.squirrel.SquirrelEntity;
import net.dakotapride.creategarnished.entity.squirrel.client.SquirrelModel;
import net.dakotapride.creategarnished.entity.voltfish.VoltfishEntity;
import net.dakotapride.creategarnished.entity.voltfish.client.VoltfishModel;
import net.dakotapride.creategarnished.registry.CreateGarnishedEntityTypes;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = CreateGarnished.ID, bus = EventBusSubscriber.Bus.MOD)
public class CreateGarnishedMobCreationEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(VoltfishModel.LAYER_LOCATION, VoltfishModel::createBodyLayer);
        event.registerLayerDefinition(SquirrelModel.LAYER_LOCATION, SquirrelModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(CreateGarnishedEntityTypes.VOLTFISH.get(), VoltfishEntity.createAttributes().build());
        event.put(CreateGarnishedEntityTypes.SQUIRREL.get(), SquirrelEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(CreateGarnishedEntityTypes.SQUIRREL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                SquirrelEntity::checkSquirrelSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

}
