package net.dakotapride.garnished.datagen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simibubi.create.foundation.utility.FilesHelper;
//import com.simibubi.create.infrastructure.data.*;
import com.simibubi.create.infrastructure.data.GeneratedEntriesProvider;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateDataProvider;
import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class CreateGarnishedDatagen {
    public static void gatherData(GatherDataEvent event) {
        addExtraRegistrateData();

        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        //generator.addProvider(event.includeClient(), AllSoundEvents.provider(generator));

        GeneratedEntriesProvider generatedEntriesProvider = new GeneratedEntriesProvider(output, lookupProvider);
        lookupProvider = generatedEntriesProvider.getRegistryProvider();
        generator.addProvider(event.includeServer(), generatedEntriesProvider);

        generator.addProvider(event.includeServer(), new CreateGarnishedAdvancements(output, lookupProvider));

//        generator.addProvider(event.includeServer(), new CreateRecipeSerializerTagsProvider(output, lookupProvider, existingFileHelper));
//        generator.addProvider(event.includeServer(), new CreateContraptionTypeTagsProvider(output, lookupProvider, existingFileHelper));
//        generator.addProvider(event.includeServer(), new CreateMountedItemStorageTypeTagsProvider(output, lookupProvider, existingFileHelper));
//        generator.addProvider(event.includeServer(), new DamageTypeTagGen(output, lookupProvider, existingFileHelper));
//        generator.addProvider(event.includeServer(), new AllAdvancements(output, lookupProvider));
//        generator.addProvider(event.includeServer(), new StandardRecipeGen(output, lookupProvider));
//        generator.addProvider(event.includeServer(), new MechanicalCraftingRecipeGen(output, lookupProvider));
//        generator.addProvider(event.includeServer(), new SequencedAssemblyRecipeGen(output, lookupProvider));
//        generator.addProvider(event.includeServer(), new CreateDatamapProvider(output, lookupProvider));
//        generator.addProvider(event.includeServer(), new VanillaHatOffsetGenerator(output));
//        generator.addProvider(event.includeServer(), new CuriosDataGenerator(output, lookupProvider, existingFileHelper));
//        generator.addProvider(event.includeServer(), new CreateEnchantmentTagsProvider(output, lookupProvider, existingFileHelper));

        if (event.includeServer()) {
            //ProcessingRecipeGen.registerAll(generator, output, lookupProvider);
        }

        event.getGenerator().addProvider(true, CreateGarnished.registrate().setDataProvider(new RegistrateDataProvider(CreateGarnished.registrate(), CreateGarnished.ID, event)));
    }

    private static void addExtraRegistrateData() {
        //CreateRegistrateTags.addGenerators();

        CreateGarnished.registrate().addDataGenerator(ProviderType.LANG, provider -> {
            BiConsumer<String, String> langConsumer = provider::add;

            provideDefaultLang("interface", langConsumer);
            provideDefaultLang("tooltips", langConsumer);
            //AllAdvancements.provideLang(langConsumer);
            //AllSoundEvents.provideLang(langConsumer);
            //AllKeys.provideLang(langConsumer);
        });
    }

    private static void provideDefaultLang(String fileName, BiConsumer<String, String> consumer) {
        String path = "assets/garnished/lang/default/" + fileName + ".json";
        JsonElement jsonElement = FilesHelper.loadJsonResource(path);
        if (jsonElement == null) {
            throw new IllegalStateException(String.format("Could not find default lang file: %s", path));
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().getAsString();
            consumer.accept(key, value);
        }
    }
}
