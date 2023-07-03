package net.dakotapride.garnished.item.tab;

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
		items.add(7, GarnishedItems.HONEYED_CASHEW.asStack());

		items.add(8, GarnishedItems.CRACKED_WALNUT.asStack());
		items.add(9, GarnishedItems.UNGARNISHED_WALNUT.asStack());
		items.add(10, GarnishedItems.WALNUT.asStack());
		items.add(11, GarnishedItems.CINDER_FLOUR_WALNUT.asStack());
		items.add(12, GarnishedItems.MELTED_CINDER_FLOUR_WALNUT.asStack());
		items.add(13, GarnishedItems.STRENGTH_CINDER_WALNUT.asStack());
		items.add(14, GarnishedItems.SWEETENED_WALNUT.asStack());
		items.add(15, GarnishedItems.HONEYED_WALNUT.asStack());

		items.add(16, GarnishedItems.CRACKED_ALMOND.asStack());
		items.add(17, GarnishedItems.UNGARNISHED_ALMOND.asStack());
		items.add(18, GarnishedItems.ALMOND.asStack());
		items.add(19, GarnishedItems.CINDER_FLOUR_ALMOND.asStack());
		items.add(20, GarnishedItems.MELTED_CINDER_FLOUR_ALMOND.asStack());
		items.add(21, GarnishedItems.HASTE_CINDER_ALMOND.asStack());
		items.add(22, GarnishedItems.SWEETENED_ALMOND.asStack());
		items.add(23, GarnishedItems.HONEYED_ALMOND.asStack());

		items.add(24, GarnishedItems.CRACKED_PECAN.asStack());
		items.add(25, GarnishedItems.UNGARNISHED_PECAN.asStack());
		items.add(26, GarnishedItems.PECAN.asStack());
		items.add(27, GarnishedItems.CINDER_FLOUR_PECAN.asStack());
		items.add(28, GarnishedItems.MELTED_CINDER_FLOUR_PECAN.asStack());
		items.add(29, GarnishedItems.RESISTANCE_CINDER_PECAN.asStack());
		items.add(30, GarnishedItems.SWEETENED_PECAN.asStack());
		items.add(31, GarnishedItems.HONEYED_PECAN.asStack());

		items.add(32, GarnishedItems.CRACKED_PISTACHIO.asStack());
		items.add(33, GarnishedItems.UNGARNISHED_PISTACHIO.asStack());
		items.add(34, GarnishedItems.PISTACHIO.asStack());
		items.add(35, GarnishedItems.CINDER_FLOUR_PISTACHIO.asStack());
		items.add(36, GarnishedItems.MELTED_CINDER_FLOUR_PISTACHIO.asStack());
		items.add(37, GarnishedItems.NIGHT_VISION_CINDER_PISTACHIO.asStack());
		items.add(38, GarnishedItems.SWEETENED_PISTACHIO.asStack());
		items.add(39, GarnishedItems.HONEYED_PISTACHIO.asStack());

		items.add(40, GarnishedItems.CRACKED_MACADAMIA.asStack());
		items.add(41, GarnishedItems.UNGARNISHED_MACADAMIA.asStack());
		items.add(42, GarnishedItems.MACADAMIA.asStack());
		items.add(43, GarnishedItems.CINDER_FLOUR_MACADAMIA.asStack());
		items.add(44, GarnishedItems.MELTED_CINDER_FLOUR_MACADAMIA.asStack());
		items.add(45, GarnishedItems.FIRE_RESISTANCE_CINDER_MACADAMIA.asStack());
		items.add(46, GarnishedItems.SWEETENED_MACADAMIA.asStack());
		items.add(47, GarnishedItems.HONEYED_MACADAMIA.asStack());

		items.add(48, GarnishedItems.NUT_MIX.asStack());
		items.add(49, GarnishedItems.SWEETENED_NUT_MIX.asStack());
		items.add(50, GarnishedItems.HONEYED_NUT_MIX.asStack());

		items.add(51, GarnishedItems.GARNISHED_SWEET_BERRIES.asStack());
		items.add(52, GarnishedItems.HONEYED_SWEET_BERRIES.asStack());

		items.add(53, GarnishedFluids.GARNISH.getBucket().get().getDefaultInstance());
	}

	@Override
	public @NotNull ItemStack makeIcon() {
		return new ItemStack(GarnishedItems.NUT_MIX.get());
	}
}
