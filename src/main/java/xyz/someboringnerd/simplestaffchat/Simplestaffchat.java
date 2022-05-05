package xyz.someboringnerd.simplestaffchat;

import xyz.someboringnerd.simplestaffchat.events.ChatEvent;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.someboringnerd.simplestaffchat.commands.StaffSay;
import xyz.someboringnerd.simplestaffchat.commands.StaffToggle;
public final class Simplestaffchat extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("staffsay").setExecutor(new StaffSay());
        getCommand("staffchattoggle").setExecutor(new StaffToggle());

        getServer().getPluginManager().registerEvents(new ChatEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
