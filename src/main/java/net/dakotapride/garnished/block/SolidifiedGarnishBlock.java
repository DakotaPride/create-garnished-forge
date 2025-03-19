package net.dakotapride.garnished.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;

public class SolidifiedGarnishBlock extends FallingBlock {
	public static final MapCodec<SolidifiedGarnishBlock> CODEC = simpleCodec(SolidifiedGarnishBlock::new);
	public SolidifiedGarnishBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected MapCodec<? extends FallingBlock> codec() {
		return CODEC;
	}
}
