package me.LucasHeh.MobCoins.gui.artisan;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class DragonBreath {

	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	public DragonBreath(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 45, ChatColor.translateAlternateColorCodes('&', "&4&lDragon Breath"));
		for(int i = 0; i<inv.getSize(); i++) {
			if(i == 10 || i==11 || i==12 || i==19 || i==20 || i==21 || i==28 || i==29 || i==30) {
				inv.setItem(i, null);
			} else if(i == 22) {
				utils.itemToInventory(Material.LIME_DYE, ChatColor.translateAlternateColorCodes('&', "&6&lCraft"), null, inv, i);
			} else if(i==15 || i==23 || i==25 || i== 33){
				inv.setItem(i, utils.dragonBreathEssence());
			} else if(i==24) {
				inv.setItem(i, new ItemStack(Material.BLAZE_ROD));
			} else {
				utils.itemToInventory(Material.BLACK_STAINED_GLASS_PANE, " ", null, inv, i);
			}
		}
		p.openInventory(inv);
	}

}
