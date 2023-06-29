package net.dakotapride.garnished.item.tab;

import net.dakotapride.garnished.registry.GarnishedItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GarnishedCreativeModeTab extends CreativeModeTab {
	public GarnishedCreativeModeTab() {
		super("create.garnished");
	}

	@Override
	public @NotNull ItemStack makeIcon() {
		return new ItemStack(GarnishedItems.GARNISHMENT_TEMPLATE.get());
	}
}
