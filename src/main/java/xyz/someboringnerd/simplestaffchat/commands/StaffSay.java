package io.github.corentynn.simplestaffchat.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class StaffSay implements CommandExecutor {


    public static void staffSayMSG(String message, Player sender)
    {
        System.out.println("[StaffChat] " + sender.getName() + " >> " + message);

        String senderName = sender.getName();

        for(Player player : Bukkit.getServer().getOnlinePlayers()){
            if(player.isOp() || player.getPlayer().hasPermission("staffchat.getstaffmsg")){
                Objects.requireNonNull(player.getPlayer()).sendMessage("§4[StaffChat] §a" + senderName + " §4>> §r" + message);
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender.hasPermission("staffchat.say") || sender.isOp())){
            sender.sendMessage("§4[StaffChat] : vous n'avez pas la permission requise pour executer cette commande");
        }else{

            StringBuilder sb = new StringBuilder();
            for (String arg : args) {
                sb.append(arg).append(" ");
            }

            Player p = (Player) sender;
            String name = p.getName();

            System.out.println("[StaffChat] " + name+ " >> " + sb.toString());

            staffSayMSG(sb.toString(), p);
        }
        return true;
    }
}
