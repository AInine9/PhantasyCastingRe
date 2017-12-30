package hugu1026.com.github.phantasycastingre.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CastingGui extends Gui {

    private ItemStack SWORD, HELMET, CHEST_PLATE, LEGGINGS, BOOTS, GLASS;

    public CastingGui() {
        SWORD = super.createItemStack(Material.IRON_SWORD, ChatColor.LIGHT_PURPLE + "武器を作る", null, 1);
        HELMET = super.createItemStack(Material.IRON_HELMET, ChatColor.LIGHT_PURPLE + "ヘルメットを作る", null, 1);
        CHEST_PLATE = super.createItemStack(Material.IRON_CHESTPLATE, ChatColor.LIGHT_PURPLE + "チェストプレートを作る", null, 1);
        LEGGINGS = super.createItemStack(Material.IRON_LEGGINGS, ChatColor.LIGHT_PURPLE + "レギンスを作る", null, 1);
        BOOTS = super.createItemStack(Material.IRON_BOOTS, ChatColor.LIGHT_PURPLE + "ブーツを作る", null, 1);
        GLASS = super.createItemStack(Material.STAINED_GLASS_PANE, ChatColor.LIGHT_PURPLE + " ", null, 1);

        super.createInventory(this, 2 * 9, "鋳造台");
    }

    @Override
    public void openInventory(Player player) {
        super.setInventory(SWORD, 9);
        super.setInventory(GLASS, 10);
        super.setInventory(HELMET, 11);
        super.setInventory(GLASS, 12);
        super.setInventory(CHEST_PLATE, 13);
        super.setInventory(GLASS, 14);
        super.setInventory(LEGGINGS, 15);
        super.setInventory(GLASS, 16);
        super.setInventory(BOOTS, 17);
        super.openInventory(player);
    }

    public ItemStack getSWORD() {
        return SWORD;
    }

    public ItemStack getHELMET() {
        return HELMET;
    }

    public ItemStack getCHEST_PLATE() {
        return CHEST_PLATE;
    }

    public ItemStack getLEGGINGS() {
        return LEGGINGS;
    }

    public ItemStack getBOOTS() {
        return BOOTS;
    }

    public ItemStack getGLASS() {
        return GLASS;
    }
}