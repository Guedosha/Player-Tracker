package com.guedosha.playertracker.events;

import com.guedosha.playertracker.Playertracker;
import com.guedosha.playertracker.functionality.CustomConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerDiedEvent implements Listener {

    Plugin plugin = Playertracker.getPlugin(Playertracker.class);

    @EventHandler
    public void PlayerDieEvent(PlayerDeathEvent e) {
        String p = e.getEntity().getPlayer().getName();
        String c = String.valueOf(e.getEntity().getLastDeathLocation());
        String cause = String.valueOf(e.getEntity().getLastDamageCause());
        plugin.getLogger().info("| Player Died |");
        plugin.getLogger().info("Player: " + p);
        plugin.getLogger().info("Coordinates: " + c);
        plugin.getLogger().info("Cause: " + cause);
        long date = new Date().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        CustomConfig.get().addDefault(String.valueOf(date), p + ", " + c + ", " + "Cause: " + cause);
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();
    }
}
