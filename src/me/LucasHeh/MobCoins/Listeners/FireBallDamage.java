package me.LucasHeh.MobCoins.Listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class FireBallDamage implements Listener{
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if(e.getDamager() == null)
			return;
		if(e.getDamager().getType() == EntityType.FIREBALL) {
			e.setDamage(20.0);
		}
	}

}
