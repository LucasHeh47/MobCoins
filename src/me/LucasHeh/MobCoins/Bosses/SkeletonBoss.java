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
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class SkeletonBoss extends Boss implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	public SkeletonBoss() {
		
	}

	@SuppressWarnings("deprecation")
	@Override
	@EventHandler
	public void onSpawn(PlayerInteractEvent e) {
		if(e.getItem() == null)
			return;
		if(e.getItem().getType() == Material.SKELETON_SPAWN_EGG && e.getItem().getItemMeta().getDisplayName().equals(
				ChatColor.translateAlternateColorCodes('&', "&7&lSkeleton Boss")) && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			e.setCancelled(true);
			Location location = e.getClickedBlock().getLocation().add(0, 1, 0);
			if(location.getX() <= 10104 && location.getX() >= 10098 &&
					location.getZ() <= 9997 && location.getZ() >= 9992 && location.getWorld().equals(Bukkit.getWorld("Spawn"))) {
				e.getPlayer().getInventory().remove(utils.skeletonBossEgg());
				Skeleton boss = location.getWorld().spawn(location, Skeleton.class);
				
				boss.setCustomName(ChatColor.translateAlternateColorCodes('&', "&7&lSkeleton Boss"));
				boss.setMaxHealth(200.0);
				boss.setHealth(200.0);
				
				boss.setCustomNameVisible(true);
				
				ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
				helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 300);
				boss.getEquipment().setHelmet(helmet);
	
				ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
				chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 300);
				boss.getEquipment().setChestplate(chestplate);
	
				ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
				leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 300);
				boss.getEquipment().setLeggings(leggings);
	
				ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
				boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 300);
				boss.getEquipment().setBoots(boots);
				
				ItemStack bow = new ItemStack(Material.BOW);
				bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 75);
				bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
				boss.getEquipment().setItemInMainHand(bow);
			} else {
				Player p = e.getPlayer();
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&cCannot spawn boss here!"));
				return;
			}
		}
	}

	@Override
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if(e.getEntity().getType() == EntityType.SKELETON && e.getEntity().getCustomName().equals(ChatColor.translateAlternateColorCodes('&', "&7&lSkeleton Boss"))) {
			if(((LivingEntity)e.getEntity()).getHealth() <= 5.0) {
				Skeleton skeleton = (Skeleton) e.getEntity();
				skeleton.getEquipment().setHelmet(null);
				skeleton.getEquipment().setChestplate(null);
				skeleton.getEquipment().setLeggings(null);
				skeleton.getEquipment().setBoots(null);
			}
			if(e.getDamager() == null) 
				return;
			if(e.getDamager() instanceof Player) {
				((Player) e.getDamager()).sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + 
						"&7Bosses HP: " + ((LivingEntity) e.getEntity()).getHealth()));
			}	
		}
	}

	@Override
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		if(e.getEntity().getType() == EntityType.SKELETON && e.getEntity().getCustomName().equals(ChatColor.translateAlternateColorCodes('&', "&7&lSkeleton Boss"))) {
			e.setDroppedExp(1000);
			
			Random random = new Random();
			int amount = random.nextInt(4);
			e.getDrops().add(utils.dragonBreathFragment(amount+1));
			e.getDrops().add(new ItemStack(Material.NETHERITE_SCRAP, random.nextInt(65)));
			e.getDrops().add(new ItemStack(Material.EMERALD, random.nextInt(129)));
			e.getDrops().add(new ItemStack(Material.DIAMOND, random.nextInt(257)));
			Bukkit.dispatchCommand(main.getServer().getConsoleSender(), "crates givekey " + e.getEntity().getKiller().getName() + " legendary 1");
		}
	}

}
