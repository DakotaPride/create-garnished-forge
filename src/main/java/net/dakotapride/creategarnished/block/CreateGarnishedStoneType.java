package net.dakotapride.creategarnished.block;

import com.simibubi.create.Create;
import com.simibubi.create.content.decoration.palettes.PaletteBlockPattern;
import com.simibubi.create.foundation.block.connected.*;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class CreateGarnishedStoneType {

    private final String id;
    public static BlockBehaviour.Properties defaultBehaviour = BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).destroyTime(0.75f);
    CreateRegistrate REGISTRATE = CreateGarnished.REGISTRATE;

    private final BlockEntry<Block> base;
    private final BlockEntry<Block> cutBase;
    private final BlockEntry<SlabBlock> slab;
    private final BlockEntry<StairBlock> stairs;
    private final BlockEntry<WallBlock> wall;
    private final BlockEntry<Block> brickBase;
    private final BlockEntry<SlabBlock> brickSlab;
    private final BlockEntry<StairBlock> brickStairs;
    private final BlockEntry<WallBlock> brickWall;
    private final BlockEntry<Block> smallBrickBase;
    private final BlockEntry<SlabBlock> smallBrickSlab;
    private final BlockEntry<StairBlock> smallBrickStairs;
    private final BlockEntry<WallBlock> smallBrickWall;
    private final BlockEntry<Block> polishedBase;
    private final BlockEntry<SlabBlock> polishedSlab;
    private final BlockEntry<StairBlock> polishedStairs;
    private final BlockEntry<WallBlock> polishedWall;

    public CreateGarnishedStoneType(String id) {
        this.id = id;

        base = REGISTRATE.block(id, Block::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        cutBase = REGISTRATE.block("cut_" + id, Block::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        slab = REGISTRATE.block("cut_" + id + "_slab", SlabBlock::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        stairs = REGISTRATE.block("cut_" + id + "_stairs", p -> new StairBlock(cutBase.getDefaultState(), p))
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        wall = REGISTRATE.block("cut_" + id + "_wall", WallBlock::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        brickBase = REGISTRATE.block("cut_" + id + "_bricks", Block::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        brickSlab = REGISTRATE.block("cut_" + id + "_brick_slab", SlabBlock::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        brickStairs = REGISTRATE.block("cut_" + id + "_brick_stairs", p -> new StairBlock(brickBase.getDefaultState(), p))
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        brickWall = REGISTRATE.block("cut_" + id + "_brick_wall", WallBlock::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        smallBrickBase = REGISTRATE.block("small_" + id + "_bricks", Block::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        smallBrickSlab = REGISTRATE.block("small_" + id + "_brick_slab", SlabBlock::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        smallBrickStairs = REGISTRATE.block("small_" + id + "_brick_stairs", p -> new StairBlock(smallBrickBase.getDefaultState(), p))
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        smallBrickWall = REGISTRATE.block("small_" + id + "_brick_wall", WallBlock::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        polishedBase = REGISTRATE.block("polished_cut_" + id, Block::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        polishedSlab = REGISTRATE.block("polished_cut_" + id + "_slab", SlabBlock::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        polishedStairs = REGISTRATE.block("polished_cut_" + id + "_stairs", p -> new StairBlock(polishedBase.getDefaultState(), p))
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
        polishedWall = REGISTRATE.block("polished_cut_" + id + "_wall", WallBlock::new)
                .properties(properties1 -> defaultBehaviour)
                .simpleItem()
                .register();
    }

    public static BlockBehaviour.Properties getDefaultBehaviour() {
        return defaultBehaviour;
    }

    public BlockEntry<Block> getBaseStoneBlock() {
        return base;
    }

    public BlockEntry<Block> getCutBlock() {
        return cutBase;
    }

    public BlockEntry<SlabBlock> getSlabBlock() {
        return slab;
    }

    public BlockEntry<StairBlock> getStairsBlock() {
        return stairs;
    }

    public BlockEntry<WallBlock> getWallBlock() {
        return wall;
    }

    public BlockEntry<Block> getBricksBlock() {
        return brickBase;
    }

    public BlockEntry<SlabBlock> getBrickSlabBlock() {
        return brickSlab;
    }

    public BlockEntry<StairBlock> getBrickStairsBlock() {
        return brickStairs;
    }

    public BlockEntry<WallBlock> getBrickWallBlock() {
        return brickWall;
    }

    public BlockEntry<Block> getSmallBricksBlock() {
        return smallBrickBase;
    }

    public BlockEntry<SlabBlock> getSmallBrickSlabBlock() {
        return smallBrickSlab;
    }

    public BlockEntry<StairBlock> getSmallBrickStairsBlock() {
        return smallBrickStairs;
    }

    public BlockEntry<WallBlock> getSmallBrickWallBlock() {
        return smallBrickWall;
    }

    public BlockEntry<Block> getPolishedBlock() {
        return polishedBase;
    }

    public BlockEntry<SlabBlock> getPolishedSlabBlock() {
        return polishedSlab;
    }

    public BlockEntry<StairBlock> getPolishedStairsBlock() {
        return polishedStairs;
    }

    public BlockEntry<WallBlock> getPolishedWallBlock() {
        return polishedWall;
    }

}
