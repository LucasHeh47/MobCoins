package me.LucasHeh.MobCoins;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.IslandManager;

import net.milkbowl.vault.economy.Economy;

public class Utils {
	
	private Main main = Main.getInstance();
	private Economy economy = main.getEconomy();
	private IridiumSkyblock iridium = main.getIridium();
	private IslandManager islandManager = main.getIslandManager();
	private List<String> emptyLore = new ArrayList<String>();
	
	private DecimalFormat decimalFortmat = new DecimalFormat("0.0");
	
	private HashMap<String, Integer> mobCoinMap;
	
	private int cashPerCoin = 5000, expPerCoin = 750, crystalsPerCoin = 2;
	
	private String prefix = "&b&lPrimalMC » ";
	
	public Utils() {
		mobCoinMap = new HashMap<String, Integer>();
	}

	public boolean isSword(ItemStack is){
		return is.getType().name().contains("SWORD");
	}
	
	public Player getPlayerByUUID(String uuid) {
		return Bukkit.getPlayer(uuid);
	}
	
	public String getPlayersUUID(Player p) {
		return p.getUniqueId().toString();
	}

	public Economy getEconomy() {
		return economy;
	}
	
	public ItemStack mobCoinItem() {
		ItemStack item = new ItemStack(Material.SUNFLOWER);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', 
				"&e&l» &6&lMob Coin &e&l«"));
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7Trade in &6Mob Coins"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7for &aCash&7, &eExperience"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7and &bIsland Crystals"));
		meta.setLore(listTranslate(lore));
		item.setItemMeta(meta);
		return item;
	}

	public HashMap<String, Integer> getMobCoinMap() {
		return mobCoinMap;
	}
	
	public void itemToInventory(Material mat, String displayName, List<String> lore, Inventory inv, int slot) {
		ItemStack item = new ItemStack(mat);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		if(lore != null)
			meta.setLore(listTranslate(lore));
		item.setItemMeta(meta);
		inv.setItem(slot, item);
	}
	
	public void itemToInventoryAmt(Material mat, String displayName, int amt, List<String> lore, Inventory inv, int slot) {
		ItemStack item = new ItemStack(mat);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		if(lore != null)
			meta.setLore(listTranslate(lore));
		item.setItemMeta(meta);
		item.setAmount(amt);
		inv.setItem(slot, item);
	}
	
	public ItemStack mobCoinBoosterSword(double multiplier) {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lMob Coin Sword"));
		List<String> lore = new ArrayList<String>();
		lore.add("&7Raises the chances");
		lore.add("&7of getting a mobcoin");
		lore.add("&7when killing a mob");
		lore.add("&7&l" + multiplier + "x");
		meta.setLore(listTranslate(lore));
		meta.setUnbreakable(true);
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack mobCoinBoosterSword(double multiplier, Map<Enchantment, Integer> enchantments) {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lMob Coin Sword"));
		List<String> lore = new ArrayList<String>();
		lore.add("&7Raises the chances");
		lore.add("&7of getting a mobcoin");
		lore.add("&7when killing a mob");
		lore.add("&7&l" + multiplier + "x");
		meta.setLore(listTranslate(lore));
		if(enchantments != null)
			for(Map.Entry<Enchantment, Integer> enchant : enchantments.entrySet())
				meta.addEnchant(enchant.getKey(), enchant.getValue(), true);
		meta.setUnbreakable(true);
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack superMobCoinBoosterSword(double multiplier) {
		ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lSuper Mob Coin Sword"));
		List<String> lore = new ArrayList<String>();
		lore.add("&7Raises the chances");
		lore.add("&7of getting a mobcoin");
		lore.add("&7when killing a mob");
		lore.add("&7&l" + multiplier + "x");
		meta.setLore(listTranslate(lore));
		meta.setUnbreakable(true);
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack superMobCoinBoosterSword(double multiplier, Map<Enchantment, Integer> enchantments) {
		ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lSuper Mob Coin Sword"));
		List<String> lore = new ArrayList<String>();
		lore.add("&7Raises the chances");
		lore.add("&7of getting a mobcoin");
		lore.add("&7when killing a mob");
		lore.add("&7&l" + multiplier + "x");
		meta.setLore(listTranslate(lore));
		if(enchantments != null)
			for(Map.Entry<Enchantment, Integer> enchant : enchantments.entrySet())
				meta.addEnchant(enchant.getKey(), enchant.getValue(), true);
		meta.setUnbreakable(true);
		item.setItemMeta(meta);
		return item;
	}
	
	public List<String> listTranslate(List<String> list){
		List<String> converted = new ArrayList<String>();
		for(String str : list) {
			converted.add(ChatColor.translateAlternateColorCodes('&', str));
		}
		return converted;
	}

	public IridiumSkyblock getIridium() {
		return iridium;
	}

	public IslandManager getIslandManager() {
		return islandManager;
	}

	public List<String> getEmptyLore() {
		return emptyLore;
	}
	
	public ItemStack dragonBreathFragment(int amount) {
		ItemStack item = new ItemStack(Material.POPPED_CHORUS_FRUIT);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lDragon Breath Fragment"));
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setLore(listTranslate(new ArrayList<String>(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7Use this to craft &4&lDragon Breath")))));
		item.setItemMeta(meta);
		item.setAmount(amount);
		return item;
	}
	
	public ItemStack dragonBreathEssence() {
		ItemStack item = new ItemStack(Material.DRAGON_BREATH);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&lDragon Breath Essence"));
		meta.setLore(listTranslate(new ArrayList<String>(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7Use this to craft &4&lDragon Breath")))));
		item.setItemMeta(meta);
		return item;
	}
	
	public double getMultiplierFromMobCoinSword(ItemStack item) {
		List<String> list = item.getItemMeta().getLore();
		return Double.parseDouble(ChatColor.stripColor(list.get(list.size()-1).replace("x", " ").replace(" ", "")));
	}
	
	public void saveToFile() {
		FileConfiguration dataConfig = main.getDataConfig();
		
		for(Map.Entry<String, Integer> coins : mobCoinMap.entrySet()) 
			dataConfig.set("data." + coins.getKey(), coins.getValue());
		
		try {
			dataConfig.save(main.getDataFile());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public ItemStack zombieBossEgg() {
		ItemStack item = new ItemStack(Material.ZOMBIE_SPAWN_EGG);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2&lZombie Boss"));
		List<String> lore = new ArrayList<String>();
		lore.add("&7Armor: Protection 500 Diamond Armor");
		lore.add("&7Weapon: Sharpness 100 Diamond Sword");
		lore.add("&7Health: 200 HP");
		lore.add(" ");
		lore.add("&7Spawn bosses in the Warzone!");
		meta.setLore(listTranslate(lore));
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack skeletonBossEgg() {
		ItemStack item = new ItemStack(Material.SKELETON_SPAWN_EGG);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lSkeleton Boss"));
		List<String> lore = new ArrayList<String>();
		lore.add("&7Armor: Protection 300 Diamond Armor");
		lore.add("&7Weapon: Power 75, Flame 1 Bow");
		lore.add("&7Health: 200 HP");
		lore.add(" ");
		lore.add("&7Spawn bosses in the Warzone!");
		meta.setLore(listTranslate(lore));
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack witherSkeletonBossEgg() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SPAWN_EGG);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cWither Skeleton Boss"));
		List<String> lore = new ArrayList<String>();
		lore.add("&7Armor: Protection 350 Netherite Armor");
		lore.add("&7Weapon: Sharpness 100 Netherite Sword");
		lore.add("&7Health: 250 HP");
		lore.add(" ");
		lore.add("&7Spawn bosses in the Warzone!");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public void loadFromFile() {
		FileConfiguration dataConfig = main.getDataConfig();
		
		dataConfig.getConfigurationSection("data.").getKeys(false).forEach(key -> {
			int amt = dataConfig.getInt("data." + key);
			mobCoinMap.put(key, amt);
		});
		
	}

	public int getCashPerCoin() {
		return cashPerCoin;
	}

	public void setCashPerCoin(int cashPerCoin) {
		this.cashPerCoin = cashPerCoin;
	}

	public int getExpPerCoin() {
		return expPerCoin;
	}

	public void setExpPerCoin(int expPerCoin) {
		this.expPerCoin = expPerCoin;
	}

	public int getCrystalsPerCoin() {
		return crystalsPerCoin;
	}

	public void setCrystalsPerCoin(int crystalsPerCoin) {
		this.crystalsPerCoin = crystalsPerCoin;
	}

	public String getPrefix() {
		return prefix;
	}

	public DecimalFormat getDecimalFortmat() {
		return decimalFortmat;
	}

}
