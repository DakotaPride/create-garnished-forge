package net.dakotapride.creategarnished.util;

import net.neoforged.fml.ModList;

public enum ModIds {
    RELIQUARY("reliquary"),
    IRONWORKS("create_ironworks"),
    PASTEL("pastel"),
    MEKANISM("mekanism"),
    ORITECH("oritech"),
    FARMERS_DELIGHT("farmersdelight"),
    HOMINID("hominid"),



    ;

    public final String id;

    ModIds(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isLoaded() {
        return ModList.get().isLoaded(id);
    }
}
