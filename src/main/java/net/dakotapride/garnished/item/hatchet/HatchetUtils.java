package net.dakotapride.garnished.item.hatchet;

import net.dakotapride.garnished.registry.GarnishedEnchantments;
import net.dakotapride.garnished.registry.GarnishedTags;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Unique;

public class HatchetUtils {
    // Information
    // Maximum Level: 2
    // Minimum Level: 1
    //
    // Grants additional drops depending on the level
    static ResourceKey<Enchantment> salvaging = GarnishedEnchantments.SALVAGING;
    // Information
    // Maximum Level: 1
    // Minimum Level: 1
    //
    // Grants the player PVE/PVP benefits depending on the situation
	// Grants additional drops depending on the level
    static ResourceKey<Enchantment> ravaging = GarnishedEnchantments.RAVAGING;
    // Information
    // Maximum Level: 4
    // Minimum Level: 1
    //
    // Grants the player bonus damage, similar to Sharpness or Smite
    static ResourceKey<Enchantment> striking = GarnishedEnchantments.STRIKING;
    // Information
    // Maximum Level: 3
    // Minimum Level: 1
    //
    // Grants the player a speed boost whilst under half health. This enchantment cannot be applied alongside Ravaging
    static ResourceKey<Enchantment> quickStep = GarnishedEnchantments.QUICK_STEP;
    //
    static ResourceKey<Enchantment> leechingCurse = GarnishedEnchantments.LEECHING_CURSE;
    //
    static ResourceKey<Enchantment> rejuvenate = GarnishedEnchantments.REJUVENATE;
    // random shit
    public static final RandomSource random = RandomSource.create();

    public HatchetUtils() {}


    public static boolean isAffectedByRavaging(Entity entity) {
        return entity.getType().is(GarnishedTags.IS_AFFECTED_BY_RAVAGING);
    }

    public static boolean isAffectedBySalvaging(Entity entity) {
        return entity.getType().is(GarnishedTags.IS_AFFECTED_BY_SALVAGING);
    }

    public static boolean hasRavaging(LivingEntity entity, ItemStack stack) {
        return hasEnchantment(stack, GarnishedTags.RAVAGING);
    }

    public static boolean hasSalvaging(LivingEntity entity, ItemStack stack) {
        return hasEnchantment(stack, GarnishedTags.SALVAGING);
    }

    public static boolean hasStriking(LivingEntity entity, ItemStack stack) {
        return hasEnchantment(stack, GarnishedTags.STRIKING);
    }

    public static boolean hasLeechingCurse(LivingEntity entity, ItemStack stack) {
        return hasEnchantment(stack, GarnishedTags.LEECH_CURSE);
    }

    public static boolean hasRejuvenate(LivingEntity entity, ItemStack stack) {
        return hasEnchantment(stack, GarnishedTags.REJUVENATE);
    }

    public static boolean hasQuickStep(LivingEntity entity, ItemStack stack) {
        return hasEnchantment(stack, GarnishedTags.QUICK_STEP);
    }

    // Changed to not rely on half of the entity's max health (partially because of how enchantments were changed in 1.21.x)
//    public static boolean canApplyRavagingEffects(LivingEntity entity, ItemStack stack) {
//        return stack.is(GarnishedTags.HATCHETS_TAG) && hasRavaging(entity, stack) && entity.getHealth() <= (entity.getMaxHealth() / 2);
//    }
//
//    public static boolean canApplyQuickStepEffects(LivingEntity entity, ItemStack stack) {
//        return stack.is(GarnishedTags.HATCHETS_TAG) && hasEnchantment(stack, GarnishedTags.QUICK_STEP) && entity.getHealth() <= (entity.getMaxHealth() / 2);
//    }

    public static boolean canBeUsedToStripLogs(ItemStack stack) {
        return stack.getItem() instanceof AxeItem || stack.getItem() instanceof HatchetToolItem;
    }

    @Unique
    private static boolean hasEnchantment(ItemStack stack, TagKey<Enchantment> enchantmentTag) {
        return EnchantmentHelper.hasTag(stack, enchantmentTag);
    }


}
