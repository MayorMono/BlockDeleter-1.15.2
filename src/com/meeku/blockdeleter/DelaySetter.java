package com.meeku.blockdeleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DelaySetter implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.isOp()) {

            if(!(strings.length == 1)) {
                return false;
            }

            try {
                int delay = Integer.parseInt(strings[0]);

                if(delay >= 1 && delay <= 200) {
                    BlockDeleter.delay = delay;
                    Bukkit.broadcastMessage("Deletion delay is now " + strings[0] + " ticks");
                }

            } catch(NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
}
