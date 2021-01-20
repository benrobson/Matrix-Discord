package me.benrobson.MatrixDiscord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.Listener;

import javax.security.auth.login.LoginException;

public class DiscordMain extends ListenerAdapter implements Listener {
    private static DiscordMain instance;
    public static JDA jda;
    private MatrixDiscordMain plugin;

    public DiscordMain(MatrixDiscordMain plugin) {
        instance = this;
        this.plugin = plugin;

        if (startBot()) {
//            registerDiscordEventListeners();
        }
    }

//    private void registerDiscordEventListeners() {
//        this.jda.addEventListener(this);
//    }

    //
    // Start the Discord side bot
    //
    private boolean startBot() {
        try {
            // Build JDA/bot connection
            jda = JDABuilder.createDefault(plugin.getConfig().getString("discordapitoken")).build();
            // Show signs of life
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + plugin.getDescription().getName() +" is now connected to Discord.\nConnected Discord Server Name: " + ChatColor.YELLOW + jda.getGuilds()));
            return true;
        } catch (LoginException e) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + plugin.getDescription().getName() + " has encountered an error and can't login to Discord. The Discord Token may not be set, Discord integrations might not function."));
        }
        return false;
    }
}
