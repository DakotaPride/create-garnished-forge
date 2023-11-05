package net.dakotapride.garnished.item.hatchet.tier.integrated;

import net.dakotapride.garnished.GarnishedUtils;
import net.dakotapride.garnished.item.hatchet.IntegratedHatchetToolItem;
import net.dakotapride.garnished.item.hatchet.IntegratedMaterials;

public class RoseQuartzHatchetToolItem extends IntegratedHatchetToolItem {
    public RoseQuartzHatchetToolItem(Properties properties) {
        super(GarnishedUtils.stuffAndAdditions(), IntegratedMaterials.ROSE_QUARTZ, 1.0F, -2.7F, properties);
    }
}
