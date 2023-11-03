package net.dakotapride.garnished.registry;

import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.block.*;
import net.dakotapride.garnished.block.nut.*;
import net.dakotapride.garnished.block.sapling.*;
import net.dakotapride.garnished.block.sepia.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

@SuppressWarnings({"unused"})
public class GarnishedBlocks {
	private static final CreateRegistrate REGISTRATE = CreateGarnished.registrate()
			.setCreativeTab(GarnishedTabs.GARNISHED);

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

	public static final BlockEntry<LeavesBlock> NUT_LEAVES =
			REGISTRATE.block("nut_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();

	public static final BlockEntry<LeavesBlock> BUHG_LEAVES =
			REGISTRATE.block("peanut_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> WALNUT_LEAVES =
			REGISTRATE.block("walnut_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> CASHEW_LEAVES =
			REGISTRATE.block("cashew_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> MACADAMIA_LEAVES =
			REGISTRATE.block("macadamia_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> PISTACHIO_LEAVES =
			REGISTRATE.block("pistachio_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> ALMOND_LEAVES =
			REGISTRATE.block("almond_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> PECAN_LEAVES =
			REGISTRATE.block("pecan_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> HAZELNUT_LEAVES =
			REGISTRATE.block("hazelnut_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.simpleItem()
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();

	public static final BlockEntry<SolidifiedGarnishBlock> SOLIDIFIED_GARNISH_BLOCK =
			REGISTRATE.block("solidified_garnish", SolidifiedGarnishBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem().register();

	public static final BlockEntry<SepiaFungusBlock> SEPIA_FUNGUS =
			REGISTRATE.block("sepia_fungus", SepiaFungusBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_FUNGUS)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN).noCollission().noOcclusion()
							.pushReaction(PushReaction.DESTROY).instabreak()).register();

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

	public static void setRegister() {}
}
