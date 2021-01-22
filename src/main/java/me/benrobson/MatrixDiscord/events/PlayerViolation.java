//package me.benrobson.MatrixDiscord.events;
//
//import me.benrobson.MatrixDiscord.DiscordMain;
//import me.benrobson.MatrixDiscord.MatrixDiscordMain;
//import me.rerere.matrix.api.events.PlayerViolationEvent;
//import net.dv8tion.jda.api.EmbedBuilder;
//import net.dv8tion.jda.api.entities.TextChannel;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//
//import java.awt.*;
//
//public class PlayerViolation implements Listener {
//    private static MatrixDiscordMain plugin;
//    public PlayerViolation(MatrixDiscordMain plugin) {
//        this.plugin = plugin;
//    }
//
//    @EventHandler
//    public void PlayerViolation(PlayerViolationEvent event) {
//        EmbedBuilder embed = new EmbedBuilder();
//        embed.setTitle("Player Violation :: " + event.getHackType());
//        embed.setColor(Color.ORANGE);
//        embed.addField("Name", event.getPlayer().getDisplayName(), true);
//        embed.addField("Violation Lvl", String.valueOf(event.getViolations()), true);
//        embed.setFooter("MatrixToDiscord");
//
//        TextChannel textChannel = DiscordMain.jda.getTextChannelsByName(plugin.getConfig().getString("matrixnotificationchannel"), true).get(0);
//        textChannel.sendMessage(embed.build()).queue();
//    }
//
//}
