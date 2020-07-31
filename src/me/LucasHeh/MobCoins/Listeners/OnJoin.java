package me.LucasHeh.MobCoins.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;

public class OnJoin implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(!utils.getMobCoinMap().containsKey(utils.getPlayersUUID(p)))
			utils.getMobCoinMap().put(utils.getPlayersUUID(p), 0);
	}

}
