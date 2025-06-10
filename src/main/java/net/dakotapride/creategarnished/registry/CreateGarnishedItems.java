package net.dakotapride.creategarnished.registry;

import com.simibubi.create.foundation.item.ItemDescription;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.dakotapride.creategarnished.CreateGarnished;
import net.dakotapride.creategarnished.item.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class CreateGarnishedItems {

    static {
        CreateGarnished.REGISTRATE.setCreativeTab(GarnishedCreativeModeTabs.GARNISHED);
    }

    public static final ItemEntry<GarnishmentBookItem> GARNISHMENT_BOOK = CreateGarnished.REGISTRATE.item("garnishment_book", GarnishmentBookItem::new).register();

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


    public static final ItemEntry<Item> GARLIC_BULB = CreateGarnished.REGISTRATE.item("garlic_bulb", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.4F)
                    .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 200, 1), 1.0F).build())).register();
    public static final ItemEntry<Item> MINCED_GARLIC = CreateGarnished.REGISTRATE.item("minced_garlic", Item::new).register();
    public static final ItemEntry<GarlicBreadItem> GARLIC_BREAD = CreateGarnished.REGISTRATE.item("garlic_bread", GarlicBreadItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F)
                    .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 800, 0), 1.0F).build())).register();

    public static void register() {}

}
