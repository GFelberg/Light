package me.GFelberg.Light.data;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.GFelberg.Light.Main;
import me.GFelberg.Light.utils.LightUtils;

public class LightSystem {

	public static String unlight, light;
	public static String prefix_var, unlight_var, light_var;

	public static void loadVariables() {
		unlight = Main.getInstance().getConfig().getString("Light.Disabled").replace("&", "§");
		light = Main.getInstance().getConfig().getString("Light.Enabled").replace("&", "§");
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

	public static void loadLanguage(Player p) {

		switch (Main.getInstance().getConfig().getString("Language")) {

		case "en-US":
			p.sendMessage(LightUtils.prefix + " " + ChatColor.GREEN + "Plugin reloaded successfully!");
			break;

		case "zh-CN": // Chinese
			prefix_var = "§8[§e无限夜视§8]§r";
			p.sendMessage(prefix_var + " " + ChatColor.GREEN + "Plugin reloaded successfully!");
			break;
		}
	}
}
