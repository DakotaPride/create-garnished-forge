package net.dakotapride.creategarnished.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SpikeItem extends SwordItem {
    final EntityType<?> type;
    public SpikeItem(EntityType<?> type, Properties properties) {
        super(Tiers.IRON, properties);
        this.type = type;
    }

    @Override
    public @NotNull Tier getTier() {
        return (type == EntityType.ELDER_GUARDIAN) ? Tiers.DIAMOND : Tiers.IRON;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> text, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, text, tooltipFlag);
        text.add(Component.translatable("creategarnished.text.obtained_from_entity", Component.translatable(type.getDescriptionId()).withColor(0xBD8ACC)).withColor(0x7E5B87));
    }
}
