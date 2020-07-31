package me.LucasHeh.MobCoins.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class MainInv {
	
	Main main = Main.getInstance();
	Utils utils = main.getUtils();

	public MainInv(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&6Trade Mob Coins"));
		for(int i=0; i<27; i++) {
			if(i == 11) {
				utils.itemToInventory(Material.PAPER, 
						ChatColor.translateAlternateColorCodes('&', "&2Cash"), utils.getEmptyLore(), inv, i);
			} else if(i == 13) {
				utils.itemToInventory(Material.EXPERIENCE_BOTTLE, 
						ChatColor.translateAlternateColorCodes('&', "&eExperience"), utils.getEmptyLore(), inv, i);
			} else if(i == 15) {
				utils.itemToInventory(Material.NETHER_STAR, 
						ChatColor.translateAlternateColorCodes('&', "&bIsland Crystal"), utils.getEmptyLore(), inv, i);
			} else {
				utils.itemToInventory(Material.BLACK_STAINED_GLASS_PANE, " ", utils.getEmptyLore(), inv, i);
			}
		}
		p.openInventory(inv);
	}
	
}
