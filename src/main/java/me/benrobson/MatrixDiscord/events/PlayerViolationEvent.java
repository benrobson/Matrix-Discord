package me.benrobson.MatrixDiscord.events;

import me.benrobson.MatrixDiscord.DiscordMain;
import me.benrobson.MatrixDiscord.MatrixDiscordMain;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.awt.*;

public class PlayerViolationEvent implements Listener {
    private static MatrixDiscordMain plugin;
    public PlayerViolationEvent(MatrixDiscordMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerViolationEvent(PlayerViolationEvent event) {
        System.out.println(event);

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Player Violation");
        embed.setColor(Color.ORANGE);
        embed.addField("Name", "Online", true);

        TextChannel textChannel = DiscordMain.jda.getTextChannelsByName(plugin.getConfig().getString("matrixnotificationchannel"), true).get(0);
        textChannel.sendMessage(embed.build()).queue();
    }

}
