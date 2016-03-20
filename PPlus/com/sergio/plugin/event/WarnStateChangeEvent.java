package com.sergio.plugin.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class WarnStateChangeEvent extends Event {
	private Player target;
	
	
	private static final HandlerList handlers = new HandlerList();
	
public WarnStateChangeEvent(Player target) {
		this.target = target;
		
	}

	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return handlers;
	}


	public Player getPlayer() {
		return target;
	}

	


}
