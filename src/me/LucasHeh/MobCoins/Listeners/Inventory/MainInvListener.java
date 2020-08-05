package me.LucasHeh.MobCoins.Listeners.Inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import me.LucasHeh.MobCoins.gui.Menu;
import me.LucasHeh.MobCoins.gui.MobChances;
import me.LucasHeh.MobCoins.gui.Trade;

public class MainInvListener implements Listener{
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InventoryView inv = p.getOpenInventory();
		
		if(!inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&6&lMob Coins Menu")))
			return;
		
		if(e.getCurrentItem() == null)
			return;
		if(e.getCurrentItem().getType() == Material.ZOMBIE_SPAWN_EGG) {
			e.setCancelled(true);
			new MobChances(p);
		} else if(e.getCurrentItem().getType() == Material.SUNFLOWER) {
			e.setCancelled(true);
			new Trade(p);
		} else if(e.getCurrentItem().getType() == Material.BARRIER) {
			e.setCancelled(true);
			p.closeInventory();
		} else if(e.getCurrentItem().getType() == Material.ARROW) {
			e.setCancelled(true);
			p.closeInventory();
			new Menu(p);
		} else {
			e.setCancelled(true);
		}
		
	}

}
