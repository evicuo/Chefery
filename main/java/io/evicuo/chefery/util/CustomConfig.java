package io.evicuo.chefery.util;

import io.evicuo.chefery.Chefery;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class CustomConfig {
    private final Chefery plugin;
    private File file;
    private YamlConfiguration config;
    private final String dir;


    public CustomConfig(Chefery plugin, String dir) {
        this.plugin = plugin;
        this.dir = dir;
        create();
    }

    public void create(){
        file = new File(plugin.getDataFolder(), dir);
        if(!file.exists()){
            file.getParentFile().mkdirs();
            plugin.saveResource(dir, false);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration get() {
        return config;
    }

    public void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }

    public void save() {
        try{
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
