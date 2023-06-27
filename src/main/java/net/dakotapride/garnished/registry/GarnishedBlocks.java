package net.dakotapride.garnished.registry;

import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.block.NutCropBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class GarnishedBlocks {
	private static final CreateRegistrate REGISTRATE = CreateGarnished.registrate()
			.creativeModeTab(() -> GarnishedTabs.GARNISHED);

	public static final BlockEntry<NutCropBlock> CASHEW_CROP =
			REGISTRATE.block("cashew_crop", NutCropBlock::new)
					.blockstate((ctx, pov) -> pov.simpleBlock(ctx.get(), AssetLookup.standardModel(ctx, pov)))
					.register();

	public static void setRegister() {}

}
