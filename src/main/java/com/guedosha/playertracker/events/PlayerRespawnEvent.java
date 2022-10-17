package com.guedosha.playertracker.events;

import com.guedosha.playertracker.Playertracker;
import com.guedosha.playertracker.functionality.CustomConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerRespawnEvent implements Listener {

    Plugin plugin = Playertracker.getPlugin(Playertracker.class);

    @EventHandler
    public void onPlayerRespawn(org.bukkit.event.player.PlayerRespawnEvent e) {
        String name = e.getPlayer().getName();
        String respawnLocationX = String.valueOf(e.getRespawnLocation().getBlockX());
        String respawnLocationY = String.valueOf(e.getRespawnLocation().getBlockY());
        String respawnLocationZ = String.valueOf(e.getRespawnLocation().getBlockZ());
        String respawnWorld = e.getRespawnLocation().getWorld().getName();
        String verbose = String.valueOf(e.getRespawnLocation());
        Boolean log = plugin.getConfig().getBoolean("LogPlayerRespawn");
        long date = new Date().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        CustomConfig.get().addDefault(String.valueOf(date), "Player Respawned: " + name + ", " + respawnLocationX + ", " + respawnLocationY + ", " + respawnLocationZ + ", " + "Verbose: " + verbose + " World: " + respawnWorld);
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();
        plugin.getLogger().info("| Player Respawn |");
        plugin.getLogger().info("Name: " + name);
        plugin.getLogger().info("Respawn Location: " + respawnLocationX + ", " + respawnLocationY + ", " + respawnLocationZ);
        plugin.getLogger().info("Respawn World: " + respawnWorld);
        plugin.getLogger().info("Verbose: " + verbose);
    }
}
