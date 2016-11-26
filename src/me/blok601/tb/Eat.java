package me.blok601.tb;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Eat implements Listener{
	
	@EventHandler
	public void onEat(PlayerItemConsumeEvent e){
		ItemStack i = e.getItem();
		Player p = e.getPlayer();
		
		if(i.hasItemMeta() && i != null){
			if(i.getItemMeta().getDisplayName() != null){
				if(i.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Golden Head")){
					p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0));
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
				}
			}
		}
	}
	

}
