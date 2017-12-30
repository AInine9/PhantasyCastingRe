package hugu1026.com.github.phantasycastingre.listener;

import hugu1026.com.github.phantasycastingre.caster.Casting;
import hugu1026.com.github.phantasycastingre.caster.Inscription;
import hugu1026.com.github.phantasycastingre.gui.CastingGui;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerInteract implements Listener {

    @EventHandler
    public void PlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK
                || event.getHand() != EquipmentSlot.HAND) {
            return;
        }

        Casting casting = new Casting();
        Inscription inscription = new Inscription();

        if (casting.canCast(block, player)) {
            CastingGui castingGui = new CastingGui();
            castingGui.openInventory(player);
        }

        if (inscription.canCast(block, player)) {
            inscription.onInscription(player);
        }
    }
}