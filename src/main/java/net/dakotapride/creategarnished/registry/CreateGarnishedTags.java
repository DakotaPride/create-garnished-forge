package net.dakotapride.creategarnished.registry;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public class CreateGarnishedTags {
    public static TagKey<Item> PANCAKES = TagKey.create(BuiltInRegistries.ITEM.key(), CreateGarnished.asResource("pancakes"));
    public static TagKey<EntityType<?>> FLAPJACK_ADJACENT_ENTITY = TagKey.create(BuiltInRegistries.ENTITY_TYPE.key(), CreateGarnished.asResource("acceptable_birbs_for_flapjack"));
}
