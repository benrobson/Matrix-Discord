package me.benrobson.MatrixDiscord.events;

import me.benrobson.MatrixDiscord.DiscordMain;
import me.benrobson.MatrixDiscord.MatrixDiscordMain;
import me.rerere.matrix.api.events.PlayerViolationCommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.awt.*;

public class PlayerViolationCommand implements Listener {
    private static MatrixDiscordMain plugin;
    public PlayerViolationCommand(MatrixDiscordMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerViolation(PlayerViolationCommandEvent event) {
        String MatrixMessage = event.getCommand();

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Player Violation Command Triggered :: " + event.getHackType());
        embed.setColor(Color.YELLOW);
        embed.setDescription(MatrixMessage.substring(MatrixMessage.indexOf(" ") + 1));
        embed.addField("Name", event.getPlayer().getDisplayName(), true);
        embed.setFooter("MatrixToDiscord");

        TextChannel textChannel = DiscordMain.jda.getTextChannelsByName(plugin.getConfig().getString("matrixnotificationchannel"), true).get(0);
        textChannel.sendMessage(embed.build()).queue();
    }

}
