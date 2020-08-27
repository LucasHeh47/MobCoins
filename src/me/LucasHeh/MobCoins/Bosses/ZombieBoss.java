package me.LucasHeh.MobCoins.Bosses;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class ZombieBoss extends Boss implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	public ZombieBoss() {
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onSpawn(PlayerInteractEvent e) {
		if(e.getItem() == null)
			return;
		if(e.getItem().getType() == Material.ZOMBIE_SPAWN_EGG && e.getItem().getItemMeta().getDisplayName().equals(
				ChatColor.translateAlternateColorCodes('&', "&2&lZombie Boss")) && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			e.setCancelled(true);
			Location location = e.getClickedBlock().getLocation().add(0, 1, 0);
			if(location.getX() <= 10104 && location.getX() >= 10098 &&
					location.getZ() <= 9997 && location.getZ() >= 9992 && location.getWorld().equals(Bukkit.getWorld("Spawn"))) {
				Zombie zombie = location.getWorld().spawn(location, Zombie.class);
				e.getPlayer().getInventory().remove(utils.zombieBossEgg());
				zombie.setCustomName(ChatColor.translateAlternateColorCodes('&', "&2&lZombie Boss"));
				zombie.setMaxHealth(200.0);
				zombie.setHealth(200.0);
				
				zombie.setCustomNameVisible(true);
				zombie.setBaby(false);
				
				ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
				helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 500);
				zombie.getEquipment().setHelmet(helmet);
	
				ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
				chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 500);
				zombie.getEquipment().setChestplate(chestplate);
	
				ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
				leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 500);
				zombie.getEquipment().setLeggings(leggings);
	
				ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
				boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 500);
				zombie.getEquipment().setBoots(boots);
				
				ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
				sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 100);
				zombie.getEquipment().setItemInMainHand(sword);
			} else {
				Player p = e.getPlayer();
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&cCannot spawn boss here!"));
				return;
			}
		}
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent  e) {
		if(e.getEntity().getType() == EntityType.ZOMBIE && e.getEntity().getCustomName().equals(ChatColor.translateAlternateColorCodes('&', "&2&lZombie Boss"))) {
			if(((LivingEntity)e.getEntity()).getHealth() <= 5.0) {
				Zombie zombie = (Zombie) e.getEntity();
				zombie.getEquipment().setHelmet(null);
				zombie.getEquipment().setChestplate(null);
				zombie.getEquipment().setLeggings(null);
				zombie.getEquipment().setBoots(null);
			}
			if(e.getDamager() == null) 
				return;
			if(e.getDamager() instanceof Player) {
				((Player) e.getDamager()).sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + 
						"&7Bosses HP: " + ((LivingEntity) e.getEntity()).getHealth()));
			}	
		}
	}
	
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		if(e.getEntity().getType() == EntityType.ZOMBIE && e.getEntity().getCustomName().equals(ChatColor.translateAlternateColorCodes('&', "&2&lZombie Boss"))) {
			e.setDroppedExp(1000);
			Random random = new Random();
			int amount = random.nextInt(3);
			e.getDrops().add(utils.dragonBreathFragment(amount+1));
			e.getDrops().add(new ItemStack(Material.NETHERITE_SCRAP, random.nextInt(25)));
			e.getDrops().add(new ItemStack(Material.EMERALD, random.nextInt(33)));
			e.getDrops().add(new ItemStack(Material.DIAMOND, random.nextInt(65)));
			Bukkit.dispatchCommand(main.getServer().getConsoleSender(), "crates givekey " + e.getEntity().getKiller().getName() + " champion 1");
		}
	}

}
