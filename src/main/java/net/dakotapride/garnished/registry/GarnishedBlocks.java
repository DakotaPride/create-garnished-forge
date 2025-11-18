package net.dakotapride.garnished.registry;

import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;
import com.simibubi.create.content.decoration.palettes.WindowBlock;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.block.*;
import net.dakotapride.garnished.block.cake.AnniversaryCakeBlock;
import net.dakotapride.garnished.block.kelp.DulseKelpBlock;
import net.dakotapride.garnished.block.kelp.DulseKelpPlantBlock;
import net.dakotapride.garnished.block.kelp.VermilionKelpBlock;
import net.dakotapride.garnished.block.kelp.VermilionKelpPlantBlock;
import net.dakotapride.garnished.block.nut.*;
import net.dakotapride.garnished.block.potted_blocks.*;
import net.dakotapride.garnished.block.sapling.*;
import net.dakotapride.garnished.block.sepia.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static net.dakotapride.garnished.registry.GarnishedCT.woodenWindowBlock;
import static net.dakotapride.garnished.registry.GarnishedCT.woodenWindowPaneBlock;

@SuppressWarnings({"unused"})
public class GarnishedBlocks {
	private static final CreateRegistrate REGISTRATE = CreateGarnished.registrate();

	public static final BlockEntry<Block> NUT_PLANT =
			REGISTRATE.block("nut_plant", Block::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.properties(p -> p.mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.GRASS))
					.register();

	public static final BlockEntry<NutSackBlock> BUHG_SACK =
			REGISTRATE.block("peanut_sack", NutSackBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.WHITE_WOOL)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
					.simpleItem()
					.register();
	public static final BlockEntry<NutSackBlock> WALNUT_SACK =
			REGISTRATE.block("walnut_sack", NutSackBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.WHITE_WOOL)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
					.simpleItem()
					.register();
	public static final BlockEntry<NutSackBlock> CASHEW_SACK =
			REGISTRATE.block("cashew_sack", NutSackBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.WHITE_WOOL)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
					.simpleItem()
					.register();
	public static final BlockEntry<NutSackBlock> MACADAMIA_SACK =
			REGISTRATE.block("macadamia_sack", NutSackBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.WHITE_WOOL)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
					.simpleItem()
					.register();
	public static final BlockEntry<NutSackBlock> PISTACHIO_SACK =
			REGISTRATE.block("pistachio_sack", NutSackBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.WHITE_WOOL)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
					.simpleItem()
					.register();
	public static final BlockEntry<NutSackBlock> ALMOND_SACK =
			REGISTRATE.block("almond_sack", NutSackBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.WHITE_WOOL)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
					.simpleItem()
					.register();
	public static final BlockEntry<NutSackBlock> PECAN_SACK =
			REGISTRATE.block("pecan_sack", NutSackBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.WHITE_WOOL)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
					.simpleItem()
					.register();
	public static final BlockEntry<NutSackBlock> HAZELNUT_SACK =
			REGISTRATE.block("hazelnut_sack", NutSackBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.WHITE_WOOL)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
					.simpleItem()
					.register();
	public static final BlockEntry<NutSackBlock> CHESTNUT_SACK =
			REGISTRATE.block("chestnut_sack", NutSackBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.WHITE_WOOL)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
					.simpleItem()
					.register();

