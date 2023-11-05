package net.dakotapride.garnished.entity;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;
import java.util.stream.Stream;

public class NutBoatRenderer extends BoatRenderer {

    private final Map<NutBoatEntity.Type, Pair<ResourceLocation, BoatModel>> boatResources;

    public NutBoatRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.boatResources = Stream.of(NutBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap((type) -> type, (type) ->
                Pair.of(new ResourceLocation(CreateGarnished.ID, getTextureLocation(type)), this.createBoatModel(pContext, type))));
    }

    private static String getTextureLocation(NutBoatEntity.Type pType) {
        return "textures/entity/boat/" + pType.getName() + ".png";
    }

    private BoatModel createBoatModel(EntityRendererProvider.Context pContext, NutBoatEntity.Type pType) {
        ModelLayerLocation modellayerlocation = NutBoatRenderer.createBoatModelName(pType);
        ModelPart modelpart = pContext.bakeLayer(modellayerlocation);
        return new BoatModel(modelpart);
    }

    public static ModelLayerLocation createBoatModelName(NutBoatEntity.Type pType) {
        return createLocation("boat/" + pType.getName(), "main");
    }

    private static ModelLayerLocation createLocation(String pPath, String pModel) {
        return new ModelLayerLocation(new ResourceLocation(CreateGarnished.ID, pPath), pModel);
    }

    public Pair<ResourceLocation, BoatModel> getModelWithLocation(Boat boat) {
        if (boat instanceof NutBoatEntity modBoat) {
            return this.boatResources.get(modBoat.getModVariant());
        }else {
            return null;
        }
    }
}