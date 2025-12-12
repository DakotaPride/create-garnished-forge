package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.advancements.BasicTrigger;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class GarnishedAdvancementUtils {
    //public static AnniversaryCakeTrigger CONSUME_ANNIVERSARY_CAKE_SLICE = new AnniversaryCakeTrigger();
    //public static DejojoTheAwsomeTrigger DEJOJO = new DejojoTheAwsomeTrigger();

//    public static void register() {
//        CriteriaTriggers.register(CONSUME_ANNIVERSARY_CAKE_SLICE);
//        CriteriaTriggers.register(DEJOJO);
//    }



    private static final DeferredRegister<CriterionTrigger<?>> CRITERION_TRIGGERS = DeferredRegister.create(BuiltInRegistries.TRIGGER_TYPES, CreateGarnished.ID);

    //public static DejojoTheAwsomeTrigger DEJOJO = new DejojoTheAwsomeTrigger();

    public static final Supplier<BasicTrigger> DEJOJO =
            CRITERION_TRIGGERS.register("the_one_who_started_it_all", BasicTrigger::new);
    public static final Supplier<BasicTrigger> CONSUME_ANNIVERSARY_CAKE_SLICE =
            CRITERION_TRIGGERS.register("consume_anniversary_cake_slice", BasicTrigger::new);
    public static final Supplier<BasicTrigger> WYVERN_EFFECTS =
            CRITERION_TRIGGERS.register("wyvern_effects", BasicTrigger::new);

    public static void register(IEventBus bus) {
        CRITERION_TRIGGERS.register(bus);
    }
}
