package hugu1026.com.github.phantasycastingre.caster;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Melting extends Caster {

    public Melting(Player player, Block block, String message, AsyncPlayerChatEvent event) {
        if (canCast(block, player)) {
            event.setCancelled(true);
            if (super.isInt(message, player)) {

                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                List<String> lore = meta.getLore();

                if (lore.get(1).equals("")) {
                    lore.set(1, ChatColor.YELLOW + String.valueOf(message) + "NFMUJOH UFNQFSBUVSF");
                    meta.setLore(lore);

                    player.getInventory().getItemInMainHand().setItemMeta(meta);
                }

                player.sendMessage(ChatColor.GOLD + "次は金床に視線を合わし、叩く回数を決めよう");
                player.playSound(player.getLocation(), Sound.ENTITY_GHAST_SHOOT, 1, (float) 0.6);
                player.getWorld().spawnParticle(Particle.LAVA, player.getLocation().add(0, 0.5, 0), 20);
            }
        }
    }

    @Override
    public boolean canCast(Block block, Player player) {
        return block != null
                && block.getType() == Material.MAGMA
                && block.getRelative(BlockFace.NORTH).getType() == Material.COBBLESTONE
                && block.getRelative(BlockFace.EAST).getType() == Material.COBBLESTONE
                && block.getRelative(BlockFace.SOUTH).getType() == Material.COBBLESTONE
                && block.getRelative(BlockFace.WEST).getType() == Material.COBBLESTONE
                && block.getRelative(BlockFace.NORTH_EAST).getType() == Material.COBBLESTONE
                && block.getRelative(BlockFace.NORTH_WEST).getType() == Material.COBBLESTONE
                && block.getRelative(BlockFace.SOUTH_EAST).getType() == Material.COBBLESTONE
                && block.getRelative(BlockFace.SOUTH_WEST).getType() == Material.COBBLESTONE
                && super.hasMass(player);
    }
}