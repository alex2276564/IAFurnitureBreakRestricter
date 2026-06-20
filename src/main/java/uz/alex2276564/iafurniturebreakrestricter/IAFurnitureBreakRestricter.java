package uz.alex2276564.iafurniturebreakrestricter;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import uz.alex2276564.iafurniturebreakrestricter.listeners.IAFurnitureBreakListener;
import uz.alex2276564.iafurniturebreakrestricter.utils.HttpUtils;
import uz.alex2276564.iafurniturebreakrestricter.utils.UpdateChecker;
import uz.alex2276564.iafurniturebreakrestricter.utils.runner.FoliaRunner;
import uz.alex2276564.iafurniturebreakrestricter.utils.runner.Runner;

import java.util.logging.Level;

public final class IAFurnitureBreakRestricter extends JavaPlugin {

    @Getter
    private Runner runner;

    @Getter
    private HttpUtils httpUtils;

    @Override
    public void onEnable() {
        try {
            setupRunner();
            setupHttpClient();
            registerListeners();
            checkUpdates();

            getLogger().info("IAFurnitureBreakRestricter has been enabled successfully!");
        } catch (Exception e) {
            getLogger().log(Level.SEVERE, "Failed to enable IAFurnitureBreakRestricter", e);
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    private void setupRunner() {
        runner = new FoliaRunner(this);
        getLogger().info("Initialized " + runner.getPlatformName() + " scheduler support");

        if (runner.isFolia()) {
            getLogger().info("Folia detected - using RegionScheduler and EntityScheduler for optimal performance");
        }
    }

    private void setupHttpClient() {
        this.httpUtils = new HttpUtils();
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new IAFurnitureBreakListener(), this);
    }

    private void checkUpdates() {
        UpdateChecker updateChecker = new UpdateChecker(this, "alex2276564/IAFurnitureBreakRestricter", runner, httpUtils);
        updateChecker.checkForUpdates();
    }

    @Override
    public void onDisable() {
        if (runner != null) {
            runner.cancelAllTasks();
        }
    }
}
