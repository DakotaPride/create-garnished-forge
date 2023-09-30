package net.dakotapride.garnished.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FarmersDelightItem extends Item {
    public FarmersDelightItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {

        if (!ModList.get().isLoaded("farmersdelight")) {
            components.add(Component.translatable("text.garnished.integration.farmersdelight.missing").withStyle(ChatFormatting.GRAY));
        }

        super.appendHoverText(stack, level, components, flag);

    }
}
