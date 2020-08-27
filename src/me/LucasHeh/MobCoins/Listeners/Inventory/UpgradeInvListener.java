package me.LucasHeh.MobCoins.Listeners.Inventory;

import java.text.DecimalFormat;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
			if(inv.getItem(37) == null|| inv.getItem(43) == null) {
				return;
			}
			if(inv.getItem(37).getItemMeta().getDisplayName().equals(utils.mobCoinBoosterSword(utils.getMultiplierFromMobCoinSword(inv.getItem(37))).getItemMeta().getDisplayName()) || inv.getItem(37).getItemMeta().getDisplayName().equals(utils.superMobCoinBoosterSword(utils.getMultiplierFromMobCoinSword(inv.getItem(37))).getItemMeta().getDisplayName())){
				if(inv.getItem(37).getItemMeta().getDisplayName().equals(inv.getItem(43).getItemMeta().getDisplayName())) {
					if(utils.getMultiplierFromMobCoinSword(inv.getItem(37)) != utils.getMultiplierFromMobCoinSword(inv.getItem(43))) {
						e.setCancelled(true);
						return;
					}
					e.setCancelled(true);
					double newMultiplier = utils.getMultiplierFromMobCoinSword(inv.getItem(37))+0.2;
					Material mat = inv.getItem(37).getType();
					if(mat == Material.DIAMOND_SWORD) {
						if(newMultiplier > 3.0) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&7You already reached multiplier limit"));
							return;
						}
					}
					if(mat == Material.NETHERITE_SWORD) {
						if(newMultiplier > 5.0) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&7You already reached multiplier limit"));
							return;
						}
					}
					if(mat == Material.DIAMOND_SWORD) {
						if(inv.getItem(37).getEnchantments() != null) {
							inv.setItem(13, utils.mobCoinBoosterSword(Double.parseDouble(decimalFormat.format(newMultiplier)), inv.getItem(37).getEnchantments()));
						} else {
							inv.setItem(13, utils.mobCoinBoosterSword(Double.parseDouble(decimalFormat.format(newMultiplier))));
						}
					} else if(mat == Material.NETHERITE_SWORD) {
						if(inv.getItem(37).getEnchantments() != null) {
							inv.setItem(13, utils.superMobCoinBoosterSword(Double.parseDouble(decimalFormat.format(newMultiplier)), inv.getItem(37).getEnchantments()));
						} else {
							inv.setItem(13, utils.superMobCoinBoosterSword(Double.parseDouble(decimalFormat.format(newMultiplier))));
						}
					}
					inv.setItem(37, null);
					inv.setItem(43, null);
				}
			}
		} else if(slot == 37) {
			
		} else if (slot == 43) {
			
		} else if(slot == 13) {
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(utils.mobCoinBoosterSword(1.5).getItemMeta().getDisplayName()) || e.getCurrentItem().getItemMeta().getDisplayName().equals(utils.superMobCoinBoosterSword(1.5).getItemMeta().getDisplayName())) {
				ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(" ");
				item.setItemMeta(meta);
				p.getInventory().addItem(inv.getItem(13));
				inv.setItem(13, item);
				e.setCancelled(true);
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
