package me.LucasHeh.MobCoins.Listeners;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class CustomDrops implements Listener {

	@EventHandler
	public void onDrop(EntityDeathEvent e) {
		Entity entity = e.getEntity();
		EntityType entityType = entity.getType();
		Random random = new Random();
		
		int three = random.nextInt(4);
		int two = random.nextInt(3);
		int four = random.nextInt(5);
		
		if(entity.getType() == EntityType.VINDICATOR) {
			for(int i = e.getDrops().size() ; i >= 0 ; i++) {
				ItemStack item = e.getDrops().get(i);
				if(item.getType() == Material.IRON_AXE || item.getType() == Material.WHITE_BANNER)
					e.getDrops().remove(i);
			}
		} else if(entity.getType() == EntityType.GUARDIAN) {
			ItemStack item = new ItemStack(Material.DIAMOND, three);
			if(e.getEntity().getKiller() != null && e.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)) {
				int looting = random.nextInt(e.getEntity().getKiller().getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_MOBS));
				Player p = e.getEntity().getKiller();
				item.setAmount(three+looting);
			}
			e.getDrops().add(item);
		} else if(entity.getType() == EntityType.SILVERFISH) {
			ItemStack item = new ItemStack(Material.QUARTZ, two);
			if(e.getEntity().getKiller() != null && e.getEntity().getKiller().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)) {
				int looting = random.nextInt(e.getEntity().getKiller().getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_MOBS));
				Player p = e.getEntity().getKiller();
				item.setAmount(three+looting);
			}
			e.getDrops().add(item);
		}
	}
	
}