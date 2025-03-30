package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vazkii.patchouli.api.PatchouliAPI;

public class GarnishmentBookItem extends Item {
    public GarnishmentBookItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (player instanceof ServerPlayer serverPlayer) {

            PatchouliAPI.get().openBookGUI(serverPlayer, CreateGarnished.asResource("garnishment_book"));

            return InteractionResultHolder.success(itemStack);
        } else return InteractionResultHolder.fail(itemStack);
    }
}
