package ch.minepvp.announcer.config;

import ch.minepvp.announcer.Announcer;
import ch.minepvp.announcer.loader.BukkitLoader;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.List;

public class BukkitConfig implements Config {

    private FileConfiguration config;

    public BukkitConfig() {
        config = ((BukkitLoader)Announcer.getInstance().getCaller().getLoader()).getConfig();
    }

    @Override
    public Boolean getBoolean(String path) {
        return config.getBoolean(path);
    }

    @Override
    public Integer getInt(String path) {
        return config.getInt(path);
    }

    @Override
    public Long getLong(String path) {
        return config.getLong(path);
    }

    @Override
    public Double getDouble(String path) {
        return config.getDouble(path);
    }

    @Override
    public String getString(String path) {
        return config.getString(path);
    }

    @Override
    public List<String> getStringList(String path) {
        return config.getStringList(path);
    }

    @Override
    public Integer getStringListSize(String path) {
        return config.getStringList(path).size();
    }

    @Override
    public Integer getChildrenSize(String path) {
        return config.getConfigurationSection(path).getKeys(false).size();
    }

    @Override
    public void setValue(String path, Object value) {
        config.set(path, value);

        ((BukkitLoader)Announcer.getInstance().getCaller().getLoader()).saveConfig();

    }

    @Override
    public Boolean has(String path) {
        return config.contains(path);
    }

    @Override
    public File getFile() {
        return new File( Announcer.getInstance().getCaller().getDataFolder() , "metrics.yml");
    }

}
