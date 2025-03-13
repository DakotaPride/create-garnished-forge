package net.dakotapride.creategarnished.registry;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.simibubi.create.infrastructure.config.AllConfigs;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.createmod.catnip.theme.Color;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
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
    public static final FluidEntry<VirtualFluid> BIRCH_SYRUP = REGISTRATE.virtualFluid("birch_syrup").register();
    public static final FluidEntry<VirtualFluid> BEETROOT_JUICE = REGISTRATE.virtualFluid("beetroot_juice").register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> PEANUT_BUTTER =
            REGISTRATE.standardFluid("peanut_butter",
                            SolidRenderedPlaceableFluidType.create(0xA2774B,
                                    () -> 1f / 32f * AllConfigs.client().chocolateTransparencyMultiplier.getF()))
                    .lang("Peanut Butter")
                    .tag(AllTags.forgeFluidTag("peanut_butter"))
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .source(ForgeFlowingFluid.Source::new) // TODO: remove when Registrate fixes FluidBuilder
                    .bucket()
                    .tag(AllTags.forgeItemTag("buckets/peanut_butter"))
                    .build()
                    .register();

    public static void register() {}

    public static void registerFluidInteractions() {
//        FluidInteractionRegistry.addInteraction(ForgeMod.WATER_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
//                MELTED_BLUE_ICE.get().getFluidType(),
//                fluidState -> {
//                    if (fluidState.isSource()) {
//                        return Blocks.BLUE_ICE.defaultBlockState();
//                    } else {
//                        return HerbologyBlocks.CRYOSINE.getDefaultState();
//                    }
//                }
//        ));
    }

    @Nullable
    public static BlockState getFluidInteraction(FluidState fluidState) {
        Fluid fluid = fluidState.getType();
//        if (fluid.isSame(MELTED_BLUE_ICE.get()))
//            return HerbologyBlocks.CRYOSINE.getDefaultState();
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
