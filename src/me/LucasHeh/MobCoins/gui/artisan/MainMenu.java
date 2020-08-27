package me.LucasHeh.MobCoins.gui.artisan;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class MainMenu {
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	public MainMenu(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 54, ChatColor.translateAlternateColorCodes('&', "&9&lArtisan"));
		for(int i = 0; i<inv.getSize(); i++) {
			if(i == 0) {
				inv.setItem(i, utils.dragonBreathEssence());
			} else if(i == 1) {
				inv.setItem(i, main.getItemJoin().getItemStack(p, "dragonbreath"));
			} else {
				utils.itemToInventory(Material.BLACK_STAINED_GLASS_PANE, " ", null, inv, i);
			}
		}
		p.openInventory(inv);
	}

}
