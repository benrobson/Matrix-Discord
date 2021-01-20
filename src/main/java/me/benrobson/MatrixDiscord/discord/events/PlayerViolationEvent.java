package me.benrobson.MatrixDiscord.discord.events;

import me.benrobson.MatrixDiscord.discord.MatrixDiscordMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerViolationEvent implements Listener {
    MatrixDiscordMain plugin;
    public PlayerViolationEvent(MatrixDiscordMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerViolationEvent(PlayerViolationEvent event) {
        System.out.println(event);
    }
}
