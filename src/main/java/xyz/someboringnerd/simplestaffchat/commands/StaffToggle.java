package io.github.corentynn.simplestaffchat.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffToggle implements CommandExecutor {

    public static Map<Player, Boolean> playerWithStaffMode = new HashMap<Player, Boolean>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§4[StaffChat] cette commande ne peut être executée depuis la console");
            return true;
        }
        else {

            Player p = (Player) sender;
            String name = p.getName();

            System.out.println(name);

            playerWithStaffMode.putIfAbsent(p, false);

            if (sender.hasPermission("staffchat.toggle")) {
                playerWithStaffMode.replace(p, !playerWithStaffMode.get(p));
                sender.sendMessage("§4[StaffChat] : vous parlez actuellement dans le chat " + (playerWithStaffMode.get(p) ? "admin" : "general"));
            } else {
                sender.sendMessage("§4[StaffChat] : vous n'avez pas la permission requise pour executer cette commande");
            }
        }
        return true;
    }
}
