package net.flarcraft.api.commands;

import net.flarcraft.api.BungeeMain;
import net.flarcraft.api.utils.ChatUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class VipCommand extends Command {


    public VipCommand() {

        super("vip");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        ChatUtil.sendMessage(commandSender, BungeeMain.cg.getStringList("Chat_Text_Vip"));
    }
}
