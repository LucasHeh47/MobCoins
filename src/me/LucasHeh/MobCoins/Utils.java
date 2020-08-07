package me.LucasHeh.MobCoins;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
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
	
	private HashMap<String, Integer> mobCoinMap;
	
	private int cashPerCoin = 5000, expPerCoin = 1500, crystalsPerCoin = 5;
	
	private String prefix = "&b&lPrimalMC » ";
	
	public Utils() {
		mobCoinMap = new HashMap<String, Integer>();
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
	
	public ItemStack mobCoinBoosterSword() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lMob Coin Sword"));
		List<String> lore = new ArrayList<String>();
		lore.add("&7Raises the chances");
		lore.add("&7of getting a mobcoin");
		lore.add("&7when killing a mob");
		lore.add("&7&l2.0x");
		meta.setLore(listTranslate(lore));
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack superMobCoinBoosterSword() {
		ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lSuper Mob Coin Sword"));
		List<String> lore = new ArrayList<String>();
		lore.add("&7Raises the chances");
		lore.add("&7of getting a mobcoin");
		lore.add("&7when killing a mob");
		lore.add("&7&l3.0x");
		meta.setLore(listTranslate(lore));
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
	
	public double getMultiplierFromMobCoinSword(ItemStack item) {
		List<String> list = item.getItemMeta().getLore();
		return Double.parseDouble(ChatColor.stripColor(list.get(3).replace("x", " ").replace(" ", "")));
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

}
