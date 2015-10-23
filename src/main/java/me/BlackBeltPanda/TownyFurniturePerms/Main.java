package main.java.me.BlackBeltPanda.TownyFurniturePerms;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.palmergames.bukkit.towny.object.TownyPermission;
import com.palmergames.bukkit.towny.utils.PlayerCacheUtil;

import de.Ste3et_C0st.FurnitureLib.Events.FurnitureBreakEvent;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onFurnitureBreak(FurnitureBreakEvent event){
		if (PlayerCacheUtil.getCachePermission(event.getPlayer(), event.getLocation(), 1, (byte)0, TownyPermission.ActionType.DESTROY)){
			event.getID().remove(event.getPlayer());
		}
		else event.setCancelled(true);
	}
}
