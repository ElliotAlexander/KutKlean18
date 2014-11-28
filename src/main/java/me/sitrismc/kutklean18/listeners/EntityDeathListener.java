package me.sitrismc.kutklean18.listeners;

import me.sitrismc.kutklean18.KutKlean;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

/**
 * Created by linse_000 on 11/28/2014.
 */
public class EntityDeathListener implements Listener {

    KutKlean plugin;

    public EntityDeathListener(KutKlean plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (!plugin.isRunning()) {
            return;
        }

        if (event.getEntity() instanceof Player) {
            return;
        }

        if (event.getEntity() instanceof Sheep) {
            event.getDrops().add(new ItemStack(Material.COOKED_MUTTON));
        } else if (event.getEntity() instanceof Cow) {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.COOKED_BEEF, 3));
            event.getDrops().add(new ItemStack(Material.LEATHER, 1));
        } else if (event.getEntity() instanceof Pig) {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.GRILLED_PORK, 3));
        } else if (event.getEntity() instanceof Chicken) {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.COOKED_CHICKEN, 3));
            event.getDrops().add(new ItemStack(Material.FEATHER, 2));
        } else if (event.getEntity() instanceof Rabbit) {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.COOKED_RABBIT, 1));
            event.getDrops().add(new ItemStack(Material.RABBIT_HIDE, 1));
            event.getDrops().add(new ItemStack(Material.RABBIT_FOOT));
        } else if (event.getEntity() instanceof Villager) {
            if (new Random().nextInt(99) < 50) {
                event.getDrops().clear();
                event.getDrops().add(new ItemStack(Material.BOOK, 1));
            }
        } else if (event.getEntity() instanceof Horse) {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.LEATHER, 2));
        } else if (event.getEntity() instanceof PigZombie) {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.GOLD_NUGGET, 1));
            event.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, 1));
        } else if (event.getEntity() instanceof Spider || event.getEntity() instanceof CaveSpider) {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.STRING, 2));
        } else if (event.getEntity() instanceof Zombie) {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, 2));
        } else if (event.getEntity() instanceof Skeleton) {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.ARROW, 2));
            event.getDrops().add(new ItemStack(Material.BONE, 1));
        } else if (event.getEntity() instanceof Creeper) {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.SULPHUR, 2));
        } else if (event.getEntity() instanceof Guardian) {
            event.getDrops().clear();
            event.getDrops().add(new ItemStack(Material.PRISMARINE_SHARD, 1));
            event.getDrops().add(new ItemStack(Material.PRISMARINE_CRYSTALS, 1));
            event.getDrops().add(new ItemStack(Material.COOKED_FISH, 1));
        }
    }
}
