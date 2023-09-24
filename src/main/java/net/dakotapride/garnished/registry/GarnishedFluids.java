package net.dakotapride.garnished.registry;

import com.mojang.math.Vector3f;
import com.simibubi.create.AllFluids;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.foundation.utility.Color;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nullable;
import java.util.function.Supplier;

@SuppressWarnings({"unused"})
public class GarnishedFluids {

	private static ResourceLocation createLocation(String fluid, boolean isFlowing) {
		String getMotion;

		if (isFlowing) {
			getMotion = "_flow";
		} else {
			getMotion = "_still";
		}

		return new ResourceLocation(CreateGarnished.ID, "fluid/" + fluid + getMotion);
	}

	public static final FluidEntry<ForgeFlowingFluid.Flowing> GARNISH =
			CreateGarnished.registrate().fluid("garnish",
							createLocation("garnish", false),
							createLocation("garnish", true))
					.properties(b -> b.viscosity(1500)
							.density(800))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/garnish"))
					.build()
					.register();

	public static final FluidEntry<ForgeFlowingFluid.Flowing> APPLE_CIDER =
			CreateGarnished.registrate().fluid("apple_cider",
							createLocation("apple_cider", false),
							createLocation("apple_cider", true))
					.properties(b -> b.viscosity(1500)
							.density(800))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/apple_cider"))
					.build()
					.register();

	public static final FluidEntry<ForgeFlowingFluid.Flowing> PEANUT_OIL =
			CreateGarnished.registrate().fluid("peanut_oil",
							createLocation("peanut_oil", false),
							createLocation("peanut_oil", true))
					.properties(b -> b.viscosity(1500)
							.density(800))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/peanut_oil"))
					.build()
					.register();

	public static final FluidEntry<ForgeFlowingFluid.Flowing> CASHEW_MIXTURE =
			CreateGarnished.registrate().fluid("cashew_mixture",
							createLocation("cashew_mixture", false),
							createLocation("cashew_mixture", true))
					.properties(b -> b.viscosity(1500)
							.density(800))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/cashew_mixture"))
					.build()
					.register();


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

	public static void registerFluidInteractions() {
		FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
				GARNISH.get().getFluidType(),
				fluidState -> {
					if (fluidState.isSource()) {
						return Blocks.OBSIDIAN.defaultBlockState();
					} else {
						return AllPaletteStoneTypes.CALCITE.getBaseBlock()
								.get()
								.defaultBlockState();
					}
				}
		));

		FluidInteractionRegistry.addInteraction(GARNISH.getType(), new FluidInteractionRegistry.InteractionInformation(
				ForgeMod.LAVA_TYPE.get(),
				fluidState -> {
					if (fluidState.isSource()) {
						return Blocks.OBSIDIAN.defaultBlockState();
					} else {
						return AllPaletteStoneTypes.CALCITE.getBaseBlock()
								.get()
								.defaultBlockState();
					}
				}
		));

		FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
				APPLE_CIDER.get().getFluidType(),
				fluidState -> {
					if (fluidState.isSource()) {
						return Blocks.OBSIDIAN.defaultBlockState();
					} else {
						return AllPaletteStoneTypes.OCHRUM.getBaseBlock()
								.get()
								.defaultBlockState();
					}
				}
		));

		FluidInteractionRegistry.addInteraction(APPLE_CIDER.getType(), new FluidInteractionRegistry.InteractionInformation(
				ForgeMod.LAVA_TYPE.get(),
				fluidState -> {
					if (fluidState.isSource()) {
						return Blocks.OBSIDIAN.defaultBlockState();
					} else {
						return AllPaletteStoneTypes.OCHRUM.getBaseBlock()
								.get()
								.defaultBlockState();
					}
				}
		));

		FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
				PEANUT_OIL.get().getFluidType(),
				fluidState -> {
					if (fluidState.isSource()) {
						return Blocks.OBSIDIAN.defaultBlockState();
					} else {
						return Blocks.DRIPSTONE_BLOCK.defaultBlockState();
					}
				}
		));

		FluidInteractionRegistry.addInteraction(PEANUT_OIL.getType(), new FluidInteractionRegistry.InteractionInformation(
				ForgeMod.LAVA_TYPE.get(),
				fluidState -> {
					if (fluidState.isSource()) {
						return Blocks.OBSIDIAN.defaultBlockState();
					} else {
						return AllPaletteStoneTypes.DRIPSTONE.getBaseBlock()
								.get()
								.defaultBlockState();
					}
				}
		));
	}

	@Nullable
	public static BlockState getLavaInteraction(FluidState fluidState) {
		Fluid fluid = fluidState.getType();
		if (fluid.isSame(GARNISH.get()))
			return AllPaletteStoneTypes.CALCITE.getBaseBlock()
					.get()
					.defaultBlockState();
		if (fluid.isSame(APPLE_CIDER.get()))
			return AllPaletteStoneTypes.OCHRUM.getBaseBlock()
					.get()
					.defaultBlockState();
		if (fluid.isSame(PEANUT_OIL.get()))
			return AllPaletteStoneTypes.DRIPSTONE.getBaseBlock()
					.get()
					.defaultBlockState();
		return null;
	}
}