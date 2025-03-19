package net.dakotapride.garnished.neoforge;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class AddItemModifier extends LootModifier {
    public static final MapCodec<AddItemModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
            LootModifier.codecStart(inst).and(
                    BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(e -> e.item)).apply(inst, AddItemModifier::new));
    private final Item item;

    public AddItemModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        float chance = 0.0F;

        if (item.getDefaultInstance().is(GarnishedItems.RAW_TENEBROUS_MEAT.asItem()))
            chance = 0.5F;
        if (item.getDefaultInstance().is(GarnishedItems.LUSTROUS_PEARL.asItem()))
            chance = 0.0F;
        if (item.getDefaultInstance().is(GarnishedItems.ANTIQUE_SWATHE.asItem()))
            chance = 0.3F;
        if (item.getDefaultInstance().is(GarnishedItems.AMBER_REMNANT.asItem()))
            chance = 0.55F;
        if (item.getDefaultInstance().is(GarnishedItems.BOK_CHOY.asItem()))
            chance = 0.75F;
        if (item.getDefaultInstance().is(GarnishedItems.BOK_CHOY_SEEDS.asItem()))
            chance = 0.25F;
        if (item.getDefaultInstance().is(GarnishedBlocks.PANSOPHICAL_DAISY.asItem()) || item.getDefaultInstance().is(GarnishedBlocks.INCANDESCENT_LILY.asItem()) || item.getDefaultInstance().is(GarnishedBlocks.SORROWFUL_LICHEN.asItem()))
            chance = 0.85F;

        if (context.getRandom().nextFloat() >= chance) {
            generatedLoot.add(new ItemStack(item, (1 + (RandomSource.create()).nextInt(3))));
        }

        return generatedLoot;
    }


    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
