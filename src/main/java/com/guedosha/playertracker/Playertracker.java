package com.guedosha.playertracker;

import com.guedosha.playertracker.commands.CommandMessage;
import com.guedosha.playertracker.events.*;
import com.guedosha.playertracker.functionality.CustomConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class Playertracker extends JavaPlugin {
    private static Playertracker plugin;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerDiedEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerSleepEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerPortalEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveEvent(), this);

        getCommand("message").setExecutor(new CommandMessage());

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        plugin = this;

        CustomConfig.setup();
        CustomConfig.get().addDefault("Message", "this is a very sexy message");
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();
    }

    public static Playertracker getPlugin() { return plugin; }

}
