package me.gezelligheid.eventsplugin;

import me.gezelligheid.eventsplugin.Events.SheepHitEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new SheepHitEvents(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
