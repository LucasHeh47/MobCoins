package me.LucasHeh.MobCoins.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class TradeForIslandCrystal {
	
	private int crystalsPerCoin = 5;
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();

	public TradeForIslandCrystal(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "6MobCoins &7» &bIsland Crystals"));
		for(int i = 0; i<27; i++) {
			switch(i) {
			case 9:
				utils.itemToInventoryAmt(Material.NETHER_STAR, ChatColor.AQUA + String.valueOf(crystalsPerCoin), 1, null, inv, i);
				break;
			case 11:
				utils.itemToInventoryAmt(Material.NETHER_STAR, ChatColor.AQUA + String.valueOf(crystalsPerCoin*8), 8, null, inv, i);
				break;
			case 13:
				utils.itemToInventoryAmt(Material.NETHER_STAR, ChatColor.AQUA + String.valueOf(crystalsPerCoin*16), 16, null, inv, i);
				break;
			case 15:
				utils.itemToInventoryAmt(Material.NETHER_STAR, ChatColor.AQUA + String.valueOf(crystalsPerCoin*32), 32, null, inv, i);
				break;
			case 17:
				utils.itemToInventoryAmt(Material.NETHER_STAR, ChatColor.AQUA + String.valueOf(crystalsPerCoin*64), 64, null, inv, i);
				break;
			default:
				utils.itemToInventory(Material.BLACK_STAINED_GLASS_PANE, " ", null, inv, i);
				break;
			}
		}
		p.openInventory(inv);
	}
	
	public int getCrystalsPerCoin() {
		return crystalsPerCoin;
	}
	
}
