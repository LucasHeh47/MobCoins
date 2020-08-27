package me.LucasHeh.MobCoins.Listeners.Inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import com.iridium.iridiumskyblock.User;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;
import me.LucasHeh.MobCoins.gui.Menu;

public class TradeInvListener implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory inventory = e.getClickedInventory();
		InventoryView inv = p.getOpenInventory();
		
		if(!inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&b&lTrading Mob Coins")))
			return;
		if(e.getCurrentItem() == null)
			return;
		if(e.getCurrentItem().getType() != Material.SUNFLOWER)
			e.setCancelled(true);
		if(e.getSlot() == 40) {
			return;
		} else {
			if(e.getCurrentItem().getType() == Material.EXPERIENCE_BOTTLE) {
				ItemStack item = inv.getItem(40);
				if(!item.getItemMeta().getDisplayName().equals(utils.mobCoinItem().getItemMeta().getDisplayName())) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&7Item is not a Mob Coin"));
				} else {
					ItemStack mobcoins = inv.getItem(40);
					int amount = mobcoins.getAmount();
					inventory.setItem(40, new ItemStack(Material.LAVA_BUCKET));
					p.updateInventory();
					p.giveExp(amount*utils.getExpPerCoin());
					p.closeInventory();
				}
			} else if(e.getCurrentItem().getType() == Material.EMERALD) {
				ItemStack item = inv.getItem(40);
				if(!item.getItemMeta().getDisplayName().equals(utils.mobCoinItem().getItemMeta().getDisplayName())) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&7Item is not a Mob Coin"));
				} else {
					ItemStack mobcoins = inv.getItem(40);
					int amount = mobcoins.getAmount();
					inventory.setItem(40, new ItemStack(Material.LAVA_BUCKET));
					p.updateInventory();
					main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "eco give " + p.getName() + " " + amount*utils.getCashPerCoin());
					p.closeInventory();
				}
			} else if(e.getCurrentItem().getType() == Material.NETHER_STAR) {
				ItemStack item = inv.getItem(40);
				if(!item.getItemMeta().getDisplayName().equals(utils.mobCoinItem().getItemMeta().getDisplayName())) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&7Item is not a Mob Coin"));
				} else {
					ItemStack mobcoins = inv.getItem(40);
					int amount = mobcoins.getAmount();
					inventory.setItem(40, new ItemStack(Material.LAVA_BUCKET));
					p.updateInventory();
					User.getUser(p).getIsland().setCrystals(User.getUser(p).getIsland().getCrystals()+(amount*utils.getCrystalsPerCoin()));
					p.closeInventory();
				}
			} else if(e.getCurrentItem().getType() == Material.ARROW) {
				p.closeInventory();
				new Menu(p);
			}
		}
		
	}

}


// Current item is item that was there already and then you clicked on it