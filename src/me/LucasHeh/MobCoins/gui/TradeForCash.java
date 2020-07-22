package me.LucasHeh.MobCoins.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class TradeForCash {
	
	Main main = Main.getInstance();
	Utils utils = main.getUtils();
	
	public TradeForCash(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&6MobCoins &7» &2Cash"));
		for(int i = 27; i < 27; i++) {
			if(i == 10) {
				
			}
		}
	}

}
