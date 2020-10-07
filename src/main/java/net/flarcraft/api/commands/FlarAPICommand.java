package net.flarcraft.api.commands;

import net.flarcraft.api.BungeeMain;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class FlarAPICommand extends Command {

    public FlarAPICommand() {

        super("flarapi");
    }

    final String prefix = BungeeMain.cg.getString("Prefix").replace("&", "§");

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        commandSender.sendMessage(new TextComponent(String.valueOf(String.valueOf(prefix)) + BungeeMain.cg.getString("Chat_Text").replace("&", "§")));

        final Title t = ProxyServer.getInstance().createTitle();
        t.reset();
        t.title((BaseComponent)new TextComponent(BungeeMain.cg.getString("Title_Text").replace("&", "§")));
        t.subTitle((BaseComponent)new TextComponent(BungeeMain.cg.getString("SubTitle_Text").replace("&", "§")));
        t.send((ProxiedPlayer) commandSender);
    }
}