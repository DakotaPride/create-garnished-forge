package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.advancement.DejojoTheAwsomeTrigger;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraftforge.eventbus.api.IEventBus;

public class CreateGarnishedAdvancements {
    //private static DeferredRegister<CriterionTrigger<?>> CRITERION_TRIGGERS = DeferredRegister.create(BuiltInRegistries.TRIGG, CreateGarnished.ID);

    //public static DejojoTheAwsomeTrigger DEJOJO = new DejojoTheAwsomeTrigger();

    public static final DejojoTheAwsomeTrigger DEJOJO = new DejojoTheAwsomeTrigger();
            //CRITERION_TRIGGERS.register("the_one_who_started_it_all", DejojoTheAwsomeTrigger::new);

    public static void register(IEventBus bus) {
        //CRITERION_TRIGGERS.register(bus);
        CriteriaTriggers.register(DEJOJO);
    }
}

