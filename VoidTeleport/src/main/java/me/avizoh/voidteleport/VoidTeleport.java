package me.avizoh.voidteleport;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class VoidTeleport extends JavaPlugin {

    public static VoidTeleport instance;
    public File cFile;
    public FileConfiguration config;

    @Override
    public void onEnable() {
        instance = this;
        createConfig();

        getServer().getPluginManager().registerEvents(new TeleportListener(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static VoidTeleport getInstance() {
        return instance;
    }

    public void createConfig() {
        cFile = new File(getDataFolder(), "config.yml");
        if (!cFile.exists()) {
            cFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        config = new YamlConfiguration();
        try {
            config.load(cFile);
        } catch (IOException | InvalidConfigurationException exception) {
            exception.printStackTrace();
        }
    }
}
