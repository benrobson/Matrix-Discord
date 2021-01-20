package me.benrobson.MatrixDiscord.discord;

import me.benrobson.MatrixDiscord.ConfigurationManager;
import me.benrobson.MatrixDiscord.Variables;
import me.rerere.matrix.api.MatrixAPI;
import me.rerere.matrix.api.MatrixAPIProvider;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public class MatrixDiscordMain extends JavaPlugin {
    private static MatrixDiscordMain plugin;
    public ConfigurationManager configurationManager;
    public static JDA jda;

    MatrixAPI MatrixAPI = MatrixAPIProvider.getAPI();

    @Override
    public void onEnable() {
        plugin = this;
        loadConfigurationManager();

        // Init Message
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nMatrix Discord has been enabled.\nRunning Version " + plugin.getDescription().getVersion() + "\nGitHub Repository: https://github.com/benrobson/Matrix-Discord\nCreated by Ben Robson\n\n");

        PluginManager pluginmanager = this.getServer().getPluginManager();

        saveConfig();

        if (startBot()) {
            registerDiscordEventListeners();
        }
    }

    public void loadConfigurationManager() {
        configurationManager = new ConfigurationManager(plugin);
        configurationManager.loadlocalConfiguration(); // Loading the config.yml
    }

    @Override
    public void onDisable() {
        loadConfigurationManager();
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nMatrix Discord has been disabled.\n\n");
    }

    //
    // Start the Discord side bot
    //
    private boolean startBot() {
        try {
            // Build JDA/bot connection
            jda = JDABuilder.createDefault(Variables.discordapitoken).build();
            // Show signs of life
            System.out.println("Matrix Discord is now connected.");
            return true;
        } catch (LoginException e) {
            System.out.println("You did not login correctly.");
        }
        return false;
    }

    private void registerDiscordEventListeners() {
        this.jda.addEventListener(this);
    }
}