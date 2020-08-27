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

public class Blacksmith {
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	public Blacksmith(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 54, ChatColor.translateAlternateColorCodes('&', "&6&lBlacksmith"));
		for(int i = 0; i<inv.getSize(); i++) {
			if(i == 22) {
				
			} else if(i == 40) {
				utils.itemToInventory(Material.ANVIL, ChatColor.translateAlternateColorCodes('&', "&6&lRepair"), 
						new ArrayList<String>(Arrays.asList("&720 Exp Levels to Repair")), inv, i);
			} else {
				utils.itemToInventory(Material.BLACK_STAINED_GLASS_PANE, " ", null, inv, i);
			}
		}
		p.openInventory(inv);
	}

}
