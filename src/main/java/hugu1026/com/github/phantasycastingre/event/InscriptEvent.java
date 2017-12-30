package hugu1026.com.github.phantasycastingre.event;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class InscriptEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private int original_power;
    private int original_sharpness;
    private int melting;
    private int polishing;
    private String genre;
    private Material type;

    public InscriptEvent(Player player) {
        this.player = player;
        ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();
        List<String> lore = itemMeta.getLore();

        //各値を説明文から取得
        String lore0 = itemMeta.getLore().get(0).replace("QPXFS", "");
        lore0 = ChatColor.stripColor(lore0);
        original_power = Integer.parseInt(lore0);

        String lore1 = itemMeta.getLore().get(1).replace("NFMUJOH UFNQFSBUVSF", "");
        lore1 = ChatColor.stripColor(lore1);
        melting = Integer.parseInt(lore1);

        String lore2 = itemMeta.getLore().get(2).replace("GPSHJOH UJNFT", "");
        lore2 = ChatColor.stripColor(lore2);
        int forging = Integer.parseInt(lore2);

        String lore3 = itemMeta.getLore().get(3).replace("IBSEFOJOH UFNQFSBUVSF", "");
        lore3 = ChatColor.stripColor(lore3);
        int hardening = Integer.parseInt(lore3);

        String lore4 = itemMeta.getLore().get(4).replace("QPMJTIJOH UJNFT", "");
        lore4 = ChatColor.stripColor(lore4);
        polishing = Integer.parseInt(lore4);

        String lore5 = itemMeta.getLore().get(5).replace("TIBSQOFTT", "");
        lore5 = ChatColor.stripColor(lore5);
        original_sharpness = Integer.parseInt(lore5);

        //平均値からジャンルを決定
        int result;
        result = (forging + hardening) / 2;

        if (75 <= result && result < 120) {
            genre = "ウォーハンマー";
        } else if (result < 170) {
            genre = "アックス";
        } else if (result < 217) {
            genre = "ハルバード";
        } else if (result < 267) {
            genre = "クレイモア";
        } else if (result < 315) {
            genre = "メイス";
        } else if (result < 365) {
            genre = "ロングソード";
        } else if (result < 412) {
            genre = "サイス";
        } else if (result < 462) {
            genre = "ソードブレイカー";
        } else if (result < 510) {
            genre = "ソード";
        } else if (result < 560) {
            genre = "カタナ";
        } else if (result < 607) {
            genre = "スピア";
        } else if (result < 657) {
            genre = "ファルカタ";
        } else if (result < 705) {
            genre = "レイピア";
        } else if (result < 755) {
            genre = "ダガー";
        } else if (result < 800) {
            genre = "クロー";
        } else {
            genre = "ボロボロの塊";
        }

        //作るタイプを判断
        String lore6 = itemMeta.getLore().get(6);
        lore6 = ChatColor.stripColor(lore6);

        switch (lore6) {
            case "Weapon":
                type = Material.IRON_SWORD;
                break;
            case "Helmet":
                type = Material.IRON_HELMET;
                break;
            case "ChestPlate":
                type = Material.IRON_CHESTPLATE;
                break;
            case "Leggings":
                type = Material.IRON_LEGGINGS;
                break;
            case "Boots":
                type = Material.IRON_BOOTS;
                break;
        }
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public int getOriginal_sharpness() {
        return original_sharpness;
    }

    public int getMelting() {
        return melting;
    }

    public int getOriginal_power() {
        return original_power;
    }

    public int getPolishing() {
        return polishing;
    }

    public Material getType() {
        return type;
    }

    public Player getPlayer() {
        return player;
    }

    public String getGenre() {
        return genre;
    }
}