package me.LucasHeh.MobCoins.Listeners.Inventory.artisan;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class DragonBreathInvListener implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InventoryView inv = p.getOpenInventory();
		
		if(!inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&4&lDragon Breath")))
			return;
		if(e.getCurrentItem() == null) return;
		if(e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE || e.getRawSlot() == 14 || e.getRawSlot() == 15 || e.getRawSlot() == 16 || e.getRawSlot() == 23 || e.getRawSlot() == 24 || e.getRawSlot() == 25 ||
				 e.getRawSlot() == 32 || e.getRawSlot() == 33 || e.getRawSlot() == 34) {
			e.setCancelled(true);
			return;
		}
		
		if(e.getCurrentItem().getType() == Material.LIME_DYE) {
			e.setCancelled(true);
			if(inv.getItem(11).getItemMeta().getDisplayName().equals(inv.getItem(15).getItemMeta().getDisplayName()) &&
					inv.getItem(19).getItemMeta().getDisplayName().equals(inv.getItem(23).getItemMeta().getDisplayName()) &&
					inv.getItem(20).getItemMeta().getDisplayName().equals(inv.getItem(24).getItemMeta().getDisplayName()) &&
					inv.getItem(21).getItemMeta().getDisplayName().equals(inv.getItem(25).getItemMeta().getDisplayName()) &&
					inv.getItem(29).getItemMeta().getDisplayName().equals(inv.getItem(33).getItemMeta().getDisplayName())) {
				inv.setItem(11, null);
				inv.setItem(19, null);
				inv.setItem(20, main.getItemJoin().getItemStack(p, "dragonbreath"));
				inv.setItem(21, null);
				inv.setItem(29, null);
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&cRecipe does not match"));
			}
		}
	}

}
