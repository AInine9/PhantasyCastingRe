package hugu1026.com.github.phantasycastingre.caster;

import hugu1026.com.github.phantasycastingre.event.InscriptEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public class Inscription extends Caster {

    @Override
    public boolean canCast(Block block, Player player) {
        return block != null
                && block.getType() == Material.IRON_PLATE
                && block.getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_ORE
                && super.hasMass(player);
    }

    public void onInscription(Player player) {
        if (!(player.getInventory().getItemInMainHand().getItemMeta()
                .getLore().contains(""))) {
            InscriptEvent inscriptEvent = new InscriptEvent(player);
            Bukkit.getServer().getPluginManager().callEvent(inscriptEvent);
        } else {
            player.sendMessage(ChatColor.RED + "前の工程を飛ばしているぞ！");
        }
    }
}