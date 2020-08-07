package me.LucasHeh.MobCoins.Listeners;

import java.util.Random;

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
		int result = random.nextInt(101);
		if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(utils.mobCoinBoosterSword().getItemMeta().getDisplayName()))
			multiplier = 2.0;
		if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(utils.superMobCoinBoosterSword().getItemMeta().getDisplayName()))
			multiplier = 3.0;
		if(e.getEntityType() == EntityType.BLAZE) {
			if(result <= chances.getBLAZE()*multiplier) {
				e.getDrops().add(utils.mobCoinItem());
				return;
			}
		} else if(e.getEntityType() == EntityType.ZOMBIE) {
			if(result <= chances.getZOMBIE()*multiplier) {
				p.getInventory().addItem(utils.mobCoinItem());
				return;
			}
		} else if(e.getEntityType() == EntityType.SKELETON) {
			if(result <= chances.getSKELETON()*multiplier) {
				p.getInventory().addItem(utils.mobCoinItem());
				return;
			}
		} else if(e.getEntityType() == EntityType.IRON_GOLEM) {
			if(result <= chances.getIRON_GOLEM()*multiplier) {
				p.getInventory().addItem(utils.mobCoinItem());
				return;
			}
		} else if(e.getEntityType() == EntityType.MUSHROOM_COW) {
			if(result <= chances.getMOOSHROOM()*multiplier) {
				p.getInventory().addItem(utils.mobCoinItem());
				return;
			}
		} else if(e.getEntityType() == EntityType.CREEPER) {
			if(result <= chances.getCREEPER()*multiplier) {
				p.getInventory().addItem(utils.mobCoinItem());
				return;
			}
		} else if(e.getEntityType() == EntityType.WITCH) {
			if(result <= chances.getWITCH()*multiplier) {
				p.getInventory().addItem(utils.mobCoinItem());
				return;
			}
		}
	}

}
