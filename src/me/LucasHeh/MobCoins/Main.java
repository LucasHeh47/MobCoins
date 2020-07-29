package me.LucasHeh.MobCoins;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.IslandManager;

import me.LucasHeh.MobCoins.Commands.Give;
import me.LucasHeh.MobCoins.Commands.TabComplete;
import me.LucasHeh.MobCoins.Listeners.MobDrop;
import me.LucasHeh.MobCoins.Listeners.OnClick;
import me.LucasHeh.MobCoins.Listeners.Inventory.MainInvListener;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin{
	
	private static Main instance;
	private Utils utils;
	private Economy economy;
	private IridiumSkyblock iridium = IridiumSkyblock.getInstance();
	private IslandManager islandManager = IridiumSkyblock.getIslandManager();
	
	private Chances mobChances;
	
	public void onEnable() {
		instance = this;
		mobChances = new Chances();
		
		new Give(this);
		getCommand("mobcoins").setTabCompleter(new TabComplete());
		
		this.getServer().getPluginManager().registerEvents(new MainInvListener(), this);
		this.getServer().getPluginManager().registerEvents(new MobDrop(), this);
		this.getServer().getPluginManager().registerEvents(new OnClick(), this);
		
		if(!setupEconomy()) {
			this.getLogger().severe("Disabled due to no Vault");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		
	}
	
	public void onDisable() {
		
	}
	
	private boolean setupEconomy() {
		if(Bukkit.getPluginManager().getPlugin("Vault") == null)
			return false;
		
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if(rsp == null)
			return false;
		
		economy = rsp.getProvider();
		return economy != null;
	}
	
	public static Main getInstance() {
		return instance;
	}

	public Utils getUtils() {
		return utils;
	}

	public Economy getEconomy() {
		return economy;
	}

	public Chances getMobChances() {
		return mobChances;
	}

	public IridiumSkyblock getIridium() {
		return iridium;
	}

	public IslandManager getIslandManager() {
		return islandManager;
	}

}
