package me.benrobson.MatrixDiscord.events;

import me.benrobson.MatrixDiscord.DiscordMain;
import me.benrobson.MatrixDiscord.MatrixDiscordMain;
import me.rerere.matrix.api.events.PlayerViolationCommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.awt.*;

public class PlayerViolation implements Listener {
    private static MatrixDiscordMain plugin;
    public PlayerViolation(MatrixDiscordMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerViolation(PlayerViolationCommandEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Player Violation");
        embed.setColor(Color.YELLOW);
        embed.setDescription(event.getPlayer().getDisplayName() + "has been flagged for " + event.getHackType());
        embed.setFooter("MatrixToDiscord");

        TextChannel textChannel = DiscordMain.jda.getTextChannelsByName(plugin.getConfig().getString("matrixnotificationchannel"), true).get(0);
        textChannel.sendMessage(embed.build()).queue();
    }

}
