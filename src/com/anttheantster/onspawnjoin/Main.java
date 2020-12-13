package com.anttheantster.onspawnjoin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    //Get the Plugin Manager
    PluginManager pm = Bukkit.getPluginManager();

    //Register this plugin to a variable
    Plugin OSJ = this;

    @Override
    public void onEnable(){

        //Check if my core dependency is not null
        //if (pm.getPlugin("AntsPluginsCore") == null){
        //    getLogger().warning(OSJ.getName() + " requires AntsPluginsCore to work, please find this on AntTheAntster's Spigot page.");
        //    pm.disablePlugin(this);
        //}

        getLogger().info(OSJ.getName() + " has been Enabled! AntTheAntster 2020. All Rights Reserved.");

        pm.registerEvents(this, this);

    }

    @Override
    public void onDisable(){
        getLogger().info(OSJ.getName() + " has been disabled! AntTheAntster 2020. All Rights Reserved.");
        OSJ = null; //Prevent memory leaks, etc.
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if (p.hasPermission("spawnjoin.auto")){
            p.performCommand("spawn");
        }
    }
}
