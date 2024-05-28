package net.dakotapride.garnished.registry;

import com.mojang.math.Vector3f;
import com.simibubi.create.AllFluids;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.Color;
import com.simibubi.create.infrastructure.config.AllConfigs;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.FluidEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.block.DragonBreathFluidBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
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

	public static FluidBuilder<ForgeFlowingFluid.Flowing, CreateRegistrate> standardFluid(String name,
																						  FluidBuilder.FluidTypeFactory typeFactory) {
		return CreateGarnished.registrate().fluid(name, createLocation(name, false), createLocation(name, true), typeFactory);
	}

	public static final FluidEntry<ForgeFlowingFluid.Flowing> GARNISH =
			GarnishedFluids.standardFluid("garnish", SolidRenderedPlaceableFluidType.create(0xEFE9E3,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
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
			GarnishedFluids.standardFluid("apple_cider", SolidRenderedPlaceableFluidType.create(0xEFB377,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
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
			GarnishedFluids.standardFluid("peanut_oil", SolidRenderedPlaceableFluidType.create(0xCAC49F,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
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
			GarnishedFluids.standardFluid("cashew_mixture", SolidRenderedPlaceableFluidType.create(0xFCEFCF,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
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
			GarnishedFluids.standardFluid("mastic_resin", SolidRenderedPlaceableFluidType.create(0x526B4C,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
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
			GarnishedFluids.standardFluid("red_mastic_resin", SolidRenderedPlaceableFluidType.create(0x8E1919,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
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
			GarnishedFluids.standardFluid("orange_mastic_resin", SolidRenderedPlaceableFluidType.create(0x8E1919,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
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
			GarnishedFluids.standardFluid("yellow_mastic_resin", SolidRenderedPlaceableFluidType.create(0xB28835,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
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
			GarnishedFluids.standardFluid("green_mastic_resin", SolidRenderedPlaceableFluidType.create(0x438E29,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
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
			GarnishedFluids.standardFluid("blue_mastic_resin", SolidRenderedPlaceableFluidType.create(0x397A7E,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
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
			GarnishedFluids.standardFluid("purple_mastic_resin", SolidRenderedPlaceableFluidType.create(0x572499,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
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

	public static final FluidEntry<ForgeFlowingFluid.Flowing> DRAGON_BREATH =
			GarnishedFluids.standardFluid("dragon_breath", SolidRenderedPlaceableFluidType.create(0xC54883,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
					.properties(b -> b.viscosity(1500)
							.density(1400)
							.lightLevel(15))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f)
							//.block(GarnishedBlocks.DRAGON_BREATH_FLUID)
					)
					.block((NonNullSupplier<? extends ForgeFlowingFluid.Flowing> pProperties, BlockBehaviour.Properties pProperties2) -> new DragonBreathFluidBlock(pProperties2)).build()
					.source(ForgeFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/dragon_breath"))
					.build()
					.register();

	public static final FluidEntry<ForgeFlowingFluid.Flowing> SWEET_TEA =
			GarnishedFluids.standardFluid("sweet_tea", SolidRenderedPlaceableFluidType.create(0xE28C52,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
					.properties(b -> b.viscosity(1500)
							.density(1400)
							.lightLevel(15))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(ForgeFlowingFluid.Source::new)
					// Replicate Create mod's tea fluid to not have a bucket
					.bucket()
					.tag(AllTags.forgeItemTag("buckets/sweet_tea"))
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

	public static class SolidRenderedPlaceableFluidType extends AllFluids.TintedFluidType {

		public Vector3f fogColor;
		public Supplier<Float> fogDistance;

		public static FluidBuilder.FluidTypeFactory create(int fogColor, Supplier<Float> fogDistance) {
			return (p, s, f) -> {
				SolidRenderedPlaceableFluidType fluidType = new SolidRenderedPlaceableFluidType(p, s, f);
				fluidType.fogColor = new Color(fogColor, false).asVectorF();
				fluidType.fogDistance = fogDistance;
				return fluidType;
			};
		}

		public SolidRenderedPlaceableFluidType(Properties properties, ResourceLocation stillTexture,
											   ResourceLocation flowingTexture) {
			super(properties, stillTexture, flowingTexture);
		}

		@Override
		public int getTintColor(FluidStack stack) {
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
		public Vector3f getCustomFogColor() {
			return fogColor;
		}

		@Override
		public float getFogDistanceModifier() {
			return fogDistance.get();
		}

	}
}