package me.LucasHeh.MobCoins.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.LucasHeh.MobCoins.Main;

public class Buy implements CommandExecutor {

	public Buy(Main main) {
		main.getCommand("buy").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "PrimalMC » &7 https://server.pro/server/14822663"));
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lNOTE: &7Process is not automatic, let a staff know you purchased a rank"));
		
		return false;
	}
	
}
