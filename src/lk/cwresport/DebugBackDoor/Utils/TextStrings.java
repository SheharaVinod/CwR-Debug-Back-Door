package lk.cwresport.DebugBackDoor.Utils;

import lk.cwresport.DebugBackDoor.CwRConsoleBackDoor;
import org.bukkit.ChatColor;

public class TextStrings {
    public static String COMMAND_CAN_EXECUTE_BY_A_PLAYER = "&4This command can only execute by a player.";
    public static String HAS_NOT_PERMISSION = "&4You don't have permission to execute this command.";

    public static String[] help = {
            "&6----------------------------------",
            "&6 Nothing fancy you can execute",
            "&6 any console command, in game.",
            "&6 Ex: /cbd op <name>",
            "&6----------------------------------",
    };


    public static String colorize(String massage) {
        return colorize(massage, true);
    }

    public static String colorize(String massage, boolean with_prefix) {
        if (with_prefix) {
            return colorize(CwRConsoleBackDoor.PREFIX, false) + " " + colorize(massage, false);
        }
        return ChatColor.translateAlternateColorCodes('&', massage);
    }
}
