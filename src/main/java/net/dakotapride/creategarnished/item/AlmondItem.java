package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.CreateGarnishedBlocks;
import net.minecraft.world.item.ItemNameBlockItem;
import org.jetbrains.annotations.NotNull;

public class AlmondItem extends ItemNameBlockItem {
    public AlmondItem(Properties pProperties) {
        super(CreateGarnishedBlocks.ALMOND_SAPLING.get(), pProperties);
    }

    @Override
    public @NotNull String getOrCreateDescriptionId() {
        return "item.creategarnished.almond";
    }
}
