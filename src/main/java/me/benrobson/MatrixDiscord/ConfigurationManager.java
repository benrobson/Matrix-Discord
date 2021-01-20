package me.benrobson.MatrixDiscord;

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
