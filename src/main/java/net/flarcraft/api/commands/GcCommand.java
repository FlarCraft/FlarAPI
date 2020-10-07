package net.flarcraft.api.commands;

import net.flarcraft.api.BungeeMain;
import net.flarcraft.api.utils.ChatUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class GcCommand extends Command {


    public GcCommand() {

        super("gc", "", "mem", "lag");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        ChatUtil.sendMessage(commandSender, "");
        ChatUtil.sendMessage(commandSender, "  &c&lSTATYSTYKI SERWERA PROXY:");
        ChatUtil.sendMessage(commandSender, "");
        ChatUtil.sendMessage(commandSender, "  &6RAM (used, total, free): &c" + (BungeeMain.getInstance().getRuntime().totalMemory() - BungeeMain.getInstance().getRuntime().freeMemory()) / 1048576L + " MB &8/ &6" + BungeeMain.getInstance().getRuntime().totalMemory() / 1048576L + " MB &8/&a " + BungeeMain.getInstance().getRuntime().freeMemory() / 1048576L + " MB");
        ChatUtil.sendMessage(commandSender, "  §6CPU (system): ");
        ChatUtil.sendMessage(commandSender, "  §6CZAS PRACY: ");
        ChatUtil.sendMessage(commandSender, "");
    }

}
