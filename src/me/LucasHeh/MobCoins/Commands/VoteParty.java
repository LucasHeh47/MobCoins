package me.LucasHeh.MobCoins.Commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LucasHeh.MobCoins.Main;

public class VoteParty implements CommandExecutor {
	
	private Main main = Main.getInstance();
	
	public VoteParty(Main main) {
		main.getCommand("vp").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!sender.hasPermission("vp.start")) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cYou do not have permission!"));
			return true;
		} else {
			Random random = new Random();
			for(Player p : Bukkit.getOnlinePlayers()) {
				int keys = random.nextInt(4)+1;
				for(int i = 0; i < keys ; i++) {
					int type = random.nextInt(101);
					if(type <= 50)
						main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "crates givekey " + p.getName() + " vote");
					else if(type <= 75 && type > 50)
						main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "crates givekey " + p.getName() + " deluxe");
					else if(type <= 90 && type > 75)
						main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "crates givekey " + p.getName() + " cash");
					else if(type < 100 && type > 90)
						main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "crates givekey " + p.getName() + " legendary");
				}
			}
		}
		
		return false;
	}

}
