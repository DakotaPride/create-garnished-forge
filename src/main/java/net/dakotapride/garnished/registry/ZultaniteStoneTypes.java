package net.dakotapride.garnished.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.block.MasticBlock;
import net.dakotapride.garnished.block.ZultaniteStairsBlock;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

public enum ZultaniteStoneTypes {
    DEFAULT(),
    RED(MapColor.COLOR_RED),
    ORANGE(MapColor.COLOR_ORANGE),
    YELLOW(MapColor.COLOR_YELLOW),
    GREEN(MapColor.COLOR_GREEN),
    LIME(MapColor.COLOR_LIGHT_GREEN),
    BLUE(MapColor.COLOR_BLUE),
    LIGHT_BLUE(MapColor.COLOR_LIGHT_BLUE),
    CYAN(MapColor.COLOR_CYAN),
    PURPLE(MapColor.COLOR_PURPLE),
    MAGENTA(MapColor.COLOR_MAGENTA),
    PINK(MapColor.COLOR_PINK),
    BLACK(MapColor.COLOR_BLACK),
    GRAY(MapColor.COLOR_GRAY),
    LIGHT_GRAY(MapColor.COLOR_LIGHT_GRAY),
    WHITE(MapColor.TERRACOTTA_WHITE),
    BROWN(MapColor.COLOR_BROWN),



    ;

    private final BlockEntry<MasticBlock> slimeLikeBlock;
    private final BlockEntry<Block> block;
    private final BlockEntry<SlabBlock> slabBlock;
    private final BlockEntry<ZultaniteStairsBlock> stairsBlock;
    private final BlockEntry<WallBlock> wallBlock;
    private final BlockEntry<Block> polishedBlock;
    private final BlockEntry<SlabBlock> polishedSlabBlock;
    private final BlockEntry<ZultaniteStairsBlock> polishedStairsBlock;
    private final BlockEntry<WallBlock> polishedWallBlock;
    private final BlockEntry<Block> brickBlock;
    private final BlockEntry<SlabBlock> brickSlabBlock;
    private final BlockEntry<ZultaniteStairsBlock> brickStairsBlock;
    private final BlockEntry<WallBlock> brickWallBlock;
    private final BlockEntry<Block> smallBrickBlock;
    private final BlockEntry<SlabBlock> smallBrickSlabBlock;
    private final BlockEntry<ZultaniteStairsBlock> smallBrickStairsBlock;
    private final BlockEntry<WallBlock> smallBrickWallBlock;
    private final BlockEntry<Block> chiseledBricksBlock;
    private final BlockEntry<Block> smoothBlock;
    private final BlockEntry<SlabBlock> smoothSlabBlock;
    private final BlockEntry<ZultaniteStairsBlock> smoothStairsBlock;
    private final BlockEntry<WallBlock> smoothWallBlock;
    private final BlockEntry<Block> cutBlock;
    private final BlockEntry<SlabBlock> cutSlabBlock;
    private final BlockEntry<ZultaniteStairsBlock> cutStairsBlock;
    private final BlockEntry<WallBlock> cutWallBlock;
    //private final BlockEntry<Block> layeredBlock;

    ZultaniteStoneTypes() {
        String id = name().toLowerCase(Locale.ROOT);
        CreateRegistrate REGISTRATE = CreateGarnished.registrate();


        slimeLikeBlock = REGISTRATE.block("mastic_block", MasticBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN).sound(SoundType.SLIME_BLOCK).noOcclusion().instabreak()).register();

