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
import net.milkbowl.vault.economy.Economy;

public class TradeForCashInvListener implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	private double cashPerCoin = 5000;
	
	private Economy econ = main.getEconomy();
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InventoryView inv = (InventoryView) p.getOpenInventory();
		
		if(!inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&6MobCoins &7» &2Cash")))
			return;
		
		int slot = e.getSlot();
		e.setCancelled(true);
		System.out.println("click");
		switch(slot) {
			case 9:
				if(utils.getMobCoinMap().get(utils.getPlayersUUID(p)) >= 1) {
					utils.getMobCoinMap().put(utils.getPlayersUUID(p), utils.getMobCoinMap().get(utils.getPlayersUUID(p)).intValue()-1);
					econ.depositPlayer(p, cashPerCoin);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, 1);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cNot enough MobCoins"));
				}
				break;
			case 11:
				if(utils.getMobCoinMap().get(utils.getPlayersUUID(p)) >= 8) {
					utils.getMobCoinMap().put(utils.getPlayersUUID(p), utils.getMobCoinMap().get(utils.getPlayersUUID(p))-8);
					econ.depositPlayer(p, cashPerCoin*8);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, 1);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cNot enough MobCoins"));
				}
				break;
			case 13:
				if(utils.getMobCoinMap().get(utils.getPlayersUUID(p)) >= 16) {
					utils.getMobCoinMap().put(utils.getPlayersUUID(p), utils.getMobCoinMap().get(utils.getPlayersUUID(p))-16);
					econ.depositPlayer(p, cashPerCoin*16);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, 1);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cNot enough MobCoins"));
				}
				break;
			case 15:
				if(utils.getMobCoinMap().get(utils.getPlayersUUID(p)) >= 32) {
					utils.getMobCoinMap().put(utils.getPlayersUUID(p), utils.getMobCoinMap().get(utils.getPlayersUUID(p))-32);
					econ.depositPlayer(p, cashPerCoin*32);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, 1);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cNot enough MobCoins"));
				}
				break;
			case 17:
				if(utils.getMobCoinMap().get(utils.getPlayersUUID(p)) >= 64) {
					utils.getMobCoinMap().put(utils.getPlayersUUID(p), utils.getMobCoinMap().get(utils.getPlayersUUID(p))-64);
					econ.depositPlayer(p, cashPerCoin*64);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2F, 1);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC » &cNot enough MobCoins"));
				}
				break;
			default:
				break;
		}
		
	}

}
