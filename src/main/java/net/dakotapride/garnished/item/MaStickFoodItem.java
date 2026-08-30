package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;

public class MaStickFoodItem extends ConditionalEffectItem implements IGarnishedUtilities {
    public MaStickFoodItem(Properties properties) {
        super(0, 100, properties.food(GarnishedFoodValues.MASTICK).stacksTo(16));
    }
}
