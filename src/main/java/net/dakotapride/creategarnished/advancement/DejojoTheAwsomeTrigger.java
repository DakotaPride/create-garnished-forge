package net.dakotapride.creategarnished.advancement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class DejojoTheAwsomeTrigger extends SimpleCriterionTrigger<DejojoTheAwsomeTrigger.TriggerInstance> {
    //private static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CreateGarnished.ID, "the_one_who_started_it_all");

    @Override
    public Codec<DejojoTheAwsomeTrigger.TriggerInstance> codec() {
        return DejojoTheAwsomeTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, TriggerInstance::test);
    }

    public static record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance {
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