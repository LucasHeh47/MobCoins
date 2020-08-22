package me.LucasHeh.MobCoins.Enchants;

import java.util.Random;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;
import su.nightexpress.goldenenchants.manager.enchants.api.CombatEnchant;

public class Profit extends Enchantment implements CombatEnchant{
	
	private int succeedChance = 35;
	private int min=30, max=300;
	
	private double multiplier = 1.5;
	
	Random random = new Random();
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();

	public Profit() {
		super(new NamespacedKey(Main.getInstance(), "profit"));
	}

	@Override
	public void use(@NotNull ItemStack item, @NotNull LivingEntity Entity, @NotNull LivingEntity Entity2,
			@NotNull EntityDamageByEntityEvent event, int dmg) {
		int resultSucceed = random.nextInt(101);
		if(resultSucceed <= succeedChance) {
			int resultMoney = random.nextInt(max-min)+min;
			
		}
	}

	@Override
	public boolean canEnchantItem(ItemStack item) {
		return utils.isSword(item);
	}

	@Override
	public boolean conflictsWith(Enchantment arg0) {
		return false;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return EnchantmentTarget.WEAPON;
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public int getStartLevel() {
		return 1;
	}

	@Override
	public boolean isCursed() {
		return false;
	}

	@Override
	public boolean isTreasure() {
		return false;
	}

}
