package me.blok601.tb;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	FileConfiguration config = getConfig();
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new Timebomb(this), this);
		getServer().getPluginManager().registerEvents(new Eat(), this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("timebomb")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.hasPermission("oblivion.timebomb")){
					if(args.length == 0){
						p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GREEN + "Timebomb Commands:");
						p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GRAY + "/timebomb on");
						p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GRAY + "/timebomb off");
						p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GRAY + "/timebomb heads off/raw/ghead");
						return true;
					}else if(args.length == 1){
						if(args[0].equalsIgnoreCase("off")){
							config.set("timebomb", false);
							saveConfig();
							p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GREEN + "Timebomb turned off!");
						}else if(args[0].equalsIgnoreCase("on")){
							config.set("timebomb", true);
							saveConfig();
							p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.RED + "Timebomb turned on!");
						}else{
							p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GREEN + "Timebomb Commands:");
							p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GRAY + "/timebomb on");
							p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GRAY + "/timebomb off");
							p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GRAY + "/timebomb heads off/raw/ghead");
							return false;
						}
					}else if(args.length == 2){
						if(args[0].equalsIgnoreCase("heads")){
							if(args[1].equalsIgnoreCase("off")){
								config.set("heads", "off");
								saveConfig();
								p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GREEN + "Timebomb heads turned off!");
							}else if(args[1].equalsIgnoreCase("raw")){
								config.set("heads", "raw");
								saveConfig();
								p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.RED + "Timebomb heads turned to raw!");
							}else if(args[1].equalsIgnoreCase("ghead")){
								config.set("heads", "ghead");
								saveConfig();
								p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.RED + "Timebomb heads set to Golden Heads!");
							}else{
								p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GREEN + "Timebomb Commands:");
								p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GRAY + "/timebomb on");
								p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GRAY + "/timebomb off");
								p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GRAY + "/timebomb heads off/raw/ghead");
							}
						}else{
							p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GREEN + "Timebomb Commands:");
							p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GRAY + "/timebomb on");
							p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GRAY + "/timebomb off");
							p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "UHC" + ChatColor.DARK_GRAY + " » " + ChatColor.RESET + ChatColor.RESET + ChatColor.GRAY + "/timebomb heads off/raw/ghead");
							return false;
						}
					}else{
						return false;
					}
				}
			}else{
				return false;
			}
		}
		return false;
	}

}
