package me.LucasHeh.MobCoins.Listeners;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class CustomDrops implements Listener {

	@EventHandler
	public void onDrop(EntityDeathEvent e) {
		Entity entity = e.getEntity();
		Random random = new Random();
		
		int three = random.nextInt(4);
		int two = random.nextInt(3);
		
		if(entity.getType() == EntityType.VINDICATOR) {
			if(e.getDrops().size() <= 0) {
				return;
			}
			for(int i = 0; i<e.getDrops().size(); i++) {
				ItemStack item = e.getDrops().get(i);
				if(item.getType() == Material.IRON_AXE || item.getType() == Material.WHITE_BANNER)
					e.getDrops().remove(i);
			}
		} else if(entity.getType() == EntityType.GUARDIAN) {
			ItemStack item = new ItemStack(Material.DIAMOND, three);
			if(e.getEntity().getKiller() != null && e.getEntity().getKiller().getInventory().getItemInMainHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)) {
				int looting = random.nextInt(e.getEntity().getKiller().getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_MOBS));
				item.setAmount(three+looting);
			}
			e.getDrops().add(item);
		} else if(entity.getType() == EntityType.SILVERFISH) {
			ItemStack item = new ItemStack(Material.QUARTZ, two);
			if(e.getEntity().getKiller() != null && e.getEntity().getKiller().getInventory().getItemInMainHand().containsEnchantment(Enchantment.LOOT_BONUS_MOBS)) {
				int looting = random.nextInt(e.getEntity().getKiller().getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_MOBS));
				item.setAmount(three+looting);
			}
			e.getDrops().add(item);
		} else if(entity.getType() == EntityType.WITHER_SKELETON) {
			ItemStack item = new ItemStack(Material.NETHERITE_SCRAP, 1);
			int resultWS = random.nextInt(25);
			if(resultWS == 16) {
				e.getDrops().add(item);
			}
		} else if(entity.getType() == EntityType.ZOMBIFIED_PIGLIN) {
			ItemStack item = new ItemStack(Material.GOLD_INGOT, three);
			e.getDrops().add(item);
		}
	}
	
}
