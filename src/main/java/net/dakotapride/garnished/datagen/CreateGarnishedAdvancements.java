package net.dakotapride.garnished.datagen;

import com.google.common.collect.Sets;
import com.simibubi.create.AllItems;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import static net.dakotapride.garnished.datagen.CreateGarnishedAdvancement.TaskType.SILENT;

public class CreateGarnishedAdvancements implements DataProvider {

    public static final List<CreateGarnishedAdvancement> ENTRIES = new ArrayList<>();
    public static final CreateGarnishedAdvancement START = null,

    /*
     * Some ids have trailing 0's to modify their vertical position on the tree
     * (Advancement ordering seems to be deterministic but hash based)
     */

    ROOT = create("nut_tree", b -> b.icon(GarnishedItems.UNGARNISHED_WALNUT)
            .title("Vast Wilderness")
            .description("Obtain Ungarnished Nuts by exploring the world")
            //.awardedForFree()
            .special(SILENT));

    private static CreateGarnishedAdvancement create(String id, UnaryOperator<CreateGarnishedAdvancement.Builder> b) {
        return new CreateGarnishedAdvancement(id, b);
    }

    // Datagen

    private final PackOutput output;
    private final CompletableFuture<HolderLookup.Provider> registries;

    public CreateGarnishedAdvancements(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        this.output = output;
        this.registries = registries;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        return this.registries.thenCompose(provider -> {
            PackOutput.PathProvider pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "advancement");
            List<CompletableFuture<?>> futures = new ArrayList<>();

            Set<ResourceLocation> set = Sets.newHashSet();
            Consumer<AdvancementHolder> consumer = (advancement) -> {
                ResourceLocation id = advancement.id();
                if (!set.add(id))
                    throw new IllegalStateException("Duplicate advancement " + id);
                Path path = pathProvider.json(id);
                LOGGER.info("Saving advancement {}", id);
                futures.add(DataProvider.saveStable(cache, provider, Advancement.CODEC, advancement.value(), path));
            };

            for (CreateGarnishedAdvancement advancement : ENTRIES)
                advancement.save(consumer, provider);

            return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
        });
    }

    @Override
    public String getName() {
        return "Create: Garnished's Advancements";
    }

    public static void provideLang(BiConsumer<String, String> consumer) {
        for (CreateGarnishedAdvancement advancement : ENTRIES)
            advancement.provideLang(consumer);
    }

    public static void register() {
    }
}
