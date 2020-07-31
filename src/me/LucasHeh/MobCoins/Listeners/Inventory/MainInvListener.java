package me.LucasHeh.MobCoins.Listeners.Inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import me.LucasHeh.MobCoins.gui.TradeForCash;
import me.LucasHeh.MobCoins.gui.TradeForExp;
import me.LucasHeh.MobCoins.gui.TradeForIslandCrystal;

public class MainInvListener implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getCurrentItem() == null)
			return;
		Player p = (Player) e.getWhoClicked();
		InventoryView inv = p.getOpenInventory();
		ItemStack item = e.getCurrentItem();
		
		if(!inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&6Trade Mob Coins")))
			return;
		
		e.setCancelled(true);
		if(item.getType() == Material.PAPER)
			new TradeForCash(p);
		if(item.getType() == Material.EXPERIENCE_BOTTLE)
			new TradeForExp(p);
		if(item.getType() == Material.NETHER_STAR)
			new TradeForIslandCrystal(p);
		
	}
	
}
