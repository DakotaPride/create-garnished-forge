package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.block.GingerbreadCookieBlock;
import net.dakotapride.creategarnished.registry.CreateGarnishedBlockStateProperties;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GingerbreadCookieItem extends BlockItem {
    String id;
    GingerbreadCookieBlock.GingerbreadCookieVariants variant;

    public GingerbreadCookieItem(String id, GingerbreadCookieBlock.GingerbreadCookieVariants variant, GingerbreadCookieBlock block, Properties properties) {
        super(block, properties);
        this.id = id;
        this.variant = variant;
        //block.defaultBlockState().setValue(CreateGarnishedBlockStateProperties.GINGERBREAD_COOKIE_VARIANTS, variant);
    }

    public GingerbreadCookieBlock.GingerbreadCookieVariants getVariant() {
        return variant;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (variant != GingerbreadCookieBlock.GingerbreadCookieVariants.NONE)
            tooltipComponents.add(Component.translatable("creategarnished.text.gingerbread_cookie_variant." + id).withStyle(ChatFormatting.GRAY));
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable("item.creategarnished.gingerbread_cookie");
    }
}
