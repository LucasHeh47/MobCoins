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

public class Boss implements CommandExecutor {
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	public Boss(Main main) {
		main.getCommand("boss").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.isOp()) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&cNo permission"));
			return true;
		}
		// boss give darthspanky1 zombieboss 1
		if(args.length == 4) {
			if(args[0].equalsIgnoreCase("give")) {
				if(args[2].equalsIgnoreCase("ZombieBoss")) {
					Player target = Bukkit.getPlayer(args[1]);
					int amount = Integer.parseInt(args[3]);
					ItemStack item = utils.zombieBossEgg();
					item.setAmount(amount);
					target.getInventory().addItem(item);
					target.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&7Received Zombie Boss Egg(s)"));
					return true;
				} else if(args[2].equalsIgnoreCase("SkeletonBoss")) {
					Player target = Bukkit.getPlayer(args[1]);
					int amount = Integer.parseInt(args[3]);
					ItemStack item = utils.skeletonBossEgg();
					item.setAmount(amount);
					target.getInventory().addItem(item);
					target.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&7Received Skeleton Boss Egg(s)"));
					return true;
				}
			}
		}
		
		return true;
	}

}
