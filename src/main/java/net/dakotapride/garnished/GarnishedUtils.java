package net.dakotapride.garnished;

public class GarnishedUtils {
    public enum IDs {
        STUFF_AND_ADDITIONS("create_sa"),
        DEEPER_AND_DARKER("deeperdarker"),
        ADDITIONAL_ADDITIONS("additionaladditions"),
        AE2("ae2"),
        BETTER_END("betterend"),
        BETTER_NETHER("betternether");

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
    public static String ae2ID = IDs.AE2.getID;
    public static String betterEndID = IDs.BETTER_END.getID;
    public static String betterNetherID = IDs.BETTER_NETHER.getID;

    public static String stuffAndAdditions() {
        return getIDFromEnum(stuffAndAdditionsID);
    }

    public static String deeperAndDarker() {
        return getIDFromEnum(deeperAndDarkerID);
    }

    public static String additionalAdditions() {
        return getIDFromEnum(additionalAdditionsID);
    }

    public static String ae2() {
        return getIDFromEnum(ae2ID);
    }

    public static String betterEnd() {
        return getIDFromEnum(betterEndID);
    }

    public static String betterNether() {
        return getIDFromEnum(betterNetherID);
    }
}
