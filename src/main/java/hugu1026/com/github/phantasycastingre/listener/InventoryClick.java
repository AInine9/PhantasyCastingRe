package hugu1026.com.github.phantasycastingre.listener;

import hugu1026.com.github.phantasycastingre.caster.Casting;
import hugu1026.com.github.phantasycastingre.gui.CastingGui;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

    @EventHandler
    public void InventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        if (inventory == null) return;

        if (!(inventory.getHolder() instanceof CastingGui)) return;

        if (!(event.getWhoClicked() instanceof Player)) return;

        CastingGui castingGui = (CastingGui) event.getInventory().getHolder();
        ItemStack clickedItem = event.getCurrentItem();
        String type = null;

        if (clickedItem != null) {
            if (clickedItem.equals(castingGui.getSWORD())) {
                type = "Weapon";
            }
            else if (clickedItem.equals(castingGui.getHELMET())) {
                type = "Helmet";
            }
            else if (clickedItem.equals(castingGui.getCHEST_PLATE())) {
                type = "ChestPlate";
            }
            else if (clickedItem.equals(castingGui.getLEGGINGS())) {
                type = "Leggings";
            }
            else if (clickedItem.equals(castingGui.getBOOTS())) {
                type = "Boots";
            }
            else if (clickedItem.equals(castingGui.getGLASS())) {
                event.setCancelled(true);
                return;
            }
            else {
                return;
            }
            event.setCancelled(true);

            Casting casting = new Casting();

            Player player = (Player) event.getWhoClicked();

            casting.onCasting(inventory, type, player);
        }
    }
}