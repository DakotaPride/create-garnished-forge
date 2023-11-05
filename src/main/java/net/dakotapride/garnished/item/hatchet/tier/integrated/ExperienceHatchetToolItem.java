package net.dakotapride.garnished.item.hatchet.tier.integrated;

import net.dakotapride.garnished.GarnishedUtils;
import net.dakotapride.garnished.item.hatchet.IntegratedHatchetToolItem;
import net.dakotapride.garnished.item.hatchet.IntegratedMaterials;

public class ExperienceHatchetToolItem extends IntegratedHatchetToolItem {
    public ExperienceHatchetToolItem(Properties properties) {
        super(GarnishedUtils.stuffAndAdditions(), IntegratedMaterials.EXPERIENCE, 1.0F, -2.5F, properties);
    }
}
