package me.LucasHeh.MobCoins.Listeners.Inventory;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class TradeForExpInvListener implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	private int expPerCoin = 1500;
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InventoryView inv = (InventoryView) p.getOpenInventory();
		
		if(!inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&6MobCoins &7» &eExperience")))
			return;
		
		int slot = e.getSlot();
		e.setCancelled(true);
		
		switch(slot) {
			case 9:
				if(utils.getMobCoinMap().get(utils.getPlayersUUID(p)) >= 1) {
					utils.getMobCoinMap().put(utils.getPlayersUUID(p), utils.getMobCoinMap().get(utils.getPlayersUUID(p))-1);
					p.giveExp(expPerCoin);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, 1);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cNot enough MobCoins"));
				}
			case 11:
				if(utils.getMobCoinMap().get(utils.getPlayersUUID(p)) >= 8) {
					utils.getMobCoinMap().put(utils.getPlayersUUID(p), utils.getMobCoinMap().get(utils.getPlayersUUID(p))-8);
					p.giveExp(expPerCoin*8);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, 1);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cNot enough MobCoins"));
				}
			case 13:
				if(utils.getMobCoinMap().get(utils.getPlayersUUID(p)) >= 16) {
					utils.getMobCoinMap().put(utils.getPlayersUUID(p), utils.getMobCoinMap().get(utils.getPlayersUUID(p))-16);
					p.giveExp(expPerCoin*16);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, 1);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cNot enough MobCoins"));
				}
			case 15:
				if(utils.getMobCoinMap().get(utils.getPlayersUUID(p)) >= 32) {
					utils.getMobCoinMap().put(utils.getPlayersUUID(p), utils.getMobCoinMap().get(utils.getPlayersUUID(p))-32);
					p.giveExp(expPerCoin*32);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, 1);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cNot enough MobCoins"));
				}
			case 17:
				if(utils.getMobCoinMap().get(utils.getPlayersUUID(p)) >= 64) {
					utils.getMobCoinMap().put(utils.getPlayersUUID(p), utils.getMobCoinMap().get(utils.getPlayersUUID(p))-64);
					p.giveExp(expPerCoin*64);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, 1);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cNot enough MobCoins"));
				}
		}
		
	}

}
