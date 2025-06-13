package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.CreateGarnishedBlocks;
import net.minecraft.world.item.ItemNameBlockItem;
import org.jetbrains.annotations.NotNull;

public class GarlicBulbItem extends ItemNameBlockItem {
    public GarlicBulbItem(Properties pProperties) {
        super(CreateGarnishedBlocks.GARLIC_CROP.get(), pProperties);
    }

    @Override
    public @NotNull String getOrCreateDescriptionId() {
        return "item.creategarnished.garlic";
    }
}
