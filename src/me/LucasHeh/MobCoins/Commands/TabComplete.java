package me.LucasHeh.MobCoins.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class TabComplete implements TabCompleter{

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		List<String> completes = new ArrayList<String>();
		if(args.length == 0) {
			completes.add("give");
			completes.add("gui");
			return completes;
		}
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("give")) {
				Bukkit.getOnlinePlayers().forEach(player -> {
					completes.add(player.getName());
				});
				return completes;
			}
		}
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("give")) {
				completes.add("1");
				completes.add("8");
				completes.add("16");
				completes.add("32");
				completes.add("64");
				completes.add("128");
				completes.add("256");
				completes.add("512");
				return completes;
			}
		}
		
		return null;
	}

}
