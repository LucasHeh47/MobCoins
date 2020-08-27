package me.LucasHeh.MobCoins.Listeners.Inventory.artisan;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

import me.LucasHeh.MobCoins.Main;
import me.LucasHeh.MobCoins.Utils;
import me.LucasHeh.MobCoins.gui.artisan.DragonBreathEssence;

public class MainMenuListener implements Listener{
	
	private Main main = Main.getInstance();
	private Utils utils = main.getUtils();
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		InventoryView inv = p.getOpenInventory();
		
		if(!inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&9&lArtisan")))
			return;
		
		e.setCancelled(true);
		
		if(e.getCurrentItem().getType() == Material.DRAGON_BREATH && e.getCurrentItem().getItemMeta()
				.getDisplayName().equals(utils.dragonBreathEssence().getItemMeta().getDisplayName())) {
			p.closeInventory();
			new DragonBreathEssence(p);
		}
		if(e.getCurrentItem().getType() == Material.BLAZE_ROD && e.getCurrentItem().getItemMeta()
				.getDisplayName().equals(main.getItemJoin().getItemStack(p, "dragonbreath").getItemMeta().getDisplayName())) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', utils.getPrefix() + "&cRecipe coming soon"));
		}
	}

}
