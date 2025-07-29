package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.material.Fluid;

public class CreateGarnishedTags {
    //public static TagKey<Item> PANCAKES = TagKey.create(BuiltInRegistries.ITEM.key(), CreateGarnished.asResource("pancakes"));
    public static TagKey<Item> CAUSES_NUT_ALLERGY_CONSEQUENCES = TagKey.create(BuiltInRegistries.ITEM.key(), CreateGarnished.asResource("causes_nut_allergy_consequences"));
    public static TagKey<EntityType<?>> FLAPJACK_ADJACENT_ENTITY = TagKey.create(BuiltInRegistries.ENTITY_TYPE.key(), CreateGarnished.asResource("acceptable_birbs_for_flapjack"));
    //public static TagKey<EntityType<?>> GELATINOUS_CREATURES = TagKey.create(BuiltInRegistries.ENTITY_TYPE.key(), ResourceLocation.fromNamespaceAndPath("c", "gelatinous_creatures"));
    //public static TagKey<EntityType<?>> GUARDIANS = TagKey.create(BuiltInRegistries.ENTITY_TYPE.key(), ResourceLocation.fromNamespaceAndPath("c", "guardians"));
    public static TagKey<Fluid> APPLIES_NUT_ALLERGY = TagKey.create(BuiltInRegistries.FLUID.key(), CreateGarnished.asResource("applies_nut_allergy"));
    public static TagKey<Item> HATCHETS = TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath("c", "tools/hatchets"));

    // Special foods
    public static TagKey<Item> JUNGLE_SPECIAL_FOODS = TagKey.create(BuiltInRegistries.ITEM.key(), CreateGarnished.asResource("special_foods/jungle"));
    public static TagKey<Item> TAIGA_SPECIAL_FOODS = TagKey.create(BuiltInRegistries.ITEM.key(), CreateGarnished.asResource("special_foods/taiga"));
    public static TagKey<Item> FLOWER_FOREST_SPECIAL_FOODS = TagKey.create(BuiltInRegistries.ITEM.key(), CreateGarnished.asResource("special_foods/flower"));
    public static TagKey<Item> BIRCH_FOREST_SPECIAL_FOODS = TagKey.create(BuiltInRegistries.ITEM.key(), CreateGarnished.asResource("special_foods/birch"));

    public static TagKey<Biome> IS_ACCEPTED_FLOWER_BIOME = TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "is_flower_biome"));
}
