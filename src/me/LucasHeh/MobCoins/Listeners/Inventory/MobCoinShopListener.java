package me.LucasHeh.MobCoins.Listeners.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class MobCoinShopListener implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InventoryView inv = p.getOpenInventory();
		
		if(!inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&6&lMob Coin Shop")))
			return;
		
		e.setCancelled(true);
		if(e.getCurrentItem().getType() == Material.NETHER_STAR && e.getCurrentItem().getItemMeta().getDisplayName().equals
				(ChatColor.translateAlternateColorCodes('&', "&6&lDeluxe Crate Key"))) {
			if(utils.getMobCoinMap().get(p.getUniqueId().toString()) >= 75) {
				utils.getMobCoinMap().put(p.getUniqueId().toString(), utils.getMobCoinMap().get(p.getUniqueId().toString())-75);
				Bukkit.getServer().dispatchCommand(main.getServer().getConsoleSender(), "crates givekey " + p.getName() + " deluxe 1");
				return;
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + 
						"&6Not enough MobCoins (Don't forget to redeem mobcoins)"));
				return;
			}
		} else if(e.getCurrentItem().getType() == Material.NETHER_STAR && e.getCurrentItem().getItemMeta().getDisplayName().equals
				(ChatColor.translateAlternateColorCodes('&', "&a&lCash Crate Key"))) {
			if(utils.getMobCoinMap().get(p.getUniqueId().toString()) >= 100) {
				utils.getMobCoinMap().put(p.getUniqueId().toString(), utils.getMobCoinMap().get(p.getUniqueId().toString())-100);
				Bukkit.getServer().dispatchCommand(main.getServer().getConsoleSender(), "crates givekey " + p.getName() + " cash 1");
				return;
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + 
						"&6Not enough MobCoins (Don't forget to redeem mobcoins)"));
				return;
			}
		} else if(e.getCurrentItem().getType() == Material.EMERALD_BLOCK && e.getCurrentItem().getItemMeta().getDisplayName().equals
				(ChatColor.translateAlternateColorCodes('&', "&aPlanet Minecraft Vote"))) {
			if(utils.getMobCoinMap().get(p.getUniqueId().toString()) >= 50) {
				utils.getMobCoinMap().put(p.getUniqueId().toString(), utils.getMobCoinMap().get(p.getUniqueId().toString())-50);
				Bukkit.getServer().dispatchCommand(main.getServer().getConsoleSender(), "av vote " + p.getName() + " PlanetMinecraft");
				return;
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + 
						"&6Not enough MobCoins (Don't forget to redeem mobcoins)"));
				return;
			}
		} else if(e.getCurrentItem().getType() == Material.SPAWNER && e.getCurrentItem().getItemMeta().getDisplayName().equals
				(ChatColor.translateAlternateColorCodes('&', "&cWither Skeleton Spawner"))) {
			if(utils.getMobCoinMap().get(p.getUniqueId().toString()) >= 1500) {
				utils.getMobCoinMap().put(p.getUniqueId().toString(), utils.getMobCoinMap().get(p.getUniqueId().toString())-1500);
				Bukkit.getServer().dispatchCommand(main.getServer().getConsoleSender(), "ms give " + p.getName() + " wither_skeleton 1");
				return;
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + 
						"&6Not enough MobCoins (Don't forget to redeem mobcoins)"));
				return;
			}
		} else if(e.getCurrentItem().getType() == Material.SPAWNER && e.getCurrentItem().getItemMeta().getDisplayName().equals
				(ChatColor.translateAlternateColorCodes('&', "&6Zombified Piglin Spawner"))) {
			if(utils.getMobCoinMap().get(p.getUniqueId().toString()) >= 500) {
				utils.getMobCoinMap().put(p.getUniqueId().toString(), utils.getMobCoinMap().get(p.getUniqueId().toString())-500);
				Bukkit.getServer().dispatchCommand(main.getServer().getConsoleSender(), "ms give " + p.getName() + " zombified_piglin 1");
				return;
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + 
						"&6Not enough MobCoins (Don't forget to redeem mobcoins)"));
				return;
			}
		} else if(e.getCurrentItem().getType() == Material.ZOMBIE_SPAWN_EGG && e.getCurrentItem().getItemMeta()
				.getDisplayName().equals(utils.zombieBossEgg().getItemMeta().getDisplayName())) {
			if(utils.getMobCoinMap().get(p.getUniqueId().toString()) >= 500) {
				utils.getMobCoinMap().put(p.getUniqueId().toString(), utils.getMobCoinMap().get(p.getUniqueId().toString())-500);
				p.getInventory().addItem(utils.zombieBossEgg());
				return;
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + 
						"&6Not enough MobCoins (Don't forget to redeem mobcoins)"));
				return;
			}
		} else if(e.getCurrentItem().getType() == Material.SKELETON_SPAWN_EGG && e.getCurrentItem().getItemMeta()
				.getDisplayName().equals(utils.skeletonBossEgg().getItemMeta().getDisplayName())) {
			if(utils.getMobCoinMap().get(p.getUniqueId().toString()) >= 750) {
				utils.getMobCoinMap().put(p.getUniqueId().toString(), utils.getMobCoinMap().get(p.getUniqueId().toString())-750);
				p.getInventory().addItem(utils.skeletonBossEgg());
				return;
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + 
						"&6Not enough MobCoins (Don't forget to redeem mobcoins)"));
				return;
			}
		} else if(e.getCurrentItem().getType() == Material.WITHER_SKELETON_SPAWN_EGG && e.getCurrentItem().getItemMeta()
				.getDisplayName().equals(utils.witherSkeletonBossEgg().getItemMeta().getDisplayName())) {
			if(utils.getMobCoinMap().get(p.getUniqueId().toString()) >= 1000) {
				utils.getMobCoinMap().put(p.getUniqueId().toString(), utils.getMobCoinMap().get(p.getUniqueId().toString())-1000);
				p.getInventory().addItem(utils.witherSkeletonBossEgg());
				return;
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + 
						"&6Not enough MobCoins (Don't forget to redeem mobcoins)"));
				return;
			}
		}
	}

}
