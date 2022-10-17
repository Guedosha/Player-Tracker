package com.guedosha.playertracker.events;

import com.guedosha.playertracker.Playertracker;
import com.guedosha.playertracker.functionality.CustomConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerPortalEvent implements Listener {

    Plugin plugin = Playertracker.getPlugin(Playertracker.class);

    @EventHandler
    public void onPlayerPortalEvent(PlayerTeleportEvent e) {
        String p = e.getPlayer().getName();
        String fromWorld = e.getFrom().getWorld().getName();
        String toWorld = e.getTo().getWorld().getName();
        String fromX = String.valueOf(e.getFrom().getBlockX());
        String fromY = String.valueOf(e.getFrom().getBlockY());
        String fromZ = String.valueOf(e.getFrom().getBlockZ());
        String toX = String.valueOf(e.getTo().getX());
        String toY = String.valueOf(e.getTo().getY());
        String toZ = String.valueOf(e.getTo().getZ());
        String teleportCause = String.valueOf(e.getCause());
        Boolean log = plugin.getConfig().getBoolean("LogPlayerTeleport");
        long date = new Date().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        CustomConfig.get().addDefault(String.valueOf(date), "Player Teleported: " + p + ". From: " + fromWorld + ", " + fromX + ", " + fromY + ", " + fromZ + "to: " + toWorld + ", " + toX + ", " + toY + ", " + toZ + "Cause: " + teleportCause);
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();
        plugin.getLogger().info("| Player Teleported |");
        plugin.getLogger().info("Name: " + p);
        plugin.getLogger().info("From World: " + fromWorld);
        plugin.getLogger().info("To World: " + toWorld);
        plugin.getLogger().info("From: " + fromX + ", " + fromY + ", " + fromZ);
        plugin.getLogger().info("To: " + toX + ", " + toY + ", " + toZ);
        plugin.getLogger().info("Teleport Cause: " + teleportCause);

    }
}

