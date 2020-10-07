package net.flarcraft.api.commands;

import net.flarcraft.api.BungeeMain;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;

import net.md_5.bungee.api.plugin.Command;

public class DiscordCommand extends Command {


    public DiscordCommand() {

        super("discord");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        for(String messages : BungeeMain.cg.getStringList("Chat_Text_Discord")) {
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', messages));
        }

    }
}
