package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class GarnishedTags {

	public static TagKey<Item> AVERSION_FOODS_TAG = garnishedTag("aversion_foods", ForgeRegistries.ITEMS.getRegistryKey());
	public static TagKey<Item> HATCHETS_TAG = forgeTag("tools/hatchets", ForgeRegistries.ITEMS.getRegistryKey());
	public static final TagKey<Block> MINEABLE_WITH_HATCHET = forgeTag("mineable/hatchet", ForgeRegistries.BLOCKS.getRegistryKey());
	public static final TagKey<EntityType<?>> IS_AFFECTED_BY_SALVAGING = forgeTag("affected_by/salvaging", ForgeRegistries.ENTITIES.getRegistryKey());
	public static final TagKey<EntityType<?>> IS_AFFECTED_BY_RAVAGING = forgeTag("affected_by/ravaging", ForgeRegistries.ENTITIES.getRegistryKey());
	public static final TagKey<Block> CARNOTITE_BLOCKS = garnishedTag("carnotite", ForgeRegistries.BLOCKS.getRegistryKey());
	public static final TagKey<Block> GENERATION_REPLACEABLES = garnishedTag("carnotite", ForgeRegistries.BLOCKS.getRegistryKey());
	public static final TagKey<Item> ENDER_DUSTS_TAG = forgeTag("ender_dusts", ForgeRegistries.ITEMS.getRegistryKey());
	public static final TagKey<Biome> HAS_REMNANT_TAG = garnishedTag("has_remnant", ForgeRegistries.BIOMES.getRegistryKey());

	// Integrated Tags
	public static TagKey<Item> ZINC_INGOTS = forgeTag("ingots/zinc", ForgeRegistries.ITEMS.getRegistryKey());
	public static TagKey<Item> BRASS_INGOTS = forgeTag("ingots/brass", ForgeRegistries.ITEMS.getRegistryKey());
	public static TagKey<Item> COPPER_INGOTS = forgeTag("ingots/copper", ForgeRegistries.ITEMS.getRegistryKey());
	public static TagKey<Item> EXPERIENCE_REPAIRABLE_ITEMS = forgeTag("experience_heaps", ForgeRegistries.ITEMS.getRegistryKey());
	public static TagKey<Item> BLAZING_REPAIRABLE_ITEMS = forgeTag("blazing_repairable_items", ForgeRegistries.ITEMS.getRegistryKey());

	public static TagKey<Item> WARDEN_REPAIRABLE_ITEMS = forgeTag("shards/warden", ForgeRegistries.ITEMS.getRegistryKey());

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
