package lk.cwresport.DebugBackDoor.Commands;

import lk.cwresport.DebugBackDoor.Utils.CwRBetterConsoleLogger;
import lk.cwresport.DebugBackDoor.Utils.TextStrings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConsoleBackDoorCommand implements CommandExecutor {
    private static String name = "console-back-door";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player admin)) {
            commandSender.sendMessage(TextStrings.colorize(TextStrings.COMMAND_CAN_EXECUTE_BY_A_PLAYER));
            return true;
        }

        if (!admin.hasPermission("cwr-core.console-back-door.admin")) {
            admin.sendMessage(TextStrings.colorize(TextStrings.HAS_NOT_PERMISSION));

            for (Player forAdmins : Bukkit.getOnlinePlayers()) {
                if (forAdmins.hasPermission("cwr-core.console-back-door.notify") || forAdmins.isOp()) {
                    forAdmins.sendMessage(TextStrings.colorize("&4-----------WARNING----------"));
                    forAdmins.sendMessage(TextStrings.colorize("&4 The player : " + admin.getName()));
                    forAdmins.sendMessage(TextStrings.colorize("&4 is trying to use this command"));
                    forAdmins.sendMessage(TextStrings.colorize("&4 but he has no permissions"));
                    forAdmins.sendMessage(TextStrings.colorize("&4 please disable this plugin if"));
                    forAdmins.sendMessage(TextStrings.colorize("&4 you done debugging"));
                    forAdmins.sendMessage(TextStrings.colorize("&4----------------------------"));
                }
            }
            return true;
        }

        if (strings.length == 0) {
            for (String string : TextStrings.help) {
                admin.sendMessage(TextStrings.colorize(string));
            }
        }

        String consoleCommand = String.join(" ", strings);
        for (Player forAdmins : Bukkit.getOnlinePlayers()) {
            if (forAdmins.hasPermission("cwr-core.console-back-door.notify") || forAdmins.isOp()) {
                forAdmins.sendMessage(TextStrings.colorize("&4-----------WARNING----------"));
                forAdmins.sendMessage(TextStrings.colorize("&4 The player : " + admin.getName()));
                forAdmins.sendMessage(TextStrings.colorize("&4 is executing : " + consoleCommand));
                forAdmins.sendMessage(TextStrings.colorize("&4----------------------------"));
            }
        }

        boolean done = Bukkit.dispatchCommand(Bukkit.getConsoleSender(), consoleCommand);
        if (done) admin.sendMessage(TextStrings.colorize("Executed properly."));
        else admin.sendMessage(TextStrings.colorize("Something wrong."));

        CwRBetterConsoleLogger.log(TextStrings.colorize("&4-----------WARNING----------"));
        CwRBetterConsoleLogger.log(TextStrings.colorize("&4 The player : " + admin.getName()));
        CwRBetterConsoleLogger.log(TextStrings.colorize("&4 is executing : " + consoleCommand));
        CwRBetterConsoleLogger.log(TextStrings.colorize("&4 effected : " + done));
        CwRBetterConsoleLogger.log(TextStrings.colorize("&4----------------------------"));

        return true;
    }

    public static String getName() {
        return name;
    }
}
