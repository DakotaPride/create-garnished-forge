package net.dakotapride.garnished.registry;

import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.simibubi.create.foundation.block.connected.HorizontalCTBehaviour;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.block.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.Locale;

import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;

public enum GarnishedPaletteStoneTypes {
    CARNOTITE(Block::new, SlabBlock::new, CarnotiteStairsBlock::new, WallBlock::new, properties ->
            properties.explosionResistance(6.0F).mapColor(MapColor.COLOR_YELLOW), GarnishedCT.CARNOTITE_HORIZONTAL, GarnishedCT.CARNOTITE_OMNI),
    ABYSSAL_STONE(Blocks.OBSIDIAN, AbyssalStoneBlock::new, AbyssalStoneSlabBlock::new, AbyssalStoneStairsBlock::new, AbyssalStoneWallBlock::new, properties ->
            properties.sound(SoundType.STONE).destroyTime(35.0F).explosionResistance(12.0F).mapColor(MapColor.TERRACOTTA_PURPLE), GarnishedCT.ABYSSAL_STONE_HORIZONTAL, GarnishedCT.ABYSSAL_STONE_OMNI),
    RITUALISTIC_STONE(Block::new, SlabBlock::new, RitualisticStoneStairsBlock::new, WallBlock::new, properties ->
            properties.explosionResistance(6.0F).mapColor(MapColor.COLOR_BROWN), GarnishedCT.RITUALISTIC_STONE_HORIZONTAL, GarnishedCT.RITUALISTIC_STONE_OMNI),
    UNSTABLE_STONE(UnstableStoneBlock::new, UnstableStoneSlabBlock::new, UnstableStoneStairsBlock::new, UnstableStoneWallBlock::new, properties ->
            properties.explosionResistance(6.0F).mapColor(MapColor.COLOR_LIGHT_BLUE), GarnishedCT.UNSTABLE_STONE_HORIZONTAL, GarnishedCT.UNSTABLE_STONE_OMNI),
    // Wyvern Stone
    DRAGON_STONE(DragonStoneBlock::new, DragonStoneSlabBlock::new, DragonStoneStairsBlock::new, DragonStoneWallBlock::new, properties ->
            properties.explosionResistance(12.0F).mapColor(MapColor.WOOL), GarnishedCT.DRAGON_STONE_HORIZONTAL, GarnishedCT.DRAGON_STONE_OMNI),



    ;

    private final BlockEntry<Block> block;
    private final BlockEntry<SlabBlock> slabBlock;
    private final BlockEntry<StairBlock> stairsBlock;
    private final BlockEntry<WallBlock> wallBlock;
    private final BlockEntry<Block> polishedBlock;
    private final BlockEntry<SlabBlock> polishedSlabBlock;
    private final BlockEntry<StairBlock> polishedStairsBlock;
    private final BlockEntry<WallBlock> polishedWallBlock;
    private final BlockEntry<Block> brickBlock;
    private final BlockEntry<SlabBlock> brickSlabBlock;
    private final BlockEntry<StairBlock> brickStairsBlock;
    private final BlockEntry<WallBlock> brickWallBlock;
    private final BlockEntry<Block> smallBrickBlock;
    private final BlockEntry<SlabBlock> smallBrickSlabBlock;
    private final BlockEntry<StairBlock> smallBrickStairsBlock;
    private final BlockEntry<WallBlock> smallBrickWallBlock;
    private final BlockEntry<Block> chiseledBricksBlock;
    private final BlockEntry<Block> smoothBlock;
    private final BlockEntry<SlabBlock> smoothSlabBlock;
    private final BlockEntry<StairBlock> smoothStairsBlock;
    private final BlockEntry<WallBlock> smoothWallBlock;
    private final BlockEntry<Block> cutBlock;
    private final BlockEntry<SlabBlock> cutSlabBlock;
    private final BlockEntry<StairBlock> cutStairsBlock;
    private final BlockEntry<WallBlock> cutWallBlock;

