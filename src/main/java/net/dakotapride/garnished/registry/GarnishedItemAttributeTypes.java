package net.dakotapride.garnished.registry;

import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.logistics.item.filter.attribute.ItemAttributeType;
import com.simibubi.create.content.logistics.item.filter.attribute.SingletonItemAttribute;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.recipe.GarnishedFanProcessing;
import net.minecraft.core.Registry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.BiPredicate;

public class GarnishedItemAttributeTypes {
    public static final ItemAttributeType FREEZABLE = registerSingleton("freezable", GarnishedFanProcessing.FREEZING::canProcess);

    public static final ItemAttributeType CAN_BE_DYED_RED = registerSingleton("can_be_dyed_red", GarnishedFanProcessing.RED_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_ORANGE = registerSingleton("can_be_dyed_orange", GarnishedFanProcessing.ORANGE_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_YELLOW = registerSingleton("can_be_dyed_yellow", GarnishedFanProcessing.YELLOW_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_GREEN = registerSingleton("can_be_dyed_green", GarnishedFanProcessing.GREEN_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_LIME = registerSingleton("can_be_dyed_lime", GarnishedFanProcessing.LIME_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_BLUE = registerSingleton("can_be_dyed_blue", GarnishedFanProcessing.BLUE_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_LIGHT_BLUE = registerSingleton("can_be_dyed_light_blue", GarnishedFanProcessing.LIGHT_BLUE_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_CYAN = registerSingleton("can_be_dyed_cyan", GarnishedFanProcessing.CYAN_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_PURPLE = registerSingleton("can_be_dyed_purple", GarnishedFanProcessing.PURPLE_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_MAGENTA = registerSingleton("can_be_dyed_magenta", GarnishedFanProcessing.MAGENTA_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_PINK = registerSingleton("can_be_dyed_pink", GarnishedFanProcessing.PINK_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_BLACK = registerSingleton("can_be_dyed_black", GarnishedFanProcessing.BLACK_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_GRAY = registerSingleton("can_be_dyed_gray", GarnishedFanProcessing.GRAY_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_LIGHT_GRAY = registerSingleton("can_be_dyed_light_gray", GarnishedFanProcessing.LIGHT_GRAY_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_WHITE = registerSingleton("can_be_dyed_white", GarnishedFanProcessing.WHITE_DYE_BLOWING::canProcess);
    public static final ItemAttributeType CAN_BE_DYED_BROWN = registerSingleton("can_be_dyed_brown", GarnishedFanProcessing.BROWN_DYE_BLOWING::canProcess);

    private static ItemAttributeType registerSingleton(String id, BiPredicate<ItemStack, Level> predicate) {
        return register(id, singleton(id, predicate));
    }

    private static ItemAttributeType singleton(String id, BiPredicate<ItemStack, Level> predicate) {
        return new SingletonItemAttribute.Type(type -> new SingletonItemAttribute(type, predicate, id));
    }

    private static ItemAttributeType register(String id, ItemAttributeType type) {
        return Registry.register(CreateBuiltInRegistries.ITEM_ATTRIBUTE_TYPE, CreateGarnished.asResource(id), type);
    }

    public static void register() {}
}