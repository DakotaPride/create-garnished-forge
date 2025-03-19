package net.dakotapride.garnished.registry;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.dakotapride.garnished.CreateGarnished;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.Set;
import java.util.stream.Stream;

public record GarnishedSetTypes() {
	private static final Set<BlockSetType> VALUES = new ObjectArraySet<>();

	public static final BlockSetType SEPIA = register(new BlockSetType("sepia"));

	public static final BlockSetType NUT = register(new BlockSetType("nut"));

	public static Stream<BlockSetType> values() {
		return VALUES.stream();
	}

	private static BlockSetType register(BlockSetType value) {
		VALUES.add(value);
		return value;
	}

	public static void setRegister() {}
}
