package com.sergio.plugin;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Messages {
	
	public static String PREFIX = ChatColor.translateAlternateColorCodes('&', "&6&lPunishment&c&lPlus&7&l » &r");
	public static String KICK_MESSAGE;
	public static String WARN_MESSAGE;
	public static String BAN_MESSAGE;
	public static String MUTE_MESSAGE;
	public static String JAIL_MESSAGE;
	public static String UNWARN_MESSAGE;
	public static String UNBAN_MESSAGE;
	public static String UNMUTE_MESSAGE;
	public static String UNJAIL_MESSAGE;
	public static String IGNORE_MESSAGE;
	public static String UNIGNORE_MESSAGE;
	public static String NAME;
	public static String DATE;
	public static String FROM;
	public static String REASON;
	public static String CHECK_USER_TITLE;
	
	public static FileConfiguration loadMsgYaml(){
		File f = new File(Main.getInstance().getDataFolder() + "messages.yml");
		FileConfiguration ymlfile = YamlConfiguration.loadConfiguration(f);
		return ymlfile;
	}
	
	public static void registerDefaults(){
		FileConfiguration config = loadMsgYaml();
		config.addDefault("name", "&4Name");
		config.addDefault("from", "&4From");
		config.addDefault("reason", "&4Reason");
		config.addDefault("date", "&4Date");
		config.addDefault("kick-message", "&cPlayer succesfully kicked.");
		config.addDefault("warn-message", "");
		config.addDefault("ban-message", "&4Name");
		config.addDefault("jail-message", "&4Name");
		config.addDefault("ignore-message", "&4Name");
		config.addDefault("unignore-message", "&4Name");
		config.addDefault("mute-message", "&4Name");
		config.addDefault("unmute-message", "&4Name");
		config.addDefault("check-user-title", "&4Name");
		config.addDefault("unwarn-message", "&aSuccesfully removed a warn. Player now has <warnings> warnings.");
		config.addDefault("unban-message", "&4Name");
		config.addDefault("unjail-message", "&4Name");
		config.options().copyDefaults(true);
	}
	public static void register(){
		loadMsgYaml();
		registerDefaults();
	}
	public static void readFromFile(){
		FileConfiguration config = loadMsgYaml();
		NAME = config.getString("name");
		FROM = config.getString("from");
		REASON =config.getString("reason");
		DATE = config.getString("date");
		KICK_MESSAGE = config.getString("kick-message");
		WARN_MESSAGE = config.getString("warn-message");
		BAN_MESSAGE = config.getString("ban-message");
		JAIL_MESSAGE = config.getString("jail-message");
		IGNORE_MESSAGE=config.getString("ignore-message");
		UNIGNORE_MESSAGE=config.getString("unignore-message");
		MUTE_MESSAGE=config.getString("mute-message");
		UNMUTE_MESSAGE=config.getString("unmute-message");
		CHECK_USER_TITLE=config.getString("check-user-title");
		UNWARN_MESSAGE=config.getString("unwarn-message");
		UNBAN_MESSAGE=config.getString("unban-message");
		UNJAIL_MESSAGE=config.getString("unjail-message");
	}

}
