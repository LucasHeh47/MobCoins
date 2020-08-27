package me.LucasHeh.MobCoins.Bosses;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class Boss {
	
	@EventHandler
	public abstract void onSpawn(PlayerInteractEvent e);

	@EventHandler
	public abstract void onHit(EntityDamageByEntityEvent  e);

	@EventHandler
	public abstract void onDeath(EntityDeathEvent e);
}
