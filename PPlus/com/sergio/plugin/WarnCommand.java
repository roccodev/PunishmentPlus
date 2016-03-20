package com.sergio.plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.sergio.plugin.event.WarnReceiveEvent;
import com.sergio.plugin.event.WarnStateChangeEvent;

public class WarnCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		FileConfiguration config = Main.getInstance().getConfig();
		Player target = Bukkit.getPlayer(arg3[0]);
		if(arg1.getName().equalsIgnoreCase("warn")){
			List<String> warns = config.getStringList(target.getUniqueId() + ".Warns");
			StringBuilder sb = new StringBuilder();
			List<String> args = new ArrayList<>(Arrays.asList(arg3));
			args.remove(0);
			for(String s : args){
				sb.append(s).append(" ");
			}
			warns.add(sb.toString().trim());
			config.set(target.getUniqueId() + ".Warns", warns);
			Main.getInstance().saveConfig();
			Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD+
				    "Punishment" + ChatColor.GOLD + ""+ChatColor.BOLD+"Plus" + ChatColor.AQUA+" > " +
				    ChatColor.GREEN+""+"Warnato " + ChatColor.BOLD +target.getName() + ChatColor.GREEN+"!");
				  Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD+
				    "Punishment" + ChatColor.GOLD + ""+ChatColor.BOLD+"Plus" + ChatColor.AQUA+" > " +
				    ChatColor.DARK_RED +""+"MOTIVO: " + ChatColor.GREEN + sb.toString().trim());
				  Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD+
				    "Punishment" + ChatColor.GOLD + ""+ChatColor.BOLD+"Plus" + ChatColor.AQUA+" > " +
				    ChatColor.DARK_RED+""+"DA: " + ChatColor.GREEN +  arg0.getName());
				  Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD+
				    "Punishment" + ChatColor.GOLD + ""+ChatColor.BOLD+"Plus" + ChatColor.AQUA+" > " +
				    ChatColor.DARK_RED+""+"DATA: " + ChatColor.GREEN +  new Date());
				  WarnReceiveEvent evt = new WarnReceiveEvent(target, (Player) arg0, sb.toString().trim());
				  Bukkit.getPluginManager().callEvent(evt);
			
		}
		else if(arg1.getName().equalsIgnoreCase("delwarn")){
			List<String> warns = config.getStringList(target.getUniqueId() + ".Warns");
			warns.remove(warns.size() - 1);
			config.set(target.getUniqueId() + ".Warns", warns);
			
			Main.getInstance().saveConfig();
			arg0.sendMessage(ChatColor.GREEN + "Succesfully removed a warn. Player now has " + warns.size() +
					" warnings.");
			target.sendMessage(ChatColor.GREEN + "One of your warns has been removed! You now have " + warns.size() +
					" warnings.");
			
			 WarnStateChangeEvent evt = new WarnStateChangeEvent(target);
			  Bukkit.getPluginManager().callEvent(evt);
		}
		return true;
	}

}
