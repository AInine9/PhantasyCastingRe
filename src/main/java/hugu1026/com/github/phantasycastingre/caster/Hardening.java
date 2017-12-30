package hugu1026.com.github.phantasycastingre.caster;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Cauldron;

import java.util.List;

public class Hardening extends Caster {

    public Hardening(Player player, Block block, String message, AsyncPlayerChatEvent event) {
        if (canCast(block, player)) {
            event.setCancelled(true);

            if (super.isInt(message, player)) {

                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                List<String> lore = meta.getLore();

                if (!(lore.get(2).equals(""))) {
                    lore.set(3, ChatColor.YELLOW + message + "IBSEFOJOH UFNQFSBUVSF");
                    meta.setLore(lore);

                    player.getInventory().getItemInMainHand().setItemMeta(meta);

                    player.sendMessage(ChatColor.GOLD + "最後に研磨台に視線を合わせ、研磨を何回行うかを決めよう");
                } else {
                    player.sendMessage(ChatColor.RED + "前の工程を飛ばしているぞ！");
                }
            }
        }
    }

    @Override
    public boolean canCast(Block block, Player player) {
        if (block != null && block.getType() == Material.CAULDRON) {
            Cauldron cauldron = (Cauldron) block.getState().getData();
            return cauldron.isFull() && super.hasMass(player);
        } else {
            return false;
        }
    }
}