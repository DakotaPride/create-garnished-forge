package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.CreateGarnishedBlocks;
import net.minecraft.world.item.ItemNameBlockItem;
import org.jetbrains.annotations.NotNull;

public class HazelnutItem extends ItemNameBlockItem {
    public HazelnutItem(Properties pProperties) {
        super(CreateGarnishedBlocks.HAZELNUT_SAPLING.get(), pProperties);
    }

    @Override
    public @NotNull String getOrCreateDescriptionId() {
        return "item.creategarnished.hazelnut";
    }
}
