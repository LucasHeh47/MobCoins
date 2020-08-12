package me.LucasHeh.MobCoins.Listeners.Inventory;

import java.text.DecimalFormat;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class UpgradeInvListener implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	private DecimalFormat decimalFormat = utils.getDecimalFortmat();
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InventoryView inv = p.getOpenInventory();
		
		if(!inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&9&lUpgrade Swords")))
			return;
		
		int slot = e.getSlot();
		
		if(slot == 40) {
			e.setCancelled(true);
			if(inv.getItem(37).getItemMeta().getDisplayName().equals(utils.mobCoinBoosterSword(utils.getMultiplierFromMobCoinSword(inv.getItem(37))).getItemMeta().getDisplayName()) || inv.getItem(37).getItemMeta().getDisplayName().equals(utils.superMobCoinBoosterSword(utils.getMultiplierFromMobCoinSword(inv.getItem(37))).getItemMeta().getDisplayName())){
				if(inv.getItem(37).isSimilar(inv.getItem(43))) {
					e.setCancelled(true);
					double newMultiplier = utils.getMultiplierFromMobCoinSword(inv.getItem(37))+0.2;
					if(newMultiplier > 5.0) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&7You already reached multiplier limit"));
						return;
					}
					Material mat = inv.getItem(37).getType();
					if(mat == Material.DIAMOND_SWORD) {
						inv.setItem(13, utils.mobCoinBoosterSword(Double.parseDouble(decimalFormat.format(newMultiplier))));
					} else if(mat == Material.NETHERITE_SWORD) {
						inv.setItem(13, utils.superMobCoinBoosterSword(Double.parseDouble(decimalFormat.format(newMultiplier))));
					}
					inv.setItem(37, null);
					inv.setItem(43, null);
				}
			}
		} else if(slot == 37) {
			
		} else if (slot == 43) {
			
		} else if(slot == 13) {
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(utils.mobCoinBoosterSword(1.5).getItemMeta().getDisplayName()) || e.getCurrentItem().getItemMeta().getDisplayName().equals(utils.superMobCoinBoosterSword(1.5).getItemMeta().getDisplayName())) {
				
			} else {
				e.setCancelled(true);
			}
		} else {
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(utils.mobCoinBoosterSword(1.5).getItemMeta().getDisplayName()) ||
					e.getCurrentItem().getItemMeta().getDisplayName().equals(utils.superMobCoinBoosterSword(1.5).getItemMeta().getDisplayName())) {
				
			} else {
				e.setCancelled(true);
			}
		}
		
	}

}
