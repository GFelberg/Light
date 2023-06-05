package me.GFelberg.Light.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.GFelberg.Light.Main;
import me.GFelberg.Light.data.LightSystem;

public class LightUtils {

	public static String prefix;

	public static void loadVariables() {
		prefix = Main.getInstance().getConfig().getString("Light.Prefix").replace("&", "§");
	}

	public void reloadConfig(Player p) {

		if (!(p.hasPermission("light.reload"))) {
			p.sendMessage(ChatColor.RED + "You dont have permission to perform this command!");
		} else {
			Main.getInstance().reloadConfig();
			loadVariables();
			LightSystem.loadLanguage(p);
			Bukkit.getConsoleSender().sendMessage("=======================================");
			Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Light Plugin reloaded");
			Bukkit.getConsoleSender().sendMessage("=======================================");
		}
	}

	public void helpPage(Player p) {
		HelpPageUtils helpUtils = new HelpPageUtils();

		if (!(p.hasPermission("light.admin"))) {
			p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
			p.sendMessage(ChatColor.AQUA + "Light - Help Commands");
			p.sendMessage(ChatColor.YELLOW + "/light help: " + helpUtils.getHelp_page());
			p.sendMessage(ChatColor.YELLOW + "/light : " + helpUtils.getHelp_light());
			p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
		} else {
			p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
			p.sendMessage(ChatColor.AQUA + "Light - Help Commands");
			p.sendMessage(ChatColor.YELLOW + "/light help : " + helpUtils.getHelp_page());
			p.sendMessage(ChatColor.YELLOW + "/light : " + helpUtils.getHelp_light());
			p.sendMessage(ChatColor.YELLOW + "/light reload : " + helpUtils.getHelp_reload());
			p.sendMessage(ChatColor.WHITE + "-----------------------------------------");
		}
	}
}