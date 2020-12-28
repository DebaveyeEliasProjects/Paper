package me.gezelligheid.eventsplugin.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SheepHitEvents implements Listener {

    @EventHandler
    public void onSheepDamage(EntityDamageByEntityEvent event){

        if(event.getDamager() instanceof Player && event.getEntity() instanceof Sheep){

            ItemStack itemStack = new ItemStack(Material.DIAMOND,1);
            ItemMeta meta = itemStack.getItemMeta();
            meta.setDisplayName(ChatColor.GOLD + "Diamond");
            itemStack.setItemMeta(meta);


            ((Player) event.getDamager()).getInventory().addItem(itemStack);
            event.getDamager().sendMessage("You hit a sheep");

        }

    }

    @EventHandler
    public void onPing(ServerListPingEvent event){

        String motd = ChatColor.translateAlternateColorCodes('&',"&cWelcome to testserver\n&e" + event.getMaxPlayers() + " players can join");

        event.setMotd(motd);

    }

}
