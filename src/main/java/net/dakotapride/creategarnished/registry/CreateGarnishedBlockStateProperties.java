package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.block.GingerbreadCookieBlock;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class CreateGarnishedBlockStateProperties {
    public static final IntegerProperty GUMDROPS = IntegerProperty.create("gumdrops", 1, 4);
    public static final EnumProperty<GingerbreadCookieBlock.GingerbreadCookieVariants> GINGERBREAD_COOKIE_VARIANTS = EnumProperty.create("gingerbread_cookie_variant", GingerbreadCookieBlock.GingerbreadCookieVariants.class);
    public static final IntegerProperty COOKIE_COUNT = IntegerProperty.create("cookie_count", 1, 6);
}
