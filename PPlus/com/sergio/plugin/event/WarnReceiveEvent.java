package com.sergio.plugin.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class WarnReceiveEvent extends Event{
	
	private Player target;
	private Player sender;
	private String warning;
	private static final HandlerList handlers = new HandlerList();
	
public WarnReceiveEvent(Player target, Player sender, String warning) {
		this.target = target;
		this.sender = sender;
		this.warning = warning;
	}

	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return handlers;
	}

	public Player getSender() {
		return sender;
	}

	public Player getTarget() {
		return target;
	}

	public String getWarning() {
		return warning;
	}

	

	

	

}
