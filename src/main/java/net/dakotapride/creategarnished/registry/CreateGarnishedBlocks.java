package net.dakotapride.creategarnished.registry;


import com.tterrag.registrate.util.entry.BlockEntry;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.block.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class CreateGarnishedBlocks {

    static {
        CreateGarnishedStoneTypes.register();
        CreateGarnished.REGISTRATE.setCreativeTab(GarnishedCreativeModeTabs.GARNISHED);
    }

    public static final BlockEntry<MarigoldFlowerBlock> MARIGOLD = CreateGarnished.REGISTRATE.block("marigold", MarigoldFlowerBlock::new)
            .properties(p -> p.noOcclusion().noCollission().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.GRASS))
            .simpleItem()
            .register();

    public static final BlockEntry<WildCropBlock> WILD_GINGER_ROOT = CreateGarnished.REGISTRATE.block("wild_ginger_root", WildCropBlock::new)
            .properties(p -> p.noOcclusion().noCollission().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.GRASS))
            .simpleItem()
            .register();
    public static final BlockEntry<WildCropBlock> WILD_PEANUT = CreateGarnished.REGISTRATE.block("wild_peanuts", WildCropBlock::new)
            .properties(p -> p.noOcclusion().noCollission().mapColor(MapColor.TERRACOTTA_WHITE).sound(SoundType.GRASS))
            .simpleItem()
            .register();

    public static final BlockEntry<GingerRootCropBlock> GINGER_ROOT_CROP = CreateGarnished.REGISTRATE.block("ginger_roots", GingerRootCropBlock::new)
            .properties(p -> p.noCollission().noOcclusion().sound(SoundType.GRASS))
            .register();

    public static final BlockEntry<PeanutCropBlock> PEANUT_CROP = CreateGarnished.REGISTRATE.block("peanuts", PeanutCropBlock::new)
            .properties(p -> p.noCollission().noOcclusion().sound(SoundType.GRASS))
            .register();

    public static final BlockEntry<LeavesBlock> PINE_NUT_LEAVES = CreateGarnished.REGISTRATE.block("pine_nut_leaves", LeavesBlock::new)
            .initialProperties(() -> Blocks.OAK_LEAVES)
            .properties(p -> p.noOcclusion().sound(SoundType.GRASS))
            .simpleItem()
            .register();
    public static final BlockEntry<PineNutSaplingBlock> PINE_NUT_SAPLING = CreateGarnished.REGISTRATE.block("pine_nut_sapling", PineNutSaplingBlock::new)
            .properties(p -> p.noCollission().noOcclusion().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY))
            .register();

    public static final BlockEntry<ElvenSweetBerryBushBlock> ELVEN_SWEET_BERRY_BUSH = CreateGarnished.REGISTRATE.block("elven_sweet_berry_bush", ElvenSweetBerryBushBlock::new)
            .properties(p -> p.noCollission().noOcclusion().sound(SoundType.GRASS).lightLevel(t -> t.getValue(ElvenSweetBerryBushBlock.AGE) * 3))
            .register();

    public static final BlockEntry<HazelnutSaplingBlock> HAZELNUT_SAPLING = CreateGarnished.REGISTRATE.block("hazelnut_sapling", HazelnutSaplingBlock::new)
            .properties(p -> p.noCollission().noOcclusion().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY))
            .register();
    public static final BlockEntry<LeavesBlock> HAZELNUT_LEAVES = CreateGarnished.REGISTRATE.block("hazelnut_leaves", LeavesBlock::new)
            .initialProperties(() -> Blocks.OAK_LEAVES)
            .properties(p -> p.noOcclusion().sound(SoundType.GRASS))
            .simpleItem()
            .register();
    public static final BlockEntry<BirchLogExtractingSapBlock> BIRCH_SAP_LOG = CreateGarnished.REGISTRATE.block("birch_sap_log", BirchLogExtractingSapBlock::new)
            .initialProperties(() -> Blocks.BIRCH_LOG)
            .simpleItem()
            .register();

    public static final BlockEntry<AlmondSaplingBlock> ALMOND_SAPLING = CreateGarnished.REGISTRATE.block("almond_sapling", AlmondSaplingBlock::new)
            .properties(p -> p.noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY))
            .register();
    public static final BlockEntry<LeavesBlock> ALMOND_LEAVES = CreateGarnished.REGISTRATE.block("almond_leaves", LeavesBlock::new)
            .initialProperties(() -> Blocks.OAK_LEAVES)
            .properties(p -> p.noOcclusion().sound(SoundType.GRASS))
            .simpleItem()
            .register();
    public static final BlockEntry<LeavesBlock> BLOSSOMING_ALMOND_LEAVES = CreateGarnished.REGISTRATE.block("blossoming_almond_leaves", LeavesBlock::new)
            .initialProperties(() -> Blocks.OAK_LEAVES)
            .properties(p -> p.noOcclusion().sound(SoundType.GRASS))
            .simpleItem()
            .register();

    public static final BlockEntry<CropBarrelBlock> GINGER_ROOT_BARREL = CreateGarnished.REGISTRATE.block("ginger_root_barrel", CropBarrelBlock::new)
            .simpleItem()
            .initialProperties(() -> Blocks.BARREL).register();
    public static final BlockEntry<CropBarrelBlock> PEANUT_BARREL = CreateGarnished.REGISTRATE.block("peanut_barrel", CropBarrelBlock::new)
            .simpleItem()
            .initialProperties(() -> Blocks.BARREL).register();

    public static final BlockEntry<CropBarrelBlock> PINE_NUT_BARREL = CreateGarnished.REGISTRATE.block("pine_nut_barrel", CropBarrelBlock::new)
            .simpleItem()
            .initialProperties(() -> Blocks.BARREL).register();
    public static final BlockEntry<CropBarrelBlock> SWEET_BERRY_BARREL = CreateGarnished.REGISTRATE.block("sweet_berry_barrel", CropBarrelBlock::new)
            .simpleItem()
            .initialProperties(() -> Blocks.BARREL).register();

    public static final BlockEntry<CropBarrelBlock> ELVEN_SWEET_BERRY_BARREL = CreateGarnished.REGISTRATE.block("elven_sweet_berry_barrel", CropBarrelBlock::new)
            .simpleItem()
            .initialProperties(() -> Blocks.BARREL).register();

    public static final BlockEntry<CropBarrelBlock> HAZELNUT_BARREL = CreateGarnished.REGISTRATE.block("hazelnut_barrel", CropBarrelBlock::new)
            .simpleItem()
            .initialProperties(() -> Blocks.BARREL).register();

    public static final BlockEntry<CropBarrelBlock> ALMOND_BARREL = CreateGarnished.REGISTRATE.block("almond_barrel", CropBarrelBlock::new)
            .simpleItem()
            .initialProperties(() -> Blocks.BARREL).register();


    public static final BlockEntry<PoundCakeBlock> POUND_CAKE = CreateGarnished.REGISTRATE.block("pound_cake", PoundCakeBlock::new)
            .simpleItem()
            .properties(BlockBehaviour.Properties::noOcclusion)
            .initialProperties(() -> Blocks.CAKE).register();


    public static final BlockEntry<WildCropBlock> WILD_GARLIC = CreateGarnished.REGISTRATE.block("wild_garlic", WildCropBlock::new)
            .properties(p -> p.noOcclusion().noCollission().mapColor(MapColor.TERRACOTTA_WHITE).sound(SoundType.GRASS))
            .simpleItem()
            .register();
    public static final BlockEntry<GarlicCropBlock> GARLIC_CROP = CreateGarnished.REGISTRATE.block("garlic", GarlicCropBlock::new)
            .properties(p -> p.noCollission().noOcclusion().sound(SoundType.GRASS))
            .register();

    public static void register() {}

}
