package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.CreateGarnishedBlocks;
import net.minecraft.world.item.ItemNameBlockItem;
import org.jetbrains.annotations.NotNull;

public class ChestnutItem extends ItemNameBlockItem {
    public ChestnutItem(Properties pProperties) {
        super(CreateGarnishedBlocks.CHESTNUT_SAPLING.get(), pProperties);
    }

    @Override
    public @NotNull String getOrCreateDescriptionId() {
        return "item.creategarnished.chestnut";
    }
}
