package net.flarcraft.api.commands;

import net.flarcraft.api.BungeeMain;
import net.flarcraft.api.utils.ChatUtil;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class FlarAPICommand extends Command {

    public FlarAPICommand() {

        super("flarapi");
    }

    final String prefix = ChatUtil.fixColors(BungeeMain.cg.getString("Prefix"));


    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        ChatUtil.sendMessage(commandSender, String.valueOf(String.valueOf(prefix)) + BungeeMain.cg.getString("Chat_Text"));
        final Title t = ProxyServer.getInstance().createTitle();
        t.reset();
        String title = ChatUtil.fixColors(BungeeMain.cg.getString("Title_Text"));
        t.title((BaseComponent) new TextComponent(title));
        String subtitle = ChatUtil.fixColors(BungeeMain.cg.getString("SubTitle_Text"));
        t.subTitle((BaseComponent)new TextComponent(subtitle));
        t.send((ProxiedPlayer) commandSender);
    }
}