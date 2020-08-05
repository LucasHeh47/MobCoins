package me.LucasHeh.MobCoins.Listeners.Inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import me.LucasHeh.MobCoins.gui.Menu;

public class MobChancesInvListener implements Listener{
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InventoryView inv = (InventoryView) p.getOpenInventory();
		
		if(inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&6Mob Chances")))
			e.setCancelled(true);
		if(e.getCurrentItem().getType() == Material.ARROW) {
			e.setCancelled(true);
			p.closeInventory();
			new Menu(p);
		}
	}

}
