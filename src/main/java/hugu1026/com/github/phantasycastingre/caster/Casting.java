package hugu1026.com.github.phantasycastingre.caster;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static hugu1026.com.github.phantasycastingre.manager.materialList.getMaterialList;

public class Casting extends Caster {

    @Override
    public boolean canCast(Block block, Player player) {
        return block != null
                && block.getType() == Material.GOLD_PLATE
                && block.getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK;
    }

    public void onCasting(Inventory inventory, String type, Player player) {
        String[] names = new String[9];
        Material[] materials = new Material[9];

        for (int i = 0; i < 9; i++) {
            ItemStack itemStack = inventory.getItem(i);

            if (itemStack != null) {
                if (itemStack.getItemMeta().getDisplayName() != null) {
                    names[i] = ChatColor.stripColor(itemStack.getItemMeta().getDisplayName());
                    materials[i] = itemStack.getType();
                } else {
                    player.sendMessage(ChatColor.RED + "そのアイテムは素材に出来ないぞ");
                    return;
                }
            } else {
                player.sendMessage(ChatColor.RED + "素材が足りない！");
                return;
            }
        }

        int original_power = 0;
        int original_sharpness = 0;
        int materialPower;
        int materialSharpness;
        Map<String, Map<Integer, Integer>> materialList = getMaterialList();

        for (String materialName : names) {
            if (!(materialList.containsKey(materialName))) {
                player.sendMessage(ChatColor.RED + "そのアイテムは素材に出来ないぞ");
                return;
            }
            for (String key : materialList.keySet()) {
                String name = key;
                if (materialName.equals(name)) {
                    Map<Integer, Integer> materialPerformance = materialList.get(name);
                    for (int keyy : materialPerformance.keySet()) {
                        materialPower = keyy;
                        materialSharpness = materialPerformance.get(keyy);
                        int random = new java.util.Random().nextInt(3) + 1;
                        original_power = materialPower + random + original_power;
                        original_sharpness = materialSharpness + random + original_power;
                    }
                }
            }
        }

        inventory.clear();
        player.closeInventory();

        List<String> lore = new ArrayList<>();

        Material material = Material.BLAZE_ROD;
        int amount = 1;
        String name = ChatColor.LIGHT_PURPLE + "金属の塊";
        lore.add(0, ChatColor.YELLOW + String.valueOf(original_power) + "QPXFS");
        lore.add(1, "");
        lore.add(2, "");
        lore.add(3, "");
        lore.add(4, "");
        lore.add(5, ChatColor.YELLOW + String.valueOf(original_sharpness) + "TIBSQOFTT");
        lore.add(6, ChatColor.YELLOW + type);

        ItemStack mass = new ItemStack(material, amount);
        ItemMeta itemMeta = mass.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        mass.setItemMeta(itemMeta);

        player.getInventory().addItem(mass);
        player.sendMessage(ChatColor.GOLD + "入手した金属の塊を手に持って積沸し台に視点を合わし、何度まで上昇させるかをチャットに入力しよう");
    }
}