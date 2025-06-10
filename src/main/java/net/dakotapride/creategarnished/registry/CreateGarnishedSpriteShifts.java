package net.dakotapride.creategarnished.registry;

import com.simibubi.create.foundation.block.connected.*;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.client.resources.model.BakedModel;

public class CreateGarnishedSpriteShifts {
    public static final CTSpriteShiftEntry PORPHYRY_CUT_CAP = omni("cut_porphyry_cap");

    public static final CTSpriteShiftEntry PORPHYRY_CUT_LAYERED = horizontal("cut_porphyry_layered");
    public static final CTModelProvider LAYERED_PORPHYRY_PROVIDER = new CTModelProvider(new HorizontalCTBehaviour(PORPHYRY_CUT_LAYERED, PORPHYRY_CUT_CAP));

    public static final CTSpriteShiftEntry PORPHYRY_PILLAR_LAYERED = rect("cut_porphyry_pillar");
    public static final CTModelProvider PORPHYRY_PILLAR_PROVIDER = new CTModelProvider(new RotatedPillarCTBehaviour(PORPHYRY_PILLAR_LAYERED, PORPHYRY_CUT_CAP));


    private static CTSpriteShiftEntry omni(String name) {
        return CTSpriteShifter.getCT(AllCTTypes.OMNIDIRECTIONAL, CreateGarnished.asResource("block/" + name), CreateGarnished.asResource("block/" + name + "_connected"));
    }

    private static CTSpriteShiftEntry horizontal(String name) {
        return CTSpriteShifter.getCT(AllCTTypes.HORIZONTAL_KRYPPERS, CreateGarnished.asResource("block/" + name), CreateGarnished.asResource("block/" + name + "_connected"));
    }

    private static CTSpriteShiftEntry rect(String name) {
        return CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, CreateGarnished.asResource("block/" + name), CreateGarnished.asResource("block/" + name + "_connected"));
    }


    public record CTModelProvider(ConnectedTextureBehaviour behavior) implements NonNullFunction<BakedModel, BakedModel> {
        @Override
        public BakedModel apply(BakedModel bakedModel) {
            return new CTModel(bakedModel, behavior);
        }
    }
}
