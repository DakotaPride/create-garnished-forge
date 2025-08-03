package net.dakotapride.garnished.registry;

import com.simibubi.create.Create;
import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class GarnishedTags {

	public static TagKey<Item> AVERSION_FOODS_TAG = garnishedTag("aversion_foods", Registries.ITEM);
	public static TagKey<Item> HATCHETS_TAG = commonTag("tools/hatchets", Registries.ITEM);
	public static final TagKey<Block> MINEABLE_WITH_HATCHET = commonTag("mineable/hatchet", Registries.BLOCK);
	public static final TagKey<EntityType<?>> IS_AFFECTED_BY_SALVAGING = commonTag("affected_by/salvaging", Registries.ENTITY_TYPE);
	public static final TagKey<EntityType<?>> IS_AFFECTED_BY_RAVAGING = commonTag("affected_by/ravaging", Registries.ENTITY_TYPE);
	public static final TagKey<Block> CARNOTITE_BLOCKS = garnishedTag("carnotite", Registries.BLOCK);
	public static final TagKey<Item> ENDER_DUSTS_TAG = commonTag("ender_dusts", Registries.ITEM);
	public static final TagKey<Block> FAN_FREEZING_PROCESSING_TAG = garnishedTag("fan_processing_catalysts/freezing", Registries.BLOCK);
	public static final TagKey<Fluid> FAN_FREEZING_PROCESSING_FLUID_TAG = garnishedTag("fan_processing_catalysts/freezing", Registries.FLUID);

	public static final TagKey<Enchantment> FROST_WALKER = commonTag("frost_walker", Registries.ENCHANTMENT);

	public static final TagKey<Enchantment> RAVAGING = garnishedTag("ravaging", Registries.ENCHANTMENT);
	public static final TagKey<Enchantment> SALVAGING = garnishedTag("salvaging", Registries.ENCHANTMENT);
	public static final TagKey<Enchantment> QUICK_STEP = garnishedTag("quick_step", Registries.ENCHANTMENT);
	public static final TagKey<Enchantment> REJUVENATE = garnishedTag("rejuvenate", Registries.ENCHANTMENT);
	public static final TagKey<Enchantment> STRIKING = garnishedTag("striking", Registries.ENCHANTMENT);
	public static final TagKey<Enchantment> LEECH_CURSE = garnishedTag("leech_curse", Registries.ENCHANTMENT);

	// Integrated Tags
	public static TagKey<Item> ZINC_INGOTS = commonTag("ingots/zinc", Registries.ITEM);
	public static TagKey<Item> BRASS_INGOTS = commonTag("ingots/brass", Registries.ITEM);
	public static TagKey<Item> COPPER_INGOTS = commonTag("ingots/copper", Registries.ITEM);
	public static TagKey<Item> EXPERIENCE_REPAIRABLE_ITEMS = commonTag("experience_heaps", Registries.ITEM);
	public static TagKey<Item> BLAZING_REPAIRABLE_ITEMS = commonTag("blazing_repairable_items", Registries.ITEM);

	public static TagKey<Item> WARDEN_REPAIRABLE_ITEMS = commonTag("shards/warden", Registries.ITEM);

	public static TagKey<Item> NETHER_RUBIES = commonTag("rubies/nether", Registries.ITEM);
	public static TagKey<Item> CINCINNASITE = commonTag("cincinnasite", Registries.ITEM);

	public static TagKey<Item> CERTUS_QUARTZ = commonTag("gems/certus_quartz", Registries.ITEM);
	public static TagKey<Item> FLUIX_CRYSTALS = commonTag("gems/fluix", Registries.ITEM);

	public static TagKey<Item> THALLASIUM_INGOTS = commonTag("ingots/thallasium", Registries.ITEM);
	public static TagKey<Item> TERMINITE_INGOTS = commonTag("ingots/terminite", Registries.ITEM);
	public static TagKey<Item> AETERNIUM_INGOTS = commonTag("ingots/aeternium", Registries.ITEM);

	public static final TagKey<Block> MUSHROOM_COLONY_GROWABLE_ON = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("farmersdelight", "mushroom_colony_growable_on"));

	// public static TagKey<Item> JADE_GEMS = forgeTag("gems/jade");
	//	public static TagKey<Item> TOPAZ_GEMS = forgeTag("gems/topaz");
	//	public static TagKey<Item> AQUAMARINE_GEMS = forgeTag("gems/aquamarine");
	//	public static TagKey<Item> SAPPHIRE_GEMS = forgeTag("gems/sapphire");
	//	public static TagKey<Item> RUBY_GEMS = forgeTag("gems/ruby");
	//	public static TagKey<Item> AMETRINE_GEMS = forgeTag("gems/ametrine");

	private static <F> TagKey<F> garnishedTag(String name, ResourceKey<Registry<F>> key) {
		return TagKey.create(key, CreateGarnished.asResource(name));
	}

	private static <F> TagKey<F> commonTag(String name, ResourceKey<Registry<F>> key) {
		return TagKey.create(key, ResourceLocation.fromNamespaceAndPath("c", name));
	}

	private static <F> TagKey<F> createTag(String name, ResourceKey<Registry<F>> key) {
		return TagKey.create(key, ResourceLocation.fromNamespaceAndPath(Create.ID, name));
	}

	public static void setRegister() {}

}
