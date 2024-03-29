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
							.density(1400))
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
							.density(1400))
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
							.density(1400))
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
							.density(1400))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/cashew_mixture"))
					.build()
					.register();

	public static final FluidEntry<ForgeFlowingFluid.Flowing> MASTIC_RESIN =
			CreateGarnished.registrate().fluid("mastic_resin",
							createLocation("mastic_resin", false),
							createLocation("mastic_resin", true))
					.properties(b -> b.viscosity(1500)
							.density(1400))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/mastic_resin"))
					.build()
					.register();

	public static final FluidEntry<ForgeFlowingFluid.Flowing> RED_MASTIC_RESIN =
			CreateGarnished.registrate().fluid("red_mastic_resin",
							createLocation("red_mastic_resin", false),
							createLocation("red_mastic_resin", true))
					.properties(b -> b.viscosity(1500)
							.density(1400))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/mastic_resin"))
					.build()
					.register();
	public static final FluidEntry<ForgeFlowingFluid.Flowing> ORANGE_MASTIC_RESIN =
			CreateGarnished.registrate().fluid("orange_mastic_resin",
							createLocation("orange_mastic_resin", false),
							createLocation("orange_mastic_resin", true))
					.properties(b -> b.viscosity(1500)
							.density(1400))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/mastic_resin"))
					.build()
					.register();
	public static final FluidEntry<ForgeFlowingFluid.Flowing> YELLOW_MASTIC_RESIN =
			CreateGarnished.registrate().fluid("yellow_mastic_resin",
							createLocation("yellow_mastic_resin", false),
							createLocation("yellow_mastic_resin", true))
					.properties(b -> b.viscosity(1500)
							.density(1400))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/mastic_resin"))
					.build()
					.register();
	public static final FluidEntry<ForgeFlowingFluid.Flowing> GREEN_MASTIC_RESIN =
			CreateGarnished.registrate().fluid("green_mastic_resin",
							createLocation("green_mastic_resin", false),
							createLocation("green_mastic_resin", true))
					.properties(b -> b.viscosity(1500)
							.density(1400))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/mastic_resin"))
					.build()
					.register();
	public static final FluidEntry<ForgeFlowingFluid.Flowing> BLUE_MASTIC_RESIN =
			CreateGarnished.registrate().fluid("blue_mastic_resin",
							createLocation("blue_mastic_resin", false),
							createLocation("blue_mastic_resin", true))
					.properties(b -> b.viscosity(1500)
							.density(1400))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/mastic_resin"))
					.build()
					.register();
	public static final FluidEntry<ForgeFlowingFluid.Flowing> PURPLE_MASTIC_RESIN =
			CreateGarnished.registrate().fluid("purple_mastic_resin",
							createLocation("purple_mastic_resin", false),
							createLocation("purple_mastic_resin", true))
					.properties(b -> b.viscosity(1500)
							.density(1400))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/mastic_resin"))
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
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), PEANUT_OIL.getType(), Blocks.OBSIDIAN, AllPaletteStoneTypes.DRIPSTONE.getBaseBlock().get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), APPLE_CIDER.getType(), Blocks.OBSIDIAN, AllPaletteStoneTypes.OCHRUM.getBaseBlock().get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), GARNISH.getType(), Blocks.OBSIDIAN, AllPaletteStoneTypes.CALCITE.getBaseBlock().get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), CASHEW_MIXTURE.getType(), Blocks.OBSIDIAN, Blocks.END_STONE);

		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), MASTIC_RESIN.getType(), Blocks.OBSIDIAN, AllPaletteStoneTypes.TUFF.getBaseBlock().get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), RED_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, AllPaletteStoneTypes.CRIMSITE.getBaseBlock().get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), ORANGE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.RITUALISTIC_STONE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), YELLOW_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.CARNOTITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), GREEN_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, AllPaletteStoneTypes.VERIDIUM.getBaseBlock().get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), BLUE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, AllPaletteStoneTypes.ASURINE.getBaseBlock().get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), PURPLE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.ABYSSAL_STONE.get());
	}

	@Nullable
	public static BlockState getLavaInteraction(FluidState fluidState) {
		Fluid fluid = fluidState.getType();
		if (fluid.isSame(GARNISH.get()))
			return AllPaletteStoneTypes.CALCITE.getBaseBlock()
					.get()
					.defaultBlockState();
		if (fluid.isSame(PEANUT_OIL.get()))
			return AllPaletteStoneTypes.DRIPSTONE.getBaseBlock()
					.get()
					.defaultBlockState();
		if (fluid.isSame(APPLE_CIDER.get()))
			return AllPaletteStoneTypes.OCHRUM.getBaseBlock()
					.get()
					.defaultBlockState();
		if (fluid.isSame(CASHEW_MIXTURE.get()))
			return Blocks.END_STONE.defaultBlockState();
		if (fluid.isSame(MASTIC_RESIN.get()))
			return AllPaletteStoneTypes.TUFF.getBaseBlock()
					.get()
					.defaultBlockState();
		if (fluid.isSame(RED_MASTIC_RESIN.get()))
			return AllPaletteStoneTypes.CRIMSITE.getBaseBlock()
					.get()
					.defaultBlockState();
		if (fluid.isSame(ORANGE_MASTIC_RESIN.get()))
			return GarnishedBlocks.RITUALISTIC_STONE.get()
					.defaultBlockState();
		if (fluid.isSame(YELLOW_MASTIC_RESIN.get()))
			return GarnishedBlocks.CARNOTITE.get()
					.defaultBlockState();
		if (fluid.isSame(GREEN_MASTIC_RESIN.get()))
			return AllPaletteStoneTypes.VERIDIUM.getBaseBlock()
					.get()
					.defaultBlockState();
		if (fluid.isSame(BLUE_MASTIC_RESIN.get()))
			return AllPaletteStoneTypes.ASURINE.getBaseBlock()
					.get()
					.defaultBlockState();
		if (fluid.isSame(PURPLE_MASTIC_RESIN.get()))
			return GarnishedBlocks.ABYSSAL_STONE.get()
					.defaultBlockState();
		return null;
	}
}