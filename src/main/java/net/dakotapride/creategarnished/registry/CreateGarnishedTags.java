package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;

public class CreateGarnishedTags {
    public static TagKey<Item> PANCAKES = TagKey.create(BuiltInRegistries.ITEM.key(), CreateGarnished.asResource("pancakes"));
    public static TagKey<EntityType<?>> FLAPJACK_ADJACENT_ENTITY = TagKey.create(BuiltInRegistries.ENTITY_TYPE.key(), CreateGarnished.asResource("acceptable_birbs_for_flapjack"));

    // Special foods
    public static TagKey<Item> JUNGLE_SPECIAL_FOODS = TagKey.create(BuiltInRegistries.ITEM.key(), CreateGarnished.asResource("special_foods/jungle"));
    public static TagKey<Item> TAIGA_SPECIAL_FOODS = TagKey.create(BuiltInRegistries.ITEM.key(), CreateGarnished.asResource("special_foods/taiga"));
    public static TagKey<Item> FLOWER_FOREST_SPECIAL_FOODS = TagKey.create(BuiltInRegistries.ITEM.key(), CreateGarnished.asResource("special_foods/flower"));
    public static TagKey<Item> BIRCH_FOREST_SPECIAL_FOODS = TagKey.create(BuiltInRegistries.ITEM.key(), CreateGarnished.asResource("special_foods/birch"));

    public static TagKey<Biome> IS_ACCEPTED_FLOWER_BIOME = TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "is_flower_biome"));
    public static TagKey<Biome> IS_BIRCH_FOREST = TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "is_birch_forest"));
}
