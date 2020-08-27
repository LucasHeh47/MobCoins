package me.LucasHeh.MobCoins.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LucasHeh.MobCoins.Main;

public class Blacksmith implements CommandExecutor {

	public Blacksmith(Main main) {
		main.getCommand("blacksmith").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) return true;
		Player p = (Player) sender;
		new me.LucasHeh.MobCoins.gui.Blacksmith(p);
		
		return false;
	}
	
}