        block = REGISTRATE.block("zultanite", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        slabBlock = REGISTRATE.block("zultanite_slab", SlabBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        stairsBlock = REGISTRATE.block("zultanite_stairs", ZultaniteStairsBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        wallBlock = REGISTRATE.block("zultanite_wall", WallBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();


        polishedBlock = REGISTRATE.block("polished_zultanite", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        polishedSlabBlock = REGISTRATE.block("polished_zultanite_slab", SlabBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        polishedStairsBlock = REGISTRATE.block("polished_zultanite_stairs", ZultaniteStairsBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        polishedWallBlock = REGISTRATE.block("polished_zultanite_wall", WallBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();


        brickBlock = REGISTRATE.block("zultanite_bricks", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        brickSlabBlock = REGISTRATE.block("zultanite_brick_slab", SlabBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        brickStairsBlock = REGISTRATE.block("zultanite_brick_stairs", ZultaniteStairsBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        brickWallBlock = REGISTRATE.block("zultanite_brick_wall", WallBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        smallBrickBlock = REGISTRATE.block("small_zultanite_bricks", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        smallBrickSlabBlock = REGISTRATE.block("small_zultanite_brick_slab", SlabBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        smallBrickStairsBlock = REGISTRATE.block("small_zultanite_brick_stairs", ZultaniteStairsBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        smallBrickWallBlock = REGISTRATE.block("small_zultanite_brick_wall", WallBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        chiseledBricksBlock = REGISTRATE.block("chiseled_zultanite_bricks", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();

        smoothBlock = REGISTRATE.block("smooth_zultanite", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        smoothSlabBlock = REGISTRATE.block("smooth_zultanite_slab", SlabBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        smoothStairsBlock = REGISTRATE.block("smooth_zultanite_stairs", ZultaniteStairsBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        smoothWallBlock = REGISTRATE.block("smooth_zultanite_wall", WallBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();

        cutBlock = REGISTRATE.block("cut_zultanite", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        cutSlabBlock = REGISTRATE.block("cut_zultanite_slab", SlabBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        cutStairsBlock = REGISTRATE.block("cut_zultanite_stairs", ZultaniteStairsBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
        cutWallBlock = REGISTRATE.block("cut_zultanite_wall", WallBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties -> properties.mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)).register();
    }

    ZultaniteStoneTypes(MapColor color) {
        String id = name().toLowerCase(Locale.ROOT);
        CreateRegistrate REGISTRATE = CreateGarnished.registrate();


        slimeLikeBlock = REGISTRATE.block(id + "_mastic_block", MasticBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .properties(properties -> properties.mapColor(color).sound(SoundType.SLIME_BLOCK).noOcclusion().instabreak()).register();

        block = REGISTRATE.block(id + "_zultanite", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(color)).register();
        slabBlock = REGISTRATE.block(id + "_zultanite_slab", SlabBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties -> properties.mapColor(color)).register();
        stairsBlock = REGISTRATE.block(id + "_zultanite_stairs", ZultaniteStairsBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties -> properties.mapColor(color)).register();
        wallBlock = REGISTRATE.block(id + "_zultanite_wall", WallBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties -> properties.mapColor(color)).register();


        polishedBlock = REGISTRATE.block("polished_" + id + "_zultanite", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(color)).register();
        polishedSlabBlock = REGISTRATE.block("polished_" + id + "_zultanite_slab", SlabBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties -> properties.mapColor(color)).register();
        polishedStairsBlock = REGISTRATE.block("polished_" + id + "_zultanite_stairs", ZultaniteStairsBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties -> properties.mapColor(color)).register();
        polishedWallBlock = REGISTRATE.block("polished_" + id + "_zultanite_wall", WallBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties -> properties.mapColor(color)).register();


        brickBlock = REGISTRATE.block(id + "_zultanite_bricks", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(color)).register();
        brickSlabBlock = REGISTRATE.block(id + "_zultanite_brick_slab", SlabBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties -> properties.mapColor(color)).register();
        brickStairsBlock = REGISTRATE.block(id + "_zultanite_brick_stairs", ZultaniteStairsBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties -> properties.mapColor(color)).register();
        brickWallBlock = REGISTRATE.block(id + "_zultanite_brick_wall", WallBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties -> properties.mapColor(color)).register();
        smallBrickBlock = REGISTRATE.block("small_" + id + "_zultanite_bricks", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(color)).register();
        smallBrickSlabBlock = REGISTRATE.block("small_" + id + "_zultanite_brick_slab", SlabBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties -> properties.mapColor(color)).register();
        smallBrickStairsBlock = REGISTRATE.block("small_" + id + "_zultanite_brick_stairs", ZultaniteStairsBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties -> properties.mapColor(color)).register();
        smallBrickWallBlock = REGISTRATE.block("small_" + id + "_zultanite_brick_wall", WallBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties -> properties.mapColor(color)).register();
        chiseledBricksBlock = REGISTRATE.block("chiseled_" + id + "_zultanite_bricks", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(color)).register();

        smoothBlock = REGISTRATE.block("smooth_" + id + "_zultanite", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(color)).register();
        smoothSlabBlock = REGISTRATE.block("smooth_" + id + "_zultanite_slab", SlabBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties -> properties.mapColor(color)).register();
        smoothStairsBlock = REGISTRATE.block("smooth_" + id + "_zultanite_stairs", ZultaniteStairsBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties -> properties.mapColor(color)).register();
        smoothWallBlock = REGISTRATE.block("smooth_" + id + "_zultanite_wall", WallBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties -> properties.mapColor(color)).register();

        cutBlock = REGISTRATE.block("cut_" + id + "_zultanite", Block::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties -> properties.mapColor(color)).register();
        cutSlabBlock = REGISTRATE.block("cut_" + id + "_zultanite_slab", SlabBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties -> properties.mapColor(color)).register();
        cutStairsBlock = REGISTRATE.block("cut_" + id + "_zultanite_stairs", ZultaniteStairsBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties -> properties.mapColor(color)).register();
        cutWallBlock = REGISTRATE.block("cut_" + id + "_zultanite_wall", WallBlock::new)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties -> properties.mapColor(color)).register();
    }

    public BlockEntry<MasticBlock> getSlimeLikeBlock() {
        return slimeLikeBlock;
    }

    public BlockEntry<Block> getBlock() {
        return block;
    }

    public BlockEntry<SlabBlock> getSlabBlock() {
        return slabBlock;
    }

    public BlockEntry<ZultaniteStairsBlock> getStairsBlock() {
        return stairsBlock;
    }

    public BlockEntry<WallBlock> getWallBlock() {
        return wallBlock;
    }

    public BlockEntry<Block> getPolishedBlock() {
        return polishedBlock;
    }

    public BlockEntry<SlabBlock> getPolishedSlabBlock() {
        return polishedSlabBlock;
    }

    public BlockEntry<ZultaniteStairsBlock> getPolishedStairsBlock() {
        return polishedStairsBlock;
    }

    public BlockEntry<WallBlock> getPolishedWallBlock() {
        return polishedWallBlock;
    }

    public BlockEntry<Block> getBrickBlock() {
        return brickBlock;
    }

    public BlockEntry<SlabBlock> getBrickSlabBlock() {
        return brickSlabBlock;
    }

    public BlockEntry<ZultaniteStairsBlock> getBrickStairsBlock() {
        return brickStairsBlock;
    }

    public BlockEntry<WallBlock> getBrickWallBlock() {
        return brickWallBlock;
    }

    public BlockEntry<Block> getChiseledBricksBlock() {
        return chiseledBricksBlock;
    }

    public BlockEntry<Block> getSmoothBlock() {
        return smoothBlock;
    }

    public BlockEntry<SlabBlock> getSmoothSlabBlock() {
        return smoothSlabBlock;
    }

    public BlockEntry<ZultaniteStairsBlock> getSmoothStairsBlock() {
        return smoothStairsBlock;
    }

    public BlockEntry<WallBlock> getSmoothWallBlock() {
        return smoothWallBlock;
    }

    public BlockEntry<Block> getCutBlock() {
        return cutBlock;
    }

    public BlockEntry<SlabBlock> getCutSlabBlock() {
        return cutSlabBlock;
    }

    public BlockEntry<ZultaniteStairsBlock> getCutStairsBlock() {
        return cutStairsBlock;
    }

    public BlockEntry<WallBlock> getCutWallBlock() {
        return cutWallBlock;
    }

    public BlockEntry<Block> getSmallBrickBlock() {
        return smallBrickBlock;
    }

    public BlockEntry<SlabBlock> getSmallBrickSlabBlock() {
        return smallBrickSlabBlock;
    }

    public BlockEntry<ZultaniteStairsBlock> getSmallBrickStairsBlock() {
        return smallBrickStairsBlock;
    }

    public BlockEntry<WallBlock> getSmallBrickWallBlock() {
        return smallBrickWallBlock;
    }

    public static void register() {}
}
