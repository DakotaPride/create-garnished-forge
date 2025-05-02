package net.dakotapride.garnished.registry;

import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.logistics.item.filter.attribute.ItemAttributeType;
import com.simibubi.create.content.logistics.item.filter.attribute.SingletonItemAttribute;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.recipe.GarnishedFanProcessing;
import net.dakotapride.garnished.registry.recipe.GarnishedRecipeTypes;
import net.minecraft.core.Registry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class GarnishedItemAttributeTypes {
    public static final DeferredRegister<ItemAttributeType> ITEM_ATTRIBUTE_TYPES =
            DeferredRegister.create(CreateBuiltInRegistries.ITEM_ATTRIBUTE_TYPE, CreateGarnished.ID);

    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> FREEZABLE =
            ITEM_ATTRIBUTE_TYPES.register("freezable",
                    () -> singleton("freezable", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.FREEZING.getType()))
            );


    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_RED =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_red",
                    () -> singleton("can_be_dyed_red", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.RED_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_ORANGE =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_orange",
                    () -> singleton("can_be_dyed_orange", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.ORANGE_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_YELLOW =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_yellow",
                    () -> singleton("can_be_dyed_yellow", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.YELLOW_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_GREEN =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_green",
                    () -> singleton("can_be_dyed_green", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.GREEN_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_LIME =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_lime",
                    () -> singleton("can_be_dyed_lime", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.LIME_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_BLUE =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_blue",
                    () -> singleton("can_be_dyed_blue", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.BLUE_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_LIGHT_BLUE =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_light_blue",
                    () -> singleton("can_be_dyed_light_blue", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.LIGHT_BLUE_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_CYAN =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_cyan",
                    () -> singleton("can_be_dyed_cyan", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.CYAN_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_PURPLE =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_purple",
                    () -> singleton("can_be_dyed_purple", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.PURPLE_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_MAGENTA =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_magenta",
                    () -> singleton("can_be_dyed_magenta", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.MAGENTA_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_PINK =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_pink",
                    () -> singleton("can_be_dyed_pink", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.PINK_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_BLACK =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_black",
                    () -> singleton("can_be_dyed_black", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.BLACK_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_GRAY =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_gray",
                    () -> singleton("can_be_dyed_gray", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.GRAY_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_LIGHT_GRAY =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_light_gray",
                    () -> singleton("can_be_dyed_light_gray", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.LIGHT_GRAY_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_WHITE =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_white",
                    () -> singleton("can_be_dyed_white", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.WHITE_DYE_BLOWING.getType()))
            );
    public static final DeferredHolder<ItemAttributeType, ItemAttributeType> CAN_BE_DYED_BROWN =
            ITEM_ATTRIBUTE_TYPES.register("can_be_dyed_brown",
                    () -> singleton("can_be_dyed_brown", (s, w) -> testRecipe(s, w, GarnishedRecipeTypes.BROWN_DYE_BLOWING.getType()))
            );

    private static <T extends Recipe<SingleRecipeInput>> boolean testRecipe(ItemStack s, Level w, RecipeType<T> type) {
        return w.getRecipeManager()
                .getRecipeFor(type, new SingleRecipeInput(s.copy()), w)
                .isPresent();
    }

    private static ItemAttributeType singleton(String id, BiPredicate<ItemStack, Level> predicate) {
        return new SingletonItemAttribute.Type(type -> new SingletonItemAttribute(type, predicate, id));
    }

    public static void register(IEventBus bus) {
        ITEM_ATTRIBUTE_TYPES.register(bus);
    }
}
