package net.dakotapride.creategarnished.registry;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.simibubi.create.foundation.item.ItemDescription;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.item.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;

public class CreateGarnishedItems {

    static {
        CreateGarnished.REGISTRATE.setCreativeTab(CreateGarnishedCreativeModeTabs.GARNISHED);
    }

    public static final ItemEntry<GarnishmentBookItem> GARNISHMENT_BOOK = CreateGarnished.REGISTRATE.item("garnishment_book", GarnishmentBookItem::new)
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.garnishment_book"))
            .register();

    public static final ItemEntry<GingerRootItem> GINGER_ROOT = CreateGarnished.REGISTRATE.item("ginger_root", GingerRootItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.6F).build()))
            .register();
    public static final ItemEntry<PeanutItem> PEANUT = CreateGarnished.REGISTRATE.item("peanut", PeanutItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.6F).build()))
            .register();
    public static final ItemEntry<Item> PEANUT_BUTTER_BOTTLE = CreateGarnished.REGISTRATE.item("peanut_butter_bottle", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.6F).usingConvertsTo(Items.GLASS_BOTTLE).build()))
            .register();
    public static final ItemEntry<Item> PEANUT_BUTTER_COOKIE = CreateGarnished.REGISTRATE.item("peanut_butter_cookie", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.8F).build()))
            .register();
    public static final ItemEntry<SprintersTeaItem> SPRINTERS_TEA = CreateGarnished.REGISTRATE.item("sprinters_tea", SprintersTeaItem::new)
            .properties(p -> p.stacksTo(16))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.sprinters_tea"))
            .register();


    public static final ItemEntry<ElvenSweetberriesItem> ELVEN_SWEET_BERRIES = CreateGarnished.REGISTRATE.item("elven_sweet_berries", ElvenSweetberriesItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.4F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1.0F).build()))
            .register();
    public static final ItemEntry<ElvenTeaItem> ELVEN_TEA = CreateGarnished.REGISTRATE.item("elven_tea", ElvenTeaItem::new)
            .properties(p -> p.stacksTo(16))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.elven_tea"))
            .register();


    public static final ItemEntry<PineNutItem> PINE_NUT = CreateGarnished.REGISTRATE.item("pine_nut", PineNutItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.6F).build()))
            .register();
    public static final ItemEntry<Item> PINE_NUT_FLOUR = CreateGarnished.REGISTRATE.item("pine_nut_flour", Item::new).register();
    public static final ItemEntry<Item> VEGETABLE_STEW = CreateGarnished.REGISTRATE.item("vegetable_stew", Item::new)
            .properties(p -> p.stacksTo(1).food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F).usingConvertsTo(Items.BOWL)
                    .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 600, 1), 1.0F).build()))
            .register();
    public static final ItemEntry<SweetTeaItem> SWEET_TEA = CreateGarnished.REGISTRATE.item("sweet_tea", SweetTeaItem::new)
            .properties(p -> p.stacksTo(16))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.sweet_tea"))
            .register();


    public static final ItemEntry<HazelnutItem> HAZELNUT = CreateGarnished.REGISTRATE.item("hazelnut", HazelnutItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.6F).build()))
            .register();
    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_CHOCOLATE_TRUFFLE = CreateGarnished.REGISTRATE.item("incomplete_chocolate_truffle", SequencedAssemblyItem::new).register();
    public static final ItemEntry<Item> CHOCOLATE_TRUFFLE = CreateGarnished.REGISTRATE.item("chocolate_truffle", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.4F).build()))
            .register();
    public static final ItemEntry<Item> PRALINE = CreateGarnished.REGISTRATE.item("praline", Item::new)
            .properties(p -> p.stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 1), 1.0F).build()))
            .register();
    public static final ItemEntry<Item> BIRCH_SAP_BOTTLE = CreateGarnished.REGISTRATE.item("birch_sap_bottle", Item::new).register();
    public static final ItemEntry<Item> BIRCH_SYRUP_BOTTLE = CreateGarnished.REGISTRATE.item("birch_syrup_bottle", Item::new).register();

    public static final ItemEntry<AlmondItem> ALMOND = CreateGarnished.REGISTRATE.item("almond", AlmondItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.6F).build()))
            .register();
    public static final ItemEntry<Item> ALMOND_PASTE = CreateGarnished.REGISTRATE.item("almond_paste", Item::new).register();
    public static final ItemEntry<Item> BEAR_CLAW = CreateGarnished.REGISTRATE.item("bear_claw", Item::new)
            .properties(p -> p.stacksTo(16).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 2), 1.0F).build()))
            .register();
    public static final ItemEntry<Item> BEETROOT_JUICE_BOTTLE = CreateGarnished.REGISTRATE.item("beetroot_juice_bottle", Item::new).register();
    public static final ItemEntry<Item> CHURCHKHELA = CreateGarnished.REGISTRATE.item("churchkhela", Item::new)
            .properties(p -> p.stacksTo(16).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build()))
            .register();


    public static final ItemEntry<PancakesItem> PANCAKES = CreateGarnished.REGISTRATE.item("pancakes", PancakesItem::new)
            .properties(p -> p.stacksTo(16).food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.8F).build()))
            .register();
    public static final ItemEntry<PancakesItem> SYRUP_COVERED_PANCAKES = CreateGarnished.REGISTRATE.item("syrup_covered_pancakes", PancakesItem::new)
            .properties(p -> p.stacksTo(16).food(new FoodProperties.Builder()
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 1), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 400, 1), 0.5F)
                    .nutrition(8).saturationModifier(0.8F).build()))
            .register();
    public static final ItemEntry<Item> CREAM = CreateGarnished.REGISTRATE.item("cream", Item::new)
            //.properties(p -> )
            .register();


    public static final ItemEntry<GarlicBulbItem> GARLIC_BULB = CreateGarnished.REGISTRATE.item("garlic_bulb", GarlicBulbItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.4F)
                    .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 200, 1), 1.0F).build())).register();
    public static final ItemEntry<Item> MINCED_GARLIC = CreateGarnished.REGISTRATE.item("minced_garlic", Item::new).register();
    public static final ItemEntry<GarlicBreadItem> GARLIC_BREAD = CreateGarnished.REGISTRATE.item("garlic_bread", GarlicBreadItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1.0F).build())).register();

    public static final ItemEntry<Item> CRYSTALLINE_GARLIC_BULB = CreateGarnished.REGISTRATE.item("crystalline_garlic_bulb", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.2F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1), 1.0F).build())).register();
    public static final ItemEntry<Item> MINCED_CRYSTALLINE_GARLIC = CreateGarnished.REGISTRATE.item("minced_crystalline_garlic", Item::new).register();

    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_ROYAL_CIDER = CreateGarnished.REGISTRATE.item("incomplete_royal_cider", SequencedAssemblyItem::new)
            .properties(p -> p.stacksTo(1)).register();
    public static final ItemEntry<RoyalCiderItem> ROYAL_CIDER = CreateGarnished.REGISTRATE.item("royal_cider", RoyalCiderItem::new)
            .properties(p -> p.stacksTo(4))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.royal_cider"))
            .register();

    public static final ItemEntry<PressurisedHatchetItem> PRESSURISED_HATCHET = CreateGarnished.REGISTRATE.item("pressurised_hatchet", p -> new PressurisedHatchetItem(p, false))
            .properties(p -> p.stacksTo(1).durability(200).rarity(Rarity.UNCOMMON))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.pressurised_hatchet"))
            .register();
    public static final ItemEntry<PressurisedHatchetItem> CREATIVE_PRESSURISED_HATCHET = CreateGarnished.REGISTRATE.item("creative_pressurised_hatchet", p -> new PressurisedHatchetItem(Tiers.NETHERITE, p, true))
            .properties(p -> p.stacksTo(1).rarity(Rarity.EPIC))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.creative_pressurised_hatchet"))
            .register();

    public static final ItemEntry<Item> CRUSHED_HAZELNUT_POWDER = CreateGarnished.REGISTRATE.item("crushed_hazelnut_powder", Item::new).register();

    public static final ItemEntry<FromHatchetItem> SNIFFER_FLUFF = CreateGarnished.REGISTRATE.item("sniffer_fluff", p -> new FromHatchetItem(EntityType.SNIFFER, false, p)).register();
    public static final ItemEntry<SpikeItem> GUARDIAN_SPIKE = CreateGarnished.REGISTRATE.item("guardian_spike", p -> new SpikeItem(EntityType.GUARDIAN, p))
            .properties(p -> p.attributes(SwordItem.createAttributes(Tiers.IRON, 3, -2.4F)))
            .register();
    public static final ItemEntry<SpikeItem> ELDER_GUARDIAN_SPIKE = CreateGarnished.REGISTRATE.item("elder_guardian_spike", p -> new SpikeItem(EntityType.ELDER_GUARDIAN, p))
            .properties(p -> p.attributes(SwordItem.createAttributes(Tiers.DIAMOND, 5, -2.4F)))
            .register();
    public static final ItemEntry<FromHatchetItem> ELASTIC_STRAND = CreateGarnished.REGISTRATE.item("elastic_strand", p -> new FromHatchetItem(EntityType.SLIME, false, p)).register();
    public static final ItemEntry<FromHatchetItem> FIERY_ELASTIC_STRAND = CreateGarnished.REGISTRATE.item("fiery_elastic_strand", p -> new FromHatchetItem(EntityType.MAGMA_CUBE, false, p)).register();
    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_GLAZED_MONUMENT_MEDLEY = CreateGarnished.REGISTRATE.item("incomplete_glazed_monument_medley", SequencedAssemblyItem::new).register();
    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_SLLIMY = CreateGarnished.REGISTRATE.item("incomplete_sllimy", SequencedAssemblyItem::new).register();
    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_FIERY_SLLIMY = CreateGarnished.REGISTRATE.item("incomplete_fiery_sllimy", SequencedAssemblyItem::new).register();
    public static final ItemEntry<Item> SLLIMY = CreateGarnished.REGISTRATE.item("sllimy", Item::new)
            .properties(p -> p.stacksTo(16)
                    .food(new FoodProperties.Builder().nutrition(12).saturationModifier(0.8F)
                            .usingConvertsTo(Items.GLASS_BOTTLE)
                            .effect(() -> new MobEffectInstance(MobEffects.OOZING, 1200, 0,
                                    false, false, true), 0.5F).build()))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.sllimy"))
            .register();
    public static final ItemEntry<Item> FIERY_SLLIMY = CreateGarnished.REGISTRATE.item("fiery_sllimy", Item::new)
            .properties(p -> p.stacksTo(16)
                    .food(new FoodProperties.Builder().nutrition(12).saturationModifier(0.8F)
                            .usingConvertsTo(Items.GLASS_BOTTLE)
                            .effect(() -> new MobEffectInstance(MobEffects.OOZING, 1200, 0,
                                    false, false, true), 0.25F)
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0,
                                    false, false, true), 1.0F).build()))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.fiery_sllimy"))
            .register();
    public static final ItemEntry<Item> GLAZED_MONUMENT_MEDLEY = CreateGarnished.REGISTRATE.item("glazed_monument_medley", Item::new)
            .properties(p -> p.stacksTo(4)
                    .food(new FoodProperties.Builder().nutrition(12).saturationModifier(0.8F)
                            .usingConvertsTo(Items.BOWL)
                            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 3600, 0,
                                    false, false, true), 1.0F)
                            .effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 1200, 0,
                                    false, false, true), 0.10F).build()))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.glazed_monument_medley"))
            .register();

    public static final ItemEntry<Item> PUMPKIN_SPICY_FRITTERS = CreateGarnished.REGISTRATE.item("pumpkin_spicy_fritters", Item::new)
            .properties(p -> p.stacksTo(16)
                    .food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.4F)
                            .effect(() -> new MobEffectInstance(CreateGarnishedStatusEffects.SOOTHING, 3600, 0), 1.0F).build()))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.pumpkin_spicy_fritters"))
            .register();
    public static final ItemEntry<Item> CANDY_WRAPPING = CreateGarnished.REGISTRATE.item("candy_wrapping", Item::new)
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.candy_wrapping"))
            .register();
    public static final ItemEntry<Item> CORN_SYRUP_BOTTLE = CreateGarnished.REGISTRATE.item("corn_syrup_bottle", Item::new).register();
    public static final ItemEntry<MysteriousVoltBottleItem> MYSTERIOUS_VOLT_BOTTLE = CreateGarnished.REGISTRATE.item("mysterious_volt_bottle", MysteriousVoltBottleItem::new)
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.mysterious_volt_bottle"))
            .register();
    public static final ItemEntry<WrappedCandyItem> WRAPPED_CANDY = CreateGarnished.REGISTRATE.item("wrapped_candy", WrappedCandyItem::new)
            .properties(p -> p.stacksTo(16)
                    .component(DataComponents.POTION_CONTENTS, PotionContents.EMPTY)
                    .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.6F).alwaysEdible().fast().build()))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.wrapped_candy"))
            .register();
    public static final ItemEntry<Item> SLIMY_COBWOB = CreateGarnished.REGISTRATE.item("slimy_cobwob", Item::new)
            .properties(p -> p.stacksTo(8)
                    .food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.4F)
                            .effect(() -> new MobEffectInstance(MobEffects.WEAVING, 2400, 0), 0.5F)
                            //.effect(() -> new MobEffectInstance(MobEffects.OOZING, 2400, 0), 0.5F)
                            .build()))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.slimy_cobwob")).register();

    public static final ItemEntry<Item> VOLTFISH_MEAT = CreateGarnished.REGISTRATE.item("voltfish_meat", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.4F).build())).register();
    public static final ItemEntry<Item> COOKED_VOLTFISH_MEAT = CreateGarnished.REGISTRATE.item("cooked_voltfish_meat", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8F).build())).register();
    public static final ItemEntry<Item> TOUGHENED_SCALES = CreateGarnished.REGISTRATE.item("toughened_scales", Item::new).register();
    public static final ItemEntry<FromHatchetItem> VOLATILE_ORGAN = CreateGarnished.REGISTRATE.item("volatile_organ", p ->
                    new FromHatchetItem(CreateGarnishedEntityTypes.VOLTFISH.get(), true, p))
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.1F)
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 1.0F).build())).register();
    public static final ItemEntry<Item> MONSTROUS_TREAT = CreateGarnished.REGISTRATE.item("monstrous_treat", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(10).saturationModifier(1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1), 1.0F).build()))
            .onRegister(s -> ItemDescription.useKey(s, "item.creategarnished.monstrous_treat")).register();

    public static final ItemEntry<Item> POUND_CAKE_SLICE = CreateGarnished.REGISTRATE.item("pound_cake_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.2F).fast().build())).register();

    public static final ItemEntry<SpawnEggItem> VOLTFISH_SPAWN_EGG = CreateGarnished.REGISTRATE.item("voltfish_spawn_egg",
            properties -> new SpawnEggItem(CreateGarnishedEntityTypes.VOLTFISH.get(),
                    0x7C6496, 0x291B38, properties)).register();

    public static void register() {}

}
