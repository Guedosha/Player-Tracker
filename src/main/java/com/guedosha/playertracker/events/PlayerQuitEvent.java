package com.guedosha.playertracker.events;

import com.guedosha.playertracker.Playertracker;
import com.guedosha.playertracker.functionality.CustomConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.plugin.Plugin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerQuitEvent implements Listener {

    Plugin plugin = Playertracker.getPlugin(Playertracker.class);

    @EventHandler
    public void onQuitEvent(org.bukkit.event.player.PlayerQuitEvent e) {
        Player p = e.getPlayer();
        String coordinates = String.valueOf(p.getLocation());
        String name = p.getName();
        String coordinatesX = String.valueOf(p.getLocation().getX());
        String coordinatesY = String.valueOf(p.getLocation().getY());
        String coordinatesZ = String.valueOf(p.getLocation().getZ());
        String coordinatesWorld = String.valueOf(p.getWorld().getName());
        Boolean logVerbose = plugin.getConfig().getBoolean("Verbose");
        Boolean logWorld = plugin.getConfig().getBoolean("LogWorld");
        long date = new Date().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        CustomConfig.get().addDefault(String.valueOf(date), "Player Left: " + name + ", " + coordinatesX + ", " + coordinatesY + ", " + coordinatesZ + ", " + "World: " + coordinatesWorld);
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();
        if (logVerbose.equals(true)) {
            if (logWorld.equals(true)) {
                plugin.getLogger().info("Player Left at: " + coordinates);
                plugin.getLogger().info("World: " + coordinatesWorld);
                plugin.getLogger().info("Name: " + name);
            } else {
                plugin.getLogger().info("Player Left at: " + coordinatesX + ", " + coordinatesY + ", " + coordinatesZ);
                plugin.getLogger().info("Name: " + name);
            }
        } else if (logVerbose.equals(false)) {
            if (logWorld.equals(true)) {
                plugin.getLogger().info("Player Left at: " + coordinatesX + ", " + coordinatesY + ", " + coordinatesZ);
                plugin.getLogger().info("World: " + coordinatesWorld);
                plugin.getLogger().info("Name: " + name);
            } else {
                plugin.getLogger().info("Player Left at: " + coordinatesX + ", " + coordinatesY + ", " + coordinatesZ);
                plugin.getLogger().info("Name: " + name);
            }
        }
    }
}