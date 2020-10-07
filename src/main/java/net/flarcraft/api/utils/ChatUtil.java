package net.flarcraft.api.utils;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.List;

public class ChatUtil {
    public static String fixColors(final String message) {
        if (message == null) {
            return "";
        }
        return message.replace("&", "§").replace("#", " »");
    }

    public static String[] fixColors(final String[] message) {
        final String[] strings = message;
        for (int i = 0; i < strings.length; ++i) {
            strings[i] = fixColors(strings[i]);
        }
        return strings;
    }

    public static void sendMessage(final ProxiedPlayer p, final String message) {
        p.sendMessage(fixColors(message));
    }

    public static void sendMessage(final CommandSender cs, final String message) {
        cs.sendMessage(fixColors(message));
    }

    public static void sendMessage(final ProxiedPlayer p, final String[] messages) {
        p.sendMessages(fixColors(messages));
    }

    public static void sendMessage(final ProxiedPlayer p, final List<String> message) {
        for (int i = 0; i < message.size(); ++i) {
            sendMessage(p, message.get(i));
        }
    }

    public static void sendMessage(CommandSender cs, List<String> message) {
        for (int i = 0; i < message.size(); ++i) {
            sendMessage(cs, message.get(i));
        }
    }
}