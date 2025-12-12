package net.dakotapride.garnished.advancements;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class BasicTrigger extends SimpleCriterionTrigger<BasicTrigger.TriggerInstance> {
    @Override
    public Codec<BasicTrigger.TriggerInstance> codec() {
        return BasicTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, BasicTrigger.TriggerInstance::test);
    }

    public static record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleInstance {
        public static final Codec<BasicTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
                        EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(BasicTrigger.TriggerInstance::player))
                .apply(instance, BasicTrigger.TriggerInstance::new));

        public TriggerInstance(Optional<ContextAwarePredicate> player) {
            this.player = player;
        }

        public boolean test() {
            return true;
        }
    }
}


