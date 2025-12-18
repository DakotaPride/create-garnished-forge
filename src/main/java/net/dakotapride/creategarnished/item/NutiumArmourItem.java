package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.CreateGarnishedArmourMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class NutiumArmourItem extends ArmorItem {
    public NutiumArmourItem(Type type, Properties properties) {
        super(CreateGarnishedArmourMaterials.NUTIUM, type, properties);
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable(this.getDescriptionId(stack)).withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xBCAE80)));
    }
}
