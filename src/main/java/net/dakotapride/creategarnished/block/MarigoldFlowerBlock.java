package net.dakotapride.creategarnished.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MarigoldFlowerBlock extends FlowerBlock {
    public MarigoldFlowerBlock(Properties properties) {
        super(MobEffects.REGENERATION, 100, properties);
    }
}
