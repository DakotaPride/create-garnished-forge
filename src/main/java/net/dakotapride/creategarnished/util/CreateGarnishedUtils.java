package net.dakotapride.creategarnished.util;

import net.dakotapride.creategarnished.CreateGarnished;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.level.Level;

import java.util.List;

public class CreateGarnishedUtils {

    public static <T extends LivingEntity> void hauntingEntityConversion(Level level, Entity entity, EntityType<T> convertingTo) {
        createFanProcessingEntityConversion(level, entity, convertingTo, "Haunting");
    }

    public static <T extends LivingEntity> void washingEntityConversion(Level level, Entity entity, EntityType<T> convertingTo) {
        createFanProcessingEntityConversion(level, entity, convertingTo, "Washing");
    }

    public static <T extends LivingEntity> void smokingEntityConversion(Level level, Entity entity, EntityType<T> convertingTo) {
        createFanProcessingEntityConversion(level, entity, convertingTo, "Smoking");
    }

    public static <T extends LivingEntity> void blastingEntityConversion(Level level, Entity entity, EntityType<T> convertingTo) {
        createFanProcessingEntityConversion(level, entity, convertingTo, "Blasting");
    }

    public static <T extends LivingEntity> void createFanProcessingEntityConversion(Level level, Entity entity, EntityType<T> convertingTo, String processingType) {
        String data = "Create" + processingType;
        if (entity instanceof LivingEntity living) {
            int progress = living.getPersistentData().getInt(data);
            if (progress < 100) {
                if (progress % 10 == 0) {
                    level.playSound(null, entity.blockPosition(), SoundEvents.SOUL_ESCAPE.value(), SoundSource.NEUTRAL,
                            1f, 1.5f * progress / 100f);
                }
                living.getPersistentData().putInt(data, progress + 1);
                return;
            }

            level.playSound(null, entity.blockPosition(), SoundEvents.GENERIC_EXTINGUISH_FIRE,
                    SoundSource.NEUTRAL, 1.25f, 0.65f);

            T convert = convertingTo.create(level);
            CompoundTag serializeNBT = living.saveWithoutId(new CompoundTag());
            serializeNBT.remove("UUID");

            // Deprecated .deserializeNBT();
            convert.deserializeNBT(entity.registryAccess(), serializeNBT);
            convert.setPos(living.getPosition(0));
            level.addFreshEntity(convert);
            living.discard();
        }
    }

    static ResourceLocation EMPTY_SLOT_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
    static ResourceLocation EMPTY_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
    static ResourceLocation EMPTY_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
    static ResourceLocation EMPTY_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
    static ResourceLocation EMPTY_SLOT_HOE = ResourceLocation.withDefaultNamespace("item/empty_slot_hoe");
    static ResourceLocation EMPTY_SLOT_AXE = ResourceLocation.withDefaultNamespace("item/empty_slot_axe");
    static ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.withDefaultNamespace("item/empty_slot_sword");
    static ResourceLocation EMPTY_SLOT_SHOVEL = ResourceLocation.withDefaultNamespace("item/empty_slot_shovel");
    static ResourceLocation EMPTY_SLOT_PICKAXE = ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe");
    static ResourceLocation EMPTY_SLOT_INGOT = ResourceLocation.withDefaultNamespace("item/empty_slot_ingot");

    static Component NUTIUM_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", CreateGarnished.asResource("nutium_upgrade"))).withStyle(ChatFormatting.GRAY);
    static Component NUTIUM_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", CreateGarnished.asResource("smithing_template.nutium_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE);
    static Component NUTIUM_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", CreateGarnished.asResource("smithing_template.nutium_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE);
    static Component NUTIUM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", CreateGarnished.asResource("smithing_template.nutium_upgrade.base_slot_description")));
    static Component NUTIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", CreateGarnished.asResource("smithing_template.nutium_upgrade.additions_slot_description")));

    private static List<ResourceLocation> createNutiumUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }

    private static List<ResourceLocation> createNutiumUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }

    public static SmithingTemplateItem createNutiumUpgradeTemplate() {
        return new SmithingTemplateItem(NUTIUM_UPGRADE_APPLIES_TO, NUTIUM_UPGRADE_INGREDIENTS, NUTIUM_UPGRADE, NUTIUM_UPGRADE_BASE_SLOT_DESCRIPTION, NUTIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createNutiumUpgradeIconList(), createNutiumUpgradeMaterialList(), new FeatureFlag[0]);
    }
}
