package net.dakotapride.creategarnished.item;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MiscNutiumItem extends Item {
    public MiscNutiumItem(Properties properties) {
        super(properties);
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable(this.getDescriptionId(stack)).withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xBCAE80)));
    }
}
