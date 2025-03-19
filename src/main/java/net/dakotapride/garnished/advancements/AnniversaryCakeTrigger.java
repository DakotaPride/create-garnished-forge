package net.dakotapride.garnished.advancements;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class AnniversaryCakeTrigger extends SimpleCriterionTrigger<AnniversaryCakeTrigger.TriggerInstance> {
    //private static final ResourceLocation ID = new ResourceLocation(CreateGarnished.ID, "consume_anniversary_cake_slice");

    @Override
    public Codec<AnniversaryCakeTrigger.TriggerInstance> codec() {
        return AnniversaryCakeTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, AnniversaryCakeTrigger.TriggerInstance::test);
    }

    public static record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<AnniversaryCakeTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
                        EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(AnniversaryCakeTrigger.TriggerInstance::player))
                .apply(instance, AnniversaryCakeTrigger.TriggerInstance::new));

        public TriggerInstance(Optional<ContextAwarePredicate> player) {
            this.player = player;
        }

        public boolean test() {
            return true;
        }
    }
}


