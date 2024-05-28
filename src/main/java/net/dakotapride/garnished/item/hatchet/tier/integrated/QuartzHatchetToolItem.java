package net.dakotapride.garnished.item.hatchet.tier.integrated;

import net.dakotapride.garnished.GarnishedUtils;
import net.dakotapride.garnished.item.hatchet.IntegratedHatchetToolItem;
import net.dakotapride.garnished.item.hatchet.IntegratedMaterials;
import net.dakotapride.garnished.registry.GarnishedEnchantments;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class QuartzHatchetToolItem extends IntegratedHatchetToolItem {
    public QuartzHatchetToolItem(Properties properties) {
        super(GarnishedUtils.ae2(), IntegratedMaterials.NETHER_QUARTZ, 6.0F, -3.1F, properties);
    }

    public static class CertusQuartzHatchetToolItem extends IntegratedHatchetToolItem {
        public CertusQuartzHatchetToolItem(Properties properties) {
            super(GarnishedUtils.ae2(), IntegratedMaterials.CERTUS_QUARTZ, 6.0F, -3.1F, properties);
        }
    }

}
