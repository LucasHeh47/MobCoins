package me.LucasHeh.MobCoins.Listeners.Inventory;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import com.iridium.iridiumskyblock.User;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class TradeForIslandCrystalInvListener {
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	private HashMap<String, Integer> map = utils.getMobCoinMap();
	
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		String id = utils.getPlayersUUID(p);
		InventoryView inv = (InventoryView) e.getWhoClicked().getInventory();
		if(!inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "6MobCoins &7� &bIsland Crystals")))
			return;
		
		int slot = e.getSlot();
		e.setCancelled(true);
		
		switch(slot) {
			case 9:
				if(map.get(utils.getPlayersUUID(p)) >= 1) {
					if(User.getUser(p).getIsland() == null) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC � &cNot on an island!"));
						break;
					}
					map.put(id, map.get(id)-1);
					User.getUser(p).getIsland().setCrystals(User.getUser(p).getIsland().getCrystals()+5);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC � &cNot enough MobCoins"));
				}
				break;
			case 11:
				if(map.get(utils.getPlayersUUID(p)) >= 8) {
					if(User.getUser(p).getIsland() == null) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC � &cNot on an island!"));
						break;
					}
					map.put(id, map.get(id)-8);
					User.getUser(p).getIsland().setCrystals(User.getUser(p).getIsland().getCrystals()+5*8);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC � &cNot enough MobCoins"));
				}
				break;
			case 13:
				if(map.get(utils.getPlayersUUID(p)) >= 16) {
					if(User.getUser(p).getIsland() == null) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC � &cNot on an island!"));
						break;
					}
					map.put(id, map.get(id)-16);
					User.getUser(p).getIsland().setCrystals(User.getUser(p).getIsland().getCrystals()+5*16);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC � &cNot enough MobCoins"));
				}
				break;
			case 15:
				if(map.get(utils.getPlayersUUID(p)) >= 32) {
					if(User.getUser(p).getIsland() == null) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC � &cNot on an island!"));
						break;
					}
					map.put(id, map.get(id)-32);
					User.getUser(p).getIsland().setCrystals(User.getUser(p).getIsland().getCrystals()+5*32);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC � &cNot enough MobCoins"));
				}
				break;
			case 17:
				if(map.get(utils.getPlayersUUID(p)) >= 64) {
					if(User.getUser(p).getIsland() == null) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC � &cNot on an island!"));
						break;
					}
					map.put(id, map.get(id)-64);
					User.getUser(p).getIsland().setCrystals(User.getUser(p).getIsland().getCrystals()+5*64);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lPrimalMC � &cNot enough MobCoins"));
				}
				break;
			
			default:
				break;
		}
		
	}

}
