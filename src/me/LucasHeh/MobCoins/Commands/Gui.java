package me.LucasHeh.MobCoins.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.gui.MainInv;

public class Gui implements CommandExecutor {

	public Gui(Main main) {
		main.getCommand("mobcoins").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			return true;
		}
		
		if(args.length != 1) {
			return true;
		} else {
			Player p = (Player) sender;
			new MainInv(p);
		}
		
		return false;
	}
	
}
