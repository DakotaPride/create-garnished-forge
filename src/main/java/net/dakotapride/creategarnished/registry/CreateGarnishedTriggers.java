package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.advancement.*;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.KilledTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreateGarnishedTriggers {
    private static final DeferredRegister<CriterionTrigger<?>> CRITERION_TRIGGERS = DeferredRegister.create(BuiltInRegistries.TRIGGER_TYPES, CreateGarnished.ID);

    public static final Supplier<DejojoTheAwsomeTrigger> DEJOJO =
            CRITERION_TRIGGERS.register("the_one_who_started_it_all", DejojoTheAwsomeTrigger::new);
    public static final Supplier<FeedFlapjackToFlapjackTrigger> FLAPJACK =
            CRITERION_TRIGGERS.register("flapjack", FeedFlapjackToFlapjackTrigger::new);
    public static final Supplier<KilledTrigger> KILLED_USING_HATCHET =
            CRITERION_TRIGGERS.register("killed_using_hatchet", KilledTrigger::new);
    public static final Supplier<KilledTrigger> BLOODLUST =
            CRITERION_TRIGGERS.register("1000_hatchet_kills", KilledTrigger::new);
    public static final Supplier<KilledTrigger> MONSTER =
            CRITERION_TRIGGERS.register("monster", KilledTrigger::new);
    public static final Supplier<SquirrelThievingTrigger> SQUIRREL_THIEVING =
            CRITERION_TRIGGERS.register("squirrel_thieving", SquirrelThievingTrigger::new);
    public static final Supplier<SleepInBedWhileHungryTrigger> ATTEMPT_SLEEP_WHILE_HUNGRY =
            CRITERION_TRIGGERS.register("attempt_sleep_while_hungry", SleepInBedWhileHungryTrigger::new);
    public static final Supplier<ElectrocutedTrigger> ELECTROCUTED =
            CRITERION_TRIGGERS.register("electrocuted", ElectrocutedTrigger::new);

    public static void register(IEventBus bus) {
        CRITERION_TRIGGERS.register(bus);
    }
}

