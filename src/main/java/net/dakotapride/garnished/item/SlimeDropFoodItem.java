package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class SlimeDropFoodItem extends ConditionalEffectItem {
    public SlimeDropFoodItem(Properties properties) {
        super(0, 0.45F, properties.food(GarnishedFoodValues.SLIME_DROP).stacksTo(16));
    }
}
