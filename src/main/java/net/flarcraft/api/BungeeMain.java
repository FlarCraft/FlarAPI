package net.flarcraft.api;

import net.flarcraft.api.commands.DiscordCommand;
import net.flarcraft.api.commands.FlarAPICommand;
import net.flarcraft.api.commands.RangsCommand;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.logging.Level;

public class BungeeMain extends Plugin {

    public static BungeeMain instance;
    public static Configuration cg;

    public void onEnable() {
        (BungeeMain.instance = this).createFiles();
        registerConfig();
        this.getProxy().getLogger().log(Level.INFO, ChatColor.RED + "[Bungee] FlarAPI Loading...");
        ProxyServer.getInstance().getLogger().info(ChatColor.YELLOW + "-----------------------");
        ProxyServer.getInstance().getLogger().info(ChatColor.YELLOW + "- " + ChatColor.GREEN + "Commands loading...");
        getProxy().getPluginManager().registerCommand(this, new FlarAPICommand());
        getProxy().getPluginManager().registerCommand(this, new DiscordCommand());
        getProxy().getPluginManager().registerCommand(this, new RangsCommand());
        ProxyServer.getInstance().getLogger().info(ChatColor.YELLOW + "-----------------------");
        ProxyServer.getInstance().getLogger().info(new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append("Enabled FlarAPI 1.0 loaded successful").toString());
    }

    public void onDisable() {
        this.getProxy().getLogger().log(Level.INFO, "[Bungee] FlarAPI Disabling...");
        ProxyServer.getInstance().getLogger().info(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.BOLD).append("Disabled FlarAPI 1.0 disabled successful").toString());
    }

    private void createFiles() {
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }
        final File file = new File(this.getDataFolder(), "config.yml");
        if (!file.exists()) {
            try {
                final InputStream in = this.getResourceAsStream("config.yml");
                Files.copy(in, file.toPath(), new CopyOption[0]);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void registerConfig() {
        try {
            BungeeMain.cg = ConfigurationProvider.getProvider((Class) YamlConfiguration.class).load(new File(BungeeMain.instance.getDataFolder(), "config.yml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BungeeMain getInstance() {
        return BungeeMain.instance;
    }

}