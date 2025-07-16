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

    public FromHatchetItem(EntityType<?> type, Properties properties) {
        super(properties);
        this.type = type;
    }

    public FromHatchetItem(List<EntityType<?>> typeList, Properties properties) {
        super(properties);
        this.typeList = typeList;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> text, TooltipFlag tooltipFlag) {
        if (type != null)
            text.add(Component.translatable("creategarnished.text.obtained_from_entity", Component.translatable(type.getDescriptionId()).withColor(0xBD8ACC)).withColor(0x7E5B87));

        if (typeList != null)
            typeList.forEach(t -> {
                text.add(Component.translatable("creategarnished.text.obtained_from_entity", Component.translatable(t.getDescriptionId()).withColor(0xBD8ACC)).withColor(0x7E5B87));
            });
    }
}
