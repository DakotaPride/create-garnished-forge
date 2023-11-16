package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GarnishedTags {

	public static TagKey<Item> AVERSION_FOODS_TAG = garnishedTag("aversion_foods", Registries.ITEM);
	public static TagKey<Item> HATCHETS_TAG = forgeTag("tools/hatchets", Registries.ITEM);
	public static final TagKey<Block> MINEABLE_WITH_HATCHET = forgeTag("mineable/hatchet", Registries.BLOCK);
	public static final TagKey<EntityType<?>> IS_AFFECTED_BY_SALVAGING = forgeTag("affected_by/salvaging", Registries.ENTITY_TYPE);
	public static final TagKey<EntityType<?>> IS_AFFECTED_BY_RAVAGING = forgeTag("affected_by/ravaging", Registries.ENTITY_TYPE);
	public static final TagKey<Block> CARNOTITE_BLOCKS = garnishedTag("carnotite", Registries.BLOCK);
	public static final TagKey<Item> ENDER_DUSTS_TAG = forgeTag("ender_dusts", Registries.ITEM);

	// Integrated Tags
	public static TagKey<Item> ZINC_INGOTS = forgeTag("ingots/zinc", Registries.ITEM);
	public static TagKey<Item> BRASS_INGOTS = forgeTag("ingots/brass", Registries.ITEM);
	public static TagKey<Item> COPPER_INGOTS = forgeTag("ingots/copper", Registries.ITEM);
	public static TagKey<Item> EXPERIENCE_REPAIRABLE_ITEMS = forgeTag("experience_heaps", Registries.ITEM);
	public static TagKey<Item> BLAZING_REPAIRABLE_ITEMS = forgeTag("blazing_repairable_items", Registries.ITEM);

	public static TagKey<Item> WARDEN_REPAIRABLE_ITEMS = forgeTag("shards/warden", Registries.ITEM);

	// public static TagKey<Item> JADE_GEMS = forgeTag("gems/jade");
	//	public static TagKey<Item> TOPAZ_GEMS = forgeTag("gems/topaz");
	//	public static TagKey<Item> AQUAMARINE_GEMS = forgeTag("gems/aquamarine");
	//	public static TagKey<Item> SAPPHIRE_GEMS = forgeTag("gems/sapphire");
	//	public static TagKey<Item> RUBY_GEMS = forgeTag("gems/ruby");
	//	public static TagKey<Item> AMETRINE_GEMS = forgeTag("gems/ametrine");

	private static <F> TagKey<F> garnishedTag(String name, ResourceKey<Registry<F>> key) {
		return TagKey.create(key, new ResourceLocation(CreateGarnished.ID, name));
	}

	private static <F> TagKey<F> forgeTag(String name, ResourceKey<Registry<F>> key) {
		return TagKey.create(key, new ResourceLocation("forge", name));
	}

	public static void setRegister() {}

}
