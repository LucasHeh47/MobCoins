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

public class MobCoinShop {

	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	public MobCoinShop(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 54, ChatColor.translateAlternateColorCodes('&', "&6&lMob Coin Shop"));
		for(int i = 0; i < inv.getSize(); i++) {
			if(i == 0) {
				utils.itemToInventory(Material.NETHER_STAR, ChatColor.translateAlternateColorCodes('&', "&6&lDeluxe Crate Key"), 
						new ArrayList<String>(Arrays.asList("&632 MobCoins")), inv, 0);
			}
		}
	}
	
}
