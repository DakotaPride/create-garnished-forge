package net.dakotapride.garnished.item.hatchet;

import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings({"deprecation","unused"})
public enum IntegratedMaterials implements Tier {
    ZINC(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 7.0F, 7.0F, 11, () -> {
        return Ingredient.of(GarnishedTags.ZINC_INGOTS);
    }),
    COPPER(BlockTags.INCORRECT_FOR_IRON_TOOL, 131, 5.0F, 5.0F, 11, () -> {
        return Ingredient.of(GarnishedTags.COPPER_INGOTS);
    }),
    BRASS(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 450, 8.0F, 7.0F, 14, () -> {
        return Ingredient.of(GarnishedTags.BRASS_INGOTS);
    }),
    ROSE_QUARTZ(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1644, 9.0F, 7.0F, 14, () -> {
        return Ingredient.of(Items.GOLD_INGOT);
    }),
    EXPERIENCE(BlockTags.INCORRECT_FOR_IRON_TOOL, 270, 7.0F, 5.0F, 800, () -> {
        return Ingredient.of(GarnishedTags.EXPERIENCE_REPAIRABLE_ITEMS);
    }),
    BLAZING(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 450, 12.0F, 6.5F, 2, () -> {
        return Ingredient.of(GarnishedTags.BLAZING_REPAIRABLE_ITEMS);
    }),

    WARDEN(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2519, 10, 5, 18, () -> {
        return Ingredient.of(GarnishedTags.WARDEN_REPAIRABLE_ITEMS);
    }),

    ROSE_GOLD(BlockTags.INCORRECT_FOR_IRON_TOOL, 900, 9.0F, 2.0F, 17, () -> {
        return Ingredient.of(GarnishedTags.COPPER_INGOTS);
    }),
    GILDED_NETHERITE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2031, 10.0F, 2.0F, 20, () -> {
        return Ingredient.of(Items.NETHERITE_INGOT);
    }),
    NETHER_QUARTZ(Tiers.IRON.getIncorrectBlocksForDrops(), Tiers.IRON.getUses(), Tiers.IRON.getSpeed(), Tiers.IRON.getAttackDamageBonus(), Tiers.IRON.getEnchantmentValue(), () -> {
        return Ingredient.of(Items.QUARTZ);
    }),
    CERTUS_QUARTZ(Tiers.IRON.getIncorrectBlocksForDrops(), Tiers.IRON.getUses(), Tiers.IRON.getSpeed(), Tiers.IRON.getAttackDamageBonus(), Tiers.IRON.getEnchantmentValue(), () -> {
        return Ingredient.of(GarnishedTags.CERTUS_QUARTZ);
    }),
    FLUIX(BlockTags.INCORRECT_FOR_IRON_TOOL, Tiers.IRON.getUses() * 3, Tiers.IRON.getSpeed() * 1.2F, Tiers.IRON.getAttackDamageBonus() * 1.2F, Tiers.IRON.getEnchantmentValue(), () -> {
        return Ingredient.of(GarnishedTags.FLUIX_CRYSTALS);
    })

    // SAPPHIRE(Tiers.NETHERITE.getLevel(), 2106, 9.0f, 4.0f, 18, () -> {
    //        return Ingredient.of(GarnishedTags.SAPPHIRE_GEMS);
    //    }),
    //    RUBY(Tiers.NETHERITE.getLevel(), 2106, 12.0f, 4.0f, 18, () -> {
    //        return Ingredient.of(GarnishedTags.RUBY_GEMS);
    //    }),
    //    JADE(Tiers.NETHERITE.getLevel(), 2106, 9.0f, 4.0f, 18, () -> {
    //        return Ingredient.of(GarnishedTags.JADE_GEMS);
    //    }),
    //    TOPAZ(Tiers.NETHERITE.getLevel(), 6318, 10.0f, 4.5f, 18, () -> {
    //        return Ingredient.of(GarnishedTags.TOPAZ_GEMS);
    //    }),
    //    AMETRINE(Tiers.NETHERITE.getLevel(), 2106, 9.0f, 4.0f, 18, () -> {
    //        return Ingredient.of(GarnishedTags.AMETRINE_GEMS);
    //    }),
    //    AQUAMARINE(Tiers.NETHERITE.getLevel(), 2106, 9.0f, 4.0f, 18, () -> {
    //        return Ingredient.of(GarnishedTags.AQUAMARINE_GEMS);
    //    });
    ;

    //private final int level;
    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    IntegratedMaterials(TagKey<Block> incorrectBlocksForDrops, int pUses, float pSpeed, float pDamage, int pEnchantmentValue, Supplier<Ingredient> pRepairIngredient) {
        //this.level = pLevel;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.uses = pUses;
        this.speed = pSpeed;
        this.damage = pDamage;
        this.enchantmentValue = pEnchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

//    public int getLevel() {
//        return this.level;
//    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
