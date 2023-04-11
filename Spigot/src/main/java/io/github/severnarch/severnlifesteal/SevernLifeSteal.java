package io.github.severnarch.severnlifesteal;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

public final class SevernLifeSteal extends JavaPlugin {

    public List<Listener> listeners = List.of();
    public String prefix = ChatColor.translateAlternateColorCodes('&', "&4[&cSevernLifeSteal&4] &7");

    private File playersDataFile;
    private FileConfiguration playersData;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        createPlayersData();
        for (Listener listener : listeners) {
            try {
                getServer().getPluginManager().registerEvents(listener.getClass().getDeclaredConstructor().newInstance(), this);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        Objects.requireNonNull(this.getCommand("severnlifesteal")).setExecutor(new SevernLifeStealCommand());
        Objects.requireNonNull(this.getCommand("severnlifesteal")).setTabCompleter(new SevernLifeStealCommand());
        String[] version = getDescription().getVersion().split("\\.");
        try {
           URL url = new URL("https://raw.githubusercontent.com/Severnarch/SevernLifeSteal/master/Spigot/build.gradle");
           BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
           String inputLine;
           String[] lstVersion = new String[0];
           while ((inputLine = in.readLine()) != null) {
               if (inputLine.startsWith("version = ")) {
                   lstVersion = inputLine.split(" = ")[1].replace("'", "").split("\\.");
                   break;
               }
           }
           in.close();
           assert lstVersion.length != 0;
           // Lower version checking
           if (Integer.parseInt(version[2]) < Integer.parseInt(lstVersion[2])) {
               getLogger().log(Level.WARNING, "Running on a lower patch version than the latest stable release. Updating is not necessary, but recommended.");
           } else if (Integer.parseInt(version[1]) < Integer.parseInt(lstVersion[1])) {
               getLogger().log(Level.WARNING, "Running on a lower minor version than the latest stable release. Please update to the latest version at "+getDescription().getWebsite()+".");
           } else if (Integer.parseInt(version[0]) < Integer.parseInt(lstVersion[0])) {
               getLogger().log(Level.WARNING, "Running on a lower major version than the latest stable release. Please update to the latest version at "+getDescription().getWebsite()+".");
           }
           // Higher version checking
           if (Integer.parseInt(version[2]) > Integer.parseInt(lstVersion[2]) || Integer.parseInt(version[1]) > Integer.parseInt(lstVersion[1]) || Integer.parseInt(version[0]) > Integer.parseInt(lstVersion[0])) {
               getLogger().log(Level.WARNING, "Running on an unstable version of SevernLifeSteal. Report any errors at "+getDescription().getWebsite()+" with your version number.");
           }
        }
        catch(IOException ex) {
           getLogger().log(Level.WARNING, "Unable to obtain the latest version number available online.");
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void createPlayersData() {
        playersDataFile = new File(getDataFolder(), "players.yml");
        if (!playersDataFile.exists()) {
            playersDataFile.getParentFile().mkdirs();
            saveResource("players.yml", false);
        }
        playersData = new YamlConfiguration();
        try {
            playersData.load(playersDataFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public FileConfiguration getPlayersData() {
        return this.playersData;
    }

    public void savePlayersData() {
        try {
            getPlayersData().save(playersDataFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Integer getPlayerData(Player player, String key) {
        int ret = getPlayersData().getInt(player.getUniqueId() +"."+key);
        savePlayersData();
        return ret;
    }
    public void setPlayerData(Player player, String key, Object value) {
        getPlayersData().set(player.getUniqueId() +"."+key, value);
        savePlayersData();
    }

    public Player getPlayer(String match) {
        ArrayList<String> matchedPlayers = new ArrayList<>();
        ArrayList<String> onlinePlayers = new ArrayList<>();
        for (Player onlinePlayer : this.getServer().getOnlinePlayers()) onlinePlayers.add(onlinePlayer.getName());
        StringUtil.copyPartialMatches(match, onlinePlayers, matchedPlayers);
        Collections.sort(matchedPlayers);
        return this.getServer().getPlayer(matchedPlayers.get(0));
    }
}
