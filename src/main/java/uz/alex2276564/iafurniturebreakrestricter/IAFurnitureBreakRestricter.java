package uz.alex2276564.iafurniturebreakrestricter;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import uz.alex2276564.iafurniturebreakrestricter.listeners.IAFurnitureBreakListener;
import uz.alex2276564.iafurniturebreakrestricter.utils.UpdateChecker;

public final class IAFurnitureBreakRestricter extends JavaPlugin {

    @Override
    public void onEnable() {
        registerListeners();
        checkUpdates();
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new IAFurnitureBreakListener(), this);
    }

    private void checkUpdates() {
        UpdateChecker updateChecker = new UpdateChecker(this, "alex2276564/IAFurnitureBreakRestricter");
        updateChecker.checkForUpdates();
    }
}
