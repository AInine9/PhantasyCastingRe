package hugu1026.com.github.phantasycastingre.caster;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Polishing extends Caster {

    public Polishing(Player player, Block block, String message, AsyncPlayerChatEvent event) {
        if (canCast(block, player)) {
            event.setCancelled(true);
            if (super.isInt(message, player)) {

                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                List<String> lore = meta.getLore();

                if (!(lore.get(3).equals(""))) {
                    lore.set(4, ChatColor.YELLOW + message + "QPMJTIJOH UJNFT");
                    meta.setLore(lore);

                    player.getInventory().getItemInMainHand().setItemMeta(meta);

                    player.sendMessage(ChatColor.GOLD + "素材が完成した。心を込めて、銘入れ台をクリックしよう。");
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
                && block.getType() == Material.STONE_PLATE
                && block.getRelative(BlockFace.DOWN).getType() == Material.PRISMARINE;
    }
}