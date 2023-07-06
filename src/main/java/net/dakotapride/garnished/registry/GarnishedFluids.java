package net.dakotapride.garnished.registry;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import static com.simibubi.create.Create.REGISTRATE;
import static net.minecraft.world.item.Items.BUCKET;

@SuppressWarnings({"unused"})
public class GarnishedFluids {
	private static final CreateRegistrate REGISTRATE = CreateGarnished.registrate()
			.creativeModeTab(() -> GarnishedTabs.GARNISHED);

	public static final FluidEntry<ForgeFlowingFluid.Flowing> GARNISH;
	public static final FluidEntry<ForgeFlowingFluid.Flowing> APPLE_CIDER;

	static {
		GARNISH = REGISTRATE
				.fluid("garnish",
						new ResourceLocation(CreateGarnished.ID, "fluid/garnish_still"),
						new ResourceLocation(CreateGarnished.ID, "fluid/garnish_flowing")
				)
				.fluidProperties(p -> p.levelDecreasePerBlock(2)
						.tickRate(25)
						.slopeFindDistance(3)
						.explosionResistance(100f))
				.properties(b -> b.viscosity(1500).density(800).descriptionId("fluid.liquid_garnish"))
				.source(ForgeFlowingFluid.Source::new)
				.bucket().build()
				.register();
		APPLE_CIDER = REGISTRATE
				.fluid("apple_cider",
						new ResourceLocation(CreateGarnished.ID, "fluid/apple_cider_still"),
						new ResourceLocation(CreateGarnished.ID, "fluid/apple_cider_flowing")
				)
				.fluidProperties(p -> p.levelDecreasePerBlock(2)
						.tickRate(25)
						.slopeFindDistance(3)
						.explosionResistance(100f))
				.properties(b -> b.viscosity(1500).density(800).descriptionId("fluid.apple_cider"))
				.source(ForgeFlowingFluid.Source::new)
				.bucket().build()
				.register();
	}


	private static class NoColorFluidAttributes extends AllFluids.TintedFluidType {

		public NoColorFluidAttributes(Properties properties, ResourceLocation stillTexture,
									  ResourceLocation flowingTexture) {
			super(properties, stillTexture, flowingTexture);
		}

		@Override
		protected int getTintColor(FluidStack stack) {
			return NO_TINT;
		}

		@Override
		public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
			return 0x00ffffff;
		}

	}

	public static void setRegister() {}
}
