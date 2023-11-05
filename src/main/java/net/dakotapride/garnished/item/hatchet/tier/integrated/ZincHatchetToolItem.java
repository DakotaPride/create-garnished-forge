package net.dakotapride.garnished.item.hatchet.tier.integrated;

import net.dakotapride.garnished.GarnishedUtils;
import net.dakotapride.garnished.item.hatchet.IntegratedHatchetToolItem;
import net.dakotapride.garnished.item.hatchet.IntegratedMaterials;
import net.minecraft.world.item.Tier;

public class ZincHatchetToolItem extends IntegratedHatchetToolItem {
    public ZincHatchetToolItem(Properties properties) {
        super(GarnishedUtils.stuffAndAdditions(), IntegratedMaterials.ZINC, 0.5F, -2.8F, properties);
    }
}
