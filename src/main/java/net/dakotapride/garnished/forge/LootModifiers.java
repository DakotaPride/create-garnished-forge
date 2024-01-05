package net.dakotapride.garnished.forge;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = CreateGarnished.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LootModifiers {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(
                new AddItemModifier.Serializer().setRegistryName
                        (new ResourceLocation(CreateGarnished.ID, "add_item"))
        );
    }
}
