package net.dakotapride.creategarnished.registry;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.simibubi.create.infrastructure.config.AllConfigs;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.createmod.catnip.theme.Color;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.function.Supplier;

import static net.dakotapride.creategarnished.CreateGarnished.REGISTRATE;

public class CreateGarnishedFluids {

    static {
        REGISTRATE.setCreativeTab(GarnishedCreativeModeTabs.GARNISHED);
    }

    public static final FluidEntry<VirtualFluid> SPRINTERS_TEA = REGISTRATE.virtualFluid("sprinters_tea").register();
    public static final FluidEntry<VirtualFluid> SWEET_TEA = REGISTRATE.virtualFluid("sweet_tea").register();
    public static final FluidEntry<VirtualFluid> ELVEN_TEA = REGISTRATE.virtualFluid("elven_tea").register();
    public static final FluidEntry<VirtualFluid> BIRCH_SAP = REGISTRATE.virtualFluid("birch_sap").register();
    //public static final FluidEntry<VirtualFluid> BIRCH_SYRUP = REGISTRATE.virtualFluid("birch_syrup").register();
    public static final FluidEntry<VirtualFluid> BEETROOT_JUICE = REGISTRATE.virtualFluid("beetroot_juice").register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> PEANUT_BUTTER =
            REGISTRATE.standardFluid("peanut_butter",
                            SolidRenderedPlaceableFluidType.create(0xA2774B,
                                    () -> 1f / 32f * AllConfigs.client().chocolateTransparencyMultiplier.getF()))
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .source(BaseFlowingFluid.Source::new) // TODO: remove when Registrate fixes FluidBuilder
                    .bucket()
                    .build()
                    .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> BIRCH_SYRUP =
            REGISTRATE.standardFluid("birch_syrup",
                            SolidRenderedPlaceableFluidType.create(0x9E4B1F,
                                    () -> 1f / 32f * AllConfigs.client().chocolateTransparencyMultiplier.getF()))
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .source(BaseFlowingFluid.Source::new) // TODO: remove when Registrate fixes FluidBuilder
                    .bucket().build()
                    .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> ALMOND_EXTRACT =
            REGISTRATE.standardFluid("almond_extract",
                            SolidRenderedPlaceableFluidType.create(0x9E4B1F,
                                    () -> 1f / 32f * AllConfigs.client().chocolateTransparencyMultiplier.getF()))
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .source(BaseFlowingFluid.Source::new) // TODO: remove when Registrate fixes FluidBuilder
                    .bucket().build()
                    .register();

    public static void register() {}

    private static void provideFluidInteraction(FluidType colliding_fluid, FluidType met_fluid, Block from_source, Block from_flowing) {
        FluidInteractionRegistry.addInteraction(colliding_fluid, new FluidInteractionRegistry.InteractionInformation(
                met_fluid,
                fluidState -> {
                    if (fluidState.isSource()) {
                        return from_source.defaultBlockState();
                    } else {
                        return from_flowing.defaultBlockState();
                    }
                }
        ));
    }

    public static void registerFluidInteractions() {
        provideFluidInteraction(
                NeoForgeMod.LAVA_TYPE.value(),
                BIRCH_SYRUP.get().getFluidType(),
                AllPaletteStoneTypes.CRIMSITE.getBaseBlock().get(),
                CreateGarnishedStoneTypes.PORPHYRY.getStoneType().getBaseStoneBlock().get()
        );
        provideFluidInteraction(
                NeoForgeMod.LAVA_TYPE.value(),
                PEANUT_BUTTER.get().getFluidType(),
                AllPaletteStoneTypes.DRIPSTONE.getBaseBlock().get(),
                AllPaletteStoneTypes.DRIPSTONE.getBaseBlock().get()
        );
    }

    @Nullable
    public static BlockState getFluidInteraction(FluidState fluidState) {
        Fluid fluid = fluidState.getType();
        if (fluid.isSame(BIRCH_SYRUP.get()))
            return CreateGarnishedStoneTypes.PORPHYRY.getStoneType().getBaseStoneBlock().getDefaultState();
        if (fluid.isSame(PEANUT_BUTTER.get()))
            return AllPaletteStoneTypes.DRIPSTONE.getBaseBlock().get().defaultBlockState();
        return null;
    }

    private static class SolidRenderedPlaceableFluidType extends AllFluids.TintedFluidType {

        private Vector3f fogColor;
        private Supplier<Float> fogDistance;

        public static FluidBuilder.FluidTypeFactory create(int fogColor, Supplier<Float> fogDistance) {
            return (p, s, f) -> {
                SolidRenderedPlaceableFluidType fluidType = new SolidRenderedPlaceableFluidType(p, s, f);
                fluidType.fogColor = new Color(fogColor, false).asVectorF();
                fluidType.fogDistance = fogDistance;
                return fluidType;
            };
        }

        private SolidRenderedPlaceableFluidType(Properties properties, ResourceLocation stillTexture,
                                                ResourceLocation flowingTexture) {
            super(properties, stillTexture, flowingTexture);
        }

        @Override
        protected int getTintColor(FluidStack stack) {
            return NO_TINT;
        }

        /*
         * Removing alpha from tint prevents optifine from forcibly applying biome
         * colors to modded fluids (this workaround only works for fluids in the solid
         * render layer)
         */
        @Override
        public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
            return 0x00ffffff;
        }

        @Override
        protected Vector3f getCustomFogColor() {
            return fogColor;
        }

        @Override
        protected float getFogDistanceModifier() {
            return fogDistance.get();
        }

    }
}
