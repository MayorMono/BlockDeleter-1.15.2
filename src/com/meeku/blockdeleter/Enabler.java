package com.meeku.blockdeleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Enabler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 0) {
            if(!BlockDeleter.enabled && commandSender.isOp()) {
                BlockDeleter.enabled = true;
                Bukkit.broadcastMessage("Blocks will now be deleted upon stepping on them. Watch your step!");
                return true;
            }
            return true;
        }
        return false;
    }
}
