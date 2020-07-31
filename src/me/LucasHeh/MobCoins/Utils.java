package me.LucasHeh.MobCoins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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

}
