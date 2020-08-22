package me.LucasHeh.MobCoins.Listeners;

import java.util.Random;

import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.LucasHeh.MobCoins.Chances;
import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class MobDrop implements Listener{
	
	private Random random = new Random();
	private Main main = Main.getInstance();
	private Chances chances = main.getMobChances();
	private Utils utils = main.getUtils();
	
	private double multiplier = 1.0;
	
	@EventHandler
	public void onDrop(EntityDeathEvent e) {
		if(e.getEntity() instanceof Player)
			return;
		Player p = e.getEntity().getKiller();
		if(p == null)
			return;
		double result = 0 + (100 - 0) * random.nextDouble();
		if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(utils.mobCoinBoosterSword(1.0).getItemMeta().getDisplayName()))
			multiplier = utils.getMultiplierFromMobCoinSword(p.getInventory().getItemInMainHand());
		if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(utils.superMobCoinBoosterSword(1.0).getItemMeta().getDisplayName()))
			multiplier = utils.getMultiplierFromMobCoinSword(p.getInventory().getItemInMainHand());
		
		if(e.getEntityType() == EntityType.BLAZE) {
			if(result <= chances.getBLAZE()*multiplier) {
				e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 0.5F);
				e.getDrops().add(utils.mobCoinItem());
				return;
			}
		} else if(e.getEntityType() == EntityType.ZOMBIE) {
			if(result <= chances.getZOMBIE()*multiplier) {
				e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 0.5F);
				e.getDrops().add(utils.mobCoinItem());
				return;
			}
		} else if(e.getEntityType() == EntityType.SKELETON) {
			if(result <= chances.getSKELETON()*multiplier) {
				e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 0.5F);
				e.getDrops().add(utils.mobCoinItem());
				return;
			}
		} else if(e.getEntityType() == EntityType.IRON_GOLEM) {
			if(result <= chances.getIRON_GOLEM()*multiplier) {
				e.getDrops().add(utils.mobCoinItem());
				return;
			}
		} else if(e.getEntityType() == EntityType.MUSHROOM_COW) {
			if(result <= chances.getMOOSHROOM()*multiplier) {
				e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 0.5F);
				e.getDrops().add(utils.mobCoinItem());
				return;
			}
		} else if(e.getEntityType() == EntityType.CREEPER) {
			if(result <= chances.getCREEPER()*multiplier) {
				e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 0.5F);
				e.getDrops().add(utils.mobCoinItem());
				return;
			}
		} else if(e.getEntityType() == EntityType.WITCH) {
			if(result <= chances.getWITCH()*multiplier) {
				e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_CHICKEN_EGG, 3.0F, 0.5F);
				e.getDrops().add(utils.mobCoinItem());
				return;
			}
		}
	}

}
