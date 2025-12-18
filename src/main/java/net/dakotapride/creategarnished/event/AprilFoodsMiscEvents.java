package net.dakotapride.creategarnished.event;

import net.dakotapride.creategarnished.registry.CreateGarnishedTriggers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.CanPlayerSleepEvent;

@EventBusSubscriber
public class AprilFoodsMiscEvents {
    @SubscribeEvent
    private static void canSleepInBed(CanPlayerSleepEvent event) {
        Player player = event.getEntity();

        if (player.getFoodData().needsFood()) {
            player.displayClientMessage(Component.translatable("creategarnished.text.april_foods.cannot_sleep_while_hungry").withStyle(ChatFormatting.LIGHT_PURPLE), true);
            event.setProblem(Player.BedSleepingProblem.OTHER_PROBLEM);
            if (player instanceof ServerPlayer server)
                CreateGarnishedTriggers.ATTEMPT_SLEEP_WHILE_HUNGRY.get().trigger(server);
        }
    }
}
