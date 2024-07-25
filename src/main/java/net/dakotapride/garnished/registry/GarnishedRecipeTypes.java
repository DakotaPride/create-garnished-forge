package net.dakotapride.garnished.registry;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import com.simibubi.create.foundation.utility.Lang;
import net.dakotapride.garnished.CreateGarnished;
import net.dakotapride.garnished.recipe.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

public enum GarnishedRecipeTypes implements IRecipeTypeInfo {
	FREEZING(FreezingFanRecipe::new),
	RED_DYE_BLOWING(RedDyeBlowingFanRecipe::new),
	ORANGE_DYE_BLOWING(OrangeDyeBlowingFanRecipe::new),
	YELLOW_DYE_BLOWING(YellowDyeBlowingFanRecipe::new),
	GREEN_DYE_BLOWING(GreenDyeBlowingFanRecipe::new),
	LIME_DYE_BLOWING(LimeDyeBlowingFanRecipe::new),
	BLUE_DYE_BLOWING(BlueDyeBlowingFanRecipe::new),
	LIGHT_BLUE_DYE_BLOWING(LightBlueDyeBlowingFanRecipe::new),
	CYAN_DYE_BLOWING(CyanDyeBlowingFanRecipe::new),
	PURPLE_DYE_BLOWING(PurpleDyeBlowingFanRecipe::new),
	MAGENTA_DYE_BLOWING(MagentaDyeBlowingFanRecipe::new),
	PINK_DYE_BLOWING(PinkDyeBlowingFanRecipe::new),
	BLACK_DYE_BLOWING(BlackDyeBlowingFanRecipe::new),
	GRAY_DYE_BLOWING(GrayDyeBlowingFanRecipe::new),
	LIGHT_GRAY_DYE_BLOWING(LightGrayDyeBlowingFanRecipe::new),
	WHITE_DYE_BLOWING(WhiteDyeBlowingFanRecipe::new),
	BROWN_DYE_BLOWING(BrownDyeBlowingFanRecipe::new);

	private final ResourceLocation id;
	private final RegistryObject<RecipeSerializer<?>> serializerObject;
	private final Supplier<RecipeType<?>> type;


	GarnishedRecipeTypes(Supplier<RecipeSerializer<?>> serializerSupplier) {
		String name = Lang.asId(name());
		id = CreateGarnished.asResource(name);
		serializerObject = Registers.SERIALIZER_REGISTER.register(name, serializerSupplier);
		@Nullable RegistryObject<RecipeType<?>> typeObject = Registers.TYPE_REGISTER.register(name, () -> RecipeType.simple(id));
		type = typeObject;
	}

	GarnishedRecipeTypes(ProcessingRecipeBuilder.ProcessingRecipeFactory<?> processingFactory) {
		this(() -> new ProcessingRecipeSerializer<>(processingFactory));
	}

	public static void register(IEventBus modEventBus) {
		ShapedRecipe.setCraftingSize(9, 9);
		Registers.SERIALIZER_REGISTER.register(modEventBus);
		Registers.TYPE_REGISTER.register(modEventBus);
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends RecipeSerializer<?>> T getSerializer() {
		return (T) serializerObject.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends RecipeType<?>> T getType() {
		return (T) type.get();
	}

	public <C extends Container, T extends Recipe<C>> Optional<T> find(C inv, Level world) {
		return world.getRecipeManager()
				.getRecipeFor(getType(), inv, world);
	}

	private static class Registers {
		private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CreateGarnished.ID);
		private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER = DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY, CreateGarnished.ID);
	}

}