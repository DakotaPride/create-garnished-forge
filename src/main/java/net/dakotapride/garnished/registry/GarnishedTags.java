package net.dakotapride.garnished.registry;

import com.simibubi.create.AllTags;
import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GarnishedTags {

	public static TagKey<Item> AVERSION_FOODS_TAG = itemTag("aversion_foods");
	public static TagKey<Item> HATCHETS_TAG = forgeItemTag("tools/hatchets");
	public static final TagKey<Block> MINEABLE_WITH_HATCHET = forgeBlockTag("mineable/hatchet");
	public static final TagKey<EntityType<?>> IS_AFFECTED_BY_SALVAGING = forgeEntityTypeTag("affected_by/salvaging");
	public static final TagKey<EntityType<?>> IS_AFFECTED_BY_RAVAGING = forgeEntityTypeTag("affected_by/ravaging");

	// Integrated Tags
	public static TagKey<Item> ZINC_INGOTS = forgeItemTag("ingots/zinc");
	public static TagKey<Item> BRASS_INGOTS = forgeItemTag("ingots/brass");
	public static TagKey<Item> COPPER_INGOTS = forgeItemTag("ingots/copper");
	public static TagKey<Item> ROSE_QUARTZ = forgeItemTag("rose_quartz");
	public static TagKey<Item> EXPERIENCE_REPAIRABLE_ITEMS = forgeItemTag("experience_heaps");
	public static TagKey<Item> BLAZING_REPAIRABLE_ITEMS = forgeItemTag("blazing_repairable_items");

	public static TagKey<Item> WARDEN_REPAIRABLE_ITEMS = forgeItemTag("shards/warden");

	// public static TagKey<Item> JADE_GEMS = forgeItemTag("gems/jade");
	//	public static TagKey<Item> TOPAZ_GEMS = forgeItemTag("gems/topaz");
	//	public static TagKey<Item> AQUAMARINE_GEMS = forgeItemTag("gems/aquamarine");
	//	public static TagKey<Item> SAPPHIRE_GEMS = forgeItemTag("gems/sapphire");
	//	public static TagKey<Item> RUBY_GEMS = forgeItemTag("gems/ruby");
	//	public static TagKey<Item> AMETRINE_GEMS = forgeItemTag("gems/ametrine");

	private static TagKey<Item> itemTag(String name) {
		return TagKey.create(Registries.ITEM, new ResourceLocation(CreateGarnished.ID, name));
	}

	private static TagKey<Item> forgeItemTag(String name) {
		return TagKey.create(Registries.ITEM, new ResourceLocation("forge", name));
	}

	private static TagKey<Block> forgeBlockTag(String name) {
		return TagKey.create(Registries.BLOCK, new ResourceLocation("forge", name));
	}

	private static TagKey<EntityType<?>> forgeEntityTypeTag(String name) {
		return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge", name));
	}

	public static void setRegister() {}

}
