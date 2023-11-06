package net.dakotapride.garnished.item.hatchet.tier.integrated;

import net.dakotapride.garnished.GarnishedUtils;
import net.dakotapride.garnished.item.hatchet.IntegratedHatchetToolItem;
import net.dakotapride.garnished.item.hatchet.IntegratedMaterials;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ExperienceHatchetToolItem extends IntegratedHatchetToolItem {
    public ExperienceHatchetToolItem(Properties properties) {
        super(GarnishedUtils.stuffAndAdditions(), IntegratedMaterials.EXPERIENCE, 1.0F, -2.5F, properties);
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull BlockState blockstate, @NotNull BlockPos pos, @NotNull LivingEntity entity) {
        execute(world, pos.getX(), pos.getY(), pos.getZ());
        return super.mineBlock(itemstack, world, blockstate, pos, entity);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        execute(target.level(), target);
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.literal("§8Hold [§fShift§8] for Summary"));
            components.add(Component.literal(" "));
            components.add(Component.literal("§5Use this tool gradually crumbles"));
            components.add(Component.literal("§5it and if you are lucky, the tool"));
            components.add(Component.literal("§5will spawn §dxp orbs"));
        } else {
            components.add(Component.literal("§8Hold [§7Shift§8] for Summary"));
        }

        super.appendHoverText(stack, level, components, tooltipFlag);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(@NotNull ItemStack stack) {
        return true;
    }

    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (Math.random() < 0.1 && world instanceof ServerLevel level) {
            level.addFreshEntity(new ExperienceOrb(level, x + 0.5, y + 0.5, z + 0.5, 1));
        }
    }

    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            if (Math.random() < 0.1 && world instanceof ServerLevel level) {
                level.addFreshEntity(new ExperienceOrb(level, entity.getX(), entity.getY(), entity.getZ(), 1));
            }

        }
    }
}
