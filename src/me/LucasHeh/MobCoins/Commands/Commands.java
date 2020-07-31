package me.LucasHeh.MobCoins.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;
import me.LucasHeh.MobCoins.gui.MainInv;

public class Commands implements CommandExecutor {
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();

	public Commands(Main main) {
		main.getCommand("mobcoins").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			return true;
		}
		if(args.length == 0) {
			Player p = (Player) sender;
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &7You have " + utils.getMobCoinMap().get(utils.getPlayersUUID(p)) + " Mob Coins"));
		}
		if(args.length != 1) {
			if(args.length == 3) {
				Player target = Bukkit.getPlayer(args[1]);
				ItemStack item = utils.mobCoinItem();
				item.setAmount(Integer.parseInt(args[2]));
				target.getInventory().addItem(item);
				target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &7You have been given " + args[2] + " &6Mob Coins"));
				sender.sendMessage(ChatColor.AQUA + "MobCoins given");
				return true;
			}
			return true;
		} else {
			if(args[0].equalsIgnoreCase("gui")) {
				Player p = (Player) sender;
				new MainInv(p);
			}
		}
		
		return false;
	}
	
}
