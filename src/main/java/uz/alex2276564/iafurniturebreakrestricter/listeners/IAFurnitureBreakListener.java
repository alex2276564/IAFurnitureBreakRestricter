package uz.alex2276564.iafurniturebreakrestricter.listeners;

import dev.lone.itemsadder.api.Events.FurnitureBreakEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import uz.alex2276564.iafurniturebreakrestricter.events.PlayerIAFurnitureBreakEvent;

public class IAFurnitureBreakListener implements Listener {

    @EventHandler
    public void onIA(FurnitureBreakEvent event) {
        Player player = event.getPlayer();

        final PlayerIAFurnitureBreakEvent e = new PlayerIAFurnitureBreakEvent(player);
        Bukkit.getPluginManager().callEvent(e);
        if(e.isCancelled()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void on(PlayerIAFurnitureBreakEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPermission("ia.furniture.break")) {
            event.setCancelled(true);
        }
    }
}
