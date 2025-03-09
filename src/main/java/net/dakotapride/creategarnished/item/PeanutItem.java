package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.CreateGarnishedBlocks;
import net.minecraft.world.item.ItemNameBlockItem;
import org.jetbrains.annotations.NotNull;

public class PeanutItem extends ItemNameBlockItem {
    public PeanutItem(Properties pProperties) {
        super(CreateGarnishedBlocks.PEANUT_CROP.get(), pProperties);
    }

    @Override
    public @NotNull String getOrCreateDescriptionId() {
        return "item.creategarnished.peanut";
    }
}
