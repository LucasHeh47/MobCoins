package me.LucasHeh.MobCoins.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LucasHeh.MobCoins.Main;

public class Warzone implements CommandExecutor {
	
	public Warzone(Main main) {
		main.getCommand("warzone").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if(p.isFlying()) {
			p.setFlying(false);
		}
		Location location = new Location(Bukkit.getWorld("Spawn"), 10096, 150, 9980);
		p.teleport(location);
		
		return true;
	}

}
