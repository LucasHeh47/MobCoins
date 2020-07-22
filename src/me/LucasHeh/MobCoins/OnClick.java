package me.LucasHeh.MobCoins;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnClick implements Listener{
	
	private Main main = Main.getInstance();
	
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action action = e.getAction();
		if(e.getItem() == null) 
			return;
		if(e.getItem().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&e&l» &6&lMob Coin e&l«"))) {
			
		}
		
	}

}
