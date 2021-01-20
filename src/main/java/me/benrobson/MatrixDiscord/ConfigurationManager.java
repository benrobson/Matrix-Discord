package me.benrobson.MatrixDiscord;

import me.benrobson.MatrixDiscord.discord.MatrixDiscordMain;

public class ConfigurationManager {
    static MatrixDiscordMain plugin;
    public ConfigurationManager(MatrixDiscordMain plugin) {
        this.plugin = plugin;
    }

    public void loadlocalConfiguration() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        plugin.saveConfig();
    }
}
