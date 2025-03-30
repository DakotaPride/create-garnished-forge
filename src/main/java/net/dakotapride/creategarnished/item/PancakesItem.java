package net.dakotapride.creategarnished.item;

import net.dakotapride.creategarnished.registry.CreateGarnishedAdvancements;
import net.dakotapride.creategarnished.registry.CreateGarnishedTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.NotNull;

public class PancakesItem extends Item {
    public PancakesItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        if (interactionTarget.getType().is(CreateGarnishedTags.FLAPJACK_ADJACENT_ENTITY) && isFlapjack(interactionTarget)
                && player instanceof ServerPlayer server) {
            CreateGarnishedAdvancements.FLAPJACK.get().trigger(server);
            stack.consume(1, player);
            if (interactionTarget instanceof TamableAnimal animal) {
                if (!animal.isSilent()) {
                    animal.level().playSound(null, animal.getX(), animal.getY(), animal.getZ(), SoundEvents.GENERIC_EAT, animal.getSoundSource(), 1.0F, 1.0F + (animal.getRandom().nextFloat() - animal.getRandom().nextFloat()) * 0.2F);
                }

                if (!animal.level().isClientSide) {
                    if (animal.getRandom().nextInt(10) == 0 && !EventHooks.onAnimalTame(animal, player)) {
                        animal.tame(player);
                        animal.level().broadcastEntityEvent(animal, (byte)7);
                    } else {
                        animal.level().broadcastEntityEvent(animal, (byte)6);
                    }
                }
            }

            return InteractionResult.sidedSuccess(player.level().isClientSide);
        }

        return super.interactLivingEntity(stack, player, interactionTarget, usedHand);
    }

    public static boolean isFlapjack(LivingEntity entity) {
        return entity.hasCustomName() && entity.getName().getString().equalsIgnoreCase("flapjack");
    }
}
