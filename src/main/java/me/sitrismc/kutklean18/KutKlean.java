package me.sitrismc.kutklean18;

import me.sitrismc.kutklean18.listeners.BlockBreakListener;
import me.sitrismc.kutklean18.listeners.EntityDeathListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by linse_000 on 11/28/2014.
 */
public class KutKlean extends JavaPlugin {

    FileConfiguration config = getConfig();

    private ChatColor bracketId = ChatColor.DARK_GRAY;
    private ChatColor mainId = ChatColor.YELLOW;
    private ChatColor textId = ChatColor.GRAY;
    private String prefix = bracketId + "[" + mainId + "KutKlean" + bracketId + "] " + textId;
    private boolean running = false;

    public void onEnable() {
        config.options().copyDefaults(true);
        saveConfig();
        load();
        register();
    }

    public void load() {
        setBracketId(config.getString("Bracket ID"));
        setMainId(config.getString("Main ID"));
        setTextId(config.getString("Text ID"));
        setPrefix();
        setRunning(config.getBoolean("Running"));
    }

    public void register() {
        getCommand("kutklean").setExecutor(new KutKleanCommand(this));
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EntityDeathListener(this), this);
        pm.registerEvents(new BlockBreakListener(this), this);
    }

    public void broadcast(String msg) {
        Bukkit.broadcastMessage(getPrefix() + msg);
    }

    // GETTERS SETTERS

    public ChatColor getBracketId() {
        return bracketId;
    }

    public void setBracketId(String id) {
        bracketId = ChatColor.getByChar(id);
    }

    public ChatColor getMainId() {
        return mainId;
    }

    public void setMainId(String id) {
        mainId = ChatColor.getByChar(id);
    }

    public ChatColor getTextId() {
        return textId;
    }

    public void setTextId(String id) {
        textId = ChatColor.getByChar(id);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix() {
        prefix = getBracketId() + "[" + getMainId() + "KutKlean" + getBracketId() + "] " + getTextId();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean value) {
        running = value;
        config.set("Running", value);
        saveConfig();
    }
}
