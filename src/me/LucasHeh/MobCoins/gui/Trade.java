package me.LucasHeh.MobCoins.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class Trade {
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();

	public Trade(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 54, ChatColor.translateAlternateColorCodes('&', "&b&lTrading Mob Coins"));
		
		List<String> expLore = new ArrayList<String>();
		expLore.add(ChatColor.translateAlternateColorCodes('&', "&71 Coin = " + utils.getExpPerCoin() + " Exp"));

		List<String> cashLore = new ArrayList<String>();
		cashLore.add(ChatColor.translateAlternateColorCodes('&', "&71 Coin = " + utils.getCashPerCoin() + " Cash"));

		List<String> crystalLore = new ArrayList<String>();
		crystalLore.add(ChatColor.translateAlternateColorCodes('&', "&71 Coin = " + utils.getCrystalsPerCoin() + " Island Crystals"));
		
		for(int i = 0 ; i < inv.getSize() ; i++) {
			if(i == 11) {
				utils.itemToInventory(Material.EXPERIENCE_BOTTLE, 
						ChatColor.translateAlternateColorCodes('&', "&e&lExperience"), expLore, inv, i);
			} else if(i == 13) {
				utils.itemToInventory(Material.EMERALD, 
						ChatColor.translateAlternateColorCodes('&', "&a&lCash"), cashLore, inv, i);
			} else if(i == 15) {
				utils.itemToInventory(Material.NETHER_STAR, 
						ChatColor.translateAlternateColorCodes('&', "&b&lIsland Crystals"), crystalLore, inv, i);
			}else if(i == 31) {
				utils.itemToInventory(Material.YELLOW_STAINED_GLASS_PANE, " ", null, inv, i);
			} else if(i == 39) {
				utils.itemToInventory(Material.YELLOW_STAINED_GLASS_PANE, " ", null, inv, i);
			} else if(i == 40) {
				continue;
			} else if(i == 41) {
				utils.itemToInventory(Material.YELLOW_STAINED_GLASS_PANE, " ", null, inv, i);
			} else if(i == 49) {
				utils.itemToInventory(Material.YELLOW_STAINED_GLASS_PANE, " ", null, inv, i);
			} else if(i == 45){
				utils.itemToInventory(Material.ARROW, ChatColor.RED + "Back", null, inv, i);
			} else {
				utils.itemToInventory(Material.BLACK_STAINED_GLASS_PANE, " ", null, inv, i);
			}
		}
		p.openInventory(inv);
	}
	
}
