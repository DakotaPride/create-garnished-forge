package net.dakotapride.creategarnished.config;

import net.createmod.catnip.config.ConfigBase;

public class ClientConfig extends ConfigBase {

    public final ConfigGroup client = group(0, "client");

    public final ConfigFloat peanutButterTransparencyMultiplier =
            f(1, .125f, 256, "peanutButter", Comments.peanutButterTransparencyMultiplier);
    public final ConfigFloat birchSyrupTransparencyMultiplier =
            f(1, .125f, 256, "birchSyrup", Comments.birchSyrupTransparencyMultiplier);
    public final ConfigFloat almondExtractTransparencyMultiplier =
            f(1, .125f, 256, "almondExtract", Comments.almondExtractTransparencyMultiplier);
    public final ConfigFloat royalCiderTransparencyMultiplier =
            f(1, .125f, 256, "royalCider", Comments.royalCiderTransparencyMultiplier);
    public final ConfigFloat beetrootJuiceTransparencyMultiplier =
            f(1, .125f, 256, "beetrootJuice", Comments.beetrootJuiceTransparencyMultiplier);
    public final ConfigFloat mushroomSlopTransparencyMultiplier =
            f(1, .125f, 256, "mushroomSlop", Comments.mushroomSlopTransparencyMultiplier);

    @Override
    public String getName() {
        return "client";
    }

    private static class Comments {
        static String peanutButterTransparencyMultiplier = "The vision range though peanut butter will be multiplied by this factor";
        static String birchSyrupTransparencyMultiplier = "The vision range though birch syrup will be multiplied by this factor";
        static String almondExtractTransparencyMultiplier = "The vision range though almond extract will be multiplied by this factor";
        static String royalCiderTransparencyMultiplier = "The vision range though royal cider will be multiplied by this factor";
        static String beetrootJuiceTransparencyMultiplier = "The vision range though beetroot juice will be multiplied by this factor";
        static String mushroomSlopTransparencyMultiplier = "The vision range though mushroom slop will be multiplied by this factor";
    }
}
