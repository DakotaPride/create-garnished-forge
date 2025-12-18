package net.dakotapride.creategarnished.advancement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class SquirrelThievingTrigger extends SimpleCriterionTrigger<SquirrelThievingTrigger.TriggerInstance> {

    @Override
    public Codec<SquirrelThievingTrigger.TriggerInstance> codec() {
        return SquirrelThievingTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, TriggerInstance::test);
    }

    public static record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleInstance {
        public static final Codec<TriggerInstance> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
                EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(TriggerInstance::player))
                .apply(instance, TriggerInstance::new));

        public TriggerInstance(Optional<ContextAwarePredicate> player) {
            this.player = player;
        }

        public boolean test() {
            return true;
        }
    }
}