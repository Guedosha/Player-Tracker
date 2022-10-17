package com.guedosha.playertracker.events;

import com.guedosha.playertracker.Playertracker;
import com.guedosha.playertracker.functionality.CustomConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.Plugin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerSleepEvent implements Listener {

    Plugin plugin = Playertracker.getPlugin(Playertracker.class);

    @EventHandler
    public void PlayerSleptEvent(PlayerBedLeaveEvent e) {
        Player p = e.getPlayer();
        String name = p.getName();
        String location = String.valueOf(p.getLocation());
        String coordinatesX = String.valueOf(p.getLocation().getX());
        String coordinatesY = String.valueOf(p.getLocation().getY());
        String coordinatesZ = String.valueOf(p.getLocation().getZ());
        Boolean log = plugin.getConfig().getBoolean("LogPlayerSleep");
        int time = (int) p.getWorld().getTime();
        int timeframe1 = 12000;
        int timeframe2 = 0;
        if (time <= timeframe1) {
            if (time >= timeframe2) {
                plugin.getLogger().info("| Player Slept |");
                plugin.getLogger().info("Name: " + name);
                plugin.getLogger().info("Coordinates: " + coordinatesX + ", " + coordinatesY + ", " + coordinatesZ);
                plugin.getLogger().info("Verbose: " + location);
                long date = new Date().getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                CustomConfig.get().addDefault(String.valueOf(date), "Player Slept: " + name + ", " + coordinatesX + ", " + coordinatesY + ", " + coordinatesZ + ", " + "Verbose: " + location);
                CustomConfig.get().options().copyDefaults(true);
                CustomConfig.save();
            }
        }
    }
}
