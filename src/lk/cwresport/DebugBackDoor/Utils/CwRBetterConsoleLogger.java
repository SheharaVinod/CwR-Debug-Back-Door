package lk.cwresport.DebugBackDoor.Utils;

import org.bukkit.Bukkit;

public class CwRBetterConsoleLogger {
    public static void log(String massage) {
        Bukkit.getServer().getConsoleSender().sendMessage(TextStrings.colorize(massage));
    }
}

