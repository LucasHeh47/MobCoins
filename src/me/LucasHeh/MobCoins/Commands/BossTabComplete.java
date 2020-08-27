package me.LucasHeh.MobCoins.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class BossTabComplete implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		
		List<String> completes = new ArrayList<String>();
		if(args.length == 1) {
			completes.add("give");
			return completes;
		}
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("give")) {
				for(Player p : Bukkit.getServer().getOnlinePlayers()) {
					completes.add(p.getName());
				}
			}
			return completes;
		}
		if(args.length == 3) {
			if(args[0].equalsIgnoreCase("give")) {
				completes.add("ZombieBoss");
				completes.add("SkeletonBoss");
			}
			return completes;
		}
		
		return null;
	}

}
