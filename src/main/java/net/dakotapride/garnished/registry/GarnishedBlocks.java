package net.dakotapride.garnished.registry;

import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.block.*;
import net.dakotapride.garnished.block.sapling.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

@SuppressWarnings({"unused"})
public class GarnishedBlocks {
	private static final CreateRegistrate REGISTRATE = CreateGarnished.registrate()
		.useCreativeTab(GarnishedTabs.GARNISHED);

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
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();

	public static final BlockEntry<LeavesBlock> BUHG_LEAVES =
			REGISTRATE.block("peanut_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> WALNUT_LEAVES =
			REGISTRATE.block("walnut_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> CASHEW_LEAVES =
			REGISTRATE.block("cashew_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> MACADAMIA_LEAVES =
			REGISTRATE.block("macadamia_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> PISTACHIO_LEAVES =
			REGISTRATE.block("pistachio_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> ALMOND_LEAVES =
			REGISTRATE.block("almond_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> PECAN_LEAVES =
			REGISTRATE.block("pecan_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
					.properties(p -> p.mapColor(MapColor.GRASS).noOcclusion().strength(0.2F).randomTicks())
					.register();
	public static final BlockEntry<LeavesBlock> HAZELNUT_LEAVES =
			REGISTRATE.block("hazelnut_leaves", LeavesBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.initialProperties(() -> Blocks.OAK_LEAVES)
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

	public static final BlockEntry<SoulPlantBlock> SOUL_ROOTS =
			REGISTRATE.block("soul_roots", SoulPlantBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.simpleItem()
					.initialProperties(() -> Blocks.CRIMSON_ROOTS)
					.properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).noCollission().noOcclusion()
							.pushReaction(PushReaction.DESTROY).instabreak()).register();

	public static void setRegister() {}
}
