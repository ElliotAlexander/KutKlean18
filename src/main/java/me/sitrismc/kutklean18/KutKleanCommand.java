package me.sitrismc.kutklean18;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by linse_000 on 11/28/2014.
 */
public class KutKleanCommand implements CommandExecutor {

    KutKlean plugin;

    public KutKleanCommand(KutKlean plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            help(sender);
            return false;
        }

        if (args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("on")) {
            if (plugin.isRunning()) {
                sender.sendMessage(plugin.getPrefix() + "Already enabled!");
                return false;
            }
            plugin.setRunning(true);
            plugin.broadcast("Enabled by " + plugin.getMainId() + sender.getName());
            return true;
        }
        if (args[0].equalsIgnoreCase("disable") || args[0].equalsIgnoreCase("off")) {
            if (!plugin.isRunning()) {
                sender.sendMessage(plugin.getPrefix() + "Already disabled!");
                return false;
            }
            plugin.setRunning(false);
            plugin.broadcast("Disabled by " + plugin.getMainId() + sender.getName());
            return true;
        }
        if (args[0].equalsIgnoreCase("toggle")) {
            if (!plugin.isRunning()) {
                plugin.setRunning(true);
                plugin.broadcast("Enabled by " + plugin.getMainId() + sender.getName());
            } else {
                plugin.setRunning(false);
                plugin.broadcast("Disabled by " + plugin.getMainId() + sender.getName());
            }
            return true;
        }
        if (args[0].equalsIgnoreCase("state")) {
            sender.sendMessage(plugin.getPrefix() + (plugin.isRunning() ? ChatColor.GREEN + "Enabled!" : ChatColor.RED + "Disabled!"));
            return true;
        }
        help(sender);
    return false;
    }

    public void help(CommandSender sender) {
        sender.sendMessage(plugin.getPrefix() + "Commands");
        sender.sendMessage(plugin.getMainId() + "/kutklean enable " + plugin.getTextId() + "- Enables KutKlean");
        sender.sendMessage(plugin.getMainId() + "/kutklean disable " + plugin.getTextId() + "- Disables KutKlean");
        sender.sendMessage(plugin.getMainId() + "/kutklean toggle " + plugin.getTextId() + "- Toggles KutKlean");
        sender.sendMessage(plugin.getMainId() + "/kutklean state " + plugin.getTextId() + "- Views state");
    }
}
