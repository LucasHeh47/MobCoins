package me.LucasHeh.MobCoins.gui;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class Upgrade {
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	public Upgrade(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 54, ChatColor.translateAlternateColorCodes('&', "&9&lUpgrade Swords"));
		for(int i = 0; i < inv.getSize(); i++) {
			if(i == 4 || i == 12 || i== 14 || i == 22) {
				utils.itemToInventory(Material.YELLOW_STAINED_GLASS_PANE, 
						ChatColor.translateAlternateColorCodes('&', "&e&lUpgraded Sword here"), null, inv, i);
			} else if(i == 28 || i == 34 || i == 42 || i == 44 || i == 52 || i == 36 || i == 38 || i == 46) {
				utils.itemToInventory(Material.LIME_STAINED_GLASS_PANE, 
						ChatColor.translateAlternateColorCodes('&', "&a&lPlace 2 of the same multiplier swords here"), null, inv, i);
			} else if(i == 40) {
				utils.itemToInventory(Material.EMERALD, 
						ChatColor.translateAlternateColorCodes('&', "&aUpgrade"), new ArrayList<>(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7If you want to keep enchantments"), 
								ChatColor.translateAlternateColorCodes('&', "&7put sword with enchantments on the Left"))), inv, i);
			} else if(i == 43 || i == 37) {
				
			} else {
				utils.itemToInventory(Material.BLACK_STAINED_GLASS_PANE, " ", null, inv, i);
			}
		}
		p.openInventory(inv);
	}

}
