package net.dakotapride.garnished.item;

import net.dakotapride.garnished.registry.GarnishedFoods;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TntBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IncendiaryStewFoodItem extends Item implements IGarnishedItem {
	public IncendiaryStewFoodItem(Properties properties) {
		super(properties.food(GarnishedFoods.INDENDCIARY_STEW).stacksTo(1));
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> tooltip, @NotNull TooltipFlag adv) {
		tooltip.add(Component.translatable("text.garnished.incendiary_stew.desc").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, Level level, @NotNull LivingEntity entity) {
		if (!level.isClientSide) {
			PrimedTnt primedtnt = new PrimedTnt(level, (double)entity.blockPosition().getX() + 0.5D, (double)entity.blockPosition().getY(), (double)entity.blockPosition().getZ() + 0.5D, entity);
			int i = primedtnt.getFuse();
			primedtnt.setFuse((short)(level.random.nextInt(i / 4) + i / 8));
			level.addFreshEntity(primedtnt);
		}

		if (entity instanceof Player player) {
			player.getCooldowns().addCooldown(stack.getItem(), 30);
		}

		return super.finishUsingItem(stack, level, entity);
	}
}