    GarnishedPaletteStoneTypes(Block copyFrom, NonNullFunction<BlockBehaviour.Properties, Block> blockInstance,
                               NonNullFunction<BlockBehaviour.Properties, SlabBlock> slabInstance,
                               NonNullFunction<BlockBehaviour.Properties, StairBlock> stairsInstance,
                               NonNullFunction<BlockBehaviour.Properties, WallBlock> wallInstance,
                               NonNullUnaryOperator<BlockBehaviour.Properties> properties,
                               CTSpriteShiftEntry ct0, CTSpriteShiftEntry ct1) {
        String id = name().toLowerCase(Locale.ROOT);
        CreateRegistrate REGISTRATE = CreateGarnished.registrate();

        block = REGISTRATE.block(id, blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        slabBlock = REGISTRATE.block(id + "_slab", slabInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        stairsBlock = REGISTRATE.block(id + "_stairs", stairsInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        wallBlock = REGISTRATE.block(id + "_wall", wallInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();


        polishedBlock = REGISTRATE.block("polished_" + id, blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        polishedSlabBlock = REGISTRATE.block("polished_" + id + "_slab", slabInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        polishedStairsBlock = REGISTRATE.block("polished_" + id + "_stairs", stairsInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        polishedWallBlock = REGISTRATE.block("polished_" + id + "_wall", wallInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();


        brickBlock = REGISTRATE.block(id + "_bricks", blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        brickSlabBlock = REGISTRATE.block(id + "_brick_slab", slabInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        brickStairsBlock = REGISTRATE.block(id + "_brick_stairs", stairsInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        brickWallBlock = REGISTRATE.block(id + "_brick_wall", wallInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        smallBrickBlock = REGISTRATE.block("small_" + id + "_bricks", blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        smallBrickSlabBlock = REGISTRATE.block("small_" + id + "_brick_slab", slabInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        smallBrickStairsBlock = REGISTRATE.block("small_" + id + "_brick_stairs", stairsInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        smallBrickWallBlock = REGISTRATE.block("small_" + id + "_brick_wall", wallInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        chiseledBricksBlock = REGISTRATE.block("chiseled_" + id + "_bricks", blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();

        smoothBlock = REGISTRATE.block("smooth_" + id, blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        smoothSlabBlock = REGISTRATE.block("smooth_" + id + "_slab", slabInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        smoothStairsBlock = REGISTRATE.block("smooth_" + id + "_stairs", stairsInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        smoothWallBlock = REGISTRATE.block("smooth_" + id + "_wall", wallInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();

        cutBlock = REGISTRATE.block("cut_" + id, blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        cutSlabBlock = REGISTRATE.block("cut_" + id + "_slab", slabInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        cutStairsBlock = REGISTRATE.block("cut_" + id + "_stairs", stairsInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
        cutWallBlock = REGISTRATE.block("cut_" + id + "_wall", wallInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> copyFrom)
                .properties(properties).register();
    }

    GarnishedPaletteStoneTypes(NonNullFunction<BlockBehaviour.Properties, Block> blockInstance,
                               NonNullFunction<BlockBehaviour.Properties, SlabBlock> slabInstance,
                               NonNullFunction<BlockBehaviour.Properties, StairBlock> stairsInstance,
                               NonNullFunction<BlockBehaviour.Properties, WallBlock> wallInstance,
                               NonNullUnaryOperator<BlockBehaviour.Properties> properties,
                               CTSpriteShiftEntry ct0, CTSpriteShiftEntry ct1) {
        String id = name().toLowerCase(Locale.ROOT);
        CreateRegistrate REGISTRATE = CreateGarnished.registrate();


        block = REGISTRATE.block(id, blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties).register();
        slabBlock = REGISTRATE.block(id + "_slab", slabInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties).register();
        stairsBlock = REGISTRATE.block(id + "_stairs", stairsInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties).register();
        wallBlock = REGISTRATE.block(id + "_wall", wallInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties).register();


        polishedBlock = REGISTRATE.block("polished_" + id, blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties).register();
        polishedSlabBlock = REGISTRATE.block("polished_" + id + "_slab", slabInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties).register();
        polishedStairsBlock = REGISTRATE.block("polished_" + id + "_stairs", stairsInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties).register();
        polishedWallBlock = REGISTRATE.block("polished_" + id + "_wall", wallInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties).register();


        brickBlock = REGISTRATE.block(id + "_bricks", blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties).register();
        brickSlabBlock = REGISTRATE.block(id + "_brick_slab", slabInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties).register();
        brickStairsBlock = REGISTRATE.block(id + "_brick_stairs", stairsInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties).register();
        brickWallBlock = REGISTRATE.block(id + "_brick_wall", wallInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties).register();
        smallBrickBlock = REGISTRATE.block("small_" + id + "_bricks", blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties).register();
        smallBrickSlabBlock = REGISTRATE.block("small_" + id + "_brick_slab", slabInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties).register();
        smallBrickStairsBlock = REGISTRATE.block("small_" + id + "_brick_stairs", stairsInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties).register();
        smallBrickWallBlock = REGISTRATE.block("small_" + id + "_brick_wall", wallInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties).register();
        chiseledBricksBlock = REGISTRATE.block("chiseled_" + id + "_bricks", blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties).register();

        smoothBlock = REGISTRATE.block("smooth_" + id, blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties).register();
        smoothSlabBlock = REGISTRATE.block("smooth_" + id + "_slab", slabInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties).register();
        smoothStairsBlock = REGISTRATE.block("smooth_" + id + "_stairs", stairsInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties).register();
        smoothWallBlock = REGISTRATE.block("smooth_" + id + "_wall", wallInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties).register();

        cutBlock = REGISTRATE.block("cut_" + id, blockInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE)
                .properties(properties).register();
        cutSlabBlock = REGISTRATE.block("cut_" + id + "_slab", slabInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_SLAB)
                .properties(properties).register();
        cutStairsBlock = REGISTRATE.block("cut_" + id + "_stairs", stairsInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_STAIRS)
                .properties(properties).register();
        cutWallBlock = REGISTRATE.block("cut_" + id + "_wall", wallInstance)
                //.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
                .simpleItem()
                .initialProperties(() -> Blocks.STONE_BRICK_WALL)
                .properties(properties).register();
    }

    public static BlockEntry<Block> layered(String name, NonNullUnaryOperator<BlockBehaviour.Properties> properties,
                                            ConnectedTextureBehaviour.Base behaviour) {
        return CreateGarnished.registrate().block("layered_" + name, Block::new)
                .onRegister(connectedTextures(() -> behaviour))
                .initialProperties(() -> Blocks.STONE)
                .properties(properties)
                .simpleItem()
                .register();
    }

    public static BlockEntry<Block> layered(String name, NonNullUnaryOperator<BlockBehaviour.Properties> properties,
                                            ConnectedTextureBehaviour.Base behaviour, Block copy) {
        return CreateGarnished.registrate().block("layered_" + name, Block::new)
                .onRegister(connectedTextures(() -> behaviour))
                .initialProperties(() -> copy)
                .properties(properties)
                .simpleItem()
                .register();
    }

    public BlockEntry<Block> getBlock() {
        return block;
    }

    public BlockEntry<SlabBlock> getSlabBlock() {
        return slabBlock;
    }

    public BlockEntry<StairBlock> getStairsBlock() {
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

    public BlockEntry<StairBlock> getPolishedStairsBlock() {
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

    public BlockEntry<StairBlock> getBrickStairsBlock() {
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

    public BlockEntry<StairBlock> getSmoothStairsBlock() {
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

    public BlockEntry<StairBlock> getCutStairsBlock() {
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

    public BlockEntry<StairBlock> getSmallBrickStairsBlock() {
        return smallBrickStairsBlock;
    }

    public BlockEntry<WallBlock> getSmallBrickWallBlock() {
        return smallBrickWallBlock;
    }

    public static void register() {}
}