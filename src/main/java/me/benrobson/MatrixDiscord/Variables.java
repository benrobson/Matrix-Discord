package me.benrobson.MatrixDiscord;

import static me.benrobson.MatrixDiscord.ConfigurationManager.plugin;

public class Variables {
    public static String discordapitoken = plugin.getConfig().getString("discordapitoken");
    public static String matrixnotificationchannel = plugin.getConfig().getString("matrixnotificationchannel");
}
