package me.LucasHeh.MobCoins.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class OnClick implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action action = e.getAction();
		if(e.getItem() == null) 
			return;
		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(e.getItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&e&l» &6&lMob Coin &e&l«"))) {
				int amount = 0;
				for(ItemStack item : p.getInventory().getContents()) {
					if(item == utils.mobCoinItem())
						amount++;
				}
				ItemStack item = utils.mobCoinItem();
				item.setAmount(amount);
				p.getInventory().remove(item);
				utils.getMobCoinMap().put(p.getUniqueId().toString(), utils.getMobCoinMap().get(p.getUniqueId().toString())+amount);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
						"&b&lPrimalMC » &7Redeemed &b" + amount + " Mob Coins"));
				return;
			}
		}
		
	}

}
