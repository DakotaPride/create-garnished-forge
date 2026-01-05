package net.dakotapride.garnished.registry;

import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;
import com.simibubi.create.content.decoration.palettes.WindowBlock;
import com.simibubi.create.foundation.block.connected.*;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.createmod.catnip.render.SpriteShiftEntry;
import net.createmod.catnip.render.SpriteShifter;
import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;


public class GarnishedCT {
    private static final CreateRegistrate REGISTRATE = CreateGarnished.registrate();

    public static void setRegister() {}


    /* Custom Window Gen */


    private static BlockBehaviour.Properties glassProperties(BlockBehaviour.Properties p) {
        return p.isValidSpawn(GarnishedCT::never)
                .isRedstoneConductor(GarnishedCT::never)
                .isSuffocating(GarnishedCT::never)
                .isViewBlocking(GarnishedCT::never);
    }

    private static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }

    private static Boolean never(BlockState state, BlockGetter getter, BlockPos pos,
                                 EntityType<?> entityType) {
        return false;
    }

    public static BlockEntry<WindowBlock> woodenWindowBlock(String name, Supplier<CTSpriteShiftEntry> entry, Supplier<Block> planksBlock) {
        return woodenWindowBlock(name, entry, planksBlock, () -> RenderType::cutout, true);
    }

    public static BlockEntry<WindowBlock> woodenWindowBlock(String name, Supplier<CTSpriteShiftEntry> entry, Supplier<Block> planksBlock,
                                                            Supplier<Supplier<RenderType>> renderType, boolean translucent) {
        return windowBlock(name, entry, renderType,
                translucent, () -> planksBlock.get().defaultMapColor());
    }

    public static BlockEntry<WindowBlock> windowBlock(String name,
                                                      Supplier<CTSpriteShiftEntry> ct, Supplier<Supplier<RenderType>> renderType, boolean translucent,
                                                      Supplier<MapColor> color) {
        return REGISTRATE.block(name + "_window", p -> new WindowBlock(p, translucent))
                .onRegister(connectedTextures(() -> new HorizontalCTBehaviour(ct.get())))
                .addLayer(renderType)
                .initialProperties(() -> Blocks.GLASS)
                .properties(p -> p.mapColor(color.get()).noOcclusion())
                .simpleItem()
                .register();
    }


    public static BlockEntry<ConnectedGlassPaneBlock> woodenWindowPaneBlock(String name, Supplier<CTSpriteShiftEntry> entry, Supplier<? extends Block> windowsBlock) {
        return woodenWindowPaneBlock(name, entry, windowsBlock, () -> RenderType::cutout);
    }

    public static BlockEntry<ConnectedGlassPaneBlock> woodenWindowPaneBlock(String name, Supplier<CTSpriteShiftEntry> entry, Supplier<? extends Block> windowsBlock,
                                                            Supplier<Supplier<RenderType>> renderType) {
        return windowPaneBlock(name, entry, renderType, () -> windowsBlock.get().defaultMapColor());
    }

    public static BlockEntry<ConnectedGlassPaneBlock> windowPaneBlock(String name,
                                                      Supplier<CTSpriteShiftEntry> ct, Supplier<Supplier<RenderType>> renderType,
                                                      Supplier<MapColor> color) {
        return REGISTRATE.block(name + "_window_pane", ConnectedGlassPaneBlock::new)
                .onRegister(connectedTextures(() -> new HorizontalCTBehaviour(ct.get())))
                .addLayer(renderType)
                .initialProperties(() -> Blocks.GLASS_PANE)
                .properties(p -> p.mapColor(color.get()).noOcclusion())
                .simpleItem()
                .register();
    }



    static CTSpriteShiftEntry omni(String name) {
        return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
    }

    static CTSpriteShiftEntry horizontal(String name) {
        return getCT(AllCTTypes.HORIZONTAL, name);
    }

    static CTSpriteShiftEntry horizontalKryppers(String name) {
        return getCT(AllCTTypes.HORIZONTAL_KRYPPERS, name);
    }

    static CTSpriteShiftEntry vertical(String name) {
        return getCT(AllCTTypes.VERTICAL, name);
    }

    public static final CTSpriteShiftEntry NUT_WINDOW = vertical("nut_window");
    public static final CTSpriteShiftEntry SEPIA_WINDOW = vertical("sepia_window");
    public static final CTSpriteShiftEntry NUT_WINDOW_PANE = vertical("nut_window");
    public static final CTSpriteShiftEntry SEPIA_WINDOW_PANE = vertical("sepia_window");
    public static final CTSpriteShiftEntry AMBER_REMNANT_BLOCK = omni("amber_remnant_block");
    public static CTSpriteShiftEntry
            CARNOTITE_HORIZONTAL = horizontalKryppers("layered_carnotite"),
            ABYSSAL_STONE_HORIZONTAL = horizontalKryppers("layered_abyssal_stone"),
            RITUALISTIC_STONE_HORIZONTAL = horizontalKryppers("layered_ritualistic_stone"),
            UNSTABLE_STONE_HORIZONTAL = horizontalKryppers("layered_unstable_stone"),
            DRAGON_STONE_HORIZONTAL = horizontalKryppers("layered_dragon_stone"),

    CARNOTITE_OMNI = omni("layered_carnotite_cap"),
            ABYSSAL_STONE_OMNI = omni("layered_abyssal_stone_cap"),
            RITUALISTIC_STONE_OMNI = omni("layered_ritualistic_stone_cap"),
            UNSTABLE_STONE_OMNI = omni("layered_unstable_stone_cap"),
            DRAGON_STONE_OMNI = omni("layered_dragon_stone_cap");

    private static SpriteShiftEntry get(String originalLocation, String targetLocation) {
        return SpriteShifter.get(CreateGarnished.asResource(originalLocation), CreateGarnished.asResource(targetLocation));
    }

    static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, CreateGarnished.asResource("block/" + blockTextureName),
                CreateGarnished.asResource("block/" + connectedTextureName + "_connected"));
    }

    static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
        return getCT(type, blockTextureName, blockTextureName);
    }

}
