package me.LucasHeh.MobCoins.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.LucasHeh.MobCoins.Chances;
import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class MobChances {
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	private Chances chances = main.getMobChances();

	public MobChances(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 36, ChatColor.translateAlternateColorCodes('&', "&6Mob Chances"));
		for(int i = 0; i < inv.getSize(); i++) {
			switch(i) {
			case 11:
				utils.itemToInventory(Material.GUNPOWDER, ChatColor.GREEN + "Creeper: " + chances.getCREEPER() + "/100", null, inv, i);
			case 13:
				utils.itemToInventory(Material.RED_MUSHROOM, ChatColor.GREEN + "Mooshroom: " + chances.getMOOSHROOM() + "/100", null, inv, i);
			case 15:
				utils.itemToInventory(Material.BONE, ChatColor.GREEN + "Skeleton: " + chances.getSKELETON() + "/100", null, inv, i);
			case 17:
				utils.itemToInventory(Material.REDSTONE, ChatColor.GREEN + "Witch: " + chances.getWITCH() + "/100", null, inv, i);
			case 21:
				utils.itemToInventory(Material.ROTTEN_FLESH, ChatColor.GREEN + "Zombie: " + chances.getZOMBIE() + "/100", null, inv, i);
			case 23:
				utils.itemToInventory(Material.IRON_BLOCK, ChatColor.GREEN + "Iron Golem: " + chances.getIRON_GOLEM() + "/100", null, inv, i);
			case 25:
				utils.itemToInventory(Material.BLAZE_ROD, ChatColor.GREEN + "Blaze: " + chances.getBLAZE() + "/100", null, inv, i);
			
			default:
				utils.itemToInventory(Material.BLACK_STAINED_GLASS_PANE, " ", null, inv, i);
			}
		}
		p.openInventory(inv);
	}
	
}
