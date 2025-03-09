package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.CreateGarnishedBlocks;
import net.minecraft.world.item.ItemNameBlockItem;
import org.jetbrains.annotations.NotNull;

public class PineNutItem extends ItemNameBlockItem {
    public PineNutItem(Properties pProperties) {
        super(CreateGarnishedBlocks.PINE_NUT_SAPLING.get(), pProperties);
    }

    @Override
    public @NotNull String getOrCreateDescriptionId() {
        return "item.creategarnished.pine_nut";
    }
}
