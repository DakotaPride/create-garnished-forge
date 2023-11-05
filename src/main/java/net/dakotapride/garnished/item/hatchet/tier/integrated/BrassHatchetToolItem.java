package net.dakotapride.garnished.item.hatchet.tier.integrated;

import net.dakotapride.garnished.GarnishedUtils;
import net.dakotapride.garnished.item.hatchet.IntegratedHatchetToolItem;
import net.dakotapride.garnished.item.hatchet.IntegratedMaterials;

public class BrassHatchetToolItem extends IntegratedHatchetToolItem {
    public BrassHatchetToolItem(Properties properties) {
        super(GarnishedUtils.stuffAndAdditions(), IntegratedMaterials.BRASS, 1.0F, -2.5F, properties);
    }
}
