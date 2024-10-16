package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class VenerableDelicacyFoodItem extends ConditionalEffectItem {
    public VenerableDelicacyFoodItem(Properties properties) {
        super(0, 1.0F, properties.food(GarnishedFoodValues.VENERABLE_DELICACY).stacksTo(16));
    }
}
