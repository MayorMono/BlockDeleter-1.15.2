package com.meeku.blockdeleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Disabler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 0) {
            if(BlockDeleter.enabled && commandSender.isOp()) {
                BlockDeleter.enabled = false;
                Bukkit.broadcastMessage("Blocks will no longer be deleted");
                return true;
            }
            return true;
        }
        return false;
    }
}
