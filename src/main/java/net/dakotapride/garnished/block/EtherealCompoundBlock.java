package net.dakotapride.garnished.block;

import net.dakotapride.garnished.registry.GarnishedEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockState;

public class EtherealCompoundBlock extends SlimeBlock {
    public EtherealCompoundBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof Player player) {
            player.displayClientMessage(Component.translatable("text.garnished.april_foods.ethereal_compound_bounce")
                    .withStyle(ChatFormatting.LIGHT_PURPLE), true);
            player.addEffect(new MobEffectInstance(GarnishedEffects.YEETED, 60 * 20, 0, false, true, false));
        }

        super.stepOn(level, pos, state, entity);
    }
}
