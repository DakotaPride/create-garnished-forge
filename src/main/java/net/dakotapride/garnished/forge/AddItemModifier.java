package net.dakotapride.garnished.forge;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.dakotapride.garnished.registry.GarnishedBlocks;
import net.dakotapride.garnished.registry.GarnishedItems;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {
    public static final Supplier<Codec<AddItemModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ForgeRegistries.ITEMS.getCodec()
            .fieldOf("item").forGetter(m -> m.item)).apply(inst, AddItemModifier::new)));
    private final Item item;

    protected AddItemModifier(LootItemCondition[] conditionsIn, Item item) {
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
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
