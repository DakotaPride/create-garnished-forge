package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.advancement.DejojoTheAwsomeTrigger;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreateGarnishedAdvancements {
    private static DeferredRegister<CriterionTrigger<?>> CRITERION_TRIGGERS = DeferredRegister.create(BuiltInRegistries.TRIGGER_TYPES, CreateGarnished.ID);

    //public static DejojoTheAwsomeTrigger DEJOJO = new DejojoTheAwsomeTrigger();

    public static final Supplier<DejojoTheAwsomeTrigger> DEJOJO =
            CRITERION_TRIGGERS.register("the_one_who_started_it_all", DejojoTheAwsomeTrigger::new);

    public static void register(IEventBus bus) {
        CRITERION_TRIGGERS.register(bus);
    }
}

