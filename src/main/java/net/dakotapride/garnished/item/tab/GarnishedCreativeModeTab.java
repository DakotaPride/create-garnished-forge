package net.dakotapride.garnished.item.tab;

import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.dakotapride.garnished.registry.GarnishedFluids;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GarnishedCreativeModeTab extends CreativeModeTab {
	public GarnishedCreativeModeTab() {
		super("create.garnished");
	}

	@Override
	public void fillItemList(@NotNull NonNullList<ItemStack> items) {
		items.add(0, GarnishedItems.CRACKED_CASHEW.asStack());
		items.add(1, GarnishedItems.UNGARNISHED_CASHEW.asStack());
		items.add(2, GarnishedItems.CASHEW.asStack());
		items.add(3, GarnishedItems.CINDER_FLOUR_CASHEW.asStack());
		items.add(4, GarnishedItems.MELTED_CINDER_FLOUR_CASHEW.asStack());
		items.add(5, GarnishedItems.SPEED_CINDER_CASHEW.asStack());
		items.add(6, GarnishedItems.SWEETENED_CASHEW.asStack());
		items.add(7, GarnishedItems.CHOCOLATE_GLAZED_CASHEW.asStack());
		items.add(8, GarnishedItems.HONEYED_CASHEW.asStack());

		items.add(9, GarnishedItems.CRACKED_WALNUT.asStack());
		items.add(10, GarnishedItems.UNGARNISHED_WALNUT.asStack());
		items.add(11, GarnishedItems.WALNUT.asStack());
		items.add(12, GarnishedItems.CINDER_FLOUR_WALNUT.asStack());
		items.add(13, GarnishedItems.MELTED_CINDER_FLOUR_WALNUT.asStack());
		items.add(14, GarnishedItems.STRENGTH_CINDER_WALNUT.asStack());
		items.add(15, GarnishedItems.SWEETENED_WALNUT.asStack());
		items.add(16, GarnishedItems.CHOCOLATE_GLAZED_WALNUT.asStack());
		items.add(17, GarnishedItems.HONEYED_WALNUT.asStack());

		items.add(18, GarnishedItems.CRACKED_ALMOND.asStack());
		items.add(19, GarnishedItems.UNGARNISHED_ALMOND.asStack());
		items.add(20, GarnishedItems.ALMOND.asStack());
		items.add(21, GarnishedItems.CINDER_FLOUR_ALMOND.asStack());
		items.add(22, GarnishedItems.MELTED_CINDER_FLOUR_ALMOND.asStack());
		items.add(23, GarnishedItems.HASTE_CINDER_ALMOND.asStack());
		items.add(24, GarnishedItems.SWEETENED_ALMOND.asStack());
		items.add(25, GarnishedItems.CHOCOLATE_GLAZED_ALMOND.asStack());
		items.add(26, GarnishedItems.HONEYED_ALMOND.asStack());

		items.add(27, GarnishedItems.CRACKED_PECAN.asStack());
		items.add(28, GarnishedItems.UNGARNISHED_PECAN.asStack());
		items.add(29, GarnishedItems.PECAN.asStack());
		items.add(30, GarnishedItems.CINDER_FLOUR_PECAN.asStack());
		items.add(31, GarnishedItems.MELTED_CINDER_FLOUR_PECAN.asStack());
		items.add(32, GarnishedItems.RESISTANCE_CINDER_PECAN.asStack());
		items.add(33, GarnishedItems.SWEETENED_PECAN.asStack());
		items.add(34, GarnishedItems.CHOCOLATE_GLAZED_PECAN.asStack());
		items.add(35, GarnishedItems.HONEYED_PECAN.asStack());

		items.add(36, GarnishedItems.CRACKED_PISTACHIO.asStack());
		items.add(37, GarnishedItems.UNGARNISHED_PISTACHIO.asStack());
		items.add(38, GarnishedItems.PISTACHIO.asStack());
		items.add(39, GarnishedItems.CINDER_FLOUR_PISTACHIO.asStack());
		items.add(40, GarnishedItems.MELTED_CINDER_FLOUR_PISTACHIO.asStack());
		items.add(41, GarnishedItems.NIGHT_VISION_CINDER_PISTACHIO.asStack());
		items.add(42, GarnishedItems.SWEETENED_PISTACHIO.asStack());
		items.add(43, GarnishedItems.CHOCOLATE_GLAZED_PISTACHIO.asStack());
		items.add(44, GarnishedItems.HONEYED_PISTACHIO.asStack());

		items.add(45, GarnishedItems.CRACKED_MACADAMIA.asStack());
		items.add(46, GarnishedItems.UNGARNISHED_MACADAMIA.asStack());
		items.add(47, GarnishedItems.MACADAMIA.asStack());
		items.add(48, GarnishedItems.CINDER_FLOUR_MACADAMIA.asStack());
		items.add(49, GarnishedItems.MELTED_CINDER_FLOUR_MACADAMIA.asStack());
		items.add(50, GarnishedItems.FIRE_RESISTANCE_CINDER_MACADAMIA.asStack());
		items.add(51, GarnishedItems.SWEETENED_MACADAMIA.asStack());
		items.add(52, GarnishedItems.CHOCOLATE_GLAZED_MACADAMIA.asStack());
		items.add(53, GarnishedItems.HONEYED_MACADAMIA.asStack());

		items.add(54, GarnishedItems.NUT_MIX.asStack());
		items.add(55, GarnishedItems.SWEETENED_NUT_MIX.asStack());
		items.add(56, GarnishedItems.CHOCHOLATE_GLAZED_NUT_MIX.asStack());
		items.add(57, GarnishedItems.HONEYED_NUT_MIX.asStack());

		items.add(58, GarnishedItems.GARNISHED_MEAL.asStack());

		items.add(59, GarnishedItems.GARNISHED_SWEET_BERRIES.asStack());
		items.add(60, GarnishedItems.HONEYED_SWEET_BERRIES.asStack());

		items.add(61, GarnishedItems.APPLE_CIDER.asStack());
		items.add(62, GarnishedItems.CRYPTIC_APPLE_CIDER.asStack());

		items.add(63, GarnishedItems.GARNISH_COMPOUND.asStack());
		items.add(64, GarnishedBlocks.SOLIDIFIED_GARNISH_BLOCK.asStack());

		items.add(65, GarnishedFluids.GARNISH.getBucket().get().getDefaultInstance());
		items.add(66, GarnishedFluids.APPLE_CIDER.getBucket().get().getDefaultInstance());
	}

	@Override
	public @NotNull ItemStack makeIcon() {
		return new ItemStack(GarnishedItems.NUT_MIX.get());
	}
}
