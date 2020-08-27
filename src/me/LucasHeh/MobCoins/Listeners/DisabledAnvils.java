package me.LucasHeh.MobCoins.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class DisabledAnvils implements Listener{
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		if(e.getClickedBlock().getType() == Material.ANVIL)
			e.setCancelled(true);
	}

}
