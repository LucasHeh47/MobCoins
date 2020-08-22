package me.LucasHeh.MobCoins.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.LucasHeh.MobCoins.Main;

public class CustomEnchantList implements CommandExecutor {

	public CustomEnchantList(Main main) {
		main.getCommand("el").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lEnchantment List: &5&nhttps://docs.google.com/spreadsheets/d/1TitLuPcRdCOc-4MvRx5XHzlbnCBrHw9_nIqab_POXwc/edit?usp=sharing"));
		
		return false;
	}
	
}
