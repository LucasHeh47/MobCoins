package me.LucasHeh.MobCoins.Listeners.Inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

public class BlacksmithInvListener implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InventoryView inv = p.getOpenInventory();
		
		if(!inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&6&lBlacksmith")))
			return;
		
		if(e.getCurrentItem() == null)
			return;
		
		if(e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE) {
			e.setCancelled(true);
			return;
		}
		if(e.getCurrentItem().getType() == Material.ANVIL) {
			e.setCancelled(true);
			if(inv.getItem(22) != null && p.getLevel() >= 20) {
				inv.getItem(22).setDurability((short)0);
				p.setLevel(p.getLevel()-20);
				p.getInventory().addItem(inv.getItem(22));
				inv.setItem(22, null);
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cItem slot is empty or you do not have enough exp!"));
			}
		}
	}

}
