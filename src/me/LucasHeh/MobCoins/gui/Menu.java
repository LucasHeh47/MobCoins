package me.LucasHeh.MobCoins.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class Menu {
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();

	public Menu(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 36, ChatColor.translateAlternateColorCodes('&', "&6&lMob Coins Menu"));
		for(int i = 0 ; i < inv.getSize() ; i++) {
			if(i == 10) {
				utils.itemToInventory(Material.ZOMBIE_SPAWN_EGG, ChatColor.translateAlternateColorCodes('&', 
						"&2&lMob Chances"), null, inv, i);
			} else if(i == 12) {
				utils.itemToInventory(Material.DIAMOND_SWORD, 
						ChatColor.translateAlternateColorCodes('&', "&9&lUpgrade Mob Coin Swords"), null, inv, i);
			} else if(i==14) {
				utils.itemToInventory(Material.SUNFLOWER, ChatColor.translateAlternateColorCodes('&', 
						"&a&lTrade in Mob Coins"), null, inv, i);
			} else if(i == 16) {
				utils.itemToInventory(Material.EMERALD, ChatColor.translateAlternateColorCodes('&', 
						"&6&lMobCoin Shop"), null, inv, i);
			} else if(i==31) {
				utils.itemToInventory(Material.BARRIER, ChatColor.RED + "Exit", null, inv, i);
			} else {
				utils.itemToInventory(Material.BLACK_STAINED_GLASS_PANE, " ", null, inv, i);
			}
		}
		p.openInventory(inv);
	}
	
}
