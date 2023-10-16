package net.dakotapride.garnished.registry;

import net.dakotapride.garnished.item.IGarnishedItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class GarnishedFoods implements IGarnishedItem {

	// Ungarnished
	public static final FoodProperties UNGARNISHED_NUT = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F)
			.effect(new MobEffectInstance(MobEffects.CONFUSION, 240), 1.0F).build();

	// Garnished
	public static final FoodProperties GARNISHED_NUT = new FoodProperties.Builder().nutrition(5).saturationMod(0.3F).build();
	public static final FoodProperties GARNISHED_NUT_MIX = new FoodProperties.Builder().nutrition(7).saturationMod(0.4F).build();
	public static final FoodProperties GARNISHED_BERRIES = new FoodProperties.Builder().nutrition(5).saturationMod(0.4F).build();

	// Cinder Flour (Melted)
	public static final FoodProperties MELTED_CINDER_FLOUR_NUT = new FoodProperties.Builder().nutrition(6).saturationMod(0.4F).build();

	// Sweetened
	public static final FoodProperties SWEETENED_NUT = new FoodProperties.Builder().nutrition(7).saturationMod(0.4F).build();
	public static final FoodProperties SWEETENED_NUT_MIX = new FoodProperties.Builder().nutrition(9).saturationMod(0.4F).build();

	// Chocolate Glazed
	public static final FoodProperties CHOCHOLATE_GLAZED_NUT = new FoodProperties.Builder().nutrition(7).saturationMod(0.6F).build();
	public static final FoodProperties CHOCOLATE_GLAZED_NUT_MIX = new FoodProperties.Builder().nutrition(9).saturationMod(0.6F).build();

	// Honeyed
	public static final FoodProperties HONEYED_NUT = new FoodProperties.Builder().nutrition(8).saturationMod(0.6F).build();
	public static final FoodProperties HONEYED_NUT_MIX = new FoodProperties.Builder().nutrition(10).saturationMod(0.7F).build();
	public static final FoodProperties HONEYED_BERRIES = new FoodProperties.Builder().nutrition(7).saturationMod(0.6F).build();

	// Apple Cider
	public static final FoodProperties APPLE_CIDER = new FoodProperties.Builder().nutrition(7).saturationMod(0.5F).build();
	public static final FoodProperties CRYPTIC_APPLE_CIDER = new FoodProperties.Builder().nutrition(8).saturationMod(0.7F).build();

	// Misc
	public static final FoodProperties GARNISHED_MEAL = new FoodProperties.Builder().nutrition(11).saturationMod(0.8F).build();
	public static final FoodProperties SALAD = new FoodProperties.Builder().nutrition(8).saturationMod(0.6F).build();
	public static final FoodProperties PHANTOM_STEAK = new FoodProperties.Builder().nutrition(12).saturationMod(0.9F).build();
	public static final FoodProperties PEANUT_OIL = new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).build();
	public static final FoodProperties CASHEW_FRUIT = new FoodProperties.Builder().nutrition(6).saturationMod(0.4F).build();
	public static final FoodProperties BITTER_ALMOND = new FoodProperties.Builder().nutrition(5).saturationMod(0.6F)
			.effect(new MobEffectInstance(MobEffects.POISON, getBitterAlmondEffectDuration), 1.0F).build();
	public static final FoodProperties WALNUT_BROWNIE = new FoodProperties.Builder().nutrition(8).saturationMod(0.7F).build();
	public static final FoodProperties PECAN_PIE = new FoodProperties.Builder().nutrition(9).saturationMod(0.4F).build();
	public static final FoodProperties CASHEW_COOKIE = new FoodProperties.Builder().nutrition(7).saturationMod(0.5F).build();
	public static final FoodProperties ALMOND_CHEESE = new FoodProperties.Builder().nutrition(7).saturationMod(0.5F).build();

	// Incineration
	public static final FoodProperties PEANUT_OIL_AND_CINDER_SANDWICH = new FoodProperties.Builder().nutrition(10).saturationMod(0.6F).build();
	public static final FoodProperties TOPHET_BREW = new FoodProperties.Builder().nutrition(12).saturationMod(0.8F).build();
	public static final FoodProperties GRIM_STEW = new FoodProperties.Builder().nutrition(14).saturationMod(0.9F).build();
	public static final FoodProperties WRAPPED_WARPED_TANGLE = new FoodProperties.Builder().nutrition(9).saturationMod(0.5F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, getWrappedTangleEffectDuration, 1), 0.8F).build();
	public static final FoodProperties WRAPPED_CRIMSON_TANGLE = new FoodProperties.Builder().nutrition(9).saturationMod(0.5F)
			.effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, getWrappedTangleEffectDuration, 1), 0.8F).build();
	public static final FoodProperties WRAPPED_SEPIA_TANGLE = new FoodProperties.Builder().nutrition(9).saturationMod(0.5F)
			// .effect(new MobEffectInstance(GarnishedEffects.SPIRITED_RESISTANCE.get(), getWrappedTangleEffectDuration, 1), 0.8F)
			.build();
	public static final FoodProperties CINDER_ROLL = new FoodProperties.Builder().nutrition(8).saturationMod(0.7F).build();
	public static final FoodProperties WEEPING_TANGLE = new FoodProperties.Builder().nutrition(11).saturationMod(0.5F).build();
	public static final FoodProperties BLAZING_DELIGHT = new FoodProperties.Builder().nutrition(16).saturationMod(0.7F).build();
	public static final FoodProperties FERMENTED_CASHEW_MIXTURE = new FoodProperties.Builder().nutrition(3).saturationMod(0.4F)
			.effect(new MobEffectInstance(MobEffects.CONFUSION, getFermentedCashewMixtureEffectDuration,2 ), 0.05F)
			.effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, getFermentedCashewMixtureEffectDuration, 2), 0.05F).build();
	public static final FoodProperties PUTRID_STEW = new FoodProperties.Builder().nutrition(7).saturationMod(0.3F)
			.effect(new MobEffectInstance(MobEffects.CONFUSION, 200), 1.0F).build();
	public static final FoodProperties SOUL_KHANA = new FoodProperties.Builder().nutrition(7).saturationMod(0.3F)
			.effect(new MobEffectInstance(MobEffects.INVISIBILITY, 2400), 1.0F)
			.effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3000), 1.0F).build();
	public static final FoodProperties SPIRITED_CONCOCTION = new FoodProperties.Builder().nutrition(7).saturationMod(0.3F)
			// .effect(new MobEffectInstance(GarnishedEffects.SPIRITED_RESISTANCE.get(), 900), 1.0F)
			.build();
	public static final FoodProperties SENILE_SWEET = new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).build();
	public static final FoodProperties NUT_NACHO = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
	public static final FoodProperties NUT_NACHO_BOWL = new FoodProperties.Builder().nutrition(9).saturationMod(0.5F).build();

	// Desolation
	public static final FoodProperties BOTTLED_ENDER_JELLY = new FoodProperties.Builder().nutrition(10).saturationMod(0.5F).build();
	public static final FoodProperties CHORUS_COCKTAIL = new FoodProperties.Builder().nutrition(14).saturationMod(0.8F).build();
	public static final FoodProperties COSMIC_BREW = new FoodProperties.Builder().nutrition(18).saturationMod(0.8F).build();
	public static final FoodProperties DESOLATE_STEW = new FoodProperties.Builder().nutrition(12).saturationMod(0.6F).build();
	public static final FoodProperties ETHEREAL_CONCOCTION = new FoodProperties.Builder().nutrition(16).saturationMod(0.6F).build();
	public static final FoodProperties VOID_MIXTURE = new FoodProperties.Builder().nutrition(12).saturationMod(0.4F).build();
	public static final FoodProperties CHORUS_BOWL = new FoodProperties.Builder().nutrition(16).saturationMod(0.6F).build();
	public static final FoodProperties CHORUS_COOKIE = new FoodProperties.Builder().nutrition(6).saturationMod(0.2F).build();
	public static final FoodProperties ENDER_JELLY = new FoodProperties.Builder().nutrition(8).saturationMod(0.2F).build();
	public static final FoodProperties ILLUMINATING_COCKTAIL = new FoodProperties.Builder().nutrition(16).saturationMod(0.8F).build();
	public static final FoodProperties MULCH = new FoodProperties.Builder().nutrition(5).saturationMod(0.3F).build();
	public static final FoodProperties MUD_PIE = new FoodProperties.Builder().nutrition(9).saturationMod(0.2F).build();

	// Snare & Tear
	public static final FoodProperties MOLTEN_STEW = new FoodProperties.Builder().nutrition(12).saturationMod(0.6F).build();

	// Farmer's Delight Foods
	public static final FoodProperties PECAN_PIE_SLICE = new FoodProperties.Builder().nutrition(3).saturationMod(0.4F).build();
	public static final FoodProperties PHANTOM_BURGER = new FoodProperties.Builder().nutrition(14).saturationMod(0.9F).build();
	public static final FoodProperties PHANTOM_BEEF_PATTY = new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build();
	public static final FoodProperties GLOW_INK_ROLL = new FoodProperties.Builder().nutrition(12).saturationMod(0.6F).build();
	public static final FoodProperties GLOW_INK_ROLL_SLICE = new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build();


	public static void setRegister() {}
}
