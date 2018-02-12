package hugu1026.com.github.phantasycastingre.listener;

import hugu1026.com.github.phantasycastingre.gui.CastingGui;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClose implements Listener {

    @EventHandler
    public void InventoryClose(InventoryCloseEvent event) {
        if (event.getInventory().getHolder() instanceof CastingGui) {
            for (int i = 0; i < 9; i++) {
                if (event.getInventory().getItem(i) != null) {
                    ItemStack item = event.getInventory().getItem(i);
                    event.getPlayer().getInventory().addItem(item);
                }
            }
        }
    }
}