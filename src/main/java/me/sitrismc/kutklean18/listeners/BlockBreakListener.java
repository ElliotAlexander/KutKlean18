package me.sitrismc.kutklean18.listeners;

import me.sitrismc.kutklean18.KutKlean;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by linse_000 on 11/28/2014.
 */
public class BlockBreakListener implements Listener {

    KutKlean plugin;

    public BlockBreakListener(KutKlean plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (!plugin.isRunning()) {
            return;
        }

        if (event.isCancelled()) {
            return;
        }

        if (event.getPlayer().getGameMode() != GameMode.SURVIVAL) {
            return;
        }

        Block b = event.getBlock();
        World w = b.getWorld();
        Location l = b.getLocation();

        if (b.getType() == Material.IRON_ORE) {
            event.setCancelled(true);
            b.setType(Material.AIR);
            w.dropItemNaturally(l, new ItemStack(Material.IRON_INGOT));
            ExperienceOrb orb = w.spawn(l, ExperienceOrb.class);
            orb.setExperience(1);
        } else if (b.getType() == Material.GOLD_ORE) {
            event.setCancelled(true);
            b.setType(Material.AIR);
            w.dropItemNaturally(l, new ItemStack(Material.GOLD_INGOT));
            ExperienceOrb orb = w.spawn(l, ExperienceOrb.class);
            orb.setExperience(1);
        }
    }
}
