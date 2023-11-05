package net.dakotapride.garnished.item.hatchet.tier.integrated;

import net.dakotapride.garnished.GarnishedUtils;
import net.dakotapride.garnished.item.hatchet.IntegratedHatchetToolItem;
import net.dakotapride.garnished.item.hatchet.IntegratedMaterials;

public class CopperHatchetToolItem extends IntegratedHatchetToolItem {
    public CopperHatchetToolItem(Properties properties) {
        super(GarnishedUtils.stuffAndAdditions(), IntegratedMaterials.COPPER, 1.0F, -2.5F, properties);
    }
}
