package me.LucasHeh.MobCoins.Listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class BlockSpawns implements Listener{
	
	@EventHandler
	public void onSpawn(CreatureSpawnEvent e) {
		if(e.getEntityType() == EntityType.PILLAGER)
			e.setCancelled(true);
		if(e.getEntityType() == EntityType.PHANTOM)
			e.setCancelled(true);
		if(e.getEntityType() == EntityType.ENDER_DRAGON)
			e.setCancelled(true);
		if(e.getEntityType() == EntityType.WITHER)
			e.setCancelled(true);
	}

}
