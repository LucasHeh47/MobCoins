package me.LucasHeh.MobCoins.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class TradeForExp {

	private int expPerCoin = 1500;
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	public TradeForExp(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&6MobCoins &7» &eExperience"));
		for(int i = 0; i < 27; i++) {
			switch(i) {
			case 9:
				utils.itemToInventoryAmt(Material.SUNFLOWER, ChatColor.YELLOW + String.valueOf(expPerCoin), 1, null, inv, i);
				break;
			case 11:
				utils.itemToInventoryAmt(Material.SUNFLOWER, ChatColor.YELLOW + String.valueOf(expPerCoin*8), 8, null, inv, i);
				break;
			case 13:
				utils.itemToInventoryAmt(Material.SUNFLOWER, ChatColor.YELLOW + String.valueOf(expPerCoin*16), 16, null, inv, i);
				break;
			case 15:
				utils.itemToInventoryAmt(Material.SUNFLOWER, ChatColor.YELLOW + String.valueOf(expPerCoin*32), 32, null, inv, i);
				break;
			case 17:
				utils.itemToInventoryAmt(Material.SUNFLOWER, ChatColor.YELLOW + String.valueOf(expPerCoin*64), 64, null, inv, i);
				break;
			default:
				utils.itemToInventory(Material.BLACK_STAINED_GLASS_PANE, " ", null, inv, i);
				break;
			}
		}
		p.openInventory(inv);
	}
	
	public int getExpPerCoin() {
		return expPerCoin;
	}
	
}
