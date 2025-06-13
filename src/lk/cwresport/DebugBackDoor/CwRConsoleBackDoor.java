package lk.cwresport.DebugBackDoor;

import lk.cwresport.DebugBackDoor.Commands.ConsoleBackDoorCommand;
import lk.cwresport.DebugBackDoor.Utils.CwRBetterConsoleLogger;
import org.bukkit.plugin.java.JavaPlugin;

public class CwRConsoleBackDoor extends JavaPlugin {
    public static String PREFIX = "&7[&bCwRConsoleBackDoor&7]&r";

    @Override
    public void onEnable() {
        getCommand(ConsoleBackDoorCommand.getName()).setExecutor(new ConsoleBackDoorCommand());
        CwRBetterConsoleLogger.log("-----------------------------");
        CwRBetterConsoleLogger.log("-----CwR-ConsoleBackDoor-----");
        CwRBetterConsoleLogger.log("-----------------------------");
    }
}
