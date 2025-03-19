package net.dakotapride.garnished.item.hatchet.tier.integrated;

import net.dakotapride.garnished.GarnishedUtils;
import net.dakotapride.garnished.item.hatchet.IntegratedHatchetToolItem;
import net.dakotapride.garnished.item.hatchet.IntegratedMaterials;

public class GildedNetheriteHatchetToolItem extends IntegratedHatchetToolItem {
    public GildedNetheriteHatchetToolItem(Properties properties) {
        super(GarnishedUtils.additionalAdditions(), IntegratedMaterials.GILDED_NETHERITE, properties.fireResistant());
    }
}