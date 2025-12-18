package net.dakotapride.creategarnished.item;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.*;

public class NutiumTools {
    public static class Sword extends SwordItem {
        public Sword(Tier tier, Properties properties) {
            super(tier, properties);
        }

        @Override
        public Component getName(ItemStack stack) {
            return Component.translatable(this.getDescriptionId(stack)).withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xBCAE80)));
        }
    }

    public static class Pickaxe extends PickaxeItem {
        public Pickaxe(Tier p_42961_, Properties p_42964_) {
            super(p_42961_, p_42964_);
        }

        @Override
        public Component getName(ItemStack stack) {
            return Component.translatable(this.getDescriptionId(stack)).withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xBCAE80)));
        }
    }

    public static class Axe extends AxeItem {
        public Axe(Tier p_40521_, Properties p_40524_) {
            super(p_40521_, p_40524_);
        }

        @Override
        public Component getName(ItemStack stack) {
            return Component.translatable(this.getDescriptionId(stack)).withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xBCAE80)));
        }
    }

    public static class Shovel extends ShovelItem {
        public Shovel(Tier p_43114_, Properties p_43117_) {
            super(p_43114_, p_43117_);
        }

        @Override
        public Component getName(ItemStack stack) {
            return Component.translatable(this.getDescriptionId(stack)).withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xBCAE80)));
        }
    }

    public static class Hoe extends HoeItem {
        public Hoe(Tier p_41336_, Properties p_41339_) {
            super(p_41336_, p_41339_);
        }

        @Override
        public Component getName(ItemStack stack) {
            return Component.translatable(this.getDescriptionId(stack)).withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xBCAE80)));
        }
    }
}
