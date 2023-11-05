package net.dakotapride.garnished;

public class GarnishedUtils {
    public enum IDs {
        STUFF_AND_ADDITIONS("create_sa"),
        DEEPER_AND_DARKER("deeperdarker"),
        ADDITIONAL_ADDITIONS("additionaladditions");

        final String getID;

        IDs(String id) {
            this.getID = id;
        }
    }

    public static String getIDFromEnum(String id) {
        return id;
    }

    public static String stuffAndAdditionsID = IDs.STUFF_AND_ADDITIONS.getID;
    public static String deeperAndDarkerID = IDs.DEEPER_AND_DARKER.getID;
    public static String additionalAdditionsID = IDs.ADDITIONAL_ADDITIONS.getID;

    public static String stuffAndAdditions() {
        return getIDFromEnum(stuffAndAdditionsID);
    }

    public static String deeperAndDarker() {
        return getIDFromEnum(deeperAndDarkerID);
    }

    public static String additionalAdditions() {
        return getIDFromEnum(additionalAdditionsID);
    }
}
