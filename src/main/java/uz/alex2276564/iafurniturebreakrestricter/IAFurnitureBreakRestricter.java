package uz.alex2276564.iafurniturebreakrestricter;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import uz.alex2276564.iafurniturebreakrestricter.listeners.IAFurnitureBreakListener;
import uz.alex2276564.iafurniturebreakrestricter.utils.HttpUtils;
import uz.alex2276564.iafurniturebreakrestricter.utils.UpdateChecker;
import uz.alex2276564.iafurniturebreakrestricter.utils.runner.FoliaRunner;
import uz.alex2276564.iafurniturebreakrestricter.utils.runner.Runner;

import java.util.logging.Level;

public final class IAFurnitureBreakRestricter extends JavaPlugin {

    private Runner runner;
    private HttpUtils httpUtils;

    @Override
    public void onEnable() {
        try {
            setupRunner();
            setupHttpClient();
            setupUpdateChecker();
            registerListeners();

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

    private void setupUpdateChecker() {
        UpdateChecker updateChecker;
        updateChecker = new UpdateChecker(
                getDescription().getName(),
                getDescription().getVersion(),
                "alex2276564/IAFurnitureBreakRestricter",
                runner,
                httpUtils,
                getLogger()
        );
        updateChecker.checkForUpdates();
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new IAFurnitureBreakListener(), this);
    }

    @Override
    public void onDisable() {
        if (runner != null) {
            runner.cancelAllTasks();
        }
    }
}
