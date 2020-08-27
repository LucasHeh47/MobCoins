package me.LucasHeh.MobCoins.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.gui.artisan.MainMenu;

public class Artisan implements CommandExecutor {
	
	public Artisan(Main main) {
		main.getCommand("artisan").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) return true;
		Player p = (Player) sender;
		new MainMenu(p);
		return false;
	}

}
