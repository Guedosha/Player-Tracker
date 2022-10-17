package com.guedosha.playertracker.events;

import com.guedosha.playertracker.Playertracker;
import com.guedosha.playertracker.functionality.CustomConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerJoinEvent implements Listener {

    Plugin plugin = Playertracker.getPlugin(Playertracker.class);

    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String coordinates = String.valueOf(p.getLocation());
        String name = p.getDisplayName();
        String coordinatesX = String.valueOf(p.getLocation().getX());
        String coordinatesY = String.valueOf(p.getLocation().getY());
        String coordinatesZ = String.valueOf(p.getLocation().getZ());
        String coordinatesWorld = String.valueOf(p.getWorld());
        Boolean logVerbose = plugin.getConfig().getBoolean("Verbose");
        Boolean logWorld = plugin.getConfig().getBoolean("LogWorld");
        long date = new Date().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        plugin.getLogger().info("| Player Joined |");
        plugin.getLogger().info("Name: " + name);
        plugin.getLogger().info("Coordinates: " + coordinatesX + ", " + coordinatesY + ", " + coordinatesX);
        plugin.getLogger().info("World: " + coordinatesWorld);
        CustomConfig.get().addDefault(String.valueOf(date), "Player Joined: " + name + ", " + coordinatesX + ", " + coordinatesY + ", " + coordinatesZ + ", " + "World: " + coordinatesWorld);
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();
    }
}
