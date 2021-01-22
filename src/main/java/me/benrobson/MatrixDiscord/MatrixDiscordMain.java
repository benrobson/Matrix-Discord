package me.benrobson.MatrixDiscord;

import me.benrobson.MatrixDiscord.events.PlayerViolationCommand;
import me.rerere.matrix.api.MatrixAPI;
import me.rerere.matrix.api.MatrixAPIProvider;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MatrixDiscordMain extends JavaPlugin {
    public static MatrixDiscordMain plugin;
    public ConfigurationManager configurationManager;

    MatrixAPI api = MatrixAPIProvider.getAPI();

    @Override
    public void onEnable() {
        plugin = this;
        loadConfigurationManager();

        // Init Message
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\n" + plugin.getDescription().getName() + " has been enabled.\nRunning Version " + plugin.getDescription().getVersion() + "\nGitHub Repository: https://github.com/benrobson/MatrixDiscord/\nCreated by " + plugin.getDescription().getAuthors() + "\n\n");

        // Event Registry
        PluginManager pluginmanager = plugin.getServer().getPluginManager();
//        pluginmanager.registerEvents(new PlayerViolation(this), this);
        pluginmanager.registerEvents(new PlayerViolationCommand(this), this);

        DiscordMain DiscordMain = new DiscordMain(this);
        saveConfig();
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\n" + plugin.getDescription().getName() + " has been disabled. \n\n");
    }

    public void loadConfigurationManager() {
        configurationManager = new ConfigurationManager(plugin);
        configurationManager.loadlocalConfiguration(); // Loading the config.yml
    }

}
