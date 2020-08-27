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
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class WitherSkeletonBoss extends Boss implements Listener {
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();

	@SuppressWarnings("deprecation")
	@Override
	@EventHandler
	public void onSpawn(PlayerInteractEvent e) {
		if(e.getItem() == null)
			return;
		if(e.getItem().getType() == Material.WITHER_SKELETON_SPAWN_EGG && e.getItem().getItemMeta().getDisplayName().equals(
				ChatColor.translateAlternateColorCodes('&', "&c&lWither Skeleton Boss")) && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			e.setCancelled(true);
			Location location = e.getClickedBlock().getLocation().add(0, 1, 0);
			if(location.getX() <= 10104 && location.getX() >= 10098 &&
					location.getZ() <= 9997 && location.getZ() >= 9992 && location.getWorld().equals(Bukkit.getWorld("Spawn"))) {
				WitherSkeleton boss = location.getWorld().spawn(location, WitherSkeleton.class);
				e.getPlayer().getInventory().remove(utils.witherSkeletonBossEgg());
				boss.setCustomName(ChatColor.translateAlternateColorCodes('&', "&2&lZombie Boss"));
				boss.setMaxHealth(250.0);
				boss.setHealth(250.0);
				
				boss.setCustomNameVisible(true);
				boss.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
				
				ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
				helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 350);
				boss.getEquipment().setHelmet(helmet);
	
				ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
				chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 350);
				boss.getEquipment().setChestplate(chestplate);
	
				ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
				leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 350);
				boss.getEquipment().setLeggings(leggings);
	
				ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
				boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 350);
				boss.getEquipment().setBoots(boots);
				
				ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
				sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 100);
				boss.getEquipment().setItemInMainHand(sword);
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
		if(e.getEntity().getType() == EntityType.WITHER_SKELETON && e.getEntity().getCustomName().equals(ChatColor.translateAlternateColorCodes('&', "&c&lWither Skeleton Boss"))) {
			if(((LivingEntity)e.getEntity()).getHealth() <= 5.0) {
				WitherSkeleton boss = (WitherSkeleton) e.getEntity();
				boss.getEquipment().setHelmet(null);
				boss.getEquipment().setChestplate(null);
				boss.getEquipment().setLeggings(null);
				boss.getEquipment().setBoots(null);
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
		if(e.getEntity().getType() == EntityType.WITHER_SKELETON && e.getEntity().getCustomName().equals(ChatColor.translateAlternateColorCodes('&', "&c&lWither Skeleton Boss"))) {
			e.setDroppedExp(2500);
			Random random = new Random();
			int amount = random.nextInt(5);
			e.getDrops().add(utils.dragonBreathFragment(amount+1));
			e.getDrops().add(new ItemStack(Material.NETHERITE_INGOT, random.nextInt(17)));
			e.getDrops().add(new ItemStack(Material.EMERALD, random.nextInt(257)));
			e.getDrops().add(new ItemStack(Material.DIAMOND, random.nextInt(513)));
			Bukkit.dispatchCommand(main.getServer().getConsoleSender(), "crates givekey " + e.getEntity().getKiller().getName() + " champion 1");
		}
	}

}
