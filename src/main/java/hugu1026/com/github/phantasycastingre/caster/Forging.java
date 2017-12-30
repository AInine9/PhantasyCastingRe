package hugu1026.com.github.phantasycastingre.caster;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Forging extends Caster {

    public Forging(Player player, Block block, String message, AsyncPlayerChatEvent event) {
        if (canCast(block, player)) {
            event.setCancelled(true);
            if (super.isInt(message, player)) {

                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                List<String> lore = meta.getLore();

                if (!(lore.get(1).equals(""))) {
                    lore.set(2, ChatColor.YELLOW + message + "GPSHJOH UJNFT");
                    meta.setLore(lore);

                    player.getInventory().getItemInMainHand().setItemMeta(meta);

                    player.sendMessage(ChatColor.GOLD + "次は大釜に視線を合わし、冷却水を何度にして冷やすかを決めよう");
                } else {
                    player.sendMessage(ChatColor.RED + "前の工程を飛ばしているぞ！");
                }
            }
        }
    }

    @Override
    public boolean canCast(Block block, Player player) {
        return block != null
                && super.hasMass(player)
                && block.getType() == Material.ANVIL
                && block.getRelative(BlockFace.SOUTH).getType() == Material.IRON_BLOCK
                || block.getRelative(BlockFace.EAST).getType() == Material.IRON_BLOCK
                || block.getRelative(BlockFace.NORTH).getType() == Material.IRON_BLOCK
                || block.getRelative(BlockFace.WEST).getType() == Material.IRON_BLOCK;
    }
}
