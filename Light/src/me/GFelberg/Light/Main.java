package me.GFelberg.Light;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.GFelberg.Light.commands.Light;
import me.GFelberg.Light.utils.LightUtils;

public class Main extends JavaPlugin {

	private static Main instance;

	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		LightUtils.loadVariables();
		getCommand("light").setExecutor(new Light());
		Bukkit.getConsoleSender().sendMessage("-----------------------------");
		Bukkit.getConsoleSender().sendMessage("Light Plugin Enabled");
		Bukkit.getConsoleSender().sendMessage("Plugin develloped by GFelberg");
		Bukkit.getConsoleSender().sendMessage("-----------------------------");
	}

	public static Main getInstance() {
		return instance;
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("-----------------------------");
		Bukkit.getConsoleSender().sendMessage("Light Plugin Disabled");
		Bukkit.getConsoleSender().sendMessage("Plugin develloped by GFelberg");
		Bukkit.getConsoleSender().sendMessage("-----------------------------");
	}
}