package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoodValues;
import net.minecraft.world.item.Item;

public class WeepingTangleFoodItem extends ConditionalEffectItem implements IGarnishedUtilities {
	public WeepingTangleFoodItem(Properties properties) {
		super(5, 0.60F, properties.food(GarnishedFoodValues.WEEPING_TANGLE).stacksTo(16));
	}
}
