package com.meeku.blockdeleter;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class BlockDeleter extends JavaPlugin {
    public static boolean enabled = false;
    public static int delay = 20;
    public BukkitScheduler scheduler = getServer().getScheduler();

    @Override
    public void onEnable() {
        System.out.println("Block Deleter by MayorMono");

        this.getCommand("bdenable").setExecutor(new Enabler());
        this.getCommand("bddisable").setExecutor(new Disabler());
        this.getCommand("bdsetdelay").setExecutor(new DelaySetter());

        scheduler.scheduleSyncRepeatingTask(this, this::findBlocks, 0L, 1L);
    }

    public void findBlocks() {
        if(enabled) {

            for(Player p : Bukkit.getOnlinePlayers()) {

                if(!(p.getGameMode() == GameMode.SPECTATOR)) {

                    Location l = p.getLocation();
                    l.subtract(0,1,0);

                    Location l1 = new Location(p.getWorld(), l.getX() + 0.3, l.getY(), l.getZ());
                    Location l2 = new Location(p.getWorld(), l.getX() - 0.3, l.getY(), l.getZ());
                    Location l3 = new Location(p.getWorld(), l.getX(), l.getY(), l.getZ() + 0.3);
                    Location l4 = new Location(p.getWorld(), l.getX(), l.getY(), l.getZ() - 0.3);
                    Location l5 = new Location(p.getWorld(), l.getX() + 0.3, l.getY(), l.getZ() + 0.3);
                    Location l6 = new Location(p.getWorld(), l.getX() + 0.3, l.getY(), l.getZ() - 0.3);
                    Location l7 = new Location(p.getWorld(), l.getX() - 0.3, l.getY(), l.getZ() + 0.3);
                    Location l8 = new Location(p.getWorld(), l.getX() - 0.3, l.getY(), l.getZ() - 0.3);

                    Block b1 = l1.getBlock();
                    Block b2 = l2.getBlock();
                    Block b3 = l3.getBlock();
                    Block b4 = l4.getBlock();
                    Block b5 = l5.getBlock();
                    Block b6 = l6.getBlock();
                    Block b7 = l7.getBlock();
                    Block b8 = l8.getBlock();

                    scheduleDelete(b1);
                    scheduleDelete(b2);
                    scheduleDelete(b3);
                    scheduleDelete(b4);
                    scheduleDelete(b5);
                    scheduleDelete(b6);
                    scheduleDelete(b7);
                    scheduleDelete(b8);
                }

            }

        }
    }

    private void scheduleDelete(Block b) {
        Material m = b.getType();
        if(!(m == Material.AIR) && !(m == Material.BEDROCK) && !(m == Material.OBSIDIAN)) {
            scheduler.scheduleSyncDelayedTask(this, new Deleter(b), delay);
        }
    }
}
