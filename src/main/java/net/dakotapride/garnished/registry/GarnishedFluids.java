package net.dakotapride.garnished.registry;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.foundation.fluid.FluidHelper;
import com.simibubi.create.foundation.utility.Iterate;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nullable;

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
					.attributes(b -> b.viscosity(1500).density(800))
					.properties(p -> p.levelDecreasePerBlock(2)
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
					.attributes(b -> b.viscosity(1500)
							.density(800))
					.properties(p -> p.levelDecreasePerBlock(2)
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
					.attributes(b -> b.viscosity(1500)
							.density(800))
					.properties(p -> p.levelDecreasePerBlock(2)
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
					.attributes(b -> b.viscosity(1500)
							.density(800))
					.properties(p -> p.levelDecreasePerBlock(2)
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
					.attributes(b -> b.viscosity(1500)
							.density(800))
					.properties(p -> p.levelDecreasePerBlock(2)
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
					.attributes(b -> b.viscosity(1500)
							.density(800))
					.properties(p -> p.levelDecreasePerBlock(2)
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
					.attributes(b -> b.viscosity(1500)
							.density(800))
					.properties(p -> p.levelDecreasePerBlock(2)
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
					.attributes(b -> b.viscosity(1500)
							.density(800))
					.properties(p -> p.levelDecreasePerBlock(2)
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
					.attributes(b -> b.viscosity(1500)
							.density(800))
					.properties(p -> p.levelDecreasePerBlock(2)
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
					.attributes(b -> b.viscosity(1500)
							.density(800))
					.properties(p -> p.levelDecreasePerBlock(2)
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
					.attributes(b -> b.viscosity(1500)
							.density(800))
					.properties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/mastic_resin"))
					.build()
					.register();


	private static class NoColorFluidAttributes extends FluidAttributes {
		protected NoColorFluidAttributes(Builder builder, Fluid fluid) {
			super(builder, fluid);
		}

		@Override
		public int getColor(BlockAndTintGetter world, BlockPos pos) {
			return 0x00ffffff;
		}

	}

	public static void setRegister() {}

	@Nullable
	public static BlockState getLavaInteraction(FluidState fluidState) {
		Fluid fluid = fluidState.getType();

		if (fluid.isSame(GARNISH.get()))
			return AllPaletteStoneTypes.CALCITE.getBaseBlock().get().defaultBlockState();
		if (fluid.isSame(APPLE_CIDER.get()))
			return AllPaletteStoneTypes.OCHRUM.getBaseBlock().get().defaultBlockState();
		if (fluid.isSame(PEANUT_OIL.get()))
			return AllPaletteStoneTypes.DRIPSTONE.getBaseBlock().get().defaultBlockState();

		if (fluid.isSame(MASTIC_RESIN.get()))
			return AllPaletteStoneTypes.TUFF.getBaseBlock().get().defaultBlockState();
		if (fluid.isSame(RED_MASTIC_RESIN.get()))
			return AllPaletteStoneTypes.CRIMSITE.getBaseBlock().get().defaultBlockState();
		if (fluid.isSame(ORANGE_MASTIC_RESIN.get()))
			return Blocks.TERRACOTTA.defaultBlockState();
		if (fluid.isSame(YELLOW_MASTIC_RESIN.get()))
			return GarnishedBlocks.CARNOTITE.get().defaultBlockState();
		if (fluid.isSame(GREEN_MASTIC_RESIN.get()))
			return AllPaletteStoneTypes.VERIDIUM.getBaseBlock().get().defaultBlockState();
		if (fluid.isSame(BLUE_MASTIC_RESIN.get()))
			return AllPaletteStoneTypes.ASURINE.getBaseBlock().get().defaultBlockState();
		if (fluid.isSame(PURPLE_MASTIC_RESIN.get()))
			return GarnishedBlocks.ABYSSAL_STONE.get().defaultBlockState();

		return null;
	}
}