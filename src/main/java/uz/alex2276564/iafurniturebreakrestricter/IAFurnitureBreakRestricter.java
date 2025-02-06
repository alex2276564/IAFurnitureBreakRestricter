package uz.alex2276564.iafurniturebreakrestricter;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import uz.alex2276564.iafurniturebreakrestricter.listeners.IAFurnitureBreakListener;
import uz.alex2276564.iafurniturebreakrestricter.task.BukkitRunner;
import uz.alex2276564.iafurniturebreakrestricter.task.Runner;
import uz.alex2276564.iafurniturebreakrestricter.utils.UpdateChecker;

public final class IAFurnitureBreakRestricter extends JavaPlugin {

    @Getter
    private Runner runner;

    @Override
    public void onEnable() {
        setupRunner();
        registerListeners();
        checkUpdates();
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
