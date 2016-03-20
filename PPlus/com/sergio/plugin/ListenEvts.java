package com.sergio.plugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.sergio.plugin.event.WarnReceiveEvent;

public class ListenEvts implements Listener{
	
	@EventHandler
	public void onWarn(WarnReceiveEvent e){
		Player p = e.getTarget();
		FileConfiguration config = Main.getInstance().getConfig();
		List<String> warns = new ArrayList<>(config.getStringList(p.getUniqueId() + ".Warns"));
		if(warns.size() == 5){
			p.setBanned(true);
		}
	}
	


}
