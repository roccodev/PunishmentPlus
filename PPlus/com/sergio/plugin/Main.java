package com.sergio.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static Main m;
	public Main(){
		m = this;
	}
	public static Main getInstance(){
		return m;
	}
	
	@Override
	public void onEnable(){
		
		this.getCommand("warn").setExecutor(new WarnCommand());
		this.getCommand("delwarn").setExecutor(new WarnCommand());
	}

}
