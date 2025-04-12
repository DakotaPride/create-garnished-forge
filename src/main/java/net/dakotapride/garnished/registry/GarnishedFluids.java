package net.dakotapride.garnished.registry;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.infrastructure.config.AllConfigs;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.createmod.catnip.theme.Color;
import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.function.Supplier;

@SuppressWarnings({"unused"})
public class GarnishedFluids implements Fluids {

	private static ResourceLocation createLocation(String fluid, boolean isFlowing) {
		String getMotion;

		if (isFlowing) {
			getMotion = "_flow";
		} else {
			getMotion = "_still";
		}

		return CreateGarnished.asResource("fluid/" + fluid + getMotion);
	}

	public static FluidBuilder<BaseFlowingFluid.Flowing, CreateRegistrate> standardFluid(String name,
																						 FluidBuilder.FluidTypeFactory typeFactory) {
		return CreateGarnished.registrate().fluid(name, createLocation(name, false), createLocation(name, true), typeFactory);
	}

	public static final FluidEntry<BaseFlowingFluid.Flowing> GARNISH =
			GarnishedFluids.standardFluid("garnish", SolidRenderedPlaceableFluidType.create(0xEFE9E3,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(BaseFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.commonItemTag("buckets/garnish"))
					.build()
					.register();

	public static final FluidEntry<BaseFlowingFluid.Flowing> APPLE_CIDER =
			GarnishedFluids.standardFluid("apple_cider", SolidRenderedPlaceableFluidType.create(0xEFB377,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
					.properties(b -> b.viscosity(1500)
							.density(1400))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(BaseFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.commonItemTag("buckets/apple_cider"))
					.build()
					.register();

	public static final FluidEntry<BaseFlowingFluid.Flowing> PEANUT_OIL =
			GarnishedFluids.standardFluid("peanut_oil", SolidRenderedPlaceableFluidType.create(0xCAC49F,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
					.properties(b -> b.viscosity(1500)
							.density(1400))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(BaseFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.commonItemTag("buckets/peanut_oil"))
					.build()
					.register();

	public static final FluidEntry<BaseFlowingFluid.Flowing> CASHEW_MIXTURE =
			GarnishedFluids.standardFluid("cashew_mixture", SolidRenderedPlaceableFluidType.create(0xFCEFCF,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
					.properties(b -> b.viscosity(1500)
							.density(1400))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(BaseFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.commonItemTag("buckets/cashew_mixture"))
					.build()
					.register();

	public static FluidEntry<BaseFlowingFluid.Flowing> masticResinRegistration(String colour0, int colour1) {
		return GarnishedFluids.standardFluid((colour0 == "" ? colour0 : colour0 + "_") + "mastic_resin", SolidRenderedPlaceableFluidType.create(colour1,
						() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
				.properties(b -> b.viscosity(1500)
						.density(1400))
				.fluidProperties(p -> p.levelDecreasePerBlock(2)
						.tickRate(25)
						.slopeFindDistance(3)
						.explosionResistance(100f))
				.source(BaseFlowingFluid.Source::new)
				.bucket()
				.tag(AllTags.commonItemTag("buckets/mastic_resin"))
				.build()
				.register();
	}

	public static final FluidEntry<BaseFlowingFluid.Flowing> MASTIC_RESIN = masticResinRegistration("", 0x526B4C);
	public static final FluidEntry<BaseFlowingFluid.Flowing> RED_MASTIC_RESIN = masticResinRegistration("red", 0x8E1919);
	public static final FluidEntry<BaseFlowingFluid.Flowing> ORANGE_MASTIC_RESIN = masticResinRegistration("orange", 0xA5562E);
	public static final FluidEntry<BaseFlowingFluid.Flowing> YELLOW_MASTIC_RESIN = masticResinRegistration("yellow", 0xB28835);
	public static final FluidEntry<BaseFlowingFluid.Flowing> GREEN_MASTIC_RESIN = masticResinRegistration("green", 0x438E29);
	public static final FluidEntry<BaseFlowingFluid.Flowing> LIME_MASTIC_RESIN = masticResinRegistration("lime", 0x37C646);
	public static final FluidEntry<BaseFlowingFluid.Flowing> BLUE_MASTIC_RESIN = masticResinRegistration("blue", 0x397A7E);
	public static final FluidEntry<BaseFlowingFluid.Flowing> LIGHT_BLUE_MASTIC_RESIN = masticResinRegistration("light_blue", 0x51ABC1);
	public static final FluidEntry<BaseFlowingFluid.Flowing> CYAN_MASTIC_RESIN = masticResinRegistration("cyan", 0x51C198);
	public static final FluidEntry<BaseFlowingFluid.Flowing> PURPLE_MASTIC_RESIN = masticResinRegistration("purple", 0x572499);
	public static final FluidEntry<BaseFlowingFluid.Flowing> MAGENTA_MASTIC_RESIN = masticResinRegistration("magenta", 0xA12FC6);
	public static final FluidEntry<BaseFlowingFluid.Flowing> PINK_MASTIC_RESIN = masticResinRegistration("pink", 0xC9508D);
	public static final FluidEntry<BaseFlowingFluid.Flowing> BLACK_MASTIC_RESIN = masticResinRegistration("black", 0x06161E);
	public static final FluidEntry<BaseFlowingFluid.Flowing> GRAY_MASTIC_RESIN = masticResinRegistration("gray", 0x2D333D);
	public static final FluidEntry<BaseFlowingFluid.Flowing> LIGHT_GRAY_MASTIC_RESIN = masticResinRegistration("light_gray", 0x7587A3);
	public static final FluidEntry<BaseFlowingFluid.Flowing> WHITE_MASTIC_RESIN = masticResinRegistration("white", 0xC0C4E0);
	public static final FluidEntry<BaseFlowingFluid.Flowing> BROWN_MASTIC_RESIN = masticResinRegistration("brown", 0x614332);

	public static final FluidEntry<BaseFlowingFluid.Flowing> DRAGON_BREATH =
			GarnishedFluids.standardFluid("dragon_breath", SolidRenderedPlaceableFluidType.create(0xC54883,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
					.properties(b -> b.viscosity(1500)
							.density(1400)
							.lightLevel(15))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					// Currently brokek
					//.block((NonNullSupplier<? extends BaseFlowingFluid.Flowing> pProperties, BlockBehaviour.Properties pProperties2) -> new DragonBreathFluidBlock(pProperties2)).build()
					.source(BaseFlowingFluid.Source::new)
					.bucket()
					.tag(AllTags.commonItemTag("buckets/dragon_breath"))
					.build()
					.register();

	public static final FluidEntry<BaseFlowingFluid.Flowing> SWEET_TEA =
			GarnishedFluids.standardFluid("sweet_tea", SolidRenderedPlaceableFluidType.create(0xE28C52,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
					.properties(b -> b.viscosity(1500)
							.density(1400)
							.lightLevel(15))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
					.source(BaseFlowingFluid.Source::new)
					// Replicate Create mod's tea fluid to not have a bucket
					.bucket()
					.tag(AllTags.commonItemTag("buckets/sweet_tea"))
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
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), PEANUT_OIL.getType(), Blocks.OBSIDIAN, AllPaletteStoneTypes.DRIPSTONE.getBaseBlock().get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), APPLE_CIDER.getType(), Blocks.OBSIDIAN, GarnishedPaletteStoneTypes.CARNOTITE.getBlock().get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), GARNISH.getType(), Blocks.OBSIDIAN, AllPaletteStoneTypes.CALCITE.getBaseBlock().get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), CASHEW_MIXTURE.getType(), Blocks.OBSIDIAN, Blocks.END_STONE);

		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), RED_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.RED_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), ORANGE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.ORANGE_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), YELLOW_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.YELLOW_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), GREEN_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.GREEN_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), LIME_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.LIME_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), BLUE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.BLUE_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), LIGHT_BLUE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.LIGHT_BLUE_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), CYAN_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.CYAN_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), PURPLE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.PURPLE_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), MAGENTA_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.MAGENTA_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), PINK_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.PINK_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), BLACK_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.BLACK_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), GRAY_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.GRAY_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), LIGHT_GRAY_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.LIGHT_GRAY_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), WHITE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.WHITE_ZULTANITE.get());
		Fluids.basicFluidInteraction(NeoForgeMod.LAVA_TYPE.value(), BROWN_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.BROWN_ZULTANITE.get());


