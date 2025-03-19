package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public class GarnishedEnchantments {
	public static final ResourceKey<Enchantment>
			SALVAGING = key("salvaging"),
			RAVAGING = key("ravaging"),
			STRIKING = key("striking"),
			QUICK_STEP = key("quick_step"),
			REJUVENATE = key("rejuvenate"),
			LEECHING_CURSE = key("leeching_curse");

	private static ResourceKey<Enchantment> key(String name) {
		return ResourceKey.create(Registries.ENCHANTMENT, CreateGarnished.asResource(name));
	}

//	public static final RegistryEntry<SalvagingEnchantment> SALVAGING = CreateGarnished.registrate()
//			.object("salvaging")
//			.enchantment(EnchantmentCategory.DIGGER, SalvagingEnchantment::new)
//			.addSlots(EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND)
//			.rarity(Enchantment.Rarity.UNCOMMON)
//			.register();
//
//	public static final RegistryEntry<RavagingEnchantment> RAVAGING = CreateGarnished.registrate()
//			.object("ravaging")
//			.enchantment(EnchantmentCategory.DIGGER, RavagingEnchantment::new)
//			.addSlots(EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND)
//			.rarity(Enchantment.Rarity.UNCOMMON)
//			.register();
//
//	public static final RegistryEntry<StrikingEnchantment> STRIKING = CreateGarnished.registrate()
//			.object("striking")
//			.enchantment(EnchantmentCategory.WEAPON, StrikingEnchantment::new)
//			.addSlots(EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND)
//			.rarity(Enchantment.Rarity.RARE)
//			.register();
//
//	public static final RegistryEntry<QuickStepEnchantment> QUICK_STEP = CreateGarnished.registrate()
//			.object("quick_step")
//			.enchantment(EnchantmentCategory.WEAPON, QuickStepEnchantment::new)
//			.addSlots(EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND)
//			.rarity(Enchantment.Rarity.VERY_RARE)
//			.register();
//
//	public static final RegistryEntry<RejuvenateEnchantment> REJUVENATE = CreateGarnished.registrate()
//			.object("rejuvenate")
//			.enchantment(EnchantmentCategory.WEAPON, RejuvenateEnchantment::new)
//			.addSlots(EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND)
//			.rarity(Enchantment.Rarity.VERY_RARE)
//			.register();
//
//	public static final RegistryEntry<CurseOfTheLeechEnchantment> LEECHING_CURSE = CreateGarnished.registrate()
//			.object("leeching_curse")
//			.enchantment(EnchantmentCategory.WEAPON, CurseOfTheLeechEnchantment::new)
//			.addSlots(EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND)
//			.rarity(Enchantment.Rarity.VERY_RARE)
//			.register();

	public static void setRegister() {}

}
