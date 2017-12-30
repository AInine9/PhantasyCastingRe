package hugu1026.com.github.phantasycastingre.listener;

import hugu1026.com.github.phantasycastingre.caster.*;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashSet;
import java.util.Set;

public class PlayerChat implements Listener {
    private static Set<Class<? extends Caster>> numberCasterClass;

    static {
        numberCasterClass = new HashSet<>();

        numberCasterClass.add(Melting.class);
        numberCasterClass.add(Forging.class);
        numberCasterClass.add(Hardening.class);
        numberCasterClass.add(Polishing.class);
    }

    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Block block = player.getTargetBlock((Set<Material>) null, 5);
        String message = event.getMessage();

        numberCasterClass.stream().forEach(c -> {
            try {
                c.getConstructor(Player.class, Block.class, String.class, AsyncPlayerChatEvent.class).newInstance(player, block, message, event);
            } catch (Exception ex) {
                return;
            }
        });
    }
}