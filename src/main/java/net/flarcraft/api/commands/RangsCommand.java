package net.flarcraft.api.commands;

import net.flarcraft.api.BungeeMain;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class RangsCommand extends Command {


    public RangsCommand() {

        super("rangi");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        for(String messages : BungeeMain.cg.getStringList("Chat_Text_Rangs")) {
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', messages));
        }

    }
}
