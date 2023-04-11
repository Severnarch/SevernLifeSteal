package io.github.severnarch.severnlifesteal;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SevernLifeStealCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        SevernLifeSteal plugin = JavaPlugin.getPlugin(SevernLifeSteal.class);
        if (Objects.equals(args[0], "help")) {
            sender.sendMessage(plugin.prefix+"SevernLifeSteal is a multi-platform life steal mod/plugin for Minecraft..");
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        SevernLifeSteal plugin = JavaPlugin.getPlugin(SevernLifeSteal.class);
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();
        if (args.length == 1) {
            if (sender.hasPermission("tjsrpgplugin.admin")) commands.add("admin");
            commands.add("help");
            commands.add("spellwand");
            StringUtil.copyPartialMatches(args[0], commands, completions);
        }
        Collections.sort(completions);
        return completions;
    }
}