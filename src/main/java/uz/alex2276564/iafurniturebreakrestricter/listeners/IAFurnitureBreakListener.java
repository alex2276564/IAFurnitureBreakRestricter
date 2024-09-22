package uz.alex2276564.iafurniturebreakrestricter.listeners;

import dev.lone.itemsadder.api.Events.FurnitureBreakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class IAFurnitureBreakListener implements Listener {

    @EventHandler
    private void onIA(FurnitureBreakEvent event) {

        if (!event.getPlayer().hasPermission("ia.furniture.break")) {

            event.setCancelled(true);
        }
    }
}
