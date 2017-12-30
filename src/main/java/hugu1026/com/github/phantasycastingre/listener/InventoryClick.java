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
        if (event.getInventory() == null
                || !(event.getClickedInventory().getHolder() instanceof CastingGui)) {
            return;
        }

        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        switch (event.getSlot()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                event.setCancelled(true);

                Casting casting = new Casting();

                Player player = (Player) event.getWhoClicked();
                CastingGui castingGui = (CastingGui) event.getInventory().getHolder();
                ItemStack clickedItem = event.getCurrentItem();
                Inventory inventory = event.getInventory();
                String type = null;

                if (clickedItem.equals(castingGui.getSWORD())) {
                    type = "Weapon";
                }

                if (clickedItem.equals(castingGui.getHELMET())) {
                    type = "Helmet";
                }

                if (clickedItem.equals(castingGui.getCHEST_PLATE())) {
                    type = "ChestPlate";
                }

                if (clickedItem.equals(castingGui.getLEGGINGS())) {
                    type = "Leggings";
                }

                if (clickedItem.equals(castingGui.getBOOTS())) {
                    type = "Boots";
                }

                if (clickedItem.equals(castingGui.getGLASS())) {
                    return;
                }

                casting.onCasting(inventory, type, player);

                break;
        }
    }
}