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
import me.LucasHeh.MobCoins.gui.Menu;

public class Commands implements CommandExecutor {
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();

	public Commands(Main main) {
		main.getCommand("mobcoins").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length == 0) {
			if(!(sender instanceof Player)) {
				return true;
			}
			Player p = (Player) sender;
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &7You have " + utils.getMobCoinMap().get(utils.getPlayersUUID(p)) + " Mob Coins"));
		}
		if(args.length != 1) {
			if(args.length == 2) {
				if(!(sender instanceof Player)) {
					return true;
				}
				if(args[0].equalsIgnoreCase("withdraw")) {
					Player p = (Player) sender;
					int amount = Integer.parseInt(args[1]);
					if(amount > utils.getMobCoinMap().get(p.getUniqueId().toString())) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cYou do not have enough Mob Coins"));
						return true;
					}
					if(amount <= 0) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cPlease enter a # above 0"));
						return true;
					}
					utils.getMobCoinMap().put(p.getUniqueId().toString(), utils.getMobCoinMap().get(p.getUniqueId().toString())-amount);
					ItemStack item = utils.mobCoinItem();
					item.setAmount(amount);
					p.getInventory().addItem(item);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &7You have withdrawed " + amount + " Mob Coin(s)"));
					return true;
				}
			}
			if(args.length == 3) {
				if(!sender.hasPermission("mobcoins.give"))
					return true;
				if(args[2].equalsIgnoreCase("mcs")) {
					Player target = Bukkit.getPlayer(args[1]);
					target.getInventory().addItem(utils.mobCoinBoosterSword(1.0));
					sender.sendMessage(ChatColor.AQUA + "Mob Coin Sword given");
					target.sendMessage(ChatColor.translateAlternateColorCodes('&', 
							"&b&lPrimalMC » &7You have been given a Mob Coin Sword"));
					return true;
				}
				if(args[2].equalsIgnoreCase("smcs")) {
					Player target = Bukkit.getPlayer(args[1]);
					target.getInventory().addItem(utils.superMobCoinBoosterSword(1.0));
					sender.sendMessage(ChatColor.AQUA + "Super Mob Coin Sword given");
					target.sendMessage(ChatColor.translateAlternateColorCodes('&', 
							"&b&lPrimalMC » &7You have been given a Super Mob Coin Sword"));
					return true;
				}
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
			if(args[0].equalsIgnoreCase("menu")) {
				Player p = (Player) sender;
				new Menu(p);
			}
		}
		
		return false;
	}
	
}
