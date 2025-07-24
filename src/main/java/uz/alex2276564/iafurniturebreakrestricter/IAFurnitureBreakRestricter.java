package uz.alex2276564.iafurniturebreakrestricter;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import uz.alex2276564.iafurniturebreakrestricter.listeners.IAFurnitureBreakListener;
import uz.alex2276564.iafurniturebreakrestricter.utils.runner.BukkitRunner;
import uz.alex2276564.iafurniturebreakrestricter.utils.runner.Runner;
import uz.alex2276564.iafurniturebreakrestricter.utils.UpdateChecker;

public final class IAFurnitureBreakRestricter extends JavaPlugin {

    @Getter
    private Runner runner;

    @Override
    public void onEnable() {
        try {
            setupRunner();
            registerListeners();
            checkUpdates();

            getLogger().info("IAFurnitureBreakRestricter has been enabled successfully!");
        } catch (Exception e) {
            getLogger().severe("Failed to enable IAFurnitureBreakRestricter: " + e.getMessage());
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    private void setupRunner() {
        runner = new BukkitRunner(this);
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new IAFurnitureBreakListener(), this);
    }

    private void checkUpdates() {
        UpdateChecker updateChecker = new UpdateChecker(this, "alex2276564/IAFurnitureBreakRestricter", runner);
        updateChecker.checkForUpdates();
    }

    @Override
    public void onDisable() {
        runner.cancelTasks();
    }
}