//		// Colour Combinations
//		// Red + Blue = Purple
//		Fluids.basicFluidInteraction(RED_MASTIC_RESIN.getType(), BLUE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.PURPLE_ZULTANITE.get());
//		// Blue + Yellow = Green
//		Fluids.basicFluidInteraction(BLUE_MASTIC_RESIN.getType(), YELLOW_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.GREEN_ZULTANITE.get());
//		// Red + Yellow = Orange
//		Fluids.basicFluidInteraction(RED_MASTIC_RESIN.getType(), YELLOW_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.ORANGE_ZULTANITE.get());
//		// Purple + White = Magenta
//		Fluids.basicFluidInteraction(PURPLE_MASTIC_RESIN.getType(), WHITE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.MAGENTA_ZULTANITE.get());
//		// Purple + Pink = Magenta (alternative)
//		Fluids.basicFluidInteraction(PURPLE_MASTIC_RESIN.getType(), PINK_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.MAGENTA_ZULTANITE.get());
//		// Magenta + White = Pink
//		Fluids.basicFluidInteraction(MAGENTA_MASTIC_RESIN.getType(), WHITE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.PINK_ZULTANITE.get());
//		// Blue + White = Light Blue
//		Fluids.basicFluidInteraction(BLUE_MASTIC_RESIN.getType(), WHITE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.LIGHT_BLUE_ZULTANITE.get());
//		// Blue + Green = Cyan
//		Fluids.basicFluidInteraction(BLUE_MASTIC_RESIN.getType(), GREEN_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.CYAN_ZULTANITE.get());
//		// Green + White = Lime
//		Fluids.basicFluidInteraction(GREEN_MASTIC_RESIN.getType(), WHITE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.LIME_ZULTANITE.get());
//		// Orange + Black = Brown
//		Fluids.basicFluidInteraction(ORANGE_MASTIC_RESIN.getType(), BLACK_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.BROWN_ZULTANITE.get());
	}

	@Nullable
	public static BlockState getLavaInteraction(FluidState fluidState) {
		Fluids.lavaInteraction(fluidState, GARNISH.get(), AllPaletteStoneTypes.CALCITE.getBaseBlock().get());
		Fluids.lavaInteraction(fluidState, PEANUT_OIL.get(), AllPaletteStoneTypes.DRIPSTONE.getBaseBlock().get());
		Fluids.lavaInteraction(fluidState, APPLE_CIDER.get(), GarnishedPaletteStoneTypes.CARNOTITE.getBlock().get());
		Fluids.lavaInteraction(fluidState, CASHEW_MIXTURE.get(), Blocks.END_STONE);

		Fluids.lavaInteraction(fluidState, MASTIC_RESIN.get(), GarnishedBlocks.ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, RED_MASTIC_RESIN.get(), GarnishedBlocks.RED_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, ORANGE_MASTIC_RESIN.get(), GarnishedBlocks.ORANGE_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, YELLOW_MASTIC_RESIN.get(), GarnishedBlocks.YELLOW_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, GREEN_MASTIC_RESIN.get(), GarnishedBlocks.GREEN_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, LIME_MASTIC_RESIN.get(), GarnishedBlocks.LIME_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, BLUE_MASTIC_RESIN.get(), GarnishedBlocks.BLUE_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, LIGHT_BLUE_MASTIC_RESIN.get(), GarnishedBlocks.LIGHT_BLUE_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, CYAN_MASTIC_RESIN.get(), GarnishedBlocks.CYAN_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, PURPLE_MASTIC_RESIN.get(), GarnishedBlocks.PURPLE_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, MAGENTA_MASTIC_RESIN.get(), GarnishedBlocks.MAGENTA_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, PINK_MASTIC_RESIN.get(), GarnishedBlocks.PINK_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, BLACK_MASTIC_RESIN.get(), GarnishedBlocks.BLACK_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, GRAY_MASTIC_RESIN.get(), GarnishedBlocks.GRAY_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, LIGHT_GRAY_MASTIC_RESIN.get(), GarnishedBlocks.LIGHT_GRAY_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, WHITE_MASTIC_RESIN.get(), GarnishedBlocks.WHITE_ZULTANITE.get());
		Fluids.lavaInteraction(fluidState, BROWN_MASTIC_RESIN.get(), GarnishedBlocks.BROWN_ZULTANITE.get());

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