	public static final BlockEntry<BuhgSaplingBlock> BUHG_SAPLING =
			REGISTRATE.block("peanut_sapling", BuhgSaplingBlock::new)
					.initialProperties(() -> Blocks.OAK_SAPLING)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.properties(p -> p.mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.GRASS))
					.register();
	public static final BlockEntry<WalnutSaplingBlock> WALNUT_SAPLING =
			REGISTRATE.block("walnut_sapling", WalnutSaplingBlock::new)
					.initialProperties(() -> Blocks.OAK_SAPLING)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.properties(p -> p.mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.GRASS))
					.register();
	public static final BlockEntry<CashewSaplingBlock> CASHEW_SAPLING =
			REGISTRATE.block("cashew_sapling", CashewSaplingBlock::new)
					.initialProperties(() -> Blocks.OAK_SAPLING)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.properties(p -> p.mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.GRASS))
					.register();
	public static final BlockEntry<MacadamiaSaplingBlock> MACADAMIA_SAPLING =
			REGISTRATE.block("macadamia_sapling", MacadamiaSaplingBlock::new)
					.initialProperties(() -> Blocks.OAK_SAPLING)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.properties(p -> p.mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.GRASS))
					.register();
	public static final BlockEntry<PistachioSaplingBlock> PISTACHIO_SAPLING =
			REGISTRATE.block("pistachio_sapling", PistachioSaplingBlock::new)
					.initialProperties(() -> Blocks.OAK_SAPLING)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.properties(p -> p.mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.GRASS))
					.register();
	public static final BlockEntry<AlmondSaplingBlock> ALMOND_SAPLING =
			REGISTRATE.block("almond_sapling", AlmondSaplingBlock::new)
					.initialProperties(() -> Blocks.OAK_SAPLING)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.properties(p -> p.mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.GRASS))
					.register();
	public static final BlockEntry<PecanSaplingBlock> PECAN_SAPLING =
			REGISTRATE.block("pecan_sapling", PecanSaplingBlock::new)
					.initialProperties(() -> Blocks.OAK_SAPLING)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.properties(p -> p.mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.GRASS))
					.register();
	public static final BlockEntry<HazelnutSaplingBlock> HAZELNUT_SAPLING =
			REGISTRATE.block("hazelnut_sapling", HazelnutSaplingBlock::new)
					.initialProperties(() -> Blocks.OAK_SAPLING)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.properties(p -> p.mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.GRASS))
					.register();
	public static final BlockEntry<ChestnutSaplingBlock> CHESTNUT_SAPLING =
			REGISTRATE.block("chestnut_sapling", ChestnutSaplingBlock::new)
					.initialProperties(() -> Blocks.OAK_SAPLING)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.properties(p -> p.mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.GRASS))
					.register();

	public static final BlockEntry<NutLeavesBlock> UNASSIGNED_NUT_LEAVES =
			REGISTRATE.block("unassigned_nut_leaves", NutLeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();

	public static final BlockEntry<NutLeavesBlock> NUT_LEAVES =
			REGISTRATE.block("nut_leaves", NutLeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();

	public static final BlockEntry<NutLeavesBlock> BUHG_LEAVES =
			REGISTRATE.block("peanut_leaves", NutLeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<NutLeavesBlock> WALNUT_LEAVES =
			REGISTRATE.block("walnut_leaves", NutLeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<NutLeavesBlock> CASHEW_LEAVES =
			REGISTRATE.block("cashew_leaves", NutLeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<NutLeavesBlock> MACADAMIA_LEAVES =
			REGISTRATE.block("macadamia_leaves", NutLeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<NutLeavesBlock> PISTACHIO_LEAVES =
			REGISTRATE.block("pistachio_leaves", NutLeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<NutLeavesBlock> ALMOND_LEAVES =
			REGISTRATE.block("almond_leaves", NutLeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<NutLeavesBlock> PECAN_LEAVES =
			REGISTRATE.block("pecan_leaves", NutLeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<NutLeavesBlock> HAZELNUT_LEAVES =
			REGISTRATE.block("hazelnut_leaves", NutLeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<NutLeavesBlock> CHESTNUT_LEAVES =
			REGISTRATE.block("chestnut_leaves", NutLeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();

	public static final BlockEntry<SolidifiedGarnishBlock> SOLIDIFIED_GARNISH_BLOCK =
			REGISTRATE.block("solidified_garnish", SolidifiedGarnishBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem().register();
	public static final BlockEntry<SolidifiedGarnishBlock> SOLIDIFIED_GARNISH_BRICKS =
			REGISTRATE.block("solidified_garnish_bricks", SolidifiedGarnishBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem().register();

	public static final BlockEntry<SepiaFungusBlock> SEPIA_FUNGUS =
			REGISTRATE.block("sepia_fungus", SepiaFungusBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_FUNGUS)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN).noCollission().noOcclusion()
							.pushReaction(PushReaction.DESTROY).sound(SoundType.FUNGUS).instabreak()).register();

	public static final BlockEntry<SepiaStemBlock> SEPIA_STEM =
			REGISTRATE.block("sepia_stem", SepiaStemBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_STEM).register();
	public static final BlockEntry<SepiaStemBlock> STRIPPED_SEPIA_STEM =
			REGISTRATE.block("stripped_sepia_stem", SepiaStemBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.STRIPPED_CRIMSON_STEM)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<SepiaStemBlock> SEPIA_HYPHAE =
			REGISTRATE.block("sepia_hyphae", SepiaStemBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_HYPHAE).register();
	public static final BlockEntry<SepiaStemBlock> STRIPPED_SEPIA_HYPHAE =
			REGISTRATE.block("stripped_sepia_hyphae", SepiaStemBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.STRIPPED_CRIMSON_HYPHAE)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<Block> SEPIA_WART_BLOCK =
			REGISTRATE.block("sepia_wart_block", Block::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.NETHER_WART_BLOCK)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<SepiaTrapdoorBlock> SEPIA_TRAPDOOR =
			REGISTRATE.block("sepia_trapdoor", SepiaTrapdoorBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_TRAPDOOR)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<SepiaDoorBlock> SEPIA_DOOR =
			REGISTRATE.block("sepia_door", SepiaDoorBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_DOOR)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<Block> SEPIA_PLANKS =
			REGISTRATE.block("sepia_planks", Block::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_PLANKS)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<SlabBlock> SEPIA_SLAB =
			REGISTRATE.block("sepia_slab", SlabBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_SLAB)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<SepiaStairsBlock> SEPIA_STAIRS =
			REGISTRATE.block("sepia_stairs", SepiaStairsBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_STAIRS)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	// v1.3
	public static final BlockEntry<SepiaSignBlock> SEPIA_SIGN =
			REGISTRATE.block("sepia_sign", SepiaSignBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.CRIMSON_SIGN)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<SepiaWallSignBlock> SEPIA_WALL_SIGN =
			REGISTRATE.block("sepia_wall_sign", SepiaWallSignBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.CRIMSON_WALL_SIGN)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<SepiaHangingSignBlock> SEPIA_HANGING_SIGN =
			REGISTRATE.block("sepia_hanging_sign", SepiaHangingSignBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.CRIMSON_HANGING_SIGN)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<SepiaWallHangingSignBlock> SEPIA_WALL_HANGING_SIGN =
			REGISTRATE.block("sepia_wall_hanging_sign", SepiaWallHangingSignBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.CRIMSON_WALL_HANGING_SIGN)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<FenceBlock> SEPIA_FENCE =
			REGISTRATE.block("sepia_fence", FenceBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_FENCE)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<SepiaFenceGateBlock> SEPIA_FENCE_GATE =
			REGISTRATE.block("sepia_fence_gate", SepiaFenceGateBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_FENCE_GATE)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<SepiaButtonBlock> SEPIA_BUTTON =
			REGISTRATE.block("sepia_button", SepiaButtonBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_BUTTON)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();
	public static final BlockEntry<SepiaPressurePlateBlock> SEPIA_PRESSURE_PLATE =
			REGISTRATE.block("sepia_pressure_plate", SepiaPressurePlateBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_PRESSURE_PLATE)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)).register();

	public static final BlockEntry<SoulPlantBlock> SOUL_ROOTS =
			REGISTRATE.block("soul_roots", SoulPlantBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_ROOTS)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).noCollission().noOcclusion()
							.pushReaction(PushReaction.DESTROY).instabreak()).register();

	public static final BlockEntry<EnderJellyBlock> BLOCK_OF_ENDER_JELLY =
			REGISTRATE.block("ender_jelly_block", EnderJellyBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.HONEY_BLOCK)
					.properties(p -> p.mapColor(MapColor.COLOR_CYAN).noOcclusion().instabreak()).register();

	public static final BlockEntry<EndPlantBlock> BARREN_ROOTS =
			REGISTRATE.block("barren_roots", EndPlantBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_ROOTS)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE).noCollission().noOcclusion().instabreak()).register();

	public static final BlockEntry<EndPlantBlock> SMALL_CHORUS_PLANT =
			REGISTRATE.block("small_chorus_plant", EndPlantBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_ROOTS)
					.properties(p -> p.mapColor(MapColor.COLOR_PURPLE).noCollission().noOcclusion().instabreak()).register();

	public static final BlockEntry<Block> UNGARNISHED_NUT_BLOCK =
			REGISTRATE.block("ungarnished_nut_block", Block::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.OAK_WOOD).register();
	public static final BlockEntry<Block> GARNISHED_NUT_BLOCK =
			REGISTRATE.block("garnished_nut_block", Block::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.OAK_WOOD).register();

	public static final BlockEntry<Block> NUT_PLANKS =
			REGISTRATE.block("nut_planks", Block::new)
					.initialProperties(() -> Blocks.OAK_PLANKS)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutLogBlock> NUT_LOG =
			REGISTRATE.block("nut_log", NutLogBlock::new)
					.initialProperties(() -> Blocks.OAK_LOG)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutLogBlock> STRIPPED_NUT_LOG =
			REGISTRATE.block("stripped_nut_log", NutLogBlock::new)
					.initialProperties(() -> Blocks.STRIPPED_OAK_LOG)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutLogBlock> NUT_WOOD =
			REGISTRATE.block("nut_wood", NutLogBlock::new)
					.initialProperties(() -> Blocks.OAK_WOOD)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutLogBlock> STRIPPED_NUT_WOOD =
			REGISTRATE.block("stripped_nut_wood", NutLogBlock::new)
					.initialProperties(() -> Blocks.STRIPPED_OAK_WOOD)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<SlabBlock> NUT_SLAB =
			REGISTRATE.block("nut_slab", SlabBlock::new)
					.initialProperties(() -> Blocks.OAK_SLAB)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutStairsBlock> NUT_STAIRS =
			REGISTRATE.block("nut_stairs", NutStairsBlock::new)
					.initialProperties(() -> Blocks.OAK_STAIRS)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutDoorBlock> NUT_DOOR =
			REGISTRATE.block("nut_door", NutDoorBlock::new)
					.initialProperties(() -> Blocks.OAK_DOOR)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutTrapdoorBlock> NUT_TRAPDOOR =
			REGISTRATE.block("nut_trapdoor", NutTrapdoorBlock::new)
					.initialProperties(() -> Blocks.OAK_TRAPDOOR)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	// v1.3
	public static final BlockEntry<NutSignBlock> NUT_SIGN =
			REGISTRATE.block("nut_sign", NutSignBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_SIGN)
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutWallSignBlock> NUT_WALL_SIGN =
			REGISTRATE.block("nut_wall_sign", NutWallSignBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_WALL_SIGN)
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutHangingSignBlock> NUT_HANGING_SIGN =
			REGISTRATE.block("nut_hanging_sign", NutHangingSignBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_HANGING_SIGN)
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutWallHangingSignBlock> NUT_WALL_HANGING_SIGN =
			REGISTRATE.block("nut_wall_hanging_sign", NutWallHangingSignBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_WALL_HANGING_SIGN)
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<FenceBlock> NUT_FENCE =
			REGISTRATE.block("nut_fence", FenceBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.OAK_FENCE)
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutFenceGateBlock> NUT_FENCE_GATE =
			REGISTRATE.block("nut_fence_gate", NutFenceGateBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.OAK_FENCE_GATE)
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutButtonBlock> NUT_BUTTON =
			REGISTRATE.block("nut_button", NutButtonBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.OAK_BUTTON)
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();
	public static final BlockEntry<NutPressurePlateBlock> NUT_PRESSURE_PLATE =
			REGISTRATE.block("nut_pressure_plate", NutPressurePlateBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.OAK_PRESSURE_PLATE)
					.properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN)).register();

	// 2.0 - It took how many months for these windows to FINALLY be added? Damn.
	public static final BlockEntry<WindowBlock> NUT_WINDOW = woodenWindowBlock("nut", () -> GarnishedCT.NUT_WINDOW, GarnishedBlocks.NUT_PLANKS);
	public static final BlockEntry<WindowBlock> SEPIA_WINDOW = woodenWindowBlock("sepia", () -> GarnishedCT.SEPIA_WINDOW, GarnishedBlocks.SEPIA_PLANKS);

	public static final BlockEntry<ConnectedGlassPaneBlock> NUT_WINDOW_PANE =
			woodenWindowPaneBlock("nut", () -> GarnishedCT.NUT_WINDOW_PANE, GarnishedBlocks.NUT_WINDOW);
	public static final BlockEntry<ConnectedGlassPaneBlock> SEPIA_WINDOW_PANE =
			woodenWindowPaneBlock("sepia", () -> GarnishedCT.SEPIA_WINDOW_PANE, GarnishedBlocks.SEPIA_WINDOW);

	// Other
	public static final BlockEntry<NumbingParchmentBlock> NUMBING_PARCHMENT_BLOCK =
			REGISTRATE.block("numbing_parchment_block", NumbingParchmentBlock::new)
					//.onRegister(connectedTextures(() -> new SimpleCTBehaviour(GarnishedCT.NUMBING_PARCHMENT)))
					.initialProperties(() -> Blocks.WHITE_WOOL)
					.simpleItem().register();
	public static final BlockEntry<NumbingParchmentBlock.Carpet> NUMBING_PARCHMENT_CARPET =
			REGISTRATE.block("numbing_parchment_carpet", NumbingParchmentBlock.Carpet::new)
					//.onRegister(connectedTextures(() -> new SimpleCTBehaviour(GarnishedCT.NUMBING_PARCHMENT)))
					.initialProperties(() -> Blocks.WHITE_CARPET)
					.simpleItem().register();

	// v1.5
	public static final BlockEntry<VermilionKelpBlock> VERMILION_KELP =
			REGISTRATE.block("vermilion_kelp", VermilionKelpBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.KELP).register();
	public static final BlockEntry<VermilionKelpPlantBlock> VERMILION_KELP_PLANT =
			REGISTRATE.block("vermilion_kelp_plant", VermilionKelpPlantBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.KELP_PLANT).register();
	public static final BlockEntry<Block> DRIED_VERMILION_KELP_BLOCK =
			REGISTRATE.block("dried_vermilion_kelp_block", Block::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.DRIED_KELP_BLOCK).register();

	public static final BlockEntry<DulseKelpBlock> DULSE_KELP =
			REGISTRATE.block("dulse_kelp", DulseKelpBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.KELP).register();
	public static final BlockEntry<DulseKelpPlantBlock> DULSE_KELP_PLANT =
			REGISTRATE.block("dulse_kelp_plant", DulseKelpPlantBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.KELP_PLANT).register();
	public static final BlockEntry<Block> DRIED_DULSE_KELP_BLOCK =
			REGISTRATE.block("dried_dulse_kelp_block", Block::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.DRIED_KELP_BLOCK).register();

	public static final BlockEntry<VoltaicSeagrassBlock> VOLTAIC_SEA_GRASS =
			REGISTRATE.block("voltaic_sea_grass", VoltaicSeagrassBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.SEAGRASS).register();

	public static final BlockEntry<Block> GARNISH_COMPOUND_BLOCK =
			REGISTRATE.block("garnish_compound_block", Block::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.BONE_BLOCK).register();
	public static final BlockEntry<Block> SALT_COMPOUND_BLOCK =
			REGISTRATE.block("salt_compound_block", Block::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.BONE_BLOCK).register();
	public static final BlockEntry<Block> ETHEREAL_COMPOUND_BLOCK =
			REGISTRATE.block("ethereal_compound_block", Block::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.BONE_BLOCK).register();
	public static final BlockEntry<Block> MULCH_BLOCK =
			REGISTRATE.block("mulch_block", Block::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.OAK_WOOD).register();

	public static final BlockEntry<NetherFlowerBlock> PANSOPHICAL_DAISY =
			REGISTRATE.block("pansophical_daisy", NetherFlowerBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.WARPED_FUNGUS).register();
	public static final BlockEntry<NetherFlowerBlock> INCANDESCENT_LILY =
			REGISTRATE.block("incandescent_lily", NetherFlowerBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_FUNGUS).register();
	public static final BlockEntry<NetherLichenBlock> SORROWFUL_LICHEN =
			REGISTRATE.block("sorrowful_lichen", NetherLichenBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.properties(p -> p.lightLevel(NetherLichenBlock.emission(4)).mapColor(MapColor.GLOW_LICHEN)
							.replaceable().noCollission().strength(0.2F).sound(SoundType.GLOW_LICHEN)
							.pushReaction(PushReaction.DESTROY)).register();
	public static final BlockEntry<RotatedPillarBlock> SENILE_BONE_BLOCK =
			REGISTRATE.block("senile_bone_block", RotatedPillarBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.BONE_BLOCK).register();

	public static final BlockEntry<EndPlantBlock> AUREATE_SHRUB =
			REGISTRATE.block("aureate_shrub", EndPlantBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.WARPED_ROOTS).register();

	public static final BlockEntry<PottedSepiaFungusBlock> POTTED_SEPIA_FUNGUS =
			REGISTRATE.block("potted_sepia_fungus", PottedSepiaFungusBlock::new)
					.initialProperties(() -> Blocks.POTTED_CRIMSON_FUNGUS).register();
	public static final BlockEntry<PottedSoulRootsBlock> POTTED_SOUL_ROOTS =
			REGISTRATE.block("potted_soul_roots", PottedSoulRootsBlock::new)
					.initialProperties(() -> Blocks.POTTED_CRIMSON_FUNGUS).register();
	public static final BlockEntry<PottedBarrenRootsBlock> POTTED_BARREN_ROOTS =
			REGISTRATE.block("potted_barren_roots", PottedBarrenRootsBlock::new)
					.initialProperties(() -> Blocks.POTTED_CRIMSON_FUNGUS).register();
	public static final BlockEntry<PottedSmallChorusPlantBlock> POTTED_SMALL_CHORUS_PLANT =
			REGISTRATE.block("potted_small_chorus_plant", PottedSmallChorusPlantBlock::new)
					.initialProperties(() -> Blocks.POTTED_CRIMSON_FUNGUS).register();
	public static final BlockEntry<PottedPansophicalDaisyBlock> POTTED_PANSOPHICAL_DAISY =
			REGISTRATE.block("potted_pansophical_daisy", PottedPansophicalDaisyBlock::new)
					.initialProperties(() -> Blocks.POTTED_CRIMSON_FUNGUS).register();
	public static final BlockEntry<PottedIncandescentLilyBlock> POTTED_INCANDESCENT_LILY =
			REGISTRATE.block("potted_incandescent_lily", PottedIncandescentLilyBlock::new)
					.initialProperties(() -> Blocks.POTTED_CRIMSON_FUNGUS).register();

	public static final BlockEntry<PottedAureateShrubBlock> POTTED_AUREATE_SHRUB =
			REGISTRATE.block("potted_aureate_shrub", PottedAureateShrubBlock::new)
					.initialProperties(() -> Blocks.POTTED_CRIMSON_FUNGUS).register();

	public static final BlockEntry<Block> AMBER_REMNANT_BLOCK =
			REGISTRATE.block("amber_remnant_block", Block::new)
					.onRegister(connectedTextures(() -> new SimpleCTBehaviour(GarnishedCT.AMBER_REMNANT_BLOCK)))
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.STONE)
					.properties(p -> p.explosionResistance(12.0F)).register();
	public static final BlockEntry<SlabBlock> AMBER_REMNANT_SLAB =
			REGISTRATE.block("amber_remnant_slab", SlabBlock::new)
					.onRegister(connectedTextures(() -> new SimpleCTBehaviour(GarnishedCT.AMBER_REMNANT_BLOCK)))
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.STONE)
					.properties(p -> p.explosionResistance(12.0F)).register();
	public static final BlockEntry<AmberRemnantStairsBlock> AMBER_REMNANT_STAIRS =
			REGISTRATE.block("amber_remnant_stairs", AmberRemnantStairsBlock::new)
					.onRegister(connectedTextures(() -> new SimpleCTBehaviour(GarnishedCT.AMBER_REMNANT_BLOCK)))
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.STONE)
					.properties(p -> p.explosionResistance(12.0F)).register();
	public static final BlockEntry<WallBlock> AMBER_REMNANT_WALL =
			REGISTRATE.block("amber_remnant_wall", WallBlock::new)
					.onRegister(connectedTextures(() -> new SimpleCTBehaviour(GarnishedCT.AMBER_REMNANT_BLOCK)))
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.STONE)
					.properties(p -> p.explosionResistance(12.0F)).register();

	public static final BlockEntry<Block> AMBER_REMNANT_BRICKS =
			REGISTRATE.block("amber_remnant_bricks", Block::new)
					//.onRegister(connectedTextures(() -> new SimpleCTBehaviour(GarnishedCT.AMBER_REMNANT_BLOCK)))
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.STONE)
					.properties(p -> p.explosionResistance(12.0F)).register();
	public static final BlockEntry<SlabBlock> AMBER_REMNANT_BRICK_SLAB =
			REGISTRATE.block("amber_remnant_brick_slab", SlabBlock::new)
					//.onRegister(connectedTextures(() -> new SimpleCTBehaviour(GarnishedCT.AMBER_REMNANT_BLOCK)))
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.STONE)
					.properties(p -> p.explosionResistance(12.0F)).register();
	public static final BlockEntry<AmberRemnantStairsBlock> AMBER_REMNANT_BRICK_STAIRS =
			REGISTRATE.block("amber_remnant_brick_stairs", AmberRemnantStairsBlock::new)
					//.onRegister(connectedTextures(() -> new SimpleCTBehaviour(GarnishedCT.AMBER_REMNANT_BLOCK)))
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.STONE)
					.properties(p -> p.explosionResistance(12.0F)).register();
	public static final BlockEntry<WallBlock> AMBER_REMNANT_BRICK_WALL =
			REGISTRATE.block("amber_remnant_brick_wall", WallBlock::new)
					//.onRegister(connectedTextures(() -> new SimpleCTBehaviour(GarnishedCT.AMBER_REMNANT_BLOCK)))
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.STONE)
					.properties(p -> p.explosionResistance(12.0F)).register();

	public static final BlockEntry<Block> POLAR_BEAR_HIDE_BLOCK =
			REGISTRATE.block("polar_bear_hide_block", Block::new)
					//.onRegister(connectedTextures(() -> new SimpleCTBehaviour(GarnishedCT.AMBER_REMNANT_BLOCK)))
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.WHITE_WOOL)
					.properties(p -> p.explosionResistance(1200.0F)).register();

	public static final BlockEntry<Block> PACKED_POLAR_BEAR_HIDE_BLOCK =
			REGISTRATE.block("packed_polar_bear_hide_block", Block::new)
					//.onRegister(connectedTextures(() -> new SimpleCTBehaviour(GarnishedCT.AMBER_REMNANT_BLOCK)))
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.WHITE_WOOL)
					.properties(p -> p.explosionResistance(1200.0F)).register();

	public static final BlockEntry<AnniversaryCakeBlock> ANNIVERSARY_CAKE =
			REGISTRATE.block("anniversary_cake", AnniversaryCakeBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CAKE).register();

	public static final BlockEntry<BokChoyPlantBlock> BOK_CHOY_PLANT =
			REGISTRATE.block("bok_choy_plant", BokChoyPlantBlock::new)
					.initialProperties(() -> Blocks.WHEAT)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.properties(p -> p.mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.GRASS))
					.register();

	// Farmer's/My Nether's Delight Compat
	public static final BlockEntry<SoulFungusColonyBlock> SEPIA_FUNGUS_COLONY = REGISTRATE.block("sepia_fungus_colony", p ->
			new SoulFungusColonyBlock(BlockBehaviour.Properties.ofFullCopy(GarnishedBlocks.SEPIA_FUNGUS.get()).randomTicks())
	).simpleItem().register();

	public static void setRegister() {
		GarnishedPaletteStoneTypes.register();
		ZultaniteStoneTypes.register();
	}
}
