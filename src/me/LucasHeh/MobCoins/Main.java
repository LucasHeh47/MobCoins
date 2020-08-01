package me.LucasHeh.MobCoins;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.IslandManager;

import me.LucasHeh.MobCoins.Commands.Commands;
import me.LucasHeh.MobCoins.Commands.TabComplete;
import me.LucasHeh.MobCoins.Listeners.BlockSpawns;
import me.LucasHeh.MobCoins.Listeners.MobDrop;
import me.LucasHeh.MobCoins.Listeners.OnClick;
import me.LucasHeh.MobCoins.Listeners.OnJoin;
import me.LucasHeh.MobCoins.Listeners.Inventory.MainInvListener;
import me.LucasHeh.MobCoins.Listeners.Inventory.MobChancesInvListener;
import me.LucasHeh.MobCoins.Listeners.Inventory.TradeForCashInvListener;
import me.LucasHeh.MobCoins.Listeners.Inventory.TradeForExpInvListener;
import me.LucasHeh.MobCoins.Listeners.Inventory.TradeForIslandCrystalInvListener;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin{
	
	private static Main instance;
	private Utils utils;
	private Economy economy;
	private IridiumSkyblock iridium = IridiumSkyblock.getInstance();
	private IslandManager islandManager = IridiumSkyblock.getIslandManager();
	
	private File dataFile = new File(getDataFolder(), "data.yml");
	private FileConfiguration dataConfig = YamlConfiguration.loadConfiguration(dataFile);
	
	private Chances mobChances;
	
	public void onEnable() {
		instance = this;
		mobChances = new Chances();
		utils = new Utils();
		
		new Commands(this);
		getCommand("mobcoins").setTabCompleter(new TabComplete());
		
		this.getServer().getPluginManager().registerEvents(new MainInvListener(), this);
		this.getServer().getPluginManager().registerEvents(new MobDrop(), this);
		this.getServer().getPluginManager().registerEvents(new OnClick(), this);
		this.getServer().getPluginManager().registerEvents(new OnJoin(), this);
		this.getServer().getPluginManager().registerEvents(new TradeForIslandCrystalInvListener(), this);
		this.getServer().getPluginManager().registerEvents(new TradeForCashInvListener(), this);
		this.getServer().getPluginManager().registerEvents(new TradeForExpInvListener(), this);
		this.getServer().getPluginManager().registerEvents(new MobChancesInvListener(), this);
		
		//OFF THE PLUGIN IDEA
		//BLOCKS CERTAIN MOBS FROM SPAWNING
		this.getServer().getPluginManager().registerEvents(new BlockSpawns(), this);
		
		if(!dataFile.exists())
			saveResource("data.yml", false);
		if(dataConfig.contains("data"))
			utils.loadFromFile();
		
		if(!setupEconomy()) {
			this.getLogger().severe("Disabled due to no Vault");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		
		if(!this.getServer().getPluginManager().isPluginEnabled("IridiumSkyblock")) {
			System.out.println("MOBCOINS >> IRIDIUMSKYBLOCK NOT FOUND");
		}
		
	}
	
	public void onDisable() {
		if(!utils.getMobCoinMap().isEmpty())
			utils.saveToFile();
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

	public FileConfiguration getDataConfig() {
		return dataConfig;
	}

	public File getDataFile() {
		return dataFile;
	}

}
