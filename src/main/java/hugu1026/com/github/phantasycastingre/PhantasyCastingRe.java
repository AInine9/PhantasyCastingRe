package hugu1026.com.github.phantasycastingre;

import hugu1026.com.github.phantasycastingre.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PhantasyCastingRe extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();

        registerEvents();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerInteract(), this);
        pm.registerEvents(new InventoryClick(), this);
        pm.registerEvents(new InventoryClose(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new Inscript(), this);
    }
}