package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.CreateGarnishedBlocks;
import net.minecraft.world.item.ItemNameBlockItem;
import org.jetbrains.annotations.NotNull;

public class GingerRootItem extends ItemNameBlockItem {
    public GingerRootItem(Properties pProperties) {
        super(CreateGarnishedBlocks.GINGER_ROOT_CROP.get(), pProperties);
    }

    @Override
    public @NotNull String getOrCreateDescriptionId() {
        return "item.creategarnished.ginger_root";
    }
}
