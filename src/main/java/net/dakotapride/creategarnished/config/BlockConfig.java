package net.dakotapride.creategarnished.config;

import net.createmod.catnip.config.ConfigBase;

public class BlockConfig extends ConfigBase {
    public ConfigBool allowForRenewableBirchSap = b(true, "allowForRenewableBirchSap", Comments.allowForRenewableBirchSap);
    public ConfigBool requireLogsForSapGeneration = b(false, "requireLogsForSapGeneration", Comments.requireLogsForSapGeneration);
    public ConfigBool allowSapFluidExtraction = b(true, "allowSapFluidExtraction", Comments.allowSapFluidExtraction);
    public ConfigInt sapFluidExtractionAmount = i(250, 1, 1000, "sapFluidExtractionAmount", Comments.sapFluidExtractionAmount);

    @Override
    public String getName() {
        return "block";
    }

    private static class Comments {
        static String allowForRenewableBirchSap = "Controls whether or not Birch Sap can be generated over time from a Sappy Birch Log.";
        static String requireLogsForSapGeneration = "Controls whether or not Sappy Birch Logs require Birch Logs above and below the block to generate Birch Sap.";
        static String allowSapFluidExtraction = "Controls whether or not Birch Sap can be extracted from Sappy Birch Logs with fluid pipes.";
        static String sapFluidExtractionAmount = "The amount of Birch Sap extracted from Sappy Birch Logs assuming that fluid extraction is allowed.";
    }
}
