package hugu1026.com.github.phantasycastingre.listener;

import hugu1026.com.github.phantasycastingre.event.InscriptEvent;
import hugu1026.com.github.phantasycastingre.weapon.*;
import net.minecraft.server.v1_10_R1.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Inscript implements Listener {

    @EventHandler
    public void Inscript(InscriptEvent event) {
        Player player = event.getPlayer();
        int original_power = event.getOriginal_power();
        int melting = event.getMelting();
        int polishing = event.getPolishing();
        int original_sharpness = event.getOriginal_sharpness();
        int power_defend = 0, sharp_durability = 0;
        double speed = 0, attackSpeed = 0;
        Material type = event.getType();
        String genre = null;
        if (type == Material.IRON_SWORD) {
            genre = event.getGenre();
        }

        if (genre != null) {
            Weapon weapon = null;
            switch (genre) {
                case "ウォーハンマー":
                    weapon = new WarHammer(original_power, melting, original_sharpness, polishing);
                    break;
                case "アックス":
                    weapon = new Axe(original_power, melting, original_sharpness, polishing);
                    break;
                case "ハルバード":
                    weapon = new Halberd(original_power, melting, original_sharpness, polishing);
                    break;
                case "クレイモア":
                    weapon = new Claymore(original_power, melting, original_sharpness, polishing);
                    break;
                case "メイス":
                    weapon = new Mace(original_power, melting, original_sharpness, polishing);
                    break;
                case "ロングソード":
                    weapon = new LongSword(original_power, melting, original_sharpness, polishing);
                    break;
                case "サイス":
                    weapon = new Size(original_power, melting, original_sharpness, polishing);
                    break;
                case "ソードブレイカー":
                    weapon = new SwordBreaker(original_power, melting, original_sharpness, polishing);
                    break;
                case "ソード":
                    weapon = new Sword(original_power, melting, original_sharpness, polishing);
                    break;
                case "カタナ":
                    weapon = new Katana(original_power, melting, original_sharpness, polishing);
                    break;
                case "スピア":
                    weapon = new Spear(original_power, melting, original_sharpness, polishing);
                    break;
                case "ファルカタ":
                    weapon = new Falcata(original_power, melting, original_sharpness, polishing);
                    break;
                case "レイピア":
                    weapon = new Rapier(original_power, melting, original_sharpness, polishing);
                    break;
                case "ダガー":
                    weapon = new Dagger(original_power, melting, original_sharpness, polishing);
                    break;
                case "クロー":
                    weapon = new Claw(original_power, melting, original_sharpness, polishing);
                    break;
                case "ボロボロの塊":
                    weapon = new CrumblyChunk(original_power, melting, original_sharpness, polishing);
                    break;
            }

            power_defend = weapon.getPower_defend();
            sharp_durability = weapon.getSharp_durability();
            speed = weapon.getSpeed();
            attackSpeed = weapon.getAttackSpeed();

        } else if (genre == null) {
            Armour armour = new Armour(original_power, melting, original_sharpness, polishing);
            power_defend = armour.getPower_defend();
            sharp_durability = armour.getSharp_durability();
        }

        //成果物生成
        List<String> lore = new ArrayList<>();

        if (type == Material.IRON_SWORD) {
            lore.add(0, ChatColor.YELLOW + "ジャンル:" + genre);
            lore.add(1, ChatColor.YELLOW + "攻撃力:" + String.valueOf(power_defend));
            lore.add(2, ChatColor.YELLOW + "切れ味:" + String.valueOf(sharp_durability) + "/" + String.valueOf(sharp_durability));
        } else if (type == Material.IRON_HELMET
                || type == Material.IRON_CHESTPLATE
                || type == Material.IRON_LEGGINGS
                || type == Material.IRON_BOOTS) {
            lore.add(0, ChatColor.YELLOW + "防御力:" + String.valueOf(power_defend));
            lore.add(1, ChatColor.YELLOW + "耐久度:" + String.valueOf(sharp_durability) + "/" + String.valueOf(sharp_durability));
        }

        ItemStack product = new ItemStack(type, 1);
        ItemMeta meta = product.getItemMeta();
        meta.setLore(lore);
        product.setItemMeta(meta);

        net.minecraft.server.v1_10_R1.ItemStack nmsItem =
                CraftItemStack.asNMSCopy(product);
        NBTTagCompound nbtTag = nmsItem.getTag();
        if (nbtTag == null) {
            nbtTag = new NBTTagCompound();
            nmsItem.setTag(nbtTag);
            nbtTag = nmsItem.getTag();
        }
        NBTTagList nbtList = new NBTTagList();

        NBTTagCompound movement_speed = new NBTTagCompound();
        movement_speed.set("AttributeName", new NBTTagString("generic.movementSpeed"));
        movement_speed.set("Slot", new NBTTagString("mainhand"));
        movement_speed.set("Name", new NBTTagString("generic.movementSpeed"));
        movement_speed.set("Amount", new NBTTagDouble(speed));
        movement_speed.set("Operation", new NBTTagInt(0));
        movement_speed.set("UUIDLeast", new NBTTagInt(894654));
        movement_speed.set("UUIDMost", new NBTTagInt(2872));
        nbtList.add(movement_speed);

        NBTTagCompound attack_speed = new NBTTagCompound();
        attack_speed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
        attack_speed.set("Slot", new NBTTagString("mainhand"));
        attack_speed.set("Name", new NBTTagString("generic.attackSpeed"));
        attack_speed.set("Amount", new NBTTagDouble(attackSpeed));
        attack_speed.set("Operation", new NBTTagInt(0));
        attack_speed.set("UUIDLeast", new NBTTagInt(894654));
        attack_speed.set("UUIDMost", new NBTTagInt(2872));
        nbtList.add(attack_speed);

        nbtTag.set("AttributeModifiers", nbtList);
        nmsItem.setTag(nbtTag);

        product = CraftItemStack.asBukkitCopy(nmsItem);

        //プレイヤーへ渡す
        player.sendMessage(ChatColor.GOLD + "鋳造に成功した！");

        if (player.getInventory().getItemInMainHand().getAmount() > 1) {
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
        } else {
            player.getInventory().removeItem(player.getInventory().getItemInMainHand());
        }

        player.getInventory().addItem(product);
    }
}