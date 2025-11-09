package net.dakotapride.creategarnished.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class FromHatchetItem extends Item {
    EntityType<?> type;
    List<EntityType<?>> typeList;
    boolean voltified;

    public FromHatchetItem(EntityType<?> type, boolean voltified, Properties properties) {
        super(properties);
        this.type = type;
        this.voltified = voltified;
    }

    public FromHatchetItem(List<EntityType<?>> typeList, boolean voltified, Properties properties) {
        super(properties);
        this.typeList = typeList;
        this.voltified = voltified;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> text, TooltipFlag tooltipFlag) {
        if (type != null)
            text.add(Component.translatable("creategarnished.text.obtained_from_entity", Component.translatable(type.getDescriptionId()).withColor(0xBD8ACC)).withColor(0x7E5B87));

        if (typeList != null)
            typeList.forEach(t -> {
                text.add(Component.translatable("creategarnished.text.obtained_from_entity", Component.translatable(t.getDescriptionId()).withColor(0xBD8ACC)).withColor(0x7E5B87));
            });

        if (voltified)
            text.add(Component.translatable(""));
    }
}
