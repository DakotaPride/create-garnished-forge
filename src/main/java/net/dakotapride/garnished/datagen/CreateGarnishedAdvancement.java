package net.dakotapride.garnished.datagen;

import com.simibubi.create.foundation.advancement.AllTriggers;
import com.simibubi.create.foundation.advancement.SimpleCreateTrigger;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class CreateGarnishedAdvancement {

    static final ResourceLocation BACKGROUND = CreateGarnished.asResource("textures/gui/advancements.png");
    static final String LANG = "advancement." + CreateGarnished.ID + ".";
    static final String SECRET_SUFFIX = "\n\u00A77(Hidden Advancement)";

    private final Advancement.Builder mcBuilder = Advancement.Builder.advancement();
    private SimpleCreateTrigger builtinTrigger;
    private CreateGarnishedAdvancement parent;
    private final CreateGarnishedAdvancement.Builder createBuilder = new CreateGarnishedAdvancement.Builder();

    AdvancementHolder datagenResult;

    private String id;
    private String title;
    private String description;

    public CreateGarnishedAdvancement(String id, UnaryOperator<CreateGarnishedAdvancement.Builder> b) {
        this.id = id;

        b.apply(createBuilder);

        if (!createBuilder.externalTrigger) {
            builtinTrigger = AllTriggers.addSimple(id + "_builtin");
            mcBuilder.addCriterion("0", builtinTrigger.createCriterion(builtinTrigger.instance()));
        }

        if (createBuilder.type == CreateGarnishedAdvancement.TaskType.SECRET)
            description += SECRET_SUFFIX;

        CreateGarnishedAdvancements.ENTRIES.add(this);
    }

    private String titleKey() {
        return LANG + id;
    }

    private String descriptionKey() {
        return titleKey() + ".desc";
    }

    public boolean isAlreadyAwardedTo(Player player) {
        if (!(player instanceof ServerPlayer sp))
            return true;
        AdvancementHolder advancement = sp.getServer()
                .getAdvancements()
                .get(CreateGarnished.asResource(id));
        if (advancement == null)
            return true;
        return sp.getAdvancements()
                .getOrStartProgress(advancement)
                .isDone();
    }

    public void awardTo(Player player) {
        if (!(player instanceof ServerPlayer sp))
            return;
        if (builtinTrigger == null)
            throw new UnsupportedOperationException(
                    "Advancement " + id + " uses external Triggers, it cannot be awarded directly");
        builtinTrigger.trigger(sp);
    }

    void save(Consumer<AdvancementHolder> t, HolderLookup.Provider registries) {
        if (parent != null)
            mcBuilder.parent(parent.datagenResult);

        if (createBuilder.func != null)
            createBuilder.icon(createBuilder.func.apply(registries));

        mcBuilder.display(createBuilder.icon, Component.translatable(titleKey()),
                Component.translatable(descriptionKey()).withStyle(s -> s.withColor(0xDBA213)),
                id.equals("root") ? BACKGROUND : null, createBuilder.type.advancementType, createBuilder.type.toast,
                createBuilder.type.announce, createBuilder.type.hide);

        datagenResult = mcBuilder.save(t, CreateGarnished.asResource(id)
                .toString());
    }

    void provideLang(BiConsumer<String, String> consumer) {
        consumer.accept(titleKey(), title);
        consumer.accept(descriptionKey(), description);
    }

    static enum TaskType {

        SILENT(AdvancementType.TASK, false, false, false),
        NORMAL(AdvancementType.TASK, true, false, false),
        NOISY(AdvancementType.TASK, true, true, false),
        EXPERT(AdvancementType.GOAL, true, true, false),
        SECRET(AdvancementType.GOAL, true, true, true),

        ;

        private final AdvancementType advancementType;
        private final boolean toast;
        private final boolean announce;
        private final boolean hide;

        TaskType(AdvancementType advancementType, boolean toast, boolean announce, boolean hide) {
            this.advancementType = advancementType;
            this.toast = toast;
            this.announce = announce;
            this.hide = hide;
        }
    }

    class Builder {

        private CreateGarnishedAdvancement.TaskType type = CreateGarnishedAdvancement.TaskType.NORMAL;
        private boolean externalTrigger;
        private int keyIndex;
        private ItemStack icon;
        private Function<HolderLookup.Provider, ItemStack> func;

        CreateGarnishedAdvancement.Builder special(CreateGarnishedAdvancement.TaskType type) {
            this.type = type;
            return this;
        }

        CreateGarnishedAdvancement.Builder after(CreateGarnishedAdvancement other) {
            CreateGarnishedAdvancement.this.parent = other;
            return this;
        }

        CreateGarnishedAdvancement.Builder icon(ItemProviderEntry<?, ?> item) {
            return icon(item.asStack());
        }

        CreateGarnishedAdvancement.Builder icon(ItemLike item) {
            return icon(new ItemStack(item));
        }

        CreateGarnishedAdvancement.Builder icon(ItemStack stack) {
            icon = stack;
            return this;
        }

        CreateGarnishedAdvancement.Builder icon(Function<HolderLookup.Provider, ItemStack> func) {
            this.func = func;
            return this;
        }

        CreateGarnishedAdvancement.Builder title(String title) {
            CreateGarnishedAdvancement.this.title = title;
            return this;
        }

        CreateGarnishedAdvancement.Builder description(String description) {
            CreateGarnishedAdvancement.this.description = description;
            return this;
        }

        CreateGarnishedAdvancement.Builder whenBlockPlaced(Block block) {
            return externalTrigger(ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(block));
        }

        CreateGarnishedAdvancement.Builder whenIconCollected() {
            return externalTrigger(InventoryChangeTrigger.TriggerInstance.hasItems(icon.getItem()));
        }

        CreateGarnishedAdvancement.Builder whenItemCollected(ItemProviderEntry<?, ?> item) {
            return whenItemCollected(item.asStack()
                    .getItem());
        }

        CreateGarnishedAdvancement.Builder whenItemCollected(ItemLike itemProvider) {
            return externalTrigger(InventoryChangeTrigger.TriggerInstance.hasItems(itemProvider));
        }

        CreateGarnishedAdvancement.Builder whenItemCollected(TagKey<Item> tag) {
            return externalTrigger(InventoryChangeTrigger.TriggerInstance
                    .hasItems(ItemPredicate.Builder.item().of(tag).build()));
        }

        CreateGarnishedAdvancement.Builder awardedForFree() {
            return externalTrigger(InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[] {}));
        }

        CreateGarnishedAdvancement.Builder externalTrigger(Criterion<?> trigger) {
            mcBuilder.addCriterion(String.valueOf(keyIndex), trigger);
            externalTrigger = true;
            keyIndex++;
            return this;
        }

    }
}
