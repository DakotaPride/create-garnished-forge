package net.dakotapride.garnished.item.hatchet.tier.integrated;

import net.dakotapride.garnished.GarnishedUtils;
import net.dakotapride.garnished.item.hatchet.IntegratedHatchetToolItem;
import net.dakotapride.garnished.item.hatchet.IntegratedMaterials;

public class BlazingHatchetToolItem extends IntegratedHatchetToolItem {
    public BlazingHatchetToolItem(Properties properties) {
        super(GarnishedUtils.stuffAndAdditions(), IntegratedMaterials.BLAZING, 0.5F, -2.5F, properties);
    }
}
