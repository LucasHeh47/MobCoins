package me.LucasHeh.MobCoins.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class Give implements CommandExecutor {
	
	Main main = Main.getInstance();
	Utils utils = main.getUtils();

	public Give(Main main) {
		main.getCommand("mobcoins").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!sender.hasPermission("mobcoins.give")) {
			sender.sendMessage(ChatColor.RED + "You do not have permission!");
			return true;
		}
		
		if(args.length != 3) {
			if(args.length == 1 && args[0].equalsIgnoreCase("gui"))
				return true;
			sender.sendMessage(ChatColor.AQUA + "Commands:");
			sender.sendMessage(ChatColor.BLUE + "/mobcoins give <player> <amt>");
			sender.sendMessage(ChatColor.BLUE + "/mobcoins gui");
			return true;
		} else {
			Player target = Bukkit.getPlayer(args[1]);
			for(int i = 0 ; i<Integer.parseInt(args[2]) ; i++) {
				target.getInventory().addItem(utils.mobCoinItem());
			}
			target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &7You have been given " + args[2] + " &6Mob Coins"));
			sender.sendMessage(ChatColor.AQUA + "MobCoins given");
			return true;
		}
	}
	
}
