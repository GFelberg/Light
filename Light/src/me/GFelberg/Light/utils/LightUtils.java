package me.GFelberg.Light.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.GFelberg.Light.Main;

public class LightUtils {

	public static String prefix, unlight, light;
	public static String prefix_var, unlight_var, light_var;

	public static void loadVariables() {
		prefix = Main.getInstance().getConfig().getString("Light.Prefix").replace("&", "§");
		unlight = Main.getInstance().getConfig().getString("Light.Disabled").replace("&", "§");
		light = Main.getInstance().getConfig().getString("Light.Enabled").replace("&", "§");
	}

	public void reloadConfig(Player p) {

		if (!(p.hasPermission("light.reload"))) {
			p.sendMessage(ChatColor.RED + "You dont have permission to perform this command!");
		} else {
			Main.getInstance().reloadConfig();
			loadVariables();
			loadLanguage(p);
			Bukkit.getServer().getConsoleSender().sendMessage("=======================================");
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Light Plugin reloaded");
			Bukkit.getServer().getConsoleSender().sendMessage("=======================================");
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

	public void light(Player p) {

		if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {

			switch (Main.getInstance().getConfig().getString("Language")) {

			case "en-US":
				p.sendMessage(unlight);
				break;

			case "zh-CN": // Chinese
				unlight_var = "§4已关闭";
				p.sendMessage(unlight_var);
				break;
			}
			p.removePotionEffect(PotionEffectType.NIGHT_VISION);
		} else {
			switch (Main.getInstance().getConfig().getString("Language")) {

			case "en-US":
				p.sendMessage(light);
				break;

			case "zh-CN": // Chinese
				light_var = "§4已开启";
				p.sendMessage(light_var);
				break;
			}
			p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999, 0, false, false, false));
		}
	}

	public void loadLanguage(Player p) {

		switch (Main.getInstance().getConfig().getString("Language")) {

		case "en-US":
			p.sendMessage(prefix + " " + ChatColor.GREEN + "Plugin reloaded successfully!");
			break;

		case "zh-CN": // Chinese
			prefix_var = "§8[§e无限夜视§8]§r";
			p.sendMessage(prefix_var + " " + ChatColor.GREEN + "Plugin reloaded successfully!");
			break;
		}
	}
}