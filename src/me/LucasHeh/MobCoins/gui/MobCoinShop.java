package me.LucasHeh.MobCoins.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class MobCoinShop {

	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	public MobCoinShop(Player p) {
		openInv(p);
	}
	
	public void openInv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 9, ChatColor.translateAlternateColorCodes('&', "&6&lMob Coin Shop"));
		for(int i = 0; i < inv.getSize(); i++) {
			if(i == 0) {
				utils.itemToInventory(Material.NETHER_STAR, ChatColor.translateAlternateColorCodes('&', "&6&lDeluxe Crate Key"), 
						new ArrayList<String>(Arrays.asList("&675 MobCoins")), inv, i);
			} else if(i == 1) {
				utils.itemToInventory(Material.NETHER_STAR, ChatColor.translateAlternateColorCodes('&', "&a&lCash Crate Key"), 
						new ArrayList<String>(Arrays.asList("&6100 MobCoins")), inv, i);
			} else if(i == 2) {
				utils.itemToInventory(Material.EMERALD_BLOCK, ChatColor.translateAlternateColorCodes('&',
						"&aPlanet Minecraft Vote"), new ArrayList<String>(Arrays.asList("&650 MobCoins")), inv, i);
			} else if(i == 3) {
				utils.itemToInventory(Material.SPAWNER, ChatColor.translateAlternateColorCodes('&', 
						"&cWither Skeleton Spawner"), new ArrayList<String>(Arrays.asList("&61500 MobCoins")), inv, i);
			} else if(i == 4) {
				utils.itemToInventory(Material.SPAWNER, ChatColor.translateAlternateColorCodes('&', 
						"&6Zombified Piglin Spawner"), new ArrayList<String>(Arrays.asList("&6500 MobCoins")), inv, i);
			} else if(i == 5) {
				ItemStack item = utils.zombieBossEgg();
				ItemMeta meta = item.getItemMeta();
				List<String> lore = meta.getLore();
				lore.add(" ");
				lore.add(ChatColor.translateAlternateColorCodes('&', "&6500 MobCoins"));
				meta.setLore(lore);
				item.setItemMeta(meta);
				inv.setItem(i, item);
			} else if(i == 6) {
				ItemStack item = utils.skeletonBossEgg();
				ItemMeta meta = item.getItemMeta();
				List<String> lore = meta.getLore();
				lore.add(" ");
				lore.add(ChatColor.translateAlternateColorCodes('&', "&6750 MobCoins"));
				meta.setLore(lore);
				item.setItemMeta(meta);
				inv.setItem(i, item);
			} else if(i == 7) {
				ItemStack item = utils.witherSkeletonBossEgg();
				ItemMeta meta = item.getItemMeta();
				List<String> lore = meta.getLore();
				lore.add(" ");
				lore.add(ChatColor.translateAlternateColorCodes('&', "&61000 MobCoins"));
				meta.setLore(lore);
				item.setItemMeta(meta);
				inv.setItem(i, item);
			} else {
				utils.itemToInventory(Material.BLACK_STAINED_GLASS_PANE, ChatColor.translateAlternateColorCodes('&', 
						"&cMore Soon!"), null, inv, i);
			}
		}
		p.openInventory(inv);
	}
	
}
