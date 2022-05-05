package xyz.someboringnerd.simplestaffchat.events;

import xyz.someboringnerd.simplestaffchat.commands.StaffSay;
import xyz.someboringnerd.simplestaffchat.commands.StaffToggle;
import org.bukkit.Bukkit;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ChatEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onChat(AsyncPlayerChatEvent event)
    {
        if(StaffToggle.playerWithStaffMode.get(event.getPlayer())){
            event.setCancelled(true);
            StaffSay.staffSayMSG(event.getMessage(), event.getPlayer());
        }
    }
    @EventHandler(priority = EventPriority.HIGH)
    public void onJoin(PlayerJoinEvent event){
        StaffToggle.playerWithStaffMode.put(event.getPlayer(), false);
    }
    @EventHandler(priority = EventPriority.HIGH)
    public void onLeft(PlayerQuitEvent event){
        StaffToggle.playerWithStaffMode.remove(event.getPlayer());
    }
}
