package net.dakotapride.garnished.registry;

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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
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

	public static FluidEntry<ForgeFlowingFluid.Flowing> masticResinRegistration(String colour0, int colour1) {
		return GarnishedFluids.standardFluid((colour0 == "" ? colour0 : colour0 + "_") + "mastic_resin", SolidRenderedPlaceableFluidType.create(colour1,
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
	}

	public static final FluidEntry<ForgeFlowingFluid.Flowing> MASTIC_RESIN = masticResinRegistration("", 0x526B4C);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> RED_MASTIC_RESIN = masticResinRegistration("red", 0x8E1919);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> ORANGE_MASTIC_RESIN = masticResinRegistration("orange", 0xA5562E);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> YELLOW_MASTIC_RESIN = masticResinRegistration("yellow", 0xB28835);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> GREEN_MASTIC_RESIN = masticResinRegistration("green", 0x438E29);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> LIME_MASTIC_RESIN = masticResinRegistration("lime", 0x37C646);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> BLUE_MASTIC_RESIN = masticResinRegistration("blue", 0x397A7E);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> LIGHT_BLUE_MASTIC_RESIN = masticResinRegistration("light_blue", 0x51ABC1);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> CYAN_MASTIC_RESIN = masticResinRegistration("cyan", 0x51C198);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> PURPLE_MASTIC_RESIN = masticResinRegistration("purple", 0x572499);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> MAGENTA_MASTIC_RESIN = masticResinRegistration("magenta", 0xA12FC6);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> PINK_MASTIC_RESIN = masticResinRegistration("pink", 0xC9508D);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> BLACK_MASTIC_RESIN = masticResinRegistration("black", 0x06161E);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> GRAY_MASTIC_RESIN = masticResinRegistration("gray", 0x2D333D);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> LIGHT_GRAY_MASTIC_RESIN = masticResinRegistration("light_gray", 0x7587A3);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> WHITE_MASTIC_RESIN = masticResinRegistration("white", 0xC0C4E0);
	public static final FluidEntry<ForgeFlowingFluid.Flowing> BROWN_MASTIC_RESIN = masticResinRegistration("brown", 0x614332);

	public static final FluidEntry<ForgeFlowingFluid.Flowing> DRAGON_BREATH =
			GarnishedFluids.standardFluid("dragon_breath", SolidRenderedPlaceableFluidType.create(0xC54883,
							() -> 1f / 8f * AllConfigs.client().honeyTransparencyMultiplier.getF()))
					.properties(b -> b.viscosity(1500)
							.density(1400)
							.lightLevel(15))
					.fluidProperties(p -> p.levelDecreasePerBlock(2)
							.tickRate(25)
							.slopeFindDistance(3)
							.explosionResistance(100f))
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
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), APPLE_CIDER.getType(), Blocks.OBSIDIAN, GarnishedBlocks.CARNOTITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), GARNISH.getType(), Blocks.OBSIDIAN, AllPaletteStoneTypes.CALCITE.getBaseBlock().get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), CASHEW_MIXTURE.getType(), Blocks.OBSIDIAN, Blocks.END_STONE);

		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), RED_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.RED_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), ORANGE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.ORANGE_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), YELLOW_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.YELLOW_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), GREEN_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.GREEN_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), LIME_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.LIME_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), BLUE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.BLUE_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), LIGHT_BLUE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.LIGHT_BLUE_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), CYAN_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.CYAN_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), PURPLE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.PURPLE_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), MAGENTA_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.MAGENTA_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), PINK_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.PINK_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), BLACK_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.BLACK_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), GRAY_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.GRAY_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), LIGHT_GRAY_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.LIGHT_GRAY_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), WHITE_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.WHITE_ZULTANITE.get());
		Fluids.basicFluidInteraction(ForgeMod.LAVA_TYPE.get(), BROWN_MASTIC_RESIN.getType(), Blocks.OBSIDIAN, GarnishedBlocks.BROWN_ZULTANITE.get());
	}

	@Nullable
	public static BlockState getLavaInteraction(FluidState fluidState) {
		Fluids.lavaInteraction(fluidState, GARNISH.get(), AllPaletteStoneTypes.CALCITE.getBaseBlock().get());
		Fluids.lavaInteraction(fluidState, PEANUT_OIL.get(), AllPaletteStoneTypes.DRIPSTONE.getBaseBlock().get());
		Fluids.lavaInteraction(fluidState, APPLE_CIDER.get(), GarnishedBlocks.CARNOTITE.get());
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
