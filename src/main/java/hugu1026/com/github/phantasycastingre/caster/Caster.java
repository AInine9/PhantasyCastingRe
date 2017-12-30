package hugu1026.com.github.phantasycastingre.caster;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public abstract class Caster {

    public abstract boolean canCast(Block block, Player player);

    public boolean hasMass(Player player) {
        ItemStack item = player.getInventory().getItemInMainHand();

        return item != null
                && item.getType() == Material.BLAZE_ROD
                && Objects.equals(item.getItemMeta().getDisplayName(), ChatColor.LIGHT_PURPLE + "金属の塊");
    }

    public boolean isInt(String message, Player player) {
        try {
            Integer.parseInt(message);
            return true;
        } catch (NumberFormatException e) {
            player.sendMessage(ChatColor.RED + "有効な数字を入力してください");
            return false;
        }
    }
}